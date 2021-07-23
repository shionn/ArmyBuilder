package armybuilder.model.rule;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public enum GeneriqueUnitRule implements IArmyRule<GeneriqueUnitRule> {

	Sorcier_1_2("Magie", ArmyRuleType.Aptitude),
	Sorcier_3_2_1("Magie", ArmyRuleType.Aptitude),
	Vol(ArmyRuleType.Aptitude),
	;

	private String displayName;
	private List<ArmyRuleType> types;

	GeneriqueUnitRule(ArmyRuleType... types) {
		this.types = Arrays.asList(types);
	}

	GeneriqueUnitRule(String displayName, ArmyRuleType... types) {
		this.displayName = displayName;
		this.types = Arrays.asList(types);
	}

	@Override
	public List<ArmyRuleType> getTypes() {
		return types;
	}

	@Override
	public String getDescription() throws IOException {
		return new DescriptionReader().read("GeneriqueUnit/", name());
	}

	@Override
	public String getDisplayName() {
		if (displayName == null) {
			return name();
		}
		return displayName;
	}

}
