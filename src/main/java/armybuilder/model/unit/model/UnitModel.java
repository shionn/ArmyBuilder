package armybuilder.model.unit.model;

import java.util.List;

import armybuilder.model.army.Army;
import armybuilder.model.dok.DokUnitModel;
import armybuilder.model.rule.IRule;
import armybuilder.model.unit.ProfileDegressif;
import armybuilder.model.unit.UnitProfile;
import armybuilder.model.unit.keyword.KeyWord;
import armybuilder.model.unit.role.RoleTactique;
import armybuilder.model.unit.weapon.IUnitWeapon;
import armybuilder.modelold.deprecated.army.Listing;
import armybuilder.modelold.deprecated.unit.Unit;
import armybuilder.modelold.deprecated.unit.option.IUnitOptionValue;
import armybuilder.modelold.deprecated.unit.option.UnitOptionCategory;

public enum UnitModel implements IUnitModel<UnitModel> {
	MorathiKhaine(DokUnitModel.MorathiKhaine),
	LaReineDeLOmbre(DokUnitModel.LaReineDeLOmbre),
	SanctuaireIncarnat(DokUnitModel.SanctuaireIncarnat),
	MelusaiIronscale(DokUnitModel.MelusaiIronscale),
	MeduseIncarnate(DokUnitModel.MeduseIncarnate),
//	MorgwaethTheBloodied(DokUnitModel.MorgwaethTheBloodied),
//	LeBladeCoven(DokUnitModel.LeBladeCoven),
//	HagQueenSurChaudron(DokUnitModel.HagQueenSurChaudron),
	ReineMatriache(DokUnitModel.ReineMatriache),
	ReineDuMassacreSurChaudronDeSang(DokUnitModel.ReineDuMassacreSurChaudronDeSang),
//	SlaughterQueen(DokUnitModel.SlaughterQueen),
	GrandeGladiatrice(DokUnitModel.GrandeGladiatrice),
	SoeurDuMassacre(DokUnitModel.SoeurDuMassacre),
	Erinyes(DokUnitModel.Erinyes),
//	KhainiteShadowstalkers(DokUnitModel.KhainiteShadowstalkers),
//	ConjurateursDuFeuMaudit(DokUnitModel.ConjurateursDuFeuMaudit),
	AvatarDeKhaine(DokUnitModel.AvatarDeKhaine),
//	BloodStalkers(DokUnitModel.BloodStalkers),
//	BloodSisters(DokUnitModel.BloodSisters),
	EtripeusesKhinerai(DokUnitModel.EtripeusesKhinerai),
//	EgorgeusesKhinerai(DokUnitModel.EgorgeusesKhinerai),
//	BloodwrackViper(DokUnitModel.BloodwrackViper),
//	Bladewind(DokUnitModel.Bladewind),
	CoeurDeFureur(DokUnitModel.CoeurDeFureur);

	private IUnitModel<?> sub;

	UnitModel(IUnitModel<?> sub) {
		this.sub = sub;
	}

	@Override
	public String getDisplayName() {
		return sub.getDisplayName();
	}

	@Override
	public boolean available(Army army) {
		return sub.available(army);
	}

	@Override
	public List<IUnitWeapon> getWeapons() {
		return sub.getWeapons();
	}


	@Override
	public List<KeyWord> getKeyWords() {
		return sub.getKeyWords();
	}

	@Override
	public List<IRule<?>> getRules() {
		return sub.getRules();
	}

	@Override
	public List<RoleTactique> getRoleTactiques() {
		return sub.getRoleTactiques();
	}

	@Override
	public int points() {
		// TODO Auto-generated method stub
		return sub.points();
	}

	@Override
	public List<UnitOptionCategory> options() {
		return null;
	}

	@Override
	public List<IUnitOptionValue<?>> optionValues() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void rebuild(Unit unit) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean availableFor(Listing listing) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public UnitProfile getProfile() {
		return sub.getProfile();
	}

	@Override
	public ProfileDegressif getProfileDegressif() {
		return sub.getProfileDegressif();
	}
}
