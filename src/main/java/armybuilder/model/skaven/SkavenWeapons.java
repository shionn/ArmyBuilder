package armybuilder.model.skaven;

import armybuilder.model.unit.weapon.IUnitWeapon;
import armybuilder.model.unit.weapon.WeaponType;

public enum SkavenWeapons implements IUnitWeapon {
	AttrapeChoses("Attrape-choses", WeaponType.Melee, "2", "4", "4+", "4+", "-1", "2"),
	BatonDeMalepierre("Bâton de Malepierre", WeaponType.Melee, "2", "3", "4+", "4+", "-1", "D3"),
	BourdonDeMalepierre("Bourdon de Malepierre", WeaponType.Melee, "2", "D3", "3+", "3+", "-1", "1"),
	EncensoirAPestilence("Encensoir a Pestilence", WeaponType.Melee, "2", "2", "4+", "3+", "-1", "1"),
	CatapulteDeLaPeste("Catapulte de la Peste", WeaponType.Projectil, "6\"-30", "1", "3+", "2+", "-2", "D6"),
	CoupsDeMassue("Coups de Massue", WeaponType.Melee, "1", "4", "4+", "3+", "-", "2"),
	CrocsEtPoignards("Crocs et Poignards", WeaponType.Melee, "1", "D6", "4+", "4+", "-", "1"),
	CrocsEtPoignards_Roue("Crocs et Poignards", WeaponType.Melee, "1", "6", "4+", "4+", "-", "1"),
	DechargeDeMalefoudre("Décharge de Malefoudre", WeaponType.Projectil, "24", "--", "--", "*", "--", "--"),
	FouetDeMalepierre("Fouet de Malepierre", WeaponType.Melee, "3", "6", "3+", "4+", "-1", "1"),
	GanteletsChoc("Gantelets Choc", WeaponType.Melee, "1", "4", "3+", "3+", "-1", "2"),
	GanteletsEcorcheurs("Gantelets Écorcheurs", WeaponType.Melee, "1", "2D3", "3+", "3+", "-2", "D3"),
	GrandEncensoirAPestilence("Grand Encensoir à Pestilence", WeaponType.Melee, "3", "--", "--", "*", "--", "--"),
	GriffesEtDentsDechiqueteuses("Griffes et Dents Déchiqueteuses", WeaponType.Melee, "1", "4", "4+", "3+", "-1", "2"),
	GriffesLamesEtDentsDechiqueteuses("Griffes, Lames et Dents Déchiqueteuses", WeaponType.Melee, "1", "4", "3+", "3+", "-1", "2"),
	HallebardeRouillee("Hallebarde Rouillée", WeaponType.Melee, "1", "2", "3+", "3+", "-1", "1"),
	LanceRouillee("Lance Rouillée", WeaponType.Melee, "2", "1", "5+", "4+", "-", "1"),
	LameAMalenergie("Lame à Malénergie", WeaponType.Melee, "1", "D3", "4+", "3+", "-1", "1"),
	LameDeMalepierre("Lame de Malepierre", WeaponType.Melee, "1", "6", "3+", "3+", "-1", "2"),
	LameFetideEtBatonDesPlaies("Lame Fétide et Bâton des Plaies", WeaponType.Melee, "2", "2", "4+", "4+", "-", "1"),
	LameFetides_Creuset("Lames Fétides", WeaponType.Melee, "1", "6", "3+", "4+", "-", "1"),
	LameRouillee("Lame Rouillée", WeaponType.Melee, "1", "1", "4+", "4+", "-", "1"),
	LameSuintante("Lame Suitante", WeaponType.Melee, "1", "5", "3+", "3+", "-1", "D3"),
	PaireDeLamesFetides("Paire de Lames Fétide", WeaponType.Melee, "1", "2", "3+", "4+", "-", "1"),
	PiquesRouillees("Piques Rouillées", WeaponType.Melee, "1", "*", "3+", "3+", "-1", "1"),
	PoignardsRouilles("Poignards Rouillés", WeaponType.Melee, "1", "2", "4+", "4+", "-", "1"),
	PoignardsRouilles_Catapulte("Poignards Rouillés", WeaponType.Melee, "1", "D6", "4+", "4+", "-", "1"),
	PoingsConcasseurs("Poings Concasseurs", WeaponType.Melee, "1", "4", "3+", "3+", "-2", "2"),
	PointesRouillees("Pointes Rouillées", WeaponType.Melee, "1", "*", "3+", "3+", "-1", "1"),
	RoueBroyeuse("Roue Broyeuse", WeaponType.Melee, "1", "D6", "3+", "3+", "-1", "1"),

	BombardesAGlobesToxiques("Bombardes à Globes Toxiques", WeaponType.Projectil, "24", "3", "4+", "3+", "-3", "D3"),
	CanonAMaleflamme("Canon a Maleflamme", WeaponType.Projectil, "16", "D3", "4+", "3+", "-1", "2"),
	CanonsRatlings("Canons Ratlings", WeaponType.Projectil, "12", "3D6", "3+", "3+", "-1", "1"),
	CanonsRatlings_EA("Canons Ratlings", WeaponType.Projectil, "12", "2D6+3", "4+", "4+", "-1", "1"),
	EtoileDeJetEshin("Etoile de Jet Eshin", WeaponType.Projectil, "12", "5", "4+", "4+", "-", "D3"),
	LanceFeu("Lance-Feu", WeaponType.Projectil, "8", "--", "--", "*", "--", "--"),
	PistoletAMalepierre("Pistolet à Malepierre", WeaponType.Projectil, "9", "3", "3+", "3+", "-2", "1"),
	ProjecteursAMaleflamme("Projecteurs à Maleflamme", WeaponType.Projectil, "8", "--", "--", "*", "--", "--"),
	TraitsDeMalefoudre("Traits de Malefoudre", WeaponType.Projectil, "13", "D6", "3+", "3+", "-1", "D3"),

	;
	private String displayName;
	private WeaponType type;
	private String[] stats;

	SkavenWeapons(String displayName, WeaponType type, String... stats) {
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

	@Override
	public boolean is(IUnitWeapon weapon) {
		return weapon == this;
	}

}
