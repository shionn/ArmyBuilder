package armybuilder.model.unit.option;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import armybuilder.model.rule.ArmyRuleType;
import armybuilder.model.rule.DescriptionReader;
import armybuilder.model.rule.IArmyRule;

public enum AptitudeDeVeteran implements IArmyRule<AptitudeDeVeteran> {

	VoleeMortelle(
			"Volée Mortelle",
			ArmyRuleType.AptitudeDeVeteran,
			ArmyRuleType.TraisUnitee,
			ArmyRuleType.PhaseDeTir),
	FormationDefensive(
			"Formation Défensive",
			ArmyRuleType.AptitudeDeVeteran,
			ArmyRuleType.TraisUnitee,
			ArmyRuleType.PhaseDeCombat),

	;

	private List<ArmyRuleType> types;
	private String displayName;

	AptitudeDeVeteran(String displayName, ArmyRuleType... types) {
		this.displayName = displayName;
		this.types = Arrays.asList(types);
	}

	@Override
	public String getDisplayName() {
		return displayName;
	}

	@Override
	public List<ArmyRuleType> getTypes() {
		return types;
	}

	@Override
	public String getDescription() throws IOException {
		return new DescriptionReader().read("AptitudeDeVeteran/", name());
	}

	@Override
	public String toString() {
		return name() + getTypes();
	}

}
