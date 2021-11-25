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
	DraichiGaneth("Draichi Ganeth"),
	DreadbladeHarrow("Dreadblade Harrow"),
	EpinesDeLaReineDesRonces("Epines de la Reine des Ronces"),
	GlaivewraithStalkers("Glaivewraith Stalkers"),
	HagQueen("Hag Queen"),
	HaggNar("Hagg Nar"),
	Heros("Héros"),
	Invocable("Invocable"),
	Khailebron("Khailebron"),
	KhainiteShadowstalkers("Khainite Shadowstalkers"),
	KheltNar("Khelt Nar"),
	KhineraiHarpies("Khinerai Harpies"),
	KhineraiHeartrenders("Khinerai Heartrenders"),
	Kraith("Kraith"),
	KnightOfShrouds("Knight Of Shrouds"),
	LaBladeCoven("La Blade-Coven"),
	LaReineDesRonces("La Reine des Ronces"),
	LaShadowQueen("La Shadow Queen"),
	LOstEmeraude("Ost Émeraude"),
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
	TombBanshee("Tomb Banshee"),
	Totem("Totem"),
	TousLesTemples("Tous les Temples"),
	Unique("Unique"),
	WitchAelves("Witch Aelves"),
	ZaintharKai("Zainthar Kai"),


	;

	private String displayName;

	private KeyWord(String displayName) {
		this.displayName = displayName;
	}

	public String getDisplayName() {
		return displayName;
	}
}
