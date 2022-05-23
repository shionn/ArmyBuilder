package armybuilder.model.army.option;

import java.util.function.Consumer;

import armybuilder.model.army.Listing;
import armybuilder.model.army.rule.GeneriqueRule;
import armybuilder.model.army.rule.PackDeBataille2021Rule;
import armybuilder.model.unit.KeyWord;

public enum PackDeBataille implements IListingOptionValue<PackDeBataille> {
	LutteDeGeneraux("Lutte de Généraux", a -> {
		a.units(KeyWord.Sorcier).forEach(u -> {
			u.add(GeneriqueRule.TraitMagique);
			u.add(GeneriqueRule.BouclierMystique);
		});
	}), 
	BataillesRangees2021("Batailles Rangées 2021", a -> {
		a.units(KeyWord.Sorcier)
				.forEach(u -> { 
					u.add(PackDeBataille2021Rule.Metamorphose);
					u.add(GeneriqueRule.TraitMagique);
					u.add(GeneriqueRule.BouclierMystique);
				});
		a.units(KeyWord.Monstre).forEach(u -> u.add(PackDeBataille2021Rule.RugissementSauvage));
	});

	private String displayName;
	private Consumer<Listing> modifiers;

	private PackDeBataille(String displayName, Consumer<Listing> modifier) {
		this.displayName = displayName;
		this.modifiers = modifier;
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
		if (modifiers != null) {
			modifiers.accept(listing);
		}
	}
}
