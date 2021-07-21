package armybuilder.model.modifier;

import java.util.Arrays;

import armybuilder.model.Army;
import armybuilder.model.option.IArmyOptionValue;
import armybuilder.model.rule.IArmyRule;

public class Modifiers {

	public static <T extends Enum<T> & IArmyOptionValue<T>> IArmyModifier<T> rules(IArmyRule... rules) {
		return (Army a) -> Arrays.stream(rules).forEach(a::addRule);
	}

	public static <T extends Enum<T> & IArmyOptionValue<T>> IArmyModifier<T> add(
			@SuppressWarnings("unchecked") IArmyModifier<T>... modifiers) {
		return (Army a) -> Arrays.stream(modifiers).forEach(m -> m.accept(a));
	}

}
