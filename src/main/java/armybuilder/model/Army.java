package armybuilder.model;

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

import armybuilder.model.check.GenericCheck;
import armybuilder.model.option.ArmyOption;
import armybuilder.model.option.IArmyOptionValue;
import armybuilder.model.rule.ArmyRuleType;
import armybuilder.model.rule.GeneriqueRule;
import armybuilder.model.rule.IArmyRule;
import armybuilder.model.unit.IUnitModel;
import armybuilder.model.unit.Unit;
import armybuilder.model.unit.option.IUnitOptionValue;
import armybuilder.model.unit.option.UnitOption;

@Component
@SessionScope
public class Army {

	private Map<ArmyOption, IArmyOptionValue<?>> options = new HashMap<>();

	private Set<IArmyRule<?>> rules = new LinkedHashSet<>();
	private List<String> errors = new ArrayList<>();
	private Set<IUnitModel> unitChoices = new TreeSet<>((a, b) -> {
		int compare = a.getRoleTactiques().get(0).compareTo(b.getRoleTactiques().get(0));
		if (compare == 0) {
			compare = a.getDisplayName().compareTo(b.getDisplayName());
		}
		return compare;
	});

	private List<Unit> units = new ArrayList<>();

	public void rebuild() {
		rules.clear();
		errors.clear();
		units.stream().forEach(u -> u.clear());

		rules.addAll(Arrays.asList(GeneriqueRule.values()));

		options.values().stream().filter(Objects::nonNull).forEach(o -> o.rebuild(this));
		units.stream().forEach(o -> o.rebuild(this));

		Arrays.stream(GenericCheck.values()).forEach(c -> c.verify(this));
		options.values().stream().forEach(o -> o.verify(this));
	}

	public void setOption(ArmyOption option, IArmyOptionValue<?> value) {
		this.options.put(option, value);
		if (option == ArmyOption.Allegiance) {
			this.options.remove(ArmyOption.SubAllegiance);
			this.unitChoices.clear();
			this.units.clear();
		}
	}

	public IArmyOptionValue<?> getOption(ArmyOption option) {
		return options.get(option);
	}

	public List<IArmyRule<?>> getRules(ArmyRuleType... types) {
		return rules.stream().filter(r -> r.getTypes().containsAll(Arrays.asList(types)))
				.sorted((a, b) -> a.name().compareTo(b.name())).collect(Collectors.toList());
	}

	public void addRule(IArmyRule<?> rule) {
		this.rules.add(rule);
	}

	public void addRules(Collection<IArmyRule<?>> rules) {
		this.rules.addAll(rules);
	}

	public void addUnitChoice(IUnitModel unit) {
		this.unitChoices.add(unit);
	}

	public Set<IUnitModel> getUnitChoices() {
		return unitChoices;
	}

	public void addUnit(Unit unit) {
		this.units.add(unit);
	}

	public List<Unit> getUnits() {
		return units;
	}

	public void addError(String string) {
		this.errors.add(string);
	}

	public List<String> getErrors() {
		return errors;
	}

	public List<Unit> units(UnitOption opt) {
		return units.stream().filter(u -> u.is(opt)).collect(Collectors.toList());
	}

	public List<Unit> units(IArmyRule<?> rule) {
		return units.stream().filter(u -> u.is(rule)).collect(Collectors.toList());
	}

	public List<Unit> units(UnitOption opt, IUnitOptionValue<?> value) {
		return units.stream().filter(u -> u.get(opt) == value).collect(Collectors.toList());
	}

	public boolean is(IArmyOptionValue<?> opt) {
		return options.containsValue(opt);
	}

}
