package armybuilder.v3.model.skaven;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

import armybuilder.v3.model.rule.IRule;
import armybuilder.v3.model.rule.RuleType;
import armybuilder.v3.model.rule.desc.Description;
import armybuilder.v3.model.unit.Unit;
import armybuilder.v3.serialisation.EnumPropertyLoader;
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
	MaitreDeLaMagie(RuleType.TraitsDeCommandement, RuleType.PhaseDesHeros, RuleType.Sort),
	MaitreDeLaPourritureEtDeLaRuine(RuleType.TraitsDeCommandement, RuleType.Priere),
	MaitreDeHorde(RuleType.TraitsDeCommandement),
	MaitreDesOmbres(RuleType.TraitsDeCommandement),
	ManipulateurSupreme(RuleType.TraitsDeCommandement, RuleType.PhaseDesHeros),
	ModeleurSupreme(RuleType.TraitsDeCommandement, RuleType.PhaseDeTir, RuleType.PhaseDeCombat),
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
	LeFumigatus(RuleType.Artefact, RuleType.PhaseDeCombatDebut, RuleType.MemoDisplay),
	LeRongeclat(RuleType.Artefact, RuleType.PhaseDeCombat),
	LOrbeDAirain(RuleType.Artefact, RuleType.PhaseDesHerosPlayer, RuleType.MemoDisplay),
	ResonateurEsoteriqueAMalepierre(RuleType.Artefact),
	Rongebombe(RuleType.Artefact),
	Salecuir(RuleType.Artefact),
	SceptreDeSuprematieLegitime(RuleType.Artefact),
	Skavenectar(RuleType.Artefact, RuleType.PhaseDesHerosPlayer, RuleType.MemoDisplay),

	// sort et priere
	AppelDesCrevasses(RuleType.Sort, RuleType.MemoDisplay),
	Brulure(RuleType.Sort, RuleType.MemoDisplay),
	BouclierDeMalefoudre(RuleType.Sort, RuleType.MemoDisplay),
	ChaineDeMalefoudre(RuleType.Sort, RuleType.MemoDisplay),
	ClocheDeLApocalypseConvocation(RuleType.Sort, RuleType.MemoDisplay),
	ClocheDeLApocalypsePredateur(RuleType.PhaseDeMouvement),
	Evasion(RuleType.Sort, RuleType.MemoDisplay),
	FrenesieMortelle(RuleType.Sort, RuleType.MemoDisplay),
	Fletrissement(RuleType.Sort, RuleType.MemoDisplay),
	Malefoudre(RuleType.Sort, RuleType.MemoDisplay),
	PlusPlusPlusDeVilPouvoir(RuleType.Sort, RuleType.MemoDisplay),
	RazDeVermineConvocation(RuleType.Sort, RuleType.MemoDisplay),
	RazDeVerminePredateur(RuleType.PhaseDeMouvement),
	RedoutableMaletornade(RuleType.Sort, RuleType.Memo),

	CrasseCrasse(RuleType.Priere, RuleType.MemoDisplay),
	PestePeste(RuleType.Priere, RuleType.MemoDisplay),
	PestilencePestilence(RuleType.Priere, RuleType.MemoDisplay),
	RageRage(RuleType.Priere, RuleType.MemoDisplay),

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
	BougiesDeMalepierre_Sort(RuleType.TraisDeBataille, RuleType.Aptitude, RuleType.Sort, RuleType.MemoDisplay),
	BougiesDeMalepierre_Tir(RuleType.TraisDeBataille, RuleType.PhaseDeTirPlayerDebut, RuleType.MemoDisplay),
	BougiesDeMalepierre_Combat(RuleType.TraisDeBataille, RuleType.PhaseDeCombat, RuleType.MemoDisplay),
	EchosDesGrandesPlaies(RuleType.TraisDeBataille, RuleType.Priere),
	EchosDesGrandesPlaies_Unit(RuleType.TraisDeBataille, RuleType.Priere),

	// aptitude d'unité
	ArmureSertieDeMalepierre(RuleType.Aptitude),
	AssautFrenetique(u -> u.alterAllWeapons(w -> w.setAltAttaques("+1")), RuleType.Aptitude, RuleType.PhaseDeCombat),
	AudaceOuDesespoir(RuleType.Aptitude, RuleType.PhaseDeDeroute),
	AuraDuGrandRatCornu(RuleType.Aptitude, RuleType.PhaseDesHerosPlayer, RuleType.Aura, RuleType.Priere, RuleType.Sort),
	AutelDuGrandRatCornu(RuleType.Aptitude, RuleType.PhaseDesHerosPlayer),
	AutelDuGrandRatCornu_Creuset(RuleType.Aptitude),
	AvalancheDEnergie(RuleType.Aptitude, RuleType.Sort),
	AvalancheDeChair(RuleType.Aptitude, RuleType.PhaseDeCombat),
	BarrageDeContagion(u -> u.alter(SkavenWeapons.CatapulteDeLaPeste, w -> {
		w.setAltToucher("+1");
		w.setAltDegats("*");
	}), RuleType.Aptitude, RuleType.PhaseDeTirPlayer),
	BombardesAGlobesToxiques(
			u -> u.alter(SkavenWeapons.BombardesAGlobesToxiques, w -> w.setAltBlesser("+1")),
			RuleType.Aptitude,
			RuleType.PhaseDeTir),
	CarillonFuneste(RuleType.Aptitude, RuleType.PhaseDesHerosPlayerDebut, RuleType.MemoDisplay),
	DechargeDeMalefoudre(RuleType.Aptitude, RuleType.PhaseDeTir),
	EnAvantEnfantsDuRatCornu(RuleType.Aptitude, RuleType.PhaseDeDeroute),
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
	LesGrandsManipulateurs(RuleType.Aptitude),
	LivreDesPlaies(RuleType.Aptitude, RuleType.PhaseDesHerosPlayer, RuleType.MemoDisplay),
	MaitreModeleur(RuleType.Aptitude, RuleType.PhaseDesHerosPlayer, RuleType.MemoDisplay),
	MonstruositeRegenerante(RuleType.Aptitude, RuleType.PhaseDesHerosPlayer, RuleType.MemoDisplay),
	MortAtroce(RuleType.Aptitude, RuleType.PhaseDeDeroute, RuleType.MemoDisplay),
	MortRoulante(RuleType.Aptitude, RuleType.PhaseDeMouvement),
	NueeGrouillante(RuleType.Aptitude, RuleType.PhaseDeDeroute),
	OrbeDevin(RuleType.Aptitude, RuleType.PhaseDeTirPlayer),
	PieuxDeMalepierre(RuleType.Aptitude),
	PlacementTrouVermines(RuleType.PhaseBeforeStart),
	PlusPlusDeMaleflammes(RuleType.Aptitude, RuleType.PhaseDeTir),
	PlusPlusDeMalefoudre(RuleType.Aptitude, RuleType.PhaseDeTir),
	PlusPlusDeMalenergie(RuleType.Aptitude, RuleType.PhaseDeCombat),
	PlusPlusDeMaleplomb(RuleType.Aptitude, RuleType.PhaseDeTir),
	PlusPlusDeVitesse(RuleType.Aptitude, RuleType.PhaseDeMouvement),
	PlusPlusDEclairs(
			u -> u.alter(SkavenWeapons.TraitsDeMalefoudre, w -> w.setAltAttaques("*")),
			RuleType.Aptitude,
			RuleType.PhaseDeTir),
	@Deprecated()
	PousseeVersLaBataille(RuleType.Aptitude, RuleType.PhaseDeMouvement),
	ProjecteursAMaleflamme(RuleType.Aptitude, RuleType.PhaseDeTir),
	ProtectionduRatCornu(RuleType.Aptitude),
	RemousParDelaLeVoile(RuleType.Aptitude, RuleType.PhaseDesHeros, RuleType.MemoDisplay),
	RongezRongezLeursOs(RuleType.Aptitude, RuleType.AptitudesDeCommandement, RuleType.PhaseDeCombat),
	ServantsDArmeCachesDeploiement(RuleType.Aptitude, RuleType.PhaseBeforeStart),
	ServantsDArmeCachesTir(RuleType.Aptitude, RuleType.PhaseDeTirPlayerDebut, RuleType.MemoDisplay),
	ToxineEshin(u -> u.alterAllWeapons(w -> w.setAltToucher("*")), RuleType.Aptitude, RuleType.PhaseDeCombat),
	TueurCacheCombat(RuleType.Aptitude, RuleType.PhaseDeCombatDebut, RuleType.MemoDisplay),
	TueurCacheMort(RuleType.Aptitude),
	TueurCacheDeploiement(RuleType.Aptitude, RuleType.PhaseBeforeStart),
	TunneliersAPoingsConcasseurs(RuleType.Aptitude, RuleType.PhaseDeMouvement),
	TunnelsDansLaRealite(RuleType.Aptitude, RuleType.PhaseDeMouvementPlayerFin, RuleType.MemoDisplay),
	TropHorriblePourMourrir(RuleType.Aptitude),

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
