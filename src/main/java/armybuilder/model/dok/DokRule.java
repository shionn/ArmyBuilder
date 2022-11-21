package armybuilder.model.dok;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

import armybuilder.model.rule.RuleType;
import armybuilder.model.rule.IRule;
import armybuilder.serialisation.DescriptionReader;

public enum DokRule implements IRule<DokRule> {
	// TraisDeBataille
	FoiFanatique("Foi Fanatique", RuleType.TraisDeBataille),
	RitesDeSang("Rites de Sang", RuleType.TraisDeBataille),
	FureurDeBataille("Fureur de Bataille", RuleType.TraisDeBataille, RuleType.ActionsHeroiques),
	MassacreTotal("Massacre total", RuleType.TraisDeBataille, RuleType.AptitudesDeCommandement),
	// TraisDeBataille sous allegiance
	DisciplesDuMassacre("Disciples du Massacre", RuleType.TraisDeBataille),
	FillesDuPremierTemple("Filles du Premier Temple", RuleType.TraisDeBataille),
	FrapperEtSeRetirer("Frapper et se Retirer", RuleType.TraisDeBataille),
	TueusesHerisseesDeLames("Tueuses Hérissées de Lames", RuleType.TraisDeBataille),
	LessenceDeKhaine("L'essence de Khaine", RuleType.TraisDeBataille),

	// TraitsDeCommandement
	BainDeSang("Bain de Sang", RuleType.TraitsDeCommandement),
	MaitreDesPoisons("Maître des Poisons", RuleType.TraitsDeCommandement),
	MaitriseDesArcanes("Maîtrise des Arcanes", RuleType.TraitsDeCommandement),
	OrateurZele("Orateur Zélé", RuleType.TraitsDeCommandement),
	PousseParLaVengeance("Poussée par la Vengeance", RuleType.TraitsDeCommandement),
	SacrificateurSanglant("Sacrificateur Sanglant", RuleType.TraitsDeCommandement),
	VraiCroyant("Vrai Croyant", RuleType.TraitsDeCommandement),

	// Artefact
	CouronneDeDouleur("Couronne de Douleur", RuleType.Artefact),
	CoeurDeCristal("Cœur de Cristal", RuleType.Artefact),
	LameSorciere("Lame Sorcière", RuleType.Artefact),
	OmbreSeptFoisDrapee("Ombre Sept-fois-drapée", RuleType.Artefact),
	PendentifKhainite("Pendentif Khainite", RuleType.Artefact),
	PierreDOmbre("Pierre d'Ombre", RuleType.Artefact),
	RuneDeKhaine("Rune de Khaine", RuleType.Artefact),
	SymboleSanglant("Symbole Sanglant", RuleType.Artefact),
	VeninFleauDuSang("Venin Fléau du Sang", RuleType.Artefact),

	// Sort
	Affaiblissement(RuleType.Sort, RuleType.TraisUnitee),
	DanseSymetrique("Danse Symétrique", RuleType.Sort, RuleType.TraisUnitee),
	Deperissement("Dépérissement", RuleType.Sort, RuleType.TraisUnitee),
	DestrierDOmbres("Destrier d'Ombre", RuleType.Sort, RuleType.TraisUnitee),
	HorreurNoireDUlgu("Horreur Noire d'Ulgu", RuleType.Sort, RuleType.TraisUnitee),
	PuitsDeTenebres("Puits de Ténèbres", RuleType.Sort, RuleType.TraisUnitee),
	RasoirMental("Rasoir Mental", RuleType.Sort, RuleType.TraisUnitee),
	SuaireDeDesespoir("Suaire de Désespoir", RuleType.Sort, RuleType.TraisUnitee),

	// Prieres
	BenedictionDeKhaine("Bénédiction de Khaine", RuleType.Priere, RuleType.TraisUnitee),
	CaresseDeLaMort("Caresse de la Mort", RuleType.Priere, RuleType.TraisUnitee),
	CatechismeDuMeurtre("Catéchisme Du Meurtre", RuleType.Priere, RuleType.TraisUnitee),
	CouventDuCoeurDeFer("Couvent du Cœur de Fer", RuleType.Priere, RuleType.TraisUnitee),
	DanseMaudite("Danse Maudite", RuleType.Priere, RuleType.TraisUnitee),
	SacreDeSang("Sacre de Sang", RuleType.Priere, RuleType.TraisUnitee),
	SacrificeDuMartyr("Sacrifice du Martyr", RuleType.Priere, RuleType.TraisUnitee),
	ResurrectionPourpre("Résurrection Pourpre", RuleType.Priere, RuleType.TraisUnitee),

	// Aptitude de Commandement
	OrgieDeMassacre("Orgie de Massacre", RuleType.AptitudesDeCommandement, RuleType.PhaseDesHeros, RuleType.TraisUnitee),
	VenerationParLeSang("Vénération par le Sang", RuleType.AptitudesDeCommandement, RuleType.PhaseDesHeros, RuleType.TraisUnitee),

	// Aptitude de Commandement sous allegiance
	MaitressesDesOmbrevoies("Maîtresses des Ombrevoies", RuleType.TraisDeBataille, RuleType.AptitudesDeCommandement, RuleType.PhaseDeMouvement),

	// Aptitude
	AnimuseDeSorcellerieEtDeSacrifice("Animus de Sorcellerie et de Sacrifice", RuleType.Aptitude, RuleType.TraisUnitee),
	AuraDAgonie("Aura d'Agonie", RuleType.Aptitude, RuleType.PhaseDesHeros, RuleType.TraisUnitee),
	AutelDeKhaine("Autel de Khaine", RuleType.Aptitude),
	BouclierDeSang("Bouclier de Sang", RuleType.Aptitude, RuleType.TraisUnitee),
	BrouetDeSang("Brouet de Sang", RuleType.Aptitude, RuleType.PhaseDesHeros, RuleType.TraisUnitee),
	ColereDeKhaine("Colère de Khaine", RuleType.Aptitude, RuleType.TraisUnitee),
	ColereDesMoirenees(
			"Colère des Moirenées",
			RuleType.TraisDeBataille,
			RuleType.AptitudesDeCommandement,
			RuleType.PhaseDeCharge,
			RuleType.TraisUnitee),
	CoupDeGrace("Coup de Grâce", RuleType.Aptitude, RuleType.TraisUnitee),
	CoeurDeFerDeKhaine("Cœur de Fer de Khaine", RuleType.Aptitude, RuleType.TraisUnitee),
	DanseDeLaMort("Danse de la Mort", RuleType.Aptitude, RuleType.TraisUnitee),
	DeuxCorpsUneSeuleAme("Deux corps, une seule âme", RuleType.Aptitude, RuleType.TraisUnitee),
	DeuxCorpsUneSeuleAme_Shadow("Deux corps, une seule âme", RuleType.Aptitude, RuleType.TraisUnitee),
	FerveurFrenetique("Ferveur Frénétique", RuleType.Aptitude, RuleType.PhaseDeCombat),
	FureurDeLaReineDeLOmbre("Fureur de la Reine de l'Ombre", RuleType.Aptitude, RuleType.TraisUnitee),
	ImpactLame("Impact Lamé", RuleType.Aptitude, RuleType.PhaseDeCharge, RuleType.TraisUnitee),
	MaitreDeGuerre("Maître de Guerre", RuleType.Aptitude, RuleType.TraisUnitee),
	PacteDeSang("Pacte de Sang", RuleType.Aptitude, RuleType.TraisUnitee),
	ParangonDuMassacre("Parangon du Massacre", RuleType.Aptitude, RuleType.TraisUnitee),
	PlongeonDansLaBataille("Plongeon dans la Bataille", RuleType.Aptitude, RuleType.PhaseDeMouvement, RuleType.TraisUnitee),
	PresenceIntimidante("Présence Intimidante", RuleType.Aptitude, RuleType.TraisUnitee),
	RegardIncarnat("Regard Incarnat", RuleType.Aptitude, RuleType.PhaseDeTir, RuleType.TraisUnitee),
	SoeurDesMelusai("Sœur des Melusaĩ", RuleType.Aptitude, RuleType.PhaseDeCombat, RuleType.TraisUnitee),
	Sorcier_3_2_1("Sorcier", RuleType.Aptitude, RuleType.TraisUnitee),
	TransmuteEnCristal_Ferecaille(
			"Transmuté en Cristal",
			RuleType.Aptitude,
			RuleType.PhaseDeCombat,
			RuleType.TraisUnitee),
	TransmuteEnCristal(
			"Transmuté en Cristal",
			RuleType.Aptitude,
			RuleType.PhaseDeCombat,
			RuleType.TraisUnitee),
	VoleeEtVolteFace("Volée et Volte-face", RuleType.Aptitude, RuleType.PhaseDeTir, RuleType.TraisUnitee),

	// Conposition
	Matriache("Champion", RuleType.Composition),
	PorteuseDePennonDeMort("Porte-Étendards", RuleType.Composition),
	Servante("Champion", RuleType.Composition),
	SonneuseDeCor("Musiciennes", RuleType.Composition),
	Ecorcheuse("Champion", RuleType.Composition),

	// Armes
	RondacheTranchante("Rondache Tranchante", RuleType.Aptitude),

	// sort persistant et aptitude
	CoeurDeFureurConv("Convocation", RuleType.Aptitude),
	ReceptacleDuDieuMeurtre("Réceptacle du Dieu du Meurtre", RuleType.Aptitude, RuleType.PhaseDeCombat),

	// Tactique de Bataille
	FracasDesArmes("Fracas des Armes", RuleType.TactiquesDeBataille),
	RegalCruel("Régal Cruel", RuleType.TactiquesDeBataille),
	MareeDeLames("Marée de Lame", RuleType.TactiquesDeBataille),
	CulteDeLExecutrice("Culte de l'Éxécutrice", RuleType.TactiquesDeBataille),
	HaineDuChaos("Haine du Chaos", RuleType.TactiquesDeBataille),
	AttaqueInatendue("Attaque Inattendue", RuleType.TactiquesDeBataille),

	//

	// ---- Fait au dessus
	//
	CrypteDesAinee("Crypte des Aînée", RuleType.TraisDeBataille),
	DissimulationEtDiscretion("Dissimulation et Discrétion", RuleType.TraisDeBataille),

	//
	Gorgai("Gorgaï", RuleType.Composition),
	ShroudQueen("Shroud Queen", RuleType.Composition),
	Krone("Krone", RuleType.Composition),

	//
	BondDeLOmbre(
			"Bond de l'Ombre",
			RuleType.Aptitude,
			RuleType.PhaseDeMouvement,
			RuleType.TraisUnitee),
	Cherchecoeurs("Cherchecœurs", RuleType.Aptitude),
	LaMortVientDuCiel("La Mort Vient du Ciel", RuleType.Aptitude, RuleType.TraisUnitee),
	ObjetDAdoration("Objet d'Adoration", RuleType.Aptitude, RuleType.PhaseDeDeroute),
	OffrandeSanguinolente(
			"Offrande Sanguinolente",
			RuleType.Aptitude,
			RuleType.PhaseDeCombat,
			RuleType.TraisUnitee),
	PaireDeCouteauxSacrificiels("Paire de Couteaux Sacrificiels", RuleType.Aptitude),
	ProfiterDeLOmbre("Profiter de l'Ombre", RuleType.Aptitude),
	ProjectilesMaudits("Projectiles Maudits", RuleType.Aptitude),
	SangDeLOracle("Sang de l'Oracle", RuleType.Aptitude),
	ZelotesDuPremierTemple("Zélotes du Premier Temple", RuleType.Aptitude),


	//

	//

	DanseDAgonie("Danse d'Agonie", RuleType.Priere, RuleType.TraisUnitee),
	RuneDeKhaine_Priere("Rune de Khaine", RuleType.Priere, RuleType.TraisUnitee),

	//
	AttaqueDeCrochets("Attaque de Crochets", RuleType.Aptitude),
	BloodWrackViperConv("Convocation", RuleType.Aptitude),
	BladewindConv("Convocation", RuleType.Aptitude),
	TranchantSurnaturel("Tranchant Surnaturel", RuleType.Aptitude),


	;

	private List<RuleType> types;
	private String displayName;
	private Supplier<String> description;

	DokRule(RuleType... types) {
		this.types = Arrays.asList(types);
	}

	DokRule(String displayName, RuleType... types) {
		this.displayName = displayName;
		this.types = Arrays.asList(types);
	}

	DokRule(String displayName, Supplier<String> description, RuleType... types) {
		this.displayName = displayName;
		this.description = description;
		this.types = Arrays.asList(types);
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
	public String getDescription() throws IOException {
		if (description == null) {
			return new DescriptionReader().read("Dok/", name());
		}
		return description.get();
	}

}
