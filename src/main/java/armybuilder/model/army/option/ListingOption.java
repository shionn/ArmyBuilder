package armybuilder.model.army.option;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import armybuilder.model.army.Listing;

public enum ListingOption {
	SubAllegiance("Sous Allegiance", armybuilder.db.dbo.SubAllegiance.values()),
	PackDeBataille(
			"Pack de Bataille",
			armybuilder.model.army.option.PackDeBataille.values()),
	GrandeStrategie(
			"Grande Strategie",
			armybuilder.model.army.option.GrandeStrategie.values()),
	Triomphes("Triomphe", armybuilder.model.army.option.Triomphes.values());

	private String displayName;
	private List<IListingOptionValue<?>> values;

	private ListingOption(String displayName, IListingOptionValue<?>... values) {
		this.displayName = displayName;
		this.values = Arrays.asList(values);
	}

	public List<IListingOptionValue<?>> values(Listing listing) {
		return values.stream().filter(o -> o.availableFor(listing)).collect(Collectors.toList());
	}

	public String displayName() {
		return displayName;
	}

	@Deprecated
	public boolean isSelect() {
		return true;
	}

}
