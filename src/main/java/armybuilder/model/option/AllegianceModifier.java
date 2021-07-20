package armybuilder.model.option;

import java.util.Arrays;
import java.util.List;

import armybuilder.model.Army;
import armybuilder.model.modifier.IArmyModifier;
import armybuilder.model.rule.IArmyRule;
import armybuilder.model.unit.IUnit;

public class AllegianceModifier implements IArmyModifier<Allegiance> {

	private List<IUnit> units;
	private List<IArmyRule> rules;

	public AllegianceModifier(IUnit[] units, IArmyRule... rules) {
		this.units = Arrays.asList(units);
		this.rules = Arrays.asList(rules);
	}

	@Override
	public void accept(Allegiance t, Army u) {
		rules.stream().forEach(u::addRule);
		units.stream().forEach(u::addUnitChoice);
	}

}
