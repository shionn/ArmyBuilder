package armybuilder.model.army.check;

import java.util.function.Consumer;

import armybuilder.model.army.Army;
import armybuilder.model.unit.KeyWord;
import armybuilder.model.unit.option.UnitOption;

public enum GenericCheck implements ICheck {
	General(Checkers.oneUnitWithOption(UnitOption.General)), OneOfEachUnique(a -> {
		a.units(KeyWord.Unique).stream().map(u -> u.getModel()).map(m -> a.units(m))
				.filter(units -> units.size() > 1).map(units -> units.get(0).getModel())
				.distinct()
				.forEach(m -> a.addError(
						"Vous ne pouvez mettre qu'une seule fois : " + m.getDisplayName()));
	});

	private Consumer<Army> check;

	private GenericCheck(Consumer<Army> check) {
		this.check = check;
	}

	@Override
	public void verify(Army army) {
		check.accept(army);
	}

}
