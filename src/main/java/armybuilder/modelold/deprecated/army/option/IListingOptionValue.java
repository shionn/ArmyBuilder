package armybuilder.modelold.deprecated.army.option;

import armybuilder.modelold.deprecated.army.Listing;

public interface IListingOptionValue<T extends Enum<T> & IListingOptionValue<T>> {
	String getDisplayName();

	ListingOption option();

	void rebuild(Listing listing);

	boolean availableFor(Listing listing);

}
