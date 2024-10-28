package armybuilder.db.dbo.unit;

import armybuilder.db.dbo.rule.Rule;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UnitModelRule {

	private int id;
	private Rule rule;
	private UnitModel unit;

}
