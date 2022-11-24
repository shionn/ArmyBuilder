package armybuilder.model.army;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import armybuilder.model.IHaveDisplayName;
import armybuilder.model.rule.IRule;
import armybuilder.model.rule.RuleType;
import armybuilder.serialisation.DescriptionReader;

public enum Triomphes implements IHaveDisplayName, IDecoreArmy, IRule<Triomphes> {
	Sanguinaires("Sanguinaires", Arrays.asList(RuleType.Triomphes, RuleType.PhaseDeCharge)),
	Inspires(
			"Inspirés",
			Arrays.asList(RuleType.Triomphes, RuleType.PhaseDeTir,
					RuleType.PhaseDeCombat)),
	Indomptables(
			"Indomptables",
			Arrays.asList(RuleType.Triomphes, RuleType.PhaseDeDeroute));

	private String displayName;
	private List<RuleType> ruleTypes;

	private Triomphes(String displayName, List<RuleType> ruleTypes) {
		this.displayName = displayName;
		this.ruleTypes = ruleTypes;
	}

	@Override
	public String getDisplayName() {
		return displayName;
	}

	@Override
	public List<RuleType> getTypes() {
		return ruleTypes;
	}

	@Override
	public String getDescription() throws IOException {
		return new DescriptionReader().read("Triomphes/", name());
	}


	@Override
	public void decorate(Army army) {
		army.add(this);
	}

}