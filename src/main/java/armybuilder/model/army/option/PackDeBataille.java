package armybuilder.model.army.option;

import java.util.function.Consumer;

import armybuilder.model.army.Listing;
import armybuilder.model.army.rule.PackDeBatailleRule;
import armybuilder.model.unit.KeyWord;
import armybuilder.model.unit.RoleTactique;

public enum PackDeBataille implements IListingOptionValue<PackDeBataille> {
	LutteDeGeneraux("Lutte de Généraux", null), 
	BataillesRangees2021("Batailles Rangées 2021", a -> {
		a.units(KeyWord.Sorcier).forEach(u -> u.add(PackDeBatailleRule.Metamorphose));
		a.units(KeyWord.Monstre).forEach(u -> u.add(PackDeBatailleRule.RugissementSauvage));
	}),
	BataillesRangees2022("Batailles Rangées 2022", a -> {
		a.units(RoleTactique.Ligne)
				.stream()
				.filter(u -> u.model().profile().getIntLife() <= 4)
				.forEach(u -> u.add(KeyWord.VeteransDeGallet));
		a.units(KeyWord.Sorcier).forEach(u -> u.add(PackDeBatailleRule.RegardDeGhur));
	});

	private String displayName;
	private Consumer<Listing> modifier;

	private PackDeBataille(String displayName, Consumer<Listing> modifier) {
		this.displayName = displayName;
		this.modifier = modifier;
	}

	@Override
	public String displayName() {
		return displayName;
	}

	@Override
	public ListingOption option() {
		return ListingOption.PackDeBataille;
	}

	@Override
	public boolean availableFor(Listing listing) {
		return true;
	}

	@Override
	public void rebuild(Listing listing) {
		if (modifier != null) {
			modifier.accept(listing);
		}
	}
}
