package armybuilder.model.army;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import armybuilder.model.army.compare.UnitModelComparator;
import armybuilder.model.army.option.Allegiance;
import armybuilder.model.army.option.SubAllegiance;
import armybuilder.model.army.rule.IArmyRule;
import armybuilder.model.unit.IUnitModel;
import armybuilder.model.unit.KeyWord;
import armybuilder.model.unit.weapon.IUnitWeapon;
import armybuilder.model.unit.weapon.WeaponType;

/**
 * point d'acces root à une amree multi list
 */
public class Army {
	private Allegiance allegiance;

	private List<Listing> listings = new ArrayList<>();
	private Set<IArmyRule<?>> rules = new LinkedHashSet<>();
	
	public Army(Allegiance allegiance) {
		this.allegiance = allegiance;
	}

	public void rebuild() {
		this.rules.clear();
		this.allegiance.rebuild(this);
		this.listings.stream().forEach(l -> l.rebuild());
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

	/** rules **/
	public IArmyRule<?> rules() {
		return rules();
	}

	public void addRules(IArmyRule<?>... rules) {
		this.rules.addAll(Arrays.asList(rules));
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

	public List<IArmyRule<?>> rules(IUnitModel model) {
		return listings.stream()
				.flatMap(l -> l.units(model).stream())
				.flatMap(u -> u.rules().stream())
				.distinct()
				.toList();
	}

	public List<KeyWord> keyWords(IUnitModel model) {
		return listings.stream()
				.flatMap(l -> l.units(model).stream())
				.flatMap(u -> u.keyWords().stream())
				.distinct()
				.toList();

	}

}
