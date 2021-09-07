package armybuilder.model.army.rule;

import java.io.IOException;
import java.util.List;

import armybuilder.model.army.Army;

public interface IArmyRule<T extends Enum<T> & IArmyRule<T>> {

	List<ArmyRuleType> getTypes();

	String name();

	String getDisplayName();

	String getDescription() throws IOException;

	default boolean is(ArmyRuleType type) {
		return getTypes().contains(type);
	}

	void rebuild(Army army);

}
