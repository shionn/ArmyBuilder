package armybuilder.model.skaven;

import java.util.Arrays;
import java.util.List;

import armybuilder.model.rule.IRule;
import armybuilder.model.rule.RuleType;
import armybuilder.model.rule.desc.Description;
import armybuilder.serialisation.EnumPropertyLoader;

public enum SkavenRule implements IRule<SkavenRule> {
	DirigerDepuisLArriere(RuleType.TraisDeBataille),
	SauveQuiPeut(RuleType.TraisDeBataille),
	LUnionFaitLaForce(RuleType.TraisDeBataille),

	// trais de co
	AdversaireSournois(RuleType.TraitsDeCommandement),
	AgiliteIncroyable(RuleType.TraitsDeCommandement),
	ArchitecteDeLaMort(RuleType.TraitsDeCommandement),
	CollectionneurEmerite(RuleType.TraitsDeCommandement),
	IntrigantDiabolique(RuleType.TraitsDeCommandement),
	InventeurDerange(RuleType.TraitsDeCommandement),
	MaitreDeLaMagie(RuleType.TraitsDeCommandement),
	MaitreDeLaPourritureEtDeLaRuine(RuleType.TraitsDeCommandement),
	MaitreDeHorde(RuleType.TraitsDeCommandement),
	MaitreDesOmbres(RuleType.TraitsDeCommandement),
	ManipulateurSupreme(RuleType.TraitsDeCommandement),
	ModeleurSupreme(RuleType.TraitsDeCommandement),
	MutateurAstucieux(RuleType.TraitsDeCommandement),
	PuissantAlpha(RuleType.TraitsDeCommandement),
	Scrofuleux(RuleType.TraitsDeCommandement),
	SeigneurSauvage(RuleType.TraitsDeCommandement),
	SuperviseurDeDestruction(RuleType.TraitsDeCommandement),
	TueurSansEgal(RuleType.TraitsDeCommandement),
	VaillanceVermineuse(RuleType.TraitsDeCommandement),

	// artos
	LeRongeclat(RuleType.Artefact),
	Skavenectar(RuleType.Artefact),
	SceptreDeSuprematieLegitime(RuleType.Artefact),
	FouetDeCrocs(RuleType.Artefact),
	CouronneEnragee(RuleType.Artefact),
	Salecuir(RuleType.Artefact),
	BabioleTenebromagnetique(RuleType.Artefact),
	CapeDetaleuse(RuleType.Artefact),
	Rongebombe(RuleType.Artefact),
	BouclierDeDistraction(RuleType.Artefact),
	ArmureDeMalerouille(RuleType.Artefact),
	CharmeDeMalepierre(RuleType.Artefact),
	ResonateurEsoteriqueAMalepierre(RuleType.Artefact),
	FioleDuFulminateur(RuleType.Artefact),
	LeFumigatus(RuleType.Artefact),
	CloquepusLeKysteVivant(RuleType.Artefact),
	LOrbeDAirain(RuleType.Artefact),
	LameDeCorruption(RuleType.Artefact),

	// sort et priere
	Brulure(RuleType.Sort),
	Evasion(RuleType.Sort),
	FrenesieMortelle(RuleType.Sort),
	PlusPlusPlusDeVilPouvoir(RuleType.Sort),
	ChaineDeMalefoudre(RuleType.Sort),
	BouclierDeMalefoudre(RuleType.Sort),
	PestePeste(RuleType.Priere),
	CrasseCrasse(RuleType.Priere),
	RageRage(RuleType.Priere),
	Fletrissement(RuleType.Sort),
	Malefoudre(RuleType.Sort),

	// aptitude des sous clan
	CreationsPrisees_1(RuleType.TraisDeBataille),
	CreationsPrisees_3(RuleType.TraisDeBataille),
	ManipulateursHabiles(RuleType.Aptitude),
	ToujoursTroisCoupsDeGriffesDAvance(RuleType.AptitudesDeCommandement),
	MaitresDuMeurtre_1(RuleType.TraisDeBataille),
	MaitresDuMeurtre_3(RuleType.TraisDeBataille),
	PuissantsChefsDeGuerre_1(RuleType.ActionsHeroiques),
	PuissantsChefsDeGuerre_3(RuleType.ActionsHeroiques),
	BougiesDeMalepierre_1(RuleType.TraisDeBataille),
	BougiesDeMalepierre_3(RuleType.TraisDeBataille),
	EchosDesGrandesPlaies(RuleType.TraisDeBataille),

	// aptitude d'unité
	AppelDesCrevasses(RuleType.Aptitude),
	ArmureSertieDeMalepierre(RuleType.Aptitude),
	AutelDuGrandRatCornu(RuleType.Aptitude),
	AvalancheDEnergie(RuleType.Aptitude),
	BombardesAGlobesToxiques(RuleType.Aptitude, RuleType.PhaseDeTir),
	CarillonFuneste(RuleType.Aptitude),
	DechargeDeMalefoudre(RuleType.Aptitude, RuleType.PhaseDeTir),
	FragmentsDeMalepierre(RuleType.Aptitude, RuleType.PhaseDesHerosPlayer),
	FureurCernee(RuleType.Aptitude),
	GanteletsChoc(RuleType.Aptitude, RuleType.PhaseDeCombat),
	GanteletsEcorcheurs(RuleType.Aptitude, RuleType.PhaseDeCharge, RuleType.PhaseDeCombat),
	GardesDuCorpsDElite(RuleType.Aptitude),
	LanceFeu(RuleType.Aptitude, RuleType.PhaseDeTir),
	NueeGrouillante(RuleType.Aptitude, RuleType.PhaseDeDeroute),
	PlusPlusDeMaleflammes(RuleType.Aptitude, RuleType.PhaseDeTir),
	PlusPlusDeMalefoudre(RuleType.Aptitude, RuleType.PhaseDeTir),
	PlusPlusDeMalenergie(RuleType.Aptitude, RuleType.PhaseDeCombat),
	PlusPlusDeMaleplomb(RuleType.Aptitude, RuleType.PhaseDeTir),
	PousseeVersLaBataille(RuleType.Aptitude),
	ProjecteursAMaleflamme(RuleType.Aptitude, RuleType.PhaseDeTir),
	RemousParDelaLeVoile(RuleType.Aptitude),
	RongezRongezLeursOs(RuleType.Aptitude, RuleType.AptitudesDeCommandement, RuleType.PhaseDeCombat),
	ServantsDArmeCaches(RuleType.Aptitude, RuleType.PhaseBeforeStart, RuleType.PhaseDeTirPlayer),
	TunneliersAPoingsConcasseurs(RuleType.Aptitude, RuleType.PhaseDeMouvement),


	// aptitude de co
	// composition
	Maitrecroc(RuleType.Aptitude, RuleType.Composition),
	Maitregriffe(RuleType.Aptitude, RuleType.Composition),
	PorteEtendardDeChoc(RuleType.Aptitude, RuleType.Composition),
	PorteEtendardDesClans(RuleType.Aptitude, RuleType.Composition),
	SonneurDeClocheDesClans(RuleType.Aptitude, RuleType.Composition),
	TambourDeChoc(RuleType.Aptitude, RuleType.Composition),


	;

	private List<RuleType> types;
	private String name;

	SkavenRule(RuleType... types) {
		this.types = Arrays.asList(types);
		this.name = EnumPropertyLoader.instance().name(this);
	}

	@Override
	public String getDisplayName() {
		return name;
	}

	@Override
	public List<RuleType> getTypes() {
		return types;
	}

	@Override
	public Description getDescription() {
		return new Description(this);
	}

}
