package armybuilder.model.rule;

import armybuilder.serialisation.EnumPropertyLoader;

public enum RuleType {
	TraisDeBataille(true),
	TraisUnitee(false),

//	SubAllegiance(false),

	GrandeStrategie(true),
	Triomphes(true),
	Composition(true),
	TactiquesDeBataille(true),

	Aptitude(true),
	AptitudesDeCommandement(true),
	TraitsDeCommandement(true),
	FureursMonstrueuses(true),
	ActionsHeroiques(true),
	Artefact(true),
	Sort(true),
	Priere(true),
	EndLessSpell(true),

	PhaseBeforeStart(false),
	PhaseDeCharge(false),
	PhaseDesHeros(false),
	PhaseDeMouvement(false),
	PhaseDeTir(false),
	PhaseDeCombat(false),
	PhaseDeDeroute(false),

	Rule(true),

	;
	private String displayName;
	private boolean displayed;

	private RuleType(boolean displayed) {
		this.displayName = EnumPropertyLoader.instance().name(this);
		this.displayed = displayed;
	}

	public boolean isDisplayed() {
		return displayed;
	}

	public String getDisplayName() {
		return displayName;
	}


}
