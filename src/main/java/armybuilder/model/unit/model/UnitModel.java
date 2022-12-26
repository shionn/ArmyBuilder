package armybuilder.model.unit.model;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import armybuilder.model.army.Army;
import armybuilder.model.comparator.DisplayNameComparator;
import armybuilder.model.comparator.EnumOrdinalComparator;
import armybuilder.model.dok.DokUnitModel;
import armybuilder.model.nighthaunt.NighthauntUnitModel;
import armybuilder.model.rule.IRule;
import armybuilder.model.skaven.SkavenUnitModel;
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
//	ConjurateursDuFeuMaudit(DokUnitModel.ConjurateursDuFeuMaudit),
//	AvatarDeKhaine(DokUnitModel.AvatarDeKhaine),
//	BloodStalkers(DokUnitModel.BloodStalkers),
//	BloodSisters(DokUnitModel.BloodSisters),
	EtripeusesKhinerai(DokUnitModel.EtripeusesKhinerai),
//	EgorgeusesKhinerai(DokUnitModel.EgorgeusesKhinerai),
//	BloodwrackViper(DokUnitModel.BloodwrackViper),
//	Bladewind(DokUnitModel.Bladewind),
	CoeurDeFureur(DokUnitModel.CoeurDeFureur),

	KurdossValentian(NighthauntUnitModel.KurdossValentian),
	ReikenorLeSombreChantre(NighthauntUnitModel.ReikenorLeSombreChantre),
	ChevalierDesSuaires(NighthauntUnitModel.ChevalierDesSuaires),
	ChevalierDesSuairesSurCoursierEthere(NighthauntUnitModel.ChevalierDesSuairesSurCoursierEthere),
	EcumeurAffrelame(NighthauntUnitModel.EcumeurAffrelame),
	SeigneurBourreau(NighthauntUnitModel.SeigneurBourreau),
	GardienDesAmes(NighthauntUnitModel.GardienDesAmes),
	EspritTourmenteur(NighthauntUnitModel.EspritTourmenteur),
	ManesEnchaines(NighthauntUnitModel.ManesEnchaines),
	BansheeDesTertres(NighthauntUnitModel.BansheeDesTertres),
	SpectreDesCairns(NighthauntUnitModel.SpectreDesCairns),
	FaucheursMornemanes(NighthauntUnitModel.FaucheursMornemanes),

	PropheteGrisSurClocheHurlante(SkavenUnitModel.PropheteGrisSurClocheHurlante),
	PropheteGris(SkavenUnitModel.PropheteGris),

	AstreiaSolbrigh(StormcastUnitModel.AstreiaSolbrigh),
	SeigneurArcanumSurDracolineCeleste(StormcastUnitModel.SeigneurArcanumSurDracolineCeleste),
	SeigneurArcanumSurGryphDestrier(StormcastUnitModel.SeigneurArcanumSurGryphDestrier),
	SeigneurImperatant(StormcastUnitModel.SeigneurImperatant),
	SeigneurRelictor(StormcastUnitModel.SeigneurRelictor),
	SeigneurExorciste(StormcastUnitModel.SeigneurExorciste),
	SeigneurOrdinator(StormcastUnitModel.SeigneurOrdinator),
	ChevalierVexillorAvecBanniereDeLApotheose(StormcastUnitModel.ChevalierVexillorAvecBanniereDeLApotheose),
	ChevalierAzyros(StormcastUnitModel.ChevalierAzyros),
	ChevalierArcanum(StormcastUnitModel.ChevalierArcanum),
	ChevalierIncantator(StormcastUnitModel.ChevalierIncantator),
	ChevalierQuestor(StormcastUnitModel.ChevalierQuestor),
	Vindictor(StormcastUnitModel.Vindictors),
	Liberators(StormcastUnitModel.Liberators),
	Sequitors(StormcastUnitModel.Sequitors),
	JudicatorsArcs(StormcastUnitModel.JudicatorsArcs),
	Castigators(StormcastUnitModel.Castigators),
	GryphDogues(StormcastUnitModel.GryphDogues),
	ProsecutorsMarteaux(StormcastUnitModel.ProsecutorsMarteaux),
	Annihilators(StormcastUnitModel.Annihilators),
	Retributors(StormcastUnitModel.Retributors),
	Praetors(StormcastUnitModel.Praetors),
	EvocatorsSurDracolinesCelestes(StormcastUnitModel.EvocatorsSurDracolinesCelestes),
	Evocators(StormcastUnitModel.Evocators),
	BalisteCelestar(StormcastUnitModel.BalisteCelestar),
	;

	private IUnitModel<?> sub;

	private UnitModel(IUnitModel<?> sub) {
		this.sub = sub;
	}

	public static List<UnitModel> sorteds() {
		return Arrays.stream(values()).sorted(new Comparator<UnitModel>() {
			@Override
			public int compare(UnitModel o1, UnitModel o2) {
				int result = new EnumOrdinalComparator().compare(o1.getRoleTactiques().get(0),
						o2.getRoleTactiques().get(0));
				if (result == 0) {
					result = new DisplayNameComparator().compare(o1, o2);
				}
				return result;
			}
		}).collect(Collectors.toList());
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
		List<RoleTactique> roles = sub.getRoleTactiques();
		if (roles.isEmpty()) {
			throw new IllegalStateException("No roles for " + this.name());
		}
		return roles;
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
