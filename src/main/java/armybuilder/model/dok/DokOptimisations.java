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

	BainDeSang(
			"Bain de Sang",
			UnitOption.TraisDeCommandement,
			(a, u) -> u.is(UnitOption.General) && !u.is(KeyWord.Unique)
					&& u.is(KeyWord.DaughtersOfKhaine) && u.is(KeyWord.Aelf),
			null),
	OrateurZele(
			"Orateur Zélé",
			UnitOption.TraisDeCommandement,
			(a, u) -> u.is(UnitOption.General) && !u.is(KeyWord.Unique)
					&& u.is(KeyWord.DaughtersOfKhaine) && u.is(KeyWord.Aelf),
			null),
	SacrificateurSanglant(
			"Sacrificateur Sanglant",
			UnitOption.TraisDeCommandement,
			(a, u) -> u.is(UnitOption.General) && !u.is(KeyWord.Unique)
					&& u.is(KeyWord.DaughtersOfKhaine) && u.is(KeyWord.Aelf),
			null),
	BeauteTerrifiante(
			"Beauté Terrifiante",
			UnitOption.TraisDeCommandement,
			(a, u) -> u.is(UnitOption.General) && !u.is(KeyWord.Unique)
					&& u.is(KeyWord.DaughtersOfKhaine) && u.is(KeyWord.Aelf),
			null),
	MaitreDesPoisons(
			"Maître des Poisons",
			UnitOption.TraisDeCommandement,
			(a, u) -> u.is(UnitOption.General) && !u.is(KeyWord.Unique)
					&& u.is(KeyWord.DaughtersOfKhaine) && u.is(KeyWord.Aelf),
			null),
	VraiCroyant(
			"Vrai Croyant",
			UnitOption.TraisDeCommandement,
			(a, u) -> u.is(UnitOption.General) && !u.is(KeyWord.Unique)
					&& u.is(KeyWord.DaughtersOfKhaine) && u.is(KeyWord.Aelf),
			null),

	MaitriseDesArcanes(
			"Maîtrise des Arcanes",
			UnitOption.TraisDeCommandement,
			(a, u) -> u.is(UnitOption.General) && !u.is(KeyWord.Unique)
					&& u.is(KeyWord.BloodwrackMedusa),
			null),
	AnneauxOndulants(
			"Anneaux Ondulants",
			UnitOption.TraisDeCommandement,
			(a, u) -> u.is(UnitOption.General) && !u.is(KeyWord.Unique)
					&& u.is(KeyWord.BloodwrackMedusa),
			null),
	PresenceEffrayante(
			"Présence Effrayante",
			UnitOption.TraisDeCommandement,
			(a, u) -> u.is(UnitOption.General) && !u.is(KeyWord.Unique)
					&& u.is(KeyWord.BloodwrackMedusa),
			null),

	VeteranDeLaCathtrarDhule(
			"Vétéran de la Cathtrar Dhule",
			UnitOption.TraisDeCommandement,
			(a, u) -> u.is(UnitOption.General) && !u.is(KeyWord.Unique)
					&& u.is(KeyWord.MelusaiIronscale),
			null),
	EcaillesImpenetrables(
			"Écailles Impénétrables",
			UnitOption.TraisDeCommandement,
			(a, u) -> u.is(UnitOption.General) && !u.is(KeyWord.Unique)
					&& u.is(KeyWord.MelusaiIronscale),
			null),
	AnimeParLaVengeance(
			"Animé par la Vengeance",
			UnitOption.TraisDeCommandement,
			(a, u) -> u.is(UnitOption.General) && !u.is(KeyWord.Unique)
					&& u.is(KeyWord.MelusaiIronscale),
			null),

	DisciplesDevots(
			"Disciples Dévots",
			UnitOption.TraisDeCommandement,
			(a, u) -> u.is(UnitOption.General) && a.is(SubAllegiance.HaggNar),
			null),

	CouronneDeDouleur(
			"Couronne de Douleur",
			UnitOption.Artefact,
			(a, u) -> u.is(KeyWord.Heros) && !u.is(KeyWord.Unique)
					&& u.is(KeyWord.DaughtersOfKhaine),
			null),
	CrocDeShadracar(
			"Croc de Shadracar",
			UnitOption.Artefact,
			(a, u) -> u.is(KeyWord.Heros) && !u.is(KeyWord.Unique)
					&& u.is(KeyWord.DaughtersOfKhaine),
			null),
	AmuletteDeFeuNoir(
			"Amulette de Feu Noir",
			UnitOption.Artefact,
			(a, u) -> u.is(KeyWord.Heros) && !u.is(KeyWord.Unique)
					&& u.is(KeyWord.DaughtersOfKhaine),
			null),
	LameSorciere(
			"Lame Sorcière",
			UnitOption.Artefact,
			(a, u) -> u.is(KeyWord.Heros) && !u.is(KeyWord.Unique)
					&& u.is(KeyWord.DaughtersOfKhaine),
			null),
	MilleEtUneSombresMaledictions(
			"Mille et Une Sombres Malédictions",
			UnitOption.Artefact,
			(a, u) -> u.is(KeyWord.Heros) && !u.is(KeyWord.Unique)
					&& u.is(KeyWord.DaughtersOfKhaine),
			null),
	VeninFleauDuSang(
			"Venin Fléau du Sang",
			UnitOption.Artefact,
			(a, u) -> u.is(KeyWord.Heros) && !u.is(KeyWord.Unique)
					&& u.is(KeyWord.DaughtersOfKhaine),
			null),

	PierreDOmbre(
			"Pierre d'Ombre",
			UnitOption.Artefact,
			(a, u) -> u.is(KeyWord.Heros) && !u.is(KeyWord.Unique)
					&& u.is(KeyWord.BloodwrackMedusa),
			null),
	RuneDUlgu(
			"Rune d'Ulgu",
			UnitOption.Artefact,
			(a, u) -> u.is(KeyWord.Heros) && !u.is(KeyWord.Unique)
					&& u.is(KeyWord.BloodwrackMedusa),
			null),
	LeVougeMiroir(
			"Le Vouge Miroir",
			UnitOption.Artefact,
			(a, u) -> u.is(KeyWord.Heros) && !u.is(KeyWord.Unique)
					&& u.is(KeyWord.BloodwrackMedusa),
			null),
	OmbreSeptFoisDrapee(
			"Ombre Sept-fois-drapée",
			UnitOption.Artefact,
			(a, u) -> u.is(KeyWord.Heros) && !u.is(KeyWord.Unique)
					&& u.is(KeyWord.BloodwrackMedusa),
			null),
	CoeurDeCristal(
			"Cœur de Cristal",
			UnitOption.Artefact,
			(a, u) -> u.is(KeyWord.Heros) && !u.is(KeyWord.Unique)
					&& u.is(KeyWord.BloodwrackMedusa),
			null),
	GriffeDOmbre(
			"Griffe d'Ombre",
			UnitOption.Artefact,
			(a, u) -> u.is(KeyWord.Heros) && !u.is(KeyWord.Unique)
					&& u.is(KeyWord.BloodwrackMedusa),
			null),


	SymboleSanglant(
			"Symbole Sanglant",
			UnitOption.Artefact,
			(a, u) -> u.is(KeyWord.Heros) && !u.is(KeyWord.Unique)
					&& u.is(KeyWord.DaughtersOfKhaine) && u.is(KeyWord.Pretre),
			null),
	DiademeDeFer(
			"Diadème de Fer",
			UnitOption.Artefact,
			(a, u) -> u.is(KeyWord.Heros) && !u.is(KeyWord.Unique)
					&& u.is(KeyWord.DaughtersOfKhaine) && u.is(KeyWord.Pretre),
			null),
	RuneDeKhaine(
			"Rune de Khaine",
			UnitOption.Artefact,
			(a, u) -> u.is(KeyWord.Heros) && !u.is(KeyWord.Unique)
					&& u.is(KeyWord.DaughtersOfKhaine) && u.is(KeyWord.Pretre),
			null),
	EclatPourpre(
			"Éclat Pourpre",
			UnitOption.Artefact,
			(a, u) -> u.is(KeyWord.Heros) && !u.is(KeyWord.Unique)
					&& u.is(KeyWord.DaughtersOfKhaine) && u.is(KeyWord.Pretre),
			null),
	PendentifKhainite(
			"Pendentif Khainite",
			UnitOption.Artefact,
			(a, u) -> u.is(KeyWord.Heros) && !u.is(KeyWord.Unique)
					&& u.is(KeyWord.DaughtersOfKhaine) && u.is(KeyWord.Pretre),
			null),
	BreuvageDeMatriarche(
			"Breuvage de Matriarche",
			UnitOption.Artefact,
			(a, u) -> u.is(KeyWord.Heros) && !u.is(KeyWord.Unique)
					&& u.is(KeyWord.DaughtersOfKhaine) && u.is(KeyWord.Pretre),
			null),

	LUlfuri(
			"L'Ulfuri",
			UnitOption.Artefact,
			(a, u) -> u.is(KeyWord.Heros) && u.is(KeyWord.HaggNar),
			null),
	
	DestrierDOmbres(
			"Destrier d'Ombres",
			UnitOption.Sort,
			(a, u) -> u.is(KeyWord.Heros) && u.is(KeyWord.DaughtersOfKhaine)
					&& u.is(KeyWord.Sorcier),
			null),
	PuitsDeTenebres(
			"Puits de Ténèbres",
			UnitOption.Sort,
			(a, u) -> u.is(KeyWord.Heros) && u.is(KeyWord.DaughtersOfKhaine)
					&& u.is(KeyWord.Sorcier),
			null),
	DanseSymetrique(
			"Danse Symétrique",
			UnitOption.Sort,
			(a, u) -> u.is(KeyWord.Heros) && u.is(KeyWord.DaughtersOfKhaine)
					&& u.is(KeyWord.Sorcier),
			null),
	Affaiblissement(
			"Affaiblissement",
			UnitOption.Sort,
			(a, u) -> u.is(KeyWord.Heros) && u.is(KeyWord.DaughtersOfKhaine)
					&& u.is(KeyWord.Sorcier),
			null),
	RasoirMental(
			"Rasoir Mental",
			UnitOption.Sort,
			(a, u) -> u.is(KeyWord.Heros) && u.is(KeyWord.DaughtersOfKhaine)
					&& u.is(KeyWord.Sorcier),
			null),
	SuaireDeDesespoir(
			"Suaire de Désespoir",
			UnitOption.Sort,
			(a, u) -> u.is(KeyWord.Heros) && u.is(KeyWord.DaughtersOfKhaine)
					&& u.is(KeyWord.Sorcier),
			null),

	CatechismeDuMeurtre(
			"Catéchisme du Meurtre",
			UnitOption.Priere,
			(a, u) -> u.is(KeyWord.Heros) && u.is(KeyWord.DaughtersOfKhaine)
					&& u.is(KeyWord.Pretre),
			null),
	BenedictionDeKhaine(
			"Bénédiction de Khaine",
			UnitOption.Priere,
			(a, u) -> u.is(KeyWord.Heros) && u.is(KeyWord.DaughtersOfKhaine)
					&& u.is(KeyWord.Pretre),
			null),
	SacrificeDuMartyr(
			"Sacrifice du Martyr",
			UnitOption.Priere,
			(a, u) -> u.is(KeyWord.Heros) && u.is(KeyWord.DaughtersOfKhaine)
					&& u.is(KeyWord.Pretre),
			null),
	ResurrectionPourpre(
			"Résurrection Pourpre",
			UnitOption.Priere,
			(a, u) -> u.is(KeyWord.Heros) && u.is(KeyWord.DaughtersOfKhaine)
					&& u.is(KeyWord.Pretre),
			null),
	CouventDuCoeurDeFer(
			"Couvent du Cœur de Fer",
			UnitOption.Priere,
			(a, u) -> u.is(KeyWord.Heros) && u.is(KeyWord.DaughtersOfKhaine)
					&& u.is(KeyWord.Pretre),
			null),
	SacreDeSang(
			"Sacre de Sang",
			UnitOption.Priere,
			(a, u) -> u.is(KeyWord.Heros) && u.is(KeyWord.DaughtersOfKhaine)
					&& u.is(KeyWord.Pretre),
			null),

	Hag("Hag", UnitOption.Chef, (a, u) -> u.is(KeyWord.WitchAelves), null),
	Handmaiden("Handmaiden", UnitOption.Chef, (a, u) -> u.is(KeyWord.SisterOfSlaughter), null),
	PorteEtendard(
			"Porte-Étendard",
			UnitOption.Banniere,
			(a, u) -> u.is(KeyWord.WitchAelves) || u.is(KeyWord.SisterOfSlaughter),
			null),
	SonneuseDeCor(
			"Sonneuse de Cor",
			UnitOption.Musicien,
			(a, u) -> u.is(KeyWord.WitchAelves) || u.is(KeyWord.SisterOfSlaughter),
			null),
	Gorgai("Gorgaï", UnitOption.Chef, (a, u) -> u.is(DokUnitModel.BloodSisters), null),
	Krone("Krone", UnitOption.Chef, (a, u) -> u.is(DokUnitModel.BloodStalkers), u -> {
		u.add(DokRule.Krone);
		u.add(DokUnitWeapon.GuivreDeSang);
	}),

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
	;

	private String displayName;
	private UnitOption option;
	private BiFunction<Army, Unit, Boolean> available;
	private Consumer<Unit> modifier;

	DokOptimisations(String displayName, UnitOption type,
			BiFunction<Army, Unit, Boolean> available,
			Consumer<Unit> modifier) {
		this.displayName = displayName;
		this.option = type;
		this.available = available;
		this.modifier = modifier;
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
