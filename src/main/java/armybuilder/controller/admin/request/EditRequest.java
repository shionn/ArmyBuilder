package armybuilder.controller.admin.request;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

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
	private String condition;
	private String mvt, life, control, save;
	private String type;
	private int id;
	private String range, atk, hit, str, perf, deg, aptitude;
	private String cost;
	private String size;
	private String composition;
	private String script;
	private EditRequest[] weapons = {};
	private EditRequest[] rules = {};
	private EditRequest army;
	private EditRequest rule;
	private EditRequest option;

	public List<Keyword> keywords() {
		if (StringUtils.isNotBlank(keywords)) {
			return Arrays.stream(keywords.split(",")).map(Keyword::valueOf).toList();
		}
		return Collections.emptyList();
	}

}
