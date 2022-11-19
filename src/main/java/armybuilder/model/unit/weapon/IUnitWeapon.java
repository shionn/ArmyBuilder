package armybuilder.model.unit.weapon;

public interface IUnitWeapon {

	String getDisplayName();

	WeaponType getType();

	String getPortee();

	String getAttaques();

	String getToucher();

	String getBlesser();

	String getPerf();

	String getDegats();

	default boolean is(WeaponType type) {
		return getType() == type;
	}

}
