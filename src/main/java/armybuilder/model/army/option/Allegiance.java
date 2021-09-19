package armybuilder.model.army.option;

import armybuilder.model.army.Army;
import armybuilder.model.army.modifier.AllegianceModifier;
import armybuilder.model.army.modifier.IArmyModifier;
import armybuilder.model.dok.DokRule;
import armybuilder.model.dok.DokUnitModel;
import armybuilder.model.nighthaunt.NighthauntRule;
import armybuilder.model.nighthaunt.NighthauntUnitModel;
import armybuilder.model.unit.Unit;

public enum Allegiance implements IArmyOptionValue<Allegiance> {
	CoS("Order", "City of Sigmar", null),
	DoK(
			"Order", "Daughters of Khaine",
			new AllegianceModifier(DokUnitModel.values(), DokRule.RitesDeSang,
					DokRule.FoiFanatique)),
	Nighthaunt(
			"Death", "Nighthaunt",
			new AllegianceModifier(NighthauntUnitModel.values(), NighthauntRule.AuraDEffroi,
					NighthauntRule.ConvocationSpectrale, NighthauntRule.EspritsImperissables,
					NighthauntRule.IlsViennentDesSousMondes, NighthauntRule.NourrisDeTerreur,
					NighthauntRule.RestituerLesFigurinesTuees, NighthauntRule.VagueDeTerreur))
	
	;

	private String displayName;
	private String faction;
	private IArmyModifier modifier;

	private Allegiance(String faction, String displayName, IArmyModifier modifier) {
		this.faction = faction;
		this.displayName = displayName;
		this.modifier = modifier;
	}

	public String getFullName() {
		return faction + " : " + displayName;
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

	@Override
	public void verify(Army army) {
	}

	@Override
	public boolean isAvailable(Army army, Unit unit) {
		return false;
	}

}
