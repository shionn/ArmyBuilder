package armybuilder.model.army.option;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

import armybuilder.model.army.Army;
import armybuilder.model.dok.DokRule;
import armybuilder.model.dok.DokUnitModel;
import armybuilder.model.nighthaunt.NighthauntRule;
import armybuilder.model.nighthaunt.NighthauntUnitModel;
import armybuilder.model.unit.IUnitModel;

public enum Allegiance {
	CoS("Order", "City of Sigmar", null, new IUnitModel[0]),
	DoK(
			"Order", "Daughters of Khaine",
			a -> a.addRules(DokRule.RitesDeSang, DokRule.FoiFanatique),
			DokUnitModel.values()),
	Nighthaunt(
			"Death", "Nighthaunt",
			a -> a.addRules(NighthauntRule.AuraDEffroi,
					NighthauntRule.ConvocationSpectrale, NighthauntRule.EspritsImperissables,
					NighthauntRule.IlsViennentDesSousMondes, NighthauntRule.NourrisDeTerreur,
					NighthauntRule.RestituerLesFigurinesTuees, NighthauntRule.VagueDeTerreur),
			NighthauntUnitModel.values())
	;

	private String displayName;
	private String faction;
	private Consumer<Army> modifier;
	private List<IUnitModel> units;

	private Allegiance(String faction, String displayName, Consumer<Army> modifier, IUnitModel[] units) {
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

	public void rebuild(Army army) {
		if (modifier != null) {
			modifier.accept(army);
		}
	}

	public List<IUnitModel> units() {
		return units;
	}

}
