package armybuilder.model.dok;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

import armybuilder.model.army.Listing;
import armybuilder.model.army.rule.GeneriqueRule;
import armybuilder.model.army.rule.IArmyRule;
import armybuilder.model.unit.IUnitModel;
import armybuilder.model.unit.KeyWord;
import armybuilder.model.unit.ProfileDegressif;
import armybuilder.model.unit.RoleTactique;
import armybuilder.model.unit.Unit;
import armybuilder.model.unit.UnitProfile;
import armybuilder.model.unit.modifiers.UnitModifiers;
import armybuilder.model.unit.option.IUnitOptionValue;
import armybuilder.model.unit.option.UnitOption;
import armybuilder.model.unit.rule.GeneriqueUnitRule;
import armybuilder.model.unit.weapon.IUnitWeapon;

public enum DokUnitModel implements IUnitModel {

	MorathiKhaine("Morathi-Khaine",
			340,
			UnitProfile._6_6_8_4,
			Arrays.asList(RoleTactique.Leader),
			Arrays.asList(DokUnitWeapon.EcorcheCoeur, DokUnitWeapon.AilesLamees),
			null,
			Arrays.asList(
					DokRule.Sorcier_3_2_1,
					DokRule.PresenceIntimidante,
					DokRule.DeuxCorpsUneSeuleAme,
					DokRule.VenerationParLeSang,
					DokRule.HorreurNoireDUlgu, 
					// ajouter ces regle sur un rebuild
					GeneriqueRule.TraitMagique,
					GeneriqueRule.BouclierMystique, 
					DokRule.Affaiblissement, 
					DokRule.DanseSymetrique,
					DokRule.DestrierDOmbres, 
					DokRule.PuitsDeTenebres, 
					DokRule.RasoirMental, 
					DokRule.SuaireDeDesespoir),
			Arrays.asList(UnitOption.General, UnitOption.Sort, UnitOption.Bataillon),
			Arrays.asList(KeyWord.Ordre, KeyWord.FilleDeKhaine, KeyWord.Aelf, KeyWord.Heros, KeyWord.Sorcier,
					KeyWord.MorathiKhaine, KeyWord.Unique),
			Arrays.asList()),

	LaReineDeLOmbre("La Reine de l'Ombre",
			340,
			UnitProfile._S_12_10_4,
			Arrays.asList(RoleTactique.Leader, RoleTactique.Behemoth),
			Arrays.asList(DokUnitWeapon.RegardDeLaReineDeLOmbre, DokUnitWeapon.EcorcheCoeur_Shadow, DokUnitWeapon.CouronneDeSerpents, DokUnitWeapon.QueueVenimeuse),
			new ProfileDegressif("Mouvement", DokUnitWeapon.EcorcheCoeur_Shadow.getDisplayName(),DokUnitWeapon.QueueVenimeuse.getDisplayName())
					.add("0-6", "14", "8", "6").add("7-8", "12", "7", "5").add("9-10", "10", "6", "4").add("11+", "8", "5", "3"),
			Arrays.asList(GeneriqueUnitRule.Vol, DokRule.FureurDeLaReineDeLOmbre, DokRule.DeuxCorpsUneSeuleAme_Shadow, DokRule.CoeurDeFerDeKhaine),
			Arrays.asList(UnitOption.Bataillon),
			Arrays.asList(KeyWord.Ordre, KeyWord.FilleDeKhaine, KeyWord.Aelf, KeyWord.Heros, KeyWord.Monstre, KeyWord.LaReineDeLOmbre, KeyWord.Unique),
			Arrays.asList()),

	@Deprecated
	SanctuaireIncarant("TODO Sanctuaire Incarant", 200, UnitProfile._S_13_8_5, Arrays.asList(RoleTactique.Leader),
			// TODO
			Arrays.asList(DokUnitWeapon.RegardIncarnat, DokUnitWeapon.LanceIncarnate, DokUnitWeapon.Aiguillons,
					DokUnitWeapon.GriffeMurmure, DokUnitWeapon.QueueDeSerpents),
			new ProfileDegressif("Mouvement", DokUnitWeapon.Aiguillons.getDisplayName(),
					DokRule.AuraDAgonie.displayName()).add("0-3", "6", "6", "2+")
					.add("4-6", "5", "5", "3+")
					.add("7-10", "4", "4", "4+")
					.add("11+", "3", "3", "5+"),
			Arrays.asList(DokRule.AuraDAgonie, DokRule.ImpactLame, DokRule.RegardIncarnat,
					DokRule.Deperissement, GeneriqueRule.TraitMagique, GeneriqueRule.BouclierMystique,
					GeneriqueUnitRule.Sorcier_1_2),
			Arrays.asList(UnitOption.General, UnitOption.Sort, UnitOption.TraisDeCommandement, UnitOption.Artefact,
					UnitOption.Bataillon),
			Arrays.asList(KeyWord.Ordre, KeyWord.Aelf, KeyWord.FilleDeKhaine, KeyWord.Meduse, KeyWord.Heros,
					KeyWord.Sorcier, KeyWord.Totem, KeyWord.MeduseIncarnate, KeyWord.BloodwrackShrine),
			Arrays.asList()),

	@Deprecated
	MelusaiIronscale("TODO Melusai Ironscale", 115, UnitProfile._8_6_9_5, Arrays.asList(RoleTactique.Leader),
			Arrays.asList(DokUnitWeapon.Keldrisaith_Projectil, DokUnitWeapon.Keldrisaith_Melee), null,
			Arrays.asList(DokRule.SangDeLOracle, DokRule.OffrandeSanguinolente, DokRule.TransmuteEnCristal,
					DokRule.ColereDesMoirenees),
			Arrays.asList(UnitOption.General, UnitOption.TraisDeCommandement, UnitOption.Artefact,
					UnitOption.Bataillon),
			Arrays.asList(KeyWord.Ordre, KeyWord.FilleDeKhaine, KeyWord.Meduse, KeyWord.Heros,
					KeyWord.MelusaiIronscale),
			Arrays.asList()),

	MeduseIncarnate(
			"Méduse Incarnate",
			130,
			UnitProfile._8_6_8_5,
			Arrays.asList(RoleTactique.Leader),
			Arrays.asList(DokUnitWeapon.RegardIncarnat, DokUnitWeapon.LanceIncarnate, DokUnitWeapon.GriffeMurmure,
					DokUnitWeapon.QueueDeSerpents),
			null,
			Arrays.asList(DokRule.RegardIncarnat, DokRule.Deperissement, DokRule.SoeurDesMelusai,
					GeneriqueUnitRule.Sorcier_1_2),
			Arrays.asList(UnitOption.General, UnitOption.TraisDeCommandement, UnitOption.Artefact, UnitOption.Sort,
					UnitOption.Bataillon),
			Arrays.asList(KeyWord.Ordre, KeyWord.FilleDeKhaine, KeyWord.Meduse, KeyWord.Heros, KeyWord.Sorcier,
					KeyWord.MeduseIncarnate),
			Arrays.asList()),

	@Deprecated
	MorgwaethTheBloodied("TODO Morgwaeth the Bloodied", 175, UnitProfile._6_1_7_6, Arrays.asList(RoleTactique.Leader),
			Arrays.asList(DokUnitWeapon.VougeDeKhaine), null,
			Arrays.asList(DokRule.RuneDeKhaine_Priere, DokRule.BrouetDeSang),
			Arrays.asList(UnitOption.General, UnitOption.Priere, UnitOption.TraisDeCommandement, UnitOption.Artefact,
					UnitOption.Bataillon),
			Arrays.asList(KeyWord.Ordre, KeyWord.Aelf, KeyWord.FilleDeKhaine, KeyWord.HaggNar, KeyWord.Heros,
					KeyWord.Pretre, KeyWord.ReineMatriarche, KeyWord.MorgwaethTheBloodied, KeyWord.Unique),
			Arrays.asList()),

	@Deprecated
	LeBladeCoven("TODO Le Blade-Coven", 0, UnitProfile._6_1_7_6, Arrays.asList(RoleTactique.Elite),
			Arrays.asList(DokUnitWeapon.ArcCherchecoeur, DokUnitWeapon.ArmesSacrificielles), null,
			Arrays.asList(DokRule.Cherchecoeurs, DokRule.ZelotesDuPremierTemple), Arrays.asList(UnitOption.Bataillon),
			Arrays.asList(KeyWord.Ordre, KeyWord.Aelf, KeyWord.FilleDeKhaine, KeyWord.Meduse, KeyWord.FilleDeKhaine,
					KeyWord.HaggNar, KeyWord.LaBladeCoven, KeyWord.Unique),
			Arrays.asList()),

	@Deprecated
	HagQueenSurChaudron("TODO Hag Queen sur Cauldron of Blood", 255, UnitProfile._S_13_8_5,
			Arrays.asList(RoleTactique.Leader, RoleTactique.Behemoth),
			Arrays.asList(DokUnitWeapon.TorrentDeSangBrulant, DokUnitWeapon.EpeeDAvatar, DokUnitWeapon.LameDeKhaine,
					DokUnitWeapon.CouteauxSacrificiels_Chaudron),
			new ProfileDegressif("Mouvement", DokUnitWeapon.CouteauxSacrificiels_Chaudron.getDisplayName(),
					DokRule.BouclierDeSang.displayName()).add("0-3", "6\"", "8", "18\"")
					.add("4-6", "5\"", "7", "14\"")
					.add("7-9", "4\"", "6", "10\"")
					.add("10+", "3\"", "5", "6\""),
			Arrays.asList(DokRule.ImpactLame, DokRule.BouclierDeSang, DokRule.ObjetDAdoration,
					DokRule.RuneDeKhaine_Priere, DokRule.CaresseDeLaMort, DokRule.ColereDeKhaine, DokRule.BrouetDeSang),
			Arrays.asList(UnitOption.General, UnitOption.Priere, UnitOption.TraisDeCommandement, UnitOption.Artefact,
					UnitOption.Bataillon),
			Arrays.asList(KeyWord.Ordre, KeyWord.Aelf, KeyWord.FilleDeKhaine, KeyWord.Heros, KeyWord.Pretre,
					KeyWord.Totem, KeyWord.Erinyes, KeyWord.ReineMatriarche, KeyWord.AvatarDeKhaine,
					KeyWord.ChaudronDeSang),
			Arrays.asList()),

	HagQueen("Reine Matriache", 
			110, 
			UnitProfile._6_5_8_5, 
			Arrays.asList(RoleTactique.Leader),
			Arrays.asList(DokUnitWeapon.LameDeKhaine), null,
			Arrays.asList(DokRule.BrouetDeSang, DokRule.CaresseDeLaMort),
			Arrays.asList(UnitOption.General, UnitOption.TraisDeCommandement, UnitOption.Artefact, UnitOption.Priere,
					UnitOption.Bataillon),
			Arrays.asList(KeyWord.Ordre, KeyWord.FilleDeKhaine, KeyWord.Aelf, KeyWord.Heros, KeyWord.Pretre,
					KeyWord.ReineMatriarche),
			Arrays.asList()),

	ReineDuMassacreSurChaudronDeSang(
			"Reine du Massacre sur Chaudron de Sang",
			315,
			UnitProfile._S_13_8_5,
			Arrays.asList(RoleTactique.Leader, RoleTactique.Behemoth),
			Arrays.asList(DokUnitWeapon.TorrentDeSangBrulant, DokUnitWeapon.EpeeDAvatar,
					DokUnitWeapon.EpeeDeMortEtLameDeKhaine, DokUnitWeapon.Sciansa_Chaudron),
			new ProfileDegressif("Mouvement", DokUnitWeapon.Sciansa_Chaudron.getDisplayName(),
					DokRule.BouclierDeSang.displayName()).add("0-6", "6\"", "8", "18\"")
					.add("7-8", "5\"", "7", "15\"")
					.add("9-10", "4\"", "6", "10\"")
					.add("11+", "3\"", "5", "6\""),
			Arrays.asList(DokRule.AutelDeKhaine, DokRule.ImpactLame, DokRule.BouclierDeSang, DokRule.PacteDeSang,
					DokRule.OrgieDeMassacre, DokRule.DanseMaudite),
			Arrays.asList(UnitOption.General, UnitOption.TraisDeCommandement, UnitOption.Artefact, UnitOption.Priere,
					UnitOption.Bataillon),
			Arrays.asList(KeyWord.Ordre, KeyWord.FilleDeKhaine, KeyWord.Aelf, KeyWord.Heros, KeyWord.Pretre,
					KeyWord.Totem, KeyWord.AvatarDeKhaine, KeyWord.ChaudronDeSang, KeyWord.ReineDuMassacre),
			Arrays.asList()),

	@Deprecated
	SlaughterQueen("TODO Slaughter Queen", 110, UnitProfile._6_5_8_5, Arrays.asList(RoleTactique.Leader),
			Arrays.asList(DokUnitWeapon.EpeeDeMortEtLameDeKhaine, DokUnitWeapon.LameDeKhaine), null,
			Arrays.asList(DokRule.DanseDAgonie, DokRule.RuneDeKhaine_Priere, DokRule.CaresseDeLaMort,
					DokRule.OrgieDeMassacre),
			Arrays.asList(UnitOption.General, UnitOption.Artefact, UnitOption.Priere, UnitOption.TraisDeCommandement,
					UnitOption.Bataillon),
			Arrays.asList(KeyWord.Ordre, KeyWord.Aelf, KeyWord.FilleDeKhaine, KeyWord.Heros, KeyWord.Pretre,
					KeyWord.ReineDuMassacre),
			Arrays.asList()),

	GrandeGladiatrice("Grande Gladiatrice", 90, UnitProfile._8_6_8_5, Arrays.asList(RoleTactique.Leader),
			Arrays.asList(DokUnitWeapon.FouetBarbeleGr, DokUnitWeapon.LameDeGladiatrice),
			null, Arrays.asList(
					DokRule.DanseDeLaMort, DokRule.CoupDeGrace,
					DokRule.ParangonDuMassacre),
			Arrays.asList(UnitOption.General, UnitOption.TraisDeCommandement, UnitOption.Artefact, UnitOption.Priere,
					UnitOption.Bataillon),
			Arrays.asList(KeyWord.Ordre, KeyWord.FilleDeKhaine, KeyWord.Aelf, KeyWord.Heros, KeyWord.GrandeGladiatrice),
			Arrays.asList()),

	SoeurDuMassacre(
			"Sœurs du Massacre",
			135,
			UnitProfile._6_1_7_6,
			Arrays.asList(RoleTactique.Ligne),
			Arrays.asList(DokUnitWeapon.FouetBarbele),
			null,
			Arrays.asList(DokRule.DanseDeLaMort),
			Arrays.asList(UnitOption.Chef, UnitOption.Banniere, UnitOption.Musicien, UnitOption.Armes,
					UnitOption.Renforcees, UnitOption.Bataillon),
			Arrays.asList(KeyWord.Ordre, KeyWord.FilleDeKhaine, KeyWord.Aelf, KeyWord.SoeurDuMassacre),
			Arrays.asList()),

	Erinyes("Érinyes",
			115,
			UnitProfile._6_1_7_6,
			Arrays.asList(RoleTactique.Ligne),
			Arrays.asList(),
			null,
			Arrays.asList(DokRule.FerveurFrenetique),
			Arrays.asList(UnitOption.Chef, UnitOption.Banniere, UnitOption.Musicien, UnitOption.Armes,
					UnitOption.Renforcees, UnitOption.Bataillon),
			Arrays.asList(KeyWord.Ordre, KeyWord.FilleDeKhaine, KeyWord.Aelf, KeyWord.Erinyes),
			Arrays.asList()),


	@Deprecated
	KhainiteShadowstalkers(
			"TODO Khainite Shadowstalkers",
			120,
			UnitProfile._6_1_7_5,
			Arrays.asList(RoleTactique.Elite),
			Arrays.asList(DokUnitWeapon.ProjectilesMaudits, DokUnitWeapon.LameDAssassin),
			null,
			Arrays.asList(DokRule.BondDeLOmbre, DokRule.ProjectilesMaudits, DokRule.ProfiterDeLOmbre),
			Arrays.asList(UnitOption.Chef, UnitOption.Renforcees, UnitOption.Bataillon),
			Arrays.asList(KeyWord.Ordre, KeyWord.Aelf, KeyWord.FilleDeKhaine, KeyWord.KhainiteShadowstalkers),
			Arrays.asList()),

	@Deprecated
	ConjurateursDuFeuMaudit(
			"TODO Conjurateurs du Feu Maudit",
			0,
			UnitProfile.None,
			Arrays.asList(),
			null,
			null,
			null,
			null,
			null,
			null),

	AvatarDeKhaine(
			"Avatar de Khaine",
			155,
			UnitProfile._9_9_10_4,
			Arrays.asList(RoleTactique.Behemoth),
			Arrays.asList(DokUnitWeapon.TorrentDeSangBrulant, DokUnitWeapon.EpeeDAvatar),
			null,
			Arrays.asList(DokRule.AutelDeKhaine, DokRule.AnimuseDeSorcellerieEtDeSacrifice, DokRule.ColereDeKhaine,
					GeneriqueRule.Ecroulement, GeneriqueRule.Pietinement),
			Arrays.asList(UnitOption.Bataillon),
			Arrays.asList(KeyWord.Ordre, KeyWord.FilleDeKhaine, KeyWord.Totem, KeyWord.AvatarDeKhaine),
			Arrays.asList()),

	@Deprecated
	BloodStalkers(
			"TODO Blood Stalkers",
			180,
			UnitProfile._8_2_8_5,
			Arrays.asList(RoleTactique.Elite),
			Arrays.asList(DokUnitWeapon.ArcCherchecoeur, DokUnitWeapon.Scianlar),
			null,
			Arrays.asList(DokRule.Cherchecoeurs),
			Arrays.asList(UnitOption.Chef, UnitOption.Renforcees, UnitOption.Bataillon),
			Arrays.asList(KeyWord.Ordre, KeyWord.FilleDeKhaine, KeyWord.Meduse, KeyWord.BloodStalkers),
			Arrays.asList(UnitModifiers.roleIfGeneral(KeyWord.MeduseIncarnate, RoleTactique.Ligne),
					UnitModifiers.roleIfGeneral(KeyWord.MelusaiIronscale, RoleTactique.Ligne))),

	@Deprecated
	BloodSisters(
			"TODO Blood Sisters",
			140,
			UnitProfile._8_2_8_5,
			Arrays.asList(RoleTactique.Elite),
			Arrays.asList(DokUnitWeapon.VougeBrisecoeur),
			null,
			Arrays.asList(DokRule.TransmuteEnCristal),
			Arrays.asList(UnitOption.Chef, UnitOption.Renforcees, UnitOption.Bataillon),
			Arrays.asList(KeyWord.Ordre, KeyWord.FilleDeKhaine, KeyWord.Meduse, KeyWord.BloodSister),
			Arrays.asList(UnitModifiers.roleIfGeneral(KeyWord.MeduseIncarnate, RoleTactique.Ligne),
					UnitModifiers.roleIfGeneral(KeyWord.MelusaiIronscale, RoleTactique.Ligne))),

	EtripeusesKhinerai(
			"Étripeuses Khineraĩ",
			95,
			UnitProfile._14_1_7_5,
			Arrays.asList(RoleTactique.Elite),
			Arrays.asList(DokUnitWeapon.JavelineBarbelee_P, DokUnitWeapon.JavelineBarbelee_M),
			null,
			Arrays.asList(GeneriqueUnitRule.Vol, DokRule.PlongeonDansLaBataille, DokRule.VoleeEtVolteFace),
			Arrays.asList(UnitOption.Chef, UnitOption.Renforcees, UnitOption.Bataillon),
			Arrays.asList(KeyWord.Ordre, KeyWord.FilleDeKhaine, KeyWord.Moirenees, KeyWord.Khinerai,
					KeyWord.EtripeusesKhinerai),
			Arrays.asList()),


	@Deprecated
	EgorgeusesKhinerai(
			"TODO Egorgeuses Khinerai",
			0,
			UnitProfile.None,
			Arrays.asList(),
			null,
			null,
			null,
			null,
			null,
			null),

	@Deprecated
	BloodwrackViper(
			"TODO Bloodwrack Viper",
			95,
			UnitProfile.None,
			Arrays.asList(RoleTactique.SortsPersistantsEtInvocation),
			Arrays.asList(),
			null,
			Arrays.asList(GeneriqueUnitRule.Vol, DokRule.BloodWrackViperConv, GeneriqueUnitRule.Predateur_9,
					DokRule.AttaqueDeCrochets),
			Arrays.asList(),
			Arrays.asList(),
			Arrays.asList()),

	@Deprecated
	Bladewind(
			"TODO Bladewind",
			80,
			UnitProfile.None,
			Arrays.asList(RoleTactique.SortsPersistantsEtInvocation),
			Arrays.asList(),
			null,
			Arrays.asList(GeneriqueUnitRule.Vol, DokRule.BladewindConv, GeneriqueUnitRule.Predateur_12,
					DokRule.TranchantSurnaturel),
			Arrays.asList(),
			Arrays.asList(),
			Arrays.asList()),

	CoeurDeFureur(
			"Cœur de Fureur",
			45,
			UnitProfile.None,
			Arrays.asList(RoleTactique.SortsPersistantsEtInvocation),
			Arrays.asList(),
			null,
			Arrays.asList(DokRule.CoeurDeFureurConv, DokRule.ReceptacleDuDieuMeurtre),
			Arrays.asList(),
			Arrays.asList(),
			Arrays.asList()),


	;

	private String displayName;
	private int value;
	private UnitProfile profile;
	private List<IUnitWeapon> weapons;
	private ProfileDegressif profileDegressif;
	private List<IArmyRule<?>> rules;
	private List<KeyWord> keyWords;
	private List<RoleTactique> roleTactiques;
	private List<UnitOption> options;
	private List<Consumer<Unit>> modifiers;

	private DokUnitModel(String displayName, int value, UnitProfile profile, List<RoleTactique> roleTactiques,
			List<IUnitWeapon> weapons, ProfileDegressif profileDegressif, List<IArmyRule<?>> rules,
			List<UnitOption> options, List<KeyWord> keyWords, List<Consumer<Unit>> modifiers) {
		this.displayName = displayName;
		this.value = value;
		this.profile = profile;
		this.roleTactiques = roleTactiques;
		this.weapons = weapons;
		this.profileDegressif = profileDegressif;
		this.rules = rules;
		this.options = options;
		this.keyWords = keyWords;
		this.modifiers = modifiers;
	}

	@Override
	public String displayName() {
		return displayName;
	}

	@Override
	public UnitProfile profile() {
		return profile;
	}

	@Override
	public List<IUnitWeapon> weapons() {
		return weapons;
	}

	@Override
	public ProfileDegressif profileDegressif() {
		return profileDegressif;
	}

	@Override
	public List<IArmyRule<?>> rules() {
		return rules;
	}

	@Override
	public List<KeyWord> keyWords() {
		return keyWords;
	}

	@Override
	public List<RoleTactique> roleTactiques() {
		return roleTactiques;
	}

	@Override
	public List<UnitOption> options() {
		return options;
	}

	@Override
	public List<IUnitOptionValue<?>> optionValues() {
		return Arrays.asList(DokOptimisations.values());
	}

	@Override
	public int points() {
		return value;
	}

	@Override
	public void rebuild(Unit unit) {
		modifiers.stream().forEach(m -> m.accept(unit));
	}

	@Override
	public boolean availableFor(Listing listing) {
		boolean available = true;
		if (keyWords != null && keyWords.contains(KeyWord.Unique)) {
			available = !listing.have(this);
		}
		return available;
	}

}
