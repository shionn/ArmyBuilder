package armybuilder.model.nighthaunt;

import armybuilder.model.unit.weapon.IUnitWeapon;
import armybuilder.model.unit.weapon.WeaponType;

public enum NighthauntUnitWeapon implements IUnitWeapon {

	CriPerçant("Cri Perçant", WeaponType.Projectil, "12", "D3", "3+", "3+", "-2", "1"),
	FleauxSpectrauxProjectil("Fléaux Spectraux", WeaponType.Projectil, "15", "2", "4+", "3+", "-2", "1"),

	Affrelame("Affrelame", WeaponType.Melee, "1", "4", "3+", "3+", "-1", "2"),
	Aprefauche("Aprefauche", WeaponType.Melee, "2", "5", "3", "3", "-2", "2"),
	ArmeDeMalfaisant("Arme de Malfaisant", WeaponType.Melee, "1", "2", "4+", "4+", "-", "1"),
	BatonDeMinuit("Bâton de Minuit", WeaponType.Melee, "2", "4", "3", "3", "-2", "2"),
	ChainesBagnespectre("Chaînes Bagnespectre", WeaponType.Melee, "2", "3", "3+", "3+", "-2", "2"),
	DagueDeFrisson("Dague de Frisson", WeaponType.Melee, "1", "2", "3+", "3+", "-2", "2"),
	DagueDeFrissonBanshee("Dague de Frisson", WeaponType.Melee, "1", "2", "4+", "3+", "-2", "2"),
	DentsEtSabots("Dents et Sabots", WeaponType.Melee, "1", "2", "4+", "4+", "-", "1"),
	EpeeDesHeuresVolees("Épée des Heures Volées", WeaponType.Melee, "1", "5", "3", "3", "-1", "2"),
	FauxDeGrandCairn("Faux de Grand Cairn", WeaponType.Melee, "2", "*", "3+", "3+", "-1", "2"),
	FauxDEstafier("Faux d’Estafier", WeaponType.Melee, "2", "2", "4+", "3+", "-1", "1"),
	FauxSpectrale("Faux Spectrale", WeaponType.Melee, "1", "2", "3+", "3+", "-1", "1"),
	FleauxSpectrauxMelee("Fléaux Spectraux", WeaponType.Melee, "2", "2", "4+", "3+", "-2", "1"),
	GlasMortel("Glas Mortel", WeaponType.Melee, "2", "2", "4+", "3+", "-1", "D3"),
	GrandeHacheDeDecapitation("Grande Hache de Décapitation", WeaponType.Melee, "1", "5", "3", "3", "-2", "2"),
	GrandeLameDeLaTombe("Grande Lame de la Tombe", WeaponType.Melee, "1", "2", "3+", "3+", "-1", "1"),
	GriffesEtDaguesSpectrales("Griffes et Dagues Spectrales", WeaponType.Melee, "1", "6", "4+", "4+", "-", "1"),
	GriffesSpectrales("Griffes Spectrales", WeaponType.Melee, "1", "6", "4", "4", "-1", "1"),
	LameDeFrisson("Lame de Frisson", WeaponType.Melee, "1", "3", "3", "3", "-1", "2"),
	MembresFaucheurs("Membres Faucheurs", WeaponType.Melee, "1", "4", "4+", "4+", "-", "1"),
	PlumeFielleuse("Plume Fielleuse", WeaponType.Melee, "1", "3", "4", "3", "-1", "1"),
	SabotsEtDentsFantomatiquesEcumeur("Sabots et Dents Fantomatiques", WeaponType.Melee, "1", "2", "4", "3", "-", "1"),
	SabotsEtDentsFantomatiquesReikenor("Sabots et Dents Fantomatiques", WeaponType.Melee, "1", "3", "4", "4", "-", "1"),
	SabotsEtDentsFantomatiquesSuaires("Sabots et Dents Fantomatiques", WeaponType.Melee, "1", "2", "4", "4", "-", "1"),
	SceptreSepulcral("Sceptre Sépulcral", WeaponType.Melee, "2", "5", "3", "3", "-3", "3"),
	VougeDeChasseur("Vouge de Chasseur", WeaponType.Melee, "1", "1", "4+", "3+", "-1", "2"),



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

	@Override
	public boolean is(IUnitWeapon weapon) {
		return weapon == this;
	}

}
