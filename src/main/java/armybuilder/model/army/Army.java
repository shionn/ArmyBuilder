package armybuilder.model.army;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import armybuilder.model.army.compare.UnitModelComparator;
import armybuilder.model.army.option.Allegiance;
import armybuilder.model.army.option.SubAllegiance;
import armybuilder.model.unit.IUnitModel;
import armybuilder.model.unit.weapon.IUnitWeapon;
import armybuilder.model.unit.weapon.WeaponType;

/**
 * point d'acces root à une amree multi list
 */
public class Army {
	private Allegiance allegiance;

	private List<Listing> listings = new ArrayList<>();
	
	public Army(Allegiance allegiance) {
		this.allegiance = allegiance;
	}

	public void rebuild() {
		listings.stream().forEach(l -> l.rebuild());
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

	/** listing **/
	public void add(Listing listing) {
		listings.add(listing);
	}

	public List<Listing> listings() {
		return listings;
	}

	public Listing listing(int id) {
		return listings.stream().filter(l -> l.is(id)).findFirst().get();
	}

	/** units **/
	public List<IUnitModel> units() {
		return listings.stream()
				.flatMap(l -> l.units().stream())
				.map(u -> u.model())
				.distinct()
				.sorted(new UnitModelComparator())
				.collect(Collectors.toList());
	}

	public List<IUnitWeapon> weapons(IUnitModel model, WeaponType type) {
		return listings.stream()
				.flatMap(l -> l.units(model).stream())
				.flatMap(u -> u.weapons(type).stream())
				.distinct()
				.toList();
	}


}
