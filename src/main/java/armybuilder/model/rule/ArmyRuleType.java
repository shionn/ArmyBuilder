package armybuilder.model.rule;

public enum ArmyRuleType {
	TraisDeBataille(null),
	TraisUnitee(null),

	Composition(null),
	Aptitude(null),
	AptitudesDeCommandement("Aptitudes de Commandement"),
	TraitsDeCommandement("Traits de Commandement"),
	FureursMonstrueuses(null),
	ActionsHeroiques("Actions Heroique"),
	AptitudeDeVeteran("Aptitude de Vétéran"),
	Artefact(null),
	Sort(null),
	Priere(null),
	Triomphes(null),
	EndLessSpell(null),

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
