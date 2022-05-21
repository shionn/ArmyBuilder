package armybuilder.model.army.modifier;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

import armybuilder.model.army.Army;
import armybuilder.model.army.rule.IArmyRule;
import armybuilder.model.unit.IUnitModel;

public class AllegianceModifier implements Consumer<Army> {

	private List<IUnitModel> units;
	private List<IArmyRule<?>> rules;

	public AllegianceModifier(IUnitModel[] units, IArmyRule<?>... rules) {
		this.units = Arrays.asList(units);
		this.rules = Arrays.asList(rules);
	}

	@Override
	public void accept(Army u) {
		rules.stream().forEach(u::addRules);
	}

}
