package armybuilder.v3.model.skaven;

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
import lombok.Getter;

@Getter
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
			Arrays.asList(GeneriqueUnitRule.Sorcier_2_2,
					SkavenRule.AutelDuGrandRatCornu, SkavenRule.AvalancheDEnergie, SkavenRule.CarillonFuneste,
					SkavenRule.RemousParDelaLeVoile, SkavenRule.AppelDesCrevasses)),

	VerminarqueMaleprophete(
			Arrays.asList(SkavenWeapons.QueuesPrehensibles, SkavenWeapons.VougeDeRuine),
			new ProfileDegressif("Mouvement", "Queues Préhensible", "Vouge de Ruine").add("0-6", "12", "4", "2+")
					.add("7-8", "10", "3", "2+")
					.add("9-10", "8", "2", "3+")
					.add("11+", "6", "1", "4+"),
			Arrays.asList(GeneriqueUnitRule.Sorcier_2_2, SkavenRule.ProtectionduRatCornu,
					SkavenRule.LesGrandsManipulateurs, SkavenRule.OrbeDevin, SkavenRule.EnAvantEnfantsDuRatCornu,
					SkavenRule.RedoutableMaletornade)),

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
			Arrays.asList(SkavenWeapons.DechargeDeMalefoudre, SkavenWeapons.CrocsEtPoignards),
			null,
			Arrays.asList(SkavenRule.DechargeDeMalefoudre, SkavenRule.PlusPlusDeMalefoudre)),
	CanonRatling(
			Arrays.asList(SkavenWeapons.CanonsRatlings_EA, SkavenWeapons.PoignardsRouilles),
			null,
			Arrays.asList(SkavenRule.PlusPlusDeMaleplomb, SkavenRule.ServantsDArmeCachesDeploiement,
					SkavenRule.ServantsDArmeCachesTir)),
	LanceFeu(
			Arrays.asList(SkavenWeapons.LanceFeu, SkavenWeapons.PoignardsRouilles),
			null,
			Arrays.asList(SkavenRule.LanceFeu, SkavenRule.PlusPlusDeMaleflammes,
					SkavenRule.ServantsDArmeCachesDeploiement, SkavenRule.ServantsDArmeCachesTir)),
	RoueInfernale(
			Arrays.asList(SkavenWeapons.TraitsDeMalefoudre, SkavenWeapons.RoueBroyeuse,
					SkavenWeapons.CrocsEtPoignards_Roue),
			null,
			Arrays.asList(SkavenRule.MortRoulante, SkavenRule.PlusPlusDeVitesse, SkavenRule.PlusPlusDEclairs)),

	// skryre & Moulder
	ColossesDeChoc(Arrays.asList(), null, Arrays.asList(GeneriqueUnitRule.Elite)),

	// Moulder
	MaitreMoulder(
			Arrays.asList(),
			null,
			Arrays.asList(SkavenRule.MaitreModeleur, SkavenRule.FaireClaquerLeFouet, SkavenRule.LachezPlusPlusDeBetes)),
	RatsOgors(
			Arrays.asList(SkavenWeapons.CanonAMaleflamme, SkavenWeapons.GriffesLamesEtDentsDechiqueteuses),
			null,
			Arrays.asList(SkavenRule.FureurEnragee)),
	AbominationDeMalefosse(
			Arrays.asList(SkavenWeapons.AvalancheDeChair, SkavenWeapons.DentsRongeuses, SkavenWeapons.PoingsFléaux),
			new ProfileDegressif(SkavenWeapons.DentsRongeuses, SkavenWeapons.PoingsFléaux, SkavenRule.AvalancheDeChair)
					.add("0-6", "-3", "6", "2+")
					.add("7-8", "-3", "5", "3+")
					.add("9-10", "-2", "4", "4+")
					.add("11+", "-1", "3", "5+"),
			Arrays.asList(SkavenRule.AvalancheDeChair, SkavenRule.MonstruositeRegenerante,
					SkavenRule.PieuxDeMalepierre, SkavenRule.TropHorriblePourMourrir)),

	// Pestilien
	PretreDeLaPeste(
			Arrays.asList(SkavenWeapons.BourdonDeMalepierre, SkavenWeapons.EncensoirAPestilence),
			null,
			Arrays.asList(SkavenRule.AssautFrenetique, SkavenRule.FumeesEmpoisonnees, SkavenRule.PestilencePestilence)),
	PretreDeLaPesteSurCreuset(
			Arrays.asList(SkavenWeapons.GrandEncensoirAPestilence, SkavenWeapons.BourdonDeMalepierre,
					SkavenWeapons.LameFetides_Creuset, SkavenWeapons.PointesRouillees),
			new ProfileDegressif("Mouvement", "Grand Encensoir à Pestilence", "Pointes Rouillées")
					.add("0-6", "6", "D3+4", "6")
					.add("7-9", "5", "D3+3", "5")
					.add("10-12", "4", "D3+2", "4")
					.add("13+", "3", "D3+1", "3"),
			Arrays.asList(SkavenRule.AutelDuGrandRatCornu_Creuset,
					SkavenRule.GrandEncensoirAPestilence, SkavenRule.FumeesEmpoisonnees,
					SkavenRule.PestilencePestilence)),
	MoinesDeLaPeste(
			Arrays.asList(),
			null,
			Arrays.asList(SkavenRule.LivreDesPlaies, SkavenRule.LameFetides, SkavenRule.AssautFrenetique)),
	CatapulteDeLaPeste(
			Arrays.asList(SkavenWeapons.CatapulteDeLaPeste, SkavenWeapons.PoignardsRouilles_Catapulte),
			null,
			Arrays.asList(SkavenRule.BarrageDeContagion, SkavenRule.MortAtroce)),

	// eshin
	MaitreMort(
			Arrays.asList(SkavenWeapons.EtoileDeJetEshin, SkavenWeapons.LameSuintante),
			null,
			Arrays.asList(SkavenRule.TueurCacheCombat, SkavenRule.TueurCacheDeploiement, SkavenRule.TueurCacheMort,
					SkavenRule.ToxineEshin, SkavenRule.LaMortQuiCourt)),

	// sans clans
	TrouDeVermine(
			Arrays.asList(),
			null,
			Arrays.asList(GeneriqueUnitRule.Infranchissable, SkavenRule.PlacementTrouVermines,
					SkavenRule.TunnelsDansLaRealite,
					SkavenRule.AuraDuGrandRatCornu)),

	ClocheDeLApocalypse(
			Arrays.asList(),
			null,
			Arrays.asList(SkavenRule.ClocheDeLApocalypseConvocation, SkavenRule.ClocheDeLApocalypsePredateur,
					SkavenRule.GlasApocalypse, SkavenRule.AudaceOuDesespoir)),
	RazDeVermine(
			Arrays.asList(),
			null,
			Arrays.asList(SkavenRule.RazDeVermineConvocation, SkavenRule.RazDeVerminePredateur,
					SkavenRule.HordeVorace)),

//	KKK(Arrays.asList(), null, Arrays.asList()),
//	LLL(Arrays.asList(), null, Arrays.asList()),

	;

	private String displayName;
	private int points;
	private UnitProfile profile;
	private ProfileDegressif profileDegressif;
	private List<RoleTactique> roleTactiques;
	private List<IUnitWeapon> weapons;
	private List<KeyWord> keyWords;
	private List<IRule<?>> rules;
	private List<UnitOptionCategory> optionsCategories;

	private SkavenUnitModel(List<IUnitWeapon> weapons, ProfileDegressif profileDegressif, List<IRule<?>> rules) {
		this.displayName = EnumPropertyLoader.instance().name(this);
		this.points = EnumPropertyLoader.instance().pts(this);
		this.roleTactiques = EnumPropertyLoader.instance().roles(this);
		this.profile = EnumPropertyLoader.instance().profile(this);
		this.keyWords = EnumPropertyLoader.instance().keywords(this);
		this.optionsCategories = EnumPropertyLoader.instance().options(this);
		this.weapons = weapons;
		this.profileDegressif = profileDegressif;
		this.rules = rules;
	}

	@Override
	public boolean availableFor(Army army) {
		return army.is(Allegiance.Skaven);
	}

}
