package armybuilder.model.army.option;

import java.util.function.BiFunction;

import armybuilder.model.army.OldArmy;
import armybuilder.model.army.rule.IArmyRule;
import armybuilder.model.unit.Unit;

public enum DisplayUnit implements IListingOptionValue<DisplayUnit> {
	Full("Complet", (u, r) -> true),
	Minimal("Sans la Charte", (u, r) -> !(u.getModel().getRules().contains(r)));

	private String displayName;
	private BiFunction<Unit, IArmyRule<?>, Boolean> display;

	DisplayUnit(String displayName, BiFunction<Unit, IArmyRule<?>, Boolean> display) {
		this.displayName = displayName;
		this.display = display;
	}

	public boolean display(Unit unit, IArmyRule<?> rule) {
		return display.apply(unit, rule);
	}

	@Override
	public String getDisplayName() {
		return displayName;
	}

	@Override
	public ListingOption getOption() {
		return ListingOption.DisplayUnit;
	}

	@Override
	public boolean isOptionDisplayed(OldArmy army) {
		return true;
	}

	@Override
	public void rebuild(OldArmy army) {
	}

	@Override
	public boolean isAvailable(OldArmy army, Unit unit) {
		return true;
	}

}
