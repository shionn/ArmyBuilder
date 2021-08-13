package armybuilder.model.nighthaunt;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiConsumer;

import org.apache.commons.collections.ListUtils;

import armybuilder.model.Army;
import armybuilder.model.rule.GeneriqueUnitRule;
import armybuilder.model.rule.IArmyRule;
import armybuilder.model.unit.IUnitModel;
import armybuilder.model.unit.KeyWord;
import armybuilder.model.unit.ProfileDegressif;
import armybuilder.model.unit.RoleTactique;
import armybuilder.model.unit.Unit;
import armybuilder.model.unit.UnitCheckers;
import armybuilder.model.unit.UnitProfile;
import armybuilder.model.unit.option.IUnitOptionValue;
import armybuilder.model.unit.option.OptimisationsUniverselles;
import armybuilder.model.unit.option.UnitOption;
import armybuilder.model.unit.weapon.IUnitWeapon;

public enum NighthauntUnitModel implements IUnitModel {

	TheBriarQueen(
			"The Briar Queen",
			175,
			UnitProfile._6_5_10_4,
			Arrays.asList(RoleTactique.Leader),
			Arrays.asList(NighthauntUnitWeapon.CriDechirant, NighthauntUnitWeapon.FouetDeRonces),
			null,
			Arrays.asList(GeneriqueUnitRule.Vol, NighthauntRule.Etheres,
					GeneriqueUnitRule.Sorcier_1_1, NighthauntRule.VortexHurlant),
			Arrays.asList(UnitOption.General, UnitOption.Sort),
			Arrays.asList(KeyWord.Mort, KeyWord.Malignant, KeyWord.Nighthaunt, KeyWord.Heros,
					KeyWord.Unique, KeyWord.MirrorghastBanshee, KeyWord.LaReineDesRonces,
					KeyWord.Sorcier),
			Arrays.asList(),
			Arrays.asList(UnitCheckers.mustBeTakeWith(KeyWord.EpinesDeLaReineDesRonces))),

	ChainraspHorde(
			"Chainrasp Horde",
			95,
			UnitProfile._6_1_6_5,
			Arrays.asList(RoleTactique.Ligne),
			Arrays.asList(NighthauntUnitWeapon.ArmeDeMalignant),
			null,
			Arrays.asList(GeneriqueUnitRule.Vol, NighthauntRule.Etheres,
					NighthauntRule.HordeEffroyable),
			Arrays.asList(UnitOption.Chef),
			Arrays.asList(KeyWord.Mort, KeyWord.Malignant, KeyWord.Nighthaunt, KeyWord.Invocable,
					KeyWord.ChainraspHorde),
			Arrays.asList(),
			Arrays.asList()),

	ThornsOfTheBriarQueen(
			"Thorns of the Briar Queen",
			0,
			UnitProfile._6_1_6_5,
			Arrays.asList(RoleTactique.Elite),
			Arrays.asList(NighthauntUnitWeapon.ArmeDeMalignant),
			null,
			Arrays.asList(GeneriqueUnitRule.Vol, NighthauntRule.Etheres,
					NighthauntRule.ChainesEtrangleuses),
			Arrays.asList(UnitOption.Chef),
			Arrays.asList(KeyWord.Mort, KeyWord.Malignant, KeyWord.Nighthaunt,
					KeyWord.ChainraspHorde, KeyWord.EpinesDeLaReineDesRonces),
			Arrays.asList(),
			Arrays.asList(UnitCheckers.mustBeTakeWith(KeyWord.LaReineDesRonces))),

	MyrmournBanshees(
			"Myrmourn Banshees",
			75,
			UnitProfile._8_1_10_4,
			Arrays.asList(RoleTactique.Elite),
			Arrays.asList(NighthauntUnitWeapon.DagueDeGivre),
			null,
			Arrays.asList(GeneriqueUnitRule.Vol, NighthauntRule.Etheres, NighthauntRule.MangeSorts),
			Arrays.asList(),
			Arrays.asList(KeyWord.Mort, KeyWord.Malignant, KeyWord.Nighthaunt, KeyWord.Invocable,
					KeyWord.MyrmournBanshees),
			Arrays.asList(),
			Arrays.asList()),

	GlaivewraithStalkers(
			"Glaivewraith Stalkers",
			60,
			UnitProfile._6_1_10_4,
			Arrays.asList(RoleTactique.Elite),
			Arrays.asList(NighthauntUnitWeapon.VougeDeChasseur),
			null,
			Arrays.asList(GeneriqueUnitRule.Vol, NighthauntRule.LaPointeDeLaMort,
					NighthauntRule.Etheres),
			Arrays.asList(UnitOption.Musicien),
			Arrays.asList(KeyWord.Mort, KeyWord.Malignant, KeyWord.Nighthaunt, KeyWord.Invocable,
					KeyWord.GlaivewraithStalkers),
			Arrays.asList(),
			Arrays.asList())

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

	private NighthauntUnitModel(String displayName, int value, UnitProfile profile,
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
	@SuppressWarnings("unchecked")
	public List<IUnitOptionValue<?>> getOptionValues() {
		return ListUtils.union(Arrays.asList(OptimisationsUniverselles.values()),
				Arrays.asList(NighthauntOptimisation.values()));
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