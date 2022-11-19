package armybuilder.modelold.deprecated.army.rule;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import armybuilder.model.rule.IRule;
import armybuilder.serialisation.DescriptionReader;

public enum PackDeBatailleRule implements IRule<PackDeBatailleRule> {
	RugissementSauvage(
			"Rugissement Sauvage",
			ArmyRuleType.AptitudesDeCommandement,
			ArmyRuleType.PhaseDeCombat),
	Metamorphose("Métamorphose", ArmyRuleType.Sort, ArmyRuleType.TraisUnitee),
	RegardDeGhur("Regard de Ghur", ArmyRuleType.Sort, ArmyRuleType.TraisUnitee),

	;

	private List<ArmyRuleType> types;
	private String displayName;

	PackDeBatailleRule(ArmyRuleType... types) {
		this.types = Arrays.asList(types);
	}

	PackDeBatailleRule(String displayName, ArmyRuleType... types) {
		this.displayName = displayName;
		this.types = Arrays.asList(types);
	}

	@Override
	public List<ArmyRuleType> getTypes() {
		return types;
	}

	@Override
	public String getDescription() throws IOException {
		return new DescriptionReader().read("Generique/PackDeBataille/", getName());
	}

	@Override
	public String getDisplayName() {
		if (displayName == null) {
			return getName();
		}
		return displayName;
	}

	@Override
	public String toString() {
		return getName() + getTypes();
	}

}
