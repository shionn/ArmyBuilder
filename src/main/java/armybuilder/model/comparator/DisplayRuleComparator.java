package armybuilder.model.comparator;

import java.util.Comparator;

import armybuilder.model.rule.IRule;
import armybuilder.model.rule.RuleType;

public class DisplayRuleComparator implements Comparator<IRule<?>> {

	@Override
	public int compare(IRule<?> o1, IRule<?> o2) {
		int result = compare(o1, o2, RuleType.PhaseDeDeroute);
		if (result == 0) {
			result = compare(o1, o2, RuleType.PhaseDeCombatFin);
		}
		if (result == 0) {
			result = compare(o1, o2, RuleType.PhaseDeCombat);
		}
		if (result == 0) {
			result = compare(o1, o2, RuleType.PhaseDeCombatDebut);
		}
		if (result == 0) {
			result = compare(o1, o2, RuleType.PhaseDeCharge);
		}
		if (result == 0) {
			result = compare(o1, o2, RuleType.PhaseDeTir);
		}
		if (result == 0) {
			result = compare(o1, o2, RuleType.PhaseDeTirPlayer);
		}
		if (result == 0) {
			result = compare(o1, o2, RuleType.PhaseDeMouvement);
		}
		if (result == 0) {
			result = compare(o1, o2, RuleType.PhaseDeMouvementPlayer);
		}
		if (result == 0) {
			result = compare(o1, o2, RuleType.Sort);
		}
		if (result == 0) {
			result = compare(o1, o2, RuleType.Priere);
		}
		if (result == 0) {
			result = compare(o1, o2, RuleType.PhaseDesHeros);
		}
		if (result == 0) {
			result = compare(o1, o2, RuleType.PhaseDesHerosPlayer);
		}
		if (result == 0) {
			result = o1.name().compareTo(o2.name());
		}
		return result;
	}

	private int compare(IRule<?> o1, IRule<?> o2, RuleType type) {
		if (o1.is(type) == o2.is(type)) {
			return 0;
		}
		if (o1.is(type)) {
			return 1;
		}
		return -1;
	}

}
