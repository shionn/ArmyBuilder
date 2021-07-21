package armybuilder.model.modifier;

import java.util.Arrays;

import armybuilder.model.Army;
import armybuilder.model.rule.IArmyRule;

public class Modifiers {

	public static IArmyModifier rules(IArmyRule... rules) {
		return (Army a) -> Arrays.stream(rules).forEach(a::addRule);
	}

	public static IArmyModifier add(IArmyModifier... modifiers) {
		return (Army a) -> Arrays.stream(modifiers).forEach(m -> m.accept(a));
	}

}
