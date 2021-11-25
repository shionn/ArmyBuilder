package armybuilder.model.army.rule;

import java.util.function.Function;

import armybuilder.model.army.Army;
import armybuilder.model.army.option.PackDeBataille;
import armybuilder.model.unit.KeyWord;

public enum ArmyRuleType {
	TraisDeBataille(null, a -> true),
	TraisUnitee(null, a -> !a.getUnits().isEmpty()),

	SubAllegiance(null, a -> false),

	Composition(null, a -> !a.getUnits().isEmpty()),
	Aptitude(null, a -> true),
	AptitudesDeCommandement("Aptitudes de Commandement", a -> true),
	TraitsDeCommandement("Traits de Commandement", a -> true),
	FureursMonstrueuses("Fureurs Monstrueuses", a -> !a.units(KeyWord.Monstre).isEmpty()),
	ActionsHeroiques("Actions Heroique", a -> true),
	AptitudeDeVeteran("Aptitude de Vétéran", a -> a.is(PackDeBataille.PourLaGloire)),
	AptitudeDeVeteran_2("Aptitude de Vétéran", a -> a.is(PackDeBataille.PourLaGloire)),
	Artefact(null, a -> true),
	Sort(null, a -> !a.units(KeyWord.Sorcier).isEmpty()),
	Priere(null, a -> !a.units(KeyWord.Pretre).isEmpty()),
	Triomphes(null, a -> true),
	EndLessSpell(null, a -> !a.units(KeyWord.Sorcier).isEmpty()),

	PhaseDeCharge(null, a -> true),
	PhaseDesHeros(null, a -> true),
	PhaseDeMouvement(null, a -> true),
	PhaseDeTir(null, a -> true),
	PhaseDeCombat(null, a -> true),
	PhaseDeDeroute(null, a -> true),

	;
	private String displayName;
	private Function<Army, Boolean> usable;

	private ArmyRuleType(String displayName, Function<Army, Boolean> usable) {
		this.displayName = displayName;
		this.usable = usable;
	}

	public String getDisplayName() {
		if (displayName == null) {
			return name();
		}
		return displayName;
	}

	boolean isUsable(Army army) {
		return usable.apply(army);
	}

}
