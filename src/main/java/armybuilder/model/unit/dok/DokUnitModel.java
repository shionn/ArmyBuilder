package armybuilder.model.unit.dok;

import java.util.Arrays;
import java.util.List;

import armybuilder.model.rule.DokRule;
import armybuilder.model.rule.GeneriqueRule;
import armybuilder.model.rule.GeneriqueUnitRule;
import armybuilder.model.rule.IArmyRule;
import armybuilder.model.unit.IUnitModel;
import armybuilder.model.unit.IUnitWeapon;
import armybuilder.model.unit.KeyWord;
import armybuilder.model.unit.ProfileDegressif;
import armybuilder.model.unit.RoleTatcique;
import armybuilder.model.unit.UnitProfile;

public enum DokUnitModel implements IUnitModel {

	MorathiKhaine(
			"Morathi-Khaine",
			330,
			UnitProfile._6_6_8_4,
			Arrays.asList(RoleTatcique.Leader),
			Arrays.asList(DokUnitWeapon.EcorcheCoeur, DokUnitWeapon.AilesLamees),
			null,
			Arrays.asList(DokRule.DeuxCorpsUneSeuleAme, DokRule.PresenceIntimidante,
					GeneriqueRule.TraitMagique, GeneriqueRule.BouclierMystique,
					DokRule.HorreurNoireDUlgu, DokRule.VenerationParLeSang,
					GeneriqueUnitRule.Sorcier_3_2_1),
			Arrays.asList(KeyWord.Ordre, KeyWord.Aelf, KeyWord.DaughtersOfKhaine, KeyWord.Heros,
					KeyWord.Sorcier, KeyWord.MorathiKhaine, KeyWord.Unique)),
	LaShadowQueen(
			"La Shadow Queen",
			330,
			UnitProfile._S_12_10_4,
			Arrays.asList(RoleTatcique.Leader, RoleTatcique.Behemoth),
			Arrays.asList(DokUnitWeapon.RegardDeLaReineDeLOmbre, DokUnitWeapon.EcorcheCoeur_Shadow,
					DokUnitWeapon.CouronneDeSerpents, DokUnitWeapon.QueueVenimeuse),
			new ProfileDegressif("Mouvement", DokUnitWeapon.EcorcheCoeur_Shadow.getDisplayName(),
					DokUnitWeapon.QueueVenimeuse.getDisplayName()).add("0-3", "14", "8", "6")
							.add("4-6", "12", "7", "5").add("7-8", "10", "6", "4")
							.add("9-10", "8", "5", "3").add("11+", "6", "4", "2"),
			Arrays.asList(GeneriqueUnitRule.Vol, DokRule.FureurDeLaReineDeLOmbre,
					DokRule.DeuxCorpsUneSeuleAme_Shadow, DokRule.CoeurDeFerDeKhaine),
			Arrays.asList(KeyWord.Ordre, KeyWord.Aelf, KeyWord.DaughtersOfKhaine, KeyWord.Monstre,
					KeyWord.Heros, KeyWord.LaShadowQueen, KeyWord.Unique)),

	BloodwrackShrine(
			"Bloodwrack Shrine",
			190,
			UnitProfile._S_13_8_5,
			Arrays.asList(RoleTatcique.Leader, RoleTatcique.Behemoth),
			Arrays.asList(DokUnitWeapon.RegardIncarnat, DokUnitWeapon.LanceIncarnate,
					DokUnitWeapon.Aiguillons, DokUnitWeapon.GriffeMurmure,
					DokUnitWeapon.QueueDeSerpents),
			new ProfileDegressif("Mouvement", DokUnitWeapon.Aiguillons.getDisplayName(),
					DokRule.AuraDAgonie.getDisplayName()).add("0-3", "6", "6", "2+")
							.add("4-6", "5", "5", "3+").add("7-10", "4", "4", "4+")
							.add("11+", "3", "3", "5+"),
			Arrays.asList(DokRule.AuraDAgonie, DokRule.ImpactLame, DokRule.RegardIncarnat,
					DokRule.GriffeMurmure, DokRule.Deperissement, GeneriqueRule.TraitMagique,
					GeneriqueRule.BouclierMystique, GeneriqueUnitRule.Sorcier_1_2),
			Arrays.asList(KeyWord.Ordre, KeyWord.Aelf, KeyWord.DaughtersOfKhaine, KeyWord.Melusai,
					KeyWord.Heros, KeyWord.Sorcier, KeyWord.Totem, KeyWord.BloodwrackMedusa,
					KeyWord.BloodwrackShrine)),

	MelusaiIronscale(
			"Melusai Ironscale",
			115,
			UnitProfile._8_6_9_5,
			Arrays.asList(RoleTatcique.Leader),
			Arrays.asList(DokUnitWeapon.Keldrisaith_Projectil, DokUnitWeapon.Keldrisaith_Melee),
			null,
			Arrays.asList(DokRule.SangDeLOracle, DokRule.OffrandeSanguinolente,
					DokRule.TransmuteEnCristal, DokRule.ColereDesMoirenees),
			Arrays.asList(KeyWord.Ordre, KeyWord.DaughtersOfKhaine, KeyWord.Melusai, KeyWord.Heros,
					KeyWord.MelusaiIronscale)),

	MorgwaethTheBloodied(
			"Morgwaeth the Bloodied",
			175,
			UnitProfile._6_1_7_6,
			Arrays.asList(RoleTatcique.Leader),
			Arrays.asList(DokUnitWeapon.VougeDeKhaine),
			null,
			Arrays.asList(DokRule.RuneDeKhaine_Priere, DokRule.BrouetDeSang),
			Arrays.asList(KeyWord.Ordre, KeyWord.Aelf, KeyWord.DaughtersOfKhaine, KeyWord.HaggNar,
					KeyWord.Heros, KeyWord.Pretre, KeyWord.HagQueen, KeyWord.MorgwaethTheBloodied)),

	LeBladeCoven(
			"Le Blade-Coven",
			0,
			UnitProfile._6_1_7_6,
			Arrays.asList(RoleTatcique.None),
			Arrays.asList(DokUnitWeapon.ArcCherchecoeur, DokUnitWeapon.ArmesSacrificielles),
			null,
			Arrays.asList(DokRule.Cherchecoeurs, DokRule.ZelotesDuPremierTemple),
			Arrays.asList(KeyWord.Ordre, KeyWord.Aelf, KeyWord.DaughtersOfKhaine, KeyWord.Melusai,
					KeyWord.DaughtersOfKhaine, KeyWord.HaggNar, KeyWord.LaBladeCoven)),

	SlaughterQueen(
			"Slaughter Queen",
			120,
			UnitProfile._6_5_8_5,
			Arrays.asList(RoleTatcique.Leader),
			Arrays.asList(DokUnitWeapon.EpeeDeMort, DokUnitWeapon.LameDeKhaine),
			null,
			Arrays.asList(DokRule.DanseDAgonie, DokRule.RuneDeKhaine_Priere,
					DokRule.CaresseDeLaMort, DokRule.OrgieDeMassacre),
			Arrays.asList(KeyWord.Ordre, KeyWord.Aelf, KeyWord.DaughtersOfKhaine, KeyWord.Heros,
					KeyWord.Pretre, KeyWord.SlaughterQueen)),

	WitchAelves(
			"Witch Aelves",
			120,
			UnitProfile._6_1_7_6,
			Arrays.asList(RoleTatcique.Ligne),
			Arrays.asList(DokUnitWeapon.CouteauOuCouteauxSacrificiels),
			null,
			Arrays.asList(DokRule.FerveurFrenetique),
			Arrays.asList(KeyWord.Ordre, KeyWord.Aelf, KeyWord.DaughtersOfKhaine,
					KeyWord.WitchAelves))

	;

	private String displayName;
	private int value;
	private UnitProfile profile;
	private List<IUnitWeapon> weapons;
	private ProfileDegressif profileDegressif;
	private List<IArmyRule<?>> rules;
	private List<KeyWord> keyWords;
	private List<RoleTatcique> roleTactiques;

	private DokUnitModel(String displayName, int value, UnitProfile profile,
			List<RoleTatcique> roleTactiques, List<IUnitWeapon> weapons,
			ProfileDegressif profileDegressif, List<IArmyRule<?>> rules, List<KeyWord> keyWords) {
		this.displayName = displayName;
		this.value = value;
		this.profile = profile;
		this.roleTactiques = roleTactiques;
		this.weapons = weapons;
		this.profileDegressif = profileDegressif;
		this.rules = rules;
		this.keyWords = keyWords;
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
	public List<RoleTatcique> getRoleTactiques() {
		return roleTactiques;
	}

	@Override
	public int getValue() {
		return value;
	}

}
