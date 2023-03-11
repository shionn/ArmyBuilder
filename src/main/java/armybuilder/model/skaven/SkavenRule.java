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


	// aptitude des sous clan
	CreationsPrisees_1(RuleType.TraisDeBataille),
	CreationsPrisees_3(RuleType.TraisDeBataille),
	ManipulateursHabiles(RuleType.Aptitude, RuleType.TraisUnitee),
	ToujoursTroisCoupsDeGriffesDAvance(RuleType.AptitudesDeCommandement),
	MaitresDuMeurtre_1(RuleType.TraisDeBataille),
	MaitresDuMeurtre_3(RuleType.TraisDeBataille),
	PuissantsChefsDeGuerre_1(RuleType.ActionsHeroiques),
	PuissantsChefsDeGuerre_3(RuleType.ActionsHeroiques),
	BougiesDeMalepierre_1(RuleType.TraisDeBataille),
	BougiesDeMalepierre_3(RuleType.TraisDeBataille),
	EchosDesGrandesPlaies(RuleType.TraisDeBataille),

	// aptitude d'unité
	AppelDesCrevasses(RuleType.Aptitude, RuleType.TraisUnitee),
	AutelDuGrandRatCornu(RuleType.Aptitude, RuleType.TraisUnitee),
	AvalancheDEnergie(RuleType.Aptitude, RuleType.TraisUnitee),
	CarillonFuneste(RuleType.Aptitude, RuleType.TraisUnitee),
	FragmentsDeMalepierre(RuleType.Aptitude, RuleType.TraisUnitee),
	FureurCernee(RuleType.Aptitude, RuleType.TraisUnitee),
	PousseeVersLaBataille(RuleType.Aptitude, RuleType.TraisUnitee),
	RemousParDelaLeVoile(RuleType.Aptitude, RuleType.TraisUnitee),
	RongezRongezLeursOs(RuleType.Aptitude, RuleType.TraisUnitee),
	NueeGrouillante(RuleType.Aptitude, RuleType.TraisUnitee),

	// sort
	Fletrissement(RuleType.Sort),
	// priere
	// artefact
	// aptitude de co
	// composition
	Maitregriffe(RuleType.Aptitude, RuleType.Composition),
	PorteEtendardDesClans(RuleType.Aptitude, RuleType.Composition),
	SonneurDeClocheDesClans(RuleType.Aptitude, RuleType.Composition),

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
