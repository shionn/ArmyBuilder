package armybuilder.v3.model.unit.option;

import java.util.function.Consumer;
import java.util.function.Function;

import armybuilder.v3.model.rule.GeneriqueRule;
import armybuilder.v3.model.rule.GeneriqueUnitRule;
import armybuilder.v3.model.unit.Unit;
import armybuilder.v3.model.unit.keyword.KeyWord;
import armybuilder.v3.model.unit.role.RoleTactique;

public enum OptimisationsUniverselles implements IUnitOption {

	SoifDeBataille(
			UnitOptionCategory.TraisDeCommandement,
			u -> u.is(UnitOptionCategory.General),
			u -> u.add(GeneriqueUnitRule.SoifDeBataille)),
	LeaderCompetent(
			UnitOptionCategory.TraisDeCommandement,
			u -> u.is(UnitOptionCategory.General),
			u -> u.add(GeneriqueUnitRule.LeaderCompetent)),
	GrandPretre(
			UnitOptionCategory.TraisDeCommandement,
			u -> u.is(UnitOptionCategory.General) && u.is(KeyWord.Pretre),
			u -> u.add(GeneriqueUnitRule.GrandPretre)),
	StatureHeroique(
			UnitOptionCategory.TraisDeCommandement,
			u -> u.is(UnitOptionCategory.General),
			u -> u.add(GeneriqueUnitRule.StatureHeroique)),
	MaitreDeLaMagie(
			UnitOptionCategory.TraisDeCommandement,
			u -> u.is(UnitOptionCategory.General) && u.is(KeyWord.Sorcier),
			u -> u.add(GeneriqueUnitRule.MaitreDeLaMagie)),

	AmuletteDeLaDestinee(
			GeneriqueUnitRule.AmuletteDeLaDestinee.getDisplayName(),
			UnitOptionCategory.Artefact,
			u -> !u.isOneOf(KeyWord.Unique, KeyWord.FilleDeKhaine, KeyWord.Hantenuits),
			u -> u.add(GeneriqueUnitRule.AmuletteDeLaDestinee)),
	VolumeObscur(
			GeneriqueUnitRule.VolumeObscur.getDisplayName(),
			UnitOptionCategory.Artefact,
			u -> !u.isOneOf(KeyWord.Unique),
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
			UnitOptionCategory.Artefact,
			u -> !u.is(KeyWord.Unique),
			u -> u.add(GeneriqueUnitRule.FioleDeVeninDeManticore)),
	GraineDeRenaissance(
			GeneriqueUnitRule.GraineDeRenaissance.getDisplayName(),
			UnitOptionCategory.Artefact,
			u -> !u.is(KeyWord.Unique),
			u -> u.add(GeneriqueUnitRule.GraineDeRenaissance)),

	ArmeEnflammee(
			GeneriqueUnitRule.ArmeEnflammee.getDisplayName(),
			UnitOptionCategory.Sort,
			u -> u.is(KeyWord.Sorcier) && !u.is(KeyWord.Unique),
			u -> u.add(GeneriqueUnitRule.ArmeEnflammee)),
	BrumeFantome(
			GeneriqueUnitRule.BrumeFantome.getDisplayName(),
			UnitOptionCategory.Sort,
			u -> u.is(KeyWord.Sorcier) && !u.is(KeyWord.Unique),
			u -> u.add(GeneriqueUnitRule.BrumeFantome)),
	Levitation(
			GeneriqueUnitRule.Levitation.getDisplayName(),
			UnitOptionCategory.Sort,
			u -> u.is(KeyWord.Sorcier) && !u.is(KeyWord.Unique),
			u -> u.add(GeneriqueUnitRule.Levitation)),

	Supervision(
			GeneriqueUnitRule.Supervision.getDisplayName(),
			UnitOptionCategory.Priere,
			u -> u.is(KeyWord.Pretre) && !u.is(KeyWord.Unique),
			u -> u.add(GeneriqueUnitRule.Supervision)),
	Malediction(
			GeneriqueUnitRule.Malediction.getDisplayName(),
			UnitOptionCategory.Priere,
			u -> u.is(KeyWord.Pretre) && !u.is(KeyWord.Unique),
			u -> u.add(GeneriqueUnitRule.Malediction)),
	Guerison(
			GeneriqueUnitRule.Guerison.getDisplayName(),
			UnitOptionCategory.Priere,
			u -> u.is(KeyWord.Pretre) && !u.is(KeyWord.Unique),
			u -> u.add(GeneriqueUnitRule.Guerison)),

	General("Général", UnitOptionCategory.General, u -> u.is(KeyWord.Heros)),
	Invoquee("Invoquée", UnitOptionCategory.Invoquee, u -> true),
	PasDeRenfort(
			"Pas de Renfort",
			UnitOptionCategory.Renforcees,
			u -> (u.is(RoleTactique.Ligne) || u.is(RoleTactique.Elite)) && !u.is(UnitOptionCategory.Invoquee)),
	RenforceesUneFois(
			"Renforcées 1x",
			UnitOptionCategory.Renforcees,
			u -> (u.is(RoleTactique.Ligne) || u.is(RoleTactique.Elite)) && !u.is(UnitOptionCategory.Invoquee),
			u -> u.setPoints(u.getPoints() * 2)),
	RenforceesDeuxFois(
			"Renforcées 2x",
			UnitOptionCategory.Renforcees,
			u -> (u.is(RoleTactique.Ligne)) && !u.is(UnitOptionCategory.Invoquee),
			u -> u.setPoints(u.getPoints() * 3)),

	;

	private String displayName;
	private UnitOptionCategory category;
	private Function<Unit, Boolean> available;
	private Consumer<Unit> modifier;

	OptimisationsUniverselles(String displayName, UnitOptionCategory option, Function<Unit, Boolean> available) {
		this.displayName = displayName;
		this.category = option;
		this.available = available;
	}

	OptimisationsUniverselles(UnitOptionCategory option, Function<Unit, Boolean> available, Consumer<Unit> modifier) {
		this.displayName = GeneriqueUnitRule.valueOf(name()).getDisplayName();
		this.category = option;
		this.available = available;
		this.modifier = modifier;
	}

	OptimisationsUniverselles(String displayName, UnitOptionCategory option,
			Function<Unit, Boolean> available, Consumer<Unit> modifier) {
		this.displayName = displayName;
		this.category = option;
		this.available = available;
		this.modifier = modifier;
	}

	@Override
	public String getDisplayName() {
		return displayName;
	}

	@Override
	public UnitOptionCategory getCategory() {
		return category;
	}

	@Override
	public boolean availableFor(Unit unit) {
		return available.apply(unit);
	}

	@Override
	public void decorate(Unit unit) {
		if (modifier != null) {
			modifier.accept(unit);
		}
	}

}
