package armybuilder.model.army.modifier;

import java.util.Arrays;

import armybuilder.model.army.Army;
import armybuilder.model.army.rule.IArmyRule;

public class Modifiers {

	public static IArmyModifier rules(IArmyRule<?>... rules) {
		return (Army a) -> Arrays.stream(rules).forEach(a::addRule);
	}

}
