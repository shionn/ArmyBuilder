package armybuilder.model.unit.check;

import java.util.function.BiConsumer;

import armybuilder.model.army.Army;
import armybuilder.model.unit.KeyWord;
import armybuilder.model.unit.Unit;

public class UnitCheckers {

	public static BiConsumer<Army, Unit> mustBeTakeWith(KeyWord keyWord) {
		return (a, u) -> {
			if (a.units(keyWord).size()< 1) {
				a.addError(
						u.getDisplayName() + " Doit être pris avec " + keyWord.getDisplayName());
			}
		};
	}

}
