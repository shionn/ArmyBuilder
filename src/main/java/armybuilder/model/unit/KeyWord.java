package armybuilder.model.unit;

public enum KeyWord {
	Aelf("Aelf"),
	DaughtersOfKhaine("Daughters of khaine"),
	Heros("Héros"),
	LaShadowQueen("La Shadow Queen"),
	Monstre("Monstre"),
	MorathiKhaine("Morathi-Khaine"),
	Ordre("Ordre"),
	Sorcier("Sorcier"),
	Unique("Unique"),
	Pretre("Prêtre"),
	BloodwrackMedusa("Bloodwrack Medusa"),
	MelusaiIronscale("Melusai Ironscale"),
	Melusai("Melusai"),
	Totem("Totem"),
	BloodwrackShrine("Bloodwrack Shrine"),
	HaggNar("Hagg Nar"),
	LaBladeCoven("La Blade-Coven"),
	MorgwaethTheBloodied("Morgwaeth the Bloodied"),
	HagQueen("Hag Queen"),
	SlaughterQueen("Slaughter Queen"),
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
