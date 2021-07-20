package armybuilder.model.rule;

import java.util.Arrays;
import java.util.List;

import armybuilder.model.ArmyRuleType;

public enum GeneriqueUnitRule implements IArmyRule {

	Sorcier_3_2_1(ArmyRuleType.Aptitude),
	Vol(ArmyRuleType.Aptitude),
	;

	private List<ArmyRuleType> types;

	GeneriqueUnitRule(ArmyRuleType... types) {
		this.types = Arrays.asList(types);
	}

	@Override
	public List<ArmyRuleType> getTypes() {
		return types;
	}

}
