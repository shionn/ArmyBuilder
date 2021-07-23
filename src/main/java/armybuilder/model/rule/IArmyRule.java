package armybuilder.model.rule;

import java.io.IOException;
import java.util.List;

public interface IArmyRule<T extends Enum<T> & IArmyRule<T>> {

	List<ArmyRuleType> getTypes();

	String name();

	String getDisplayName();

	String getDescription() throws IOException;

	default boolean is(ArmyRuleType type) {
		return getTypes().contains(type);
	}
}
