package armybuilder.modelold.deprecated.army;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import armybuilder.model.army.Allegiance;
import armybuilder.model.rule.IRule;
import armybuilder.model.unit.model.IUnitModel;
import armybuilder.model.unit.weapon.IUnitWeapon;
import armybuilder.model.unit.weapon.WeaponType;
import armybuilder.modelold.deprecated.army.compare.ListingComparator;
import armybuilder.modelold.deprecated.army.compare.UnitModelComparator;
import armybuilder.modelold.deprecated.army.compare.UnitRuleComparator;
import armybuilder.modelold.deprecated.army.compare.UnitWeaponComparator;
import armybuilder.modelold.deprecated.army.option.IListingOptionValue;
import armybuilder.modelold.deprecated.army.option.ListingOption;
import armybuilder.modelold.deprecated.army.option.bataillon.Bataillon;
import armybuilder.modelold.deprecated.army.rule.ArmyRuleType;
import armybuilder.modelold.deprecated.unit.KeyWord;

/**
 * point d'acces root à une amree multi list
 */
@JsonAutoDetect(fieldVisibility = Visibility.ANY, getterVisibility = Visibility.NONE)
@JsonIgnoreProperties(ignoreUnknown = true)
public class OldArmy {

	private Allegiance allegiance;
	private List<Listing> listings = new ArrayList<>();
	
	public OldArmy() {
		// constructeur vide pour la deserialisation
	}

	public OldArmy(Allegiance allegiance) {
		this.allegiance = allegiance;
	}

	public void rebuild() {
		listings.stream().forEach(l -> l.rebuild());
	}

	/** allegiance **/
	public boolean is(Allegiance allegiance) {
		return this.allegiance == allegiance;
	}

	public Allegiance allegiance() {
		return allegiance;
	}

	/** options **/
	public List<Bataillon> bataillons() {
		return listings.stream().flatMap(l -> l.bataillons().stream()).distinct().sorted().collect(Collectors.toList());
	}

	public List<IListingOptionValue<?>> options(ListingOption type) {
		return listings.stream()
				.map(l -> l.get(type))
				.filter(Objects::nonNull)
				.distinct()
				.sorted((a, b) -> a.getDisplayName().compareTo(b.getDisplayName()))
				.collect(Collectors.toList());
	}

	/** rules **/
	public List<IRule<?>> rules(ArmyRuleType types) {
		return listings.stream().flatMap(l -> l.rules(types).stream()).distinct().collect(Collectors.toList());
	}

	public List<IRule<?>> rules(List<ArmyRuleType> types) {
		return listings.stream().flatMap(l -> l.rules(types).stream()).distinct().collect(Collectors.toList());
	}

	/** listing **/
	public void add(Listing listing) {
		listings.add(listing);
	}

	public void rm(Listing listing) {
		listings.remove(listing);
	}

	public List<Listing> listings() {
		return listings.stream().sorted(new ListingComparator()).collect(Collectors.toList());
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

	public List<IUnitModel> units(IRule<?> rule) {
		return listings.stream()
				.flatMap(l -> l.units(rule).stream())
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
				.sorted(new UnitWeaponComparator())
				.collect(Collectors.toList());
	}

	public List<IRule<?>> rules(IUnitModel model) {
		return listings.stream()
				.flatMap(l -> l.units(model).stream())
				.flatMap(u -> u.rules().stream())
				.distinct()
				.sorted(new UnitRuleComparator())
				.collect(Collectors.toList());
	}

	public List<KeyWord> keyWords(IUnitModel model) {
		return listings.stream()
				.flatMap(l -> l.units(model).stream())
				.flatMap(u -> u.keyWords().stream())
				.distinct()
				.sorted()
				.collect(Collectors.toList());

	}

	/** getters **/
	public String getDisplayName() {
		return allegiance.getDisplayName();
	}

}
