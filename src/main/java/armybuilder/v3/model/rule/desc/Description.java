package armybuilder.v3.model.rule.desc;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.commonmark.node.Node;
import org.commonmark.parser.Parser;
import org.commonmark.renderer.html.HtmlRenderer;

import armybuilder.v3.model.dok.DokRule;
import armybuilder.v3.model.dok.DokShortDescription;
import armybuilder.v3.model.rule.IRule;
import armybuilder.v3.model.rule.PackDeBatailleRule;

public class Description {

	private Map<Class<?>, Class<?>> ENUM_MAPPING = buildMappingEnums();

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
			Class<?> enums = ENUM_MAPPING.get(rule.getClass());
			String content = Arrays.stream(enums.getEnumConstants())
					.map(e -> (Enum<?>) e)
					.filter(e -> e.name() == rule.name())
					.map(e -> e.toString())
					.findFirst()
					.orElseThrow();
			Node node = Parser.builder().build().parse(content);
			return HtmlRenderer.builder().build().render(node);
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

	private static Map<Class<?>, Class<?>> buildMappingEnums() {
		Map<Class<?>, Class<?>> shortDescs = new HashMap<>();
		shortDescs.put(PackDeBatailleRule.class, PackDeBatailleRuleShortDescription.class);
		shortDescs.put(DokRule.class, DokShortDescription.class);
		return shortDescs;
	}

}
