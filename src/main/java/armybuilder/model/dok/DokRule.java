package armybuilder.model.dok;

import armybuilder.model.ArmyRuleType;
import armybuilder.model.i.IArmyRule;

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
	;

	private ArmyRuleType type;

	DokRule(ArmyRuleType type) {
		this.type = type;
	}

	@Override
	public ArmyRuleType getType() {
		return type;
	}

}
