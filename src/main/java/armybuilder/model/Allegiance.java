package armybuilder.model;

import armybuilder.model.dok.DokRule;
import armybuilder.model.i.IArmyModifier;
import armybuilder.model.i.IArmyOption;

public enum Allegiance implements IArmyOption<Allegiance> {
	CoS("Order : City of Sigmar", null),
	DoK("Order : Daughters of Khaine", Modifiers.rules(DokRule.RitesDeSang, DokRule.FoiFanatique));

	private String displayName;
	private IArmyModifier<Allegiance> modifier;

	private Allegiance(String displayName, IArmyModifier<Allegiance> modifier) {
		this.displayName = displayName;
		this.modifier = modifier;
	}

	@Override
	public String getDisplayName() {
		return displayName;
	}

	@Override
	public ArmyOptionType getType() {
		return ArmyOptionType.Allegiance;
	}

	@Override
	public boolean isOptionDisplayed(Army army) {
		return true;
	}

	@Override
	public void rebuild(Army army) {
		if (modifier != null) {
			modifier.accept(this, army);
		}
	}

}
