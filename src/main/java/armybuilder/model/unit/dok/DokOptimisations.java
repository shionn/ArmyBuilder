package armybuilder.model.unit.dok;

import java.util.function.BiFunction;
import java.util.function.Consumer;

import armybuilder.model.Army;
import armybuilder.model.rule.DokRule;
import armybuilder.model.unit.KeyWord;
import armybuilder.model.unit.Unit;
import armybuilder.model.unit.option.IUnitOptionValue;
import armybuilder.model.unit.option.UnitOption;

public enum DokOptimisations implements IUnitOptionValue<DokOptimisations> {

	BainDeSang(
			"Bain de Sang",
			UnitOption.TraisDeCommandement,
			u -> u.addRule(DokRule.BainDeSang),
			(a, u) -> u.is(UnitOption.General) && !u.is(KeyWord.Unique)
					&& u.is(KeyWord.DaughtersOfKhaine) && u.is(KeyWord.Aelf)),
	OrateurZele(
			"Orateur Zélé",
			UnitOption.TraisDeCommandement,
			null, (a, u) -> u.is(UnitOption.General) && !u.is(KeyWord.Unique)
					&& u.is(KeyWord.DaughtersOfKhaine) && u.is(KeyWord.Aelf)),
	SacrificateurSanglant(
			"Sacrificateur Sanglant",
			UnitOption.TraisDeCommandement,
			null, (a, u) -> u.is(UnitOption.General) && !u.is(KeyWord.Unique)
					&& u.is(KeyWord.DaughtersOfKhaine) && u.is(KeyWord.Aelf)),
	BeauteTerrifiante(
			"Beauté Terrifiante",
			UnitOption.TraisDeCommandement,
			null, (a, u) -> u.is(UnitOption.General) && !u.is(KeyWord.Unique)
					&& u.is(KeyWord.DaughtersOfKhaine) && u.is(KeyWord.Aelf)),
	MaitreDesPoisons(
			"Maître des Poisons",
			UnitOption.TraisDeCommandement,
			null, (a, u) -> u.is(UnitOption.General) && !u.is(KeyWord.Unique)
					&& u.is(KeyWord.DaughtersOfKhaine) && u.is(KeyWord.Aelf)),
	VraiCroyant(
			"Vrai Croyant",
			UnitOption.TraisDeCommandement,
			null, (a, u) -> u.is(UnitOption.General) && !u.is(KeyWord.Unique)
					&& u.is(KeyWord.DaughtersOfKhaine) && u.is(KeyWord.Aelf)),

	MaitriseDesArcanes(
			"Maîtrise des Arcanes",
			UnitOption.TraisDeCommandement,
			null, (a, u) -> u.is(UnitOption.General) && !u.is(KeyWord.Unique)
					&& u.is(KeyWord.BloodwrackMedusa)),
	AnneauxOndulants(
			"Anneaux Ondulants",
			UnitOption.TraisDeCommandement,
			null, (a, u) -> u.is(UnitOption.General) && !u.is(KeyWord.Unique)
					&& u.is(KeyWord.BloodwrackMedusa)),
	PresenceEffrayante(
			"Présence Effrayante",
			UnitOption.TraisDeCommandement,
			null, (a, u) -> u.is(UnitOption.General) && !u.is(KeyWord.Unique)
					&& u.is(KeyWord.BloodwrackMedusa)),

	VeteranDeLaCathtrarDhule(
			"Vétéran de la Cathtrar Dhule",
			UnitOption.TraisDeCommandement,
			null, (a, u) -> u.is(UnitOption.General) && !u.is(KeyWord.Unique)
					&& u.is(KeyWord.MelusaiIronscale)),
	EcaillesImpenetrables(
			"Écailles Impénétrables",
			UnitOption.TraisDeCommandement,
			null, (a, u) -> u.is(UnitOption.General) && !u.is(KeyWord.Unique)
					&& u.is(KeyWord.MelusaiIronscale)),
	AnimeParLaVengeance(
			"Animé par la Vengeance",
			UnitOption.TraisDeCommandement,
			null, (a, u) -> u.is(UnitOption.General) && !u.is(KeyWord.Unique)
					&& u.is(KeyWord.MelusaiIronscale)),

	CouronneDeDouleur(
			"Couronne de Douleur",
			UnitOption.Artefact,
			null, (a, u) -> u.is(KeyWord.Heros) && !u.is(KeyWord.Unique)
					&& u.is(KeyWord.DaughtersOfKhaine)),
	CrocDeShadracar(
			"Croc de Shadracar",
			UnitOption.Artefact,
			null, (a, u) -> u.is(KeyWord.Heros) && !u.is(KeyWord.Unique)
					&& u.is(KeyWord.DaughtersOfKhaine)),
	AmuletteDeFeuNoir(
			"Amulette de Feu Noir",
			UnitOption.Artefact,
			null, (a, u) -> u.is(KeyWord.Heros) && !u.is(KeyWord.Unique)
					&& u.is(KeyWord.DaughtersOfKhaine)),
	LameSorciere(
			"Lame Sorcière",
			UnitOption.Artefact,
			null, (a, u) -> u.is(KeyWord.Heros) && !u.is(KeyWord.Unique)
					&& u.is(KeyWord.DaughtersOfKhaine)),
	MilleEtUneSombresMaledictions(
			"Mille et Une Sombres Malédictions",
			UnitOption.Artefact,
			null, (a, u) -> u.is(KeyWord.Heros) && !u.is(KeyWord.Unique)
					&& u.is(KeyWord.DaughtersOfKhaine)),
	VeninFleauDuSang(
			"Venin Fléau du Sang",
			UnitOption.Artefact,
			null, (a, u) -> u.is(KeyWord.Heros) && !u.is(KeyWord.Unique)
					&& u.is(KeyWord.DaughtersOfKhaine)),

	PierreDOmbre(
			"Pierre d'Ombre",
			UnitOption.Artefact,
			null, (a, u) -> u.is(KeyWord.Heros) && !u.is(KeyWord.Unique)
					&& u.is(KeyWord.BloodwrackMedusa)),
	RuneDUlgu(
			"Rune d'Ulgu",
			UnitOption.Artefact,
			null, (a, u) -> u.is(KeyWord.Heros) && !u.is(KeyWord.Unique)
					&& u.is(KeyWord.BloodwrackMedusa)),
	LeVougeMiroir(
			"Le Vouge Miroir",
			UnitOption.Artefact,
			null, (a, u) -> u.is(KeyWord.Heros) && !u.is(KeyWord.Unique)
					&& u.is(KeyWord.BloodwrackMedusa)),
	OmbreSeptFoisDrapee(
			"Ombre Sept-fois-drapée",
			UnitOption.Artefact,
			null, (a, u) -> u.is(KeyWord.Heros) && !u.is(KeyWord.Unique)
					&& u.is(KeyWord.BloodwrackMedusa)),
	CoeurDeCristal(
			"Cœur de Cristal",
			UnitOption.Artefact,
			null, (a, u) -> u.is(KeyWord.Heros) && !u.is(KeyWord.Unique)
					&& u.is(KeyWord.BloodwrackMedusa)),
	GriffeDOmbre(
			"Griffe d'Ombre",
			UnitOption.Artefact,
			null, (a, u) -> u.is(KeyWord.Heros) && !u.is(KeyWord.Unique)
					&& u.is(KeyWord.BloodwrackMedusa)),


	SymboleSanglant(
			"Symbole Sanglant",
			UnitOption.Artefact,
			null, (a, u) -> u.is(KeyWord.Heros) && !u.is(KeyWord.Unique)
					&& u.is(KeyWord.DaughtersOfKhaine) && u.is(KeyWord.Pretre)),
	DiademeDeFer(
			"Diadème de Fer",
			UnitOption.Artefact,
			null, (a, u) -> u.is(KeyWord.Heros) && !u.is(KeyWord.Unique)
					&& u.is(KeyWord.DaughtersOfKhaine) && u.is(KeyWord.Pretre)),
	RuneDeKhaine(
			"Rune de Khaine",
			UnitOption.Artefact,
			null, (a, u) -> u.is(KeyWord.Heros) && !u.is(KeyWord.Unique)
					&& u.is(KeyWord.DaughtersOfKhaine) && u.is(KeyWord.Pretre)),
	EclatPourpre(
			"Éclat Pourpre",
			UnitOption.Artefact,
			null, (a, u) -> u.is(KeyWord.Heros) && !u.is(KeyWord.Unique)
					&& u.is(KeyWord.DaughtersOfKhaine) && u.is(KeyWord.Pretre)),
	PendentifKhainite(
			"Pendentif Khainite",
			UnitOption.Artefact,
			null, (a, u) -> u.is(KeyWord.Heros) && !u.is(KeyWord.Unique)
					&& u.is(KeyWord.DaughtersOfKhaine) && u.is(KeyWord.Pretre)),
	BreuvageDeMatriarche(
			"Breuvage de Matriarche",
			UnitOption.Artefact,
			null, (a, u) -> u.is(KeyWord.Heros) && !u.is(KeyWord.Unique)
					&& u.is(KeyWord.DaughtersOfKhaine) && u.is(KeyWord.Pretre)),

	DestrierDOmbres(
			"Destrier d'Ombres",
			UnitOption.Sort,
			null, (a, u) -> u.is(KeyWord.Heros) && u.is(KeyWord.DaughtersOfKhaine)
					&& u.is(KeyWord.Sorcier)),
	PuitsDeTenebres(
			"Puits de Ténèbres",
			UnitOption.Sort,
			null, (a, u) -> u.is(KeyWord.Heros) && u.is(KeyWord.DaughtersOfKhaine)
					&& u.is(KeyWord.Sorcier)),
	DanseSymetrique(
			"Danse Symétrique",
			UnitOption.Sort,
			null, (a, u) -> u.is(KeyWord.Heros) && u.is(KeyWord.DaughtersOfKhaine)
					&& u.is(KeyWord.Sorcier)),
	Affaiblissement(
			"Affaiblissement",
			UnitOption.Sort,
			null, (a, u) -> u.is(KeyWord.Heros) && u.is(KeyWord.DaughtersOfKhaine)
					&& u.is(KeyWord.Sorcier)),
	RasoirMental(
			"Rasoir Mental",
			UnitOption.Sort,
			null, (a, u) -> u.is(KeyWord.Heros) && u.is(KeyWord.DaughtersOfKhaine)
					&& u.is(KeyWord.Sorcier)),
	SuaireDeDesespoir(
			"Suaire de Désespoir",
			UnitOption.Sort,
			null, (a, u) -> u.is(KeyWord.Heros) && u.is(KeyWord.DaughtersOfKhaine)
					&& u.is(KeyWord.Sorcier)),

	CatechismeDuMeurtre(
			"Catéchisme du Meurtre",
			UnitOption.Priere,
			null, (a, u) -> u.is(KeyWord.Heros) && u.is(KeyWord.DaughtersOfKhaine)
					&& u.is(KeyWord.Pretre)),
	BenedictionDeKhaine(
			"Bénédiction de Khaine",
			UnitOption.Priere,
			null, (a, u) -> u.is(KeyWord.Heros) && u.is(KeyWord.DaughtersOfKhaine)
					&& u.is(KeyWord.Pretre)),
	SacrificeDuMartyr(
			"Sacrifice du Martyr",
			UnitOption.Priere,
			null, (a, u) -> u.is(KeyWord.Heros) && u.is(KeyWord.DaughtersOfKhaine)
					&& u.is(KeyWord.Pretre)),
	ResurrectionPourpre(
			"Résurrection Pourpre",
			UnitOption.Priere,
			null, (a, u) -> u.is(KeyWord.Heros) && u.is(KeyWord.DaughtersOfKhaine)
					&& u.is(KeyWord.Pretre)),
	CouventDuCoeurDeFer(
			"Couvent du Cœur de Fer",
			UnitOption.Priere,
			null, (a, u) -> u.is(KeyWord.Heros) && u.is(KeyWord.DaughtersOfKhaine)
					&& u.is(KeyWord.Pretre)),
	SacreDeSang(
			"Sacre de Sang",
			UnitOption.Priere,
			null, (a, u) -> u.is(KeyWord.Heros) && u.is(KeyWord.DaughtersOfKhaine)
					&& u.is(KeyWord.Pretre)),

	;

	private String displayName;
	private UnitOption option;
	private BiFunction<Army, Unit, Boolean> available;
	private Consumer<Unit> modifier;

	DokOptimisations(String displayName, UnitOption type,
			Consumer<Unit> modifier, BiFunction<Army, Unit, Boolean> available) {
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
		unit.addRule(DokRule.valueOf(name()));
	}

}
