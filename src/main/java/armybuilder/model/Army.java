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

import armybuilder.model.modifier.Modifiers;
import armybuilder.model.option.ArmyOptionType;
import armybuilder.model.option.IArmyOption;
import armybuilder.model.rule.GeneriqueRule;
import armybuilder.model.rule.IArmyRule;
import armybuilder.model.unit.IUnit;
import armybuilder.model.unit.Unit;

@Component
@SessionScope
public class Army {

	private Map<ArmyOptionType, IArmyOption<?>> options = new HashMap<>();

	private Set<IArmyRule> rules = new LinkedHashSet<>();
	private Set<IUnit> unitChoices = new LinkedHashSet<>();

	private List<Unit> units = new ArrayList<>();

	public void rebuild() {
		rules.clear();
		Modifiers.rules(GeneriqueRule.values()).accept(null, this);
		options.values().stream().filter(Objects::nonNull).forEach(o -> o.rebuild(this));
		units.stream().forEach(o -> o.rebuild(this));
	}

	public void setOption(ArmyOptionType type, IArmyOption<?> value) {
		this.options.put(type, value);
		if (type == ArmyOptionType.Allegiance) {
			this.options.remove(ArmyOptionType.SubAllegiance);
			this.unitChoices.clear();
			this.units.clear();
		}
	}

	public IArmyOption<?> getOption(ArmyOptionType type) {
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
