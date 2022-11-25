package armybuilder.model.stormcast;

import armybuilder.model.unit.weapon.IUnitWeapon;
import armybuilder.model.unit.weapon.WeaponType;

public enum StormcastWeapons implements IUnitWeapon {
	ArmeDesCieux("Arme des Cieux", WeaponType.Melee, "1", "2", "3+", "4+", "-1", "1"),
	GrandeArme("Grande Arme", WeaponType.Melee, "1", "2", "3+", "3+", "-1", "2"),
	LanceDOrage("Lance d'Orage", WeaponType.Melee, "2", "2", "3+", "3+", "-1", "1"),
	MarteauRelique("Marteau Relique", WeaponType.Melee, "1", "4", "3+", "3+", "-1", "2"),
	PairesDArmesDesCieux("Paire d'Armes des Cieux", WeaponType.Melee, "1", "3", "3+", "4+", "-1", "1"),
	;

	private String displayName;
	private WeaponType type;
	private String[] stats;

	StormcastWeapons(String displayName, WeaponType type, String... stats) {
		this.displayName = displayName;
		this.type = type;
		this.stats = stats;
	}

	@Override
	public String getDisplayName() {
		return displayName;
	}

	@Override
	public WeaponType getType() {
		return type;
	}

	@Override
	public String getPortee() {
		return stats[0];
	}

	@Override
	public String getAttaques() {
		return stats[1];
	}

	@Override
	public String getToucher() {
		return stats[2];
	}

	@Override
	public String getBlesser() {
		return stats[3];
	}

	@Override
	public String getPerf() {
		return stats[4];
	}

	@Override
	public String getDegats() {
		return stats[5];
	}

}
