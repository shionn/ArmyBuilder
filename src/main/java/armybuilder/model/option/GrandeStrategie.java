package armybuilder.model.option;

import armybuilder.model.Army;

public enum GrandeStrategie implements IArmyOptionValue<GrandeStrategie> {
	CoupezLaTete("Coupez la Tête"), Vendetta("Vendetta"), TenezLaLigne("Tenez la Ligne");

	private String displayName;

	private GrandeStrategie(String displayName) {
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
		return army.getOption(ArmyOption.PackDeBataille) == PackDeBataille.LutteDeGeneraux;
	}

	@Override
	public void rebuild(Army army) {
	}

}
