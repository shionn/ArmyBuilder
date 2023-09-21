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
import armybuilder.model.unit.role.RoleTactique;
import armybuilder.serialisation.EnumPropertyLoader;

public enum Allegiance implements IHaveDisplayName, IDecoreArmy {
//	CoS(null, null),
	DoK(
			Arrays.asList(DokRule.RitesDeSang, DokRule.FoiFanatique, DokRule.FureurDeBataille, DokRule.MassacreTotal,
					DokRule.FracasDesArmes, DokRule.MareeDeLames),
			a -> {
				a.addIf(a.count(KeyWord.Khinerai) > 1, DokRule.RegalCruel);
				a.addIf(a.count(KeyWord.GrandeGladiatrice) > 0, DokRule.CulteDeLExecutrice);
				a.addIf(a.is(SubAllegiance.HaggNar) || a.is(SubAllegiance.KheltNar), DokRule.HaineDuChaos);
				a.addIf(a.count(KeyWord.RodeursDeLOmbre) > 0, DokRule.AttaqueInatendue);
			}),
	Nighthaunt(
			Arrays.asList(NighthauntRule.ApparitionsInstables, NighthauntRule.AuraDEffroi, NighthauntRule.Etheres,
					NighthauntRule.Incorporels, NighthauntRule.VagueDeTerreur, NighthauntRule.ToucherEffroyable,
					NighthauntRule.SubmergesParLEffroi, NighthauntRule.MareesDeTerreur, NighthauntRule.PaniqueDeMasse,
					NighthauntRule.CauchemarsIncessants),
			a -> {
				a.addIf(a.count(KeyWord.Raclechaines) + a.count(KeyWord.NueesDEsprits) > 0,
						NighthauntRule.LaMortParUnMillierDeCoupures);
				a.addIf(a.count(KeyWord.CarrosseNoir) > 0, NighthauntRule.UnAllerSimple);
				if (a.count(KeyWord.KurdossValentian) > 0) {
					a.units(KeyWord.GardeDuTroneVeule)
							.forEach(u -> u.changeRole(RoleTactique.Elite, RoleTactique.Ligne));
				}
			}),
	Skaven(Arrays.asList(SkavenRule.LUnionFaitLaForce),
			a -> {
				a.units(KeyWord.Heros)
						.stream()
						.filter(u -> !u.is(KeyWord.Monstre))
						.forEach(u -> u.add(SkavenRule.DirigerDepuisLArriere));
				a.units(KeyWord.Heros)
						.stream()
						.filter(u -> !u.is(KeyWord.Monture))
						.forEach(u -> u.add(SkavenRule.SauveQuiPeut));

				// Maitreclan
				a.units(KeyWord.Heros, KeyWord.Maitreclan).forEach(u -> u.add(SkavenRule.ManipulateursHabiles));
				a.addIf(a.count(KeyWord.Heros, KeyWord.Maitreclan) > 2, SkavenRule.ToujoursTroisCoupsDeGriffesDAvance);

				// clan moulder
				a.addIf(Arrays.asList(1, 2).contains(a.count(KeyWord.AbominationDeMalefosse)),
						SkavenRule.CreationsPrisees_1);
				a.addIf(a.count(KeyWord.MaitreMoulder) > 2 && a.count(KeyWord.AbominationDeMalefosse) > 1,
						SkavenRule.CreationsPrisees_3);
				a.addIf(a.count(KeyWord.RatsOgors) > 0, SkavenRule.SoignerLaBete);

				// clan echin
				a.addIf(a.count(KeyWord.ClansEshin) > 1 && a.count(KeyWord.Heros, KeyWord.ClansEshin) < 3,
						SkavenRule.MaitresDuMeurtre_1);
				a.addIf(a.count(KeyWord.Heros, KeyWord.ClansEshin) > 2, SkavenRule.MaitresDuMeurtre_3);
				a.addIf(a.count(KeyWord.ClansEshin) > 0, SkavenRule.MarqueDeLaMort);

				// clan verminus
				a.addIf(Arrays.asList(1, 2).contains(a.count(KeyWord.Griffarque)), SkavenRule.PuissantsChefsDeGuerre_1);
				a.addIf(a.count(KeyWord.Griffarque) > 2, SkavenRule.PuissantsChefsDeGuerre_3);

				// clan skryre
				a.addIf(Arrays.asList(1, 2).contains(a.count(KeyWord.Heros, KeyWord.ClansSkryre)),
						SkavenRule.BougiesDeMalepierre_1);
				a.addIf(a.count(KeyWord.Heros, KeyWord.ClansSkryre) > 2, SkavenRule.BougiesDeMalepierre_3);
				a.addIf(a.count(KeyWord.ClansSkryre) > 0, SkavenRule.FeuFeuPlusPlus);
				a.units(KeyWord.ClansSkryre, KeyWord.Heros, KeyWord.Sorcier)
						.forEach(u -> u.add(SkavenRule.BougiesDeMalepierre_Sort));
				a.units(KeyWord.ClansSkryre, KeyWord.Heros)
						.forEach(u -> u.add(SkavenRule.BougiesDeMalepierre_Tir, SkavenRule.BougiesDeMalepierre_Combat));

				// clan Pestilien
				a.addIf(a.count(KeyWord.Pretre, KeyWord.ClansPestilens) > 0, SkavenRule.EchosDesGrandesPlaies);
				a.units(KeyWord.Pretre, KeyWord.ClansPestilens)
						.forEach(u -> u.add(SkavenRule.EchosDesGrandesPlaies_Unit));
				a.addIf(a.count(KeyWord.Pretre, KeyWord.ClansPestilens) > 2, SkavenRule.CrescendoDuChoeurInfecte);


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
