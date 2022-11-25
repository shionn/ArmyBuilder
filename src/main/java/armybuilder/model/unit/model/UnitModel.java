package armybuilder.model.unit.model;

import java.util.List;

import armybuilder.model.army.Army;
import armybuilder.model.dok.DokUnitModel;
import armybuilder.model.rule.IRule;
import armybuilder.model.stormcast.StormcastUnitModel;
import armybuilder.model.unit.ProfileDegressif;
import armybuilder.model.unit.UnitProfile;
import armybuilder.model.unit.keyword.KeyWord;
import armybuilder.model.unit.option.UnitOptionCategory;
import armybuilder.model.unit.role.RoleTactique;
import armybuilder.model.unit.weapon.IUnitWeapon;

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
	ConjurateursDuFeuMaudit(DokUnitModel.ConjurateursDuFeuMaudit),
	AvatarDeKhaine(DokUnitModel.AvatarDeKhaine),
	BloodStalkers(DokUnitModel.BloodStalkers),
	BloodSisters(DokUnitModel.BloodSisters),
	EtripeusesKhinerai(DokUnitModel.EtripeusesKhinerai),
	EgorgeusesKhinerai(DokUnitModel.EgorgeusesKhinerai),
//	BloodwrackViper(DokUnitModel.BloodwrackViper),
//	Bladewind(DokUnitModel.Bladewind),
	CoeurDeFureur(DokUnitModel.CoeurDeFureur),

	SeigneurRelictor(StormcastUnitModel.SeigneurRelictor),
	Vindictor(StormcastUnitModel.Vindictors),
	Liberators(StormcastUnitModel.Liberators),
	Sequitors(StormcastUnitModel.Sequitors),
	JudicatorsArcs(StormcastUnitModel.JudicatorsArcs),

	;

	private IUnitModel<?> sub;

	UnitModel(IUnitModel<?> sub) {
		this.sub = sub;
	}

	@Override
	public String getDisplayName() {
		return sub.getDisplayName();
	}

	@Override
	public boolean availableFor(Army army) {
		return sub.availableFor(army);
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
	public int getPoints() {
		return sub.getPoints();
	}

	@Override
	public List<UnitOptionCategory> getOptionsCategories() {
		return sub.getOptionsCategories();
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
