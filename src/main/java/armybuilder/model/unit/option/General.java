package armybuilder.model.unit.option;

import armybuilder.model.IHaveDisplayName;

public enum General implements IUnitOption, IHaveDisplayName {
	True("Général"), False("");

	private String displayName;

	General(String displayName) {
		this.displayName = displayName;
	}

	@Override
	public String getDisplayName() {
		return displayName;
	}

}
