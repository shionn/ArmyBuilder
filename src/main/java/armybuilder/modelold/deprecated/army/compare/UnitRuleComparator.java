package armybuilder.modelold.deprecated.army.compare;

import java.util.Comparator;

import armybuilder.model.rule.IRule;

public class UnitRuleComparator implements Comparator<IRule<?>> {

	@Override
	public int compare(IRule<?> o1, IRule<?> o2) {
		int compare = o1.getTypes().get(0).compareTo(o2.getTypes().get(0));
		if (compare == 0) {
			compare = o1.name().compareTo(o2.name());
		}
		return compare;
	}

}
