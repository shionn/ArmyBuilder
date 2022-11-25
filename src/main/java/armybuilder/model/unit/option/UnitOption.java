package armybuilder.model.unit.option;

import armybuilder.model.dok.DokOptimisations;
import armybuilder.model.stormcast.StormcastOptimisation;
import armybuilder.model.unit.Unit;

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
	Krone(DokOptimisations.Krone),
	Gorgai(DokOptimisations.Gorgai),
	ShroudQueen(DokOptimisations.ShroudQueen),

	AppelALAide(StormcastOptimisation.AppelALAide),
	ArmeDesCieuxEtBouclierDeSigmarite(StormcastOptimisation.ArmeDesCieuxEtBouclierDeSigmarite),
	CoupDeTonerreFinal(StormcastOptimisation.CoupDeTonerreFinal),
	DechainezVotreAine(StormcastOptimisation.DechainezVotreAine),
	JudicatorArcPrimus(StormcastOptimisation.JudicatorArcPrimus),
	LiberatorPrimus(StormcastOptimisation.LiberatorPrimus),
	MarcheImpertubable(StormcastOptimisation.MarcheImpertubable),
	PaireDArmesDesCieux(StormcastOptimisation.PaireDArmesDesCieux),
	SequitorPrimus(StormcastOptimisation.SequitorPrimus),
	SignifereAzyrite(StormcastOptimisation.SignifereAzyrite),
	VindictorPrimus(StormcastOptimisation.VindictorPrimus),
	VoleeDEclairs(StormcastOptimisation.VoleeDEclairs),
	;

	private IUnitOption sub;

	UnitOption(IUnitOption sub) {
		this.sub = sub;
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
