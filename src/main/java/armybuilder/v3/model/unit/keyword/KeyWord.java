package armybuilder.v3.model.unit.keyword;

import armybuilder.v3.model.IHaveDisplayName;
import armybuilder.v3.serialisation.EnumPropertyLoader;

public enum KeyWord implements IHaveDisplayName {
	// Generique
	Chaos,
	Mort,
	Ordre,

	FilleDeKhaine,
	Nurgle,
	Skavens,

	Aelf,

	Demon,

	Heros,
	Unique,
	Monstre,
	Pretre,
	Sorcier,
	Totem,
	Monture,

	// Manuel du general
	ChampionDeGallet,
	GardeAssermentee,
	LocusAndtorien,
	VeteransDeGallet,

	// DoK
	AvatarDeKhaine,
	ChaudronDeSang,
	DraichiGaneth,
	Erinyes,
	EtripeusesKhinerai,
	FerecailleMelusai,
	GrandeGladiatrice,
	HaggNar,
	Khailebron,
	KheltNar,
	Khinerai,
	Kraith,
	LaReineDeLOmbre,
	Melusai,
	Meduse,
	MeduseIncarnate,
	Moirenees,
	MorathiKhaine,
	ReineDuMassacre,
	ReineMatriarche,
	RodeursDeLOmbre,
	SanctuaireIncarnat,
	SoeurDuMassacre,
	ZaintharKai,

	// fait au dessus
	BloodStalkers,
	BloodSister,
	LaBladeCoven,
	MelusaiIronscale,

	// Nighthaunt
	Convocable,
	FleauEcarlate,
	Hantenuits,
	LegionEploree,
	Malfaisants,
	Mortaque,
	MortsDeVifArgent,
	OstEmeraude,

	BansheeDesTertres,
	BansheesDolentes,
	CarognesFaucheuses,
	CarrosseNoir,
	ChevalierDesSuaires,
	ChevalierDesSuairesSurCoursierEthere,
	DameOlynder,
	EcumeurAffrelame,
	EspritTourmenteur,
	FaucheursMornemanes,
	GardeDuTroneVeule,
	GardienDesAmes,
	KurdossValentian,
	ManesEnchaines,
	NueesDEsprits,
	Raclechaines,
	ReikenorLeSombreChantre,
	RevenantsLamemanes,
	RodeursHastespectres,
	SeigneurBourreau,
	SpectreDesCairns,
	Sorcespectres,

	// Skaven
	AbominationDeMalefosse,
	BeteDeCombat,
	CanonAMalefoudre,
	CanonRatling,
	CatapulteDeLaPeste,
	ClansEshin,
	ClansMoulder,
	ClansPestilens,
	ClansVerminus,
	ClansSkryre,
	ClocheHurlante,
	ColossesDeChoc,
	CreusetDeLaPeste,
	EquipeDArme,
	Griffarque,
	IngenieurTechnomage,
	LanceFeu,
	Maitreclan,
	MachineDeGuerre,
	MaitreMoulder,
	MaitreMort,
	Meute,
	MoinesDeLaPeste,
	PropheteGris,
	PretreDeLaPeste,
	RatsDesClans,
	RatsOgors,
	RoueInfernale,
	Verminarque,
	VerminarqueMaleprophete,
	VerminesDeChoc,

	// StormCast
	Angelos,
	Annihilators,
	AstreiaSolbrigh,
	BalisteCelestar,
	BellicistesCelestes,
	Castigators,
	Corpuscant,
	Chevalier,
	ChevalierArcanum,
	ChevalierAzyros,
	ChevalierIncantator,
	ChevalierQuestor,
	ChevalierVexillor,
	ChevalierVexillorAvecBanniereDeLApotheose,
	ChevaliersExcelsiors,
	ChevaliersSanctifies,
	Dracastral,
	Dracoline,
	Draconithe,
	Dracoth,
	EnclumesDeLHeldenhammer,
	Evocators,
	Fulgurant,
	Etherviers,
	GryphDestrier,
	GryphDogues,
	Judicators,
	JudicatorsArc,
	Justicar,
	Liberators,
	MarteauxDeSigmar,
	MessagerDesCieux,
	Ordinatus,
	Paladin,
	Praetors,
	Prosecutors,
	ProsecutorsMarteaux,
	RaptorsDAvantGarde,
	RaptorsDAvantGardeAvecArbaletesLonguefrappe,
	Redempteur,
	Retributors,
	SacroSaint,
	Seigneur,
	SeigneurArcanum,
	SeigneurImperatant,
	SeigneurExorciste,
	SeigneurOrdinator,
	SeigneurRelictor,
	SeigneursDeLaTempete,
	Sequitors,
	StormCast,
	TempliersSiellaires,
	VengeursCelestes,
	Vindictors,

	;

	private String displayName;

	private KeyWord() {
		this.displayName = EnumPropertyLoader.instance().name(this);
	}

	@Override
	public String getDisplayName() {
		return displayName;
	}
}