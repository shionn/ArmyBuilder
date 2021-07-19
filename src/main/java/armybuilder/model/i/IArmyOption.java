package armybuilder.model.i;

import armybuilder.model.Army;
import armybuilder.model.ArmyOptionType;

public interface IArmyOption<T extends Enum<T> & IArmyOption<T>> {
	String getDisplayName();

	ArmyOptionType getType();

	boolean isOptionDisplayed(Army army);

	void rebuild(Army army);
}
