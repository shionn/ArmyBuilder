package armybuilder.model.stormcast;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import armybuilder.model.rule.IRule;
import armybuilder.model.rule.RuleType;
import armybuilder.serialisation.DescriptionReader;
import armybuilder.serialisation.EnumPropertyLoader;

public enum StormcastRule implements IRule<StormcastRule> {

	FlamboiementDeGloire(RuleType.TraisDeBataille),
	DescendantsDeLOrage(RuleType.TraisDeBataille),

	AuraMorbide(RuleType.TraisDeBataille),
	ClairvoyanceIntrepide(RuleType.TraisDeBataille),
	EchecInterdit(RuleType.TraisDeBataille),
	LOstAltier(RuleType.TraisDeBataille),
	MusParLaVengeance(RuleType.TraisDeBataille),
	Rabatteurs(RuleType.TraisDeBataille),
	SeulementLesFideles(RuleType.TraisDeBataille),
	TempeteDAnnihilation(RuleType.TraisDeBataille),

	ChocEtStupeur(RuleType.TraitsDeCommandement),
	FerventDefenseur(RuleType.TraitsDeCommandement),
	MaitreDeLaMenagerieCeleste(RuleType.TraitsDeCommandement),
	MessagerDesCieux(RuleType.TraitsDeCommandement),

	AppelALAide(RuleType.AptitudesDeCommandement),
	MarcheImpertubable(RuleType.AptitudesDeCommandement),
	VoleeDEclairs(RuleType.AptitudesDeCommandement),
	DechainezVotreAine(RuleType.AptitudesDeCommandement),
	CoupDeTonerreFinal(RuleType.AptitudesDeCommandement),

	AmuletteDeSigmarite(RuleType.Artefact),
	AmuletteDObsidienne(RuleType.Artefact),
	ArmureDecaillesDeDrac(RuleType.Artefact),
	BouclierMiroir(RuleType.Artefact),
	BreuvageDeVifArgent(RuleType.Artefact),
	CrocDeDracothion(RuleType.Artefact),
	LameDeHero(RuleType.Artefact),
	MarteauDePuissance(RuleType.Artefact),
	PierreDeChance(RuleType.Artefact),

	AlphaDeLaMeute(RuleType.Aptitude, RuleType.TraisUnitee),
	ArcsDeFoudreCeleste(RuleType.Aptitude, RuleType.TraisUnitee),
	ArmePolyvalente(RuleType.Aptitude, RuleType.TraisUnitee),
	ArsenalDAmesOrageuses(RuleType.Aptitude, RuleType.TraisUnitee),
	AttaquesAuPassage(RuleType.Aptitude, RuleType.TraisUnitee),
	BondTonitruant(RuleType.Aptitude, RuleType.TraisUnitee),
	BouclierDeSigmarite(RuleType.Aptitude, RuleType.TraisUnitee),
	CacheDeRedemption(RuleType.Aptitude, RuleType.TraisUnitee),
	CanalisationEtheriqueDeCastigators(RuleType.Aptitude, RuleType.TraisUnitee),
	CanalisationEtheriqueDeSequitors(RuleType.Aptitude, RuleType.TraisUnitee),
	ChevaucherLesVentsEtheriques(RuleType.Aptitude, RuleType.TraisUnitee),
	ChefEminent(RuleType.Aptitude, RuleType.TraisUnitee),
	CriDAlarme(RuleType.Aptitude, RuleType.TraisUnitee),
	CycleDeLOrage(RuleType.Aptitude, RuleType.TraisUnitee),
	DeflagrationCeleste(RuleType.Aptitude, RuleType.TraisUnitee),
	EnergieSpirituelleDuPremierOst(RuleType.Aptitude, RuleType.TraisUnitee),
	ExplosionDEnergieCeleste(RuleType.Aptitude, RuleType.TraisUnitee),
	FormationDispersee(RuleType.Aptitude, RuleType.TraisUnitee),
	GardiensAuxAmesSoudees(RuleType.Aptitude, RuleType.TraisUnitee),
	GuidesParLaFoudre(RuleType.Aptitude, RuleType.TraisUnitee),
	HerautsDeVertu(RuleType.Aptitude, RuleType.TraisUnitee),
	ImpactFlamboyant(RuleType.Aptitude, RuleType.TraisUnitee),
	ImpulsionFoudroyante(RuleType.Aptitude, RuleType.TraisUnitee),
	LaForceDUneEtoileFilante(RuleType.Aptitude, RuleType.TraisUnitee),
	MasseDAsterie(RuleType.Aptitude, RuleType.TraisUnitee),
	PretreMortis(RuleType.Aptitude, RuleType.TraisUnitee),
	ReduitsEnCendres(RuleType.Aptitude, RuleType.TraisUnitee),
	RenversezLesTyrans(RuleType.Aptitude, RuleType.TraisUnitee),
	SorcierEvocators(RuleType.Aptitude, RuleType.TraisUnitee),
	CoffretRedempteur(RuleType.Aptitude, RuleType.TraisUnitee),

	OrageGuerisseur(RuleType.Priere),
	OrageFoudroyant(RuleType.Priere),
	BenedictionDesArmes_12(RuleType.Priere),
	BenedictionDesArmes_18(RuleType.Priere),
	Translocation(RuleType.Priere),
	LumiereDivine(RuleType.Priere),

	Essor(RuleType.Sort),
	SalveDEclairs(RuleType.Sort),
	HaloAzyrite(RuleType.Sort),
	LamesCelestes(RuleType.Sort),
	ChocDuTonnerre(RuleType.Sort),
	ChuteDEtoile(RuleType.Sort),
	ChaineDEclairs(RuleType.Sort),
	LanceDOrage(RuleType.Sort),
	LumiereGuerisseuse(RuleType.Sort),
	SoufflePurificateur(RuleType.Sort),

	AnnihilatorPrimus(RuleType.Composition),
	CastigatorPrimus(RuleType.Composition),
	EvocatorPrimus(RuleType.Composition),
	GryphDogueAlpha(RuleType.Composition),
	JudicatorArcPrimus(RuleType.Composition),
	LiberatorPrimus(RuleType.Composition),
	PraetorPrimus(RuleType.Composition),
	ProsecutorPrimus(RuleType.Composition),
	RetributorPrimus(RuleType.Composition),
	SequitorPrimus(RuleType.Composition),
	SignifereAzyrite(RuleType.Composition),
	VindictorPrimus(RuleType.Composition),

	VitesseEtherique(RuleType.TraitsDeMonture),
	MessagerDeLaFoudre(RuleType.TraitsDeMonture),
	InstinctCeleste(RuleType.TraitsDeMonture),
	TraineeScintillante(RuleType.TraitsDeMonture),
	LumiereDesJeunesEtoiles(RuleType.TraitsDeMonture),
	PresenceTonitruante(RuleType.TraitsDeMonture),

	;

	private List<RuleType> types;
	private String displayName;

	private StormcastRule(RuleType... types) {
		this.displayName = EnumPropertyLoader.instance().name(this);
		this.types = Arrays.asList(types);
	}

	@Override
	public String getDisplayName() {
		return displayName;
	}

	@Override
	public List<RuleType> getTypes() {
		return types;
	}

	@Override
	public String getDescription() throws IOException {
		return new DescriptionReader().read("Stormcast/", name());
	}

}
