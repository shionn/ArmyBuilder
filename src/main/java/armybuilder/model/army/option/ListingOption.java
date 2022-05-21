package armybuilder.model.army.option;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import armybuilder.model.army.OldArmy;

public enum ListingOption {
	SubAllegiance("Sous Allegiance", armybuilder.model.army.option.SubAllegiance.values()),
	PackDeBataille(
			"Pack de Bataille",
			armybuilder.model.army.option.PackDeBataille.values()),
	GrandeStrategie(
			"Grande Strategie",
			armybuilder.model.army.option.GrandeStrategie.values()),
	Triomphes("Triomphe", armybuilder.model.army.option.Triomphes.values()),
	Bataillon("Bataillon", armybuilder.model.army.option.bataillon.Bataillon.values());

	private String displayName;
	private List<IListingOptionValue<?>> values;

	private ListingOption(String displayName, IListingOptionValue<?>... values) {
		this.displayName = displayName;
		this.values = Arrays.asList(values);
	}

	@Deprecated
	public List<IListingOptionValue<?>> getValues(OldArmy army) {
		return values.stream().filter(o -> o.isOptionDisplayed(army)).collect(Collectors.toList());
	}

	@Deprecated
	public String getDisplayName() {
		return displayName;
	}

	@Deprecated
	public boolean isSelect() {
		return true;
	}

}
