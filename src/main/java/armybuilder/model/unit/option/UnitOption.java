package armybuilder.model.unit.option;

import java.util.function.Function;

import armybuilder.model.army.OldArmy;
import armybuilder.model.unit.KeyWord;
import armybuilder.model.unit.Unit;

public enum UnitOption {
	General("Général", UnitOptionType.bool, (u) -> u.getKeyWords().contains(KeyWord.Heros)),
	TraisDeCommandement(
			"Traits de Commandement",
			UnitOptionType.select,
			(u) -> !u.is(KeyWord.Unique)),
	TraisDeMonstre(
			"TODO",
			UnitOptionType.select,
			(u) -> !u.is(KeyWord.Unique)),
	Artefact(
			"Artéfacts de Pouvoir",
			UnitOptionType.select,
			(u) -> !u.is(KeyWord.Unique)),
	Sort("Sort", UnitOptionType.select, (u) -> u.is(KeyWord.Sorcier)),
	Priere("Prière", UnitOptionType.select, (u) -> u.is(KeyWord.Pretre)),

	Chef("Chef", UnitOptionType.bool, (u) -> true),
	Banniere("Porte-Étendard", UnitOptionType.bool, (u) -> true),
	Musicien("Musicien", UnitOptionType.bool, (u) -> true),
	Armes("Armes", UnitOptionType.select, (u) -> true),
	Gratuit("Invoquée", UnitOptionType.bool, (u) -> true),
	Renforcees("Renforcées", UnitOptionType.select, (u) -> !u.is(UnitOption.Gratuit)),
	Bataillon("Bataillon", UnitOptionType.select, (u) -> true),

	;

	private String displayName;
	private Function<Unit, Boolean> available;
	private UnitOptionType type;

	private UnitOption(String displayName, UnitOptionType type,
			Function<Unit, Boolean> available) {
		this.displayName = displayName;
		this.type = type;
		this.available = available;
	}

	public boolean availableFor(Unit unit) {
		return available.apply(unit);
	}

	public String getDisplayName() {
		return displayName;
	}

	public UnitOptionType getType() {
		return type;
	}

	@Deprecated
	public boolean isAvailable(OldArmy a, Unit u) {
		return available.apply(u);
	}

}
