package armybuilder.model.unit;

public enum KeyWord {
	Aelf("Aelf"),
	AvatarOfKhaine("Avatar of Khaine"),
	BloodStalkers("Blood Stalkers"),
	BloodSister("Blood Sister"),
	BloodwrackMedusa("Bloodwrack Medusa"),
	BloodwrackShrine("Bloodwrack Shrine"),
	CauldronOfBlood("Cauldron of Blood"),
	DaughtersOfKhaine("Daughters of khaine"),
	HagQueen("Hag Queen"),
	HaggNar("Hagg Nar"),
	Heros("Héros"),
	KheltNar("Khelt Nar"),
	KhineraiHarpies("Khinerai Harpies"),
	KhineraiHeartrenders("Khinerai Heartrenders"),
	LaBladeCoven("La Blade-Coven"),
	LaShadowQueen("La Shadow Queen"),
	Melusai("Melusai"),
	MelusaiIronscale("Melusai Ironscale"),
	Monstre("Monstre"),
	MorathiKhaine("Morathi-Khaine"),
	MorgwaethTheBloodied("Morgwaeth the Bloodied"),
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
