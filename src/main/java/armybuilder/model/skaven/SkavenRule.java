package armybuilder.model.skaven;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

import armybuilder.model.rule.IRule;
import armybuilder.model.rule.RuleType;
import armybuilder.model.rule.desc.Description;
import armybuilder.model.unit.Unit;
import armybuilder.serialisation.EnumPropertyLoader;
import lombok.Getter;

public enum SkavenRule implements IRule<SkavenRule> {
	DirigerDepuisLArriere(RuleType.TraisDeBataille, RuleType.Aptitude, RuleType.PhaseDeCombat),
	SauveQuiPeut(RuleType.TraisDeBataille, RuleType.Aptitude, RuleType.PhaseDeCombat),
	LUnionFaitLaForce(RuleType.TraisDeBataille),

	// trais de co
	AdversaireSournois(RuleType.TraitsDeCommandement, RuleType.PhaseDeCombat),
	AgiliteIncroyable(RuleType.TraitsDeCommandement),
	ArchitecteDeLaMort(RuleType.TraitsDeCommandement),
	CollectionneurEmerite(RuleType.TraitsDeCommandement),
	IntrigantDiabolique(RuleType.TraitsDeCommandement),
	InventeurDerange(RuleType.TraitsDeCommandement),
	MaitreDeLaMagie(RuleType.TraitsDeCommandement),
	MaitreDeLaPourritureEtDeLaRuine(RuleType.TraitsDeCommandement, RuleType.Priere),
	MaitreDeHorde(RuleType.TraitsDeCommandement),
	MaitreDesOmbres(RuleType.TraitsDeCommandement),
	ManipulateurSupreme(RuleType.TraitsDeCommandement, RuleType.PhaseDesHeros),
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
	CloquepusLeKysteVivant(RuleType.Artefact, RuleType.PhaseDeCombat),
	CouronneEnragee(RuleType.Artefact),
	FioleDuFulminateur(RuleType.Artefact),
	FouetDeCrocs(RuleType.Artefact),
	LameDeCorruption(RuleType.Artefact),
	LeFumigatus(RuleType.Artefact, RuleType.PhaseDeCombat),
	LeRongeclat(RuleType.Artefact, RuleType.PhaseDeCombat),
	LOrbeDAirain(RuleType.Artefact, RuleType.PhaseDesHerosPlayer, RuleType.MemoDisplay),
	ResonateurEsoteriqueAMalepierre(RuleType.Artefact),
	Rongebombe(RuleType.Artefact),
	Salecuir(RuleType.Artefact),
	SceptreDeSuprematieLegitime(RuleType.Artefact),
	Skavenectar(RuleType.Artefact, RuleType.PhaseDesHerosPlayer, RuleType.MemoDisplay),

	// sort et priere
	AppelDesCrevasses(RuleType.Sort),
	Brulure(RuleType.Sort),
	BouclierDeMalefoudre(RuleType.Sort),
	ChaineDeMalefoudre(RuleType.Sort),
	ClocheDeLApocalypseConvocation(RuleType.Sort),
	ClocheDeLApocalypsePredateur(RuleType.PhaseDeMouvement),
	Evasion(RuleType.Sort),
	FrenesieMortelle(RuleType.Sort),
	Fletrissement(RuleType.Sort),
	Malefoudre(RuleType.Sort),
	PlusPlusPlusDeVilPouvoir(RuleType.Sort),
	RazDeVermineConvocation(RuleType.Sort),
	RazDeVerminePredateur(RuleType.PhaseDeMouvement),

	CrasseCrasse(RuleType.Priere),
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
	ArmureSertieDeMalepierre(RuleType.Aptitude),
	AssautFrenetique(u -> u.alterAllWeapons(w -> w.setAltAttaques("+1")), RuleType.Aptitude, RuleType.PhaseDeCombat),
	AudaceOuDesespoir(RuleType.Aptitude, RuleType.PhaseDeDeroute),
	AuraDuGrandRatCornu(RuleType.Aptitude, RuleType.PhaseDesHerosPlayer, RuleType.Aura, RuleType.Priere, RuleType.Sort),
	AutelDuGrandRatCornu(RuleType.Aptitude, RuleType.PhaseDesHerosPlayer),
	AutelDuGrandRatCornu_Creuset(RuleType.Aptitude),
	AvalancheDEnergie(RuleType.Aptitude, RuleType.Sort),
	BarrageDeContagion(u -> u.alter(SkavenWeapons.CatapulteDeLaPeste, w -> {
		w.setAltToucher("+1");
		w.setAltDegats("*");
	}), RuleType.Aptitude, RuleType.PhaseDeTirPlayer),
	BombardesAGlobesToxiques(
			u -> u.alter(SkavenWeapons.BombardesAGlobesToxiques, w -> w.setAltBlesser("+1")),
			RuleType.Aptitude,
			RuleType.PhaseDeTir),
	CarillonFuneste(RuleType.Aptitude, RuleType.PhaseDesHerosPlayer),
	DechargeDeMalefoudre(RuleType.Aptitude, RuleType.PhaseDeTir),
	FaireClaquerLeFouet(RuleType.Aptitude, RuleType.PhaseDeMouvementPlayerDebut, RuleType.MemoDisplay),
	FragmentsDeMalepierre(RuleType.Aptitude, RuleType.Sort, RuleType.MemoDisplay),
	FumeesEmpoisonnees(RuleType.Aptitude, RuleType.PhaseDeCombat),
	FureurCernee(u -> u.alterAllWeapons(w -> w.setAltAttaques("+*")), RuleType.Aptitude),
	FureurEnragee(
			u -> u.alter(SkavenWeapons.GriffesLamesEtDentsDechiqueteuses, w -> w.setAltToucher("*")),
			RuleType.Aptitude,
			RuleType.PhaseDeCombat),
	GanteletsChoc(RuleType.Aptitude, RuleType.PhaseDeCombat),
	GanteletsEcorcheurs(
			u -> u.alter(SkavenWeapons.GanteletsEcorcheurs, w -> w.setAltAttaques("+1")),
			RuleType.Aptitude,
			RuleType.PhaseDeCharge,
			RuleType.PhaseDeCombat),
	GardesDuCorpsDElite(RuleType.Aptitude),
	GlasApocalypse(RuleType.Aptitude, RuleType.PhaseDeMouvement),
	GrandEncensoirAPestilence(RuleType.Aptitude, RuleType.PhaseDeCombat),
	HordeVorace(RuleType.Aptitude, RuleType.PhaseDeMouvement),
	LachezPlusPlusDeBetes(RuleType.Aptitude, RuleType.AptitudesDeCommandement),
	LameFetides(u -> u.alterAllWeapons(w -> w.setAltToucher("*")), RuleType.Aptitude, RuleType.PhaseDeCombat),
	LaMortQuiCourt(RuleType.Aptitude, RuleType.PhaseDeMouvementPlayer, RuleType.PhaseDeTirPlayer),
	LanceFeu(RuleType.Aptitude, RuleType.PhaseDeTir),
	LivreDesPlaies(RuleType.Aptitude, RuleType.PhaseDesHerosPlayer),
	MaitreModeleur(RuleType.Aptitude, RuleType.PhaseDesHerosPlayer, RuleType.MemoDisplay),
	MortAtroce(RuleType.Aptitude, RuleType.PhaseDeDeroute),
	NueeGrouillante(RuleType.Aptitude, RuleType.PhaseDeDeroute),
	PlusPlusDeMaleflammes(RuleType.Aptitude, RuleType.PhaseDeTir),
	PlusPlusDeMalefoudre(RuleType.Aptitude, RuleType.PhaseDeTir),
	PlusPlusDeMalenergie(RuleType.Aptitude, RuleType.PhaseDeCombat),
	PlusPlusDeMaleplomb(RuleType.Aptitude, RuleType.PhaseDeTir),
	PousseeVersLaBataille(RuleType.Aptitude, RuleType.PhaseDeMouvement),
	ProjecteursAMaleflamme(RuleType.Aptitude, RuleType.PhaseDeTir),
	RemousParDelaLeVoile(RuleType.Aptitude, RuleType.PhaseDesHeros),
	RongezRongezLeursOs(RuleType.Aptitude, RuleType.AptitudesDeCommandement, RuleType.PhaseDeCombat),
	ServantsDArmeCachesDeploiement(RuleType.Aptitude, RuleType.PhaseBeforeStart),
	ServantsDArmeCachesTir(RuleType.Aptitude, RuleType.PhaseDeTirPlayerDebut, RuleType.MemoDisplay),
	ToxineEshin(RuleType.Aptitude, RuleType.PhaseDeCombat),
	TueurCacheCombat(RuleType.Aptitude, RuleType.PhaseDeCombatDebut),
	TueurCacheDeploiement(RuleType.Aptitude, RuleType.PhaseBeforeStart),
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
	LegatDeLaPeste(RuleType.Aptitude, RuleType.Composition),
	IconeDeLentropie(RuleType.Aptitude, RuleType.Composition),
	HerautDeLaPeste(RuleType.Aptitude, RuleType.Composition),

	// Tactique de Bataille
	CrescendoDuChoeurInfecte(RuleType.TactiquesDeBataille),
	FeuFeuPlusPlus(RuleType.TactiquesDeBataille),
	MarqueDeLaMort(RuleType.TactiquesDeBataille),
	SoignerLaBete(RuleType.TactiquesDeBataille),


	;

	@Getter
	private List<RuleType> types;
	@Getter
	private String displayName;
	private Consumer<Unit> modifier;

	private SkavenRule(RuleType... types) {
		this.types = Arrays.asList(types);
		this.displayName = EnumPropertyLoader.instance().name(this);
	}

	private SkavenRule(Consumer<Unit> modifier, RuleType... types) {
		this.modifier = modifier;
		this.types = Arrays.asList(types);
		this.displayName = EnumPropertyLoader.instance().name(this);
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

	@Override
	public String toString() {
		return name() + getTypes();
	}

}
