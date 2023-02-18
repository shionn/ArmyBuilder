package armybuilder.model.army.bataillon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

import armybuilder.model.IHaveDisplayName;
import armybuilder.model.army.Army;
import armybuilder.model.army.IDecoreArmy;
import armybuilder.model.army.PackDeBataille;
import armybuilder.model.rule.IRule;
import armybuilder.model.unit.IDecorateUnit;
import armybuilder.model.unit.Unit;
import armybuilder.model.unit.keyword.KeyWord;

public enum BataillonType implements IHaveDisplayName, IDecoreArmy, IDecorateUnit {

	AvantGarde(
			"Avant-Garde",
			l -> true,
			Arrays.asList(BataillonRule.Rapides),
			null,
			Arrays.asList(),
			contain(BataillonSlot.SousCommandant, 1),
			contain(BataillonSlot.Troupe, 1),
			opt(BataillonSlot.Troupe, 2)),
	BriseurDeLigne(
			"Briseur de Ligne",
			l -> true,
			Arrays.asList(BataillonRule.Experts),
			null,
			Arrays.asList(),
			contain(BataillonSlot.Commandant, 1),
			contain(BataillonSlot.Monstre, 2),
			opt(BataillonSlot.Monstre, 1)),
	ChasseurDesContrees(
			"Chasseurs des Contrées",
			l -> l.is(PackDeBataille.BataillesRangees2021)
					&& l.count(BataillonType.valueOf("ChasseurDesContrees")) <= 1,
			Arrays.asList(BataillonRule.OutsidersExperts),
			null,
			Arrays.asList(),
			contain(BataillonSlot.Troupe, 2),
			opt(BataillonSlot.Troupe, 1)),
	ChasseursDePrimes(
			"Chasseurs de Primes",
			l -> l.is(PackDeBataille.BataillesRangees2022) && l.count(BataillonType.valueOf("ChasseursDePrimes")) <= 1,
			Arrays.asList(BataillonRule.ChasseursDeTetes),
			null,
			Arrays.asList(),
			contain(BataillonSlot.Troupe, 2),
			opt(BataillonSlot.Troupe, 1)),
	ConquerantsExperts(
			"Conquérants Experts",
			l -> l.is(PackDeBataille.BataillesRangees2022) && l.count(BataillonType.valueOf("ConquerantsExperts")) <= 1,
			Arrays.asList(BataillonRule.ForceDominatrice),
			null,
			Arrays.asList(),
			contain(BataillonSlot.VeteranDeGallet, 2),
			opt(BataillonSlot.VeteranDeGallet, 1)),
	GardeRaprocheeM(
			"Garde Rapprochée (Magnifiques)",
			l -> true,
			Arrays.asList(),
			null,
			Arrays.asList(BataillonRule.Magnifiques),
			contain(BataillonSlot.Commandant, 1),
			contain(BataillonSlot.SousCommandant, 2),
			opt(BataillonSlot.SousCommandant, 1)),
	GardeRaprocheeS(
			"Garde Rapprochée (Stratèges)",
			l -> true,
			Arrays.asList(),
			null,
			Arrays.asList(BataillonRule.Strateges),
			contain(BataillonSlot.Commandant, 1),
			contain(BataillonSlot.SousCommandant, 2),
			opt(BataillonSlot.SousCommandant, 1)),
// TODO	GardeVyperine("Garde Vypérine",
//			l->l.is(Allegiance.DoK),
//			Arrays.asList(BataillonRule.Strateges),
//			Arrays.asList(),
//			contain(BataillonSlot.Morathi, 2),
//			contain(BataillonSlot.KhainiteLeader, 1),
//			opt(BataillonSlot.KhainiteLeader, 2),
//			contain(BataillonSlot.GuerriereMelusai, 2),
//			opt(BataillonSlot.GuerriereMelusai, 4)),
	GrandeBatterie(
			"Grande Batterie",
			l -> true,
			Arrays.asList(BataillonRule.Tueurs),
			null,
			Arrays.asList(),
			contain(BataillonSlot.SousCommandant, 1),
			contain(BataillonSlot.Artillerie, 2),
			opt(BataillonSlot.Artillerie, 1)),
	MeuteDeBeteAlpha(
			"Meute de Bête Alpha",
			l -> l.is(PackDeBataille.BataillesRangees2021) && l.count(BataillonType.valueOf("MeuteDeBeteAlpha")) <= 1,
			Arrays.asList(BataillonRule.PisterALOdeur),
			null,
			Arrays.asList(),
			contain(BataillonSlot.Monstre, 2),
			opt(BataillonSlot.Monstre, 1)),
// TODO	PatrouilleDeLOmbreU(
//			"Patrouille de l'Ombre (Unifiés)",
//			l -> l.is(Allegiance.DoK),
//			Arrays.asList(BataillonRule.Unifies),
//			Arrays.asList(),
//			contain(BataillonSlot.ConjurateursDuFauMaudit, 2),
//			contain(BataillonSlot.GuerriereKhinerai, 4)),
//	TODO PatrouilleDeLOmbreR(
//			"Patrouille de l'Ombre (Rapides)",
//			l -> l.is(Allegiance.DoK),
//			Arrays.asList(BataillonRule.Rapides),
//			Arrays.asList(),
//			contain(BataillonSlot.ConjurateursDuFauMaudit, 2),
//			contain(BataillonSlot.GuerriereKhinerai, 4)),
	RegimentDeBataille(
			"Régiment de Bataille",
			l -> true,
			Arrays.asList(BataillonRule.Unifies),
			null,
			Arrays.asList(),
			contain(BataillonSlot.Commandant, 1),
			opt(BataillonSlot.SousCommandant, 2),
			contain(BataillonSlot.Troupe, 2),
			opt(BataillonSlot.Troupe, 3),
			opt(BataillonSlot.Monstre, 1),
			opt(BataillonSlot.Artillerie, 1)),
	SeigneurDeGuerre(
			"Seigneur de Guerre",
			l -> true,
			Arrays.asList(),
			null,
			Arrays.asList(BataillonRule.Strateges, BataillonRule.Magnifiques),
			contain(BataillonSlot.Commandant, 1),
			opt(BataillonSlot.Commandant, 1),
			contain(BataillonSlot.SousCommandant, 2),
			opt(BataillonSlot.SousCommandant, 2),
			contain(BataillonSlot.Troupe, 1),
			opt(BataillonSlot.Troupe, 1)),

	EtatMajorDeGallet(
			"Etat-Major de Gallet",
			a -> a.is(PackDeBataille.BataillesRangees2023),
			Arrays.asList(BataillonRule.UnButCommun),
			u -> u.addIf(BataillonSlot.Infanterie.is(u), KeyWord.GardeAssermentee),
			Arrays.asList(),
			contain(BataillonSlot.ChampionDeGallet, 1),
			contain(BataillonSlot.Infanterie, 1)),

	VeteransDeGallet(
			"Vétérans de Gallet",
			a -> a.is(PackDeBataille.BataillesRangees2023),
			Arrays.asList(BataillonRule.FreterniteDuCombat),
			null,
			Arrays.asList(),
			contain(BataillonSlot.Infanterie, 2),
			opt(BataillonSlot.Infanterie, 2))

	;

	private String displayName;
	private Function<Army, Boolean> available;
	private List<IRule<?>> unitRules;
	private List<IRule<?>> armyRules;
	private List<BataillonComposition> compositions;
	private Consumer<Unit> unitModifier;

	private BataillonType(String displayName, Function<Army, Boolean> available, List<IRule<?>> unitRules,
			Consumer<Unit> unitModifier, List<IRule<?>> armyRules, BataillonComposition... composition) {
		this.displayName = displayName;
		this.available = available;
		this.unitModifier = unitModifier;
		this.compositions = Arrays.asList(composition);
		this.unitRules = unitRules;
		this.armyRules = armyRules;

	}

	@Override
	public String getDisplayName() {
		return displayName;
	}

	public List<IRule<?>> getRules() {
		List<IRule<?>> all = new ArrayList<IRule<?>>(unitRules);
		all.addAll(armyRules);
		return all;
	}

	public List<BataillonComposition> getCompositions() {
		return compositions;
	}

	public boolean availableFor(Army army) {
		return available.apply(army);
	}

	public boolean availableFor(Unit unit) {
		return compositions.stream().filter(c -> c.isAvailable(unit)).findAny().isPresent();
	}

	@Override
	public void decorate(Unit unit) {
		if (unitModifier != null) {
			unitModifier.accept(unit);
		} else {
			unitRules.stream().forEach(unit::add);
		}
	}

	@Override
	public void decorate(Army army) {
		armyRules.stream().forEach(army::add);
	}

	private static BataillonComposition contain(BataillonSlot slot, int count) {
		return new BataillonComposition() {

			@Override
			public boolean isAvailable(Unit unit) {
				return slot.is(unit);
			}

			@Override
			public String getImg() {
				return slot.name();
			}

			@Override
			public boolean isOpt() {
				return false;
			}

			@Override
			public int getCount() {
				return count;
			}

		};
	}

	private static BataillonComposition opt(BataillonSlot slot, int count) {
		return new BataillonComposition() {

			@Override
			public boolean isAvailable(Unit unit) {
				return slot.is(unit);
			}

			@Override
			public String getImg() {
				return slot.name();
			}

			@Override
			public boolean isOpt() {
				return true;
			}

			@Override
			public int getCount() {
				return count;
			}
		};
	}

}
