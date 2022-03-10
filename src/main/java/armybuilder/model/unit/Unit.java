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

import org.apache.commons.collections.ListUtils;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import armybuilder.model.army.Army;
import armybuilder.model.army.option.DisplayUnit;
import armybuilder.model.army.option.MultiOption;
import armybuilder.model.army.rule.IArmyRule;
import armybuilder.model.unit.option.IUnitOptionValue;
import armybuilder.model.unit.option.OptimisationsUniverselles;
import armybuilder.model.unit.option.UnitOption;
import armybuilder.model.unit.option.UnitOptionType;
import armybuilder.model.unit.rule.UnitRuleComparator;
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

	private List<Integer> multiOptions = new ArrayList<>();

	@JsonIgnore
	private Set<IUnitWeapon> weapons = new TreeSet<>();
	@JsonIgnore
	private Army army;
	@JsonIgnore
	private SortedSet<IArmyRule<?>> rules = new TreeSet<>(new UnitRuleComparator());
	@JsonIgnore
	private Set<KeyWord> keyWords = new TreeSet<>();
	@JsonIgnore
	private Set<RoleTactique> roleTatciques = new TreeSet<>();
	@JsonIgnore
	private int value;

	public Unit() {
	}

	public Unit(Army army, IUnitModel model) {
		this.army = army;
		this.model = model;
	}

	public void clear() {
		rules.clear();
		rules.addAll(model.getRules());
		weapons.clear();
		weapons.addAll(model.getWeapons());
		keyWords.clear();
		keyWords.addAll(model.getKeyWords());
		roleTatciques.clear();
		roleTatciques.addAll(model.getRoleTactiques());
		value = model.getValue();
	}

	public void rebuild(Army army) {
		options.values().stream().forEach(o -> o.rebuild(this));
		model.rebuild(army, this);
		army.addRules(rules);
	}

	public void verify(Army army) {
		model.check(army, this);
	}

	public List<IUnitWeapon> getWeapons(WeaponType type) {
		return weapons.stream().filter(w -> w.getType() == type).collect(Collectors.toList());
	}

	@JsonIgnore
	public ProfileDegressif getProfileDegressif() {
		return model.getProfileDegressif();
	}

	/**
	 * options
	 */
	public List<UnitOption> getOptions() {
		return model.getOptions().stream().filter(o -> o.isAvailable(army, this))
//				.filter(o -> this.getOptionValues(o).size() > 0)
				.collect(Collectors.toList());
	}

	public void add(IUnitOptionValue<?> value) {
		add(value.getOption(), value);
	}

	public void addAll(List<? extends IUnitOptionValue<?>> values) {
		for (IUnitOptionValue<?> value : values) {
			add(value.getOption(), value);
		}
	}

	public void add(UnitOption option, IUnitOptionValue<?> value) {
		options.put(option, value);
	}

	public void add(MultiOption o) {
		multiOptions.add(o.getId());
	}

	public void remove(UnitOption option) {
		if (option.getType() == UnitOptionType.selectMultiOption) {
			// TODO a pofiné
			multiOptions.clear();
		} else {
			options.remove(option);
		}
	}

	public void remove(MultiOption option) {
		multiOptions.removeIf(i -> i == option.getId());
	}

	public List<IUnitOptionValue<?>> getOptionValues(UnitOption option) {
		@SuppressWarnings("unchecked")
		List<IUnitOptionValue<?>> values = ListUtils.union(Arrays.asList(OptimisationsUniverselles.values()),
						model.getOptionValues());
		return values.stream().filter(o -> o.getOption().isAvailable(option))
				.filter(o -> o.isAvailable(army, this))
				.sorted((a, b) -> a.getDisplayName().compareTo(b.getDisplayName()))
				.collect(Collectors.toList());
	}

	public List<MultiOption> getMultiOptionValues(UnitOption option) {
		return army.multiOptions(option).stream().filter(o -> o.isAvailable(army, this))
				.collect(Collectors.toList());
	}

	public IUnitOptionValue<?> get(UnitOption option) {
		return options.get(option);
	}

	public MultiOption getMultiOption(UnitOption option) {
		return army.multiOptions(option).stream().filter(o -> multiOptions.contains(o.getId()))
				.findFirst().orElse(null);
	}

	/**
	 * add
	 */
	public void add(IArmyRule<?> rule) {
		rules.add(rule);
	}

	public void add(KeyWord keyWord) {
		keyWords.add(keyWord);
	}

	public void add(IUnitWeapon weapon) {
		weapons.add(weapon);
	}

	public void add(RoleTactique role) {
		roleTatciques.add(role);
	}

	/**
	 * rule
	 */
	public void replaceIfExist(IArmyRule<?> rule1, IArmyRule<?> rule2) {
		if (rules.remove(rule1)) {
			add(rule2);
		}
	}

	public List<IArmyRule<?>> getDisplayedRules() {
		DisplayUnit display = army.option(DisplayUnit.Full);
		return rules.stream().filter(r -> display.display(this, r)).collect(Collectors.toList());
	}

	public SortedSet<IArmyRule<?>> getRules() {
		return rules;
	}

	/**
	 * is
	 */
	public boolean is(KeyWord keyWord) {
		return getKeyWords().contains(keyWord);
	}

	public boolean is(UnitOption opt) {
		return get(opt) != null;
	}

	public boolean is(MultiOption opt) {
		return multiOptions.contains(opt.getId());
	}

	public boolean is(IArmyRule<?> rule) {
		return rules.contains(rule);
	}

	public boolean is(IUnitModel model) {
		return this.model == model;
	}

	public boolean is(RoleTactique role) {
		return roleTatciques.contains(role);
	}

	public int getValue() {
		return value;
	}

	@Override
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

	public String getMouvement() {
		return model.getProfile().getMvt();
	}

	public String getBlessures() {
		return model.getProfile().getLife();
	}

	public String getBravoure() {
		return model.getProfile().getCmd();
	}

	public String getSauvegarde() {
		return model.getProfile().getSvg();
	}

	public IUnitModel getModel() {
		return model;
	}

	public Set<KeyWord> getKeyWords() {
		return keyWords;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public void setArmy(Army army) {
		this.army = army;
	}



}
