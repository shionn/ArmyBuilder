package armybuilder.modelold.deprecated.unit.option;

import armybuilder.modelold.deprecated.unit.Unit;

public interface IUnitOptionValue<T extends Enum<T> & IUnitOptionValue<T>> {

	boolean isAvailable(Unit unit);

	UnitOption option();

	String displayName();

	@Deprecated
	default String getFullDisplayName() {
		return option().displayName() + " : " + displayName();
	}

	String name();

	void rebuild(Unit unit);

	default boolean is(UnitOption option) {
		return 	option() == option;
	}

}
