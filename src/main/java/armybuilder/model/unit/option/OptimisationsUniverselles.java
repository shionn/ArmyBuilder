package armybuilder.model.unit.option;

import java.util.Arrays;
import java.util.function.BiFunction;
import java.util.function.Consumer;

import armybuilder.model.army.Army;
import armybuilder.model.army.option.PackDeBataille;
import armybuilder.model.army.rule.GeneriqueRule;
import armybuilder.model.unit.KeyWord;
import armybuilder.model.unit.RoleTactique;
import armybuilder.model.unit.Unit;
import armybuilder.model.unit.rule.GeneriqueUnitRule;

public enum OptimisationsUniverselles implements IUnitOptionValue<OptimisationsUniverselles> {

	SoifDeBataille(
			GeneriqueUnitRule.SoifDeBataille.getDisplayName(),
			UnitOption.TraisDeCommandement,
			(a, u) -> u.is(UnitOption.General) && !u.is(KeyWord.Unique),
			u -> u.add(GeneriqueUnitRule.SoifDeBataille)),
	LeaderCompétent(
			GeneriqueUnitRule.LeaderCompétent.getDisplayName(),
			UnitOption.TraisDeCommandement,
			(a, u) -> u.is(UnitOption.General) && !u.is(KeyWord.Unique),
			u -> u.add(GeneriqueUnitRule.LeaderCompétent)),
	GrandPretre(
			GeneriqueUnitRule.GrandPretre.getDisplayName(),
			UnitOption.TraisDeCommandement,
			(a, u) -> u.is(UnitOption.General) && !u.is(KeyWord.Unique) && u.is(KeyWord.Pretre),
			u -> u.add(GeneriqueUnitRule.GrandPretre)),
	StatureHeroïque(
			GeneriqueUnitRule.StatureHeroïque.getDisplayName(),
			UnitOption.TraisDeCommandement,
			(a, u) -> u.is(UnitOption.General) && !u.is(KeyWord.Unique),
			u -> u.add(GeneriqueUnitRule.StatureHeroïque)),
	MaitreDeLaMagie(
			GeneriqueUnitRule.MaitreDeLaMagie.getDisplayName(),
			UnitOption.TraisDeCommandement,
			(a, u) -> u.is(UnitOption.General) && !u.is(KeyWord.Unique) && u.is(KeyWord.Sorcier),
			u -> u.add(GeneriqueUnitRule.MaitreDeLaMagie)),

	AmuletteDeLaDestinee(
			GeneriqueUnitRule.AmuletteDeLaDestinee.getDisplayName(),
			UnitOption.Artefact,
			(a, u) -> !u.is(KeyWord.Unique),
			u -> u.add(GeneriqueUnitRule.AmuletteDeLaDestinee)),
	VolumeObscur(
			GeneriqueUnitRule.VolumeObscur.getDisplayName(),
			UnitOption.Artefact,
			(a, u) -> !u.is(KeyWord.Unique),
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
			(a, u) -> !u.is(KeyWord.Unique),
			u -> u.add(GeneriqueUnitRule.FioleDeVeninDeManticore)),
	GraineDeRenaissance(
			GeneriqueUnitRule.GraineDeRenaissance.getDisplayName(),
			UnitOption.Artefact,
			(a, u) -> !u.is(KeyWord.Unique),
			u -> u.add(GeneriqueUnitRule.GraineDeRenaissance)),

	ArmeEnflammee(
			GeneriqueUnitRule.ArmeEnflammee.getDisplayName(),
			UnitOption.Sort,
			(a, u) -> u.is(KeyWord.Sorcier) && !u.is(KeyWord.Unique),
			u -> u.add(GeneriqueUnitRule.ArmeEnflammee)),
	BrumeFantome(
			GeneriqueUnitRule.BrumeFantome.getDisplayName(),
			UnitOption.Sort,
			(a, u) -> u.is(KeyWord.Sorcier) && !u.is(KeyWord.Unique),
			u -> u.add(GeneriqueUnitRule.BrumeFantome)),
	Levitation(
			GeneriqueUnitRule.Guerison.getDisplayName(),
			UnitOption.Sort,
			(a, u) -> u.is(KeyWord.Sorcier) && !u.is(KeyWord.Unique),
			u -> u.add(GeneriqueUnitRule.Levitation)),

	Supervision(
			GeneriqueUnitRule.Supervision.getDisplayName(),
			UnitOption.Priere,
			(a, u) -> u.is(KeyWord.Pretre) && !u.is(KeyWord.Unique),
			u -> u.add(GeneriqueUnitRule.Supervision)),
	Malediction(
			GeneriqueUnitRule.Malediction.getDisplayName(),
			UnitOption.Priere,
			(a, u) -> u.is(KeyWord.Pretre) && !u.is(KeyWord.Unique),
			u -> u.add(GeneriqueUnitRule.Malediction)),
	Guerison(
			GeneriqueUnitRule.Guerison.getDisplayName(),
			UnitOption.Priere,
			(a, u) -> u.is(KeyWord.Pretre) && !u.is(KeyWord.Unique),
			u -> u.add(GeneriqueUnitRule.Guerison)),

	ChargeDevstratrice(
			AptitudeDeVeteran.ChargeDevastratrice.getDisplayName(),
			UnitOption.AptitudeDeVeteran,
			(a, u) -> a.is(PackDeBataille.PourLaGloire) && !u.is(RoleTactique.Leader)
					&& !u.is(UnitOption.Gratuit),
			u -> u.add(AptitudeDeVeteran.ChargeDevastratrice)),
	FormationDefensive(
			AptitudeDeVeteran.FormationDefensive.getDisplayName(),
			UnitOption.AptitudeDeVeteran,
			(a, u) -> a.is(PackDeBataille.PourLaGloire) && !u.is(RoleTactique.Leader)
					&& !u.is(UnitOption.Gratuit),
			u -> u.add(AptitudeDeVeteran.FormationDefensive)),
	ManoeuvreDisciplinees(
			AptitudeDeVeteran.ManoeuvreDisciplinees.getDisplayName(),
			UnitOption.AptitudeDeVeteran,
			(a, u) -> a.is(PackDeBataille.PourLaGloire) && !u.is(RoleTactique.Leader)
					&& !u.is(UnitOption.Gratuit),
			u -> u.add(AptitudeDeVeteran.ManoeuvreDisciplinees)),
	PiedsLegers(
			AptitudeDeVeteran.PiedsLegers.getDisplayName(),
			UnitOption.AptitudeDeVeteran,
			(a, u) -> a.is(PackDeBataille.PourLaGloire) && !u.is(RoleTactique.Leader)
					&& !u.is(UnitOption.Gratuit),
			u -> u.add(AptitudeDeVeteran.PiedsLegers)),
	VoleeMortelle(
			AptitudeDeVeteran.VoleeMortelle.getDisplayName(),
			UnitOption.AptitudeDeVeteran,
			(a, u) -> a.is(PackDeBataille.PourLaGloire) && !u.is(RoleTactique.Leader)
					&& !u.is(UnitOption.Gratuit),
			u -> u.add(AptitudeDeVeteran.VoleeMortelle)),

	General("Général", UnitOption.General, (a, u) -> u.getKeyWords().contains(KeyWord.Heros)),
	RenforceesUneFois(
			"Renforcées 1x",
			UnitOption.Renforcees,
			(a, u) -> (u.is(RoleTactique.Ligne) || u.is(RoleTactique.Elite))
					&& !u.is(UnitOption.Gratuit),
			u -> u.setValue(u.getValue() * 2)),
	RenforceesDeuxFois(
			"Renforcées 2x",
			UnitOption.Renforcees,
			(a, u) -> (u.is(RoleTactique.Ligne) || u.is(RoleTactique.Elite))
					&& !u.is(UnitOption.Gratuit),
			u -> u.setValue(u.getValue() * 3)),

	;

	private String displayName;
	private UnitOption option;
	private BiFunction<Army, Unit, Boolean> available;
	private Consumer<Unit> modifier;

	OptimisationsUniverselles(String displayName, UnitOption option,
			BiFunction<Army, Unit, Boolean> available) {
		this.displayName = displayName;
		this.option = option;
		this.available = available;
	}

	OptimisationsUniverselles(String displayName, UnitOption option,
			BiFunction<Army, Unit, Boolean> available, Consumer<Unit> modifier) {
		this.displayName = displayName;
		this.option = option;
		this.available = available;
		this.modifier = modifier;
	}

	@Override
	public String getDisplayName() {
		if (Arrays.asList(UnitOption.AptitudeDeVeteran, UnitOption.Renforcees).contains(option)) {
			return displayName;
		}
		return "Universel : " + displayName;
	}

	@Override
	public UnitOption getOption() {
		return option;
	}

	@Override
	public boolean isAvailable(Army army, Unit unit) {
		return available.apply(army, unit);
	}

	@Override
	public void rebuild(Unit unit) {
		if (modifier != null) {
			modifier.accept(unit);
		}
	}

}
