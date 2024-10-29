package armybuilder.db.dbo.unit;

import java.util.List;

import armybuilder.db.dbo.option.UnitOptionType;
import armybuilder.db.dbo.rule.Rule;
import armybuilder.db.dbo.unit.option.UnitOptionValue;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Unit {
	private int id;
	private UnitModel model;
	private List<UnitOptionValue> options;

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

	public List<Rule> getRules() {
		return model.getRules().stream().map(m -> m.getRule()).toList();
	}

	public boolean is(UnitOptionType option) {
		return options.stream()
				.filter(o -> o.getOption() == option)
				.map(UnitOptionValue::getValue)
				.map(Boolean::parseBoolean)
				.findAny()
				.orElse(false);
	}
}
