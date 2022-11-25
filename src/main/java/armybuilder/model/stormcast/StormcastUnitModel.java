package armybuilder.model.stormcast;

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

public enum StormcastUnitModel implements IUnitModel<StormcastUnitModel> {

	SeigneurRelictor(
			UnitProfile._5_6_9_3,
			Arrays.asList(RoleTactique.Leader),
			Arrays.asList(StormcastWeapons.MarteauRelique),
			null,
			Arrays.asList(StormcastRule.PretreMortis, StormcastRule.OrageGuerisseur, StormcastRule.OrageFoudroyant),
			Arrays.asList(UnitOptionCategory.General, UnitOptionCategory.TraisDeCommandement,
					UnitOptionCategory.Priere),
			Arrays.asList(KeyWord.Ordre, KeyWord.StormCast, KeyWord.Heros, KeyWord.Pretre, KeyWord.Totem,
					KeyWord.Seigneur, KeyWord.SeigneurRelictor)),

	Vindictors(
			UnitProfile._5_2_7_3,
			Arrays.asList(RoleTactique.Ligne),
			Arrays.asList(StormcastWeapons.LanceDOrage),
			null,
			Arrays.asList(StormcastRule.ArsenalDAmesOrageuses),
			Arrays.asList(UnitOptionCategory.Chef, UnitOptionCategory.Banniere, UnitOptionCategory.Renforcees),
			Arrays.asList(KeyWord.Ordre, KeyWord.StormCast, KeyWord.Fulgurant, KeyWord.Redempteur, KeyWord.Vindictors)),

	Liberators(
			UnitProfile._5_2_7_4,
			Arrays.asList(RoleTactique.Ligne),
			Arrays.asList(StormcastWeapons.GrandeArme),
			null,
			Arrays.asList(StormcastRule.RenversezLesTyrans),
			Arrays.asList(UnitOptionCategory.Chef, UnitOptionCategory.Armes, UnitOptionCategory.Renforcees),
			Arrays.asList(KeyWord.Ordre, KeyWord.StormCast, KeyWord.Redempteur, KeyWord.Liberators)),

	Sequitors(
			UnitProfile._5_2_7_4,
			Arrays.asList(RoleTactique.Ligne),
			Arrays.asList(StormcastWeapons.ArmesSacroSaintes, StormcastWeapons.GrandeMassueDeSanction),
			null,
			Arrays.asList(StormcastRule.CanalisationEtheriqueDeSequitors),
			Arrays.asList(UnitOptionCategory.Chef, UnitOptionCategory.Renforcees),
			Arrays.asList(KeyWord.Ordre, KeyWord.StormCast, KeyWord.SacroSaint, KeyWord.Redempteur, KeyWord.Sequitors)),

	JudicatorsArcs(
			UnitProfile._5_2_7_4,
			Arrays.asList(RoleTactique.Ligne),
			Arrays.asList(StormcastWeapons.ArcFoudreciel, StormcastWeapons.ArcFoudrefleche,
					StormcastWeapons.GlaiveDOrage),
			null,
			Arrays.asList(StormcastRule.DeflagrationCeleste),
			Arrays.asList(UnitOptionCategory.Chef, UnitOptionCategory.Renforcees),
			Arrays.asList(KeyWord.Ordre, KeyWord.StormCast, KeyWord.Judicators, KeyWord.Judicators,
					KeyWord.JudicatorsArc)),

	Castigators(
			UnitProfile._5_2_7_4,
			Arrays.asList(RoleTactique.Elite),
			Arrays.asList(StormcastWeapons.GrandArcFulgurant, StormcastWeapons.LourdeCrosse),
			null,
			Arrays.asList(StormcastRule.CanalisationEtheriqueDeCastigators, StormcastRule.ExplosionDEnergieCeleste),
			Arrays.asList(UnitOptionCategory.Chef, UnitOptionCategory.Renforcees),
			Arrays.asList(KeyWord.Ordre, KeyWord.StormCast, KeyWord.SacroSaint, KeyWord.Justicar, KeyWord.Castigators)),

	GryphDogues(
			UnitProfile._9_2_6_Dash,
			Arrays.asList(RoleTactique.Elite),
			Arrays.asList(StormcastWeapons.BecEtGriffesCruels),
			null,
			Arrays.asList(StormcastRule.AttaquesAuPassage, StormcastRule.CriDAlarme),
			Arrays.asList(UnitOptionCategory.Chef, UnitOptionCategory.Renforcees),
			Arrays.asList(KeyWord.Ordre, KeyWord.StormCast, KeyWord.GryphDogues)),

	ProsecutorsMarteaux(
			UnitProfile._12_2_7_4,
			Arrays.asList(RoleTactique.Elite),
			Arrays.asList(StormcastWeapons.GrandeArme),
			null,
			Arrays.asList(GeneriqueUnitRule.Vol, StormcastRule.FormationDispersee, StormcastRule.HerautsDeVertu),
			Arrays.asList(UnitOptionCategory.Chef, UnitOptionCategory.Armes, UnitOptionCategory.Renforcees),
			Arrays.asList(KeyWord.Ordre, KeyWord.StormCast, KeyWord.Angelos, KeyWord.Prosecutors,
					KeyWord.ProsecutorsMarteaux)),

	;

	private int pts;
	private String displayName;

	private UnitProfile profile;
	private ProfileDegressif degressif;

	private List<IUnitWeapon> weapons;
	private List<RoleTactique> roles;
	private List<KeyWord> keywords;
	private List<IRule<?>> rules;
	private List<UnitOptionCategory> options;

	StormcastUnitModel(UnitProfile profile, List<RoleTactique> roleTactiques, List<IUnitWeapon> weapons,
			ProfileDegressif profileDegressif, List<IRule<?>> rules, List<UnitOptionCategory> options,
			List<KeyWord> keyWords) {
		this.displayName = EnumPropertyLoader.instance().name(this);
		this.pts = EnumPropertyLoader.instance().pts(this);
		this.roles = roleTactiques;
		this.weapons = weapons;
		this.degressif = profileDegressif;
		this.rules = rules;
		this.options = options;
		this.keywords = keyWords;
		this.profile = profile;
	}

	@Override
	public List<IUnitWeapon> getWeapons() {
		return weapons;
	}

	@Override
	public List<RoleTactique> getRoleTactiques() {
		return roles;
	}

	@Override
	public List<KeyWord> getKeyWords() {
		return keywords;
	}

	@Override
	public String getDisplayName() {
		return displayName;
	}

	@Override
	public boolean availableFor(Army army) {
		return army.is(Allegiance.StormCast);
	}

	@Override
	public List<IRule<?>> getRules() {
		return rules;
	}

	@Override
	public int getPoints() {
		return pts;
	}

	@Override
	public List<UnitOptionCategory> getOptionsCategories() {
		return options;
	}

	@Override
	public UnitProfile getProfile() {
		return profile;
	}

	@Override
	public ProfileDegressif getProfileDegressif() {
		return degressif;
	}

}
