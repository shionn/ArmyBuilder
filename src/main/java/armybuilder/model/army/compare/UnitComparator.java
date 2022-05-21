package armybuilder.model.army.compare;

import java.util.Comparator;

import armybuilder.model.unit.Unit;

public class UnitComparator implements Comparator<Unit> {

	@Override
	public int compare(Unit a, Unit b) {
		int result = new UnitModelComparator().compare(a.model(), b.model());
		if (result == 0) {
			result = Integer.compare(a.points(), b.points());
		}
		return result;
	}
}
