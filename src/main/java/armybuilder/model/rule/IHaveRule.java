package armybuilder.model.rule;

import java.util.List;
import java.util.stream.Collectors;

public interface IHaveRule {

	List<IRule<?>> getRules();

	default List<IRule<?>> rules(RuleType type) {
		return getRules().stream().filter(r -> r.is(type)).collect(Collectors.toList());
	}

}
