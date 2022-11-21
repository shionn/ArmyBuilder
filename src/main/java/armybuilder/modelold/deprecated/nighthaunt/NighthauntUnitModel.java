package armybuilder.modelold.deprecated.nighthaunt;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

import armybuilder.model.rule.GeneriqueUnitRule;
import armybuilder.model.rule.IRule;
import armybuilder.model.unit.ProfileDegressif;
import armybuilder.model.unit.UnitProfile;
import armybuilder.model.unit.keyword.KeyWord;
import armybuilder.model.unit.model.IUnitModel;
import armybuilder.model.unit.option.UnitOptionCategory;
import armybuilder.model.unit.role.RoleTactique;
import armybuilder.model.unit.weapon.IUnitWeapon;
import armybuilder.modelold.deprecated.army.Listing;
import armybuilder.modelold.deprecated.unit.Unit;
import armybuilder.modelold.deprecated.unit.option.IUnitOptionValue;

public enum NighthauntUnitModel implements IUnitModel {

	ChainraspHorde(
			"Chainrasp Horde",
			95,
			UnitProfile._6_1_6_5,
			Arrays.asList(RoleTactique.Ligne),
			Arrays.asList(NighthauntUnitWeapon.ArmeDeMalignant),
			null,
			Arrays.asList(GeneriqueUnitRule.Vol, NighthauntRule.Etheres,
					NighthauntRule.HordeEffroyable),
			Arrays.asList(UnitOptionCategory.Chef, UnitOptionCategory.Bataillon),
			Arrays.asList(KeyWord.Mort, KeyWord.Malignant, KeyWord.Nighthaunt, KeyWord.Invocable,
					KeyWord.ChainraspHorde),
			Arrays.asList(),
			null),

	DreadbladeHarrow(
			"Dreadblade Harrow",
			100,
			UnitProfile._12_5_10_4,
			Arrays.asList(RoleTactique.Leader),
			Arrays.asList(NighthauntUnitWeapon.Affrelame,
					NighthauntUnitWeapon.SabotsEtDentsFantomatiques),
			null,
			Arrays.asList(GeneriqueUnitRule.Vol, NighthauntRule.Etheres,
					NighthauntRule.Dematerialisation, NighthauntRule.Affrelame,
					NighthauntRule.MaledictionDeLoyaute),
			Arrays.asList(UnitOptionCategory.General, UnitOptionCategory.TraisDeCommandement, UnitOptionCategory.Artefact,
					UnitOptionCategory.Bataillon),
			Arrays.asList(KeyWord.Mort, KeyWord.Malignant, KeyWord.Nighthaunt, KeyWord.Heros,
					KeyWord.DreadbladeHarrow),
			Arrays.asList(),
			null),

	GlaivewraithStalkers(
			"Glaivewraith Stalkers",
			60,
			UnitProfile._6_1_10_4,
			Arrays.asList(RoleTactique.Elite),
			Arrays.asList(NighthauntUnitWeapon.VougeDeChasseur),
			null,
			Arrays.asList(GeneriqueUnitRule.Vol, NighthauntRule.LaPointeDeLaMort,
					NighthauntRule.Etheres),
			Arrays.asList(UnitOptionCategory.Musicien, UnitOptionCategory.Bataillon),
			Arrays.asList(KeyWord.Mort, KeyWord.Malignant, KeyWord.Nighthaunt, KeyWord.Invocable,
					KeyWord.GlaivewraithStalkers),
			Arrays.asList(),
			null),

	MyrmournBanshees(
			"Myrmourn Banshees",
			75,
			UnitProfile._8_1_10_4,
			Arrays.asList(RoleTactique.Elite),
			Arrays.asList(NighthauntUnitWeapon.DagueDeGivre),
			null,
			Arrays.asList(GeneriqueUnitRule.Vol, NighthauntRule.Etheres, NighthauntRule.MangeSorts),
			Arrays.asList(UnitOptionCategory.Bataillon),
			Arrays.asList(KeyWord.Mort, KeyWord.Malignant, KeyWord.Nighthaunt, KeyWord.Invocable,
					KeyWord.MyrmournBanshees),
			Arrays.asList(),
			null),
	ThornsOfTheBriarQueen(
			"Thorns of the Briar Queen",
			0,
			UnitProfile._6_1_6_5,
			Arrays.asList(RoleTactique.Elite),
			Arrays.asList(NighthauntUnitWeapon.ArmeDeMalignant),
			null,
			Arrays.asList(GeneriqueUnitRule.Vol, NighthauntRule.Etheres,
					NighthauntRule.ChainesEtrangleuses),
			Arrays.asList(UnitOptionCategory.Chef, UnitOptionCategory.Bataillon),
			Arrays.asList(KeyWord.Mort, KeyWord.Malignant, KeyWord.Nighthaunt,
					KeyWord.ChainraspHorde, KeyWord.EpinesDeLaReineDesRonces),
			Arrays.asList(),
			null),

	TheBriarQueen(
			"The Briar Queen",
			175,
			UnitProfile._6_5_10_4,
			Arrays.asList(RoleTactique.Leader),
			Arrays.asList(NighthauntUnitWeapon.CriDechirant, NighthauntUnitWeapon.FouetDeRonces),
			null,
			Arrays.asList(GeneriqueUnitRule.Vol, NighthauntRule.Etheres,
					GeneriqueUnitRule.Sorcier_1_1, NighthauntRule.VortexHurlant),
			Arrays.asList(UnitOptionCategory.General, UnitOptionCategory.Sort, UnitOptionCategory.Bataillon),
			Arrays.asList(KeyWord.Mort, KeyWord.Malignant, KeyWord.Nighthaunt, KeyWord.Heros,
					KeyWord.Unique, KeyWord.MirrorghastBanshee, KeyWord.LaReineDesRonces,
					KeyWord.Sorcier),
			Arrays.asList(),
			null),

	TombBanshee(
			"Tomb Banshee",
			80,
			UnitProfile._6_4_10_4,
			Arrays.asList(RoleTactique.Leader),
			Arrays.asList(NighthauntUnitWeapon.DagueDeGivre),
			null,
			Arrays.asList(GeneriqueUnitRule.Vol, NighthauntRule.Etheres,
					NighthauntRule.ToucherFuneste, NighthauntRule.CriFunebre),
			Arrays.asList(UnitOptionCategory.General, UnitOptionCategory.TraisDeCommandement, UnitOptionCategory.Artefact,
					UnitOptionCategory.Bataillon),
			Arrays.asList(KeyWord.Mort, KeyWord.Malignant, KeyWord.Nighthaunt, KeyWord.Heros,
					KeyWord.TombBanshee),
			Arrays.asList(),
			null),

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
	private List<Consumer<Unit>> modifiers;
	private Function<Listing, Boolean> availableFor;

	private NighthauntUnitModel(String displayName, int value, UnitProfile profile,
			List<RoleTactique> roleTactiques, List<IUnitWeapon> weapons,
			ProfileDegressif profileDegressif, List<IRule<?>> rules, List<UnitOptionCategory> options,
			List<KeyWord> keyWords, List<Consumer<Unit>> modifiers,
			Function<Listing, Boolean> availableFor) {
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
		this.availableFor = availableFor;
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
	public List<IUnitWeapon> weapons() {
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
	public List<IUnitOptionValue<?>> optionValues() {
		return Arrays.asList(NighthauntOptimisation.values());
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
		return availableFor == null || availableFor.apply(listing);
	}

}
