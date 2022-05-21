package armybuilder.model.army.option;

import java.util.Arrays;
import java.util.List;

import armybuilder.model.army.OldArmy;
import armybuilder.model.army.modifier.AllegianceModifier;
import armybuilder.model.army.modifier.IArmyModifier;
import armybuilder.model.dok.DokRule;
import armybuilder.model.dok.DokUnitModel;
import armybuilder.model.nighthaunt.NighthauntRule;
import armybuilder.model.nighthaunt.NighthauntUnitModel;
import armybuilder.model.unit.IUnitModel;
import armybuilder.model.unit.Unit;

public enum Allegiance implements IArmyOptionValue<Allegiance> {
	CoS("Order", "City of Sigmar", null, new IUnitModel[0]),
	DoK(
			"Order", "Daughters of Khaine",
			new AllegianceModifier(DokUnitModel.values(), DokRule.RitesDeSang,
					DokRule.FoiFanatique),
			DokUnitModel.values()),
	Nighthaunt(
			"Death", "Nighthaunt",
			new AllegianceModifier(NighthauntUnitModel.values(), NighthauntRule.AuraDEffroi,
					NighthauntRule.ConvocationSpectrale, NighthauntRule.EspritsImperissables,
					NighthauntRule.IlsViennentDesSousMondes, NighthauntRule.NourrisDeTerreur,
					NighthauntRule.RestituerLesFigurinesTuees, NighthauntRule.VagueDeTerreur),
			NighthauntUnitModel.values())
	;

	private String displayName;
	private String faction;
	private IArmyModifier modifier;
	private List<IUnitModel> units;

	private Allegiance(String faction, String displayName, IArmyModifier modifier, IUnitModel[] units) {
		this.faction = faction;
		this.displayName = displayName;
		this.modifier = modifier;
		this.units = Arrays.asList(units);
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
	public boolean isOptionDisplayed(OldArmy army) {
		return true;
	}

	@Override
	public void rebuild(OldArmy army) {
		if (modifier != null) {
			modifier.accept(army);
		}
	}

	@Override
	public void verify(OldArmy army) {
	}

	@Override
	public boolean isAvailable(OldArmy army, Unit unit) {
		return false;
	}

	public List<IUnitModel> units() {
		return units;
	}

}
