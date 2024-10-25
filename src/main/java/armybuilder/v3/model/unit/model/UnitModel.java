package armybuilder.v3.model.unit.model;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import armybuilder.v3.model.army.Army;
import armybuilder.v3.model.comparator.DisplayNameComparator;
import armybuilder.v3.model.comparator.EnumOrdinalComparator;
import armybuilder.v3.model.dok.DokUnitModel;
import armybuilder.v3.model.nighthaunt.NighthauntUnitModel;
import armybuilder.v3.model.rule.IRule;
import armybuilder.v3.model.skaven.SkavenUnitModel;
import armybuilder.v3.model.stormcast.StormcastUnitModel;
import armybuilder.v3.model.unit.ProfileDegressif;
import armybuilder.v3.model.unit.UnitProfile;
import armybuilder.v3.model.unit.keyword.KeyWord;
import armybuilder.v3.model.unit.option.UnitOptionCategory;
import armybuilder.v3.model.unit.role.RoleTactique;
import armybuilder.v3.model.unit.weapon.IUnitWeapon;

@Deprecated
public enum UnitModel implements IUnitModel<UnitModel> {
	MorathiKhaine(DokUnitModel.MorathiKhaine),
	LaReineDeLOmbre(DokUnitModel.LaReineDeLOmbre),
	SanctuaireIncarnat(DokUnitModel.SanctuaireIncarnat),
	MelusaiIronscale(DokUnitModel.MelusaiIronscale),
	MeduseIncarnate(DokUnitModel.MeduseIncarnate),
//	MorgwaethTheBloodied(DokUnitModel.MorgwaethTheBloodied),
//	LeBladeCoven(DokUnitModel.LeBladeCoven),
	ReineMatriache(DokUnitModel.ReineMatriache),
	ReineMatriacheSurChaudronDeSang(DokUnitModel.ReineMatriacheSurChaudronDeSang),
	ReineDuMassacreSurChaudronDeSang(DokUnitModel.ReineDuMassacreSurChaudronDeSang),
	ReineDuMassacre(DokUnitModel.ReineDuMassacre),
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
	CoeurDeFureur(DokUnitModel.CoeurDeFureur),

	DameOlynder(NighthauntUnitModel.DameOlynder),
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
	Raclechaines(NighthauntUnitModel.Raclechaines),
	RevenantsLamemanes(NighthauntUnitModel.RevenantsLamemanes),
	RodeursHastespectres(NighthauntUnitModel.RodeursHastespectres),
	NueesDEsprits(NighthauntUnitModel.NueesDEsprits),
	BansheesDolentes(NighthauntUnitModel.BansheesDolentes),
	CarognesFaucheuses(NighthauntUnitModel.CarognesFaucheuses),
	Sorcespectres(NighthauntUnitModel.Sorcespectres),

	// skaven
	PropheteGris(SkavenUnitModel.PropheteGris),
	PropheteGrisSurClocheHurlante(SkavenUnitModel.PropheteGrisSurClocheHurlante),
	Griffarque(SkavenUnitModel.Griffarque),
	IngenieurTechnomage(SkavenUnitModel.IngenieurTechnomage),
	MaitreMoulder(SkavenUnitModel.MaitreMoulder),
	PretreDeLaPeste(SkavenUnitModel.PretreDeLaPeste),
	PretreDeLaPesteSurCreuset(SkavenUnitModel.PretreDeLaPesteSurCreuset),
	MaitreMort(SkavenUnitModel.MaitreMort),
	VerminarqueMaleprophete(SkavenUnitModel.VerminarqueMaleprophete),

	RatsDesClans(SkavenUnitModel.RatsDesClans),
	VerminesDeChoc(SkavenUnitModel.VerminesDeChoc),
	MoinesDeLaPeste(SkavenUnitModel.MoinesDeLaPeste),

	ColossesDeChoc(SkavenUnitModel.ColossesDeChoc),
	RatsOgors(SkavenUnitModel.RatsOgors),
	AbominationDeMalefosse(SkavenUnitModel.AbominationDeMalefosse),

	CanonRatling(SkavenUnitModel.CanonRatling),
	LanceFeu(SkavenUnitModel.LanceFeu),
	RoueInfernale(SkavenUnitModel.RoueInfernale),

	CanonAMalefoudre(SkavenUnitModel.CanonAMalefoudre),
	CatapulteDeLaPeste(SkavenUnitModel.CatapulteDeLaPeste),

	ClocheDeLApocalypse(SkavenUnitModel.ClocheDeLApocalypse),
	RazDeVermine(SkavenUnitModel.RazDeVermine),
	TrouDeVermine(SkavenUnitModel.TrouDeVermine),

	// SCE
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
	RaptorsDAvantGardeAvecArbaletesLonguefrappe(StormcastUnitModel.RaptorsDAvantGardeAvecArbaletesLonguefrappe),
	Etherviers(StormcastUnitModel.Etherviers),
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
