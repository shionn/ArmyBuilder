package armybuilder.model.army.option;

import armybuilder.model.army.Listing;

public interface IListingOptionValue<T extends Enum<T> & IListingOptionValue<T>> {
	String displayName();

	ListingOption option();

	void rebuild(Listing listing);

	boolean availableFor(Listing listing);

}
