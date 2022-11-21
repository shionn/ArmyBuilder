package armybuilder.model.rule;

import java.io.IOException;
import java.util.List;

import armybuilder.model.IHaveDisplayName;

public interface IRule<T extends Enum<T> & IRule<T>> extends IHaveDisplayName {

	List<RuleType> getTypes();

	String getDescription() throws IOException;

	default boolean is(RuleType type) {
		return getTypes().contains(type);
	}

	@Deprecated
	default boolean isAll(List<RuleType> types) {
		return getTypes().containsAll(types);
	}

}
