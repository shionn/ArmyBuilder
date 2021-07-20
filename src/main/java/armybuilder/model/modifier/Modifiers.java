package armybuilder.model.modifier;

import java.util.Arrays;

import armybuilder.model.Army;
import armybuilder.model.option.IArmyOption;
import armybuilder.model.rule.IArmyRule;

public class Modifiers {

	public static <T extends Enum<T> & IArmyOption<T>> IArmyModifier<T> rules(IArmyRule... rules) {
		return (T o, Army a) -> Arrays.stream(rules).forEach(a::addRule);
	}

	public static <T extends Enum<T> & IArmyOption<T>> IArmyModifier<T> add(
			@SuppressWarnings("unchecked") IArmyModifier<T>... modifiers) {
		return (T o, Army a) -> Arrays.stream(modifiers).forEach(m -> m.accept(o, a));
	}

}
