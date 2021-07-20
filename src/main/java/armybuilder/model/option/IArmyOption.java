package armybuilder.model.option;

import armybuilder.model.Army;

public interface IArmyOption<T extends Enum<T> & IArmyOption<T>> {
	String getDisplayName();

	ArmyOptionType getType();

	boolean isOptionDisplayed(Army army);

	void rebuild(Army army);
}
