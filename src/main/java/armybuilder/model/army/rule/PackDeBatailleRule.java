package armybuilder.model.army.rule;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import armybuilder.serialisation.DescriptionReader;

public enum PackDeBatailleRule implements IArmyRule<PackDeBatailleRule> {
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
		return new DescriptionReader().read("Generique/PackDeBataille/", name());
	}

	@Override
	public String displayName() {
		if (displayName == null) {
			return name();
		}
		return displayName;
	}

	@Override
	public String toString() {
		return name() + getTypes();
	}

}
