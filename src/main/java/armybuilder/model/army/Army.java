package armybuilder.model.army;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import armybuilder.model.army.check.GenericCheck;
import armybuilder.model.army.option.ArmyOption;
import armybuilder.model.army.option.IArmyOptionValue;
import armybuilder.model.army.option.MultiOption;
import armybuilder.model.army.rule.ArmyRuleType;
import armybuilder.model.army.rule.GeneriqueRule;
import armybuilder.model.army.rule.IArmyRule;
import armybuilder.model.unit.IUnitModel;
import armybuilder.model.unit.KeyWord;
import armybuilder.model.unit.RoleTactique;
import armybuilder.model.unit.Unit;
import armybuilder.model.unit.option.IUnitOptionValue;
import armybuilder.model.unit.option.UnitOption;
import armybuilder.serialisation.ArmyOptionJsonDeserializer;

@Component
@SessionScope
@JsonAutoDetect(fieldVisibility = Visibility.ANY, getterVisibility = Visibility.NONE)
public class Army {

	@JsonDeserialize(contentConverter = ArmyOptionJsonDeserializer.class)
	private Map<ArmyOption, IArmyOptionValue<?>> options = new HashMap<>();
	private List<MultiOption> multiOptions = new ArrayList<>();
	private List<Unit> units = new ArrayList<>();

	@JsonIgnore
	private List<String> errors = new ArrayList<>();
	@JsonIgnore
	private Set<IArmyRule<?>> rules = new LinkedHashSet<>();
	@JsonIgnore
	private Set<IUnitModel> unitChoices = new TreeSet<>((a, b) -> {
		return a.getDisplayName().compareTo(b.getDisplayName());
	});
	private Set<Integer> subLists = new TreeSet<Integer>();

	public void reset() {
		this.options.clear();
		this.units.clear();
		this.multiOptions.clear();
	}

	public void rebuild() {
		rules.clear();
		errors.clear();
		units.stream().filter(Objects::nonNull).forEach(Unit::clear);

		Arrays.stream(GeneriqueRule.values())
				.filter(r -> r.isUsable(this))
				.forEach(rules::add);

		options.values().stream().filter(Objects::nonNull).forEach(o -> o.rebuild(this));
		multiOptions.stream().forEach(o -> o.getValue().rebuild(this));
		rules.forEach(r -> r.rebuild(this));
		units.stream().forEach(o -> o.rebuild(this));

		Arrays.stream(GenericCheck.values()).forEach(c -> c.verify(this));
		options.values().stream().forEach(o -> o.verify(this));
		multiOptions.stream().forEach(o -> o.getValue().verify(this));
		units.stream().forEach(u -> u.verify(this));
	}

	/*
	 * Options
	 */
	public void setOption(ArmyOption option, IArmyOptionValue<?> value) {
		this.options.put(option, value);
		if (option == ArmyOption.Allegiance) {
			this.options.remove(ArmyOption.SubAllegiance);
			this.unitChoices.clear();
			this.units.clear();
		}
	}

	public boolean is(IArmyOptionValue<?> opt) {
		return options.containsValue(opt);
	}

	public IArmyOptionValue<?> option(ArmyOption option) {
		return options.get(option);
	}

	public List<MultiOption> multiOptions() {
		return multiOptions;
	}

	public List<MultiOption> multiOptions(ArmyOption option) {
		return multiOptions.stream().filter(o -> o.is(option)).collect(Collectors.toList());
	}

	public void addMultiOption(MultiOption multiOption) {
		this.multiOptions.add(multiOption);
	}

	/*
	 * rules
	 */
	public List<IArmyRule<?>> getRules(ArmyRuleType... types) {
		return rules.stream().filter(r -> r.getTypes().containsAll(Arrays.asList(types)))
				.sorted((a, b) -> a.name().compareTo(b.name())).collect(Collectors.toList());
	}

	public List<IArmyRule<?>> getRules(Collection<ArmyRuleType> types) {
		return rules.stream().filter(r -> r.getTypes().containsAll(types))
				// .filter(r -> isUsable(r))
				.sorted((a, b) -> a.name().compareTo(b.name())).collect(Collectors.toList());
	}

	public void addRule(IArmyRule<?> rule) {
		this.rules.add(rule);
	}

	public void addRules(Collection<IArmyRule<?>> rules) {
		this.rules.addAll(rules);
	}

	/*
	 * unit
	 */
	public void addUnitChoice(IUnitModel unit) {
		this.unitChoices.add(unit);
	}

	@JsonIgnore
	public Set<IUnitModel> getUnitChoices() {
		return unitChoices;
	}

	public List<IUnitModel> unitChoices(RoleTactique role, RoleTactique exclude) {
		return unitChoices.stream().filter(u -> u.is(role) && !u.is(exclude))
				.collect(Collectors.toList());
	}

	public List<IUnitModel> unitChoices(RoleTactique role) {
		return unitChoices.stream().filter(u -> u.is(role)).collect(Collectors.toList());
	}

	public void add(Unit unit) {
		this.units.add(unit);
	}

	public void remove(Unit unit) {
		this.units.remove(unit);
	}

	public List<Unit> getUnits() {
		return units.stream().sorted().collect(Collectors.toList());
	}

	public List<Unit> units(UnitOption opt) {
		return units.stream().filter(u -> u.is(opt)).collect(Collectors.toList());
	}

	public Unit unit(UnitOption opt) {
		return units.stream().filter(u -> u.is(opt)).findFirst().orElse(null);
	}

	public List<Unit> units(IArmyRule<?> rule) {
		return units.stream().filter(u -> u.is(rule)).collect(Collectors.toList());
	}

	public List<Unit> units(UnitOption opt, IUnitOptionValue<?> value) {
		return units.stream().filter(u -> u.get(opt) == value).collect(Collectors.toList());
	}

	public List<Unit> units(RoleTactique role) {
		return units.stream().filter(u -> u.is(role)).collect(Collectors.toList());
	}

	public List<Unit> units(KeyWord keyWord) {
		return units.stream().filter(u -> u.is(keyWord)).collect(Collectors.toList());
	}

	public List<Unit> units(IUnitModel model) {
		return units.stream().filter(u -> u.is(model)).collect(Collectors.toList());
	}

	/*
	 * sub
	 */
	public List<Unit> getSubUnits(int id) {
		return units.stream().filter(u -> u.isInSubList(id)).sorted().collect(Collectors.toList());
	}

	public void addError(String string) {
		this.errors.add(string);
	}

	public List<String> getErrors() {
		return errors;
	}

	public int getValue() {
		return units.stream().map(u -> u.getValue()).collect(Collectors.reducing((a, b) -> a + b))
				.orElse(0);
	}

	public int getSubValue(int sub) {
		return units.stream().filter(u -> u.isInSubList(sub)).map(u -> u.getValue())
				.collect(Collectors.reducing((a, b) -> a + b)).orElse(0);
	}

	public void addSubList(Integer sub) {
		this.subLists.add(sub);
	}

	public void removeSubList(Integer sub) {
		this.subLists.remove(sub);
	}

	public List<Integer> getSubLists() {
		return subLists.stream().sorted((a, b) -> Integer.compare(getSubValue(a), getSubValue(b)))
				.collect(Collectors.toList());
	}


}
