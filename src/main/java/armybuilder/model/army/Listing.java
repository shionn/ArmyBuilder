package armybuilder.model.army;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import armybuilder.model.army.compare.UnitComparator;
import armybuilder.model.army.compare.UnitModelComparator;
import armybuilder.model.army.option.Allegiance;
import armybuilder.model.army.option.IListingOptionValue;
import armybuilder.model.army.option.ListingOption;
import armybuilder.model.army.option.SubAllegiance;
import armybuilder.model.army.option.bataillon.Bataillon;
import armybuilder.model.army.rule.ArmyRuleType;
import armybuilder.model.army.rule.IArmyRule;
import armybuilder.model.unit.IUnitModel;
import armybuilder.model.unit.Unit;
import armybuilder.model.unit.option.UnitOption;
import armybuilder.serialisation.ListingOptionValueJsonDeserializer;

@JsonAutoDetect(fieldVisibility = Visibility.ANY, getterVisibility = Visibility.NONE)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Listing {

	private int id;
	@JsonDeserialize(contentConverter = ListingOptionValueJsonDeserializer.class)
	private Map<ListingOption, IListingOptionValue<?>> options = new HashMap<>();
	private List<Unit> units = new ArrayList<Unit>();
	private List<Bataillon> bataillons = new ArrayList<Bataillon>();

	@JsonIgnore
	private Set<IArmyRule<?>> rules = new LinkedHashSet<>();

	public Listing() {
		// constructeur vide pour la deserialisation
	}

	public Listing(int id, SubAllegiance subAllegiance) {
		this.id = id;
		set(subAllegiance);
	}

	public void rebuild() {
		rules.clear();
		units.stream().forEach(u -> u.reset());
		options.values().stream().forEach(o -> o.rebuild(this));
		units.stream().forEach(u -> u.rebuild());
	}

	/** options */
	public List<ListingOption> options() {
		return Arrays.asList(ListingOption.values());
	}

	public IListingOptionValue<?> get(ListingOption type) {
		return this.options.get(type);
	}

	public void set(IListingOptionValue<?> value) {
		this.options.put(value.option(), value);
	}

	public boolean is(IListingOptionValue<?> value) {
		return this.options.get(value.option()) == value;
	}

	public SubAllegiance subAllegiance() {
		return (SubAllegiance) this.options.get(ListingOption.SubAllegiance);
	}

	public boolean is(Allegiance allegiance) {
		return subAllegiance().allegiance() == allegiance;
	}

	/** bataillon */
	public List<Bataillon> availableBataillon() {
		return Arrays.stream(Bataillon.values()).filter(b -> b.isAvailable(this)).collect(Collectors.toList());
	}

	public List<Bataillon> bataillons() {
		return bataillons;
	}

	public void add(Bataillon bataillon) {
		bataillons.add(bataillon);
	}

	public void rm(Bataillon bataillon) {
		bataillons.remove(bataillon);
	}

	/** rules **/
	public Set<IArmyRule<?>> rules() {
		return rules;
	}

	public List<IArmyRule<?>> rules(ArmyRuleType type) {
		return rules.stream().filter(r -> r.is(type)).collect(Collectors.toList());
	}

	public void add(IArmyRule<?>... rules) {
		this.rules.addAll(Arrays.asList(rules));
	}

	/** units **/
	public List<IUnitModel> getAvailableUnitChoice() {
		return subAllegiance().allegiance()
				.units()
				.stream()
				.filter(u -> u.availableFor(this))
				.sorted(new UnitModelComparator())
				.collect(Collectors.toList());
	}

	public boolean have(IUnitModel unit) {
		return units.stream().filter(u -> u.is(unit)).findFirst().isPresent();
	}

	public void add(Unit unit) {
		this.units.add(unit);
	}

	public List<Unit> units() {
		return units.stream().sorted(new UnitComparator()).collect(Collectors.toList());
	}

	public List<Unit> units(IUnitModel model) {
		return units.stream().filter(u -> u.is(model)).sorted(new UnitComparator()).collect(Collectors.toList());
	}

	public void remove(Unit u) {
		this.units.remove(u);
	}

	public Unit unit(UnitOption option) {
		return this.units.stream().filter(u -> u.is(option)).findFirst().orElse(null);
	}

	/** getters */
	public String displayName() {
		return subAllegiance().displayName();
	}

	public int points() {
		return units.stream().collect(Collectors.summingInt(u -> u.points()));
	}

	public int getId() {
		return id;
	}

	public boolean is(int id) {
		return this.id == id;
	}


}
