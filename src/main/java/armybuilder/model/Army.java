package armybuilder.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import armybuilder.model.option.ArmyOption;
import armybuilder.model.option.IArmyOptionValue;
import armybuilder.model.rule.ArmyRuleType;
import armybuilder.model.rule.GeneriqueRule;
import armybuilder.model.rule.IArmyRule;
import armybuilder.model.unit.IUnit;
import armybuilder.model.unit.Unit;

@Component
@SessionScope
public class Army {

	private Map<ArmyOption, IArmyOptionValue<?>> options = new HashMap<>();

	private Set<IArmyRule> rules = new LinkedHashSet<>();
	private Set<IUnit> unitChoices = new LinkedHashSet<>();

	private List<Unit> units = new ArrayList<>();

	public void rebuild() {
		rules.clear();
		rules.addAll(Arrays.asList(GeneriqueRule.values()));

		options.values().stream().filter(Objects::nonNull).forEach(o -> o.rebuild(this));
		units.stream().forEach(o -> o.rebuild(this));

	}

	public void setOption(ArmyOption type, IArmyOptionValue<?> value) {
		this.options.put(type, value);
		if (type == ArmyOption.Allegiance) {
			this.options.remove(ArmyOption.SubAllegiance);
			this.unitChoices.clear();
			this.units.clear();
		}
	}

	public IArmyOptionValue<?> getOption(ArmyOption type) {
		return options.get(type);
	}

	public Set<IArmyRule> getRules() {
		return rules;
	}

	public List<IArmyRule> getRules(ArmyRuleType... types) {
		return rules.stream().filter(r -> r.getTypes().containsAll(Arrays.asList(types))).sorted()
				.collect(Collectors.toList());
	}

	public void addRule(IArmyRule rule) {
		this.rules.add(rule);
	}

	public void addUnitChoice(IUnit unit) {
		this.unitChoices.add(unit);
	}

	public Set<IUnit> getUnitChoices() {
		return unitChoices;
	}

	public void addUnit(Unit unit) {
		this.units.add(unit);
	}

	public List<Unit> getUnits() {
		return units;
	}

}
