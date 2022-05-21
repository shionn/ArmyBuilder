package armybuilder.model.army.compare;

import java.util.Comparator;

import armybuilder.model.army.rule.IArmyRule;

public class UnitRuleComparator implements Comparator<IArmyRule<?>> {

	@Override
	public int compare(IArmyRule<?> o1, IArmyRule<?> o2) {
		int compare = o1.getTypes().get(0).compareTo(o2.getTypes().get(0));
		if (compare == 0) {
			compare = o1.name().compareTo(o2.name());
		}
		return compare;
	}

}
