package armybuilder.model.army.rule;

import java.io.IOException;
import java.util.List;

import armybuilder.model.army.Army;
import armybuilder.serialisation.DescriptionReader;

public enum BataillonRule implements IArmyRule<BataillonRule> {
	Unifies("Unifiés"),
	Experts("Experts"),
	Magnifiques("Magnifiques"),
	Tueurs("Tueurs"),
	Strateges("Stratèges"),
	Rapides("Rapides");

	private String displayName;

	private BataillonRule(String displayName) {
		this.displayName = displayName;
	}
	
	@Override
	public List<ArmyRuleType> getTypes() {
		return null;
	}

	@Override
	public String getDisplayName() {
		return displayName;
	}

	@Override
	public String getDescription() throws IOException {
		return new DescriptionReader().read("Generique", name());
	}

	@Override
	public void rebuild(Army army) {
		// TODO Auto-generated method stub

	}

}
