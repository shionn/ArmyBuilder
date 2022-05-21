package armybuilder.model.unit.modifiers;

import java.util.function.Consumer;

import armybuilder.model.unit.KeyWord;
import armybuilder.model.unit.RoleTactique;
import armybuilder.model.unit.Unit;
import armybuilder.model.unit.option.UnitOption;

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
