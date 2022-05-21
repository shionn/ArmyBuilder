package armybuilder.model.army.modifier;

import java.util.Arrays;
import java.util.List;

import armybuilder.model.army.OldArmy;
import armybuilder.model.army.rule.IArmyRule;
import armybuilder.model.unit.IUnitModel;

public class AllegianceModifier implements IArmyModifier {

	private List<IUnitModel> units;
	private List<IArmyRule<?>> rules;

	public AllegianceModifier(IUnitModel[] units, IArmyRule<?>... rules) {
		this.units = Arrays.asList(units);
		this.rules = Arrays.asList(rules);
	}

	@Override
	public void accept(OldArmy u) {
		rules.stream().forEach(u::addRule);
		units.stream().forEach(u::addUnitChoice);
	}

}
