package armybuilder.model.army.option;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

import armybuilder.model.army.OldArmy;
import armybuilder.model.army.rule.PackDeBataille2021Rule;
import armybuilder.model.unit.KeyWord;
import armybuilder.model.unit.Unit;

public enum PackDeBataille implements IListingOptionValue<PackDeBataille> {
	LutteDeGeneraux(
			"Lutte de Généraux",
			Arrays.asList()),

	BataillesRangees2021(
			"Batailles Rangées 2021",
			Arrays.asList(
					a -> a.units(KeyWord.Sorcier)
							.forEach(u -> u.add(PackDeBataille2021Rule.Metamorphose)),
					a -> a.units(KeyWord.Monstre)
							.forEach(u -> a.addRule(PackDeBataille2021Rule.RugissementSauvage)))),

	PourLaGloire(
			"Pour la Gloire",
			Arrays.asList())

	;

	private String displayName;
	private List<Consumer<OldArmy>> modifiers;

	private PackDeBataille(String displayName, List<Consumer<OldArmy>> modifiers) {
		this.displayName = displayName;
		this.modifiers = modifiers;
	}

	@Override
	public String getDisplayName() {
		return displayName;
	}

	@Override
	public ListingOption getOption() {
		return ListingOption.PackDeBataille;
	}

	@Override
	public boolean isOptionDisplayed(OldArmy army) {
		return true;
	}

	@Override
	public void rebuild(OldArmy army) {
		modifiers.stream().forEach(m -> m.accept(army));
	}

	@Override
	public boolean isAvailable(OldArmy army, Unit unit) {
		return false;
	}

}
