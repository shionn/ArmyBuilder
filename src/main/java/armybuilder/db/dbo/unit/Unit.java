package armybuilder.db.dbo.unit;

import java.util.List;

import armybuilder.db.dbo.rule.Rule;
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

	public int getCost() {
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
}
