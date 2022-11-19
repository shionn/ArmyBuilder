package armybuilder.modelold.deprecated.army.option;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import armybuilder.model.rule.IRule;
import armybuilder.modelold.deprecated.army.Listing;
import armybuilder.modelold.deprecated.army.rule.ArmyRuleType;
import armybuilder.serialisation.DescriptionReader;

public enum Triomphes implements IListingOptionValue<Triomphes>, IRule<Triomphes> {
	Sanguinaires("Sanguinaires", Arrays.asList(ArmyRuleType.Triomphes, ArmyRuleType.PhaseDeCharge)),
	Inspires(
			"Inspirés",
			Arrays.asList(ArmyRuleType.Triomphes, ArmyRuleType.PhaseDeTir,
					ArmyRuleType.PhaseDeCombat)),
	Indomptables(
			"Indomptables",
			Arrays.asList(ArmyRuleType.Triomphes, ArmyRuleType.PhaseDeDeroute));

	private String displayName;
	private List<ArmyRuleType> ruleTypes;

	private Triomphes(String displayName, List<ArmyRuleType> ruleTypes) {
		this.displayName = displayName;
		this.ruleTypes = ruleTypes;
	}

	@Override
	public String getDisplayName() {
		return displayName;
	}

	@Override
	public ListingOption option() {
		return ListingOption.Triomphes;
	}

	@Override
	public List<ArmyRuleType> getTypes() {
		return ruleTypes;
	}

	@Override
	public String getDescription() throws IOException {
		return new DescriptionReader().read("Triomphes/", getName());
	}

	@Override
	public String toString() {
		return getName() + getTypes();
	}

	@Override
	public void rebuild(Listing listing) {
		listing.add(this);
	}

	@Override
	public boolean availableFor(Listing listing) {
		return true;
	}

}
