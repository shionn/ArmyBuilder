package armybuilder.model.unit;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.stream.Collectors;

import org.apache.commons.collections.ListUtils;

import com.fasterxml.jackson.annotation.JsonIgnore;

import armybuilder.model.army.Listing;
import armybuilder.model.army.rule.IArmyRule;
import armybuilder.model.unit.option.IUnitOptionValue;
import armybuilder.model.unit.option.OptimisationsUniverselles;
import armybuilder.model.unit.option.UnitOption;
import armybuilder.model.unit.rule.UnitRuleComparator;
import armybuilder.model.unit.weapon.IUnitWeapon;
import armybuilder.model.unit.weapon.WeaponType;

public class Unit implements Comparable<Unit> {

	private IUnitModel model;
	private Listing listing;

	private Map<UnitOption, IUnitOptionValue<?>> options = new HashMap<>();

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

	public Unit(IUnitModel model, Listing listing) {
		this.model = model;
		this.listing = listing;
	}

	public void reset() {
		rules.clear();
		rules.addAll(model.getRules());
		weapons.clear();
		weapons.addAll(model.getWeapons());
		keyWords.clear();
		keyWords.addAll(model.getKeyWords());
		roleTatciques.clear();
		roleTatciques.addAll(model.getRoleTactiques());
		points = model.getPoints();
	}

	public void rebuild() {
		options.values().stream().forEach(o -> o.rebuild(this));
		model.rebuild(this);
	}

	@Deprecated
	public List<IUnitWeapon> getWeapons(WeaponType type) {
		return weapons.stream().filter(w -> w.getType() == type).collect(Collectors.toList());
	}

	@Deprecated
	@JsonIgnore
	public ProfileDegressif getProfileDegressif() {
		return model.getProfileDegressif();
	}

	/** options */
	public List<UnitOption> getOptions() {
		return model.getOptions().stream().filter(o -> o.availableFor(this)).collect(Collectors.toList());
	}

	public List<IUnitOptionValue<?>> getOptionValues(UnitOption option) {
		@SuppressWarnings("unchecked")
		List<IUnitOptionValue<?>> values = ListUtils.union(Arrays.asList(OptimisationsUniverselles.values()),
				model.getOptionValues());
		return values.stream()
				.filter(o -> o.is(option))
				.filter(o -> o.isAvailable(this))
				.sorted((a, b) -> a.getDisplayName().compareTo(b.getDisplayName()))
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
		return getKeyWords().contains(keyWord);
	}

	/** rule */
	public void add(IArmyRule<?> rule) {
		rules.add(rule);
	}

	/** weapons */
	public void add(IUnitWeapon weapon) {
		weapons.add(weapon);
	}


	/** truc */
	@Deprecated
	public void add(KeyWord keyWord) {
		keyWords.add(keyWord);
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

	@Deprecated
	public SortedSet<IArmyRule<?>> getRules() {
		return rules;
	}


	@Deprecated
	public boolean is(IArmyRule<?> rule) {
		return rules.contains(rule);
	}

	public boolean is(IUnitModel model) {
		return this.model == model;
	}

	public void setPoints(int value) {
		this.points = value;
	}

	public int getPoints() {
		return model.getPoints();
	}

	@Override
	@Deprecated
	public int compareTo(Unit o) {
		int compare = model.getRoleTactiques().get(0).compareTo(o.model.getRoleTactiques().get(0));
		if (compare == 0) {
			compare = getDisplayName().compareTo(o.getDisplayName());
		}
		return compare;
	}

	public String getDisplayName() {
		return model.getDisplayName();
	}

	@Deprecated
	public String getMouvement() {
		return model.getProfile().getMvt();
	}

	@Deprecated
	public String getBlessures() {
		return model.getProfile().getLife();
	}

	@Deprecated
	public String getBravoure() {
		return model.getProfile().getCmd();
	}

	@Deprecated
	public String getSauvegarde() {
		return model.getProfile().getSvg();
	}

	public IUnitModel getModel() {
		return model;
	}

	@Deprecated
	public Set<KeyWord> getKeyWords() {
		return keyWords;
	}

	public Listing listing() {
		return listing;
	}

}
