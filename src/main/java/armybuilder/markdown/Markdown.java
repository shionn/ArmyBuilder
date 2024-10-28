package armybuilder.markdown;

import org.commonmark.node.Node;
import org.commonmark.parser.Parser;
import org.commonmark.renderer.html.HtmlRenderer;
import org.springframework.stereotype.Component;

@Component
public class Markdown {

	public String format(String data) {
		Node node = Parser.builder().build().parse(data);
		return HtmlRenderer.builder().build().render(node);
	}
}
