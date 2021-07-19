package armybuilder.model.dok;

import java.util.Arrays;
import java.util.List;

import armybuilder.model.ArmyRuleType;
import armybuilder.model.rule.IArmyRule;

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

	private List<ArmyRuleType> types;

	DokRule(ArmyRuleType... types) {
		this.types = Arrays.asList(types);
	}

	@Override
	public List<ArmyRuleType> getTypes() {
		return types;
	}

}
