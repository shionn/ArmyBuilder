package armybuilder.model.unit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.stream.Collectors;

import armybuilder.model.Army;
import armybuilder.model.rule.IArmyRule;
import armybuilder.model.unit.dok.DokOptimisations;
import armybuilder.model.unit.option.IUnitOptionValue;
import armybuilder.model.unit.option.OptimisationsUniverselles;
import armybuilder.model.unit.option.UnitOption;
import armybuilder.model.unit.option.UnitOptionType;

public class Unit {

	private Army army;
	private IUnitModel model;
	private Map<UnitOption, Object> options = new HashMap<UnitOption, Object>();
	private SortedSet<IArmyRule<?>> rules = new TreeSet<>(new UnitRuleComparator());

	public Unit(Army army, IUnitModel model) {
		this.army = army;
		this.model = model;
	}

	public void rebuild(Army army) {
		rules.clear();
		rules.addAll(model.getRules());

		options.entrySet().stream().filter(e -> e.getKey().getType() != UnitOptionType.bool)
				.map(e -> (IUnitOptionValue<?>) e.getValue()).forEach(o -> o.rebuild(this));
	}

	public List<IUnitWeapon> getWeapons(WeaponType type) {
		return model.getWeapons().stream().filter(w -> w.getType() == type)
				.collect(Collectors.toList());
	}

	public ProfileDegressif getProfileDegressif() {
		return model.getProfileDegressif();
	}

	public List<UnitOption> getOptions() {
		return Arrays.stream(UnitOption.values()).filter(u -> u.isAvailable(this))
				.collect(Collectors.toList());
	}

	public void addOption(UnitOption option, Object value) {
		options.put(option, value);
	}

	public void removeOption(UnitOption option) {
		options.remove(option);
	}

	@SuppressWarnings("unchecked")
	public <T extends Enum<T> & IUnitOptionValue<T>> List<IUnitOptionValue<T>> getOptionValues(
			UnitOption option) {
		List<T> values = new ArrayList<>();
		values.addAll((Collection<? extends T>) Arrays.asList(OptimisationsUniverselles.values()));
		values.addAll((Collection<? extends T>) Arrays.asList(DokOptimisations.values()));
		return values.stream().filter(o -> o.getOption() == option)
				.filter(o -> o.isAvailable(army, this)).collect(Collectors.toList());
	}

	public void addRule(IArmyRule<?> rule) {
		rules.add(rule);
	}

	public Set<IArmyRule<?>> getRules() {
		return rules;
	}

	public List<KeyWord> getKeyWords() {
		return model.getKeyWords();
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

	public Object get(UnitOption option) {
		return options.get(option);
	}

	public boolean is(KeyWord keyWord) {
		return getKeyWords().contains(keyWord);
	}

	public boolean is(UnitOption opt) {
		return get(opt) != null;
	}


}
