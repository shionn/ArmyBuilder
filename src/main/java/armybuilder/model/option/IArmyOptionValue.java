package armybuilder.model.option;

import armybuilder.model.Army;

public interface IArmyOptionValue<T extends Enum<T> & IArmyOptionValue<T>> {
	String getDisplayName();

	ArmyOption getOption();

	boolean isOptionDisplayed(Army army);

	void rebuild(Army army);

	void verify(Army army);

}
