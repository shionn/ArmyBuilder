package armybuilder.model.army.option.bataillon;

import java.util.Arrays;
import java.util.List;

import armybuilder.model.army.Army;
import armybuilder.model.army.option.ArmyOption;
import armybuilder.model.army.option.IArmyOptionValue;
import armybuilder.model.army.rule.BataillonRule;
import armybuilder.model.army.rule.IArmyRule;
import armybuilder.model.unit.Unit;

public enum Bataillon implements IArmyOptionValue<Bataillon> {

	SeigneurDeGuerre(
			"Seigneur de Guerre",
			and(contain(BataillonSlot.Commandant, 1, 2),
					contain(BataillonSlot.SousCommandant, 2, 4),
					contain(BataillonSlot.Troupe, 1, 2)),
			BataillonRule.Strateges,
			BataillonRule.Magnifiques),
	RegimentDeBataille(
			"Régiment de Bataille",
			and(contain(BataillonSlot.Commandant, 1, 1),
					contain(BataillonSlot.SousCommandant, 0, 2),
					contain(BataillonSlot.Troupe, 2, 5)
			),
			BataillonRule.Unifies),
	GrandeBatterie("Grande Batterie", null, BataillonRule.Tueurs),
	AvantGarde("Avant-Garde", null, BataillonRule.Rapides),
	BriseurDeLigne("Briseur de Ligne", null, BataillonRule.Experts),
	GardeRaprocheeS("Garde Rapprochée (Stratèges)", null, BataillonRule.Strateges),
	GardeRaprocheeM("Garde Rapprochée (Magnifiques)", null, BataillonRule.Magnifiques);

	private String displayName;
	private List<IArmyRule<?>> rules;
	private BataillonComposition composition;

	private Bataillon(String displayName, BataillonComposition composition, IArmyRule<?>... rules) {
		this.displayName = displayName;
		this.composition = composition;
		this.rules = Arrays.asList(rules);
	}

	@Override
	public String getDisplayName() {
		return displayName;
	}

	@Override
	public ArmyOption getOption() {
		return ArmyOption.Bataillon;
	}

	@Override
	public boolean isOptionDisplayed(Army army) {
		return true;
	}

	@Override
	public void rebuild(Army army) {
		army.addRules(rules);
	}

	@Override
	public void verify(Army army) {
		// TODO Auto-generated method stub

	}
	
	public List<IArmyRule<?>> getRules() {
		return rules;
	}

	@Override
	public boolean isAvailable(Army army, Unit unit) {
		return composition.isAvailable(unit);
	}

	private static BataillonComposition contain(BataillonSlot slot, int min, int max) {
		return new BataillonComposition() {
			@Override
			public boolean verify(Army army) {
				return true;
			}

			@Override
			public boolean isAvailable(Unit unit) {
				return slot.is(unit);
			}
		};
	}

	private static BataillonComposition and(BataillonComposition... sub) {
		return new BataillonComposition() {
			@Override
			public boolean isAvailable(Unit unit) {
				for (BataillonComposition c : sub) {
					if (c.isAvailable(unit)) return true;
				}
				return false;
			}

			@Override
			public boolean verify(Army army) {
				for (BataillonComposition c : sub) {
					if (!c.verify(army)) {
						return false;
					}
				}
				return true;
			}
		};
	}

	private static BataillonComposition xor(BataillonComposition c1, BataillonComposition c2) {
		return new BataillonComposition() {
			@Override
			public boolean isAvailable(Unit unit) {
				return c1.isAvailable(unit) || c2.isAvailable(unit);
			}

			@Override
			public boolean verify(Army army) {
				return c1.verify(army) ^ c2.verify(army);
			}
		};
	}

}
