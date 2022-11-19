package armybuilder.modelold.deprecated.army.option;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import armybuilder.modelold.deprecated.army.Listing;

public enum ListingOption {
	SubAllegiance("Sous Allegiance", armybuilder.model.army.SubAllegiance.values()),
	PackDeBataille(
			"Pack de Bataille",
			armybuilder.modelold.deprecated.army.option.PackDeBataille.values()),
	GrandeStrategie(
			"Grande Strategie",
			armybuilder.modelold.deprecated.army.option.GrandeStrategie.values()),
	Triomphes("Triomphe", armybuilder.modelold.deprecated.army.option.Triomphes.values());

	private String displayName;
	private List<IListingOptionValue<?>> values;

	private ListingOption(String displayName, IListingOptionValue<?>... values) {
		this.displayName = displayName;
		this.values = Arrays.asList(values);
	}

	public List<IListingOptionValue<?>> values(Listing listing) {
		return values.stream().filter(o -> o.availableFor(listing)).collect(Collectors.toList());
	}

	public String getDisplayName() {
		return displayName;
	}

	@Deprecated
	public boolean isSelect() {
		return true;
	}

}
