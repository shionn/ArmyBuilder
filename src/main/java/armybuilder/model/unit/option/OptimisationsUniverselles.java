package armybuilder.model.unit.option;

import java.util.Arrays;
import java.util.function.Consumer;
import java.util.function.Function;

import armybuilder.model.army.rule.GeneriqueRule;
import armybuilder.model.unit.KeyWord;
import armybuilder.model.unit.RoleTactique;
import armybuilder.model.unit.Unit;
import armybuilder.model.unit.rule.GeneriqueUnitRule;

public enum OptimisationsUniverselles implements IUnitOptionValue<OptimisationsUniverselles> {

	SoifDeBataille(
			GeneriqueUnitRule.SoifDeBataille.getDisplayName(),
			UnitOption.TraisDeCommandement,
			u -> u.is(UnitOption.General) && !u.is(KeyWord.Unique),
			u -> u.add(GeneriqueUnitRule.SoifDeBataille)),
	LeaderCompetent(
			GeneriqueUnitRule.LeaderCompetent.getDisplayName(),
			UnitOption.TraisDeCommandement,
			u -> u.is(UnitOption.General) && !u.is(KeyWord.Unique),
			u -> u.add(GeneriqueUnitRule.LeaderCompetent)),
	GrandPretre(
			GeneriqueUnitRule.GrandPretre.getDisplayName(),
			UnitOption.TraisDeCommandement,
			u -> u.is(UnitOption.General) && !u.is(KeyWord.Unique) && u.is(KeyWord.Pretre),
			u -> u.add(GeneriqueUnitRule.GrandPretre)),
	StatureHeroique(
			GeneriqueUnitRule.StatureHeroique.getDisplayName(),
			UnitOption.TraisDeCommandement,
			u -> u.is(UnitOption.General) && !u.is(KeyWord.Unique),
			u -> u.add(GeneriqueUnitRule.StatureHeroique)),
	MaitreDeLaMagie(
			GeneriqueUnitRule.MaitreDeLaMagie.getDisplayName(),
			UnitOption.TraisDeCommandement,
			u -> u.is(UnitOption.General) && !u.is(KeyWord.Unique) && u.is(KeyWord.Sorcier),
			u -> u.add(GeneriqueUnitRule.MaitreDeLaMagie)),

	AmuletteDeLaDestinee(
			GeneriqueUnitRule.AmuletteDeLaDestinee.getDisplayName(),
			UnitOption.Artefact,
			u -> !u.is(KeyWord.Unique),
			u -> u.add(GeneriqueUnitRule.AmuletteDeLaDestinee)),
	VolumeObscur(
			GeneriqueUnitRule.VolumeObscur.getDisplayName(),
			UnitOption.Artefact,
			u -> !u.is(KeyWord.Unique),
			u -> {
				u.add(GeneriqueUnitRule.VolumeObscur);
				if (!u.is(KeyWord.Sorcier)) {
					u.add(KeyWord.Sorcier);
					u.add(GeneriqueUnitRule.Sorcier_1_1);
					u.add(GeneriqueRule.TraitMagique);
					u.add(GeneriqueRule.BouclierMystique);
				}
			}),
	FioleDeVeninDeManticore(
			GeneriqueUnitRule.FioleDeVeninDeManticore.getDisplayName(),
			UnitOption.Artefact,
			u -> !u.is(KeyWord.Unique),
			u -> u.add(GeneriqueUnitRule.FioleDeVeninDeManticore)),
	GraineDeRenaissance(
			GeneriqueUnitRule.GraineDeRenaissance.getDisplayName(),
			UnitOption.Artefact,
			u -> !u.is(KeyWord.Unique),
			u -> u.add(GeneriqueUnitRule.GraineDeRenaissance)),

	ArmeEnflammee(
			GeneriqueUnitRule.ArmeEnflammee.getDisplayName(),
			UnitOption.Sort,
			u -> u.is(KeyWord.Sorcier) && !u.is(KeyWord.Unique),
			u -> u.add(GeneriqueUnitRule.ArmeEnflammee)),
	BrumeFantome(
			GeneriqueUnitRule.BrumeFantome.getDisplayName(),
			UnitOption.Sort,
			u -> u.is(KeyWord.Sorcier) && !u.is(KeyWord.Unique),
			u -> u.add(GeneriqueUnitRule.BrumeFantome)),
	Levitation(
			GeneriqueUnitRule.Guerison.getDisplayName(),
			UnitOption.Sort,
			u -> u.is(KeyWord.Sorcier) && !u.is(KeyWord.Unique),
			u -> u.add(GeneriqueUnitRule.Levitation)),

	Supervision(
			GeneriqueUnitRule.Supervision.getDisplayName(),
			UnitOption.Priere,
			u -> u.is(KeyWord.Pretre) && !u.is(KeyWord.Unique),
			u -> u.add(GeneriqueUnitRule.Supervision)),
	Malediction(
			GeneriqueUnitRule.Malediction.getDisplayName(),
			UnitOption.Priere,
			u -> u.is(KeyWord.Pretre) && !u.is(KeyWord.Unique),
			u -> u.add(GeneriqueUnitRule.Malediction)),
	Guerison(
			GeneriqueUnitRule.Guerison.getDisplayName(),
			UnitOption.Priere,
			u -> u.is(KeyWord.Pretre) && !u.is(KeyWord.Unique),
			u -> u.add(GeneriqueUnitRule.Guerison)),

	General("Général", UnitOption.General, u -> u.getKeyWords().contains(KeyWord.Heros)),
	RenforceesUneFois(
			"Renforcées 1x",
			UnitOption.Renforcees,
			u -> (u.is(RoleTactique.Ligne) || u.is(RoleTactique.Elite))
					&& !u.is(UnitOption.Gratuit),
			u -> u.setPoints(u.getModel().getPoints() * 2)),
	RenforceesDeuxFois(
			"Renforcées 2x",
			UnitOption.Renforcees,
			u -> (u.is(RoleTactique.Ligne) || u.is(RoleTactique.Elite))
					&& !u.is(UnitOption.Gratuit),
			u -> u.setPoints(u.getModel().getPoints() * 3)),

	;

	private String displayName;
	private UnitOption option;
	private Function<Unit, Boolean> available;
	private Consumer<Unit> modifier;

	OptimisationsUniverselles(String displayName, UnitOption option,
			Function<Unit, Boolean> available) {
		this.displayName = displayName;
		this.option = option;
		this.available = available;
	}

	OptimisationsUniverselles(String displayName, UnitOption option,
			Function<Unit, Boolean> available, Consumer<Unit> modifier) {
		this.displayName = displayName;
		this.option = option;
		this.available = available;
		this.modifier = modifier;
	}

	@Override
	public String getDisplayName() {
		if (Arrays.asList(UnitOption.Renforcees).contains(option)) {
			return displayName;
		}
		return "Universel : " + displayName;
	}

	@Override
	public UnitOption option() {
		return option;
	}

	@Override
	public boolean isAvailable(Unit unit) {
		return available.apply(unit);
	}

	@Override
	public void rebuild(Unit unit) {
		if (modifier != null) {
			modifier.accept(unit);
		}
	}

}
