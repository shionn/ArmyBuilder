package armybuilder.model.army.option;

import armybuilder.model.army.Army;
import armybuilder.model.unit.Unit;

public interface IArmyOptionValue<T extends Enum<T> & IArmyOptionValue<T>> {
	String getDisplayName();

	ArmyOption getOption();

	boolean isOptionDisplayed(Army army);

	void rebuild(Army army);

	void verify(Army army);

	boolean isAvailable(Army army, Unit unit);

}
