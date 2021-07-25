package armybuilder.model.check;

import java.util.function.Consumer;

import armybuilder.model.Army;
import armybuilder.model.unit.option.UnitOption;

public enum GenericCheck implements ICheck {
	General(Checkers.oneUnitWithOption(UnitOption.General));

	private Consumer<Army> check;

	private GenericCheck(Consumer<Army> check) {
		this.check = check;
	}

	@Override
	public void verify(Army army) {
		check.accept(army);
	}

}
