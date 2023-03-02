package armybuilder.model.army;

import java.util.function.Function;

import armybuilder.model.unit.keyword.KeyWord;
import armybuilder.model.unit.option.UnitOptionCategory;

public enum CheckRule {
	MissingGeneral(a -> count(a, UnitOptionCategory.General) < 1),
	MissingTraisDeCommandement(a -> count(a, UnitOptionCategory.TraisDeCommandement) < 1),
	MissingArtefact(a -> count(a, UnitOptionCategory.Artefact) < 1),
	MissingAspectDuChampion(
			a -> a.is(PackDeBataille.BataillesRangees2023) && count(a, UnitOptionCategory.AspectDuChampion) < 1),
	MissingSort(
			a -> a.getUnits().stream().filter(u -> u.is(KeyWord.Sorcier) && u.getSort() == null).findAny().isPresent()),
	MissingPriere(
			a -> a.getUnits()
					.stream()
					.filter(u -> u.is(KeyWord.Pretre) && u.getPriere() == null)
					.findAny()
					.isPresent()),
	MissingPTraisDeMonstre(a -> count(a, UnitOptionCategory.TraisDeMonstre) < 1 && a.count(KeyWord.Monstre) > 0),

	TooManyGeneral(a -> count(a, UnitOptionCategory.General) > 1),
	TooManyTraisDeCommandement(a -> count(a, UnitOptionCategory.TraisDeCommandement) > 1),
	TooManyArtefact(a -> count(a, UnitOptionCategory.Artefact) > 1),
	TooManyAspectDuChampion(a -> count(a, UnitOptionCategory.AspectDuChampion) > 1),

	;

	private Function<Army, Boolean> verify;

	private CheckRule(Function<Army, Boolean> verify) {
		this.verify = verify;
	}

	public boolean verify(Army army) {
		return verify.apply(army);
	}

	private static long count(Army army, UnitOptionCategory category) {
		return army.getUnits().stream().filter(u -> category.get(u) != null).count();
	}

}
