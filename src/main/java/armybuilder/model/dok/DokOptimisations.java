package armybuilder.model.dok;

import java.util.function.Consumer;
import java.util.function.Function;

import armybuilder.model.army.option.SubAllegiance;
import armybuilder.model.unit.KeyWord;
import armybuilder.model.unit.Unit;
import armybuilder.model.unit.option.IUnitOptionValue;
import armybuilder.model.unit.option.UnitOption;

public enum DokOptimisations implements IUnitOptionValue<DokOptimisations> {

	// TraisDeCommandement
	BainDeSang(
			UnitOption.TraisDeCommandement,
			u -> u.is(UnitOption.General) && !u.is(KeyWord.Unique)
					&& u.is(KeyWord.DaughtersOfKhaine) && u.is(KeyWord.Aelf)),
	OrateurZele(
			UnitOption.TraisDeCommandement,
			u -> u.is(UnitOption.General) && !u.is(KeyWord.Unique)
					&& u.is(KeyWord.DaughtersOfKhaine) && u.is(KeyWord.Aelf)),
	SacrificateurSanglant(
			UnitOption.TraisDeCommandement,
			u -> u.is(UnitOption.General) && !u.is(KeyWord.Unique)
					&& u.is(KeyWord.DaughtersOfKhaine) && u.is(KeyWord.Aelf)),
	BeauteTerrifiante(
			UnitOption.TraisDeCommandement,
			u -> u.is(UnitOption.General) && !u.is(KeyWord.Unique)
					&& u.is(KeyWord.DaughtersOfKhaine) && u.is(KeyWord.Aelf)),
	MaitreDesPoisons(
			UnitOption.TraisDeCommandement,
			u -> u.is(UnitOption.General) && !u.is(KeyWord.Unique)
					&& u.is(KeyWord.DaughtersOfKhaine) && u.is(KeyWord.Aelf)),
	VraiCroyant(
			UnitOption.TraisDeCommandement,
			u -> u.is(UnitOption.General) && !u.is(KeyWord.Unique)
					&& u.is(KeyWord.DaughtersOfKhaine) && u.is(KeyWord.Aelf)),

	MaitriseDesArcanes(
			UnitOption.TraisDeCommandement,
			u -> u.is(UnitOption.General) && !u.is(KeyWord.Unique)
					&& u.is(KeyWord.BloodwrackMedusa)),
	AnneauxOndulants(
			UnitOption.TraisDeCommandement,
			u -> u.is(UnitOption.General) && !u.is(KeyWord.Unique)
					&& u.is(KeyWord.BloodwrackMedusa)),
	PresenceEffrayante(
			UnitOption.TraisDeCommandement,
			u -> u.is(UnitOption.General) && !u.is(KeyWord.Unique)
					&& u.is(KeyWord.BloodwrackMedusa)),

	VeteranDeLaCathtrarDhule(
			UnitOption.TraisDeCommandement,
			u -> u.is(UnitOption.General) && !u.is(KeyWord.Unique)
					&& u.is(KeyWord.MelusaiIronscale)),
	EcaillesImpenetrables(
			UnitOption.TraisDeCommandement,
			u -> u.is(UnitOption.General) && !u.is(KeyWord.Unique)
					&& u.is(KeyWord.MelusaiIronscale)),
	AnimeParLaVengeance(
			UnitOption.TraisDeCommandement,
			u -> u.is(UnitOption.General) && !u.is(KeyWord.Unique)
					&& u.is(KeyWord.MelusaiIronscale)),

	// TraisDeCommandement de Sous allegiance
	DisciplesDevots(
			UnitOption.TraisDeCommandement,
			u -> u.is(UnitOption.General) && u.listing().is(SubAllegiance.HaggNar)
					&& !u.is(KeyWord.Unique)),
	MaitresseDeLIllusion(
			UnitOption.TraisDeCommandement,
			u -> u.is(UnitOption.General) && u.listing().is(SubAllegiance.Khailebron)
					&& !u.is(KeyWord.Unique)),
	MaledictionDeLaMainSanglante(
			UnitOption.TraisDeCommandement,
			u -> u.is(UnitOption.General) && u.listing().is(SubAllegiance.ZaintharKai)
					&& !u.is(KeyWord.Unique)),
	SeBaignerDansLeurSang(
			UnitOption.TraisDeCommandement,
			u -> u.is(UnitOption.General) && u.listing().is(SubAllegiance.Kraith)
					&& !u.is(KeyWord.Unique)),
	VainqueurDuYaithRil(
			UnitOption.TraisDeCommandement,
			u -> u.is(UnitOption.General) && u.listing().is(SubAllegiance.DraichiGaneth)
					&& !u.is(KeyWord.Unique)),
	VolEnCercle(
			UnitOption.TraisDeCommandement,
			u -> u.is(UnitOption.General) && u.listing().is(SubAllegiance.KheltNar)
					&& !u.is(KeyWord.Unique)),

	// Artefact
	CouronneDeDouleur(
			UnitOption.Artefact,
			u -> u.is(KeyWord.Heros) && !u.is(KeyWord.Unique)
					&& u.is(KeyWord.DaughtersOfKhaine)),
	CrocDeShadracar(
			UnitOption.Artefact,
			u -> u.is(KeyWord.Heros) && !u.is(KeyWord.Unique)
					&& u.is(KeyWord.DaughtersOfKhaine)),
	AmuletteDeFeuNoir(
			UnitOption.Artefact,
			u -> u.is(KeyWord.Heros) && !u.is(KeyWord.Unique)
					&& u.is(KeyWord.DaughtersOfKhaine)),
	LameSorciere(
			UnitOption.Artefact,
			u -> u.is(KeyWord.Heros) && !u.is(KeyWord.Unique)
					&& u.is(KeyWord.DaughtersOfKhaine)),
	MilleEtUneSombresMaledictions(
			UnitOption.Artefact,
			u -> u.is(KeyWord.Heros) && !u.is(KeyWord.Unique)
					&& u.is(KeyWord.DaughtersOfKhaine)),
	VeninFleauDuSang(
			UnitOption.Artefact,
			u -> u.is(KeyWord.Heros) && !u.is(KeyWord.Unique)
					&& u.is(KeyWord.DaughtersOfKhaine)),

	PierreDOmbre(
			UnitOption.Artefact,
			u -> u.is(KeyWord.Heros) && !u.is(KeyWord.Unique)
					&& u.is(KeyWord.BloodwrackMedusa)),
	RuneDUlgu(
			UnitOption.Artefact,
			u -> u.is(KeyWord.Heros) && !u.is(KeyWord.Unique)
					&& u.is(KeyWord.BloodwrackMedusa)),
	LeVougeMiroir(
			UnitOption.Artefact,
			u -> u.is(KeyWord.Heros) && !u.is(KeyWord.Unique)
					&& u.is(KeyWord.BloodwrackMedusa)),
	OmbreSeptFoisDrapee(
			UnitOption.Artefact,
			u -> u.is(KeyWord.Heros) && !u.is(KeyWord.Unique)
					&& u.is(KeyWord.BloodwrackMedusa)),
	CoeurDeCristal(
			UnitOption.Artefact,
			u -> u.is(KeyWord.Heros) && !u.is(KeyWord.Unique)
					&& u.is(KeyWord.BloodwrackMedusa)),
	GriffeDOmbre(
			UnitOption.Artefact,
			u -> u.is(KeyWord.Heros) && !u.is(KeyWord.Unique)
					&& u.is(KeyWord.BloodwrackMedusa)),

	SymboleSanglant(
			UnitOption.Artefact,
			u -> u.is(KeyWord.Heros) && !u.is(KeyWord.Unique)
					&& u.is(KeyWord.DaughtersOfKhaine) && u.is(KeyWord.Pretre)),
	DiademeDeFer(
			UnitOption.Artefact,
			u -> u.is(KeyWord.Heros) && !u.is(KeyWord.Unique)
					&& u.is(KeyWord.DaughtersOfKhaine) && u.is(KeyWord.Pretre)),
	RuneDeKhaine(
			UnitOption.Artefact,
			u -> u.is(KeyWord.Heros) && !u.is(KeyWord.Unique)
					&& u.is(KeyWord.DaughtersOfKhaine) && u.is(KeyWord.Pretre)),
	EclatPourpre(
			UnitOption.Artefact,
			u -> u.is(KeyWord.Heros) && !u.is(KeyWord.Unique)
					&& u.is(KeyWord.DaughtersOfKhaine) && u.is(KeyWord.Pretre)),
	PendentifKhainite(
			UnitOption.Artefact,
			u -> u.is(KeyWord.Heros) && !u.is(KeyWord.Unique)
					&& u.is(KeyWord.DaughtersOfKhaine) && u.is(KeyWord.Pretre)),
	BreuvageDeMatriarche(
			UnitOption.Artefact,
			u -> u.is(KeyWord.Heros) && !u.is(KeyWord.Unique)
					&& u.is(KeyWord.DaughtersOfKhaine) && u.is(KeyWord.Pretre)),

	// Artefact de sous allegiance
	BaiserDeLaMort(
			UnitOption.Artefact,
			u -> u.is(KeyWord.Heros) && u.is(KeyWord.DraichiGaneth) && !u.is(KeyWord.Unique)),
	LUlfuri(
			UnitOption.Artefact,
			u -> u.is(KeyWord.Heros) && u.is(KeyWord.HaggNar) && !u.is(KeyWord.Unique)),
	LaFaixDeGalisa(
			UnitOption.Artefact,
			u -> u.is(KeyWord.Heros) && u.is(KeyWord.KheltNar) && !u.is(KeyWord.Unique)),
	Mormurmure(
			UnitOption.Artefact,
			u -> u.is(KeyWord.Heros) && u.is(KeyWord.Khailebron) && !u.is(KeyWord.Unique)),
	VeninDeNagendra(
			UnitOption.Artefact,
			u -> u.is(KeyWord.Heros) && u.is(KeyWord.Kraith) && !u.is(KeyWord.Unique)),
	TalismanEcarlate(
			UnitOption.Artefact,
			u -> u.is(KeyWord.Heros) && u.is(KeyWord.ZaintharKai) && !u.is(KeyWord.Unique)),

	// Sort
	DestrierDOmbres(
			UnitOption.Sort,
			u -> u.is(KeyWord.Heros) && u.is(KeyWord.DaughtersOfKhaine)
					&& u.is(KeyWord.Sorcier)),
	PuitsDeTenebres(
			UnitOption.Sort,
			u -> u.is(KeyWord.Heros) && u.is(KeyWord.DaughtersOfKhaine)
					&& u.is(KeyWord.Sorcier)),
	DanseSymetrique(
			UnitOption.Sort,
			u -> u.is(KeyWord.Heros) && u.is(KeyWord.DaughtersOfKhaine)
					&& u.is(KeyWord.Sorcier)),
	Affaiblissement(
			UnitOption.Sort,
			u -> u.is(KeyWord.Heros) && u.is(KeyWord.DaughtersOfKhaine)
					&& u.is(KeyWord.Sorcier)),
	RasoirMental(
			UnitOption.Sort,
			u -> u.is(KeyWord.Heros) && u.is(KeyWord.DaughtersOfKhaine)
					&& u.is(KeyWord.Sorcier)),
	SuaireDeDesespoir(
			UnitOption.Sort,
			u -> u.is(KeyWord.Heros) && u.is(KeyWord.DaughtersOfKhaine)
					&& u.is(KeyWord.Sorcier)),

	// Priere
	CatechismeDuMeurtre(
			UnitOption.Priere,
			u -> u.is(KeyWord.Heros) && u.is(KeyWord.DaughtersOfKhaine)
					&& u.is(KeyWord.Pretre)),
	BenedictionDeKhaine(
			UnitOption.Priere,
			u -> u.is(KeyWord.Heros) && u.is(KeyWord.DaughtersOfKhaine)
					&& u.is(KeyWord.Pretre)),
	SacrificeDuMartyr(
			UnitOption.Priere,
			u -> u.is(KeyWord.Heros) && u.is(KeyWord.DaughtersOfKhaine)
					&& u.is(KeyWord.Pretre)),
	ResurrectionPourpre(
			UnitOption.Priere,
			u -> u.is(KeyWord.Heros) && u.is(KeyWord.DaughtersOfKhaine)
					&& u.is(KeyWord.Pretre)),
	CouventDuCoeurDeFer(
			UnitOption.Priere,
			u -> u.is(KeyWord.Heros) && u.is(KeyWord.DaughtersOfKhaine)
					&& u.is(KeyWord.Pretre)),
	SacreDeSang(
			UnitOption.Priere,
			u -> u.is(KeyWord.Heros) && u.is(KeyWord.DaughtersOfKhaine)
					&& u.is(KeyWord.Pretre)),

	// Compositioon
	Krone("Krone", UnitOption.Chef, u -> u.is(DokUnitModel.BloodStalkers), u -> {
		u.add(DokRule.Krone);
		u.add(DokUnitWeapon.GuivreDeSang);
	}),
	Gorgai("Gorgaï", UnitOption.Chef, u -> u.is(DokUnitModel.BloodSisters), null),
	Hag("Hag", UnitOption.Chef, u -> u.is(KeyWord.WitchAelves), null),
	Handmaiden("Handmaiden", UnitOption.Chef, u -> u.is(KeyWord.SisterOfSlaughter), null),
	PorteEtendard(
			"Porte-Étendard",
			UnitOption.Banniere,
			u -> u.is(KeyWord.WitchAelves) || u.is(KeyWord.SisterOfSlaughter),
			null),
	ShroudQueen(
			"Shroud Queen",
			UnitOption.Chef,
			u -> u.is(KeyWord.KhainiteShadowstalkers),
			u -> {
				u.add(DokUnitWeapon.LameObscures);
				u.add(DokRule.ShroudQueen);
			}),
	Shryke("Shryke", UnitOption.Chef, u -> u.is(KeyWord.KhineraiHeartrenders), null),
	SonneuseDeCor(
			"Sonneuse de Cor",
			UnitOption.Musicien,
			u -> u.is(KeyWord.WitchAelves) || u.is(KeyWord.SisterOfSlaughter),
			null),

	// Armes
	CouteauSacrificielEtRondacheTranchante(
			"Couteau Sacrificiel et Rondache Tranchante",
			UnitOption.Armes,
			u -> u.is(KeyWord.WitchAelves),
			u -> u.add(DokRule.RondacheTranchante)),
	PaireDeCouteauxSacrificiels(
			"Paire de Couteaux Sacrificiels",
			UnitOption.Armes,
			u -> u.is(KeyWord.WitchAelves),
			null),
	FouetBarbeleEtCouteauSacrificiel(
			"Fouet Barbelé Et Couteau Sacrificiel",
			UnitOption.Armes,
			u -> u.is(KeyWord.SisterOfSlaughter),
			u -> u.add(DokUnitWeapon.CouteauxSacrificiel)),
	FouetBarbeleEtRondacheTranchante(
			"Fouet Barbelé et Rondache Tranchante",
			UnitOption.Armes,
			u -> u.is(KeyWord.SisterOfSlaughter),
			u -> u.add(DokRule.RondacheTranchante)),

	// Cout
	Gratuit(
			"Gratuit",
			UnitOption.Gratuit,
			u -> u.is(KeyWord.KheltNar) && u.is(KeyWord.KhineraiHarpies),
			u -> u.setPoints(0)),

	;

	private String displayName;
	private UnitOption option;
	private Function<Unit, Boolean> available;
	private Consumer<Unit> modifier;

	DokOptimisations(String displayName, UnitOption type, Function<Unit, Boolean> available,
			Consumer<Unit> modifier) {
		this.displayName = displayName;
		this.option = type;
		this.available = available;
		this.modifier = modifier;
	}

	DokOptimisations(UnitOption type, Function<Unit, Boolean> available) {
		this.displayName = DokRule.valueOf(name()).getDisplayName();
		this.option = type;
		this.available = available;
	}

	@Override
	public String getDisplayName() {
		return "DoK : " + displayName;
	}

	@Override
	public UnitOption option() {
		return option;
	}

	@Override
	public boolean isAvailable(Unit unit) {
		return available.apply(unit);
	}

	@Override
	public void rebuild(Unit unit) {
		if (modifier == null) {
			unit.add(DokRule.valueOf(name()));
		} else {
			modifier.accept(unit);
		}
	}

}
