package armybuilder.model.stormcast;

import armybuilder.model.unit.weapon.IUnitWeapon;
import armybuilder.model.unit.weapon.WeaponType;

public enum StormcastWeapons implements IUnitWeapon {
	ArcFoudreciel("Arc Foudreciel", WeaponType.Projectil, "24", "2", "3+", "3+", "-1", "1"),
	ArcFoudrefleche("Arc Foudreflèche", WeaponType.Projectil, "24", "D6", "3+", "3+", "-1", "1"),
	ArmeDesCieux("Arme des Cieux", WeaponType.Melee, "1", "2", "3+", "4+", "-1", "1"),
	ArmesSacroSaintes("Armes Sacro-saintes", WeaponType.Melee, "1", "2", "3+", "3+", "-1", "1"),
	BecEtGriffesCruels("Bec et Griffes Cruels", WeaponType.Melee, "1", "4", "3+", "4+", "-", "1"),
	GlaiveDOrage("Glaive d'Orage", WeaponType.Melee, "1", "1", "3+", "4+", "-1", "1"),
	GrandArcFulgurant("Grand Arc Fulgurant", WeaponType.Projectil, "18", "D3", "3+", "3+", "-1", "1"),
	GrandSceptreEvocatorDracoline("Grand Sceptre", WeaponType.Melee, "1", "3", "3+", "3+", "-", "2"),
	GrandSceptre("Grand Sceptre (2/3)", WeaponType.Melee, "1", "3", "3+", "3+", "-", "2"),
	GrandeArme("Grande Arme", WeaponType.Melee, "1", "2", "3+", "3+", "-1", "2"),
	GrandeMassueDeSanction("Grande Massue de Sanction", WeaponType.Melee, "1", "2", "3+", "3+", "-1", "2"),
	GriffesEtBecAcere("Griffes et Bec Acéré", WeaponType.Melee, "1", "3", "3+", "3+", "-2", "1"),
	GriffesMonstrueuses("Griffes Monstrueuses", WeaponType.Melee, "1", "3", "3+", "3+", "-1", "D3"),
	HallebardeDeGardeDesAmes("Hallebarde de Garde des Âmes", WeaponType.Melee, "1", "3", "3+", "3+", "-1", "2"),
	LamesDeSigmarite("Lames de Sigmarite", WeaponType.Melee, "1", "4", "3+", "3+", "-1", "1"),
	LameTempeteEtSceptreDOrage("Lame Tempête et Sceptre d'Orage", WeaponType.Melee, "1", "4", "3+", "3+", "-1", "1"),
	LanceDOrage("Lance d'Orage", WeaponType.Melee, "2", "2", "3+", "3+", "-1", "1"),
	LourdeCrosse("Lourde Crosse", WeaponType.Melee, "1", "2", "4+", "3+", "-", "1"),
	MarteauDeFoudre("Marteau de Foudre", WeaponType.Melee, "1", "3", "3+", "3+", "-2", "2"),
	MarteauDeGuerreBeni("Marteau de Guerre Béni", WeaponType.Melee, "1", "4", "3+", "3+", "-1", "2"),
	MarteauRelique("Marteau Relique", WeaponType.Melee, "1", "4", "3+", "3+", "-1", "2"),
	MarteauMeteorique("Marteau Météorique", WeaponType.Melee, "1", "3", "3+", "3+", "-1", "2"),
	MarteauxCelestesMelee("Marteaux Céleste", WeaponType.Melee, "1", "2", "3+", "3+", "-1", "1"),
	MarteauxCelestesProjectil("Marteaux Céleste", WeaponType.Projectil, "9", "2", "4+", "4+", "-1", "1"),
	MasseDAsterie("Masse d'Astérie (2/5)", WeaponType.Melee, "1", "1", "*", "*", "*", "*"),
	PairesDArmesDesCieux("Paire d'Armes des Cieux", WeaponType.Melee, "1", "3", "3+", "4+", "-1", "1"),
	PaireDeMarteauxCelestesProjectil("Paire de Marteaux Célestes", WeaponType.Projectil, "9", "3", "4+", "4+", "-1", "1"),
	PaireDeMarteauxCelestesMelee("Paire de Marteaux Célestes", WeaponType.Melee, "1", "3", "3+", "3+", "-1", "1"),
	SceptreDeRedemption("Sceptre de Rédemption", WeaponType.Melee, "1", "4", "3+", "3+", "-1", "2"),
	SceptreDEther("Sceptre d'Éther", WeaponType.Melee, "2", "4", "3+", "3+", "-1", "2"),
	SceptreFulgurivoque("Sceptre Fulgurivoque", WeaponType.Projectil, "18", "D6", "3+", "3+", "-1", "1"),
	TraitsDeCelestarTirFoudroyant("Traits de Célestar: Tir Foudroyant", WeaponType.Projectil, "36","1","3+","2+","-3","D6"),
	TraitsDeCelestarTirRapide("Traits de Célestar: Tir Rapide", WeaponType.Projectil, "18","2D6","4+","3+","-2","1"),

	;

	private String displayName;
	private WeaponType type;
	private String[] stats;

	StormcastWeapons(String displayName, WeaponType type, String... stats) {
		this.displayName = displayName;
		this.type = type;
		this.stats = stats;
	}

	@Override
	public String getDisplayName() {
		return displayName;
	}

	@Override
	public WeaponType getType() {
		return type;
	}

	@Override
	public String getPortee() {
		return stats[0];
	}

	@Override
	public String getAttaques() {
		return stats[1];
	}

	@Override
	public String getToucher() {
		return stats[2];
	}

	@Override
	public String getBlesser() {
		return stats[3];
	}

	@Override
	public String getPerf() {
		return stats[4];
	}

	@Override
	public String getDegats() {
		return stats[5];
	}

}
