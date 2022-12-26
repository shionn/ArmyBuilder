package armybuilder.model.nighthaunt;

import java.util.Arrays;
import java.util.List;

import org.apache.commons.collections.ListUtils;

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



	// LADY Olynder (Arrays.asList(), Arrays.asList()),

	KurdossValentian(Arrays.asList(NighthauntUnitWeapon.SceptreSepulcral, NighthauntUnitWeapon.GriffesSpectrales),
			Arrays.asList(NighthauntRule.SiJeNePeuxRegnerNulNeLePourra)),
	ReikenorLeSombreChantre(
			Arrays.asList(NighthauntUnitWeapon.Aprefauche, NighthauntUnitWeapon.SabotsEtDentsFantomatiquesReikenor),
			Arrays.asList(GeneriqueUnitRule.Sorcier_1_1, NighthauntRule.BougiesDeCadavre,
					NighthauntRule.JusticeFuneste, NighthauntRule.TempeteSpectrale)),
//	TODO Scribot Mortis(Arrays.asList(), Arrays.asList()),
	ChevalierDesSuaires(Arrays.asList(NighthauntUnitWeapon.EpeeDesHeuresVolees),
			Arrays.asList(NighthauntRule.HeuresVolees, NighthauntRule.ContremaitreSpectral)),
	ChevalierDesSuairesSurCoursierEthere(Arrays.asList(NighthauntUnitWeapon.EpeeDesHeuresVolees,
			NighthauntUnitWeapon.SabotsEtDentsFantomatiquesSuaires),
			Arrays.asList(NighthauntRule.HeuresVolees, NighthauntRule.SeigneurDesSpectres)),
	EcumeurAffrelame(
			Arrays.asList(NighthauntUnitWeapon.Affrelame, NighthauntUnitWeapon.SabotsEtDentsFantomatiquesEcumeur),
			Arrays.asList(NighthauntRule.Dematerialisation, NighthauntRule.MaledictionDeLoyaute)),
	SeigneurBourreau(Arrays.asList(NighthauntUnitWeapon.GrandeHacheDeDecapitation),
			Arrays.asList(NighthauntRule.FaireFaceALaMort, NighthauntRule.CranesDesincarnes)),
	GardienDesAmes(Arrays.asList(NighthauntUnitWeapon.LameDeFrisson),
			Arrays.asList(GeneriqueUnitRule.Sorcier_1_1, NighthauntRule.LanterneDeCauchemar,
					NighthauntRule.LeurreSpectral)),
	EspritTourmenteur(Arrays.asList(NighthauntUnitWeapon.ChainesBagnespectre),
			Arrays.asList(NighthauntRule.EnergieDAmesCaptives)),
	ManesEnchaines(
			Arrays.asList(NighthauntUnitWeapon.FleauxSpectrauxProjectil, NighthauntUnitWeapon.FleauxSpectrauxMelee),
			Arrays.asList(NighthauntRule.UnMaillonDeLaChaine)),
	BansheeDesTertres(Arrays.asList(NighthauntUnitWeapon.CriPerçant, NighthauntUnitWeapon.DagueDeFrisson),
			Arrays.asList(NighthauntRule.HurlementFunebre)),
	SpectreDesCairns(Arrays.asList(NighthauntUnitWeapon.FauxDeGrandCairn),
			Arrays.asList(NighthauntRule.PourvoyeursDeMortEffrenes)),

	FaucheursMornemanes(Arrays.asList(NighthauntUnitWeapon.FauxDEstafier),
			Arrays.asList(NighthauntRule.FauchesCommeLesBles)),
	Raclechaines(Arrays.asList(NighthauntUnitWeapon.ArmeDeMalfaisant), Arrays.asList(NighthauntRule.HordeEffroyable)),
	RevenantsLamemanes(
			Arrays.asList(NighthauntUnitWeapon.GrandeLameDeLaTombe),
			Arrays.asList(GeneriqueUnitRule.Elite, NighthauntRule.MortTourbillonnante)),
	RodeursHastespectres(
			Arrays.asList(NighthauntUnitWeapon.VougeDeChasseur),
			Arrays.asList(GeneriqueUnitRule.Elite, NighthauntRule.LaPointeDeLaMort)),
	NueesDEsprits(
			Arrays.asList(NighthauntUnitWeapon.GriffesEtDaguesSpectrales),
			Arrays.asList(GeneriqueUnitRule.Elite, NighthauntRule.AttireesParLaGuerre)),
	BansheesDolentes(
			Arrays.asList(NighthauntUnitWeapon.DagueDeFrisson),
			Arrays.asList(GeneriqueUnitRule.Elite, NighthauntRule.MangeSorts)),
	CarognesFaucheuses(
			Arrays.asList(NighthauntUnitWeapon.MembresFaucheurs),
			Arrays.asList(NighthauntRule.SoifDeSangMeurtriere, NighthauntRule.HurlementPerturbant)),
	Sorcespectres(
			Arrays.asList(NighthauntUnitWeapon.FauxSpectrale, NighthauntUnitWeapon.DentsEtSabots),
			Arrays.asList(NighthauntRule.ProgressionFantomatique, NighthauntRule.ChasseursSpectraux)),

	;

	private String name;
	private int pts;
	private UnitProfile profile;
	private List<RoleTactique> roles;
	private List<IUnitWeapon> weapons;
	private List<KeyWord> keywords;
	private List<IRule<?>> rules;
	private List<UnitOptionCategory> options;

	@SuppressWarnings("unchecked")
	private NighthauntUnitModel(List<IUnitWeapon> weapons, List<IRule<?>> rules) {
		this.name = EnumPropertyLoader.instance().name(this);
		this.pts = EnumPropertyLoader.instance().pts(this);
		this.roles = EnumPropertyLoader.instance().roles(this);
		this.profile = EnumPropertyLoader.instance().profile(this);
		this.keywords = EnumPropertyLoader.instance().keywords(this);
		this.options = EnumPropertyLoader.instance().options(this);
		this.weapons = weapons;
		this.rules = ListUtils.sum(Arrays.asList(GeneriqueUnitRule.Vol), rules);
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
		return null;
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
