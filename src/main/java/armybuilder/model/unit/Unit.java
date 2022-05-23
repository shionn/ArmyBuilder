package armybuilder.model.unit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import armybuilder.model.army.Listing;
import armybuilder.model.army.compare.UnitRuleComparator;
import armybuilder.model.army.rule.IArmyRule;
import armybuilder.model.unit.option.IUnitOptionValue;
import armybuilder.model.unit.option.OptimisationsUniverselles;
import armybuilder.model.unit.option.UnitOption;
import armybuilder.model.unit.weapon.IUnitWeapon;
import armybuilder.model.unit.weapon.WeaponType;
import armybuilder.serialisation.UnitModelJsonDeserializer;
import armybuilder.serialisation.UnitOptionJsonDeserializer;

@JsonAutoDetect(fieldVisibility = Visibility.ANY, getterVisibility = Visibility.NONE)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Unit implements Comparable<Unit> {

	@JsonDeserialize(converter = UnitModelJsonDeserializer.class)
	private IUnitModel model;
	@JsonDeserialize(contentConverter = UnitOptionJsonDeserializer.class)
	private Map<UnitOption, IUnitOptionValue<?>> options = new HashMap<>();

	@JsonIgnore
	private Listing listing;

	@JsonIgnore
	private Set<KeyWord> keyWords = new TreeSet<>();
	@JsonIgnore
	private Set<IUnitWeapon> weapons = new TreeSet<>();
	@JsonIgnore
	private SortedSet<IArmyRule<?>> rules = new TreeSet<>(new UnitRuleComparator());
	@JsonIgnore
	private Set<RoleTactique> roleTatciques = new TreeSet<>();
	@JsonIgnore
	private int points;

	public Unit() {
		// constructeur vide pour la deserialisation
	}
	public Unit(IUnitModel model, Listing listing) {
		this.model = model;
		this.listing = listing;
	}

	public void reset() {
		rules.clear();
		rules.addAll(model.rules());
		weapons.clear();
		weapons.addAll(model.weapons());
		keyWords.clear();
		keyWords.addAll(model.keyWords());
		roleTatciques.clear();
		roleTatciques.addAll(model.roleTactiques());
		points = model.points();
	}

	public void rebuild() {
		options.values().stream().forEach(o -> o.rebuild(this));
		model.rebuild(this);
	}

	/** options */
	public List<UnitOption> options() {
		return model.options().stream().filter(o -> o.availableFor(this)).collect(Collectors.toList());
	}

	public List<IUnitOptionValue<?>> optionValues(UnitOption option) {
		List<IUnitOptionValue<?>> values = new ArrayList<IUnitOptionValue<?>>(model.optionValues());
		values.addAll(Arrays.asList(OptimisationsUniverselles.values()));
		values.addAll(listing.bataillons());
		return values.stream()
				.filter(o -> o.is(option))
				.filter(o -> o.isAvailable(this))
				.sorted((a, b) -> a.displayName().compareTo(b.displayName()))
				.collect(Collectors.toList());
	}

	public void add(IUnitOptionValue<?> value) {
		add(value.option(), value);
	}

	public void add(UnitOption option, IUnitOptionValue<?> value) {
		options.put(option, value);
	}

	public void remove(UnitOption option) {
		options.remove(option);
	}

	public boolean is(UnitOption opt) {
		return get(opt) != null;
	}

	public IUnitOptionValue<?> get(UnitOption option) {
		return options.get(option);
	}

	/** role */
	public void add(RoleTactique role) {
		roleTatciques.add(role);
	}

	public boolean is(RoleTactique role) {
		return roleTatciques.contains(role);
	}

	/** keyword */
	public boolean is(KeyWord keyWord) {
		return keyWords.contains(keyWord);
	}

	/** rule */
	public void add(IArmyRule<?> rule) {
		rules.add(rule);
	}

	public boolean is(IArmyRule<?> rule) {
		return rules.contains(rule);
	}

	/** weapons */
	public void add(IUnitWeapon weapon) {
		weapons.add(weapon);
	}

	public List<IUnitWeapon> weapons(WeaponType type) {
		return weapons.stream().filter(w -> w.getType() == type).collect(Collectors.toList());
	}

	/** keyWords */
	public void add(KeyWord keyWord) {
		keyWords.add(keyWord);
	}

	public Set<KeyWord> keyWords() {
		return keyWords;
	}

	/**
	 * rule
	 */
	@Deprecated
	public void replaceIfExist(IArmyRule<?> rule1, IArmyRule<?> rule2) {
		if (rules.remove(rule1)) {
			add(rule2);
		}
	}

	public SortedSet<IArmyRule<?>> rules() {
		return rules;
	}

	public boolean is(IUnitModel model) {
		return this.model == model;
	}

	public void points(int value) {
		this.points = value;
	}

	public int points() {
		return points;
	}

	@Override
	@Deprecated
	public int compareTo(Unit o) {
		int compare = model.roleTactiques().get(0).compareTo(o.model.roleTactiques().get(0));
		if (compare == 0) {
			compare = getDisplayName().compareTo(o.getDisplayName());
		}
		return compare;
	}

	public String getDisplayName() {
		return model.displayName();
	}

	public IUnitModel model() {
		return model;
	}

	public Listing listing() {
		return listing;
	}

	public void listing(Listing listing) {
		this.listing = listing;
	}

}
