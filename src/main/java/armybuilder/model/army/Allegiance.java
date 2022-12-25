package armybuilder.model.army;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

import armybuilder.model.IHaveDisplayName;
import armybuilder.model.dok.DokRule;
import armybuilder.model.nighthaunt.NighthauntRule;
import armybuilder.model.rule.IRule;
import armybuilder.model.skaven.SkavenRule;
import armybuilder.model.stormcast.StormcastRule;
import armybuilder.model.unit.keyword.KeyWord;
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
			Arrays.asList(NighthauntRule.ApparitionsInstables, NighthauntRule.AuraDEffroi, NighthauntRule.Etheres,
					NighthauntRule.Incorporels, NighthauntRule.VagueDeTerreur, NighthauntRule.ToucherEffroyable),
			null),
	Skaven(Arrays.asList(SkavenRule.DirigerDepuisLArriere, SkavenRule.SauveQuiPeut, SkavenRule.SauveQuiPeut),
			a -> {
				a.units(KeyWord.Heros, KeyWord.Maitreclan).forEach(u -> u.add(SkavenRule.ManipulateursHabiles));
				a.addIf(a.count(KeyWord.Heros, KeyWord.Maitreclan) > 2, SkavenRule.ToujoursTroisCoupsDeGriffesDAvance);
				a.addIf(Arrays.asList(1, 2).contains(a.count(KeyWord.MaitresMoulder)), SkavenRule.CreationsPrisees_1);
				a.addIf(a.count(KeyWord.MaitresMoulder) > 2, SkavenRule.CreationsPrisees_3);
				a.addIf(a.count(KeyWord.Heros, KeyWord.ClansEchin) < 3, SkavenRule.MaitresDuMeurtre_1);
				a.addIf(a.count(KeyWord.Heros, KeyWord.ClansEchin) > 2, SkavenRule.MaitresDuMeurtre_3);
				a.addIf(a.count(KeyWord.Griffarque) < 3, SkavenRule.PuissantsChefsDeGuerre_1);
				a.addIf(a.count(KeyWord.Griffarque) > 2, SkavenRule.PuissantsChefsDeGuerre_3);

			}
	),
	StormCast(Arrays.asList(StormcastRule.FlamboiementDeGloire, StormcastRule.DescendantsDeLOrage), null);

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
