package armybuilder.model.check;

import java.util.function.Consumer;

import armybuilder.model.Army;
import armybuilder.model.unit.option.IUnitOptionValue;
import armybuilder.model.unit.option.UnitOption;

public class Checkers {

	public static Consumer<Army> unitWithOption(UnitOption opt) {
		return (Army a) -> {
			if (a.units(opt).isEmpty()) {
				a.addError("Votre armée doit avoir : " + opt.getDisplayName());
			}
		};
	}

	public static Consumer<Army> unitWithOption(UnitOption opt,
			IUnitOptionValue<?> value) {
		return (Army a) -> {
			if (a.units(opt, value).isEmpty()) {
				a.addError("Votre armée doit avoir : " + opt.getDisplayName() + " "
						+ value.getDisplayName());
			}
		};
	}

}
