package armybuilder.model.rule;

import armybuilder.serialisation.EnumPropertyLoader;

public enum RuleType {
	Memo(false),
	MemoDisplay(false),

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
	Sort(true),
	EndLessSpell(true),
	Aura(false),

	PhaseBeforeStart(false),
	PhaseDeCharge(false),
	PhaseDesHeros(false),
	PhaseDesHerosPlayer(false),
	PhaseDesHerosPlayerDebut(false),
	PhaseDeMouvement(false),
	PhaseDeMouvementPlayerDebut(false),
	PhaseDeMouvementPlayer(false),
	PhaseDeMouvementPlayerFin(false),
	PhaseDeTir(false),
	PhaseDeTirPlayer(false),
	PhaseDeTirPlayerDebut(false),
	PhaseDeCombat(false),
	PhaseDeCombatDebut(false),
	PhaseDeCombatFin(false),
	PhaseDeDeroute(false),

	Rule(false),

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
