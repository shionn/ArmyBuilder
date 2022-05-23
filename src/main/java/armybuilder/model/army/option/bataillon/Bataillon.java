package armybuilder.model.army.option.bataillon;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

import armybuilder.model.army.Listing;
import armybuilder.model.army.OldArmy;
import armybuilder.model.army.option.Allegiance;
import armybuilder.model.army.rule.BataillonRule;
import armybuilder.model.army.rule.IArmyRule;
import armybuilder.model.unit.Unit;
import armybuilder.model.unit.option.IUnitOptionValue;
import armybuilder.model.unit.option.UnitOption;

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
	PatrouilleDeLOmbreU(
			"Patrouille de l'Ombre", 
			l -> l.is(Allegiance.DoK), 
			Arrays.asList(BataillonRule.Unifies), 
			contain(BataillonSlot.ConjurateursDuFauMaudit, 2), 
			contain(BataillonSlot.GuerriereKhinerai, 4)),
	PatrouilleDeLOmbreR(
			"Patrouille de l'Ombre", 
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
	private List<IArmyRule<?>> rules;
	private List<BataillonComposition> compositions;

	private Bataillon(String displayName, Function<Listing, Boolean> available, List<IArmyRule<?>> rules,
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

	@Deprecated
	public void rebuild(OldArmy army) {
		army.addRules(rules);
	}

	public List<IArmyRule<?>> rules() {
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
	public UnitOption option() {
		return UnitOption.Bataillon;
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
