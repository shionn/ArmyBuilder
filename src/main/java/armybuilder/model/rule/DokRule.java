package armybuilder.model.rule;

import java.util.Arrays;
import java.util.List;

import armybuilder.model.ArmyRuleType;

public enum DokRule implements IArmyRule {
	RitesDeSang(ArmyRuleType.TraisDeBataille),
	FoiFanatique(ArmyRuleType.TraisDeBataille),

	CrypteDesAinee(ArmyRuleType.TraisDeBataille),
	DisciplesDuMassacre(ArmyRuleType.TraisDeBataille),
	DissimulationEtDiscretion(ArmyRuleType.TraisDeBataille),
	FillesDuPremierTemple(ArmyRuleType.TraisDeBataille),
	FrapperEtSeRetirer(ArmyRuleType.TraisDeBataille),
	LessenceDeKhaine(ArmyRuleType.TraisDeBataille),
	TueusesHerisseesDeLames(ArmyRuleType.TraisDeBataille),

	CoeurDeFerDeKhaine(ArmyRuleType.Aptitude),
	DeuxCorpsUneSeuleAme(ArmyRuleType.Aptitude),
	DeuxCorpsUneSeuleAme_Shadow(ArmyRuleType.Aptitude),
	FureurDeLaReineDeLOmbre(ArmyRuleType.Aptitude),
	PresenceIntimidante(ArmyRuleType.Aptitude),

	VenerationParLeSang(ArmyRuleType.AptitudesDeCommandement, ArmyRuleType.PhaseDesHeros),

	HorreurNoireDUlgu(ArmyRuleType.Sort),
	;

	private List<ArmyRuleType> types;

	DokRule(ArmyRuleType... types) {
		this.types = Arrays.asList(types);
	}

	@Override
	public List<ArmyRuleType> getTypes() {
		return types;
	}

}
