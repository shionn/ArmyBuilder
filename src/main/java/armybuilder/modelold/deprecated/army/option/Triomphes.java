package armybuilder.modelold.deprecated.army.option;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import armybuilder.model.rule.RuleType;
import armybuilder.model.rule.IRule;
import armybuilder.modelold.deprecated.army.Listing;
import armybuilder.serialisation.DescriptionReader;

public enum Triomphes implements IListingOptionValue<Triomphes>, IRule<Triomphes> {
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
	public ListingOption option() {
		return ListingOption.Triomphes;
	}

	@Override
	public List<RuleType> getTypes() {
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
