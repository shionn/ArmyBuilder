package armybuilder.v3.model.rule;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public interface IHaveRule {

	List<IRule<?>> getRules();

	default List<IRule<?>> rules(RuleType... types) {
		return getRules().stream().filter(r -> r.is(types)).collect(Collectors.toList());
	}

	default List<IRule<?>> rules(Predicate<IRule<?>> precidate) {
		return getRules().stream().filter(precidate).collect(Collectors.toList());
	}

}
