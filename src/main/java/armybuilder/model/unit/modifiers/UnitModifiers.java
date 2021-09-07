package armybuilder.model.unit.modifiers;

import java.util.function.BiConsumer;

import armybuilder.model.army.Army;
import armybuilder.model.unit.KeyWord;
import armybuilder.model.unit.RoleTactique;
import armybuilder.model.unit.Unit;
import armybuilder.model.unit.option.UnitOption;

public class UnitModifiers {

	public static BiConsumer<Army, Unit> roleIfGeneral(KeyWord keyWord, RoleTactique role) {
		return (a, u) -> {
			Unit general = a.unit(UnitOption.General);
			if (general != null && general.is(keyWord)) {
				u.add(role);
			}
		};
	}

}
