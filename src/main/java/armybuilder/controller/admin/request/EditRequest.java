package armybuilder.controller.admin.request;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import armybuilder.db.dbo.Keyword;
import lombok.Data;

@Data
public class EditRequest {

	private int id;
	private String name;
	private String timing;
	private String condition;
	private String description, announce, useby, effect;
	private String keywords;
	private String mvt, life, control, save;
	private String type;
	private String range, atk, hit, str, perf, deg, aptitude;
	private String cost;
	private String size;
	private String composition;
	private String script;
	private boolean visible;
	private EditRequest[] weapons = {};
	private EditRequest[] rules = {};
	private EditRequest army;
	private EditRequest unit;
	private EditRequest rule;
	private EditRequest option;

	public List<Keyword> keywords() {
		if (StringUtils.isNotBlank(keywords)) {
			return Arrays.stream(keywords.split(",")).map(Keyword::valueOf).toList();
		}
		return Collections.emptyList();
	}

}
