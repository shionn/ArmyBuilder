package armybuilder.model.rule;

public enum ArmyRuleType {
	TraisDeBataille(null),
	TraisUnitee(null),

	Composition(null),
	Aptitude(null),
	TraitsDeCommandement("Traits de Commandement"),
	Artefact(null),
	Sort(null),
	Priere(null),
	FureursMonstrueuses(null),
	ActionsHeroiques("Actions Heroique"),
	Triomphes(null),
	AptitudesDeCommandement("Aptitudes de Commandement"),
	EndLessSpell(""),

	PhaseDeCharge(null),
	PhaseDesHeros(null),
	PhaseDeMouvement(null),
	PhaseDeTir(null),
	PhaseDeCombat(null),
	PhaseDeDeroute(null),
	;
	private String displayName;

	private ArmyRuleType(String displayName) {
		this.displayName = displayName;
	}

	public String getDisplayName() {
		if (displayName == null) {
			return name();
		}
		return displayName;
	}

}
