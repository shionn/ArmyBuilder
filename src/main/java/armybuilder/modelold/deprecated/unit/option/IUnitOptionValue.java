package armybuilder.modelold.deprecated.unit.option;

import armybuilder.model.unit.option.UnitOptionCategory;
import armybuilder.modelold.deprecated.unit.Unit;

public interface IUnitOptionValue<T extends Enum<T> & IUnitOptionValue<T>> {

	boolean isAvailable(Unit unit);

	UnitOptionCategory option();

	String displayName();

	@Deprecated
	default String getFullDisplayName() {
		return option().displayName() + " : " + displayName();
	}

	String name();

	void rebuild(Unit unit);

	default boolean is(UnitOptionCategory option) {
		return 	option() == option;
	}

}
