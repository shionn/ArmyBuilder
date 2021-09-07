package armybuilder.model.army.option;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

import armybuilder.model.army.Army;
import armybuilder.model.army.check.Checkers;
import armybuilder.model.army.rule.PackDeBataille2021Rule;
import armybuilder.model.unit.KeyWord;
import armybuilder.model.unit.RoleTactique;

public enum PackDeBataille implements IArmyOptionValue<PackDeBataille> {
	LutteDeGeneraux(
			"Lutte de Généraux",
			Arrays.asList(Checkers.composition(0, 750, 1, 2, RoleTactique.Leader),
					Checkers.composition(0, 750, 1, -1, RoleTactique.Ligne),
					Checkers.composition(0, 750, 0, 1, RoleTactique.Behemoth),
					Checkers.composition(0, 750, 0, 1, RoleTactique.Artillerie),
					Checkers.composition(0, 750, 0, 1, RoleTactique.SortsPersistantsEtInvocation),

					Checkers.composition(751, 1000, 1, 3, RoleTactique.Leader),
					Checkers.composition(751, 1000, 2, -1, RoleTactique.Ligne),
					Checkers.composition(751, 1000, 0, 2, RoleTactique.Behemoth),
					Checkers.composition(751, 1000, 0, 2, RoleTactique.Artillerie),
					Checkers.composition(751, 1000, 0, 2,
							RoleTactique.SortsPersistantsEtInvocation),

					Checkers.composition(1001, 1500, 1, 4, RoleTactique.Leader),
					Checkers.composition(1001, 1500, 2, -1, RoleTactique.Ligne),
					Checkers.composition(1001, 1500, 0, 3, RoleTactique.Behemoth),
					Checkers.composition(1001, 1500, 0, 3, RoleTactique.Artillerie),
					Checkers.composition(1001, 1500, 0, 2,
							RoleTactique.SortsPersistantsEtInvocation),

					Checkers.composition(1501, 2000, 1, 6, RoleTactique.Leader),
					Checkers.composition(1501, 2000, 3, -1, RoleTactique.Ligne),
					Checkers.composition(1501, 2000, 0, 4, RoleTactique.Behemoth),
					Checkers.composition(1501, 2000, 0, 4, RoleTactique.Artillerie),
					Checkers.composition(1501, 2000, 0, 3,
							RoleTactique.SortsPersistantsEtInvocation),

					Checkers.composition(2001, 3000, 1, 8, RoleTactique.Leader),
					Checkers.composition(2001, 3000, 4, -1, RoleTactique.Ligne),
					Checkers.composition(2001, 3000, 0, 6, RoleTactique.Behemoth),
					Checkers.composition(2001, 3000, 0, 6, RoleTactique.Artillerie),
					Checkers.composition(2001, 3000, 0, 4,
							RoleTactique.SortsPersistantsEtInvocation),

					(Army a) -> {
						int v = a.getValue() / 2;
						a.getUnits().stream().filter(u -> u.getValue() > v).findFirst()
								.ifPresent(u -> a.addError(
										"Vous ne pouvez pas dépenser plus de la moitier de vos points pour une seule unité."));
					}),
			Arrays.asList()),

	BataillesRangees2021(
			"Batailles Rangées 2021",
			Arrays.asList(Checkers.composition(0, 1000, 1, 3, RoleTactique.Leader),
					Checkers.composition(0, 1000, 2, -1, RoleTactique.Ligne),
					Checkers.composition(0, 1000, 0, 2, RoleTactique.Behemoth),
					Checkers.composition(0, 1000, 0, 2, RoleTactique.Artillerie),
					Checkers.composition(0, 1000, 0, 2, RoleTactique.SortsPersistantsEtInvocation),

					Checkers.composition(1001, 2000, 1, 6, RoleTactique.Leader),
					Checkers.composition(1001, 2000, 3, -1, RoleTactique.Ligne),
					Checkers.composition(1001, 2000, 0, 4, RoleTactique.Behemoth),
					Checkers.composition(1001, 2000, 0, 4, RoleTactique.Artillerie),
					Checkers.composition(1001, 2000, 0, 3,
							RoleTactique.SortsPersistantsEtInvocation)),
			Arrays.asList(
					a -> a.units(KeyWord.Sorcier)
							.forEach(u -> u.add(PackDeBataille2021Rule.Metamorphose)),
					a -> a.units(KeyWord.Monstre)
							.forEach(u -> a.addRule(PackDeBataille2021Rule.RugissementSauvage)))),

	PourLaGloire(
			"Pour la Gloire",
			Arrays.asList(Checkers.generalCantBe(KeyWord.Unique)),
			Arrays.asList())

	;

	private String displayName;
	private List<Consumer<Army>> checks;
	private List<Consumer<Army>> modifiers;

	private PackDeBataille(String displayName, List<Consumer<Army>> checks,
			List<Consumer<Army>> modifiers) {
		this.displayName = displayName;
		this.checks = checks;
		this.modifiers = modifiers;
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
		modifiers.stream().forEach(m -> m.accept(army));
	}

	@Override
	public void verify(Army army) {
		checks.stream().forEach(c -> c.accept(army));
	}

}
