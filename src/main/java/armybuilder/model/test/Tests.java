package armybuilder.model.test;

import java.util.function.Function;

import armybuilder.model.Army;
import armybuilder.model.option.Allegiance;
import armybuilder.model.option.ArmyOptionType;

public interface Tests {
	public static Function<Army, Boolean> isAllegiance(Allegiance allegiance) {
		return (Army a) -> a.getOption(ArmyOptionType.Allegiance) == allegiance;
	}
}
