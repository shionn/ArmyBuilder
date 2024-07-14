package armybuilder.v3.model.stormcast;

import java.util.Arrays;
import java.util.List;

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

public enum StormcastUnitModel implements IUnitModel<StormcastUnitModel> {

	AstreiaSolbrigh(
			UnitProfile._12_8_10_3,
			Arrays.asList(RoleTactique.Leader),
			Arrays.asList(StormcastWeapons.SceptreDEther, StormcastWeapons.GriffesMonstrueuses),
			null,
			Arrays.asList(GeneriqueUnitRule.Sorcier_1_1, StormcastRule.CycleDeLOrage, StormcastRule.BondTonitruant,
					StormcastRule.EnergieSpirituelleDuPremierOst, StormcastRule.ImpulsionFoudroyante),
			Arrays.asList(UnitOptionCategory.General, UnitOptionCategory.Sort),
			Arrays.asList(KeyWord.Ordre, KeyWord.StormCast, KeyWord.MarteauxDeSigmar, KeyWord.SacroSaint, KeyWord.Heros,
					KeyWord.Sorcier, KeyWord.Dracoline, KeyWord.Seigneur, KeyWord.SeigneurArcanum,
					KeyWord.AstreiaSolbrigh, KeyWord.Unique)),

	// TODO Neave Blacktalon

	SeigneurArcanumSurDracolineCeleste(
			UnitProfile._12_8_9_3,
			Arrays.asList(RoleTactique.Leader),
			Arrays.asList(StormcastWeapons.SceptreDEther, StormcastWeapons.GriffesMonstrueuses),
			null,
			Arrays.asList(GeneriqueUnitRule.Sorcier_1_1, StormcastRule.CycleDeLOrage, StormcastRule.BondTonitruant,
					StormcastRule.AlphaDeLaMeute, StormcastRule.LanceDOrage),
			Arrays.asList(UnitOptionCategory.General, UnitOptionCategory.TraisDeCommandement,
					UnitOptionCategory.Artefact, UnitOptionCategory.TraisDeMonture, UnitOptionCategory.Sort),
			Arrays.asList(KeyWord.Ordre, KeyWord.StormCast, KeyWord.SacroSaint, KeyWord.Heros, KeyWord.Sorcier,
					KeyWord.Dracoline, KeyWord.Seigneur, KeyWord.SeigneurArcanum)),

	SeigneurArcanumSurGryphDestrier(
			UnitProfile._12_8_9_3,
			Arrays.asList(RoleTactique.Leader),
			Arrays.asList(StormcastWeapons.SceptreDEther, StormcastWeapons.GriffesEtBecAcere),
			null,
			Arrays.asList(GeneriqueUnitRule.Sorcier_1_1, StormcastRule.CycleDeLOrage,
					StormcastRule.ChevaucherLesVentsEtheriques, StormcastRule.LumiereGuerisseuse),
			Arrays.asList(UnitOptionCategory.General, UnitOptionCategory.TraisDeCommandement,
					UnitOptionCategory.Artefact, UnitOptionCategory.TraisDeMonture, UnitOptionCategory.Sort),

			Arrays.asList(KeyWord.Ordre, KeyWord.StormCast, KeyWord.SacroSaint, KeyWord.Heros, KeyWord.Sorcier,
					KeyWord.GryphDestrier, KeyWord.Seigneur, KeyWord.SeigneurArcanum)),

	SeigneurImperatant(
			UnitProfile._5_7_9_3,
			Arrays.asList(RoleTactique.Leader),
			Arrays.asList(StormcastWeapons.SceptreFulgurivoque, StormcastWeapons.MarteauDeGuerreBeni,
					StormcastWeapons.BecEtGriffesCruels),
			null,
			Arrays.asList(StormcastRule.ChefEminent, StormcastRule.GuidesParLaFoudre),
			Arrays.asList(UnitOptionCategory.General, UnitOptionCategory.TraisDeCommandement,
					UnitOptionCategory.Artefact),
			Arrays.asList(KeyWord.Ordre, KeyWord.StormCast, KeyWord.Heros, KeyWord.Fulgurant, KeyWord.Seigneur,
					KeyWord.SeigneurImperatant)),

	SeigneurRelictor(
			UnitProfile._5_6_9_3,
			Arrays.asList(RoleTactique.Leader),
			Arrays.asList(StormcastWeapons.MarteauRelique),
			null,
			Arrays.asList(StormcastRule.PretreMortis, StormcastRule.OrageGuerisseur, StormcastRule.OrageFoudroyant),
			Arrays.asList(UnitOptionCategory.General, UnitOptionCategory.TraisDeCommandement,
					UnitOptionCategory.Artefact, UnitOptionCategory.Priere),
			Arrays.asList(KeyWord.Ordre, KeyWord.StormCast, KeyWord.Heros, KeyWord.Pretre, KeyWord.Totem,
					KeyWord.Seigneur, KeyWord.SeigneurRelictor)),

	SeigneurExorciste(
			UnitProfile._5_6_9_3,
			Arrays.asList(RoleTactique.Leader),
			Arrays.asList(StormcastWeapons.SceptreDeRedemption),
			null,
			Arrays.asList(GeneriqueUnitRule.Sorcier_1_1, StormcastRule.CoffretRedempteur,
					StormcastRule.SoufflePurificateur),
			Arrays.asList(UnitOptionCategory.General, UnitOptionCategory.TraisDeCommandement,
					UnitOptionCategory.Artefact, UnitOptionCategory.Sort),
			Arrays.asList(KeyWord.Ordre, KeyWord.StormCast, KeyWord.Heros, KeyWord.SacroSaint, KeyWord.Seigneur,
					KeyWord.SeigneurExorciste)),

	SeigneurOrdinator(
			UnitProfile._5_6_9_3,
			Arrays.asList(RoleTactique.Leader),
			Arrays.asList(),
			null,
			Arrays.asList(StormcastRule.IngenieurCabaliste, StormcastRule.FrappeDeComete),
			Arrays.asList(UnitOptionCategory.General, UnitOptionCategory.TraisDeCommandement,
					UnitOptionCategory.Artefact, UnitOptionCategory.Armes),
			Arrays.asList(KeyWord.Ordre, KeyWord.StormCast, KeyWord.Heros, KeyWord.SacroSaint, KeyWord.Seigneur,
					KeyWord.SeigneurOrdinator)),

	ChevalierVexillorAvecBanniereDeLApotheose(
			UnitProfile._5_6_8_3,
			Arrays.asList(RoleTactique.Leader),
			Arrays.asList(StormcastWeapons.LameDeGuerreDeSigmarite),
			null,
			Arrays.asList(StormcastRule.LaBanniereDesReforges, StormcastRule.IconeGalvanisante),
			Arrays.asList(UnitOptionCategory.General, UnitOptionCategory.TraisDeCommandement,
					UnitOptionCategory.Artefact),
			Arrays.asList(KeyWord.Ordre, KeyWord.StormCast, KeyWord.Heros, KeyWord.Fulgurant, KeyWord.Totem,
					KeyWord.Chevalier, KeyWord.ChevalierVexillor, KeyWord.ChevalierVexillorAvecBanniereDeLApotheose)),

	ChevalierAzyros(
			UnitProfile._12_5_8_3,
			Arrays.asList(RoleTactique.Leader),
			Arrays.asList(StormcastWeapons.LameStellaire),
			null,
			Arrays.asList(GeneriqueUnitRule.Vol, StormcastRule.LaLumiereDeSigmar),
			Arrays.asList(UnitOptionCategory.General, UnitOptionCategory.TraisDeCommandement,
					UnitOptionCategory.Artefact),
			Arrays.asList(KeyWord.Ordre, KeyWord.StormCast, KeyWord.Heros, KeyWord.Totem, KeyWord.Chevalier,
					KeyWord.ChevalierAzyros)),

	ChevalierArcanum(
			UnitProfile._5_6_8_3,
			Arrays.asList(RoleTactique.Leader),
			Arrays.asList(StormcastWeapons.SceptreDuValedictor),
			null,
			Arrays.asList(GeneriqueUnitRule.Sorcier_1_1, StormcastRule.ChercheursMystiquesIndomptables,
					StormcastRule.FlamboiementDesCieux),
			Arrays.asList(UnitOptionCategory.General, UnitOptionCategory.TraisDeCommandement, UnitOptionCategory.Sort,
					UnitOptionCategory.Artefact),
			Arrays.asList(KeyWord.Ordre, KeyWord.StormCast, KeyWord.Heros, KeyWord.Fulgurant, KeyWord.Sorcier,
					KeyWord.Chevalier, KeyWord.ChevalierArcanum)),

	ChevalierIncantator(
			UnitProfile._5_5_8_3,
			Arrays.asList(RoleTactique.Leader),
			Arrays.asList(StormcastWeapons.BatondIncantor),
			null,
			Arrays.asList(GeneriqueUnitRule.Sorcier_1_1, StormcastRule.ParcheminDOrageNegatif,
					StormcastRule.OrageSpirituel),
			Arrays.asList(UnitOptionCategory.General, UnitOptionCategory.TraisDeCommandement, UnitOptionCategory.Sort,
					UnitOptionCategory.Artefact),
			Arrays.asList(KeyWord.Ordre, KeyWord.StormCast, KeyWord.Heros, KeyWord.SacroSaint, KeyWord.Sorcier,
					KeyWord.Chevalier, KeyWord.ChevalierIncantator)),

	// TODO chevalier zephirois

	ChevalierQuestor(
			UnitProfile._5_5_8_3,
			Arrays.asList(RoleTactique.Leader),
			Arrays.asList(StormcastWeapons.LameDeQuestor),
			null,
			Arrays.asList(StormcastRule.FrappeFulguree, StormcastRule.DefiHeroique),
			Arrays.asList(UnitOptionCategory.General, UnitOptionCategory.TraisDeCommandement,
					UnitOptionCategory.Artefact),
			Arrays.asList(KeyWord.Ordre, KeyWord.StormCast, KeyWord.Heros, KeyWord.Chevalier,
					KeyWord.ChevalierQuestor)),

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

	RaptorsDAvantGardeAvecArbaletesLonguefrappe(UnitProfile._5_2_7_4, Arrays.asList(RoleTactique.Elite),
			Arrays.asList(StormcastWeapons.ArbaleteLonguefrappe, StormcastWeapons.LourdeCrosse), null,
			Arrays.asList(StormcastRule.TirALaTete),
			Arrays.asList(UnitOptionCategory.Chef, UnitOptionCategory.Renforcees),
			Arrays.asList(KeyWord.Ordre, KeyWord.StormCast, KeyWord.Justicar, KeyWord.RaptorsDAvantGarde,
					KeyWord.RaptorsDAvantGardeAvecArbaletesLonguefrappe)),

	Etherviers(UnitProfile._12_2_6_Dash, Arrays.asList(RoleTactique.Elite),
			Arrays.asList(StormcastWeapons.BecEtSerres), null,
			Arrays.asList(StormcastRule.ChasseursEnPique, StormcastRule.VoueALaDestruction),
			Arrays.asList(UnitOptionCategory.Renforcees),
			Arrays.asList(KeyWord.Ordre, KeyWord.StormCast, KeyWord.Etherviers)),

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

	Annihilators(
			UnitProfile._4_3_7_2,
			Arrays.asList(RoleTactique.Elite),
			Arrays.asList(StormcastWeapons.MarteauMeteorique),
			null,
			Arrays.asList(StormcastRule.ImpactFlamboyant, StormcastRule.LaForceDUneEtoileFilante),
			Arrays.asList(UnitOptionCategory.Chef, UnitOptionCategory.Renforcees),
			Arrays.asList(KeyWord.Ordre, KeyWord.StormCast, KeyWord.Fulgurant, KeyWord.Paladin, KeyWord.Annihilators)),

	Retributors(
			UnitProfile._4_3_7_3,
			Arrays.asList(RoleTactique.Elite),
			Arrays.asList(StormcastWeapons.MarteauDeFoudre, StormcastWeapons.MasseDAsterie),
			null,
			Arrays.asList(StormcastRule.MasseDAsterie, StormcastRule.ReduitsEnCendres),
			Arrays.asList(UnitOptionCategory.Chef, UnitOptionCategory.Renforcees),
			Arrays.asList(KeyWord.Ordre, KeyWord.StormCast, KeyWord.Paladin, KeyWord.Retributors)),

	Praetors(
			UnitProfile._4_3_8_3,
			Arrays.asList(RoleTactique.Elite),
			Arrays.asList(StormcastWeapons.HallebardeDeGardeDesAmes),
			null,
			Arrays.asList(StormcastRule.GardiensAuxAmesSoudees),
			Arrays.asList(UnitOptionCategory.Chef, UnitOptionCategory.Renforcees),
			Arrays.asList(KeyWord.Ordre, KeyWord.StormCast, KeyWord.Fulgurant, KeyWord.Praetors)),

	EvocatorsSurDracolinesCelestes(
			UnitProfile._12_5_8_4,
			Arrays.asList(RoleTactique.Elite),
			Arrays.asList(StormcastWeapons.LameTempeteEtSceptreDOrage, StormcastWeapons.GrandSceptreEvocatorDracoline,
					StormcastWeapons.GriffesMonstrueuses),
			null,
			Arrays.asList(StormcastRule.SorcierEvocators, StormcastRule.ArcsDeFoudreCeleste,
					StormcastRule.BondTonitruant, StormcastRule.Essor),
			Arrays.asList(UnitOptionCategory.Chef, UnitOptionCategory.Renforcees),
			Arrays.asList(KeyWord.Ordre, KeyWord.StormCast, KeyWord.SacroSaint, KeyWord.Corpuscant, KeyWord.Dracoline,
					KeyWord.Evocators)),

	Evocators(
			UnitProfile._5_3_8_4,
			Arrays.asList(RoleTactique.Elite),
			Arrays.asList(StormcastWeapons.LameTempeteEtSceptreDOrage, StormcastWeapons.GrandSceptre),
			null,
			Arrays.asList(StormcastRule.SorcierEvocators, StormcastRule.ArcsDeFoudreCeleste, StormcastRule.Essor),
			Arrays.asList(UnitOptionCategory.Chef, UnitOptionCategory.Renforcees),
			Arrays.asList(KeyWord.Ordre, KeyWord.StormCast, KeyWord.SacroSaint, KeyWord.Corpuscant, KeyWord.Evocators)),

	BalisteCelestar(
			UnitProfile._3_9_7_4,
			Arrays.asList(RoleTactique.Artillerie),
			Arrays.asList(StormcastWeapons.TraitsDeCelestarTirFoudroyant, StormcastWeapons.TraitsDeCelestarTirRapide,
					StormcastWeapons.LamesDeSigmarite),
			null,
			Arrays.asList(StormcastRule.ArmePolyvalente),
			Arrays.asList(),
			Arrays.asList(KeyWord.Ordre, KeyWord.StormCast, KeyWord.SacroSaint, KeyWord.Ordinatus,
					KeyWord.MachineDeGuerre, KeyWord.BalisteCelestar)),

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
