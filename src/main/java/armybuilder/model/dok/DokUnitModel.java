package armybuilder.model.dok;

import java.util.Arrays;
import java.util.List;

import armybuilder.model.army.Allegiance;
import armybuilder.model.army.Army;
import armybuilder.model.rule.GeneriqueRule;
import armybuilder.model.rule.GeneriqueUnitRule;
import armybuilder.model.rule.IRule;
import armybuilder.model.unit.ProfileDegressif;
import armybuilder.model.unit.UnitProfile;
import armybuilder.model.unit.keyword.KeyWord;
import armybuilder.model.unit.model.IUnitModel;
import armybuilder.model.unit.option.UnitOptionCategory;
import armybuilder.model.unit.role.RoleTactique;
import armybuilder.model.unit.weapon.IUnitWeapon;
import armybuilder.serialisation.EnumPropertyLoader;

public enum DokUnitModel implements IUnitModel<DokUnitModel> {

	// TODO ajouter maitre de Guerre
	MorathiKhaine(Arrays.asList(DokUnitWeapon.EcorcheCoeur, DokUnitWeapon.AilesLamees),
			null,
			Arrays.asList(DokRule.SorcierMorathi, DokRule.PresenceIntimidante, DokRule.DeuxCorpsUneSeuleAme,
					DokRule.VenerationParLeSang, DokRule.HorreurNoireDUlgu, DokRule.Affaiblissement,
					DokRule.DanseSymetrique, DokRule.DestrierDOmbres, DokRule.PuitsDeTenebres, DokRule.RasoirMental,
					DokRule.SuaireDeDesespoir)),

	LaReineDeLOmbre(
			Arrays.asList(DokUnitWeapon.RegardDeLaReineDeLOmbre, DokUnitWeapon.EcorcheCoeur_Shadow,
					DokUnitWeapon.CouronneDeSerpents, DokUnitWeapon.QueueVenimeuse),
			new ProfileDegressif("Mouvement", DokUnitWeapon.EcorcheCoeur_Shadow.getDisplayName(),
					DokUnitWeapon.QueueVenimeuse.getDisplayName()).add("0-6", "14", "8", "6")
					.add("7-8", "12", "7", "5")
					.add("9-10", "10", "6", "4")
					.add("11+", "8", "5", "3"),
			Arrays.asList(GeneriqueUnitRule.Vol, DokRule.FureurDeLaReineDeLOmbre, DokRule.DeuxCorpsUneSeuleAme_Shadow,
					DokRule.CoeurDeFerDeKhaine)),

	SanctuaireIncarnat(
			Arrays.asList(DokUnitWeapon.RegardIncarnat, DokUnitWeapon.LanceIncarnate, DokUnitWeapon.Aiguillons,
					DokUnitWeapon.GriffeMurmure, DokUnitWeapon.QueueDeSerpents),
			new ProfileDegressif("Mouvement", DokUnitWeapon.Aiguillons.getDisplayName(),
					DokRule.AuraDAgonie.getDisplayName()).add("0-6", "6", "6", "2+")
					.add("7-8", "5", "5", "3+")
					.add("9-10", "4", "4", "4+")
					.add("11+", "3", "3", "5+"),
			Arrays.asList(DokRule.AuraDAgonie, DokRule.ImpactLame, DokRule.RegardIncarnat, DokRule.SoeurDesMelusai,
					GeneriqueUnitRule.Sorcier_1_2, DokRule.Deperissement)),

	MelusaiIronscale(UnitProfile._8_6_9_5,
			Arrays.asList(RoleTactique.Leader),
			Arrays.asList(DokUnitWeapon.Keldrisaith_Projectil, DokUnitWeapon.Keldrisaith_Melee),
			null,
			Arrays.asList(DokRule.SangDeLOracle, DokRule.OffrandeSanguinolente, DokRule.TransmuteEnCristal_Ferecaille,
					DokRule.ColereDesMoirenees),
			Arrays.asList(UnitOptionCategory.General, UnitOptionCategory.TraisDeCommandement,
					UnitOptionCategory.Artefact),
			Arrays.asList(KeyWord.Ordre, KeyWord.FilleDeKhaine, KeyWord.Moirenees, KeyWord.Melusai, KeyWord.Heros,
					KeyWord.FerecailleMelusai)),

	MeduseIncarnate(UnitProfile._8_6_8_5,
			Arrays.asList(RoleTactique.Leader),
			Arrays.asList(DokUnitWeapon.RegardIncarnat, DokUnitWeapon.LanceIncarnate, DokUnitWeapon.GriffeMurmure,
					DokUnitWeapon.QueueDeSerpents),
			null,
			Arrays.asList(DokRule.RegardIncarnat, DokRule.Deperissement, DokRule.SoeurDesMelusai,
					GeneriqueUnitRule.Sorcier_1_2),
			Arrays.asList(UnitOptionCategory.General, UnitOptionCategory.TraisDeCommandement,
					UnitOptionCategory.Artefact, UnitOptionCategory.Sort),
			Arrays.asList(KeyWord.Ordre, KeyWord.FilleDeKhaine, KeyWord.Meduse, KeyWord.Heros, KeyWord.Sorcier,
					KeyWord.MeduseIncarnate)),

//	@Deprecated
//	MorgwaethTheBloodied(
//			UnitProfile._6_1_7_6,
//			Arrays.asList(RoleTactique.Leader),
//			Arrays.asList(DokUnitWeapon.VougeDeKhaine),
//			null,
//			Arrays.asList(DokRule.RuneDeKhaine_Priere, DokRule.BrouetDeSang),
//			Arrays.asList(UnitOptionCategory.General, UnitOptionCategory.Priere, UnitOptionCategory.TraisDeCommandement,
//					UnitOptionCategory.Artefact),
//			Arrays.asList(KeyWord.Ordre, KeyWord.Aelf, KeyWord.FilleDeKhaine, KeyWord.HaggNar, KeyWord.Heros,
//					KeyWord.Pretre, KeyWord.ReineMatriarche, KeyWord.MorgwaethTheBloodied, KeyWord.Unique),
//			Arrays.asList()),
//
//	@Deprecated
//	LeBladeCoven(
//			UnitProfile._6_1_7_6,
//			Arrays.asList(RoleTactique.Elite),
//			Arrays.asList(DokUnitWeapon.ArcCherchecoeur, DokUnitWeapon.ArmesSacrificielles),
//			null,
//			Arrays.asList(DokRule.Cherchecoeurs, DokRule.ZelotesDuPremierTemple),
//			Arrays.asList(),
//			Arrays.asList(KeyWord.Ordre, KeyWord.Aelf, KeyWord.FilleDeKhaine, KeyWord.Meduse, KeyWord.FilleDeKhaine,
//					KeyWord.HaggNar, KeyWord.LaBladeCoven, KeyWord.Unique),
//			Arrays.asList()),

	ReineMatriacheSurChaudronDeSang(
			Arrays.asList(DokUnitWeapon.TorrentDeSangBrulant, DokUnitWeapon.EpeeDAvatar, DokUnitWeapon.LameDeKhaine,
					DokUnitWeapon.Sciansa_Chaudron),
			new ProfileDegressif("Mouvement", DokUnitWeapon.Sciansa_Chaudron.getDisplayName(),
					DokRule.BouclierDeSang.getDisplayName()).add("0-6", "6\"", "8", "18\"")
					.add("7-8", "5\"", "7", "14\"")
					.add("6-10", "4\"", "6", "10\"")
					.add("11+", "3\"", "5", "6\""),
			Arrays.asList(DokRule.AutelDeKhaine, DokRule.ImpactLame, DokRule.BouclierDeSang, DokRule.BrouetDeSang,
					DokRule.CaresseDeLaMort)),

	ReineMatriache(UnitProfile._6_5_8_5,
			Arrays.asList(RoleTactique.Leader),
			Arrays.asList(DokUnitWeapon.LameDeKhaine),
			null,
			Arrays.asList(DokRule.BrouetDeSang, DokRule.CaresseDeLaMort),
			Arrays.asList(UnitOptionCategory.General, UnitOptionCategory.TraisDeCommandement,
					UnitOptionCategory.Artefact, UnitOptionCategory.Priere),
			Arrays.asList(KeyWord.Ordre, KeyWord.FilleDeKhaine, KeyWord.Aelf, KeyWord.Heros, KeyWord.Pretre,
					KeyWord.ReineMatriarche)),

	ReineDuMassacreSurChaudronDeSang(
			Arrays.asList(DokUnitWeapon.TorrentDeSangBrulant, DokUnitWeapon.EpeeDAvatar,
					DokUnitWeapon.EpeeDeMortEtLameDeKhaine, DokUnitWeapon.Sciansa_Chaudron),
			new ProfileDegressif("Mouvement", DokUnitWeapon.Sciansa_Chaudron.getDisplayName(),
					DokRule.BouclierDeSang.getDisplayName()).add("0-6", "6\"", "8", "18\"")
					.add("7-8", "5\"", "7", "15\"")
					.add("9-10", "4\"", "6", "10\"")
					.add("11+", "3\"", "5", "6\""),
			Arrays.asList(DokRule.AutelDeKhaine, DokRule.ImpactLame, DokRule.BouclierDeSang, DokRule.PacteDeSang,
					DokRule.OrgieDeMassacre, DokRule.DanseMaudite)),

	ReineDuMassacre(Arrays.asList(DokUnitWeapon.EpeeDeMortEtLameDeKhaine),
			null,
			Arrays.asList(DokRule.DanseMaudite, DokRule.OrgieDeMassacre)),

	GrandeGladiatrice(Arrays.asList(DokUnitWeapon.FouetBarbeleGr, DokUnitWeapon.LameDeGladiatrice),
			null,
			Arrays.asList(DokRule.DanseDeLaMort, DokRule.CoupDeGrace, DokRule.ParangonDuMassacre)),

	SoeurDuMassacre(UnitProfile._6_1_7_6,
			Arrays.asList(RoleTactique.Ligne),
			Arrays.asList(DokUnitWeapon.FouetBarbele),
			null,
			Arrays.asList(DokRule.DanseDeLaMort),
			Arrays.asList(UnitOptionCategory.Chef, UnitOptionCategory.Banniere, UnitOptionCategory.Musicien,
					UnitOptionCategory.Armes, UnitOptionCategory.Renforcees),
			Arrays.asList(KeyWord.Ordre, KeyWord.FilleDeKhaine, KeyWord.Aelf, KeyWord.SoeurDuMassacre)),

	Erinyes(UnitProfile._6_1_7_6,
			Arrays.asList(RoleTactique.Ligne),
			Arrays.asList(),
			null,
			Arrays.asList(DokRule.FerveurFrenetique),
			Arrays.asList(UnitOptionCategory.Chef, UnitOptionCategory.Banniere, UnitOptionCategory.Musicien,
					UnitOptionCategory.Armes, UnitOptionCategory.Renforcees),
			Arrays.asList(KeyWord.Ordre, KeyWord.FilleDeKhaine, KeyWord.Aelf, KeyWord.Erinyes)),

//	@Deprecated
//	KhainiteShadowstalkers(
//			UnitProfile._6_1_7_5,
//			Arrays.asList(RoleTactique.Elite),
//			Arrays.asList(DokUnitWeapon.ProjectilesMaudits, DokUnitWeapon.LameDAssassin),
//			null,
//			Arrays.asList(DokRule.BondDeLOmbre, DokRule.ProjectilesMaudits, DokRule.ProfiterDeLOmbre),
//			Arrays.asList(UnitOptionCategory.Chef, UnitOptionCategory.Renforcees),
//			Arrays.asList(KeyWord.Ordre, KeyWord.Aelf, KeyWord.FilleDeKhaine, KeyWord.RodeursDeLOmbre),
//			Arrays.asList()),
//
//	@Deprecated
//	ConjurateursDuFeuMaudit(UnitProfile.None, Arrays.asList(RoleTactique.Elite), null, null, null, null, null, null),

	AvatarDeKhaine(
			Arrays.asList(DokUnitWeapon.TorrentDeSangBrulant, DokUnitWeapon.EpeeDAvatar),
			null,
			Arrays.asList(DokRule.AutelDeKhaine, DokRule.AnimuseDeSorcellerieEtDeSacrifice, DokRule.ColereDeKhaine,
					GeneriqueRule.Ecroulement, GeneriqueRule.Pietinement)),

//	@Deprecated
//	BloodStalkers(
//			UnitProfile._8_2_8_5,
//			Arrays.asList(RoleTactique.Elite),
//			Arrays.asList(DokUnitWeapon.ArcCherchecoeur, DokUnitWeapon.Scianlar),
//			null,
//			Arrays.asList(DokRule.Cherchecoeurs),
//			Arrays.asList(UnitOptionCategory.Chef, UnitOptionCategory.Renforcees),
//			Arrays.asList(KeyWord.Ordre, KeyWord.FilleDeKhaine, KeyWord.Meduse, KeyWord.BloodStalkers),
////			Arrays.asList(UnitModifiers.roleIfGeneral(KeyWord.MeduseIncarnate, RoleTactique.Ligne),
////					UnitModifiers.roleIfGeneral(KeyWord.MelusaiIronscale, RoleTactique.Ligne)),
//			Arrays.asList()),

//	@Deprecated
//	BloodSisters(
//			UnitProfile._8_2_8_5,
//			Arrays.asList(RoleTactique.Elite),
//			Arrays.asList(DokUnitWeapon.VougeBrisecoeur),
//			null,
//			Arrays.asList(DokRule.TransmuteEnCristal),
//			Arrays.asList(UnitOptionCategory.Chef, UnitOptionCategory.Renforcees),
//			Arrays.asList(KeyWord.Ordre, KeyWord.FilleDeKhaine, KeyWord.Meduse, KeyWord.BloodSister),
////			Arrays.asList(UnitModifiers.roleIfGeneral(KeyWord.MeduseIncarnate, RoleTactique.Ligne),
////					UnitModifiers.roleIfGeneral(KeyWord.MelusaiIronscale, RoleTactique.Ligne)),
//			Arrays.asList()),

	EtripeusesKhinerai(UnitProfile._14_1_7_5,
			Arrays.asList(RoleTactique.Elite),
			Arrays.asList(DokUnitWeapon.JavelineBarbelee_P, DokUnitWeapon.JavelineBarbelee_M),
			null,
			Arrays.asList(GeneriqueUnitRule.Vol, DokRule.PlongeonDansLaBataille, DokRule.VoleeEtVolteFace),
			Arrays.asList(UnitOptionCategory.Chef, UnitOptionCategory.Renforcees),
			Arrays.asList(KeyWord.Ordre, KeyWord.FilleDeKhaine, KeyWord.Moirenees, KeyWord.Khinerai,
					KeyWord.EtripeusesKhinerai)),

	@Deprecated
	EgorgeusesKhinerai(UnitProfile.None, Arrays.asList(RoleTactique.Elite), null, null, null, null, null),

	@Deprecated
	BloodwrackViper(UnitProfile.None,
			Arrays.asList(RoleTactique.SortsPersistantsEtInvocation),
			Arrays.asList(),
			null,
			Arrays.asList(GeneriqueUnitRule.Vol, DokRule.BloodWrackViperConv, GeneriqueUnitRule.Predateur_9,
					DokRule.AttaqueDeCrochets),
			Arrays.asList(),
			Arrays.asList()),

	@Deprecated
	Bladewind(UnitProfile.None,
			Arrays.asList(RoleTactique.SortsPersistantsEtInvocation),
			Arrays.asList(),
			null,
			Arrays.asList(GeneriqueUnitRule.Vol, DokRule.BladewindConv, GeneriqueUnitRule.Predateur_12,
					DokRule.TranchantSurnaturel),
			Arrays.asList(),
			Arrays.asList()),

	CoeurDeFureur(UnitProfile.None,
			Arrays.asList(RoleTactique.SortsPersistantsEtInvocation),
			Arrays.asList(),
			null,
			Arrays.asList(DokRule.CoeurDeFureurConv, DokRule.ReceptacleDuDieuMeurtre),
			Arrays.asList(),
			Arrays.asList()),

	;

	private String displayName;
	private int value;
	private UnitProfile profile;
	private List<IUnitWeapon> weapons;
	private ProfileDegressif profileDegressif;
	private List<IRule<?>> rules;
	private List<KeyWord> keyWords;
	private List<RoleTactique> roleTactiques;
	private List<UnitOptionCategory> options;

	private DokUnitModel(List<IUnitWeapon> weapons, ProfileDegressif profileDegressif, List<IRule<?>> rules) {
		this.displayName = EnumPropertyLoader.instance().name(this);
		this.value = EnumPropertyLoader.instance().pts(this);
		this.profile = EnumPropertyLoader.instance().profile(this);
		this.roleTactiques = EnumPropertyLoader.instance().roles(this);
		this.weapons = weapons;
		this.profileDegressif = profileDegressif;
		this.rules = rules;
		this.options = EnumPropertyLoader.instance().options(this);
		this.keyWords = EnumPropertyLoader.instance().keywords(this);
	}

	private DokUnitModel(UnitProfile profile, List<RoleTactique> roleTactiques, List<IUnitWeapon> weapons,
			ProfileDegressif profileDegressif, List<IRule<?>> rules, List<UnitOptionCategory> options,
			List<KeyWord> keyWords) {
		this.displayName = EnumPropertyLoader.instance().name(this);
		this.value = EnumPropertyLoader.instance().pts(this);
		this.profile = profile;
		this.roleTactiques = roleTactiques;
		this.weapons = weapons;
		this.profileDegressif = profileDegressif;
		this.rules = rules;
		this.options = options;
		this.keyWords = keyWords;
	}

	@Override
	public String getDisplayName() {
		return displayName;
	}

	@Override
	public boolean availableFor(Army army) {
		return army.is(Allegiance.DoK);
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
	public List<IRule<?>> getRules() {
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
	public List<UnitOptionCategory> getOptionsCategories() {
		return options;
	}

	@Override
	public int getPoints() {
		return value;
	}

}
