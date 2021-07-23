package armybuilder.model.rule;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;

import org.commonmark.node.Node;
import org.commonmark.parser.Parser;
import org.commonmark.renderer.html.HtmlRenderer;

public enum DokRule implements IArmyRule<DokRule> {
	RitesDeSang(ArmyRuleType.TraisDeBataille),
	FoiFanatique(ArmyRuleType.TraisDeBataille),

	CrypteDesAinee(ArmyRuleType.TraisDeBataille),
	DisciplesDuMassacre(ArmyRuleType.TraisDeBataille),
	DissimulationEtDiscretion(ArmyRuleType.TraisDeBataille),
	FillesDuPremierTemple(ArmyRuleType.TraisDeBataille),
	FrapperEtSeRetirer(ArmyRuleType.TraisDeBataille),
	LessenceDeKhaine(ArmyRuleType.TraisDeBataille),
	TueusesHerisseesDeLames(ArmyRuleType.TraisDeBataille),

	CoeurDeFerDeKhaine(ArmyRuleType.Aptitude),
	DeuxCorpsUneSeuleAme(ArmyRuleType.Aptitude),
	DeuxCorpsUneSeuleAme_Shadow(ArmyRuleType.Aptitude),
	FureurDeLaReineDeLOmbre(ArmyRuleType.Aptitude),
	PresenceIntimidante(ArmyRuleType.Aptitude),
	AuraDAgonie("Aura d'Agonie", ArmyRuleType.Aptitude, ArmyRuleType.PhaseDesHeros),
	ImpactLame(ArmyRuleType.Aptitude, ArmyRuleType.PhaseDeCharge),
	RegardIncarnat(ArmyRuleType.Aptitude, ArmyRuleType.PhaseDeTir),
	GriffeMurmure(ArmyRuleType.Aptitude, ArmyRuleType.PhaseDeCombat),

	VenerationParLeSang(ArmyRuleType.AptitudesDeCommandement, ArmyRuleType.PhaseDesHeros),
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

	DisciplesDevots(ArmyRuleType.TraitsDeCommandement),

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

	LUlfuri(ArmyRuleType.Artefact, ArmyRuleType.PhaseDeCharge),

	HorreurNoireDUlgu(ArmyRuleType.Sort),
	DestrierDOmbres(ArmyRuleType.Sort),
	PuitsDeTenebres(ArmyRuleType.Sort),
	DanseSymetrique(ArmyRuleType.Sort),
	Affaiblissement(ArmyRuleType.Sort),
	RasoirMental(ArmyRuleType.Sort),
	SuaireDeDesespoir(ArmyRuleType.Sort),
	Deperissement(ArmyRuleType.Sort),

	CatechismeDuMeurtre(ArmyRuleType.Priere),
	BenedictionDeKhaine(ArmyRuleType.Priere),
	SacrificeDuMartyr(ArmyRuleType.Priere),
	ResurrectionPourpre(ArmyRuleType.Priere),
	CouventDuCoeurDeFer(ArmyRuleType.Priere),
	SacreDeSang(ArmyRuleType.Priere),

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

	public String getDisplayName() {
		if (displayName == null) {
			return name();
		}
		return displayName;
	}

	@Override
	public String description() throws IOException {
		try (InputStream is = Thread.currentThread().getContextClassLoader()
				.getResourceAsStream("Dok/" + name() + ".md");
				java.io.InputStreamReader isr = new java.io.InputStreamReader(is)) {
			Node node = Parser.builder().build().parseReader(isr);
			return HtmlRenderer.builder().build().render(node);
		}
	}
}
