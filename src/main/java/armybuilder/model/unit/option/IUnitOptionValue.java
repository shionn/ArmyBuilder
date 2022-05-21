package armybuilder.model.unit.option;

import armybuilder.model.unit.Unit;

public interface IUnitOptionValue<T extends Enum<T> & IUnitOptionValue<T>> {

	boolean isAvailable(Unit unit);

	UnitOption option();

	@Deprecated
	String getDisplayName();

	@Deprecated
	default String getFullDisplayName() {
		return option().getDisplayName() + " : " + getDisplayName();
	}

	@Deprecated
	String name();

	void rebuild(Unit unit);

	default boolean is(UnitOption option) {
		return 	option() == option;
	}

//	@Deprecated
//	default Set<IArmyRule<?>> getDisplayedRules() {
//		Unit fake = new Unit();
//		this.rebuild(fake);
//		return fake.getRules();
//	}
}
