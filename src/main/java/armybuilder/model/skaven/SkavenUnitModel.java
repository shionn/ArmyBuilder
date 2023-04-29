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

	// maitre clan
	PropheteGris(
			Arrays.asList(SkavenWeapons.BatonDeMalepierre),
			null,
			Arrays.asList(GeneriqueUnitRule.Sorcier_2_2, SkavenRule.FragmentsDeMalepierre, SkavenRule.Fletrissement)),
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

	// verminus
	Griffarque(Arrays.asList(SkavenWeapons.LameDeMalepierre), null,
			Arrays.asList(SkavenRule.FureurCernee, SkavenRule.RongezRongezLeursOs)),
	RatsDesClans(Arrays.asList(), null, Arrays.asList(SkavenRule.NueeGrouillante)),
	VerminesDeChoc(
			Arrays.asList(SkavenWeapons.HallebardeRouillee),
			null,
			Arrays.asList(SkavenRule.GardesDuCorpsDElite)),

	// skryre
	IngenieurTechnomage(
			Arrays.asList(SkavenWeapons.PistoletAMalepierre, SkavenWeapons.LameAMalenergie),
			null,
			Arrays.asList(GeneriqueUnitRule.Sorcier_1_1, SkavenRule.Malefoudre)),
	CanonAMalefoudre(
			Arrays.asList(SkavenWeapons.DechargeDeMalefoudre),
			null,
			Arrays.asList(SkavenRule.DechargeDeMalefoudre, SkavenRule.PlusPlusDeMalefoudre)),
	CanonRatling(
			Arrays.asList(SkavenWeapons.CanonsRatlings_EA, SkavenWeapons.PoignardsRouilles),
			null,
			Arrays.asList(SkavenRule.PlusPlusDeMaleplomb, SkavenRule.ServantsDArmeCaches)),
	LanceFeu(
			Arrays.asList(SkavenWeapons.LanceFeu, SkavenWeapons.PoignardsRouilles),
			null,
			Arrays.asList(SkavenRule.LanceFeu, SkavenRule.PlusPlusDeMaleflammes, SkavenRule.ServantsDArmeCaches)),

	// skryre & Moulder
	ColossesDeChoc(Arrays.asList(), null, Arrays.asList(GeneriqueUnitRule.Elite)),

	// sans clans
	TrouDeVermine(
			Arrays.asList(),
			null,
			Arrays.asList(GeneriqueUnitRule.Infranchissable, SkavenRule.TunnelsDansLaRealite,
					SkavenRule.AuraDuGrandRatCornu)),
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
