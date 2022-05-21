package armybuilder.model.army.rule;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import armybuilder.model.army.OldArmy;
import armybuilder.serialisation.DescriptionReader;

public enum BataillonRule implements IArmyRule<BataillonRule> {
	Unifies("Unifiés"),
	Experts("Experts", ArmyRuleType.AptitudesDeCommandement, ArmyRuleType.PhaseDeTir, ArmyRuleType.PhaseDeCombat),
	Magnifiques("Magnifiques"),
	Tueurs("Tueurs", ArmyRuleType.AptitudesDeCommandement, ArmyRuleType.PhaseDeTir, ArmyRuleType.PhaseDeCombat,
			ArmyRuleType.PhaseDeCharge),
	Strateges("Stratèges", ArmyRuleType.PhaseDesHeros),
	Rapides("Rapides", ArmyRuleType.AptitudesDeCommandement, ArmyRuleType.PhaseDeMouvement);

	private String displayName;
	private List<ArmyRuleType> types;

	private BataillonRule(String displayName, ArmyRuleType... types) {
		this.displayName = displayName;
		this.types = Arrays.asList(types);
	}

	@Override
	public List<ArmyRuleType> getTypes() {
		return types;
	}

	@Override
	public String displayName() {
		return displayName;
	}

	@Override
	public String getDescription() throws IOException {
		return new DescriptionReader().read("Generique/", name());
	}

	@Override
	public void rebuild(OldArmy army) {
	}


}
