package armybuilder.model.unit.option;

import java.util.function.BiFunction;

import armybuilder.model.army.OldArmy;
import armybuilder.model.army.option.PackDeBataille;
import armybuilder.model.unit.KeyWord;
import armybuilder.model.unit.Unit;

public enum UnitOption {
	General("Général", UnitOptionType.bool, (a, u) -> u.getKeyWords().contains(KeyWord.Heros)),
	TraisDeCommandement(
			"Traits de Commandement",
			UnitOptionType.select,
			(a, u) -> !u.getKeyWords().contains(KeyWord.Unique)),
	TraisDeMonstre(
			"TODO",
			UnitOptionType.select,
			(a, u) -> !u.getKeyWords().contains(KeyWord.Unique)),
	Artefact(
			"Artéfacts de Pouvoir",
			UnitOptionType.select,
			(a, u) -> !u.getKeyWords().contains(KeyWord.Unique)),
	Sort("Sort", UnitOptionType.select, (a, u) -> u.getKeyWords().contains(KeyWord.Sorcier)),
	Priere("Prière", UnitOptionType.select, (a, u) -> u.getKeyWords().contains(KeyWord.Pretre)),
	PriereBonus(
			"Prière",
			UnitOptionType.select,
			(a, u) -> a.is(PackDeBataille.PourLaGloire)
					&& u.getKeyWords().contains(KeyWord.Pretre)),

	Chef("Chef", UnitOptionType.bool, (a, u) -> true),
	Banniere("Porte-Étendard", UnitOptionType.bool, (a, u) -> true),
	Musicien("Musicien", UnitOptionType.bool, (a, u) -> true),
	Armes("Armes", UnitOptionType.select, (a, u) -> true),
	Gratuit("Invoquée", UnitOptionType.bool, (a, u) -> true),
	Renforcees("Renforcées", UnitOptionType.select, (a, u) -> !u.is(UnitOption.Gratuit)),
	AptitudeDeVeteran(
			"Aptitude de Vétéran",
			UnitOptionType.select,
			(a, u) -> a.is(PackDeBataille.PourLaGloire)),
	AptitudeDeVeteran_2(
			"Aptitude de Vétéran",
			UnitOptionType.select,
			(a, u) -> a.is(PackDeBataille.PourLaGloire) && u.is(AptitudeDeVeteran)),
	AptitudeDeVeteran_3(
			"Aptitude de Vétéran",
			UnitOptionType.select,
			(a, u) -> a.is(PackDeBataille.PourLaGloire) && u.is(AptitudeDeVeteran_2)),
	Bataillon("Bataillon", UnitOptionType.selectMultiOption, (a, u) -> true),

	;

	private String displayName;
	private BiFunction<OldArmy, Unit, Boolean> available;
	private UnitOptionType type;

	private UnitOption(String displayName, UnitOptionType type,
			BiFunction<OldArmy, Unit, Boolean> available) {
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

	public boolean isAvailable(OldArmy a, Unit u) {
		return available.apply(a, u);
	}

	public boolean isAvailable(UnitOption option) {
		return this == option || option.name().indexOf(name()) == 0
				|| name().indexOf(option.name()) == 0;
	}

}
