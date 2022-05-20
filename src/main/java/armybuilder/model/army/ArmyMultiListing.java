package armybuilder.model.army;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import armybuilder.model.army.option.Allegiance;
import armybuilder.model.army.option.SubAllegiance;

/**
 * point d'acces root à une amree multi list
 */
public class ArmyMultiListing {
	private Allegiance allegiance;

	private List<ArmyListing> listings = new ArrayList<>();
	
	public ArmyMultiListing(Allegiance allegiance) {
		this.allegiance = allegiance;
	}

	/** listing **/
	public void add(ArmyListing listing) {
		listings.add(listing);
	}

	public List<ArmyListing> getListings() {
		return listings;
	}

	public ArmyListing listing(int id) {
		return listings.stream().filter(l -> l.is(id)).findFirst().get();
	}

	/** allegiance **/
	public boolean is(Allegiance allegiance) {
		return this.allegiance == allegiance;
	}

	/** suballegiance **/
	public List<SubAllegiance> getAvailableSubAllegiance() {
		return Arrays.stream(SubAllegiance.values()).filter(s -> s.availableFor(this)).collect(Collectors.toList());
	}

	public String getDisplayName() {
		return allegiance.getDisplayName();
	}

}
