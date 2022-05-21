package armybuilder.model.unit.option;

import armybuilder.model.unit.Unit;

public interface IUnitOptionValue<T extends Enum<T> & IUnitOptionValue<T>> {

	boolean isAvailable(Unit unit);

	UnitOption option();

	String getDisplayName();

	@Deprecated
	default String getFullDisplayName() {
		return option().getDisplayName() + " : " + getDisplayName();
	}

	String name();

	void rebuild(Unit unit);

	default boolean is(UnitOption option) {
		return 	option() == option;
	}

}
