package armybuilder.modelold.deprecated.unit.modifiers;

import java.util.function.Consumer;

import armybuilder.model.unit.role.RoleTactique;
import armybuilder.modelold.deprecated.unit.KeyWord;
import armybuilder.modelold.deprecated.unit.Unit;
import armybuilder.modelold.deprecated.unit.option.UnitOption;

public class UnitModifiers {

	public static Consumer<Unit> roleIfGeneral(KeyWord keyWord, RoleTactique role) {
		return u -> {
			Unit general = u.listing().unit(UnitOption.General);
			if (general != null && general.is(keyWord)) {
				u.add(role);
			}
		};
	}

}
