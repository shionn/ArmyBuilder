package armybuilder.model.army.rule;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import armybuilder.model.army.OldArmy;
import armybuilder.serialisation.DescriptionReader;

public enum PackDeBataille2021Rule implements IArmyRule<PackDeBataille2021Rule> {
	RugissementSauvage(
			"Rugissement Sauvage",
			ArmyRuleType.AptitudesDeCommandement,
			ArmyRuleType.PhaseDeCombat),
	Metamorphose("Métamorphose", ArmyRuleType.Sort, ArmyRuleType.TraisUnitee),

	;

	private List<ArmyRuleType> types;
	private String displayName;

	PackDeBataille2021Rule(ArmyRuleType... types) {
		this.types = Arrays.asList(types);
	}

	PackDeBataille2021Rule(String displayName, ArmyRuleType... types) {
		this.displayName = displayName;
		this.types = Arrays.asList(types);
	}

	@Override
	public List<ArmyRuleType> getTypes() {
		return types;
	}

	@Override
	public String getDescription() throws IOException {
		return new DescriptionReader().read("Generique/", name());
	}

	@Override
	public String getDisplayName() {
		if (displayName == null) {
			return name();
		}
		return displayName;
	}

	@Override
	public String toString() {
		return name() + getTypes();
	}

	@Override
	public void rebuild(OldArmy army) {

	}

}
