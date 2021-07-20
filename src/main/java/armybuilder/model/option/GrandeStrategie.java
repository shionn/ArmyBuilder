package armybuilder.model.option;

import armybuilder.model.Army;

public enum GrandeStrategie implements IArmyOption<GrandeStrategie> {
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
	public ArmyOptionType getType() {
		return ArmyOptionType.PackDeBataille;
	}

	@Override
	public boolean isOptionDisplayed(Army army) {
		return army.getOption(ArmyOptionType.PackDeBataille) == PackDeBataille.LutteDeGeneraux;
	}

	@Override
	public void rebuild(Army army) {
	}

}
