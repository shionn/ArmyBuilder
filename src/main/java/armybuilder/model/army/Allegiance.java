package armybuilder.model.army;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

import armybuilder.model.dok.DokRule;
import armybuilder.model.dok.DokUnitModel;
import armybuilder.model.rule.IRule;
import armybuilder.model.unit.IUnitModel;
import armybuilder.modelold.deprecated.army.Listing;
import armybuilder.modelold.deprecated.nighthaunt.NighthauntRule;
import armybuilder.modelold.deprecated.nighthaunt.NighthauntUnitModel;
import armybuilder.modelold.deprecated.unit.KeyWord;
import armybuilder.serialisation.EnumPropertyLoader;

public enum Allegiance {
	CoS("Order", null, new IUnitModel[0], null),
	DoK(
			"Order",
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
			Arrays.asList(NighthauntRule.AuraDEffroi, NighthauntRule.ConvocationSpectrale,
					NighthauntRule.EspritsImperissables, NighthauntRule.IlsViennentDesSousMondes,
					NighthauntRule.NourrisDeTerreur, NighthauntRule.RestituerLesFigurinesTuees,
					NighthauntRule.VagueDeTerreur),
			NighthauntUnitModel.values(),
			null);

	private String displayName;
	private List<IRule<?>> rules;
	private List<IUnitModel> units;
	private Consumer<Army> modifier;

	private Allegiance(String faction, List<IRule<?>> rules, IUnitModel[] units, Consumer<Army> modifier) {
		this.displayName = EnumPropertyLoader.instance().name(this);
		this.rules = rules;
		this.units = Arrays.asList(units);
		this.modifier = modifier;
	}

	public String getDisplayName() {
		return displayName;
	}

	public void decorate(Army army) {
		if (modifier != null) {
			modifier.accept(army);
		}
		if (rules != null) {
			army.add(rules.toArray(new IRule[0]));
		}
	}

	@Deprecated
	public List<IUnitModel> units() {
		return units;
	}

	@Deprecated
	public void rebuild(Listing listing) {
		if (modifier != null) {
//			modifier.accept(listing);
		}
		if (rules != null) {
			listing.add(rules.toArray(new IRule[0]));
		}
	}


	@Deprecated
	public List<IRule<?>> rules() {
		return rules;
	}

}
