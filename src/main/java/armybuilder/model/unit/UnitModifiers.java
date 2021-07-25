package armybuilder.model.unit;

import java.util.function.BiConsumer;

import armybuilder.model.Army;
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
