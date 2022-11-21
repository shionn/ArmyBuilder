package armybuilder.modelold.deprecated.army;

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

import armybuilder.model.army.Allegiance;
import armybuilder.model.army.SubAllegiance;
import armybuilder.model.rule.RuleType;
import armybuilder.model.rule.GeneriqueRule;
import armybuilder.model.rule.IRule;
import armybuilder.model.unit.keyword.KeyWord;
import armybuilder.model.unit.model.IUnitModel;
import armybuilder.model.unit.role.RoleTactique;
import armybuilder.modelold.deprecated.army.compare.UnitComparator;
import armybuilder.modelold.deprecated.army.compare.UnitModelComparator;
import armybuilder.modelold.deprecated.army.option.IListingOptionValue;
import armybuilder.modelold.deprecated.army.option.ListingOption;
import armybuilder.modelold.deprecated.army.option.bataillon.Bataillon;
import armybuilder.modelold.deprecated.unit.Unit;
import armybuilder.modelold.deprecated.unit.option.UnitOption;
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
	private Set<IRule<?>> rules = new LinkedHashSet<>();

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
		Arrays.stream(GeneriqueRule.values()).forEach(r -> r.rebuild(this));
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

	public long count(Bataillon bataillon) {
		return bataillons.stream().filter(b -> b == bataillon).count();
	}

	/** rules **/
	public Set<IRule<?>> rules() {
		return rules;
	}

	public List<IRule<?>> rules(RuleType type) {
		List<IRule<?>> results = new ArrayList<IRule<?>>();
		rules.stream().filter(r -> r.is(type)).forEach(r -> results.add(r));
		units.stream()
				.flatMap(u -> u.rules().stream())
				.distinct()
				.filter(r -> r.is(type))
				.forEach(r -> results.add(r));
		return results;
	}

	public List<IRule<?>> rules(List<RuleType> types) {
		List<IRule<?>> results = new ArrayList<IRule<?>>();
		rules.stream().filter(r -> r.isAll(types)).forEach(r->results.add(r));
		units.stream()
				.flatMap(u -> u.rules().stream())
				.distinct()
				.filter(r -> r.isAll(types))
				.forEach(r -> results.add(r));
		return results;
	}

	public void addIf(boolean condition, IRule<?>... rules) {
		if (condition) {
			this.rules.addAll(Arrays.asList(rules));
		}
	}
	public void add(IRule<?>... rules) {
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

	public List<Unit> units(IRule<?> rule) {
		return units.stream().filter(u -> u.is(rule)).distinct().collect(Collectors.toList());
	}

	public List<Unit> units(IUnitModel model) {
		return units.stream().filter(u -> u.is(model)).sorted(new UnitComparator()).collect(Collectors.toList());
	}

	public List<Unit> units(KeyWord keyword) {
		return units.stream().filter(u -> u.is(keyword)).sorted(new UnitComparator()).collect(Collectors.toList());
	}

	public List<Unit> units(RoleTactique role) {
		return units.stream().filter(u -> u.is(role)).collect(Collectors.toList());
	}

	public int count(KeyWord keyWord) {
		return units(keyWord).size();
	}

	public void remove(Unit u) {
		this.units.remove(u);
	}

	public Unit unit(UnitOption option) {
		return this.units.stream().filter(u -> u.is(option)).findFirst().orElse(null);
	}

	/** getters */
	public String displayName() {
		return subAllegiance().getDisplayName();
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
