package armybuilder.model.skaven;

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

public enum SkavenUnitModel implements IUnitModel<SkavenUnitModel> {

	PropheteGrisSurClocheHurlante(
			Arrays.asList(SkavenWeapons.BatonDeMalepierre, SkavenWeapons.GriffesEtDentsDechiqueteuses,
					SkavenWeapons.PiquesRouillees),
			new ProfileDegressif("Mouvement", "Piques Rouillées", "Avalanche d'Énergie")
					.add("0-6", "6\"", "6", "Lancement +2 / Récitation +1")
					.add("7-9", "5\"", "5", "Lancement +1 / Récitation +1")
					.add("10-12", "4\"", "4", "Lancement +1 / Récitation 0")
					.add("13+", "3\"", "3", "Lancement 0 / Récitation 0"),
			Arrays.asList(GeneriqueUnitRule.Sorcier_2_2, SkavenRule.PousseeVersLaBataille,
					SkavenRule.AutelDuGrandRatCornu, SkavenRule.AvalancheDEnergie, SkavenRule.CarillonFuneste,
					SkavenRule.RemousParDelaLeVoile, SkavenRule.AppelDesCrevasses)),

	PropheteGris(
			Arrays.asList(SkavenWeapons.BatonDeMalepierre),
			null,
			Arrays.asList(GeneriqueUnitRule.Sorcier_2_2, SkavenRule.FragmentsDeMalepierre, SkavenRule.Fletrissement)),

	Griffarque(Arrays.asList(SkavenWeapons.LameDeMalepierre), null,
			Arrays.asList(SkavenRule.FureurCernee, SkavenRule.RongezRongezLeursOs)),

	RatsDesClans(Arrays.asList(), null, Arrays.asList(SkavenRule.NueeGrouillante)),
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

	private SkavenUnitModel(List<IUnitWeapon> weapons, ProfileDegressif profileDegressif, List<IRule<?>> rules) {
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
		return name;
	}

	@Override
	public boolean availableFor(Army army) {
		return army.is(Allegiance.Skaven);
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
		return profileDegressif;
	}

}
