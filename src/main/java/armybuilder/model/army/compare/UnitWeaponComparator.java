package armybuilder.model.army.compare;

import java.util.Comparator;

import armybuilder.model.unit.weapon.IUnitWeapon;

public class UnitWeaponComparator implements Comparator<IUnitWeapon> {

	@Override
	public int compare(IUnitWeapon o1, IUnitWeapon o2) {
		return o1.getDisplayName().compareTo(o2.getDisplayName());
	}

}
