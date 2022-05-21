package armybuilder.model.army.option;

import armybuilder.model.army.Listing;
import armybuilder.model.army.OldArmy;

public interface IListingOptionValue<T extends Enum<T> & IListingOptionValue<T>> {
	@Deprecated
	String displayName();

	ListingOption option();

	@Deprecated
	boolean isOptionDisplayed(OldArmy army);

	void rebuild(Listing listing);

	boolean availableFor(Listing listing);

}
