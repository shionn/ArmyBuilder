package armybuilder.db.dbo.army;

import java.util.List;

import armybuilder.db.dbo.option.ArmyOptionModel;
import armybuilder.db.dbo.option.ArmyOptionType;
import armybuilder.db.dbo.rule.Rule;
import armybuilder.db.dbo.unit.Unit;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Army {

	private int id;
	private String name;
	private ArmyModel model;
	private List<Unit> units;
	private List<Rule> rules;
	private List<ArmyOptionModel> options;

	public int getCost() {
		return units.stream().map(u -> u.getCost()).reduce(0, (a, b) -> a + b);
	}

	public ArmyOptionModel get(ArmyOptionType type) {
		return options.stream().filter(o -> o.getType() == type).findAny().orElse(null);
	}
	
}
