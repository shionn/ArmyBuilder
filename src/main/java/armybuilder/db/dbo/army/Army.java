package armybuilder.db.dbo.army;

import java.util.ArrayList;
import java.util.List;

import armybuilder.controller.Comparators;
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

	public int getCost() {
		return units.stream().map(u -> u.getCost()).reduce(0, (a, b) -> a + b);
	}

	public Rule get(ArmyOptionType type) {
		return rules.stream().filter(o -> o.is(type)).findAny().orElse(null);
	}
	
	public List<Unit> getSortedUnits() {
		return units.stream().sorted(Comparators.unit).toList();
	}

	public void addRule(List<Rule> rules) {
		if (this.rules == null) {
			this.rules = new ArrayList<Rule>();
		}
		this.rules.addAll(rules);
	}

	public List<Rule> getSortedRules() {
		return this.rules.stream().sorted(Comparators.rule).toList();
	}

}
