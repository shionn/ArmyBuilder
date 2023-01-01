package armybuilder.model.unit.weapon;

import armybuilder.model.IHaveDisplayName;

public interface IUnitWeapon extends IHaveDisplayName {

	WeaponType getType();

	String getPortee();

	String getAttaques();
	String getAltAttaques();

	String getToucher();

	String getBlesser();

	String getPerf();

	String getDegats();

	boolean is(IUnitWeapon weapon);

	default boolean is(WeaponType type) {
		return getType() == type;
	}


}
