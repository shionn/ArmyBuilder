package armybuilder.model.skaven;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

import armybuilder.model.rule.IRule;
import armybuilder.model.rule.RuleType;
import armybuilder.model.rule.desc.Description;
import armybuilder.model.unit.Unit;
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
	ArmureDeMalerouille(RuleType.Artefact),
	BabioleTenebromagnetique(RuleType.Artefact),
	BouclierDeDistraction(RuleType.Artefact),
	CapeDetaleuse(RuleType.Artefact),
	CharmeDeMalepierre(RuleType.Artefact),
	CloquepusLeKysteVivant(RuleType.Artefact),
	CouronneEnragee(RuleType.Artefact),
	FioleDuFulminateur(RuleType.Artefact),
	FouetDeCrocs(RuleType.Artefact),
	LameDeCorruption(RuleType.Artefact),
	LeFumigatus(RuleType.Artefact),
	LeRongeclat(RuleType.Artefact),
	LOrbeDAirain(RuleType.Artefact),
	ResonateurEsoteriqueAMalepierre(RuleType.Artefact),
	Rongebombe(RuleType.Artefact),
	Salecuir(RuleType.Artefact),
	SceptreDeSuprematieLegitime(RuleType.Artefact),
	Skavenectar(RuleType.Artefact, RuleType.PhaseDesHerosPlayer),

	// sort et priere
	Brulure(RuleType.Sort),
	BouclierDeMalefoudre(RuleType.Sort),
	ChaineDeMalefoudre(RuleType.Sort),
	Evasion(RuleType.Sort),
	FrenesieMortelle(RuleType.Sort),
	Malefoudre(RuleType.Sort),
	PlusPlusPlusDeVilPouvoir(RuleType.Sort),

	CrasseCrasse(RuleType.Priere),
	Fletrissement(RuleType.Priere),
	PestePeste(RuleType.Priere),
	PestilencePestilence(RuleType.Priere),
	RageRage(RuleType.Priere),

	// aptitude des sous clan
	CreationsPrisees_1(RuleType.TraisDeBataille),
	CreationsPrisees_3(RuleType.TraisDeBataille),
	ManipulateursHabiles(RuleType.Aptitude), // TODO alter profil
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
	AssautFrenetique(u -> u.alterAllWeapons(w -> w.setAltAttaques("+1")), RuleType.Aptitude, RuleType.PhaseDeCombat),
	AuraDuGrandRatCornu(RuleType.Aptitude, RuleType.PhaseDesHerosPlayer, RuleType.Aura, RuleType.Priere, RuleType.Sort),
	AutelDuGrandRatCornu(RuleType.Aptitude),
	AvalancheDEnergie(RuleType.Aptitude),
	BarrageDeContagion(u -> u.alter(SkavenWeapons.CatapulteDeLaPeste, w -> {
		w.setAltToucher("+1");
		w.setAltDegats("*");
	}), RuleType.Aptitude, RuleType.PhaseDeTirPlayer),
	BombardesAGlobesToxiques(RuleType.Aptitude, RuleType.PhaseDeTir),
	CarillonFuneste(RuleType.Aptitude),
	DechargeDeMalefoudre(RuleType.Aptitude, RuleType.PhaseDeTir),
	FaireClaquerLeFouet(RuleType.Aptitude, RuleType.PhaseDeMouvementPlayer),
	FragmentsDeMalepierre(RuleType.Aptitude, RuleType.PhaseDesHerosPlayer, RuleType.Sort),
	FumeesEmpoisonnees(RuleType.Aptitude, RuleType.PhaseDeCombat),
	FureurCernee(u -> u.alterAllWeapons(w -> w.setAltAttaques("+*")), RuleType.Aptitude),
	FureurEnragee(
			u -> u.alter(SkavenWeapons.GriffesLamesEtDentsDechiqueteuses, w -> w.setAltToucher("*")),
			RuleType.Aptitude,
			RuleType.PhaseDeCombat),
	GanteletsChoc(RuleType.Aptitude, RuleType.PhaseDeCombat),
	GanteletsEcorcheurs(RuleType.Aptitude, RuleType.PhaseDeCharge, RuleType.PhaseDeCombat),
	GardesDuCorpsDElite(RuleType.Aptitude),
	LanceFeu(RuleType.Aptitude, RuleType.PhaseDeTir),
	LachezPlusPlusDeBetes(RuleType.Aptitude, RuleType.AptitudesDeCommandement),
	MaitreModeleur(RuleType.Aptitude, RuleType.PhaseDesHerosPlayer),
	MortAtroce(RuleType.Aptitude, RuleType.PhaseDeDeroute),
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
	TunnelsDansLaRealite(RuleType.Aptitude, RuleType.PhaseDeMouvement),

	// aptitude de co
	// composition
	Maitrecroc(u -> u.alterAllWeapons(w -> w.setAltAttaques("+1")), RuleType.Aptitude, RuleType.Composition),
	Maitregriffe(u -> u.alterAllWeapons(w -> w.setAltAttaques("+1")), RuleType.Aptitude, RuleType.Composition),
	PorteEtendardDeChoc(RuleType.Aptitude, RuleType.Composition, RuleType.PhaseDeMouvement),
	PorteEtendardDesClans(RuleType.Aptitude, RuleType.Composition, RuleType.PhaseDeMouvement),
	SonneurDeClocheDesClans(RuleType.Aptitude, RuleType.Composition, RuleType.PhaseDeMouvement),
	TambourDeChoc(RuleType.Aptitude, RuleType.Composition, RuleType.PhaseDeMouvement),


	// Tactique de Bataille
	CrescendoDuChoeurInfecte(RuleType.TactiquesDeBataille),
	FeuFeuPlusPlus(RuleType.TactiquesDeBataille),
	MarqueDeLaMort(RuleType.TactiquesDeBataille),
	SoignerLaBete(RuleType.TactiquesDeBataille),

	;

	private List<RuleType> types;
	private String name;
	private Consumer<Unit> modifier;

	private SkavenRule(RuleType... types) {
		this.types = Arrays.asList(types);
		this.name = EnumPropertyLoader.instance().name(this);
	}

	private SkavenRule(Consumer<Unit> modifier, RuleType... types) {
		this.modifier = modifier;
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

	@Override
	public void decorate(Unit unit) {
		if (modifier != null) {
			modifier.accept(unit);
		}
	}

}
