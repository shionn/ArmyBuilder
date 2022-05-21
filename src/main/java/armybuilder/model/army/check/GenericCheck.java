package armybuilder.model.army.check;

import java.util.function.Consumer;

import armybuilder.model.army.OldArmy;
import armybuilder.model.unit.KeyWord;
import armybuilder.model.unit.option.UnitOption;

public enum GenericCheck implements ICheck {
	General(Checkers.oneUnitWithOption(UnitOption.General)), OneOfEachUnique(a -> {
		a.units(KeyWord.Unique).stream().map(u -> u.model()).map(m -> a.units(m))
				.filter(units -> units.size() > 1).map(units -> units.get(0).model())
				.distinct()
				.forEach(m -> a.addError(
						"Vous ne pouvez mettre qu'une seule fois : " + m.getDisplayName()));
	});

	private Consumer<OldArmy> check;

	private GenericCheck(Consumer<OldArmy> check) {
		this.check = check;
	}

	@Override
	public void verify(OldArmy army) {
		check.accept(army);
	}

}
