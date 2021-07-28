package armybuilder.model.dok;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import armybuilder.model.rule.ArmyRuleType;
import armybuilder.model.rule.DescriptionReader;
import armybuilder.model.rule.IArmyRule;

public enum DokRule implements IArmyRule<DokRule> {
	RitesDeSang("Rites de Sang", ArmyRuleType.TraisDeBataille),
	FoiFanatique("Foi Fanatique", ArmyRuleType.TraisDeBataille),
	CrypteDesAinee(ArmyRuleType.TraisDeBataille),
	DisciplesDuMassacre(ArmyRuleType.TraisDeBataille),
	DissimulationEtDiscretion(ArmyRuleType.TraisDeBataille),
	FillesDuPremierTemple("Filles du Premier Temple", ArmyRuleType.TraisDeBataille),
	FrapperEtSeRetirer(ArmyRuleType.TraisDeBataille),
	LessenceDeKhaine(ArmyRuleType.TraisDeBataille),
	TueusesHerisseesDeLames(ArmyRuleType.TraisDeBataille),

	Hag("Hag", ArmyRuleType.Composition),
	Handmaiden("Handmaiden", ArmyRuleType.Composition),
	PorteEtendard("Porte-Étendard", ArmyRuleType.Composition),
	SonneuseDeCor("Sonneuse de Cor", ArmyRuleType.Composition),
	Gorgai("Gorgaï", ArmyRuleType.Composition),
	Krone("Krone", ArmyRuleType.Composition),
	Shryke("Shryke", ArmyRuleType.Composition),

	AuraDAgonie(
			"Aura d'Agonie",
			ArmyRuleType.Aptitude,
			ArmyRuleType.PhaseDesHeros,
			ArmyRuleType.TraisUnitee),
	BouclierDeSang("Bouclier de Sang", ArmyRuleType.Aptitude, ArmyRuleType.TraisUnitee),
	BouclierPerceCoeur("Bouclier Perce-coeur", ArmyRuleType.Aptitude, ArmyRuleType.TraisUnitee),
	BrouetDeSang(
			"Brouet de Sang",
			ArmyRuleType.Aptitude,
			ArmyRuleType.PhaseDesHeros,
			ArmyRuleType.TraisUnitee),
	Cherchecoeurs("Cherchecœurs", ArmyRuleType.Aptitude),
	CoeurDeFerDeKhaine("Cœur de Fer de Khaine", ArmyRuleType.Aptitude, ArmyRuleType.TraisUnitee),
	DanseDeLaMort("Danse de la Mort", ArmyRuleType.Aptitude),
	DeuxCorpsUneSeuleAme(
			"Deux corps, une seule âme",
			ArmyRuleType.Aptitude,
			ArmyRuleType.TraisUnitee),
	DeuxCorpsUneSeuleAme_Shadow(
			"Deux corps, une seule âme",
			ArmyRuleType.Aptitude,
			ArmyRuleType.TraisUnitee),
	FerveurFrenetique("Ferveur Frénétique", ArmyRuleType.Aptitude, ArmyRuleType.PhaseDeCombat),
	FureurDeLaReineDeLOmbre(
			"Fureur de la Reine de l'Ombre",
			ArmyRuleType.Aptitude,
			ArmyRuleType.TraisUnitee),
	GriffeMurmure(
			"Griffe-murmure",
			ArmyRuleType.Aptitude,
			ArmyRuleType.PhaseDeCombat,
			ArmyRuleType.TraisUnitee),
	ImpactLame(
			"Impact Lamé",
			ArmyRuleType.Aptitude,
			ArmyRuleType.PhaseDeCharge,
			ArmyRuleType.TraisUnitee),
	LaMortVientDuCiel("Aptitude", ArmyRuleType.Aptitude, ArmyRuleType.TraisUnitee),
	ObjetDAdoration("Objet d'Adoration", ArmyRuleType.Aptitude, ArmyRuleType.PhaseDeDeroute),
	OffrandeSanguinolente(
			"Offrande Sanguinolente",
			ArmyRuleType.Aptitude,
			ArmyRuleType.PhaseDeCombat,
			ArmyRuleType.TraisUnitee),
	PaireDeCouteauxSacrificiels("Paire de Couteaux Sacrificiels", ArmyRuleType.Aptitude),
	PlongeonDansLaBataille(
			"Plongeon dans la Bataille",
			ArmyRuleType.Aptitude,
			ArmyRuleType.PhaseDeMouvement,
			ArmyRuleType.TraisUnitee),
	PresenceIntimidante("Présence Intimidante", ArmyRuleType.Aptitude, ArmyRuleType.TraisUnitee),
	RegardIncarnat(
			"Regard Incarnat",
			ArmyRuleType.Aptitude,
			ArmyRuleType.PhaseDeTir,
			ArmyRuleType.TraisUnitee),
	RondacheTranchante("Rondache Tranchante", ArmyRuleType.Aptitude),
	SangDeLOracle("Sang de l'Oracle", ArmyRuleType.Aptitude),
	TransmuteEnCristal(
			"Transmuté en Cristal",
			ArmyRuleType.Aptitude,
			ArmyRuleType.PhaseDeCombat,
			ArmyRuleType.TraisUnitee),
	VoleeEtVolteFace(
			"Volée et Volte-face",
			ArmyRuleType.Aptitude,
			ArmyRuleType.PhaseDeTir,
			ArmyRuleType.TraisUnitee),
	ZelotesDuPremierTemple("Zélotes du Premier Temple", ArmyRuleType.Aptitude),

	AvancezLesChaudrons(
			"Avancez les Chaudrons",
			ArmyRuleType.AptitudesDeCommandement,
			ArmyRuleType.PhaseDeMouvement),
	ColereDesMoirenees(
			"Colère des Moirenées",
			ArmyRuleType.AptitudesDeCommandement,
			ArmyRuleType.PhaseDesHeros,
			ArmyRuleType.TraisUnitee),
	OrgieDeMassacre(
			"Orgie de Massacre",
			ArmyRuleType.AptitudesDeCommandement,
			ArmyRuleType.PhaseDesHeros,
			ArmyRuleType.TraisUnitee),
	VenerationParLeSang(
			"Vénération par le Sang",
			ArmyRuleType.AptitudesDeCommandement,
			ArmyRuleType.PhaseDesHeros,
			ArmyRuleType.TraisUnitee),

	AnimeParLaVengeance(ArmyRuleType.TraitsDeCommandement),
	AnneauxOndulants(ArmyRuleType.TraitsDeCommandement),
	BainDeSang(ArmyRuleType.TraitsDeCommandement),
	BeauteTerrifiante(ArmyRuleType.TraitsDeCommandement),
	DisciplesDevots("Disciples Dévots", ArmyRuleType.TraitsDeCommandement),
	EcaillesImpenetrables(ArmyRuleType.TraitsDeCommandement),
	MaitreDesPoisons(ArmyRuleType.TraitsDeCommandement),
	MaitriseDesArcanes(ArmyRuleType.TraitsDeCommandement),
	OrateurZele(ArmyRuleType.TraitsDeCommandement),
	PresenceEffrayante(ArmyRuleType.TraitsDeCommandement),
	SacrificateurSanglant(ArmyRuleType.TraitsDeCommandement),
	VraiCroyant(ArmyRuleType.TraitsDeCommandement),
	VeteranDeLaCathtrarDhule(ArmyRuleType.TraitsDeCommandement),

	CouronneDeDouleur(ArmyRuleType.Artefact),
	CrocDeShadracar(ArmyRuleType.Artefact),
	AmuletteDeFeuNoir(ArmyRuleType.Artefact),
	LameSorciere(ArmyRuleType.Artefact),
	MilleEtUneSombresMaledictions(ArmyRuleType.Artefact),
	VeninFleauDuSang(ArmyRuleType.Artefact),
	PierreDOmbre("Pierre d'Ombre", ArmyRuleType.Artefact),
	RuneDUlgu(ArmyRuleType.Priere),
	LeVougeMiroir(ArmyRuleType.Artefact),
	OmbreSeptFoisDrapee(ArmyRuleType.Artefact),
	CoeurDeCristal(ArmyRuleType.Artefact),
	GriffeDOmbre(ArmyRuleType.Artefact),
	SymboleSanglant(ArmyRuleType.Artefact),
	DiademeDeFer(ArmyRuleType.Artefact),
	RuneDeKhaine("Rune de Khaine", ArmyRuleType.Artefact),
	EclatPourpre(ArmyRuleType.Artefact),
	PendentifKhainite(ArmyRuleType.Artefact),
	BreuvageDeMatriarche(ArmyRuleType.Artefact),
	LUlfuri(
			"L'Ulfuri",
			ArmyRuleType.Artefact,
			ArmyRuleType.PhaseDeCharge,
			ArmyRuleType.TraisUnitee),

	HorreurNoireDUlgu("Horreur Noire d'Ulgu", ArmyRuleType.Sort, ArmyRuleType.TraisUnitee),
	DestrierDOmbres(ArmyRuleType.Sort, ArmyRuleType.TraisUnitee),
	PuitsDeTenebres(ArmyRuleType.Sort, ArmyRuleType.TraisUnitee),
	DanseSymetrique(ArmyRuleType.Sort, ArmyRuleType.TraisUnitee),
	Affaiblissement(ArmyRuleType.Sort, ArmyRuleType.TraisUnitee),
	RasoirMental(ArmyRuleType.Sort, ArmyRuleType.TraisUnitee),
	SuaireDeDesespoir(ArmyRuleType.Sort, ArmyRuleType.TraisUnitee),
	Deperissement("Dépérissement", ArmyRuleType.Sort, ArmyRuleType.TraisUnitee),

	CatechismeDuMeurtre("Catéchisme Du Meurtre", ArmyRuleType.Priere, ArmyRuleType.TraisUnitee),
	BenedictionDeKhaine(ArmyRuleType.Priere, ArmyRuleType.TraisUnitee),
	SacrificeDuMartyr(ArmyRuleType.Priere, ArmyRuleType.TraisUnitee),
	ResurrectionPourpre(ArmyRuleType.Priere, ArmyRuleType.TraisUnitee),
	CouventDuCoeurDeFer(ArmyRuleType.Priere, ArmyRuleType.TraisUnitee),
	SacreDeSang(ArmyRuleType.Priere, ArmyRuleType.TraisUnitee),
	CaresseDeLaMort("Caresse de la Mort", ArmyRuleType.Priere, ArmyRuleType.TraisUnitee),
	RuneDeKhaine_Priere("Rune de Khaine", ArmyRuleType.Priere, ArmyRuleType.TraisUnitee),
	DanseDAgonie("Danse d'Agonie", ArmyRuleType.Priere, ArmyRuleType.TraisUnitee),
	ColereDeKhaine("Colère de Khaine", ArmyRuleType.Priere, ArmyRuleType.TraisUnitee),


	;

	private List<ArmyRuleType> types;
	private String displayName;

	DokRule(ArmyRuleType... types) {
		this.types = Arrays.asList(types);
	}

	DokRule(String displayName, ArmyRuleType... types) {
		this.displayName = displayName;
		this.types = Arrays.asList(types);
	}

	@Override
	public List<ArmyRuleType> getTypes() {
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
	public String getDescription() throws IOException {
		return new DescriptionReader().read("Dok/", name());
	}

	@Override
	public String toString() {
		return name() + getTypes();
	}

}