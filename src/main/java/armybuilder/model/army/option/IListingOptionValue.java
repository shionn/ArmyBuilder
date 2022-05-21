package armybuilder.model.army.option;

import armybuilder.model.army.OldArmy;
import armybuilder.model.unit.Unit;

public interface IListingOptionValue<T extends Enum<T> & IListingOptionValue<T>> {
	@Deprecated
	String getDisplayName();

	@Deprecated
	ListingOption getOption();

	@Deprecated
	boolean isOptionDisplayed(OldArmy army);

	@Deprecated
	void rebuild(OldArmy army);

	@Deprecated
	boolean isAvailable(OldArmy army, Unit unit);

}
