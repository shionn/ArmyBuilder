package armybuilder.model.rule;

import java.util.function.Function;

import armybuilder.model.unit.keyword.KeyWord;
import armybuilder.modelold.deprecated.army.OldOldArmy;
import armybuilder.serialisation.EnumPropertyLoader;

public enum RuleType {
	TraisDeBataille(a -> true, true),
	TraisUnitee(a -> !a.getUnits().isEmpty(), false),

	SubAllegiance(a -> false, false),

	Composition(a -> !a.getUnits().isEmpty(), true),
	TactiquesDeBataille(a -> true, true),

	Aptitude(a -> true, true),
	AptitudesDeCommandement(a -> true, true),
	TraitsDeCommandement(a -> true, true),
	FureursMonstrueuses(a -> !a.units(KeyWord.Monstre).isEmpty(), true),
	ActionsHeroiques(a -> true, true),
	Artefact(a -> true, true),
	Sort(a -> !a.units(KeyWord.Sorcier).isEmpty(), true),
	Priere(a -> !a.units(KeyWord.Pretre).isEmpty(), true),
	Triomphes(a -> true, true),
	EndLessSpell(a -> !a.units(KeyWord.Sorcier).isEmpty(), true),

	PhaseBeforeStart(a -> true, false),
	PhaseDeCharge(a -> true, false),
	PhaseDesHeros(a -> true, false),
	PhaseDeMouvement(a -> true, false),
	PhaseDeTir(a -> true, false),
	PhaseDeCombat(a -> true, false),
	PhaseDeDeroute(a -> true, false),

	;
	private String displayName;
	private Function<OldOldArmy, Boolean> usable;
	private boolean displayed;

	private RuleType(Function<OldOldArmy, Boolean> usable, boolean displayed) {
		this.displayName = EnumPropertyLoader.instance().name(this);
		this.usable = usable;
		this.displayed = displayed;
	}

	public boolean isDisplayed() {
		return displayed;
	}

	public String getDisplayName() {
		return displayName;
	}

	@Deprecated
	boolean isUsable(OldOldArmy army) {
		return usable.apply(army);
	}

}
