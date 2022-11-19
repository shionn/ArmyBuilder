package armybuilder.modelold.deprecated.army.rule;

import java.util.function.Function;

import armybuilder.modelold.deprecated.army.OldOldArmy;
import armybuilder.modelold.deprecated.unit.KeyWord;

public enum ArmyRuleType {
	TraisDeBataille(null, a -> true),
	TraisUnitee(null, a -> !a.getUnits().isEmpty()),

	SubAllegiance(null, a -> false),

	Composition(null, a -> !a.getUnits().isEmpty()),
	TactiquesDeBataille("Tactiques de Bataille", a -> true),

	Aptitude(null, a -> true),
	AptitudesDeCommandement("Aptitudes de Commandement", a -> true),
	TraitsDeCommandement("Traits de Commandement", a -> true),
	FureursMonstrueuses("Fureurs Monstrueuses", a -> !a.units(KeyWord.Monstre).isEmpty()),
	ActionsHeroiques("Actions Heroique", a -> true),
	Artefact(null, a -> true),
	Sort(null, a -> !a.units(KeyWord.Sorcier).isEmpty()),
	Priere(null, a -> !a.units(KeyWord.Pretre).isEmpty()),
	Triomphes(null, a -> true),
	EndLessSpell(null, a -> !a.units(KeyWord.Sorcier).isEmpty()),

	PhaseBeforeStart(null, a -> true),
	PhaseDeCharge(null, a -> true),
	PhaseDesHeros(null, a -> true),
	PhaseDeMouvement(null, a -> true),
	PhaseDeTir(null, a -> true),
	PhaseDeCombat(null, a -> true),
	PhaseDeDeroute(null, a -> true),

	;
	private String displayName;
	private Function<OldOldArmy, Boolean> usable;

	private ArmyRuleType(String displayName, Function<OldOldArmy, Boolean> usable) {
		this.displayName = displayName;
		this.usable = usable;
	}

	public String getDisplayName() {
		if (displayName == null) {
			return getName();
		}
		return displayName;
	}

	boolean isUsable(OldOldArmy army) {
		return usable.apply(army);
	}

}