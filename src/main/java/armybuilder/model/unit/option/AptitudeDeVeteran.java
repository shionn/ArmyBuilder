package armybuilder.model.unit.option;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import armybuilder.model.army.OldArmy;
import armybuilder.model.army.rule.ArmyRuleType;
import armybuilder.model.army.rule.IArmyRule;
import armybuilder.serialisation.DescriptionReader;

public enum AptitudeDeVeteran implements IArmyRule<AptitudeDeVeteran> {

	ChargeDevastratrice(
			"Charge Dévastratrice",
			ArmyRuleType.AptitudeDeVeteran,
			ArmyRuleType.TraisUnitee,
			ArmyRuleType.PhaseDeCharge),
	FormationDefensive(
			"Formation Défensive",
			ArmyRuleType.AptitudeDeVeteran,
			ArmyRuleType.TraisUnitee,
			ArmyRuleType.PhaseDeCombat),
	ManoeuvreDisciplinees(
			"Manoeuvre Disciplinées",
			ArmyRuleType.AptitudeDeVeteran,
			ArmyRuleType.TraisUnitee,
			ArmyRuleType.PhaseDeCombat),
	PiedsLegers(
			"Pieds Légers",
			ArmyRuleType.AptitudeDeVeteran,
			ArmyRuleType.TraisUnitee,
			ArmyRuleType.PhaseDeCharge),
	VoleeMortelle(
			"Volée Mortelle",
			ArmyRuleType.AptitudeDeVeteran,
			ArmyRuleType.TraisUnitee,
			ArmyRuleType.PhaseDeTir),

	;

	private List<ArmyRuleType> types;
	private String displayName;

	AptitudeDeVeteran(String displayName, ArmyRuleType... types) {
		this.displayName = displayName;
		this.types = Arrays.asList(types);
	}

	@Override
	public String displayName() {
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

	@Override
	public void rebuild(OldArmy army) {

	}

}
