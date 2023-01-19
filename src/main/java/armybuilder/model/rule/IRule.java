package armybuilder.model.rule;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import armybuilder.model.IHaveDisplayName;
import armybuilder.model.unit.Unit;

public interface IRule<T extends Enum<T> & IRule<T>> extends IHaveDisplayName {

	List<RuleType> getTypes();

	String getDescription() throws IOException;

	default boolean is(RuleType type) {
		return getTypes().contains(type);
	}

	default boolean isOne(RuleType... types) {
		return Arrays.stream(types).filter(this::is).findAny().isPresent();
	}

	default void decorate(Unit unit) {
		// nothing to do
	}


}
