package armybuilder.model.army.option;

import armybuilder.model.army.Listing;
import armybuilder.model.army.OldArmy;
import armybuilder.model.unit.Unit;

public interface IListingOptionValue<T extends Enum<T> & IListingOptionValue<T>> {
	@Deprecated
	String displayName();

	ListingOption option();

	@Deprecated
	boolean isOptionDisplayed(OldArmy army);

	void rebuild(Listing listing);

	@Deprecated
	void rebuild(OldArmy listing);

	@Deprecated
	boolean isAvailable(OldArmy army, Unit unit);

}
