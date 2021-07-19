package armybuilder.model;

import java.util.Arrays;

import armybuilder.model.i.IArmyModifier;
import armybuilder.model.i.IArmyOption;
import armybuilder.model.i.IArmyRule;

public class Modifiers {

	public static <T extends Enum<T> & IArmyOption<T>> IArmyModifier<T> rules(IArmyRule... rules) {
		return (T o, Army a) -> Arrays.stream(rules).forEach(a::addRule);
	}

}
