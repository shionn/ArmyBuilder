package armybuilder.serialisation;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.function.Supplier;

import org.commonmark.node.Node;
import org.commonmark.parser.Parser;
import org.commonmark.renderer.html.HtmlRenderer;

import armybuilder.model.rule.IRule;

public class DescriptionReader {

	public static Supplier<String> rules(IRule<?>... rules) {
		return () -> Arrays.stream(rules).map(r -> {
			try {
				return "<div class=\"rule\"><h3>" + r.getDisplayName() + " : </h3>" + r.getDescription() + "</div>";
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		}).reduce((a, b) -> (a + b)).get();
	}

	public String read(String folder, String name) {
		try {
			try {
				try {
					return tryToRead(folder, name + ".short");
				} catch (IOException | RuntimeException e) {
					return "- FULL - " + tryToRead(folder, name);
				}
			} catch (IOException | RuntimeException e) {
				return "- OLD - " + tryToRead(folder + "old/", name);
			}
		} catch (IOException | RuntimeException e) {
			throw new IllegalStateException(folder + name + ".md");
		}
	}

	private String tryToRead(String folder, String name) throws IOException {
		try (InputStream is = Thread.currentThread()
				.getContextClassLoader()
				.getResourceAsStream(folder + name + ".md");
				java.io.InputStreamReader isr = new java.io.InputStreamReader(is, Charset.forName("UTF-8"))) {
			Node node = Parser.builder().build().parseReader(isr);
			return HtmlRenderer.builder().build().render(node);
		}
	}

}
