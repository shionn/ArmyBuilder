package armybuilder.db.dao.admin;

import armybuilder.db.dbo.rule.Rule;
import armybuilder.db.dbo.unit.UnitModel;
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
