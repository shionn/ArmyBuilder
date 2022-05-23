package armybuilder.model.army.rule;

import java.io.IOException;
import java.util.List;

public interface IArmyRule<T extends Enum<T> & IArmyRule<T>> {

	List<ArmyRuleType> getTypes();

	String name();

	String displayName();

	String getDescription() throws IOException;

	default boolean is(ArmyRuleType type) {
		return getTypes().contains(type);
	}

	default boolean isAll(List<ArmyRuleType> types) {
		return getTypes().containsAll(types);
	}

}
