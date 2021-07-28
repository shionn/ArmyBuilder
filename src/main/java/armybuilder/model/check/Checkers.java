package armybuilder.model.check;

import java.util.function.Consumer;

import armybuilder.model.Army;
import armybuilder.model.unit.KeyWord;
import armybuilder.model.unit.RoleTactique;
import armybuilder.model.unit.Unit;
import armybuilder.model.unit.option.IUnitOptionValue;
import armybuilder.model.unit.option.UnitOption;

public class Checkers {

	public static Consumer<Army> oneUnitWithOption(UnitOption opt) {
		return (Army a) -> {
			if (a.units(opt).size() != 1) {
				a.addError("Votre armée doit avoir un : " + opt.getDisplayName());
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

	public static Consumer<Army> composition(int minPt, int maxPt, int minQty, int maxQty,
			RoleTactique role) {
		return (Army a) -> {
			if (a.getValue()>=minPt && a.getValue() <=maxPt) {
				if (a.units(role).size() < minQty) {
					a.addError("de " + minPt + " à " + maxPt
							+ "pts, votre armée doit avoir au moins " + minQty + " " + role);
				} else if (a.units(role).size() > maxQty && maxQty > -1) {
					a.addError("de " + minPt + " à " + maxPt
							+ "pts, votre armée ne peu pas avoir plus de " + maxQty + " " + role);
				}
			}
		}; 
	}

	public static Consumer<Army> armySize(int minPt, int maxPt, int maxSize) {
		return (Army a) -> {
			if (a.getValue() >= minPt && a.getValue() <= maxPt) {
				if (a.getUnits().size() > maxSize) {
					a.addError("de " + minPt + " à " + maxPt
							+ "pts, votre armée ne peu avoir au maximum " + maxSize + " unité.");
				}
			}
		};
	}

	public static Consumer<Army> generalCantBe(KeyWord keyWord) {
		return (Army a) -> {
			Unit unit = a.unit(UnitOption.General);
			if (unit != null && unit.is(keyWord)) {
				a.addError("Votre général ne peu pas être : " + keyWord);
			}
		};
	}

}
