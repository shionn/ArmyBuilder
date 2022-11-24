package armybuilder.model.army;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

import armybuilder.model.IHaveDisplayName;
import armybuilder.model.dok.DokRule;
import armybuilder.model.rule.IRule;
import armybuilder.model.unit.keyword.KeyWord;
import armybuilder.modelold.deprecated.nighthaunt.NighthauntRule;
import armybuilder.serialisation.EnumPropertyLoader;

public enum Allegiance implements IHaveDisplayName, IDecoreArmy {
	CoS(null, null),
	DoK(
			Arrays.asList(DokRule.RitesDeSang, DokRule.FoiFanatique, DokRule.FureurDeBataille, DokRule.MassacreTotal),
			a -> {
				a.add(DokRule.FracasDesArmes);
				a.addIf(a.count(KeyWord.Khinerai) >1, DokRule.RegalCruel);
				a.add(DokRule.MareeDeLames);
				a.addIf(a.count(KeyWord.GrandeGladiatrice) > 0, DokRule.CulteDeLExecutrice);
				a.addIf(a.is(SubAllegiance.HaggNar) || a.is(SubAllegiance.KheltNar), DokRule.HaineDuChaos);
				a.addIf(a.count(KeyWord.RodeursDeLOmbre) > 0, DokRule.AttaqueInatendue);
			}),
	Nighthaunt(
			Arrays.asList(NighthauntRule.AuraDEffroi, NighthauntRule.ConvocationSpectrale,
					NighthauntRule.EspritsImperissables, NighthauntRule.IlsViennentDesSousMondes,
					NighthauntRule.NourrisDeTerreur, NighthauntRule.RestituerLesFigurinesTuees,
					NighthauntRule.VagueDeTerreur),
			null);

	private String displayName;
	private List<IRule<?>> rules;
	private Consumer<Army> modifier;

	private Allegiance(List<IRule<?>> rules, Consumer<Army> modifier) {
		this.displayName = EnumPropertyLoader.instance().name(this);
		this.rules = rules;
		this.modifier = modifier;
	}

	@Override
	public String getDisplayName() {
		return displayName;
	}

	@Override
	public void decorate(Army army) {
		if (modifier != null) {
			modifier.accept(army);
		}
		if (rules != null) {
			army.add(rules.toArray(new IRule[0]));
		}
		if (army.getSubAllegiance() == null) {
			Arrays.stream(SubAllegiance.values())
					.filter(sub -> sub.availableFor(army))
					.findFirst()
					.ifPresent(sub -> army.setSubAllegiance(sub));
		}
	}

}
