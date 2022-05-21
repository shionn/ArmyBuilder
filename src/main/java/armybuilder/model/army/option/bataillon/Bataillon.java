package armybuilder.model.army.option.bataillon;

import java.util.Arrays;
import java.util.List;

import armybuilder.model.army.OldArmy;
import armybuilder.model.army.option.IListingOptionValue;
import armybuilder.model.army.option.ListingOption;
import armybuilder.model.army.rule.BataillonRule;
import armybuilder.model.army.rule.IArmyRule;
import armybuilder.model.unit.Unit;

@Deprecated
public enum Bataillon implements IListingOptionValue<Bataillon> {

	SeigneurDeGuerre(
			"Seigneur de Guerre",
			Arrays.asList(BataillonRule.Strateges, BataillonRule.Magnifiques),
			contain(BataillonSlot.Commandant, 1), opt(BataillonSlot.Commandant, 1),
			contain(BataillonSlot.SousCommandant, 2), opt(BataillonSlot.SousCommandant, 2),
			contain(BataillonSlot.Troupe, 1), opt(BataillonSlot.Troupe, 1)),
	RegimentDeBataille(
			"Régiment de Bataille",
			Arrays.asList(BataillonRule.Unifies),
			contain(BataillonSlot.Commandant, 1), opt(BataillonSlot.SousCommandant, 2),
			contain(BataillonSlot.Troupe, 2), opt(BataillonSlot.Troupe, 3), opt(BataillonSlot.Monstre, 1),
			opt(BataillonSlot.Artillerie, 1)),
	GrandeBatterie("Grande Batterie", Arrays.asList(BataillonRule.Tueurs), contain(BataillonSlot.SousCommandant, 1),
			contain(BataillonSlot.Artillerie, 2), opt(BataillonSlot.Artillerie, 1)),
	AvantGarde("Avant-Garde", Arrays.asList(BataillonRule.Rapides), contain(BataillonSlot.SousCommandant, 1),
			contain(BataillonSlot.Troupe, 1), opt(BataillonSlot.Troupe, 2)),
	BriseurDeLigne("Briseur de Ligne", Arrays.asList(BataillonRule.Experts), contain(BataillonSlot.Commandant, 1),
			contain(BataillonSlot.Monstre, 2), opt(BataillonSlot.Monstre, 1)),
	GardeRaprocheeS("Garde Rapprochée (Stratèges)", Arrays.asList(BataillonRule.Strateges),
			contain(BataillonSlot.Commandant, 1), contain(BataillonSlot.SousCommandant, 2),
			opt(BataillonSlot.SousCommandant, 1)),
	GardeRaprocheeM("Garde Rapprochée (Magnifiques)", Arrays.asList(BataillonRule.Magnifiques),
			contain(BataillonSlot.Commandant, 1), contain(BataillonSlot.SousCommandant, 2),
			opt(BataillonSlot.SousCommandant, 1));

	private String displayName;
	private List<IArmyRule<?>> rules;
	private List<BataillonComposition> compositions;

	private Bataillon(String displayName, List<IArmyRule<?>> rules, BataillonComposition... composition) {
		this.displayName = displayName;
		this.compositions = Arrays.asList(composition);
		this.rules = rules;
	}

	@Override
	public String getDisplayName() {
		return displayName;
	}

	@Override
	public ListingOption getOption() {
		return ListingOption.Bataillon;
	}

	@Override
	public boolean isOptionDisplayed(OldArmy army) {
		return true;
	}

	@Override
	public void rebuild(OldArmy army) {
		army.addRules(rules);
	}

	public List<IArmyRule<?>> getRules() {
		return rules;
	}

	@Override
	public boolean isAvailable(OldArmy army, Unit unit) {
		for (BataillonComposition c : compositions) {
			if (c.isAvailable(unit)) {
				return true;
			}
		}
		return false;
	}

	public List<BataillonComposition> getCompositions() {
		return compositions;
	}

	private static BataillonComposition contain(BataillonSlot slot, int count) {
		return new BataillonComposition() {
			@Override
			public boolean verify(OldArmy army) {
				return true;
			}

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
			public boolean verify(OldArmy army) {
				return true;
			}

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
