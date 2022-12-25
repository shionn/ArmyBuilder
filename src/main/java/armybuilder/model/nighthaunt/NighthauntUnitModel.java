package armybuilder.model.nighthaunt;

import java.util.Arrays;
import java.util.List;

import armybuilder.model.army.Allegiance;
import armybuilder.model.army.Army;
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

public enum NighthauntUnitModel implements IUnitModel<NighthauntUnitModel> {

//	ChainraspHorde(
//			"Chainrasp Horde",
//			95,
//			UnitProfile._6_1_6_5,
//			Arrays.asList(RoleTactique.Ligne),
//			Arrays.asList(NighthauntUnitWeapon.ArmeDeMalignant),
//			null,
//			Arrays.asList(GeneriqueUnitRule.Vol, NighthauntRule.Etheres,
//					NighthauntRule.HordeEffroyable),
//			Arrays.asList(UnitOptionCategory.Chef, UnitOptionCategory.Bataillon),
//			Arrays.asList(KeyWord.Mort, KeyWord.Malignant, KeyWord.Nighthaunt, KeyWord.Invocable,
//					KeyWord.ChainraspHorde),
//			Arrays.asList(),
//			null),
//
//	DreadbladeHarrow(
//			"Dreadblade Harrow",
//			100,
//			UnitProfile._12_5_10_4,
//			Arrays.asList(RoleTactique.Leader),
//			Arrays.asList(NighthauntUnitWeapon.Affrelame,
//					NighthauntUnitWeapon.SabotsEtDentsFantomatiques),
//			null,
//			Arrays.asList(GeneriqueUnitRule.Vol, NighthauntRule.Etheres,
//					NighthauntRule.Dematerialisation, NighthauntRule.Affrelame,
//					NighthauntRule.MaledictionDeLoyaute),
//			Arrays.asList(UnitOptionCategory.General, UnitOptionCategory.TraisDeCommandement, UnitOptionCategory.Artefact,
//					UnitOptionCategory.Bataillon),
//			Arrays.asList(KeyWord.Mort, KeyWord.Malignant, KeyWord.Nighthaunt, KeyWord.Heros,
//					KeyWord.DreadbladeHarrow),
//			Arrays.asList(),
//			null),
//
//	GlaivewraithStalkers(
//			"Glaivewraith Stalkers",
//			60,
//			UnitProfile._6_1_10_4,
//			Arrays.asList(RoleTactique.Elite),
//			Arrays.asList(NighthauntUnitWeapon.VougeDeChasseur),
//			null,
//			Arrays.asList(GeneriqueUnitRule.Vol, NighthauntRule.LaPointeDeLaMort,
//					NighthauntRule.Etheres),
//			Arrays.asList(UnitOptionCategory.Musicien, UnitOptionCategory.Bataillon),
//			Arrays.asList(KeyWord.Mort, KeyWord.Malignant, KeyWord.Nighthaunt, KeyWord.Invocable,
//					KeyWord.GlaivewraithStalkers),
//			Arrays.asList(),
//			null),
//
//	MyrmournBanshees(
//			"Myrmourn Banshees",
//			75,
//			UnitProfile._8_1_10_4,
//			Arrays.asList(RoleTactique.Elite),
//			Arrays.asList(NighthauntUnitWeapon.DagueDeGivre),
//			null,
//			Arrays.asList(GeneriqueUnitRule.Vol, NighthauntRule.Etheres, NighthauntRule.MangeSorts),
//			Arrays.asList(UnitOptionCategory.Bataillon),
//			Arrays.asList(KeyWord.Mort, KeyWord.Malignant, KeyWord.Nighthaunt, KeyWord.Invocable,
//					KeyWord.MyrmournBanshees),
//			Arrays.asList(),
//			null),
//	ThornsOfTheBriarQueen(
//			"Thorns of the Briar Queen",
//			0,
//			UnitProfile._6_1_6_5,
//			Arrays.asList(RoleTactique.Elite),
//			Arrays.asList(NighthauntUnitWeapon.ArmeDeMalignant),
//			null,
//			Arrays.asList(GeneriqueUnitRule.Vol, NighthauntRule.Etheres,
//					NighthauntRule.ChainesEtrangleuses),
//			Arrays.asList(UnitOptionCategory.Chef, UnitOptionCategory.Bataillon),
//			Arrays.asList(KeyWord.Mort, KeyWord.Malignant, KeyWord.Nighthaunt,
//					KeyWord.ChainraspHorde, KeyWord.EpinesDeLaReineDesRonces),
//			Arrays.asList(),
//			null),
//
//	TheBriarQueen(
//			"The Briar Queen",
//			175,
//			UnitProfile._6_5_10_4,
//			Arrays.asList(RoleTactique.Leader),
//			Arrays.asList(NighthauntUnitWeapon.CriDechirant, NighthauntUnitWeapon.FouetDeRonces),
//			null,
//			Arrays.asList(GeneriqueUnitRule.Vol, NighthauntRule.Etheres,
//					GeneriqueUnitRule.Sorcier_1_1, NighthauntRule.VortexHurlant),
//			Arrays.asList(UnitOptionCategory.General, UnitOptionCategory.Sort, UnitOptionCategory.Bataillon),
//			Arrays.asList(KeyWord.Mort, KeyWord.Malignant, KeyWord.Nighthaunt, KeyWord.Heros,
//					KeyWord.Unique, KeyWord.MirrorghastBanshee, KeyWord.LaReineDesRonces,
//					KeyWord.Sorcier),
//			Arrays.asList(),
//			null),
//
//	TombBanshee(
//			"Tomb Banshee",
//			80,
//			UnitProfile._6_4_10_4,
//			Arrays.asList(RoleTactique.Leader),
//			Arrays.asList(NighthauntUnitWeapon.DagueDeGivre),
//			null,
//			Arrays.asList(GeneriqueUnitRule.Vol, NighthauntRule.Etheres,
//					NighthauntRule.ToucherFuneste, NighthauntRule.CriFunebre),
//			Arrays.asList(UnitOptionCategory.General, UnitOptionCategory.TraisDeCommandement, UnitOptionCategory.Artefact,
//					UnitOptionCategory.Bataillon),
//			Arrays.asList(KeyWord.Mort, KeyWord.Malignant, KeyWord.Nighthaunt, KeyWord.Heros,
//					KeyWord.TombBanshee),
//			Arrays.asList(),
//			null),

	// LADY Olynder

	KurdossValentian(Arrays.asList(NighthauntUnitWeapon.SceptreSepulcral, NighthauntUnitWeapon.GriffesSpectrales), null,
			Arrays.asList(GeneriqueUnitRule.Vol, NighthauntRule.SiJeNePeuxRegnerNulNeLePourra)),
//	BBB(Arrays.asList(), null, Arrays.asList()),
//	CCC(Arrays.asList(), null, Arrays.asList()),
//	DDD(Arrays.asList(), null, Arrays.asList()),
//	EEE(Arrays.asList(), null, Arrays.asList()),
//	FFF(Arrays.asList(), null, Arrays.asList()),
//	GGG(Arrays.asList(), null, Arrays.asList()),
//	HHH(Arrays.asList(), null, Arrays.asList()),
//	III(Arrays.asList(), null, Arrays.asList()),
//	JJJ(Arrays.asList(), null, Arrays.asList()),
//	KKK(Arrays.asList(), null, Arrays.asList()),
//	LLL(Arrays.asList(), null, Arrays.asList()),

	;

	private String name;
	private int pts;
	private UnitProfile profile;
	private ProfileDegressif profileDegressif;
	private List<RoleTactique> roles;
	private List<IUnitWeapon> weapons;
	private List<KeyWord> keywords;
	private List<IRule<?>> rules;
	private List<UnitOptionCategory> options;

	private NighthauntUnitModel(List<IUnitWeapon> weapons, ProfileDegressif profileDegressif, List<IRule<?>> rules) {
		this.name = EnumPropertyLoader.instance().name(this);
		this.pts = EnumPropertyLoader.instance().pts(this);
		this.roles = EnumPropertyLoader.instance().roles(this);
		this.profile = EnumPropertyLoader.instance().profile(this);
		this.keywords = EnumPropertyLoader.instance().keywords(this);
		this.options = EnumPropertyLoader.instance().options(this);
		this.weapons = weapons;
		this.profileDegressif = profileDegressif;
		this.rules = rules;
	}

	@Override
	public String getDisplayName() {
		return name;
	}

	@Override
	public UnitProfile getProfile() {
		return profile;
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
		return keywords;
	}

	@Override
	public List<RoleTactique> getRoleTactiques() {
		return roles;
	}

	@Override
	public List<UnitOptionCategory> getOptionsCategories() {
		return options;
	}

	@Override
	public int getPoints() {
		return pts;
	}

	@Override
	public List<IUnitWeapon> getWeapons() {
		return weapons;
	}

	@Override
	public boolean availableFor(Army army) {
		return army.is(Allegiance.Nighthaunt);
	}

}
