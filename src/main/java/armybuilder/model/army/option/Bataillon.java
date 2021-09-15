package armybuilder.model.army.option;

import java.util.Arrays;
import java.util.List;

import armybuilder.model.army.Army;
import armybuilder.model.army.rule.BataillonRule;
import armybuilder.model.army.rule.IArmyRule;

public enum Bataillon implements IArmyOptionValue<Bataillon> {

	SeigneurDeGuerre("Seigneur de Guerre", BataillonRule.Strateges, BataillonRule.Magnifiques),
	RegimentDeBataille("Régiment de Bataille", BataillonRule.Unifies),
	GrandeBatterie("Grande Batterie", BataillonRule.Tueurs),
	AvantGarde("Avant-Garde", BataillonRule.Rapides),
	BriseurDeLigne("Briseur de Ligne", BataillonRule.Experts),
	GardeRaprocheeS("Garde Rapprochée (Stratèges)", BataillonRule.Strateges),
	GardeRaprocheeM("Garde Rapprochée (Magnifiques)", BataillonRule.Magnifiques);

	private String displayName;
	private List<IArmyRule<?>> rules;

	private Bataillon(String displayName, IArmyRule<?>... rules) {
		this.displayName = displayName;
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

}
