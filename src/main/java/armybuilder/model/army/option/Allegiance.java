package armybuilder.model.army.option;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

import armybuilder.model.army.Listing;
import armybuilder.model.army.rule.IArmyRule;
import armybuilder.model.dok.DokRule;
import armybuilder.model.dok.DokUnitModel;
import armybuilder.model.nighthaunt.NighthauntRule;
import armybuilder.model.nighthaunt.NighthauntUnitModel;
import armybuilder.model.unit.IUnitModel;
import armybuilder.model.unit.KeyWord;

public enum Allegiance {
	CoS("Order", "City of Sigmar", null, new IUnitModel[0], null),
	DoK(
			"Order",
			"Daughters of Khaine",
			Arrays.asList(DokRule.RitesDeSang, DokRule.FoiFanatique, DokRule.FureurDeBataille, DokRule.MassacreTotal),
			DokUnitModel.values(),
			a -> {
				a.add(DokRule.FracasDesArmes);
				a.addIf(a.count(KeyWord.Khinerai) >1, DokRule.RegalCruel);
				a.add(DokRule.MareeDeLames);
				a.addIf(a.count(KeyWord.GrandeGladiatrice) > 0, DokRule.CulteDeLExecutrice);
				a.addIf(a.count(KeyWord.GrandeGladiatrice) > 0, DokRule.CulteDeLExecutrice);
				a.addIf(a.is(SubAllegiance.HaggNar) || a.is(SubAllegiance.KheltNar), DokRule.HaineDuChaos);
				a.addIf(a.count(KeyWord.RodeursDeLOmbre) > 0, DokRule.AttaqueInatendue);
			}),
	Nighthaunt(
			"Death",
			"Nighthaunt",
			Arrays.asList(NighthauntRule.AuraDEffroi, NighthauntRule.ConvocationSpectrale,
					NighthauntRule.EspritsImperissables, NighthauntRule.IlsViennentDesSousMondes,
					NighthauntRule.NourrisDeTerreur, NighthauntRule.RestituerLesFigurinesTuees,
					NighthauntRule.VagueDeTerreur),
			NighthauntUnitModel.values(),
			null);

	private String displayName;
	private List<IArmyRule<?>> rules;
	private List<IUnitModel> units;
	private Consumer<Listing> modifier;

	private Allegiance(String faction, String displayName, List<IArmyRule<?>> rules, IUnitModel[] units,
			Consumer<Listing> modifier) {
		this.displayName = displayName;
		this.rules = rules;
		this.units = Arrays.asList(units);
		this.modifier = modifier;
	}

	public String getDisplayName() {
		return displayName;
	}

	public void rebuild(Listing listing) {
		if (modifier != null) {
			modifier.accept(listing);
		}
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
