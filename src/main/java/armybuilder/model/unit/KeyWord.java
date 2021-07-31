package armybuilder.model.unit;

public enum KeyWord {
	Aelf("Aelf"),
	AvatarOfKhaine("Avatar of Khaine"),
	BloodStalkers("Blood Stalkers"),
	BloodSister("Blood Sister"),
	BloodwrackMedusa("Bloodwrack Medusa"),
	BloodwrackShrine("Bloodwrack Shrine"),
	CauldronOfBlood("Cauldron of Blood"),
	ChainraspHorde("ChainraspHorde"),
	DaughtersOfKhaine("Daughters of khaine"),
	EpinesDeLaReineDesRonces("Epines de la Reine des Ronces"),
	GlaivewraithStalkers("Glaivewraith Stalkers"),
	HagQueen("Hag Queen"),
	HaggNar("Hagg Nar"),
	Heros("Héros"),
	Invocable("Invocable"),
	KhainiteShadowstalkers("Khainite Shadowstalkers"),
	KheltNar("Khelt Nar"),
	KhineraiHarpies("Khinerai Harpies"),
	KhineraiHeartrenders("Khinerai Heartrenders"),
	LaBladeCoven("La Blade-Coven"),
	LaReineDesRonces("La Reine des Ronces"),
	LaShadowQueen("La Shadow Queen"),
	Malignant("Malignant"),
	Melusai("Melusai"),
	MelusaiIronscale("Melusai Ironscale"),
	MirrorghastBanshee("Mirrorghast Banshee"),
	Monstre("Monstre"),
	MorathiKhaine("Morathi-Khaine"),
	MorgwaethTheBloodied("Morgwaeth the Bloodied"),
	Mort("Mort"),
	MyrmournBanshees("Myrmourn Banshees"),
	Nighthaunt("Nighthaunt"),
	Ordre("Ordre"),
	Pretre("Prêtre"),
	SisterOfSlaughter("Sisters of Slaughter"),
	SlaughterQueen("Slaughter Queen"),
	Sorcier("Sorcier"),
	Totem("Totem"),
	Unique("Unique"),
	WitchAelves("Witch Aelves"),


	;

	private String displayName;

	private KeyWord(String displayName) {
		this.displayName = displayName;
	}

	public String getDisplayName() {
		return displayName;
	}
}
