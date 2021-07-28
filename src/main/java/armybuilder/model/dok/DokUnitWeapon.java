package armybuilder.model.dok;

import armybuilder.model.unit.weapon.IUnitWeapon;
import armybuilder.model.unit.weapon.WeaponType;

public enum DokUnitWeapon implements IUnitWeapon {
	AilesLamees("Ailes Lamées", WeaponType.Melee, "2", "6", "3+", "3+", "-1", "1"),
	CouronneDeSerpents("Couronne de Serpents", WeaponType.Melee, "1", "2D6", "3+", "3+", "-", "1"),
	EcorcheCoeur("Écorche-cœur", WeaponType.Melee, "2", "3", "3+", "3+", "-1", "D3"),
	EcorcheCoeur_Shadow("Écorche-cœur", WeaponType.Melee, "2", "*", "3+", "3+", "-1", "3"),
	QueueVenimeuse("Queue Venimeuse", WeaponType.Melee, "3", "1", "3+", "3+", "-2", "*"),
	RegardDeLaReineDeLOmbre(
			"Regard de la Reine de l'Ombre",
			WeaponType.Projectil,
			"18",
			"1",
			"2+",
			"2+",
			"-3",
			"D6"),
	RegardIncarnat("Regard Incarnat", WeaponType.Projectil, "12", "--", "--", "*", "--", "--"),
	LanceIncarnate("Lance Incarnate", WeaponType.Melee, "2", "3", "3+", "3+", "-1", "D3"),
	Aiguillons("Aiguillons", WeaponType.Melee, "2", "*", "3+", "3+", "-", "1"),
	GriffeMurmure("Griffe-murmure ", WeaponType.Melee, "1", "4", "4+", "3+", "-", "1"),
	QueueDeSerpents("Queue de Serpents", WeaponType.Melee, "2", "D6", "4+", "4+", "-", "1"),
	Keldrisaith_Projectil("Keldrisaith", WeaponType.Projectil, "18", "3", "3+", "3+", "-1", "1"),
	Keldrisaith_Melee("Keldrisaith", WeaponType.Melee, "2", "3", "3+", "3+", "-1", "D3"),
	ArcCherchecoeur("Arc Cherchecœur", WeaponType.Projectil, "24", "2", "3+", "3+", "-1", "1"),
	ArmesSacrificielles("Armes Sacrificielles", WeaponType.Melee, "1", "3", "3+", "4+", "-", "1"),
	VougeDeKhaine("Vouge de Khaine", WeaponType.Melee, "2", "3", "3+", "3+", "-1", "1"),
	LameDeKhaine("Lame de Khaine", WeaponType.Melee, "1", "4", "3+", "4+", "-1", "1"),
	EpeeDeMort("Épée de mort", WeaponType.Melee, "1", "3", "3+", "3+", "-1", "D3"),
	CouteauxSacrificiels("Couteaux Sacrificiels", WeaponType.Melee, "1", "2", "3+", "4+", "-", "1"),
	CouteauxSacrificiel("Couteaux Sacrificiel", WeaponType.Melee, "1", "1", "3+", "4+", "-", "1"),
	FouetBarbele("Fouet Barbelé", WeaponType.Melee, "2", "2", "3+", "4+", "-", "1"),
	VougeBrisecoeur("Vouge Brisecœur", WeaponType.Melee, "2", "3", "3+", "3+", "-1", "1"),
	Scianlar("Scianlar", WeaponType.Melee, "1", "2", "3+", "4+", "-", "1"),
	GuivreDeSang("Guivre de Sang", WeaponType.Melee, "1", "1", "3+", "3+", "-", "1"),
	TorrentdeSangBrulant(
			"Torrent de Sang Brûlant",
			WeaponType.Projectil,
			"10",
			"6",
			"3+",
			"3+",
			"-1",
			"1"),
	EpeeDAvatar("Épée d'Avatar", WeaponType.Melee, "2", "4", "3+", "3+", "-2", "3"),
	CouteauxSacrificiels_Chaudron(
			"Couteaux Sacrificiels",
			WeaponType.Melee,
			"1",
			"*",
			"3+",
			"4+",
			"-",
			"1"),
	JavelineBarbelee_M("Javeline Barbelée", WeaponType.Melee, "2+", "1", "4+", "4+", "-1", "1"),
	JavelineBarbelee_P("Javeline Barbelée", WeaponType.Projectil, "12", "1", "3+", "3+", "-1", "1"),

	;

	private String displayName;
	private String[] stats;
	private WeaponType type;

	private DokUnitWeapon(String displayName, WeaponType type, String... stats) {
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