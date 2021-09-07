package armybuilder.model.army.option;

import armybuilder.model.army.Army;

public interface IArmyOptionValue<T extends Enum<T> & IArmyOptionValue<T>> {
	String getDisplayName();

	ArmyOption getOption();

	boolean isOptionDisplayed(Army army);

	void rebuild(Army army);

	void verify(Army army);

}
