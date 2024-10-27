package armybuilder.db.dbo.rule;

import java.util.List;

import armybuilder.db.dbo.Keyword;
import armybuilder.db.dbo.aspect.HaveKeywords;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Rule implements HaveKeywords {
	private int id;
	private Timing timing;
	private String condition;
	private String name;
	private String description;
	private String announce;
	private String effect;
	private List<Keyword> keywords;
}
