package armybuilder.model.rule;

import java.util.Arrays;
import java.util.List;

public enum GeneriqueUnitRule implements IArmyRule<GeneriqueUnitRule> {

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
