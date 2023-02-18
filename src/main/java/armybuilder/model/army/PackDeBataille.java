package armybuilder.model.army;

import java.util.function.Consumer;

import armybuilder.model.IHaveDisplayName;
import armybuilder.model.rule.PackDeBatailleRule;
import armybuilder.model.unit.keyword.KeyWord;
import armybuilder.model.unit.role.RoleTactique;

public enum PackDeBataille implements IHaveDisplayName, IDecoreArmy {
	LutteDeGeneraux("Lutte de Généraux", null),
	BataillesRangees2021("BR Saison 0 2021", a -> {
		a.units(KeyWord.Sorcier).forEach(u -> u.add(PackDeBatailleRule.Metamorphose));
		a.units(KeyWord.Monstre).forEach(u -> u.add(PackDeBatailleRule.RugissementSauvage));
		// TODO Tactique de Bataille
	}),
	BataillesRangees2022("BR Saison 1 2022", a -> {
		a.units(RoleTactique.Ligne)
				.stream()
				.filter(u -> u.getModel().getProfile().getIntLife() <= 4)
				.forEach(u -> u.add(KeyWord.VeteransDeGallet));
		a.units(KeyWord.Sorcier).forEach(u -> u.add(PackDeBatailleRule.RegardDeGhur));
		// TODO Tactique de Bataille
	}),
	BataillesRangees2023("BR Saison 2 2023", a -> {
		a.units(RoleTactique.Leader)
				.stream()
				.filter(u -> u.getModel().getProfile().getIntLife() < 10)
				.filter(u -> !u.is(KeyWord.Unique))
				.filter(u -> !u.is(KeyWord.Monture))
				.forEach(u -> u.add(KeyWord.ChampionDeGallet));
		a.units(KeyWord.ChampionDeGallet).forEach(u -> u.add(PackDeBatailleRule.CleDeLaVictoire));
		a.add(PackDeBatailleRule.ActionDeseperee, PackDeBatailleRule.FrappeDOuverture,
				PackDeBatailleRule.MenerParLExemple);
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
