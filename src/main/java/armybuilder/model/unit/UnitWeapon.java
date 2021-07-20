package armybuilder.model.unit;

public enum UnitWeapon implements IUnitWeapon {
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
			"D6");

	private String displayName;
	private String[] stats;
	private WeaponType type;

	private UnitWeapon(String displayName, WeaponType type, String... stats) {
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
