package armybuilder.model.unit;

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
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import armybuilder.model.Army;
import armybuilder.model.rule.IArmyRule;
import armybuilder.model.serialisation.UnitModelJsonDeserializer;
import armybuilder.model.serialisation.UnitOptionJsonDeserializer;
import armybuilder.model.unit.option.IUnitOptionValue;
import armybuilder.model.unit.option.UnitOption;
import armybuilder.model.unit.weapon.IUnitWeapon;
import armybuilder.model.unit.weapon.WeaponType;

@JsonAutoDetect(fieldVisibility = Visibility.ANY, getterVisibility = Visibility.NONE)
public class Unit implements Comparable<Unit> {

	@JsonDeserialize(converter = UnitModelJsonDeserializer.class)
	private IUnitModel model;
	@JsonDeserialize(contentConverter = UnitOptionJsonDeserializer.class)
	private Map<UnitOption, IUnitOptionValue<?>> options = new HashMap<UnitOption, IUnitOptionValue<?>>();

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

	public List<UnitOption> getOptions() {
		return model.getOptions().stream().filter(o -> o.isAvailable(this))
				.filter(o -> this.getOptionValues(o).size() > 0)
				.collect(Collectors.toList());
	}

	public void addOption(UnitOption option, IUnitOptionValue<?> value) {
		options.put(option, value);
	}

	public void removeOption(UnitOption option) {
		options.remove(option);
	}

	public List<IUnitOptionValue<?>> getOptionValues(UnitOption option) {
		return model.getOptionValues().stream().filter(o -> o.getOption() == option)
				.filter(o -> o.isAvailable(army, this))
				.sorted((a, b) -> a.getDisplayName().compareTo(b.getDisplayName()))
				.collect(Collectors.toList());
	}

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

	public void replaceIfExist(IArmyRule<?> rule1, IArmyRule<?> rule2) {
		if (rules.remove(rule1)) {
			add(rule2);
		}
	}

	public Set<IArmyRule<?>> getRules() {
		return rules;
	}

	public Set<KeyWord> getKeyWords() {
		return keyWords;
	}

	public IUnitOptionValue<?> get(UnitOption option) {
		return options.get(option);
	}

	public boolean is(KeyWord keyWord) {
		return getKeyWords().contains(keyWord);
	}

	public boolean is(UnitOption opt) {
		return get(opt) != null;
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

	public void setValue(int value) {
		this.value = value;
	}

	public void setArmy(Army army) {
		this.army = army;
	}


}
