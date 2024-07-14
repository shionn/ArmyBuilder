package armybuilder.v3.model.dok;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

import armybuilder.v3.model.rule.IRule;
import armybuilder.v3.model.rule.RuleType;
import armybuilder.v3.model.rule.desc.Description;
import armybuilder.v3.model.unit.Unit;
import armybuilder.v3.serialisation.EnumPropertyLoader;

public enum DokRule implements IRule<DokRule> {
	// allegiance
	FoiFanatique(RuleType.TraisDeBataille),
	RitesDeSang(RuleType.TraisDeBataille),
	FureurDeBataille(RuleType.ActionsHeroiques),
	MassacreTotal(RuleType.AptitudesDeCommandement),
	// sous allegiance
	DisciplesDuMassacre(RuleType.TraisDeBataille),
	FillesDuPremierTemple(RuleType.TraisDeBataille),
	FrapperEtSeRetirer(RuleType.TraisDeBataille),
	TueusesHerisseesDeLames(RuleType.TraisDeBataille),
	LessenceDeKhaine(RuleType.TraisDeBataille),

	// TraitsDeCommandement
	BainDeSang(RuleType.TraitsDeCommandement),
	MaitreDesPoisons(RuleType.TraitsDeCommandement),
	MaitriseDesArcanes(RuleType.TraitsDeCommandement),
	OrateurZele(RuleType.TraitsDeCommandement),
	PousseParLaVengeance(RuleType.TraitsDeCommandement),
	SacrificateurSanglant(RuleType.TraitsDeCommandement, RuleType.PhaseDeCombat),
	VraiCroyant(RuleType.TraitsDeCommandement),

	// Artefact
	CouronneDeDouleur(RuleType.Artefact),
	CoeurDeCristal(RuleType.Artefact),
	LameSorciere(RuleType.Artefact),
	OmbreSeptFoisDrapee(RuleType.Artefact),
	PendentifKhainite(RuleType.Artefact),
	PierreDOmbre(RuleType.Artefact),
	RuneDeKhaine(RuleType.Artefact),
	SymboleSanglant(RuleType.Artefact),
	VeninFleauDuSang(RuleType.Artefact),

	// Sort
	Affaiblissement(RuleType.Sort),
	DanseSymetrique(RuleType.Sort),
	Deperissement(RuleType.Sort),
	DestrierDOmbres(RuleType.Sort),
	HorreurNoireDUlgu(RuleType.Sort),
	PuitsDeTenebres(RuleType.Sort),
	RasoirMental(RuleType.Sort),
	SuaireDeDesespoir(RuleType.Sort),

	// Prieres
	BenedictionDeKhaine(RuleType.Priere),
	CaresseDeLaMort(RuleType.Priere),
	CatechismeDuMeurtre(RuleType.Priere),
	CouventDuCoeurDeFer(RuleType.Priere),
	DanseMaudite(RuleType.Priere),
	SacreDeSang(RuleType.Priere),
	SacrificeDuMartyr(RuleType.Priere),
	ResurrectionPourpre(RuleType.Priere),

	// Aptitude de Commandement
	OrgieDeMassacre(RuleType.AptitudesDeCommandement, RuleType.PhaseDesHerosPlayer),
	VenerationParLeSang(RuleType.AptitudesDeCommandement, RuleType.PhaseDesHeros),

	// Aptitude de Commandement sous allegiance
	MaitressesDesOmbrevoies(RuleType.TraisDeBataille, RuleType.AptitudesDeCommandement, RuleType.PhaseDeMouvement),

	// Aptitude
	AnimuseDeSorcellerieEtDeSacrifice(RuleType.Aptitude),
	AuraDAgonie(RuleType.Aptitude, RuleType.PhaseDesHeros, RuleType.Aura),
	AutelDeKhaine(RuleType.Aptitude, RuleType.PhaseDesHerosPlayer),
	BouclierDeSang(RuleType.Aptitude),
	BrouetDeSang(RuleType.Aptitude, RuleType.PhaseDesHerosPlayer),
	ColereDeKhaine(RuleType.Aptitude, RuleType.PhaseDeCharge),
	ColereDesMoirenees(RuleType.TraisDeBataille, RuleType.AptitudesDeCommandement, RuleType.PhaseDeCharge),
	CoupDeGrace(RuleType.Aptitude, RuleType.PhaseDeCombat),
	CoeurDeFerDeKhaine(RuleType.Aptitude),
	DanseDeLaMort(RuleType.Aptitude, RuleType.PhaseDeCombat),
	DeuxCorpsUneSeuleAme(RuleType.Aptitude),
	DeuxCorpsUneSeuleAme_Shadow(RuleType.Aptitude),
	FerveurFrenetique(u -> {
		u.alter(DokUnitWeapon.Sciansa, w -> w.setAltBlesser("+1"));
		u.alter(DokUnitWeapon.SciansaAppairees, w -> w.setAltBlesser("+1"));
	}, RuleType.Aptitude),
	FureurDeLaReineDeLOmbre(RuleType.Aptitude),
	ImpactLame(RuleType.Aptitude, RuleType.PhaseDeCharge),
	PacteDeSang(RuleType.Aptitude),
	ParangonDuMassacre(RuleType.Aptitude, RuleType.PhaseDeCombat),
	PlongeonDansLaBataille(RuleType.Aptitude, RuleType.PhaseDeMouvement),
	PresenceIntimidante(RuleType.Aptitude),
	RegardIncarnat(RuleType.Aptitude, RuleType.PhaseDeTir),
	SoeurDesMelusai(RuleType.Aptitude, RuleType.PhaseDeCombat),
	SorcierMorathi(RuleType.Aptitude),
	TransmuteEnCristal_Ferecaille(RuleType.Aptitude),
	TransmuteEnCristal(RuleType.Aptitude),
	VoleeEtVolteFace(RuleType.Aptitude, RuleType.PhaseDeTir),

	// Conposition
	Matriache(u -> {
		u.alter(DokUnitWeapon.Sciansa, w -> w.setAltAttaques("+1"));
		u.alter(DokUnitWeapon.SciansaAppairees, w -> w.setAltAttaques("+1"));
	}, RuleType.Composition),
	PorteuseDePennonDeMort(RuleType.Composition),
	Servante(u -> {
		u.alter(DokUnitWeapon.FouetBarbele, w -> w.setAltAttaques("+1"));
		u.alter(DokUnitWeapon.CouteauxSacrificiel, w -> w.setAltAttaques("+1"));
	}, RuleType.Composition),
	SonneuseDeCor(RuleType.Composition),
	Ecorcheuse(u -> {
		u.alter(DokUnitWeapon.JavelineBarbelee_M, w -> w.setAltAttaques("+1"));
		u.alter(DokUnitWeapon.JavelineBarbelee_P, w -> w.setAltAttaques("+1"));
	}, RuleType.Composition),

	// Armes
	RondacheTranchante(u -> u.setProfile(u.getProfile().setSvg(5)), RuleType.Aptitude),

	// sort persistant et aptitude
	CoeurDeFureurConv(RuleType.Aptitude),
	ReceptacleDuDieuMeurtre(RuleType.Aptitude, RuleType.PhaseDeCombat),

	// Tactique de Bataille
	FracasDesArmes(RuleType.TactiquesDeBataille),
	RegalCruel(RuleType.TactiquesDeBataille),
	MareeDeLames(RuleType.TactiquesDeBataille),
	CulteDeLExecutrice(RuleType.TactiquesDeBataille),
	HaineDuChaos(RuleType.TactiquesDeBataille),
	AttaqueInatendue(RuleType.TactiquesDeBataille),

	//

	// ---- Fait au dessus
	//
	CrypteDesAinee(RuleType.TraisDeBataille),
	DissimulationEtDiscretion(RuleType.TraisDeBataille),

	//
	Gorgai(RuleType.Composition),
	ShroudQueen(RuleType.Composition),
	Krone(RuleType.Composition),

	//
	BondDeLOmbre(RuleType.Aptitude, RuleType.PhaseDeMouvement),
	Cherchecoeurs(RuleType.Aptitude),
	LaMortVientDuCiel(RuleType.Aptitude),
	ObjetDAdoration(RuleType.Aptitude, RuleType.PhaseDeDeroute),
	OffrandeSanguinolente(RuleType.Aptitude, RuleType.PhaseDeCombat),
	PaireDeCouteauxSacrificiels(RuleType.Aptitude),
	ProfiterDeLOmbre(RuleType.Aptitude),
	ProjectilesMaudits(RuleType.Aptitude),
	SangDeLOracle(RuleType.Aptitude),
	ZelotesDuPremierTemple(RuleType.Aptitude),

	//

	//

	RuneDeKhaine_Priere(RuleType.Priere),

	//
	AttaqueDeCrochets(RuleType.Aptitude),
	BloodWrackViperConv(RuleType.Aptitude),
	BladewindConv(RuleType.Aptitude),
	TranchantSurnaturel(RuleType.Aptitude),

	;

	private List<RuleType> types;
	private String displayName;
	private Consumer<Unit> modifier;

	DokRule(RuleType... types) {
		this.displayName = EnumPropertyLoader.instance().name(this);
		this.types = Arrays.asList(types);
	}

	DokRule(Consumer<Unit> modifier, RuleType... types) {
		this(types);
		this.modifier = modifier;
	}

	@Override
	public List<RuleType> getTypes() {
		return types;
	}

	@Override
	public String getDisplayName() {
		if (displayName == null) {
			return name();
		}
		return displayName;
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
