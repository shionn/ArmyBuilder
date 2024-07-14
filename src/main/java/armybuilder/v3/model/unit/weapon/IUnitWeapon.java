package armybuilder.v3.model.unit.weapon;

import armybuilder.v3.model.IHaveDisplayName;

public interface IUnitWeapon extends IHaveDisplayName {

	WeaponType getType();

	String getPortee();

	String getAttaques();

	String getToucher();

	String getBlesser();

	String getPerf();

	String getDegats();

	boolean is(IUnitWeapon weapon);

	default boolean is(WeaponType type) {
		return getType() == type;
	}


}
