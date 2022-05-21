package armybuilder.model.army.option;

import armybuilder.model.army.OldArmy;
import armybuilder.model.unit.Unit;

public interface IArmyOptionValue<T extends Enum<T> & IArmyOptionValue<T>> {
	String getDisplayName();

	ArmyOption getOption();

	boolean isOptionDisplayed(OldArmy army);

	void rebuild(OldArmy army);

	void verify(OldArmy army);

	boolean isAvailable(OldArmy army, Unit unit);

}
