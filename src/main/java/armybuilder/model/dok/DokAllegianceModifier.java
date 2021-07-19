package armybuilder.model.dok;

import armybuilder.model.Allegiance;
import armybuilder.model.Army;
import armybuilder.model.i.IArmyModifier;

public class DokAllegianceModifier implements IArmyModifier<Allegiance> {

	@Override
	public void accept(Allegiance allegiance, Army army) {
		army.addRule(DokRule.RitesDeSang);
		army.addRule(DokRule.FoiFanatique);
	}

}
