package armybuilder.model.army.rule;

import java.io.IOException;
import java.util.List;

import armybuilder.model.army.OldArmy;

public interface IArmyRule<T extends Enum<T> & IArmyRule<T>> {

	List<ArmyRuleType> getTypes();

	String name();

	String displayName();

	String getDescription() throws IOException;

	default boolean is(ArmyRuleType type) {
		return getTypes().contains(type);
	}

	void rebuild(OldArmy army);

}
