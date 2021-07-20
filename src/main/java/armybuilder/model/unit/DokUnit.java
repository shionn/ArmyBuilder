package armybuilder.model.unit;

import java.util.Arrays;
import java.util.List;

import armybuilder.model.rule.DokRule;
import armybuilder.model.rule.GeneriqueRule;
import armybuilder.model.rule.GeneriqueUnitRule;
import armybuilder.model.rule.IArmyRule;

public enum DokUnit implements IUnit {

	MorathiKhaine(
			"Morathi-Khaine",
			330,
			UnitProfile._6_6_8_4,
			Arrays.asList(RoleTatcique.Leader),
			Arrays.asList(UnitWeapon.EcorcheCoeur, UnitWeapon.AilesLamees),
			null,
			Arrays.asList(DokRule.DeuxCorpsUneSeuleAme, DokRule.PresenceIntimidante,
					GeneriqueRule.TraitMagique, GeneriqueRule.BouclierMystique,
					DokRule.HorreurNoireDUlgu, DokRule.VenerationParLeSang,
					GeneriqueUnitRule.Sorcier_3_2_1),
			Arrays.asList(KeyWord.Ordre, KeyWord.Aelf, KeyWord.DaughtersOfKhaine, KeyWord.Heros,
					KeyWord.Sorcier, KeyWord.MorathiKhaine)),
	LaShadowQueen(
			"La Shadow Queen",
			330,
			UnitProfile._S_12_10_4,
			Arrays.asList(RoleTatcique.Leader, RoleTatcique.Behemoth),
			Arrays.asList(UnitWeapon.RegardDeLaReineDeLOmbre, UnitWeapon.EcorcheCoeur_Shadow,
					UnitWeapon.CouronneDeSerpents, UnitWeapon.QueueVenimeuse),
			new ProfileDegressif("Mouvement", UnitWeapon.EcorcheCoeur_Shadow.getDisplayName(),
					UnitWeapon.QueueVenimeuse.getDisplayName()).add("0-3", "14", "8", "6")
							.add("4-6", "12", "7", "5").add("7-8", "10", "6", "4")
							.add("9-10", "8", "5", "3").add("11+", "6", "4", "2"),
			Arrays.asList(GeneriqueUnitRule.Vol, DokRule.FureurDeLaReineDeLOmbre,
					DokRule.DeuxCorpsUneSeuleAme_Shadow,
					DokRule.CoeurDeFerDeKhaine),
			Arrays.asList(KeyWord.Ordre, KeyWord.Aelf, KeyWord.DaughtersOfKhaine, KeyWord.Monstre,
					KeyWord.Heros, KeyWord.LaShadowQueen))

	;

	private String displayName;
	private int value;
	private UnitProfile profile;
	private List<IUnitWeapon> weapons;
	private ProfileDegressif profileDegressif;
	private List<IArmyRule> rules;
	private List<KeyWord> keyWords;
	private List<RoleTatcique> roleTactiques;

	private DokUnit(String displayName, int value, UnitProfile profile,
			List<RoleTatcique> roleTactiques, List<IUnitWeapon> weapons,
			ProfileDegressif profileDegressif, List<IArmyRule> rules, List<KeyWord> keyWords) {
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
	public List<IArmyRule> getRules() {
		return rules;
	}

	@Override
	public List<KeyWord> getKeyWords() {
		return keyWords;
	}

}
