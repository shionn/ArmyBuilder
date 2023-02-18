package armybuilder.model.dok;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Supplier;

import armybuilder.model.rule.IRule;
import armybuilder.model.rule.RuleType;
import armybuilder.model.unit.Unit;
import armybuilder.serialisation.DescriptionReader;
import armybuilder.serialisation.EnumPropertyLoader;

public enum DokRule implements IRule<DokRule> {
	// TraisDeBataille
	FoiFanatique(RuleType.TraisDeBataille),
	RitesDeSang(RuleType.TraisDeBataille),
	FureurDeBataille(RuleType.TraisDeBataille, RuleType.ActionsHeroiques),
	MassacreTotal(RuleType.TraisDeBataille, RuleType.AptitudesDeCommandement),
	// TraisDeBataille sous allegiance
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
	SacrificateurSanglant(RuleType.TraitsDeCommandement),
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
	Affaiblissement(RuleType.Sort, RuleType.TraisUnitee),
	DanseSymetrique(RuleType.Sort, RuleType.TraisUnitee),
	Deperissement(RuleType.Sort, RuleType.TraisUnitee),
	DestrierDOmbres(RuleType.Sort, RuleType.TraisUnitee),
	HorreurNoireDUlgu(RuleType.Sort, RuleType.TraisUnitee),
	PuitsDeTenebres(RuleType.Sort, RuleType.TraisUnitee),
	RasoirMental(RuleType.Sort, RuleType.TraisUnitee),
	SuaireDeDesespoir(RuleType.Sort, RuleType.TraisUnitee),

	// Prieres
	BenedictionDeKhaine(RuleType.Priere, RuleType.TraisUnitee),
	CaresseDeLaMort(RuleType.Priere, RuleType.TraisUnitee),
	CatechismeDuMeurtre(RuleType.Priere, RuleType.TraisUnitee),
	CouventDuCoeurDeFer(RuleType.Priere, RuleType.TraisUnitee),
	DanseMaudite(RuleType.Priere, RuleType.TraisUnitee),
	SacreDeSang(RuleType.Priere, RuleType.TraisUnitee),
	SacrificeDuMartyr(RuleType.Priere, RuleType.TraisUnitee),
	ResurrectionPourpre(RuleType.Priere, RuleType.TraisUnitee),

	// Aptitude de Commandement
	OrgieDeMassacre(RuleType.AptitudesDeCommandement, RuleType.PhaseDesHeros, RuleType.TraisUnitee),
	VenerationParLeSang(RuleType.AptitudesDeCommandement, RuleType.PhaseDesHeros, RuleType.TraisUnitee),

	// Aptitude de Commandement sous allegiance
	MaitressesDesOmbrevoies(RuleType.TraisDeBataille, RuleType.AptitudesDeCommandement, RuleType.PhaseDeMouvement),

	// Aptitude
	AnimuseDeSorcellerieEtDeSacrifice(RuleType.Aptitude, RuleType.TraisUnitee),
	AuraDAgonie(RuleType.Aptitude, RuleType.PhaseDesHeros, RuleType.TraisUnitee),
	AutelDeKhaine(RuleType.Aptitude),
	BouclierDeSang(RuleType.Aptitude, RuleType.TraisUnitee),
	BrouetDeSang(RuleType.Aptitude, RuleType.PhaseDesHeros, RuleType.TraisUnitee),
	ColereDeKhaine(RuleType.Aptitude, RuleType.TraisUnitee),
	ColereDesMoirenees(
			RuleType.TraisDeBataille,
			RuleType.AptitudesDeCommandement,
			RuleType.PhaseDeCharge,
			RuleType.TraisUnitee),
	CoupDeGrace(RuleType.Aptitude, RuleType.TraisUnitee),
	CoeurDeFerDeKhaine(RuleType.Aptitude, RuleType.TraisUnitee),
	DanseDeLaMort(RuleType.Aptitude, RuleType.TraisUnitee),
	DeuxCorpsUneSeuleAme(RuleType.Aptitude, RuleType.TraisUnitee),
	DeuxCorpsUneSeuleAme_Shadow(RuleType.Aptitude, RuleType.TraisUnitee),
	FerveurFrenetique(u -> {
		u.alter(DokUnitWeapon.Sciansa, w -> w.setAltBlesser("+1"));
		u.alter(DokUnitWeapon.SciansaAppairees, w -> w.setAltBlesser("+1"));
	}, RuleType.Aptitude, RuleType.TraisUnitee),
	FureurDeLaReineDeLOmbre(RuleType.Aptitude, RuleType.TraisUnitee),
	ImpactLame(RuleType.Aptitude, RuleType.PhaseDeCharge, RuleType.TraisUnitee),
	PacteDeSang(RuleType.Aptitude, RuleType.TraisUnitee),
	ParangonDuMassacre(RuleType.Aptitude, RuleType.TraisUnitee),
	PlongeonDansLaBataille(RuleType.Aptitude, RuleType.PhaseDeMouvement, RuleType.TraisUnitee),
	PresenceIntimidante(RuleType.Aptitude, RuleType.TraisUnitee),
	RegardIncarnat(RuleType.Aptitude, RuleType.PhaseDeTir, RuleType.TraisUnitee),
	SoeurDesMelusai(RuleType.Aptitude, RuleType.PhaseDeCombat, RuleType.TraisUnitee),
	SorcierMorathi(RuleType.Aptitude, RuleType.TraisUnitee),
	TransmuteEnCristal_Ferecaille(RuleType.Aptitude, RuleType.TraisUnitee),
	TransmuteEnCristal(RuleType.Aptitude, RuleType.TraisUnitee),
	VoleeEtVolteFace(RuleType.Aptitude, RuleType.PhaseDeTir, RuleType.TraisUnitee),

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
	BondDeLOmbre(
			RuleType.Aptitude,
			RuleType.PhaseDeMouvement,
			RuleType.TraisUnitee),
	Cherchecoeurs(RuleType.Aptitude),
	LaMortVientDuCiel(RuleType.Aptitude, RuleType.TraisUnitee),
	ObjetDAdoration(RuleType.Aptitude, RuleType.PhaseDeDeroute),
	OffrandeSanguinolente(
			RuleType.Aptitude,
			RuleType.PhaseDeCombat,
			RuleType.TraisUnitee),
	PaireDeCouteauxSacrificiels(RuleType.Aptitude),
	ProfiterDeLOmbre(RuleType.Aptitude),
	ProjectilesMaudits(RuleType.Aptitude),
	SangDeLOracle(RuleType.Aptitude),
	ZelotesDuPremierTemple(RuleType.Aptitude),


	//

	//

	DanseDAgonie(RuleType.Priere, RuleType.TraisUnitee),
	RuneDeKhaine_Priere(RuleType.Priere, RuleType.TraisUnitee),

	//
	AttaqueDeCrochets(RuleType.Aptitude),
	BloodWrackViperConv(RuleType.Aptitude),
	BladewindConv(RuleType.Aptitude),
	TranchantSurnaturel(RuleType.Aptitude),


	;

	private List<RuleType> types;
	private String displayName;
	private Supplier<String> description;
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
	public String getDescription() {
		if (description == null) {
			return new DescriptionReader().read("Dok/", this);
		}
		return description.get();
	}

	@Override
	public void decorate(Unit unit) {
		if (modifier != null) {
			modifier.accept(unit);
		}
	}

}
