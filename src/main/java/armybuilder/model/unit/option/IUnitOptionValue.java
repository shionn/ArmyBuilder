package armybuilder.model.unit.option;

import armybuilder.model.Army;
import armybuilder.model.unit.Unit;

public interface IUnitOptionValue<T extends Enum<T> & IUnitOptionValue<T>> {

	boolean isAvailable(Army army, Unit unit);

	UnitOption getOption();

	String getDisplayName();

	String name();

	void rebuild(Unit unit);

}
