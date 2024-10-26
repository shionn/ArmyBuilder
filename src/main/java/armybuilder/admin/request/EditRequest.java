package armybuilder.admin.request;

import java.util.Arrays;
import java.util.List;

import armybuilder.db.dbo.Keyword;
import lombok.Data;

@Data
public class EditRequest {

	private String announce;
	private String description;
	private String effect;
	private String keywords;
	private String name;
	private String timing;
	private String mvt, life, control, save;
	private String type;
	private int id;
	private String atk, hit, str, perf, deg;
	private EditRequest[] weapons;

	public List<Keyword> keywords() {
		return Arrays.stream(keywords.split(",")).map(Keyword::valueOf).toList();
	}
}
