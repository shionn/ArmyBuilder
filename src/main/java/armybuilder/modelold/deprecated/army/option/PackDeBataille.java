package armybuilder.modelold.deprecated.army.option;

import java.util.function.Consumer;

import armybuilder.model.unit.RoleTactique;
import armybuilder.modelold.deprecated.army.Listing;
import armybuilder.modelold.deprecated.army.rule.PackDeBatailleRule;
import armybuilder.modelold.deprecated.unit.KeyWord;

public enum PackDeBataille implements IListingOptionValue<PackDeBataille> {
	LutteDeGeneraux("Lutte de Généraux", null), 
	BataillesRangees2021("Batailles Rangées 2021", a -> {
		a.units(KeyWord.Sorcier).forEach(u -> u.add(PackDeBatailleRule.Metamorphose));
		a.units(KeyWord.Monstre).forEach(u -> u.add(PackDeBatailleRule.RugissementSauvage));
		// TODO Tactique de Bataille
	}),
	BataillesRangees2022("Batailles Rangées 2022", a -> {
		a.units(RoleTactique.Ligne)
				.stream()
				.filter(u -> u.model().getProfile().getIntLife() <= 4)
				.forEach(u -> u.add(KeyWord.VeteransDeGallet));
		a.units(KeyWord.Sorcier).forEach(u -> u.add(PackDeBatailleRule.RegardDeGhur));
		// TODO Tactique de Bataille
	});

	private String displayName;
	private Consumer<Listing> modifier;

	private PackDeBataille(String displayName, Consumer<Listing> modifier) {
		this.displayName = displayName;
		this.modifier = modifier;
	}

	@Override
	public String getDisplayName() {
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
