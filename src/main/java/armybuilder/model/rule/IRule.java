package armybuilder.model.rule;

import java.util.Arrays;
import java.util.List;

import armybuilder.model.IHaveDisplayName;
import armybuilder.model.unit.Unit;

public interface IRule<T extends Enum<T> & IRule<T>> extends IHaveDisplayName {

	String name();

	List<RuleType> getTypes();

	String getDescription();

	// TODO a supprimer pou l'enum ShortDescription
	@Deprecated
	default String getShortDescription() {
		return null;
	}

	default boolean is(RuleType type) {
		return getTypes().contains(type);
	}

	default boolean isOne(RuleType... types) {
		return Arrays.stream(types).filter(this::is).findAny().isPresent();
	}

	default void decorate(Unit unit) {
		// nothing to do
	}

	public static ShortDescriptionBuilder sh() {
		return new ShortDescriptionBuilder();
	}

}
