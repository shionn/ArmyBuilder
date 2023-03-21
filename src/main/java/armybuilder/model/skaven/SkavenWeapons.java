package armybuilder.model.skaven;

import armybuilder.model.unit.weapon.IUnitWeapon;
import armybuilder.model.unit.weapon.WeaponType;

public enum SkavenWeapons implements IUnitWeapon {
	BatonDeMalepierre("Bâton de Malepierre", WeaponType.Melee, "2", "3", "4+", "4+", "-1", "D3"),
	GriffesEtDentsDechiqueteuses("Griffes et Dents Déchiqueteuses", WeaponType.Melee, "1", "4", "4+", "3+", "-1", "2"),
	LanceRouillee("Lance Rouillée", WeaponType.Melee, "2", "1", "5+", "4+", "-", "1"),
	LameAMalenergie("Lame à Malénergie", WeaponType.Melee, "1", "D3", "4+", "3+", "-1", "1"),
	LameDeMalepierre("Lame de Malepierre", WeaponType.Melee, "1", "6", "3+", "3+", "-1", "2"),
	LameRouillee("Lame Rouillée", WeaponType.Melee, "1", "1", "4+", "4+", "-", "1"),
	PiquesRouillees("Piques Rouillées", WeaponType.Melee, "1", "*", "3+", "3+", "-1", "1"),

	PistoletAMalepierre("Pistolet à Malepierre", WeaponType.Projectil, "9", "3", "3+", "3+", "-2", "1"),

	;
	private String displayName;
	private WeaponType type;
	private String[] stats;

	SkavenWeapons(String displayName, WeaponType type, String... stats) {
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

	@Override
	public boolean is(IUnitWeapon weapon) {
		return weapon == this;
	}

}
