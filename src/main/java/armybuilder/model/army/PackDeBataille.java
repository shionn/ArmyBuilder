package armybuilder.model.army;

import java.util.function.Consumer;

import armybuilder.model.IHaveDisplayName;
import armybuilder.model.rule.PackDeBatailleRule;
import armybuilder.model.unit.keyword.KeyWord;
import armybuilder.model.unit.role.RoleTactique;

public enum PackDeBataille implements IHaveDisplayName, IDecoreArmy {
	LutteDeGeneraux("Lutte de Généraux", null),
	BataillesRangees2021("Batailles Rangées 2021", a -> {
		a.units(KeyWord.Sorcier).forEach(u -> u.add(PackDeBatailleRule.Metamorphose));
		a.units(KeyWord.Monstre).forEach(u -> u.add(PackDeBatailleRule.RugissementSauvage));
		// TODO Tactique de Bataille
	}),
	BataillesRangees2022("Batailles Rangées 2022", a -> {
		a.units(RoleTactique.Ligne)
				.stream()
				.filter(u -> u.getModel().getProfile().getIntLife() <= 4)
				.forEach(u -> u.add(KeyWord.VeteransDeGallet));
		a.units(KeyWord.Sorcier).forEach(u -> u.add(PackDeBatailleRule.RegardDeGhur));
		// TODO Tactique de Bataille
	});

	private String displayName;
	private Consumer<Army> modifier;

	private PackDeBataille(String displayName, Consumer<Army> modifier) {
		this.displayName = displayName;
		this.modifier = modifier;
	}

	@Override
	public String getDisplayName() {
		return displayName;
	}

	public void decorate(Army army) {
		if (modifier != null) {
			modifier.accept(army);
		}
	}
}