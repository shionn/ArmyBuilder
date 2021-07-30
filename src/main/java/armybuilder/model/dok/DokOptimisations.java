package armybuilder.model.dok;

import java.util.function.BiFunction;
import java.util.function.Consumer;

import armybuilder.model.Army;
import armybuilder.model.option.SubAllegiance;
import armybuilder.model.unit.KeyWord;
import armybuilder.model.unit.Unit;
import armybuilder.model.unit.option.IUnitOptionValue;
import armybuilder.model.unit.option.UnitOption;

public enum DokOptimisations implements IUnitOptionValue<DokOptimisations> {

	// TraisDeCommandement
	BainDeSang(
			UnitOption.TraisDeCommandement,
			(a, u) -> u.is(UnitOption.General) && !u.is(KeyWord.Unique)
					&& u.is(KeyWord.DaughtersOfKhaine) && u.is(KeyWord.Aelf)),
	OrateurZele(
			UnitOption.TraisDeCommandement,
			(a, u) -> u.is(UnitOption.General) && !u.is(KeyWord.Unique)
					&& u.is(KeyWord.DaughtersOfKhaine) && u.is(KeyWord.Aelf)),
	SacrificateurSanglant(
			UnitOption.TraisDeCommandement,
			(a, u) -> u.is(UnitOption.General) && !u.is(KeyWord.Unique)
					&& u.is(KeyWord.DaughtersOfKhaine) && u.is(KeyWord.Aelf)),
	BeauteTerrifiante(
			UnitOption.TraisDeCommandement,
			(a, u) -> u.is(UnitOption.General) && !u.is(KeyWord.Unique)
					&& u.is(KeyWord.DaughtersOfKhaine) && u.is(KeyWord.Aelf)),
	MaitreDesPoisons(
			UnitOption.TraisDeCommandement,
			(a, u) -> u.is(UnitOption.General) && !u.is(KeyWord.Unique)
					&& u.is(KeyWord.DaughtersOfKhaine) && u.is(KeyWord.Aelf)),
	VraiCroyant(
			UnitOption.TraisDeCommandement,
			(a, u) -> u.is(UnitOption.General) && !u.is(KeyWord.Unique)
					&& u.is(KeyWord.DaughtersOfKhaine) && u.is(KeyWord.Aelf)),

	MaitriseDesArcanes(
			UnitOption.TraisDeCommandement,
			(a, u) -> u.is(UnitOption.General) && !u.is(KeyWord.Unique)
					&& u.is(KeyWord.BloodwrackMedusa)),
	AnneauxOndulants(
			UnitOption.TraisDeCommandement,
			(a, u) -> u.is(UnitOption.General) && !u.is(KeyWord.Unique)
					&& u.is(KeyWord.BloodwrackMedusa)),
	PresenceEffrayante(
			UnitOption.TraisDeCommandement,
			(a, u) -> u.is(UnitOption.General) && !u.is(KeyWord.Unique)
					&& u.is(KeyWord.BloodwrackMedusa)),

	VeteranDeLaCathtrarDhule(
			UnitOption.TraisDeCommandement,
			(a, u) -> u.is(UnitOption.General) && !u.is(KeyWord.Unique)
					&& u.is(KeyWord.MelusaiIronscale)),
	EcaillesImpenetrables(
			UnitOption.TraisDeCommandement,
			(a, u) -> u.is(UnitOption.General) && !u.is(KeyWord.Unique)
					&& u.is(KeyWord.MelusaiIronscale)),
	AnimeParLaVengeance(
			UnitOption.TraisDeCommandement,
			(a, u) -> u.is(UnitOption.General) && !u.is(KeyWord.Unique)
					&& u.is(KeyWord.MelusaiIronscale)),

	// TraisDeCommandement de Sous allegiance
	DisciplesDevots(
			UnitOption.TraisDeCommandement,
			(a, u) -> u.is(UnitOption.General) && a.is(SubAllegiance.HaggNar)),
	VolEnCercle(
			UnitOption.TraisDeCommandement,
			(a, u) -> u.is(UnitOption.General) && a.is(SubAllegiance.KheltNar)),

	// Artefact
	CouronneDeDouleur(
			UnitOption.Artefact,
			(a, u) -> u.is(KeyWord.Heros) && !u.is(KeyWord.Unique)
					&& u.is(KeyWord.DaughtersOfKhaine)),
	CrocDeShadracar(
			UnitOption.Artefact,
			(a, u) -> u.is(KeyWord.Heros) && !u.is(KeyWord.Unique)
					&& u.is(KeyWord.DaughtersOfKhaine)),
	AmuletteDeFeuNoir(
			UnitOption.Artefact,
			(a, u) -> u.is(KeyWord.Heros) && !u.is(KeyWord.Unique)
					&& u.is(KeyWord.DaughtersOfKhaine)),
	LameSorciere(
			UnitOption.Artefact,
			(a, u) -> u.is(KeyWord.Heros) && !u.is(KeyWord.Unique)
					&& u.is(KeyWord.DaughtersOfKhaine)),
	MilleEtUneSombresMaledictions(
			UnitOption.Artefact,
			(a, u) -> u.is(KeyWord.Heros) && !u.is(KeyWord.Unique)
					&& u.is(KeyWord.DaughtersOfKhaine)),
	VeninFleauDuSang(
			UnitOption.Artefact,
			(a, u) -> u.is(KeyWord.Heros) && !u.is(KeyWord.Unique)
					&& u.is(KeyWord.DaughtersOfKhaine)),

	PierreDOmbre(
			UnitOption.Artefact,
			(a, u) -> u.is(KeyWord.Heros) && !u.is(KeyWord.Unique)
					&& u.is(KeyWord.BloodwrackMedusa)),
	RuneDUlgu(
			UnitOption.Artefact,
			(a, u) -> u.is(KeyWord.Heros) && !u.is(KeyWord.Unique)
					&& u.is(KeyWord.BloodwrackMedusa)),
	LeVougeMiroir(
			UnitOption.Artefact,
			(a, u) -> u.is(KeyWord.Heros) && !u.is(KeyWord.Unique)
					&& u.is(KeyWord.BloodwrackMedusa)),
	OmbreSeptFoisDrapee(
			UnitOption.Artefact,
			(a, u) -> u.is(KeyWord.Heros) && !u.is(KeyWord.Unique)
					&& u.is(KeyWord.BloodwrackMedusa)),
	CoeurDeCristal(
			UnitOption.Artefact,
			(a, u) -> u.is(KeyWord.Heros) && !u.is(KeyWord.Unique)
					&& u.is(KeyWord.BloodwrackMedusa)),
	GriffeDOmbre(
			UnitOption.Artefact,
			(a, u) -> u.is(KeyWord.Heros) && !u.is(KeyWord.Unique)
					&& u.is(KeyWord.BloodwrackMedusa)),

	SymboleSanglant(
			UnitOption.Artefact,
			(a, u) -> u.is(KeyWord.Heros) && !u.is(KeyWord.Unique)
					&& u.is(KeyWord.DaughtersOfKhaine) && u.is(KeyWord.Pretre)),
	DiademeDeFer(
			UnitOption.Artefact,
			(a, u) -> u.is(KeyWord.Heros) && !u.is(KeyWord.Unique)
					&& u.is(KeyWord.DaughtersOfKhaine) && u.is(KeyWord.Pretre)),
	RuneDeKhaine(
			UnitOption.Artefact,
			(a, u) -> u.is(KeyWord.Heros) && !u.is(KeyWord.Unique)
					&& u.is(KeyWord.DaughtersOfKhaine) && u.is(KeyWord.Pretre)),
	EclatPourpre(
			UnitOption.Artefact,
			(a, u) -> u.is(KeyWord.Heros) && !u.is(KeyWord.Unique)
					&& u.is(KeyWord.DaughtersOfKhaine) && u.is(KeyWord.Pretre)),
	PendentifKhainite(
			UnitOption.Artefact,
			(a, u) -> u.is(KeyWord.Heros) && !u.is(KeyWord.Unique)
					&& u.is(KeyWord.DaughtersOfKhaine) && u.is(KeyWord.Pretre)),
	BreuvageDeMatriarche(
			UnitOption.Artefact,
			(a, u) -> u.is(KeyWord.Heros) && !u.is(KeyWord.Unique)
					&& u.is(KeyWord.DaughtersOfKhaine) && u.is(KeyWord.Pretre)),

	// Artefact de sous allegiance
	LUlfuri(
			UnitOption.Artefact,
			(a, u) -> u.is(KeyWord.Heros) && u.is(KeyWord.HaggNar) && !u.is(KeyWord.Unique)),
	LaFaixDeGalisa(
			UnitOption.Artefact,
			(a, u) -> u.is(KeyWord.Heros) && u.is(KeyWord.KheltNar) && !u.is(KeyWord.Unique)),

	// Sort
	DestrierDOmbres(
			UnitOption.Sort,
			(a, u) -> u.is(KeyWord.Heros) && u.is(KeyWord.DaughtersOfKhaine)
					&& u.is(KeyWord.Sorcier)),
	PuitsDeTenebres(
			UnitOption.Sort,
			(a, u) -> u.is(KeyWord.Heros) && u.is(KeyWord.DaughtersOfKhaine)
					&& u.is(KeyWord.Sorcier)),
	DanseSymetrique(
			UnitOption.Sort,
			(a, u) -> u.is(KeyWord.Heros) && u.is(KeyWord.DaughtersOfKhaine)
					&& u.is(KeyWord.Sorcier)),
	Affaiblissement(
			UnitOption.Sort,
			(a, u) -> u.is(KeyWord.Heros) && u.is(KeyWord.DaughtersOfKhaine)
					&& u.is(KeyWord.Sorcier)),
	RasoirMental(
			UnitOption.Sort,
			(a, u) -> u.is(KeyWord.Heros) && u.is(KeyWord.DaughtersOfKhaine)
					&& u.is(KeyWord.Sorcier)),
	SuaireDeDesespoir(
			UnitOption.Sort,
			(a, u) -> u.is(KeyWord.Heros) && u.is(KeyWord.DaughtersOfKhaine)
					&& u.is(KeyWord.Sorcier)),

	// Priere
	CatechismeDuMeurtre(
			UnitOption.Priere,
			(a, u) -> u.is(KeyWord.Heros) && u.is(KeyWord.DaughtersOfKhaine)
					&& u.is(KeyWord.Pretre)),
	BenedictionDeKhaine(
			UnitOption.Priere,
			(a, u) -> u.is(KeyWord.Heros) && u.is(KeyWord.DaughtersOfKhaine)
					&& u.is(KeyWord.Pretre)),
	SacrificeDuMartyr(
			UnitOption.Priere,
			(a, u) -> u.is(KeyWord.Heros) && u.is(KeyWord.DaughtersOfKhaine)
					&& u.is(KeyWord.Pretre)),
	ResurrectionPourpre(
			UnitOption.Priere,
			(a, u) -> u.is(KeyWord.Heros) && u.is(KeyWord.DaughtersOfKhaine)
					&& u.is(KeyWord.Pretre)),
	CouventDuCoeurDeFer(
			UnitOption.Priere,
			(a, u) -> u.is(KeyWord.Heros) && u.is(KeyWord.DaughtersOfKhaine)
					&& u.is(KeyWord.Pretre)),
	SacreDeSang(
			UnitOption.Priere,
			(a, u) -> u.is(KeyWord.Heros) && u.is(KeyWord.DaughtersOfKhaine)
					&& u.is(KeyWord.Pretre)),

	// Compositioon
	Krone("Krone", UnitOption.Chef, (a, u) -> u.is(DokUnitModel.BloodStalkers), u -> {
		u.add(DokRule.Krone);
		u.add(DokUnitWeapon.GuivreDeSang);
	}),
	Gorgai("Gorgaï", UnitOption.Chef, (a, u) -> u.is(DokUnitModel.BloodSisters), null),
	Hag("Hag", UnitOption.Chef, (a, u) -> u.is(KeyWord.WitchAelves), null),
	Handmaiden("Handmaiden", UnitOption.Chef, (a, u) -> u.is(KeyWord.SisterOfSlaughter), null),
	PorteEtendard(
			"Porte-Étendard",
			UnitOption.Banniere,
			(a, u) -> u.is(KeyWord.WitchAelves) || u.is(KeyWord.SisterOfSlaughter),
			null),
	ShroudQueen(
			"Shroud Queen",
			UnitOption.Chef,
			(a, u) -> u.is(KeyWord.KhainiteShadowstalkers),
			u -> {
				u.add(DokUnitWeapon.LameObscures);
				u.add(DokRule.ShroudQueen);
			}),
	Shryke("Shryke", UnitOption.Chef, (a, u) -> u.is(KeyWord.KhineraiHeartrenders), null),
	SonneuseDeCor(
			"Sonneuse de Cor",
			UnitOption.Musicien,
			(a, u) -> u.is(KeyWord.WitchAelves) || u.is(KeyWord.SisterOfSlaughter),
			null),

	// Armes
	CouteauSacrificielEtRondacheTranchante(
			"Couteau Sacrificiel et Rondache Tranchante",
			UnitOption.Armes,
			(a, u) -> u.is(KeyWord.WitchAelves),
			u -> u.add(DokRule.RondacheTranchante)),
	PaireDeCouteauxSacrificiels(
			"Paire de Couteaux Sacrificiels",
			UnitOption.Armes,
			(a, u) -> u.is(KeyWord.WitchAelves),
			null),
	FouetBarbeleEtCouteauSacrificiel(
			"Fouet Barbelé Et Couteau Sacrificiel",
			UnitOption.Armes,
			(a, u) -> u.is(KeyWord.SisterOfSlaughter),
			u -> u.add(DokUnitWeapon.CouteauxSacrificiel)),
	FouetBarbeleEtRondacheTranchante(
			"Fouet Barbelé et Rondache Tranchante",
			UnitOption.Armes,
			(a, u) -> u.is(KeyWord.SisterOfSlaughter),
			u -> u.add(DokRule.RondacheTranchante)),

	// Cout
	Gratuit(
			"Gratuit",
			UnitOption.Gratuit,
			(a, u) -> u.is(KeyWord.KheltNar) && u.is(KeyWord.KhineraiHarpies),
			u -> u.setValue(0))

	;

	private String displayName;
	private UnitOption option;
	private BiFunction<Army, Unit, Boolean> available;
	private Consumer<Unit> modifier;

	DokOptimisations(String displayName, UnitOption type, BiFunction<Army, Unit, Boolean> available,
			Consumer<Unit> modifier) {
		this.displayName = displayName;
		this.option = type;
		this.available = available;
		this.modifier = modifier;
	}

	DokOptimisations(UnitOption type, BiFunction<Army, Unit, Boolean> available) {
		this.displayName = DokRule.valueOf(name()).getDisplayName();
		this.option = type;
		this.available = available;
	}

	@Override
	public String getDisplayName() {
		return "DoK : " + displayName;
	}

	@Override
	public UnitOption getOption() {
		return option;
	}

	@Override
	public boolean isAvailable(Army army, Unit unit) {
		return available.apply(army, unit);
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
