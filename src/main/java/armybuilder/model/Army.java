package armybuilder.model;

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

import armybuilder.model.option.ArmyOptionType;
import armybuilder.model.option.IArmyOption;
import armybuilder.model.rule.IArmyRule;

@Component
@SessionScope
public class Army {

	private Map<ArmyOptionType, IArmyOption<?>> options = new HashMap<>();

	private Set<IArmyRule> rules = new LinkedHashSet<>();

	public void rebuild() {
		rules.clear();
		options.values().stream().filter(Objects::nonNull).forEach(o -> o.rebuild(this));
	}

	public void setOption(ArmyOptionType type, IArmyOption<?> value) {
		options.put(type, value);
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

}
