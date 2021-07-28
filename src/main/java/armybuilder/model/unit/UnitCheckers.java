package armybuilder.model.unit;

import java.util.function.BiConsumer;

import armybuilder.model.Army;

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
