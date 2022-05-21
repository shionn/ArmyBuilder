package armybuilder.model.army.option;

import armybuilder.model.army.OldArmy;
import armybuilder.model.unit.Unit;

public interface IListingOptionValue<T extends Enum<T> & IListingOptionValue<T>> {
	String getDisplayName();

	ListingOption getOption();

	boolean isOptionDisplayed(OldArmy army);

	void rebuild(OldArmy army);

	boolean isAvailable(OldArmy army, Unit unit);

}
