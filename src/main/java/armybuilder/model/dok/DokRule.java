package armybuilder.model.dok;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

import armybuilder.model.army.rule.ArmyRuleType;
import armybuilder.model.army.rule.IRule;
import armybuilder.serialisation.DescriptionReader;

public enum DokRule implements IRule<DokRule> {
	// TraisDeBataille
	FoiFanatique("Foi Fanatique", ArmyRuleType.TraisDeBataille),
	RitesDeSang("Rites de Sang", ArmyRuleType.TraisDeBataille),
	FureurDeBataille("Fureur de Bataille", ArmyRuleType.TraisDeBataille, ArmyRuleType.ActionsHeroiques),
	MassacreTotal("Massacre total", ArmyRuleType.TraisDeBataille, ArmyRuleType.AptitudesDeCommandement),
	// TraisDeBataille sous allegiance
	DisciplesDuMassacre("Disciples du Massacre", ArmyRuleType.TraisDeBataille),
	FillesDuPremierTemple("Filles du Premier Temple", ArmyRuleType.TraisDeBataille),
	FrapperEtSeRetirer("Frapper et se Retirer", ArmyRuleType.TraisDeBataille),
	TueusesHerisseesDeLames("Tueuses Hérissées de Lames", ArmyRuleType.TraisDeBataille),
	LessenceDeKhaine("L'essence de Khaine", ArmyRuleType.TraisDeBataille),

	// TraitsDeCommandement
	BainDeSang("Bain de Sang", ArmyRuleType.TraitsDeCommandement),
	MaitreDesPoisons("Maître des Poisons", ArmyRuleType.TraitsDeCommandement),
	MaitriseDesArcanes("Maîtrise des Arcanes", ArmyRuleType.TraitsDeCommandement),
	OrateurZele("Orateur Zélé", ArmyRuleType.TraitsDeCommandement),
	PousseParLaVengeance("Poussée par la Vengeance", ArmyRuleType.TraitsDeCommandement),
	SacrificateurSanglant("Sacrificateur Sanglant", ArmyRuleType.TraitsDeCommandement),
	VraiCroyant("Vrai Croyant", ArmyRuleType.TraitsDeCommandement),

	// Artefact
	CouronneDeDouleur("Couronne de Douleur", ArmyRuleType.Artefact),
	CoeurDeCristal("Cœur de Cristal", ArmyRuleType.Artefact),
	LameSorciere("Lame Sorcière", ArmyRuleType.Artefact),
	OmbreSeptFoisDrapee("Ombre Sept-fois-drapée", ArmyRuleType.Artefact),
	PendentifKhainite("Pendentif Khainite", ArmyRuleType.Artefact),
	PierreDOmbre("Pierre d'Ombre", ArmyRuleType.Artefact),
	RuneDeKhaine("Rune de Khaine", ArmyRuleType.Artefact),
	SymboleSanglant("Symbole Sanglant", ArmyRuleType.Artefact),
	VeninFleauDuSang("Venin Fléau du Sang", ArmyRuleType.Artefact),

	// Sort
	Affaiblissement(ArmyRuleType.Sort, ArmyRuleType.TraisUnitee),
	DanseSymetrique("Danse Symétrique", ArmyRuleType.Sort, ArmyRuleType.TraisUnitee),
	Deperissement("Dépérissement", ArmyRuleType.Sort, ArmyRuleType.TraisUnitee),
	DestrierDOmbres("Destrier d'Ombre", ArmyRuleType.Sort, ArmyRuleType.TraisUnitee),
	HorreurNoireDUlgu("Horreur Noire d'Ulgu", ArmyRuleType.Sort, ArmyRuleType.TraisUnitee),
	PuitsDeTenebres("Puits de Ténèbres", ArmyRuleType.Sort, ArmyRuleType.TraisUnitee),
	RasoirMental("Rasoir Mental", ArmyRuleType.Sort, ArmyRuleType.TraisUnitee),
	SuaireDeDesespoir("Suaire de Désespoir", ArmyRuleType.Sort, ArmyRuleType.TraisUnitee),

	// Prieres
	BenedictionDeKhaine("Bénédiction de Khaine", ArmyRuleType.Priere, ArmyRuleType.TraisUnitee),
	CaresseDeLaMort("Caresse de la Mort", ArmyRuleType.Priere, ArmyRuleType.TraisUnitee),
	CatechismeDuMeurtre("Catéchisme Du Meurtre", ArmyRuleType.Priere, ArmyRuleType.TraisUnitee),
	CouventDuCoeurDeFer("Couvent du Cœur de Fer", ArmyRuleType.Priere, ArmyRuleType.TraisUnitee),
	DanseMaudite("Danse Maudite", ArmyRuleType.Priere, ArmyRuleType.TraisUnitee),
	SacreDeSang("Sacre de Sang", ArmyRuleType.Priere, ArmyRuleType.TraisUnitee),
	SacrificeDuMartyr("Sacrifice du Martyr", ArmyRuleType.Priere, ArmyRuleType.TraisUnitee),
	ResurrectionPourpre("Résurrection Pourpre", ArmyRuleType.Priere, ArmyRuleType.TraisUnitee),

	// Aptitude de Commandement
	OrgieDeMassacre("Orgie de Massacre", ArmyRuleType.AptitudesDeCommandement, ArmyRuleType.PhaseDesHeros, ArmyRuleType.TraisUnitee),
	VenerationParLeSang("Vénération par le Sang", ArmyRuleType.AptitudesDeCommandement, ArmyRuleType.PhaseDesHeros, ArmyRuleType.TraisUnitee),

	// Aptitude de Commandement sous allegiance
	MaitressesDesOmbrevoies("Maîtresses des Ombrevoies", ArmyRuleType.TraisDeBataille, ArmyRuleType.AptitudesDeCommandement, ArmyRuleType.PhaseDeMouvement),

	// Aptitude
	AnimuseDeSorcellerieEtDeSacrifice("Animus de Sorcellerie et de Sacrifice", ArmyRuleType.Aptitude, ArmyRuleType.TraisUnitee),
	AuraDAgonie("Aura d'Agonie", ArmyRuleType.Aptitude, ArmyRuleType.PhaseDesHeros, ArmyRuleType.TraisUnitee),
	AutelDeKhaine("Autel de Khaine", ArmyRuleType.Aptitude),
	BouclierDeSang("Bouclier de Sang", ArmyRuleType.Aptitude, ArmyRuleType.TraisUnitee),
	BrouetDeSang("Brouet de Sang", ArmyRuleType.Aptitude, ArmyRuleType.PhaseDesHeros, ArmyRuleType.TraisUnitee),
	ColereDeKhaine("Colère de Khaine", ArmyRuleType.Aptitude, ArmyRuleType.TraisUnitee),
	ColereDesMoirenees(
			"Colère des Moirenées",
			ArmyRuleType.TraisDeBataille,
			ArmyRuleType.AptitudesDeCommandement,
			ArmyRuleType.PhaseDeCharge,
			ArmyRuleType.TraisUnitee),
	CoupDeGrace("Coup de Grâce", ArmyRuleType.Aptitude, ArmyRuleType.TraisUnitee),
	CoeurDeFerDeKhaine("Cœur de Fer de Khaine", ArmyRuleType.Aptitude, ArmyRuleType.TraisUnitee),
	DanseDeLaMort("Danse de la Mort", ArmyRuleType.Aptitude, ArmyRuleType.TraisUnitee),
	DeuxCorpsUneSeuleAme("Deux corps, une seule âme", ArmyRuleType.Aptitude, ArmyRuleType.TraisUnitee),
	DeuxCorpsUneSeuleAme_Shadow("Deux corps, une seule âme", ArmyRuleType.Aptitude, ArmyRuleType.TraisUnitee),
	FerveurFrenetique("Ferveur Frénétique", ArmyRuleType.Aptitude, ArmyRuleType.PhaseDeCombat),
	FureurDeLaReineDeLOmbre("Fureur de la Reine de l'Ombre", ArmyRuleType.Aptitude, ArmyRuleType.TraisUnitee),
	ImpactLame("Impact Lamé", ArmyRuleType.Aptitude, ArmyRuleType.PhaseDeCharge, ArmyRuleType.TraisUnitee),
	MaitreDeGuerre("Maître de Guerre", ArmyRuleType.Aptitude, ArmyRuleType.TraisUnitee),
	PacteDeSang("Pacte de Sang", ArmyRuleType.Aptitude, ArmyRuleType.TraisUnitee),
	ParangonDuMassacre("Parangon du Massacre", ArmyRuleType.Aptitude, ArmyRuleType.TraisUnitee),
	PlongeonDansLaBataille("Plongeon dans la Bataille", ArmyRuleType.Aptitude, ArmyRuleType.PhaseDeMouvement, ArmyRuleType.TraisUnitee),
	PresenceIntimidante("Présence Intimidante", ArmyRuleType.Aptitude, ArmyRuleType.TraisUnitee),
	RegardIncarnat("Regard Incarnat", ArmyRuleType.Aptitude, ArmyRuleType.PhaseDeTir, ArmyRuleType.TraisUnitee),
	SoeurDesMelusai("Sœur des Melusaĩ", ArmyRuleType.Aptitude, ArmyRuleType.PhaseDeCombat, ArmyRuleType.TraisUnitee),
	Sorcier_3_2_1("Sorcier", ArmyRuleType.Aptitude, ArmyRuleType.TraisUnitee),
	TransmuteEnCristal_Ferecaille(
			"Transmuté en Cristal",
			ArmyRuleType.Aptitude,
			ArmyRuleType.PhaseDeCombat,
			ArmyRuleType.TraisUnitee),
	TransmuteEnCristal(
			"Transmuté en Cristal",
			ArmyRuleType.Aptitude,
			ArmyRuleType.PhaseDeCombat,
			ArmyRuleType.TraisUnitee),
	VoleeEtVolteFace("Volée et Volte-face", ArmyRuleType.Aptitude, ArmyRuleType.PhaseDeTir, ArmyRuleType.TraisUnitee),

	// Conposition
	Matriache("Champion", ArmyRuleType.Composition),
	PorteuseDePennonDeMort("Porte-Étendards", ArmyRuleType.Composition),
	Servante("Champion", ArmyRuleType.Composition),
	SonneuseDeCor("Musiciennes", ArmyRuleType.Composition),
	Ecorcheuse("Champion", ArmyRuleType.Composition),

	// Armes
	RondacheTranchante("Rondache Tranchante", ArmyRuleType.Aptitude),

	// sort persistant et aptitude
	CoeurDeFureurConv("Convocation", ArmyRuleType.Aptitude),
	ReceptacleDuDieuMeurtre("Réceptacle du Dieu du Meurtre", ArmyRuleType.Aptitude, ArmyRuleType.PhaseDeCombat),

	// Tactique de Bataille
	FracasDesArmes("Fracas des Armes", ArmyRuleType.TactiquesDeBataille),
	RegalCruel("Régal Cruel", ArmyRuleType.TactiquesDeBataille),
	MareeDeLames("Marée de Lame", ArmyRuleType.TactiquesDeBataille),
	CulteDeLExecutrice("Culte de l'Éxécutrice", ArmyRuleType.TactiquesDeBataille),
	HaineDuChaos("Haine du Chaos", ArmyRuleType.TactiquesDeBataille),
	AttaqueInatendue("Attaque Inattendue", ArmyRuleType.TactiquesDeBataille),

	//

	// ---- Fait au dessus
	//
	CrypteDesAinee("Crypte des Aînée", ArmyRuleType.TraisDeBataille),
	DissimulationEtDiscretion("Dissimulation et Discrétion", ArmyRuleType.TraisDeBataille),

	//
	Gorgai("Gorgaï", ArmyRuleType.Composition),
	ShroudQueen("Shroud Queen", ArmyRuleType.Composition),
	Krone("Krone", ArmyRuleType.Composition),

	//
	BondDeLOmbre(
			"Bond de l'Ombre",
			ArmyRuleType.Aptitude,
			ArmyRuleType.PhaseDeMouvement,
			ArmyRuleType.TraisUnitee),
	Cherchecoeurs("Cherchecœurs", ArmyRuleType.Aptitude),
	LaMortVientDuCiel("La Mort Vient du Ciel", ArmyRuleType.Aptitude, ArmyRuleType.TraisUnitee),
	ObjetDAdoration("Objet d'Adoration", ArmyRuleType.Aptitude, ArmyRuleType.PhaseDeDeroute),
	OffrandeSanguinolente(
			"Offrande Sanguinolente",
			ArmyRuleType.Aptitude,
			ArmyRuleType.PhaseDeCombat,
			ArmyRuleType.TraisUnitee),
	PaireDeCouteauxSacrificiels("Paire de Couteaux Sacrificiels", ArmyRuleType.Aptitude),
	ProfiterDeLOmbre("Profiter de l'Ombre", ArmyRuleType.Aptitude),
	ProjectilesMaudits("Projectiles Maudits", ArmyRuleType.Aptitude),
	SangDeLOracle("Sang de l'Oracle", ArmyRuleType.Aptitude),
	ZelotesDuPremierTemple("Zélotes du Premier Temple", ArmyRuleType.Aptitude),


	//

	//

	DanseDAgonie("Danse d'Agonie", ArmyRuleType.Priere, ArmyRuleType.TraisUnitee),
	RuneDeKhaine_Priere("Rune de Khaine", ArmyRuleType.Priere, ArmyRuleType.TraisUnitee),

	//
	AttaqueDeCrochets("Attaque de Crochets", ArmyRuleType.Aptitude),
	BloodWrackViperConv("Convocation", ArmyRuleType.Aptitude),
	BladewindConv("Convocation", ArmyRuleType.Aptitude),
	TranchantSurnaturel("Tranchant Surnaturel", ArmyRuleType.Aptitude),


	;

	private List<ArmyRuleType> types;
	private String displayName;
	private Supplier<String> description;

	DokRule(ArmyRuleType... types) {
		this.types = Arrays.asList(types);
	}

	DokRule(String displayName, ArmyRuleType... types) {
		this.displayName = displayName;
		this.types = Arrays.asList(types);
	}

	DokRule(String displayName, Supplier<String> description, ArmyRuleType... types) {
		this.displayName = displayName;
		this.description = description;
		this.types = Arrays.asList(types);
	}

	@Override
	public List<ArmyRuleType> getTypes() {
		return types;
	}

	@Override
	public String displayName() {
		if (displayName == null) {
			return name();
		}
		return displayName;
	}

	@Override
	public String description() throws IOException {
		if (description == null) {
			return new DescriptionReader().read("Dok/", name());
		}
		return description.get();
	}

	@Override
	public String toString() {
		return name() + getTypes();
	}

}
