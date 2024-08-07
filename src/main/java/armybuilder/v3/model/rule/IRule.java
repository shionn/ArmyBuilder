package armybuilder.v3.model.rule;

import java.util.Arrays;
import java.util.List;

import armybuilder.v3.model.IHaveDisplayName;
import armybuilder.v3.model.rule.desc.Description;
import armybuilder.v3.model.unit.Unit;

public interface IRule<T extends Enum<T> & IRule<T>> extends IHaveDisplayName {

	String name();

	List<RuleType> getTypes();

	Description getDescription();

	// TODO a supprimer pour les enum ShortDescription
	@Deprecated
	default String getShortDescription() {
		return null;
	}

	default boolean is(RuleType... types) {
		return getTypes().containsAll(Arrays.asList(types));
	}

	default boolean isOne(RuleType... types) {
		return Arrays.stream(types).filter(this::is).findAny().isPresent();
	}

	default void decorate(Unit unit) {
		// nothing to do
	}
}
