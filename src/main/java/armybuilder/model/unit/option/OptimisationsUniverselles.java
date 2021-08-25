package armybuilder.model.unit.option;

import java.util.Arrays;
import java.util.function.BiFunction;
import java.util.function.Consumer;

import armybuilder.model.Army;
import armybuilder.model.option.PackDeBataille;
import armybuilder.model.rule.GeneriqueUnitRule;
import armybuilder.model.unit.KeyWord;
import armybuilder.model.unit.RoleTactique;
import armybuilder.model.unit.Unit;

public enum OptimisationsUniverselles implements IUnitOptionValue<OptimisationsUniverselles> {

	SoifDeBataille(
			"Soif de Bataille",
			UnitOption.TraisDeCommandement,
			(a, u) -> u.is(UnitOption.General) && !u.is(KeyWord.Unique)),
	LeaderCompétent(
			"Leader Compétent",
			UnitOption.TraisDeCommandement,
			(a, u) -> u.is(UnitOption.General) && !u.is(KeyWord.Unique)),
	GrandPretre(
			"Grand Prêtre",
			UnitOption.TraisDeCommandement,
			(a, u) -> u.is(UnitOption.General) && !u.is(KeyWord.Unique) && u.is(KeyWord.Pretre)),
	StatureHeroïque(
			"Stature Héroïque",
			UnitOption.TraisDeCommandement,
			(a, u) -> u.is(UnitOption.General) && !u.is(KeyWord.Unique)),
	MaitreDeLaMagie(
			"Maître de la Magie",
			UnitOption.TraisDeCommandement,
			(a, u) -> u.is(UnitOption.General) && !u.is(KeyWord.Unique) && u.is(KeyWord.Sorcier)),

	AmuletteDeLaDestinee(
			"Amulette de la Destinée",
			UnitOption.Artefact,
			(a, u) -> !u.is(KeyWord.Unique)),
	VolumeObscur("Volume Obscur", UnitOption.Artefact, (a, u) -> !u.is(KeyWord.Unique)),
	FioleDeVeninDeManticore(
			"Fiole de Venin de Manticore",
			UnitOption.Artefact,
			(a, u) -> !u.is(KeyWord.Unique)),
	GraineDeRenaissance(
			"Graine de Renaissance",
			UnitOption.Artefact,
			(a, u) -> !u.is(KeyWord.Unique)),

	ArmeEnflammee(
			"Arme Enflammée",
			UnitOption.Sort,
			(a, u) -> u.is(KeyWord.Sorcier) && !u.is(KeyWord.Unique),
			u -> u.add(GeneriqueUnitRule.ArmeEnflammee)),
	BrumeFantome(
			"Brume Fantôme",
			UnitOption.Sort,
			(a, u) -> u.is(KeyWord.Sorcier) && !u.is(KeyWord.Unique),
			u -> u.add(GeneriqueUnitRule.BrumeFantome)),
	Levitation(
			"Lévitation",
			UnitOption.Sort,
			(a, u) -> u.is(KeyWord.Sorcier) && !u.is(KeyWord.Unique),
			u -> u.add(GeneriqueUnitRule.Levitation)),

	Supervision(
			"Supervision",
			UnitOption.Priere,
			(a, u) -> u.is(KeyWord.Pretre) && !u.is(KeyWord.Unique),
			u -> u.add(GeneriqueUnitRule.Supervision)),
	Malediction(
			"Malédiction",
			UnitOption.Priere,
			(a, u) -> u.is(KeyWord.Pretre) && !u.is(KeyWord.Unique),
			u -> u.add(GeneriqueUnitRule.Malediction)),
	Guerison(
			"Guérison",
			UnitOption.Priere,
			(a, u) -> u.is(KeyWord.Pretre) && !u.is(KeyWord.Unique),
			u -> u.add(GeneriqueUnitRule.Guerison)),

	FormationDefensive(
			"Formation Défensive",
			UnitOption.AptitudeDeVeteran,
			(a, u) -> a.is(PackDeBataille.PourLaGloire) && !u.is(RoleTactique.Leader)
					&& !u.is(UnitOption.Gratuit),
			u -> u.add(AptitudeDeVeteran.FormationDefensive)),
	ManoeuvreDisciplinees(
			"Manoeuvre Disciplinées",
			UnitOption.AptitudeDeVeteran,
			(a, u) -> a.is(PackDeBataille.PourLaGloire) && !u.is(RoleTactique.Leader)
					&& !u.is(UnitOption.Gratuit),
			u -> u.add(AptitudeDeVeteran.ManoeuvreDisciplinees)),
	VoleeMortelle(
			"Volée Mortelle",
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
