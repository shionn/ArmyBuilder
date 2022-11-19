package armybuilder.modelold.deprecated.army.compare;

import java.util.Comparator;

import armybuilder.modelold.deprecated.army.Listing;

public class ListingComparator implements Comparator<Listing> {

	@Override
	public int compare(Listing a, Listing b) {
		int result = Integer.compare(a.points(), b.points());
		if (result == 0) {
			result = a.displayName().compareTo(b.displayName());
		}
		return result;
	}

}