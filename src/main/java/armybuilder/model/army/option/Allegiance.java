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

public enum Allegiance {
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

	public String getDisplayName() {
		return displayName;
	}

	@Deprecated
	public void rebuild(OldArmy army) {
		if (modifier != null) {
			modifier.accept(army);
		}
	}

	public List<IUnitModel> units() {
		return units;
	}

}
