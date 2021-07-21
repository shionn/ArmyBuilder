package armybuilder.model.unit;

public enum UnitOption implements IUnitOption<UnitOption> {
	General("Général", UnitOptionType.Flag);

	private String displayName;
	private UnitOptionType type;

	private UnitOption(String displayName, UnitOptionType type) {
		this.displayName = displayName;
		this.type = type;
	}

	@Override
	public String getDisplayName() {
		return displayName;
	}

	@Override
	public UnitOptionType getType() {
		return type;
	}

}
