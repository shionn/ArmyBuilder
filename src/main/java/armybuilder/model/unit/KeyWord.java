package armybuilder.model.unit;

public enum KeyWord {
	// Generique
	Aelf("Aelf"),
	Heros("Héros"),
	Unique("Unique"),
	Monstre("Monstre"),
	Mort("Mort"),
	Ordre("Ordre"),
	// DoK
	FerecailleMelusai("Ferécaille Melusaï"),
	FilleDeKhaine("Filles de Khaine"),
	LaReineDeLOmbre("La Reine de l'Ombre"),
	MeduseIncarnate("Méduse Incarnate"),
	MorathiKhaine("Morathi-Khaine"),

	// fait au dessus
	AvatarOfKhaine("Avatar of Khaine"),
	BloodStalkers("Blood Stalkers"),
	BloodSister("Blood Sister"),
	BloodwrackMedusa("Bloodwrack Medusa"),
	BloodwrackShrine("Bloodwrack Shrine"),
	CauldronOfBlood("Cauldron of Blood"),
	ChainraspHorde("ChainraspHorde"),
	DraichiGaneth("Draichi Ganeth"),
	DreadbladeHarrow("Dreadblade Harrow"),
	EpinesDeLaReineDesRonces("Epines de la Reine des Ronces"),
	GlaivewraithStalkers("Glaivewraith Stalkers"),
	HagQueen("Hag Queen"),
	HaggNar("Hagg Nar"),
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
	LOstEmeraude("Ost Émeraude"),
	Malignant("Malignant"),
	Melusai("Melusai"),
	MelusaiIronscale("Melusai Ironscale"),
	MirrorghastBanshee("Mirrorghast Banshee"),
	MorgwaethTheBloodied("Morgwaeth the Bloodied"),
	MyrmournBanshees("Myrmourn Banshees"),
	Nighthaunt("Nighthaunt"),
	Pretre("Prêtre"),
	SisterOfSlaughter("Sisters of Slaughter"),
	SlaughterQueen("Slaughter Queen"),
	Sorcier("Sorcier"),
	TombBanshee("Tomb Banshee"),
	Totem("Totem"),
	TousLesTemples("Tous les Temples"),
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
