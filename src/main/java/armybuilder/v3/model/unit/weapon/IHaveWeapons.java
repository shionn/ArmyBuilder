package armybuilder.v3.model.unit.weapon;

import java.util.List;
import java.util.stream.Collectors;

public interface IHaveWeapons {

	List<IUnitWeapon> getWeapons();

	default List<IUnitWeapon> weapons(WeaponType type) {
		return getWeapons().stream().filter(w -> w.is(type)).collect(Collectors.toList());
	}
}
