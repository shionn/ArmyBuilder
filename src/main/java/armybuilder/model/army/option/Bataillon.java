package armybuilder.model.army.option;

import armybuilder.model.army.Army;
import armybuilder.model.army.rule.BataillonRule;

public enum Bataillon implements IArmyOptionValue<Bataillon> {

	SeigneurDeGuerre("Seigneur de Guerre", BataillonRule.Strateges, BataillonRule.Magnifiques),
	RegimentDeBataille("Régiment de Bataille", BataillonRule.Unifies),
	GrandeBatterie("Grande Batterie", BataillonRule.Tueurs),
	AvantGarde("Avant-Garde", BataillonRule.Rapides),
	BriseurDeLigne("Briseur de Ligne", BataillonRule.Experts),
	GardeRaprocheeS("Garde Rapprochée (Stratèges)", BataillonRule.Strateges),
	GardeRaprocheeM("Garde Rapprochée (Magnifiques)", BataillonRule.Magnifiques);

	private String displayName;

	private Bataillon(String displayName, BataillonRule... rules) {
		this.displayName = displayName;
	}

	@Override
	public String getDisplayName() {
		return displayName;
	}

	@Override
	public ArmyOption getOption() {
		return null;
	}

	@Override
	public boolean isOptionDisplayed(Army army) {
		return true;
	}

	@Override
	public void rebuild(Army army) {
		// TODO Auto-generated method stub

	}

	@Override
	public void verify(Army army) {
		// TODO Auto-generated method stub

	}
	
}
