package armybuilder.model;

public enum Faction {
	DOK("Daughters of Khaine");

	private String displayName;

	private Faction(String displayName) {
		this.displayName = displayName;
	}

	public String getDisplayName() {
		return displayName;
	}
}
