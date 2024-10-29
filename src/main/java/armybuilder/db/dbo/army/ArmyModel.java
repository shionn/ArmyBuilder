package armybuilder.db.dbo.army;

import java.util.List;

import armybuilder.db.dbo.option.ArmyOptionModel;
import armybuilder.db.dbo.option.ArmyOptionType;
import armybuilder.db.dbo.option.UnitOptionType;
import armybuilder.db.dbo.rule.Rule;
import armybuilder.db.dbo.unit.UnitModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ArmyModel {

	private int id;
	private String name;
	private List<UnitModel> units;
	private List<ArmyOptionModel> options;
	private List<Rule> unitOptionRules;

	public List<ArmyOptionModel> options(ArmyOptionType type) {
		return options.stream().filter(o -> o.getType() == type).toList();
	}


	public List<Rule> options(UnitOptionType type) {
		return unitOptionRules.stream().filter(r -> r.getOptionUnitType() == type).toList();
	}

}
