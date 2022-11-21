package armybuilder.modelold.deprecated.unit.modifiers;

import java.util.function.Consumer;

import armybuilder.model.unit.keyword.KeyWord;
import armybuilder.model.unit.role.RoleTactique;
import armybuilder.modelold.deprecated.unit.Unit;
import armybuilder.modelold.deprecated.unit.option.UnitOptionCategory;

public class UnitModifiers {

	public static Consumer<Unit> roleIfGeneral(KeyWord keyWord, RoleTactique role) {
		return u -> {
			Unit general = u.listing().unit(UnitOptionCategory.General);
			if (general != null && general.is(keyWord)) {
				u.add(role);
			}
		};
	}

}
