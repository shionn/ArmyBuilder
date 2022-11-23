package armybuilder.modelold.deprecated.unit.modifiers;

import java.util.function.Consumer;

import armybuilder.model.unit.Unit;
import armybuilder.model.unit.keyword.KeyWord;
import armybuilder.model.unit.role.RoleTactique;

public class UnitModifiers {

	public static Consumer<Unit> roleIfGeneral(KeyWord keyWord, RoleTactique role) {
		return u -> {
			// TODO ajouter role si l'armee contien un general du keyword mentionné
//			Unit general = u.listing().unit(UnitOptionCategory.General);
//			if (general != null && general.is(keyWord)) {
//				u.add(role);
//			}
		};
	}

}
