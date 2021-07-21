package armybuilder.model.option;

import armybuilder.model.Army;
import armybuilder.model.modifier.IArmyModifier;
import armybuilder.model.rule.DokRule;
import armybuilder.model.unit.dok.DokUnitModel;

public enum Allegiance implements IArmyOptionValue<Allegiance> {
	CoS("Order : City of Sigmar", null),
	DoK(
			"Order : Daughters of Khaine",
			new AllegianceModifier(DokUnitModel.values(), DokRule.RitesDeSang, DokRule.FoiFanatique));

	private String displayName;
	private IArmyModifier modifier;

	private Allegiance(String displayName, IArmyModifier modifier) {
		this.displayName = displayName;
		this.modifier = modifier;
	}

	@Override
	public String getDisplayName() {
		return displayName;
	}

	@Override
	public ArmyOption getOption() {
		return ArmyOption.Allegiance;
	}

	@Override
	public boolean isOptionDisplayed(Army army) {
		return true;
	}

	@Override
	public void rebuild(Army army) {
		if (modifier != null) {
			modifier.accept(army);
		}
	}

}
