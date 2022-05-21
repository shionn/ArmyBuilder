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
public class Army {
	private Allegiance allegiance;

	private List<Listing> listings = new ArrayList<>();
	
	public Army(Allegiance allegiance) {
		this.allegiance = allegiance;
	}

	/** listing **/
	public void add(Listing listing) {
		listings.add(listing);
	}

	public List<Listing> getListings() {
		return listings;
	}

	public Listing listing(int id) {
		return listings.stream().filter(l -> l.is(id)).findFirst().get();
	}

	/** allegiance **/
	public boolean is(Allegiance allegiance) {
		return this.allegiance == allegiance;
	}

	public Allegiance getAllegiance() {
		return allegiance;
	}

	/** suballegiance **/
	public List<SubAllegiance> getAvailableSubAllegiance() {
		return Arrays.stream(SubAllegiance.values()).filter(s -> s.availableFor(this)).collect(Collectors.toList());
	}

	public String getDisplayName() {
		return allegiance.getDisplayName();
	}

}
