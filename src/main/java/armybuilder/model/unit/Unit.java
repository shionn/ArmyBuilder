package armybuilder.model.unit;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.stream.Collectors;

import armybuilder.model.Army;
import armybuilder.model.rule.IArmyRule;
import armybuilder.model.unit.option.IUnitOptionValue;
import armybuilder.model.unit.option.UnitOption;
import armybuilder.model.unit.weapon.IUnitWeapon;
import armybuilder.model.unit.weapon.WeaponType;

public class Unit implements Comparable<Unit> {

	private Army army;
	private IUnitModel model;
	private Map<UnitOption, IUnitOptionValue<?>> options = new HashMap<UnitOption, IUnitOptionValue<?>>();
	private SortedSet<IArmyRule<?>> rules = new TreeSet<>(new UnitRuleComparator());
	private Set<KeyWord> keyWords = new TreeSet<>();
	private Set<IUnitWeapon> weapons = new TreeSet<>();
	private Set<RoleTactique> roleTatciques = new TreeSet<>();

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
	}

	public void rebuild(Army army) {
		options.values().stream().forEach(o -> o.rebuild(this));
		model.rebuild(army, this);
		army.addRules(rules);
	}

	public List<IUnitWeapon> getWeapons(WeaponType type) {
		return weapons.stream().filter(w -> w.getType() == type).collect(Collectors.toList());
	}

	public ProfileDegressif getProfileDegressif() {
		return model.getProfileDegressif();
	}

	public List<UnitOption> getOptions() {
		return model.getOptions();
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
		return model.getValue();
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

}
