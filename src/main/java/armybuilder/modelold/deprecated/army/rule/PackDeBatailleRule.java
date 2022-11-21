package armybuilder.modelold.deprecated.army.rule;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import armybuilder.model.rule.RuleType;
import armybuilder.model.rule.IRule;
import armybuilder.serialisation.DescriptionReader;

public enum PackDeBatailleRule implements IRule<PackDeBatailleRule> {
	RugissementSauvage(
			"Rugissement Sauvage",
			RuleType.AptitudesDeCommandement,
			RuleType.PhaseDeCombat),
	Metamorphose("Métamorphose", RuleType.Sort, RuleType.TraisUnitee),
	RegardDeGhur("Regard de Ghur", RuleType.Sort, RuleType.TraisUnitee),

	;

	private List<RuleType> types;
	private String displayName;

	PackDeBatailleRule(RuleType... types) {
		this.types = Arrays.asList(types);
	}

	PackDeBatailleRule(String displayName, RuleType... types) {
		this.displayName = displayName;
		this.types = Arrays.asList(types);
	}

	@Override
	public List<RuleType> getTypes() {
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
