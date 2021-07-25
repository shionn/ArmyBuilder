package armybuilder.model.option;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import armybuilder.model.Army;
import armybuilder.model.rule.ArmyRuleType;
import armybuilder.model.rule.DescriptionReader;
import armybuilder.model.rule.IArmyRule;

public enum Triomphes implements IArmyOptionValue<Triomphes>, IArmyRule<Triomphes> {
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
	public ArmyOption getOption() {
		return ArmyOption.Triomphes;
	}

	@Override
	public boolean isOptionDisplayed(Army army) {
		return true;
	}

	@Override
	public void rebuild(Army army) {
		army.addRule(this);
	}

	@Override
	public void verify(Army army) {

	}

	@Override
	public List<ArmyRuleType> getTypes() {
		return ruleTypes;
	}

	@Override
	public String getDescription() throws IOException {
		return new DescriptionReader().read("Triomphes/", name());
	}

	@Override
	public String toString() {
		return name() + getTypes();
	}

}
