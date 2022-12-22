package armybuilder.model.stormcast;

import java.util.function.Consumer;
import java.util.function.Function;

import armybuilder.model.unit.Unit;
import armybuilder.model.unit.keyword.KeyWord;
import armybuilder.model.unit.option.IUnitOption;
import armybuilder.model.unit.option.UnitOptionCategory;

public enum StormcastOptimisation implements IUnitOption {

	ChocEtStupeur(UnitOptionCategory.TraisDeCommandement,
			u -> u.is(UnitOptionCategory.General) && !u.is(KeyWord.Unique)),
	FerventDefenseur(UnitOptionCategory.TraisDeCommandement,
			u -> u.is(UnitOptionCategory.General) && !u.is(KeyWord.Unique)),
	MessagerDesCieux(UnitOptionCategory.TraisDeCommandement,
			u -> u.is(UnitOptionCategory.General) && !u.is(KeyWord.Unique)),
	MaitreDeLaMenagerieCeleste(UnitOptionCategory.TraisDeCommandement,
			u -> u.is(UnitOptionCategory.General) && !u.is(KeyWord.Unique) && u.is(KeyWord.Monstre)),

	// Aptitude de commandement, cette option n'existe pas : TODO
	AppelALAide(UnitOptionCategory.TraisDeCommandement, u -> true),
	CoupDeTonerreFinal(UnitOptionCategory.TraisDeCommandement, u -> true),
	DechainezVotreAine(UnitOptionCategory.TraisDeCommandement, u -> true),
	MarcheImpertubable(UnitOptionCategory.TraisDeCommandement, u -> true),
	VoleeDEclairs(UnitOptionCategory.TraisDeCommandement, u -> true),

	AmuletteDeSigmarite(UnitOptionCategory.Artefact, u -> true),
	AmuletteDObsidienne(UnitOptionCategory.Artefact, u -> true),
	ArmureDecaillesDeDrac(UnitOptionCategory.Artefact, u -> true),
	BouclierMiroir(UnitOptionCategory.Artefact, u -> true),
	BreuvageDeVifArgent(UnitOptionCategory.Artefact, u -> true),
	CrocDeDracothion(UnitOptionCategory.Artefact, u -> true),
	LameDeHero(UnitOptionCategory.Artefact, u -> true),
	MarteauDePuissance(UnitOptionCategory.Artefact, u -> true),
	PierreDeChance(UnitOptionCategory.Artefact, u -> true),

	AnnihilatorPrimus(UnitOptionCategory.Chef, u -> u.is(KeyWord.Annihilators)),
	CastigatorPrimus(UnitOptionCategory.Chef, u -> u.is(KeyWord.Castigators)),
	EvocatorPrimus(UnitOptionCategory.Chef, u -> u.is(KeyWord.Evocators)),
	JudicatorArcPrimus(UnitOptionCategory.Chef, u -> u.is(KeyWord.JudicatorsArc)),
	GryphDogueAlpha(UnitOptionCategory.Chef, u -> u.is(KeyWord.GryphDogues)),
	LiberatorPrimus(UnitOptionCategory.Chef, u -> u.is(KeyWord.Liberators)),
	PraetorPrimus(UnitOptionCategory.Chef, u -> u.is(KeyWord.Praetors)),
	ProsecutorPrimus(UnitOptionCategory.Chef, u -> u.is(KeyWord.Prosecutors)),
	RetributorPrimus(UnitOptionCategory.Chef, u -> u.is(KeyWord.Retributors)),
	SequitorPrimus(UnitOptionCategory.Chef, u -> u.is(KeyWord.Sequitors), u -> {
		u.add(StormcastRule.SequitorPrimus);
		u.add(StormcastRule.CacheDeRedemption);
	}),
	VindictorPrimus(UnitOptionCategory.Chef, u -> u.is(KeyWord.Vindictors)),

	SignifereAzyrite(UnitOptionCategory.Banniere, u -> u.is(KeyWord.Vindictors)),

	ArmeDesCieuxEtBouclierDeSigmarite(
			"Arme des Cieux & Bouclier de Sigmarite",
			UnitOptionCategory.Armes,
			u -> u.is(KeyWord.Liberators),
			u -> {
				u.add(StormcastWeapons.ArmeDesCieux);
				u.add(StormcastRule.BouclierDeSigmarite);
			}),
	PaireDArmesDesCieux(
			"Paire d'Armes des Cieux",
			UnitOptionCategory.Armes,
			u -> u.is(KeyWord.Liberators),
			u -> u.add(StormcastWeapons.PairesDArmesDesCieux)),

	MarteauCelesteEtBouclierDeSigmarite(
			"Marteau Céleste & Bouclier de Sigmarite",
			UnitOptionCategory.Armes,
			u -> u.is(KeyWord.ProsecutorsMarteaux),
			u -> {
				u.add(StormcastWeapons.MarteauxCelestesMelee);
				u.add(StormcastWeapons.MarteauxCelestesProjectil);
				u.add(StormcastRule.BouclierDeSigmarite);
			}),
	PaireDeMarteauxCelestes(
			"Paire de Marteaux Célestes",
			UnitOptionCategory.Armes,
			u -> u.is(KeyWord.ProsecutorsMarteaux),
			u -> {
				u.add(StormcastWeapons.PaireDeMarteauxCelestesMelee);
				u.add(StormcastWeapons.PaireDeMarteauxCelestesProjectil);
			}),

	// TODO Sort et priere et trais de monture

	;

	private String displayName;
	private UnitOptionCategory category;
	private Function<Unit, Boolean> available;
	private Consumer<Unit> decorate;

	StormcastOptimisation(UnitOptionCategory category, Function<Unit, Boolean> available) {
		this.displayName = StormcastRule.valueOf(name()).getDisplayName();
		this.category = category;
		this.available = available;
	}

	StormcastOptimisation(UnitOptionCategory category, Function<Unit, Boolean> available, Consumer<Unit> decorate) {
		this(category, available);
		this.decorate = decorate;
	}

	StormcastOptimisation(String displayName, UnitOptionCategory category, Function<Unit, Boolean> available,
			Consumer<Unit> decorate) {
		this.displayName = displayName;
		this.category = category;
		this.available = available;
		this.decorate = decorate;
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
		return unit.is(KeyWord.StormCast) && available.apply(unit);
	}

	@Override
	public void decorate(Unit unit) {
		if (decorate == null) {
			unit.add(StormcastRule.valueOf(name()));
		} else {
			decorate.accept(unit);
		}
	}

}
