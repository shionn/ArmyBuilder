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
	;

	private String displayName;

	private KeyWord(String displayName) {
		this.displayName = displayName;
	}

	public String getDisplayName() {
		return displayName;
	}
}
