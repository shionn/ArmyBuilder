package armybuilder.model.army;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import armybuilder.model.army.compare.UnitModelComparator;
import armybuilder.model.army.compare.UnitRuleComparator;
import armybuilder.model.army.compare.UnitWeaponComparator;
import armybuilder.model.army.option.Allegiance;
import armybuilder.model.army.option.SubAllegiance;
import armybuilder.model.army.option.bataillon.Bataillon;
import armybuilder.model.army.rule.ArmyRuleType;
import armybuilder.model.army.rule.IArmyRule;
import armybuilder.model.unit.IUnitModel;
import armybuilder.model.unit.KeyWord;
import armybuilder.model.unit.weapon.IUnitWeapon;
import armybuilder.model.unit.weapon.WeaponType;

/**
 * point d'acces root à une amree multi list
 */
@JsonAutoDetect(fieldVisibility = Visibility.ANY, getterVisibility = Visibility.NONE)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Army {

	private Allegiance allegiance;
	private List<Listing> listings = new ArrayList<>();
	
	public Army() {
		// constructeur vide pour la deserialisation
	}

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

	public Allegiance allegiance() {
		return allegiance;
	}

	/** suballegiance **/
	public String getDisplayName() {
		return allegiance.getDisplayName();
	}

	public List<SubAllegiance> subAllegiences() {
		return listings.stream()
				.map(l -> l.subAllegiance())
				.sorted((a, b) -> a.displayName().compareTo(b.displayName()))
				.distinct()
				.collect(Collectors.toList());
	}

	/** bataillon */
	public List<Bataillon> bataillons() {
		return listings.stream().flatMap(l -> l.bataillons().stream()).distinct().sorted().collect(Collectors.toList());
	}

	/** rules **/
	public List<IArmyRule<?>> rules(ArmyRuleType type) {
		return listings.stream().flatMap(l -> l.rules(type).stream()).distinct().collect(Collectors.toList());
	}

	/** listing **/
	public void add(Listing listing) {
		listings.add(listing);
	}

	public void rm(Listing listing) {
		listings.remove(listing);
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
				.sorted(new UnitWeaponComparator())
				.collect(Collectors.toList());
	}

	public List<IArmyRule<?>> rules(IUnitModel model) {
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

}
