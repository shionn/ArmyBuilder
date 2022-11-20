package armybuilder.modelold.deprecated.army.compare;

import java.util.Comparator;

import armybuilder.model.unit.model.IUnitModel;
import armybuilder.model.unit.role.RoleTactique;

public class UnitModelComparator implements Comparator<IUnitModel> {

	@Override
	public int compare(IUnitModel a, IUnitModel b) {
		int result = 0;
		if (a.is(RoleTactique.Leader) && !b.is(RoleTactique.Leader)) {
			result = -1;
		} else if (!a.is(RoleTactique.Leader) && b.is(RoleTactique.Leader)) {
			result = 1;
		}
		if (result == 0) {
			if (a.is(RoleTactique.Ligne) && !b.is(RoleTactique.Ligne)) {
				result = -1;
			} else if (!a.is(RoleTactique.Ligne) && b.is(RoleTactique.Ligne)) {
				result = 1;
			}
		}
		if (result == 0) {
			if (a.is(RoleTactique.SortsPersistantsEtInvocation) && !b.is(RoleTactique.SortsPersistantsEtInvocation)) {
				result = 1;
			} else if (!a.is(RoleTactique.SortsPersistantsEtInvocation)
					&& b.is(RoleTactique.SortsPersistantsEtInvocation)) {
				result = -1;
			}
		}
		if (result == 0) {
			if (a.is(RoleTactique.Behemoth) && !b.is(RoleTactique.Behemoth)) {
				result = 1;
			} else if (!a.is(RoleTactique.Behemoth) && b.is(RoleTactique.Behemoth)) {
				result = -1;
			}
		}
		if (result == 0) {
			if (a.is(RoleTactique.Artillerie) && !b.is(RoleTactique.Artillerie)) {
				result = 1;
			} else if (!a.is(RoleTactique.Artillerie) && b.is(RoleTactique.Artillerie)) {
				result = -1;
			}
		}
		if (result == 0) {
			result = a.getDisplayName().compareTo(b.getDisplayName());
		}
		return result;
	}
}
