package armybuilder.model.rule;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

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

	CoeurDeFerDeKhaine("Cœur de Fer de Khaine", ArmyRuleType.Aptitude, ArmyRuleType.TraisUnitee),
	DeuxCorpsUneSeuleAme(
			"Deux corps, une seule âme",
			ArmyRuleType.Aptitude,
			ArmyRuleType.TraisUnitee),
	DeuxCorpsUneSeuleAme_Shadow(
			"Deux corps, une seule âme",
			ArmyRuleType.Aptitude,
			ArmyRuleType.TraisUnitee),
	FureurDeLaReineDeLOmbre(
			"Fureur de la Reine de l'Ombre",
			ArmyRuleType.Aptitude,
			ArmyRuleType.TraisUnitee),
	PresenceIntimidante("Présence Intimidante", ArmyRuleType.Aptitude, ArmyRuleType.TraisUnitee),
	AuraDAgonie(
			"Aura d'Agonie",
			ArmyRuleType.Aptitude,
			ArmyRuleType.PhaseDesHeros,
			ArmyRuleType.TraisUnitee),
	ImpactLame(
			"Impact Lamé",
			ArmyRuleType.Aptitude,
			ArmyRuleType.PhaseDeCharge,
			ArmyRuleType.TraisUnitee),
	RegardIncarnat(
			"Regard Incarnat",
			ArmyRuleType.Aptitude,
			ArmyRuleType.PhaseDeTir,
			ArmyRuleType.TraisUnitee),
	GriffeMurmure(
			"Griffe-murmure",
			ArmyRuleType.Aptitude,
			ArmyRuleType.PhaseDeCombat,
			ArmyRuleType.TraisUnitee),

	VenerationParLeSang(
			"Vénération par le Sang",
			ArmyRuleType.AptitudesDeCommandement,
			ArmyRuleType.PhaseDesHeros,
			ArmyRuleType.TraisUnitee),
	AvancezLesChaudrons(ArmyRuleType.AptitudesDeCommandement, ArmyRuleType.PhaseDeMouvement),

	BainDeSang(ArmyRuleType.TraitsDeCommandement),
	OrateurZele(ArmyRuleType.TraitsDeCommandement),
	SacrificateurSanglant(ArmyRuleType.TraitsDeCommandement),
	BeauteTerrifiante(ArmyRuleType.TraitsDeCommandement),
	MaitreDesPoisons(ArmyRuleType.TraitsDeCommandement),
	VraiCroyant(ArmyRuleType.TraitsDeCommandement),

	MaitriseDesArcanes(ArmyRuleType.TraitsDeCommandement),
	AnneauxOndulants(ArmyRuleType.TraitsDeCommandement),
	PresenceEffrayante(ArmyRuleType.TraitsDeCommandement),

	VeteranDeLaCathtrarDhule(ArmyRuleType.TraitsDeCommandement),
	EcaillesImpenetrables(ArmyRuleType.TraitsDeCommandement),
	AnimeParLaVengeance(ArmyRuleType.TraitsDeCommandement),

	DisciplesDevots("Disciples Dévots", ArmyRuleType.TraitsDeCommandement),

	CouronneDeDouleur(ArmyRuleType.Artefact),
	CrocDeShadracar(ArmyRuleType.Artefact),
	AmuletteDeFeuNoir(ArmyRuleType.Artefact),
	LameSorciere(ArmyRuleType.Artefact),
	MilleEtUneSombresMaledictions(ArmyRuleType.Artefact),
	VeninFleauDuSang(ArmyRuleType.Artefact),

	PierreDOmbre(ArmyRuleType.Artefact),
	RuneDUlgu(ArmyRuleType.Priere),
	LeVougeMiroir(ArmyRuleType.Artefact),
	OmbreSeptFoisDrapee(ArmyRuleType.Artefact),
	CoeurDeCristal(ArmyRuleType.Artefact),
	GriffeDOmbre(ArmyRuleType.Artefact),

	SymboleSanglant(ArmyRuleType.Artefact),
	DiademeDeFer(ArmyRuleType.Artefact),
	RuneDeKhaine(ArmyRuleType.Artefact),
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

	CatechismeDuMeurtre(ArmyRuleType.Priere, ArmyRuleType.TraisUnitee),
	BenedictionDeKhaine(ArmyRuleType.Priere, ArmyRuleType.TraisUnitee),
	SacrificeDuMartyr(ArmyRuleType.Priere, ArmyRuleType.TraisUnitee),
	ResurrectionPourpre(ArmyRuleType.Priere, ArmyRuleType.TraisUnitee),
	CouventDuCoeurDeFer(ArmyRuleType.Priere, ArmyRuleType.TraisUnitee),
	SacreDeSang(ArmyRuleType.Priere, ArmyRuleType.TraisUnitee),

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
}
