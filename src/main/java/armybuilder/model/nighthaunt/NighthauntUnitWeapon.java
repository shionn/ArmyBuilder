package armybuilder.model.nighthaunt;

import armybuilder.model.unit.weapon.IUnitWeapon;
import armybuilder.model.unit.weapon.WeaponType;

public enum NighthauntUnitWeapon implements IUnitWeapon {
	Affrelame("Affrelame", WeaponType.Melee, "1", "3", "3+", "3+", "-1", "1"),
	ArmeDeMalignant("Arme de Malignant", WeaponType.Melee, "1", "2", "4+", "4+", "-", "1"),
	CriDechirant("Cri Déchirant", WeaponType.Projectil, "10", "3", "3+", "3+", "-3", "1"),
	DagueDeGivre("Dague de Givre", WeaponType.Melee, "1", "2", "4+", "3+", "-2", "D3"),
	FouetDeRonces("Fouet de Ronces", WeaponType.Melee, "3", "1", "3+", "3+", "-2", "D3"),
	SabotsEtDentsFantomatiques("Sabots et Dents Fantomatiques", WeaponType.Melee, "1", "2", "4+", "5+", "-", "1"),
	VougeDeChasseur("Vouge de Chasseur", WeaponType.Melee, "2", "2", "4+", "3+", "-", "1"),

	;

	private String displayName;
	private String[] stats;
	private WeaponType type;

	private NighthauntUnitWeapon(String displayName, WeaponType type, String... stats) {
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
