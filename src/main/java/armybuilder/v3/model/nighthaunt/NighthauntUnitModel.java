package armybuilder.v3.model.nighthaunt;

import java.util.Arrays;
import java.util.List;

import org.apache.commons.collections.ListUtils;

import armybuilder.v3.model.army.Allegiance;
import armybuilder.v3.model.army.Army;
import armybuilder.v3.model.rule.GeneriqueUnitRule;
import armybuilder.v3.model.rule.IRule;
import armybuilder.v3.model.unit.ProfileDegressif;
import armybuilder.v3.model.unit.UnitProfile;
import armybuilder.v3.model.unit.keyword.KeyWord;
import armybuilder.v3.model.unit.model.IUnitModel;
import armybuilder.v3.model.unit.option.UnitOptionCategory;
import armybuilder.v3.model.unit.role.RoleTactique;
import armybuilder.v3.model.unit.weapon.IUnitWeapon;
import armybuilder.v3.serialisation.EnumPropertyLoader;

public enum NighthauntUnitModel implements IUnitModel<NighthauntUnitModel> {

	DameOlynder(
			Arrays.asList(NighthauntUnitWeapon.BatonDeMinuit, NighthauntUnitWeapon.GriffesSpectrales),
			Arrays.asList(GeneriqueUnitRule.Sorcier_2_2, GeneriqueUnitRule.MaitreDeGuerre, NighthauntRule.SablesDuTemps,
					NighthauntRule.PasDeRepitPourLesDamnees, NighthauntRule.MortarqueDuDeuil,
					NighthauntRule.ReleverLeVoile, NighthauntRule.SuaireDeDesespoir)),

	KurdossValentian(
			Arrays.asList(NighthauntUnitWeapon.SceptreSepulcral, NighthauntUnitWeapon.GriffesSpectrales),
			Arrays.asList(NighthauntRule.SiJeNePeuxRegnerNulNeLePourra)),
	ReikenorLeSombreChantre(
			Arrays.asList(NighthauntUnitWeapon.Aprefauche, NighthauntUnitWeapon.SabotsEtDentsFantomatiquesReikenor),
			Arrays.asList(GeneriqueUnitRule.Sorcier_1_1, NighthauntRule.BougiesDeCadavre, NighthauntRule.JusticeFuneste,
					NighthauntRule.TempeteSpectrale)),
//	TODO Scribot Mortis(Arrays.asList(), Arrays.asList()),
	ChevalierDesSuaires(
			Arrays.asList(NighthauntUnitWeapon.EpeeDesHeuresVolees),
			Arrays.asList(NighthauntRule.HeuresVolees, NighthauntRule.ContremaitreSpectral_1,
					NighthauntRule.ContremaitreSpectral_2)),
	ChevalierDesSuairesSurCoursierEthere(
			Arrays.asList(NighthauntUnitWeapon.EpeeDesHeuresVolees,
					NighthauntUnitWeapon.SabotsEtDentsFantomatiquesSuaires),
			Arrays.asList(NighthauntRule.HeuresVolees, NighthauntRule.SeigneurDesSpectres_1,
					NighthauntRule.SeigneurDesSpectres_2)),
	EcumeurAffrelame(
			Arrays.asList(NighthauntUnitWeapon.Affrelame, NighthauntUnitWeapon.SabotsEtDentsFantomatiquesEcumeur),
			Arrays.asList(NighthauntRule.Dematerialisation, NighthauntRule.MaledictionDeLoyaute)),
	SeigneurBourreau(
			Arrays.asList(NighthauntUnitWeapon.GrandeHacheDeDecapitation),
			Arrays.asList(NighthauntRule.FaireFaceALaMort, NighthauntRule.CranesDesincarnes)),
	GardienDesAmes(
			Arrays.asList(NighthauntUnitWeapon.LameDeFrisson),
			Arrays.asList(GeneriqueUnitRule.Sorcier_1_1, NighthauntRule.LanterneDeCauchemar,
					NighthauntRule.LeurreSpectral)),
	EspritTourmenteur(
			Arrays.asList(NighthauntUnitWeapon.ChainesBagnespectre),
			Arrays.asList(NighthauntRule.EnergieDAmesCaptives)),
	ManesEnchaines(
			Arrays.asList(NighthauntUnitWeapon.FleauxSpectrauxProjectil, NighthauntUnitWeapon.FleauxSpectrauxMelee),
			Arrays.asList(NighthauntRule.UnMaillonDeLaChaine)),
	BansheeDesTertres(
			Arrays.asList(NighthauntUnitWeapon.CriPerçant, NighthauntUnitWeapon.DagueDeFrisson),
			Arrays.asList(NighthauntRule.HurlementFunebre)),
	SpectreDesCairns(
			Arrays.asList(NighthauntUnitWeapon.FauxDeGrandCairn),
			Arrays.asList(NighthauntRule.PourvoyeursDeMortEffrenes)),

	FaucheursMornemanes(
			Arrays.asList(NighthauntUnitWeapon.FauxDEstafier),
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
