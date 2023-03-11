package armybuilder.model.unit.option;

import static armybuilder.model.unit.option.BaseUnitOption.builder;

import armybuilder.model.dok.DokOptimisations;
import armybuilder.model.nighthaunt.NighthauntOptimisation;
import armybuilder.model.rule.PackDeBatailleRule;
import armybuilder.model.skaven.SkavenOptimisation;
import armybuilder.model.stormcast.StormcastOptimisation;
import armybuilder.model.unit.Unit;
import armybuilder.model.unit.keyword.KeyWord;

public enum UnitOption implements IUnitOption {
	SoifDeBataille(OptimisationsUniverselles.SoifDeBataille),
	LeaderCompetent(OptimisationsUniverselles.LeaderCompetent),
	GrandPretre(OptimisationsUniverselles.GrandPretre),
	StatureHeroique(OptimisationsUniverselles.StatureHeroique),
	MaitreDeLaMagie(OptimisationsUniverselles.MaitreDeLaMagie),
	AmuletteDeLaDestinee(OptimisationsUniverselles.AmuletteDeLaDestinee),
	VolumeObscur(OptimisationsUniverselles.VolumeObscur),
	FioleDeVeninDeManticore(OptimisationsUniverselles.FioleDeVeninDeManticore),
	GraineDeRenaissance(OptimisationsUniverselles.GraineDeRenaissance),
	ArmeEnflammee(OptimisationsUniverselles.ArmeEnflammee),
	BrumeFantome(OptimisationsUniverselles.BrumeFantome),
	Levitation(OptimisationsUniverselles.Levitation),
	Supervision(OptimisationsUniverselles.Supervision),
	Malediction(OptimisationsUniverselles.Malediction),
	Guerison(OptimisationsUniverselles.Guerison),
	General(OptimisationsUniverselles.General),
	Invoquee(OptimisationsUniverselles.Invoquee),
	PasDeRenfort(OptimisationsUniverselles.PasDeRenfort),
	RenforceesUneFois(OptimisationsUniverselles.RenforceesUneFois),
	RenforceesDeuxFois(OptimisationsUniverselles.RenforceesDeuxFois),

	AlimenteParLaRageDeGhur(builder().aspectsDuChampion(PackDeBatailleRule.AlimenteParLaRageDeGhur)),
	EnteteCommeUnRhinox(builder().aspectsDuChampion(PackDeBatailleRule.EnteteCommeUnRhinox)),
	MaitreDesTunnels(builder().aspectsDuChampion(PackDeBatailleRule.MaitreDesTunnels)),
	AutoriteDuDominant(builder().aspectsDuChampion(PackDeBatailleRule.AutoriteDuDominant)),

	CapeDeNictoptere(builder().artefact(PackDeBatailleRule.CapeDeNictoptere).availableFor(KeyWord.ChampionDeGallet)),
	CharmeDePlumeDeGriffe(builder().artefact(PackDeBatailleRule.CharmeDePlumeDeGriffe).availableFor(KeyWord.ChampionDeGallet)),
	HeameDIvoire(builder().artefact(PackDeBatailleRule.HeameDIvoire).availableFor(KeyWord.ChampionDeGallet)),

	BainDeSang(DokOptimisations.BainDeSang),
	MaitriseDesArcanes(DokOptimisations.MaitriseDesArcanes),
	MaitreDesPoisons(DokOptimisations.MaitreDesPoisons),
	OrateurZele(DokOptimisations.OrateurZele),
	PousseParLaVengeance(DokOptimisations.PousseParLaVengeance),
	SacrificateurSanglant(DokOptimisations.SacrificateurSanglant),
	VraiCroyant(DokOptimisations.VraiCroyant),
	CoeurDeCristal(DokOptimisations.CoeurDeCristal),
	CouronneDeDouleur(DokOptimisations.CouronneDeDouleur),
	LameSorciere(DokOptimisations.LameSorciere),
	OmbreSeptFoisDrapee(DokOptimisations.OmbreSeptFoisDrapee),
	PendentifKhainite(DokOptimisations.PendentifKhainite),
	PierreDOmbre(DokOptimisations.PierreDOmbre),
	RuneDeKhaine(DokOptimisations.RuneDeKhaine),
	SymboleSanglant(DokOptimisations.SymboleSanglant),
	VeninFleauDuSang(DokOptimisations.VeninFleauDuSang),
	Affaiblissement(DokOptimisations.Affaiblissement),
	DanseSymetrique(DokOptimisations.DanseSymetrique),
	DestrierDOmbres(DokOptimisations.DestrierDOmbres),
	PuitsDeTenebres(DokOptimisations.PuitsDeTenebres),
	RasoirMental(DokOptimisations.RasoirMental),
	SuaireDeDesespoir(DokOptimisations.SuaireDeDesespoir),
	BenedictionDeKhaine(DokOptimisations.BenedictionDeKhaine),
	CatechismeDuMeurtre(DokOptimisations.CatechismeDuMeurtre),
	CouventDuCoeurDeFer(DokOptimisations.CouventDuCoeurDeFer),
	SacreDeSang(DokOptimisations.SacreDeSang),
	SacrificeDuMartyr(DokOptimisations.SacrificeDuMartyr),
	ResurrectionPourpre(DokOptimisations.ResurrectionPourpre),
	Ecorcheuse(DokOptimisations.Ecorcheuse),
	Matriache(DokOptimisations.Matriache),
	PorteuseDePennonDeMort(DokOptimisations.PorteuseDePennonDeMort),
	Servante(DokOptimisations.Servante),
	SonneuseDeCor(DokOptimisations.SonneuseDeCor),
	SciansaAppairees(DokOptimisations.SciansaAppairees),
	SciansaEtRondacheTranchante(DokOptimisations.SciansaEtRondacheTranchante),
	FouetBarbeleEtRondacheTranchante(DokOptimisations.FouetBarbeleEtRondacheTranchante),
	FouetBarbeleEtCouteauSacrificiel(DokOptimisations.FouetBarbeleEtCouteauSacrificiel),
//	TODO Krone(DokOptimisations.Krone),
//	Gorgai(DokOptimisations.Gorgai),
//	ShroudQueen(DokOptimisations.ShroudQueen),

	DrapeDOmbre(NighthauntOptimisation.DrapeDOmbre),
	EntiteTerrifiante(NighthauntOptimisation.EntiteTerrifiante),
	EspritAmer(NighthauntOptimisation.EspritAmer),
	EspritPersistant(NighthauntOptimisation.EspritPersistant),
	HaineDesVivants(NighthauntOptimisation.HaineDesVivants),
	MaitreDesOstsSpectraux(NighthauntOptimisation.MaitreDesOstsSpectraux),
	AnneauDuFeuDeLame(NighthauntOptimisation.AnneauDuFeuDeLame),
	CapeDeLaLuneCroissante(NighthauntOptimisation.CapeDeLaLuneCroissante),
	EclatDeLuneDesMoissons(NighthauntOptimisation.EclatDeLuneDesMoissons),
	FamilierAvide(NighthauntOptimisation.FamilierAvide),
	FanalDeNagashizzar(NighthauntOptimisation.FanalDeNagashizzar),
	FaucheLesPeines(NighthauntOptimisation.FaucheLesPeines),
	FilDeLOmbre(NighthauntOptimisation.FilDeLOmbre),
	GrimoireDeMinuit(NighthauntOptimisation.GrimoireDeMinuit),
	Inciseur(NighthauntOptimisation.Inciseur),
	LanterneDeSorcellumiere(NighthauntOptimisation.LanterneDeSorcellumiere),
	PendentifDuVentMaussade(NighthauntOptimisation.PendentifDuVentMaussade),
	BrumeSepulcrale(NighthauntOptimisation.BrumeSepulcrale),
	CageAAmes(NighthauntOptimisation.CageAAmes),
	CanuleSpectrale(NighthauntOptimisation.CanuleSpectrale),
	DrainDEsprit(NighthauntOptimisation.DrainDEsprit),
	VoleurDeVie(NighthauntOptimisation.VoleurDeVie),
	SceauDeShyish(NighthauntOptimisation.SceauDeShyish),
	QuesteurDeShyish(NighthauntOptimisation.QuesteurDeShyish),
	Affregarde(NighthauntOptimisation.Affregarde),
	TambourDArythmie(NighthauntOptimisation.TambourDArythmie),
	Tailladeuse(NighthauntOptimisation.Tailladeuse),
	SpectreInfernal(NighthauntOptimisation.SpectreInfernal),

	AdversaireSournois(SkavenOptimisation.AdversaireSournois),
	ManipulateurSupreme(SkavenOptimisation.ManipulateurSupreme),
	MaitreDeLaMagie_skaven(SkavenOptimisation.MaitreDeLaMagie),
	IntrigantDiabolique(SkavenOptimisation.IntrigantDiabolique),
	MutateurAstucieux(SkavenOptimisation.MutateurAstucieux),
	ModeleurSupreme(SkavenOptimisation.ModeleurSupreme),
	MaitreDeHorde(SkavenOptimisation.MaitreDeHorde),
	TueurSansEgal(SkavenOptimisation.TueurSansEgal),
	MaitreDesOmbres(SkavenOptimisation.MaitreDesOmbres),
	AgiliteIncroyable(SkavenOptimisation.AgiliteIncroyable),
	LameRouillee(SkavenOptimisation.LameRouillee),
	Maitregriffe(SkavenOptimisation.Maitregriffe),
	PorteEtendardDesClans(SkavenOptimisation.PorteEtendardDesClans),
	SonneurDeClocheDesClans(SkavenOptimisation.SonneurDeClocheDesClans),
	VaillanceVermineuse(SkavenOptimisation.VaillanceVermineuse),
	SeigneurSauvage(SkavenOptimisation.SeigneurSauvage),
	PuissantAlpha(SkavenOptimisation.PuissantAlpha),
	SuperviseurDeDestruction(SkavenOptimisation.SuperviseurDeDestruction),
	CollectionneurEmerite(SkavenOptimisation.CollectionneurEmerite),
	InventeurDerange(SkavenOptimisation.InventeurDerange),
	MaitreDeLaPourritureEtDeLaRuine(SkavenOptimisation.MaitreDeLaPourritureEtDeLaRuine),
	ArchitecteDeLaMort(SkavenOptimisation.ArchitecteDeLaMort),
	Scrofuleux(SkavenOptimisation.Scrofuleux),
	LeRongeclat(SkavenOptimisation.LeRongeclat),
	Skavenectar(SkavenOptimisation.Skavenectar),
	SceptreDeSuprematieLegitime(SkavenOptimisation.SceptreDeSuprematieLegitime),
	FouetDeCrocs(SkavenOptimisation.FouetDeCrocs),
	CouronneEnragee(SkavenOptimisation.CouronneEnragee),
	Salecuir(SkavenOptimisation.Salecuir),
	BabioleTenebromagnetique(SkavenOptimisation.BabioleTenebromagnetique),
	CapeDetaleuse(SkavenOptimisation.CapeDetaleuse),
	Rongebombe(SkavenOptimisation.Rongebombe),
	BouclierDeDistraction(SkavenOptimisation.Rongebombe),
	ResonateurEsoteriqueAMalepierre(SkavenOptimisation.Rongebombe),
	ArmureDeMalerouille(SkavenOptimisation.Rongebombe),
	CharmeDeMalepierre(SkavenOptimisation.Rongebombe),
	FioleDuFulminateur(SkavenOptimisation.Rongebombe),
	LeFumigatus(SkavenOptimisation.Rongebombe),
	CloquepusLeKysteVivant(SkavenOptimisation.Rongebombe),
	LOrbeDAirain(SkavenOptimisation.Rongebombe),
	LameDeCorruption(SkavenOptimisation.Rongebombe),

	AnnihilatorPrimus(StormcastOptimisation.AnnihilatorPrimus),
	ArmeDesCieuxEtBouclierDeSigmarite(StormcastOptimisation.ArmeDesCieuxEtBouclierDeSigmarite),
	CastigatorPrimus(StormcastOptimisation.CastigatorPrimus),
	GryphDogueAlpha(StormcastOptimisation.GryphDogueAlpha),
	JudicatorArcPrimus(StormcastOptimisation.JudicatorArcPrimus),
	LiberatorPrimus(StormcastOptimisation.LiberatorPrimus),
	PaireDArmesDesCieux(StormcastOptimisation.PaireDArmesDesCieux),
	SequitorPrimus(StormcastOptimisation.SequitorPrimus),
	SignifereAzyrite(StormcastOptimisation.SignifereAzyrite),
	VindictorPrimus(StormcastOptimisation.VindictorPrimus),
	ProsecutorPrimus(StormcastOptimisation.ProsecutorPrimus),
	RetributorPrimus(StormcastOptimisation.RetributorPrimus),
	PraetorPrimus(StormcastOptimisation.PraetorPrimus),
	EvocatorPrimus(StormcastOptimisation.EvocatorPrimus),
	ChocEtStupeur(StormcastOptimisation.ChocEtStupeur),
	FerventDefenseur(StormcastOptimisation.FerventDefenseur),
	MessagerDesCieux(StormcastOptimisation.MessagerDesCieux),
	MaitreDeLaMenagerieCeleste(StormcastOptimisation.MaitreDeLaMenagerieCeleste),
	AmuletteDeSigmarite(StormcastOptimisation.AmuletteDeSigmarite),
	ArmureDecaillesDeDrac(StormcastOptimisation.ArmureDecaillesDeDrac),
	BouclierMiroir(StormcastOptimisation.BouclierMiroir),
	BreuvageDeVifArgent(StormcastOptimisation.BreuvageDeVifArgent),
	CrocDeDracothion(StormcastOptimisation.CrocDeDracothion),
	LameDeHero(StormcastOptimisation.LameDeHero),
	MarteauDePuissance(StormcastOptimisation.MarteauDePuissance),
	PierreDeChance(StormcastOptimisation.PierreDeChance),
	AmuletteDObsidienne(StormcastOptimisation.AmuletteDObsidienne),
	SalveDEclairs(StormcastOptimisation.SalveDEclairs),
	HaloAzyrite(StormcastOptimisation.HaloAzyrite),
	LamesCelestes(StormcastOptimisation.LamesCelestes),
	ChocDuTonnerre(StormcastOptimisation.ChocDuTonnerre),
	ChuteDEtoile(StormcastOptimisation.ChuteDEtoile),
	ChaineDEclairs(StormcastOptimisation.ChaineDEclairs),
	MarteauCelesteEtBouclierDeSigmarite(StormcastOptimisation.MarteauCelesteEtBouclierDeSigmarite),
	PaireDeMarteauxCelestes(StormcastOptimisation.PaireDeMarteauxCelestes),
	VitesseEtherique(StormcastOptimisation.VitesseEtherique),
	MessagerDeLaFoudre(StormcastOptimisation.MessagerDeLaFoudre),
	InstinctCeleste(StormcastOptimisation.InstinctCeleste),
	TraineeScintillante(StormcastOptimisation.TraineeScintillante),
	LumiereDesJeunesEtoiles(StormcastOptimisation.LumiereDesJeunesEtoiles),
	PresenceTonitruante(StormcastOptimisation.PresenceTonitruante),
	BenedictionDesArmes_12(StormcastOptimisation.BenedictionDesArmes_12),
	BenedictionDesArmes_18(StormcastOptimisation.BenedictionDesArmes_18),
	Translocation(StormcastOptimisation.Translocation),
	LumiereDivine(StormcastOptimisation.LumiereDivine),
	MarteauxAstraux(StormcastOptimisation.MarteauxAstraux),
	GrandMarteauxAstral(StormcastOptimisation.GrandMarteauxAstral),
	RaptorPrimus(StormcastOptimisation.RaptorPrimus),


	;

	private IUnitOption sub;

	UnitOption(IUnitOption sub) {
		this.sub = sub;
	}

	UnitOption(BaseUnitOption.Builder sub) {
		this.sub = sub.build();
	}

	public String getFullDisplayName() {
		if (sub instanceof OptimisationsUniverselles) {
			return "Universelle: " + getDisplayName();
		}
		if (sub instanceof NighthauntOptimisation) {
			return "Hantenuits: " + getDisplayName();
		}
		return getDisplayName();
	}

	@Override
	public String getDisplayName() {
		return sub.getDisplayName();
	}

	@Override
	public UnitOptionCategory getCategory() {
		return sub.getCategory();
	}

	@Override
	public boolean availableFor(Unit unit) {
		return sub.availableFor(unit);
	}

	@Override
	public void decorate(Unit unit) {
		sub.decorate(unit);
	}

}
