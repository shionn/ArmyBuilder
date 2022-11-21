package armybuilder.modelold.deprecated.army.option.bataillon;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

import armybuilder.model.army.Allegiance;
import armybuilder.model.rule.IRule;
import armybuilder.model.unit.option.UnitOptionCategory;
import armybuilder.modelold.deprecated.army.Listing;
import armybuilder.modelold.deprecated.army.option.PackDeBataille;
import armybuilder.modelold.deprecated.army.rule.BataillonRule;
import armybuilder.modelold.deprecated.unit.Unit;
import armybuilder.modelold.deprecated.unit.option.IUnitOptionValue;

public enum Bataillon implements IUnitOptionValue<Bataillon> {

	AvantGarde(
			"Avant-Garde",
			l -> true,
			Arrays.asList(BataillonRule.Rapides),
			contain(BataillonSlot.SousCommandant, 1),
			contain(BataillonSlot.Troupe, 1),
			opt(BataillonSlot.Troupe, 2)),
	BriseurDeLigne(
			"Briseur de Ligne",
			l -> true,
			Arrays.asList(BataillonRule.Experts),
			contain(BataillonSlot.Commandant, 1),
			contain(BataillonSlot.Monstre, 2),
			opt(BataillonSlot.Monstre, 1)),
	ChasseurDesContrees(
			"Chasseurs des Contrées",
			l -> l.is(PackDeBataille.BataillesRangees2021) && l.count(Bataillon.valueOf("ChasseurDesContrees")) <= 1,
			Arrays.asList(BataillonRule.OutsidersExperts),
			contain(BataillonSlot.Troupe, 2),
			opt(BataillonSlot.Troupe, 1)),
	ChasseursDePrimes(
			"Chasseurs de Primes",
			l -> l.is(PackDeBataille.BataillesRangees2022) && l.count(Bataillon.valueOf("ChasseursDePrimes")) <= 1,
			Arrays.asList(BataillonRule.ChasseursDeTetes),
			contain(BataillonSlot.Troupe, 2),
			opt(BataillonSlot.Troupe, 1)),
	ConquerantsExperts(
			"Conquérants Experts",
			l -> l.is(PackDeBataille.BataillesRangees2022) && l.count(Bataillon.valueOf("ConquerantsExperts")) <= 1,
			Arrays.asList(BataillonRule.ForceDominatrice),
			contain(BataillonSlot.VeteranDeGallet, 2),
			opt(BataillonSlot.VeteranDeGallet, 1)),
	GardeRaprocheeM(
			"Garde Rapprochée (Magnifiques)",
			l -> true,
			Arrays.asList(BataillonRule.Magnifiques),
			contain(BataillonSlot.Commandant, 1),
			contain(BataillonSlot.SousCommandant, 2),
			opt(BataillonSlot.SousCommandant, 1)),
	GardeRaprocheeS(
			"Garde Rapprochée (Stratèges)",
			l -> true,
			Arrays.asList(BataillonRule.Strateges),
			contain(BataillonSlot.Commandant, 1),
			contain(BataillonSlot.SousCommandant, 2),
			opt(BataillonSlot.SousCommandant, 1)),
	GardeVyperine("Garde Vypérine",
			l->l.is(Allegiance.DoK),
			Arrays.asList(BataillonRule.Strateges), 
			contain(BataillonSlot.Morathi, 2),
			contain(BataillonSlot.KhainiteLeader, 1), 
			opt(BataillonSlot.KhainiteLeader, 2), 
			contain(BataillonSlot.GuerriereMelusai, 2), 
			opt(BataillonSlot.GuerriereMelusai, 4)),
	GrandeBatterie(
			"Grande Batterie",
			l -> true,
			Arrays.asList(BataillonRule.Tueurs),
			contain(BataillonSlot.SousCommandant, 1),
			contain(BataillonSlot.Artillerie, 2),
			opt(BataillonSlot.Artillerie, 1)),
	MeuteDeBeteAlpha(
			"Meute de Bête Alpha",
			l -> l.is(PackDeBataille.BataillesRangees2021) && l.count(Bataillon.valueOf("MeuteDeBeteAlpha")) <= 1,
			Arrays.asList(BataillonRule.PisterALOdeur),
			contain(BataillonSlot.Monstre, 2),
			opt(BataillonSlot.Monstre, 1)),
	PatrouilleDeLOmbreU(
			"Patrouille de l'Ombre (Unifiés)",
			l -> l.is(Allegiance.DoK), 
			Arrays.asList(BataillonRule.Unifies), 
			contain(BataillonSlot.ConjurateursDuFauMaudit, 2), 
			contain(BataillonSlot.GuerriereKhinerai, 4)),
	PatrouilleDeLOmbreR(
			"Patrouille de l'Ombre (Rapides)",
			l -> l.is(Allegiance.DoK), 
			Arrays.asList(BataillonRule.Rapides), 
			contain(BataillonSlot.ConjurateursDuFauMaudit, 2), 
			contain(BataillonSlot.GuerriereKhinerai, 4)),
	RegimentDeBataille(
			"Régiment de Bataille",
			l -> true,
			Arrays.asList(BataillonRule.Unifies),
			contain(BataillonSlot.Commandant, 1),
			opt(BataillonSlot.SousCommandant, 2),
			contain(BataillonSlot.Troupe, 2),
			opt(BataillonSlot.Troupe, 3),
			opt(BataillonSlot.Monstre, 1),
			opt(BataillonSlot.Artillerie, 1)),
	SeigneurDeGuerre(
			"Seigneur de Guerre",
			l -> true,
			Arrays.asList(BataillonRule.Strateges, BataillonRule.Magnifiques),
			contain(BataillonSlot.Commandant, 1),
			opt(BataillonSlot.Commandant, 1),
			contain(BataillonSlot.SousCommandant, 2),
			opt(BataillonSlot.SousCommandant, 2),
			contain(BataillonSlot.Troupe, 1),
			opt(BataillonSlot.Troupe, 1)),


	;

	private String displayName;
	private Function<Listing, Boolean> available;
	private List<IRule<?>> rules;
	private List<BataillonComposition> compositions;

	private Bataillon(String displayName, Function<Listing, Boolean> available, List<IRule<?>> rules,
			BataillonComposition... composition) {
		this.displayName = displayName;
		this.available = available;
		this.compositions = Arrays.asList(composition);
		this.rules = rules;
	}

	@Override
	public String displayName() {
		return displayName;
	}

	public List<IRule<?>> rules() {
		return rules;
	}

	public boolean isAvailable(Listing listing) {
		return available.apply(listing);
	}

	public List<BataillonComposition> compositions() {
		return compositions;
	}

	@Override
	public boolean isAvailable(Unit unit) {
		return compositions.stream().filter(c -> c.isAvailable(unit)).findAny().isPresent();
	}

	@Override
	public UnitOptionCategory option() {
		return UnitOptionCategory.Bataillon;
	}

	@Override
	public void rebuild(Unit unit) {
		// TODO Auto-generated method stub

	}

	private static BataillonComposition contain(BataillonSlot slot, int count) {
		return new BataillonComposition() {

			@Override
			public boolean isAvailable(Unit unit) {
				return slot.is(unit);
			}

			@Override
			public String getImg() {
				return slot.getName();
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
				return slot.getName();
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
