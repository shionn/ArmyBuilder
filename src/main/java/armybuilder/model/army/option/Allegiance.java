package armybuilder.model.army.option;

import java.util.Arrays;
import java.util.List;

import armybuilder.model.army.Listing;
import armybuilder.model.army.rule.IArmyRule;
import armybuilder.model.dok.DokRule;
import armybuilder.model.dok.DokUnitModel;
import armybuilder.model.nighthaunt.NighthauntRule;
import armybuilder.model.nighthaunt.NighthauntUnitModel;
import armybuilder.model.unit.IUnitModel;

public enum Allegiance {
	CoS("Order", "City of Sigmar", null, new IUnitModel[0]),
	DoK(
			"Order", "Daughters of Khaine",
			Arrays.asList(DokRule.RitesDeSang, DokRule.FoiFanatique, DokRule.FureurDeBataille, DokRule.MassacreTotal),
			DokUnitModel.values()),
	Nighthaunt(
			"Death", "Nighthaunt",
			Arrays.asList(NighthauntRule.AuraDEffroi, NighthauntRule.ConvocationSpectrale,
					NighthauntRule.EspritsImperissables, NighthauntRule.IlsViennentDesSousMondes,
					NighthauntRule.NourrisDeTerreur, NighthauntRule.RestituerLesFigurinesTuees,
					NighthauntRule.VagueDeTerreur),
			NighthauntUnitModel.values())
	;

	private String displayName;
	private List<IArmyRule<?>> rules;
	private List<IUnitModel> units;

	private Allegiance(String faction, String displayName, List<IArmyRule<?>> rules, IUnitModel[] units) {
		this.displayName = displayName;
		this.rules = rules;
		this.units = Arrays.asList(units);
	}

	public String getDisplayName() {
		return displayName;
	}

	public void rebuild(Listing listing) {
//		listing.units(KeyWord.Sorcier).forEach(u -> {
//			u.add(GeneriqueRule.TraitMagique);
//			u.add(GeneriqueRule.BouclierMystique);
//		});
		if (rules != null) {
			listing.add(rules.toArray(new IArmyRule[0]));
		}
	}

	public List<IUnitModel> units() {
		return units;
	}

	public List<IArmyRule<?>> rules() {
		return rules;
	}

}
