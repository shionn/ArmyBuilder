package armybuilder.model.army.option;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import armybuilder.model.army.OldArmy;
import armybuilder.model.army.option.bataillon.Bataillon;
import armybuilder.model.unit.Unit;
import armybuilder.serialisation.ArmyOptionJsonDeserializer;

@JsonAutoDetect(fieldVisibility = Visibility.ANY, getterVisibility = Visibility.NONE)
@JsonIgnoreProperties(ignoreUnknown = true)
public class MultiOption {
	private int id;
	private ListingOption option;
	@JsonDeserialize(converter = ArmyOptionJsonDeserializer.class)
	private IListingOptionValue<?> value;

	public MultiOption() {

	}

	public MultiOption(int id, ListingOption option, IListingOptionValue<?> value) {
		this.id = id;
		this.option = option;
		this.value = value;
	}

	public int getId() {
		return id;
	}

	public ListingOption getOption() {
		return option;
	}

	public IListingOptionValue<?> getValue() {
		return value;
	}

	public String getDisplayName() {
		return value.getDisplayName();
	}

	public boolean is(ListingOption option) {
		return this.option == option;
	}

	public boolean isAvailable(OldArmy army, Unit unit) {
		return value.isAvailable(army, unit);
	}

	public List<?> getCompositions() {
		return ((Bataillon) value).getCompositions();
	}

}
