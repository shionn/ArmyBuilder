package armybuilder.db.dbo.unit;

import java.util.ArrayList;
import java.util.List;

import armybuilder.controller.Comparators;
import armybuilder.db.dbo.Keyword;
import armybuilder.db.dbo.army.Army;
import armybuilder.db.dbo.option.UnitOptionType;
import armybuilder.db.dbo.option.UnitOptionValue;
import armybuilder.db.dbo.option.UnitOptionnable;
import armybuilder.db.dbo.rule.Rule;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Unit implements UnitOptionnable {
	private int id;
	private Army army;
	private UnitModel model;
	private List<UnitOptionValue> options;
	private List<Rule> rules;

	public int getCost() {
		if (is(UnitOptionType.Reinforced)) {
			return model.getCost() * 2;
		}
		return model.getCost();
	}

	public List<UnitModelWeapon> weapons(WeaponType type) {
		if (model.getWeapons() == null)
			return null;
		return model.getWeapons().stream().filter(w -> w.is(type)).toList();
	}

	public List<Rule> getAllRules() {
		List<Rule> all = new ArrayList<Rule>();
		all.addAll(rules);
		all.addAll(model.getRules().stream().map(m -> m.getRule()).toList());
		all.sort(Comparators.rule);
		return all;
	}

	public boolean is(UnitOptionType option) {
		return options.stream()
				.filter(o -> o.getOption() == option)
				.map(UnitOptionValue::getValue)
				.map(Boolean::parseBoolean)
				.findAny()
				.orElse(false);
	}

	public UnitOptionnable get(UnitOptionType option) {
		if (option == UnitOptionType.Regiment) {
			return options.stream()
					.filter(o -> o.getOption() == UnitOptionType.Regiment)
					.map(o -> o.getValue())
					.map(Integer::parseInt)
					.map(id -> army.getUnits().stream().filter(u -> u.getId() == id).findAny().orElse(null))
					.findFirst()
					.orElse(null);
		}
		return rules.stream().filter(r -> r.is(option)).findAny().orElse(null);
	}

	public boolean is(Keyword keyword) {
		return getModel().is(keyword);
	}

	public String getName() {
		return model.getName();
	}
}
