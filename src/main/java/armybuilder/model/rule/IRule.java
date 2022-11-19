package armybuilder.model.rule;

import java.io.IOException;
import java.util.List;

import armybuilder.modelold.deprecated.army.rule.ArmyRuleType;

public interface IRule<T extends Enum<T> & IRule<T>> {

	@Deprecated
	List<ArmyRuleType> getTypes();

	@Deprecated
	String name();

	String getDisplayName();

	String getDescription() throws IOException;

	@Deprecated
	default boolean is(ArmyRuleType type) {
		return getTypes().contains(type);
	}

	@Deprecated
	default boolean isAll(List<ArmyRuleType> types) {
		return getTypes().containsAll(types);
	}

}
