package armybuilder.serialisation;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;

import org.commonmark.node.Node;
import org.commonmark.parser.Parser;
import org.commonmark.renderer.html.HtmlRenderer;

import armybuilder.model.rule.IRule;

public class Description {

	private IRule<?> rule;
	private String folder;

	public Description(IRule<?> rule) {
		this(rule.getClass().getSimpleName().replaceAll("Rule", "") + "/", rule);
	}

	public Description(String folder, IRule<?> rule) {
		this.folder = folder;
		this.rule = rule;
	}

	public String mode(DescriptionMode mode) {
		switch (mode) {
		case ShortByCode:
			return getShortByCode();
		case ShortMd:
			return getShortMd();
		case Full:
			return getFull();
		default:
			throw new IllegalArgumentException("Unexpected value: " + mode);
		}
	}

	public String getShortByCode() {
		try {
			return ShortDescription.valueOf(rule).getValue();
		} catch (RuntimeException ex) {
			if (rule.getShortDescription() != null) {
				Node node = Parser.builder().build().parse(rule.getShortDescription());
				return HtmlRenderer.builder().build().render(node) + append("deprecated");
			}
			return getShortMd() + append("MD");
		}
	}

	private String append(String suffix) {
		return "<em class=\"print-hidden\"> -" + suffix + "-</em>";
	}

	public String getShortMd() {
		try {
			return tryToRead(folder, rule.name() + ".short");
		} catch (IOException | RuntimeException e) {
			return getFull() + append("FULL");
		}
	}

	public String getFull() {
		try {
			try {
				return tryToRead(folder, rule.name());
			} catch (IOException | RuntimeException e) {
				return tryToRead(folder + "old/", rule.name()) + append("OLD");
			}
		} catch (IOException | RuntimeException e) {
			return "- NO DESCRIPTION - " + rule.name();
		}
	}

	private String tryToRead(String folder, String name) throws IOException {
		try (InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream(folder + name + ".md");
				java.io.InputStreamReader isr = new java.io.InputStreamReader(is, Charset.forName("UTF-8"))) {
			Node node = Parser.builder().build().parseReader(isr);
			return HtmlRenderer.builder().build().render(node);
		}
	}

}
