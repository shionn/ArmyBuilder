package armybuilder.model.option;

import armybuilder.model.Army;

public enum PackDeBataille implements IArmyOptionValue<PackDeBataille> {
	LutteDeGeneraux("Lutte de Généraux");

	private String displayName;

	private PackDeBataille(String displayName) {
		this.displayName = displayName;
	}
	@Override
	public String getDisplayName() {
		return displayName;
	}

	@Override
	public ArmyOption getOption() {
		return ArmyOption.PackDeBataille;
	}

	@Override
	public boolean isOptionDisplayed(Army army) {
		return true;
	}

	@Override
	public void rebuild(Army army) {
	}

	@Override
	public void verify(Army army) {

	}

}
