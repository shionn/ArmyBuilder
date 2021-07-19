package armybuilder.model;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import armybuilder.model.i.IArmyOption;
import armybuilder.model.i.IArmyRule;

@Component
@SessionScope
public class Army {

	private Map<ArmyOptionType, IArmyOption<?>> options = new HashMap<>();

	private Set<IArmyRule> rules = new LinkedHashSet<>();

	public void rebuild() {
		this.rules.clear();
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

	public List<IArmyRule> getRules(ArmyRuleType type) {
		return rules.stream().filter(r -> r.getType() == type).sorted()
				.collect(Collectors.toList());
	}

	public void addRule(IArmyRule rule) {
		this.rules.add(rule);
	}


}
