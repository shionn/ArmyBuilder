package armybuilder.model.rule;

import armybuilder.serialisation.EnumPropertyLoader;

public enum RuleType {
	TraisDeBataille(true),
	TraisUnitee(false),

//	SubAllegiance(false),

	GrandeStrategie(true),
	Triomphes(true),
	Composition(false),
	TactiquesDeBataille(true),

	Aptitude(false),
	AptitudesDeCommandement(true),
	TraitsDeCommandement(true),
	TraitsDeMonture(false),
	FureursMonstrueuses(true),
	ActionsHeroiques(true),
	Artefact(true),
	Priere(true),
	EndLessSpell(true),

	Sort(true),
	Aura(false),

	PhaseBeforeStart(false),
	PhaseDeCharge(false),
	PhaseDesHeros(false),
	PhaseDesHerosPlayer(false),
	PhaseDeMouvement(false),
	PhaseDeTir(false),
	PhaseDeCombat(false),
	PhaseDeCombatDebut(false),
	PhaseDeCombatFin(false),
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
