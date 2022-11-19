package armybuilder.model.army.rule;

import java.io.IOException;
import java.util.List;

public interface IRule<T extends Enum<T> & IRule<T>> {

	@Deprecated
	List<ArmyRuleType> getTypes();

	@Deprecated
	String name();

	String displayName();

	String description() throws IOException;

	@Deprecated
	default boolean is(ArmyRuleType type) {
		return getTypes().contains(type);
	}

	@Deprecated
	default boolean isAll(List<ArmyRuleType> types) {
		return getTypes().containsAll(types);
	}

}
