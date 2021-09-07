package armybuilder.serialisation;

import java.io.IOException;
import java.io.InputStream;

import org.commonmark.node.Node;
import org.commonmark.parser.Parser;
import org.commonmark.renderer.html.HtmlRenderer;

public class DescriptionReader {

	public String read(String folder, String name) {
		try (InputStream is = Thread.currentThread().getContextClassLoader()
				.getResourceAsStream(folder + name + ".md");
				java.io.InputStreamReader isr = new java.io.InputStreamReader(is)) {
			Node node = Parser.builder().build().parseReader(isr);
			return HtmlRenderer.builder().build().render(node);
		} catch (IOException | RuntimeException e) {
			throw new IllegalStateException(folder + name + ".md");
		}
	}

}
