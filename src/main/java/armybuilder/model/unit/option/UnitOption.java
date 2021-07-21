package armybuilder.model.unit.option;

import java.util.function.Function;

import armybuilder.model.unit.KeyWord;
import armybuilder.model.unit.Unit;

public enum UnitOption {
	General("Général", UnitOptionType.bool, u -> u.getKeyWords().contains(KeyWord.Heros)),
	TraisDeCommandement(
			"Traits de Commandement",
			UnitOptionType.select,
			u -> u.getKeyWords().contains(KeyWord.Heros)
					&& !u.getKeyWords().contains(KeyWord.Unique)),
	TraisDeMonstre(
			"TODO",
			UnitOptionType.select,
			u -> u.getKeyWords().contains(KeyWord.Monstre)
					&& !u.getKeyWords().contains(KeyWord.Unique)),
	Artefact(
			"Artéfacts de Pouvoir",
			UnitOptionType.select,
			u -> u.getKeyWords().contains(KeyWord.Heros)
					&& !u.getKeyWords().contains(KeyWord.Unique)),
	Sort("Sort", UnitOptionType.select, u -> u.getKeyWords().contains(KeyWord.Sorcier)),
	Priere("Prière", UnitOptionType.select, u -> u.getKeyWords().contains(KeyWord.Pretre));

	private String displayName;
	private Function<Unit, Boolean> available;
	private UnitOptionType type;

	private UnitOption(String displayName, UnitOptionType type, Function<Unit, Boolean> available) {
		this.displayName = displayName;
		this.type = type;
		this.available = available;
	}

	public String getDisplayName() {
		return displayName;
	}

	public UnitOptionType getType() {
		return type;
	}

	public boolean isAvailable(Unit u) {
		return available.apply(u);
	}

}
