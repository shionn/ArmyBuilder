package armybuilder.model.dok;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiConsumer;

import armybuilder.model.army.Army;
import armybuilder.model.army.rule.GeneriqueRule;
import armybuilder.model.army.rule.IArmyRule;
import armybuilder.model.unit.IUnitModel;
import armybuilder.model.unit.KeyWord;
import armybuilder.model.unit.ProfileDegressif;
import armybuilder.model.unit.RoleTactique;
import armybuilder.model.unit.Unit;
import armybuilder.model.unit.UnitProfile;
import armybuilder.model.unit.check.UnitCheckers;
import armybuilder.model.unit.modifiers.UnitModifiers;
import armybuilder.model.unit.option.IUnitOptionValue;
import armybuilder.model.unit.option.UnitOption;
import armybuilder.model.unit.rule.GeneriqueUnitRule;
import armybuilder.model.unit.weapon.IUnitWeapon;

public enum DokUnitModel implements IUnitModel {

	MorathiKhaine(
			"Morathi-Khaine",
			330,
			UnitProfile._6_6_8_4,
			Arrays.asList(RoleTactique.Leader),
			Arrays.asList(DokUnitWeapon.EcorcheCoeur, DokUnitWeapon.AilesLamees),
			null,
			Arrays.asList(DokRule.DeuxCorpsUneSeuleAme, DokRule.PresenceIntimidante,
					GeneriqueRule.TraitMagique, GeneriqueRule.BouclierMystique,
					DokRule.HorreurNoireDUlgu, DokRule.VenerationParLeSang,
					GeneriqueUnitRule.Sorcier_3_2_1),
			Arrays.asList(UnitOption.General, UnitOption.Sort, UnitOption.Bataillon),
			Arrays.asList(KeyWord.Ordre, KeyWord.Aelf, KeyWord.DaughtersOfKhaine, KeyWord.Heros,
					KeyWord.Sorcier, KeyWord.MorathiKhaine, KeyWord.Unique),
			Arrays.asList(),
			Arrays.asList(UnitCheckers.mustBeTakeWith(KeyWord.LaShadowQueen))),
	LaShadowQueen(
			"La Shadow Queen",
			330,
			UnitProfile._S_12_10_4,
			Arrays.asList(RoleTactique.Leader, RoleTactique.Behemoth),
			Arrays.asList(DokUnitWeapon.RegardDeLaReineDeLOmbre, DokUnitWeapon.EcorcheCoeur_Shadow,
					DokUnitWeapon.CouronneDeSerpents, DokUnitWeapon.QueueVenimeuse),
			new ProfileDegressif("Mouvement", DokUnitWeapon.EcorcheCoeur_Shadow.getDisplayName(),
					DokUnitWeapon.QueueVenimeuse.getDisplayName()).add("0-3", "14", "8", "6")
							.add("4-6", "12", "7", "5").add("7-8", "10", "6", "4")
							.add("9-10", "8", "5", "3").add("11+", "6", "4", "2"),
			Arrays.asList(GeneriqueUnitRule.Vol, DokRule.FureurDeLaReineDeLOmbre,
					DokRule.DeuxCorpsUneSeuleAme_Shadow, DokRule.CoeurDeFerDeKhaine),
			Arrays.asList(UnitOption.Bataillon),
			Arrays.asList(KeyWord.Ordre, KeyWord.Aelf, KeyWord.DaughtersOfKhaine, KeyWord.Monstre,
					KeyWord.Heros, KeyWord.LaShadowQueen, KeyWord.Unique),
			Arrays.asList(),
			Arrays.asList(UnitCheckers.mustBeTakeWith(KeyWord.MorathiKhaine))),

	BloodwrackShrine(
			"Bloodwrack Shrine",
			190,
			UnitProfile._S_13_8_5,
			Arrays.asList(RoleTactique.Leader, RoleTactique.Behemoth),
			Arrays.asList(DokUnitWeapon.RegardIncarnat, DokUnitWeapon.LanceIncarnate,
					DokUnitWeapon.Aiguillons, DokUnitWeapon.GriffeMurmure,
					DokUnitWeapon.QueueDeSerpents),
			new ProfileDegressif("Mouvement", DokUnitWeapon.Aiguillons.getDisplayName(),
					DokRule.AuraDAgonie.getDisplayName()).add("0-3", "6", "6", "2+")
							.add("4-6", "5", "5", "3+").add("7-10", "4", "4", "4+")
							.add("11+", "3", "3", "5+"),
			Arrays.asList(DokRule.AuraDAgonie, DokRule.ImpactLame, DokRule.RegardIncarnat,
					DokRule.GriffeMurmure, DokRule.Deperissement, GeneriqueRule.TraitMagique,
					GeneriqueRule.BouclierMystique, GeneriqueUnitRule.Sorcier_1_2),
			Arrays.asList(UnitOption.General, UnitOption.Sort, UnitOption.TraisDeCommandement,
					UnitOption.Artefact, UnitOption.Bataillon),
			Arrays.asList(KeyWord.Ordre, KeyWord.Aelf, KeyWord.DaughtersOfKhaine, KeyWord.Melusai,
					KeyWord.Heros, KeyWord.Sorcier, KeyWord.Totem, KeyWord.BloodwrackMedusa,
					KeyWord.BloodwrackShrine),
			Arrays.asList(),
			Arrays.asList()),

	BloodwrackMedusa(
			"Bloodwrack Medusa",
			120,
			UnitProfile._8_6_8_5,
			Arrays.asList(RoleTactique.Leader),
			Arrays.asList(DokUnitWeapon.RegardIncarnat, DokUnitWeapon.LanceIncarnate,
					DokUnitWeapon.GriffeMurmure, DokUnitWeapon.QueueDeSerpents),
			null,
			Arrays.asList(DokRule.RegardIncarnat, DokRule.GriffeMurmure, DokRule.Deperissement,
					GeneriqueRule.TraitMagique, GeneriqueRule.BouclierMystique,
					GeneriqueUnitRule.Sorcier_1_2),
			Arrays.asList(UnitOption.General, UnitOption.Sort, UnitOption.TraisDeCommandement,
					UnitOption.Artefact, UnitOption.Bataillon),
			Arrays.asList(KeyWord.Ordre, KeyWord.DaughtersOfKhaine, KeyWord.Melusai, KeyWord.Heros,
					KeyWord.Sorcier, KeyWord.BloodwrackMedusa),
			Arrays.asList(),
			Arrays.asList()),

	MelusaiIronscale(
			"Melusai Ironscale",
			115,
			UnitProfile._8_6_9_5,
			Arrays.asList(RoleTactique.Leader),
			Arrays.asList(DokUnitWeapon.Keldrisaith_Projectil, DokUnitWeapon.Keldrisaith_Melee),
			null,
			Arrays.asList(DokRule.SangDeLOracle, DokRule.OffrandeSanguinolente,
					DokRule.TransmuteEnCristal, DokRule.ColereDesMoirenees),
			Arrays.asList(UnitOption.General, UnitOption.TraisDeCommandement, UnitOption.Artefact,
					UnitOption.Bataillon),
			Arrays.asList(KeyWord.Ordre, KeyWord.DaughtersOfKhaine, KeyWord.Melusai, KeyWord.Heros,
					KeyWord.MelusaiIronscale),
			Arrays.asList(),
			Arrays.asList()),

	MorgwaethTheBloodied(
			"Morgwaeth the Bloodied",
			175,
			UnitProfile._6_1_7_6,
			Arrays.asList(RoleTactique.Leader),
			Arrays.asList(DokUnitWeapon.VougeDeKhaine),
			null,
			Arrays.asList(DokRule.RuneDeKhaine_Priere, DokRule.BrouetDeSang),
			Arrays.asList(UnitOption.General, UnitOption.Priere, UnitOption.TraisDeCommandement,
					UnitOption.Artefact, UnitOption.Bataillon),
			Arrays.asList(KeyWord.Ordre, KeyWord.Aelf, KeyWord.DaughtersOfKhaine, KeyWord.HaggNar,
					KeyWord.Heros, KeyWord.Pretre, KeyWord.HagQueen, KeyWord.MorgwaethTheBloodied,
					KeyWord.Unique),
			Arrays.asList(),
			Arrays.asList(UnitCheckers.mustBeTakeWith(KeyWord.LaBladeCoven))),

	LeBladeCoven(
			"Le Blade-Coven",
			0,
			UnitProfile._6_1_7_6,
			Arrays.asList(RoleTactique.Elite),
			Arrays.asList(DokUnitWeapon.ArcCherchecoeur, DokUnitWeapon.ArmesSacrificielles),
			null,
			Arrays.asList(DokRule.Cherchecoeurs, DokRule.ZelotesDuPremierTemple),
			Arrays.asList(UnitOption.Bataillon),
			Arrays.asList(KeyWord.Ordre, KeyWord.Aelf, KeyWord.DaughtersOfKhaine, KeyWord.Melusai,
					KeyWord.DaughtersOfKhaine, KeyWord.HaggNar, KeyWord.LaBladeCoven,
					KeyWord.Unique),
			Arrays.asList(),
			Arrays.asList(UnitCheckers.mustBeTakeWith(KeyWord.MorgwaethTheBloodied))),

	HagQueenSurChaudron(
			"Hag Queen sur Cauldron of Blood",
			255,
			UnitProfile._S_13_8_5,
			Arrays.asList(RoleTactique.Leader, RoleTactique.Behemoth),
			Arrays.asList(DokUnitWeapon.TorrentdeSangBrulant, DokUnitWeapon.EpeeDAvatar,
					DokUnitWeapon.LameDeKhaine, DokUnitWeapon.CouteauxSacrificiels_Chaudron),
			new ProfileDegressif("Mouvement",
					DokUnitWeapon.CouteauxSacrificiels_Chaudron.getDisplayName(),
					DokRule.BouclierDeSang.getDisplayName()).add("0-3", "6\"", "8", "18\"")
							.add("4-6", "5\"", "7", "14\"").add("7-9", "4\"", "6", "10\"")
							.add("10+", "3\"", "5", "6\""),
			Arrays.asList(DokRule.ImpactLame, DokRule.BouclierDeSang, DokRule.ObjetDAdoration,
					DokRule.RuneDeKhaine_Priere, DokRule.CaresseDeLaMort, DokRule.ColereDeKhaine,
					DokRule.BrouetDeSang),
			Arrays.asList(UnitOption.General, UnitOption.Priere, UnitOption.PriereBonus,
					UnitOption.TraisDeCommandement, UnitOption.Artefact, UnitOption.Bataillon),
			Arrays.asList(KeyWord.Ordre, KeyWord.Aelf, KeyWord.DaughtersOfKhaine, KeyWord.Heros,
					KeyWord.Pretre, KeyWord.Totem, KeyWord.WitchAelves, KeyWord.HagQueen,
					KeyWord.AvatarOfKhaine, KeyWord.CauldronOfBlood),
			Arrays.asList(),
			Arrays.asList()),

	HagQueen(
			"Hag Queen",
			105,
			UnitProfile._6_5_8_5,
			Arrays.asList(RoleTactique.Leader),
			Arrays.asList(DokUnitWeapon.LameDeKhaine),
			null,
			Arrays.asList(DokRule.RuneDeKhaine_Priere, DokRule.CaresseDeLaMort,
					DokRule.BrouetDeSang),
			Arrays.asList(UnitOption.General, UnitOption.Priere, UnitOption.TraisDeCommandement,
					UnitOption.Artefact, UnitOption.Bataillon),
			Arrays.asList(KeyWord.Ordre, KeyWord.Aelf, KeyWord.DaughtersOfKhaine, KeyWord.Heros,
					KeyWord.Pretre, KeyWord.HagQueen),
			Arrays.asList(),
			Arrays.asList()),

	SlaughterQueen(
			"Slaughter Queen",
			120,
			UnitProfile._6_5_8_5,
			Arrays.asList(RoleTactique.Leader),
			Arrays.asList(DokUnitWeapon.EpeeDeMort, DokUnitWeapon.LameDeKhaine),
			null,
			Arrays.asList(DokRule.DanseDAgonie, DokRule.RuneDeKhaine_Priere,
					DokRule.CaresseDeLaMort, DokRule.OrgieDeMassacre),
			Arrays.asList(UnitOption.General, UnitOption.Priere, UnitOption.TraisDeCommandement,
					UnitOption.Artefact, UnitOption.Bataillon),
			Arrays.asList(KeyWord.Ordre, KeyWord.Aelf, KeyWord.DaughtersOfKhaine, KeyWord.Heros,
					KeyWord.Pretre, KeyWord.SlaughterQueen),
			Arrays.asList(),
			Arrays.asList()),

	WitchAelves(
			"Witch Aelves",
			120,
			UnitProfile._6_1_7_6,
			Arrays.asList(RoleTactique.Ligne),
			Arrays.asList(DokUnitWeapon.CouteauxSacrificiels),
			null,
			Arrays.asList(DokRule.FerveurFrenetique),
			Arrays.asList(UnitOption.Chef, UnitOption.Banniere, UnitOption.Musicien,
					UnitOption.Armes, UnitOption.Renforcees, UnitOption.AptitudeDeVeteran,
					UnitOption.AptitudeDeVeteran_2, UnitOption.Bataillon),
			Arrays.asList(KeyWord.Ordre, KeyWord.Aelf, KeyWord.DaughtersOfKhaine,
					KeyWord.WitchAelves),
			Arrays.asList(),
			Arrays.asList()),

	SistersOfSlaughter(
			"Sisters of Slaughter",
			135,
			UnitProfile._6_1_7_6,
			Arrays.asList(RoleTactique.Ligne),
			Arrays.asList(DokUnitWeapon.FouetBarbele),
			null,
			Arrays.asList(DokRule.DanseDeLaMort),
			Arrays.asList(UnitOption.Chef, UnitOption.Banniere, UnitOption.Musicien,
					UnitOption.Armes, UnitOption.Renforcees, UnitOption.AptitudeDeVeteran,
					UnitOption.Bataillon),
			Arrays.asList(KeyWord.Ordre, KeyWord.Aelf, KeyWord.DaughtersOfKhaine,
					KeyWord.SisterOfSlaughter),
			Arrays.asList(),
			Arrays.asList()),

	KhainiteShadowstalkers(
			"Khainite Shadowstalkers",
			120,
			UnitProfile._6_1_7_5,
			Arrays.asList(RoleTactique.Elite),
			Arrays.asList(DokUnitWeapon.ProjectilesMaudits, DokUnitWeapon.LameDAssassin),
			null,
			Arrays.asList(DokRule.BondDeLOmbre, DokRule.ProjectilesMaudits,
					DokRule.ProfiterDeLOmbre),
			Arrays.asList(UnitOption.Chef, UnitOption.Renforcees, UnitOption.AptitudeDeVeteran,
					UnitOption.AptitudeDeVeteran_2, UnitOption.Bataillon),
			Arrays.asList(KeyWord.Ordre, KeyWord.Aelf, KeyWord.DaughtersOfKhaine,
					KeyWord.KhainiteShadowstalkers),
			Arrays.asList(),
			Arrays.asList()),

	BloodSisters(
			"Blood Sisters",
			140,
			UnitProfile._8_2_8_5,
			Arrays.asList(RoleTactique.Elite),
			Arrays.asList(DokUnitWeapon.VougeBrisecoeur),
			null,
			Arrays.asList(DokRule.TransmuteEnCristal),
			Arrays.asList(UnitOption.Chef, UnitOption.Renforcees, UnitOption.AptitudeDeVeteran,
					UnitOption.Bataillon),
			Arrays.asList(KeyWord.Ordre, KeyWord.DaughtersOfKhaine, KeyWord.Melusai,
					KeyWord.BloodSister),
			Arrays.asList(UnitModifiers.roleIfGeneral(KeyWord.BloodwrackMedusa, RoleTactique.Ligne),
					UnitModifiers.roleIfGeneral(KeyWord.MelusaiIronscale, RoleTactique.Ligne)),
			Arrays.asList()),

	BloodStalkers(
			"Blood Stalkers",
			170,
			UnitProfile._8_2_8_5,
			Arrays.asList(RoleTactique.Elite),
			Arrays.asList(DokUnitWeapon.ArcCherchecoeur, DokUnitWeapon.Scianlar),
			null,
			Arrays.asList(DokRule.Cherchecoeurs),
			Arrays.asList(UnitOption.Chef, UnitOption.Renforcees, UnitOption.AptitudeDeVeteran,
					UnitOption.AptitudeDeVeteran_2, UnitOption.AptitudeDeVeteran_3,
					UnitOption.Bataillon),
			Arrays.asList(KeyWord.Ordre, KeyWord.DaughtersOfKhaine, KeyWord.Melusai,
					KeyWord.BloodStalkers),
			Arrays.asList(UnitModifiers.roleIfGeneral(KeyWord.BloodwrackMedusa, RoleTactique.Ligne),
					UnitModifiers.roleIfGeneral(KeyWord.MelusaiIronscale, RoleTactique.Ligne)),
			Arrays.asList()),

	KhineraiHeartrenders(
			"Khinerai Heartrenders",
			95,
			UnitProfile._14_1_7_6,
			Arrays.asList(RoleTactique.Elite),
			Arrays.asList(DokUnitWeapon.JavelineBarbelee_P, DokUnitWeapon.JavelineBarbelee_M),
			null,
			Arrays.asList(GeneriqueUnitRule.Vol, DokRule.LaMortVientDuCiel,
					DokRule.PlongeonDansLaBataille, DokRule.VoleeEtVolteFace,
					DokRule.BouclierPerceCoeur),
			Arrays.asList(UnitOption.Chef, UnitOption.Renforcees, UnitOption.Gratuit,
					UnitOption.AptitudeDeVeteran, UnitOption.Bataillon),
			Arrays.asList(KeyWord.Ordre, KeyWord.DaughtersOfKhaine, KeyWord.KhineraiHarpies,
					KeyWord.KhineraiHeartrenders),
			Arrays.asList(),
			Arrays.asList()),

	AvatarOfKhaine(
			"Avatar of Khaine",
			135,
			UnitProfile._9_9_10_4,
			Arrays.asList(RoleTactique.Behemoth),
			Arrays.asList(DokUnitWeapon.TorrentdeSangBrulant, DokUnitWeapon.EpeeDAvatar),
			null,
			Arrays.asList(DokRule.AutelDeKhaine, DokRule.ObjetDAdoration, DokRule.ColereDeKhaine),
			Arrays.asList(UnitOption.AptitudeDeVeteran, UnitOption.Bataillon),
			Arrays.asList(KeyWord.Ordre, KeyWord.DaughtersOfKhaine, KeyWord.Totem,
					KeyWord.AvatarOfKhaine),
			Arrays.asList(),
			Arrays.asList()),

	BloodwrackViper(
			"Bloodwrack Viper",
			95,
			UnitProfile.None,
			Arrays.asList(RoleTactique.SortsPersistantsEtInvocation),
			Arrays.asList(),
			null,
			Arrays.asList(GeneriqueUnitRule.Vol, DokRule.BloodWrackViperConv,
					GeneriqueUnitRule.Predateur_9, DokRule.AttaqueDeCrochets),
			Arrays.asList(),
			Arrays.asList(),
			Arrays.asList(),
			Arrays.asList()),

	Bladewind(
			"Bladewind",
			80,
			UnitProfile.None,
			Arrays.asList(RoleTactique.SortsPersistantsEtInvocation),
			Arrays.asList(),
			null,
			Arrays.asList(GeneriqueUnitRule.Vol, DokRule.BladewindConv,
					GeneriqueUnitRule.Predateur_12, DokRule.TranchantSurnaturel),
			Arrays.asList(),
			Arrays.asList(),
			Arrays.asList(),
			Arrays.asList()),

	HeartOfFury(
			"Heart of Fury",
			55,
			UnitProfile.None,
			Arrays.asList(RoleTactique.SortsPersistantsEtInvocation),
			Arrays.asList(),
			null,
			Arrays.asList(DokRule.HeartOfFuryConv, DokRule.PrivilegeDuDieuDuMeurtre),
			Arrays.asList(),
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
	private List<BiConsumer<Army, Unit>> modifiers;
	private List<BiConsumer<Army, Unit>> checkers;

	private DokUnitModel(String displayName, int value, UnitProfile profile,
			List<RoleTactique> roleTactiques, List<IUnitWeapon> weapons,
			ProfileDegressif profileDegressif, List<IArmyRule<?>> rules, List<UnitOption> options,
			List<KeyWord> keyWords, List<BiConsumer<Army, Unit>> modifiers,
			List<BiConsumer<Army, Unit>> checkers) {
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
		this.checkers = checkers;
	}

	@Override
	public String getDisplayName() {
		return displayName;
	}

	@Override
	public UnitProfile getProfile() {
		return profile;
	}

	@Override
	public List<IUnitWeapon> getWeapons() {
		return weapons;
	}

	@Override
	public ProfileDegressif getProfileDegressif() {
		return profileDegressif;
	}

	@Override
	public List<IArmyRule<?>> getRules() {
		return rules;
	}

	@Override
	public List<KeyWord> getKeyWords() {
		return keyWords;
	}

	@Override
	public List<RoleTactique> getRoleTactiques() {
		return roleTactiques;
	}

	@Override
	public List<UnitOption> getOptions() {
		return options;
	}

	@Override
	public List<IUnitOptionValue<?>> getOptionValues() {
		return Arrays.asList(DokOptimisations.values());
	}

	@Override
	public int getValue() {
		return value;
	}

	@Override
	public void rebuild(Army army, Unit unit) {
		modifiers.stream().forEach(m -> m.accept(army, unit));
	}

	@Override
	public void check(Army army, Unit unit) {
		checkers.stream().forEach(c -> c.accept(army, unit));
	}

}
