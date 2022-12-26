package armybuilder.model.unit.keyword;

import armybuilder.model.IHaveDisplayName;
import armybuilder.serialisation.EnumPropertyLoader;

public enum KeyWord implements IHaveDisplayName {
	// Generique
	Aelf,
	Chaos,
	Heros,
	Unique,
	Monstre,
	Mort,
	Ordre,
	Pretre,
	Sorcier,
	Totem,

	// Manuel du general
	VeteransDeGallet,

	// DoK
	AvatarDeKhaine,
	ChaudronDeSang,
	DraichiGaneth,
	Erinyes,
	EtripeusesKhinerai,
	FerecailleMelusai,
	FilleDeKhaine,
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
	MortsDeVifArgent,
	OstEmeraude,

	BansheeDesTertres,
	BansheesDolentes,
	CarognesFaucheuses,
	ChevalierDesSuaires,
	ChevalierDesSuairesSurCoursierEthere,
	EcumeurAffrelame,
	EspritTourmenteur,
	FaucheursMornemanes,
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
	ClansEchin,
	ClocheHurlante,
	Griffarque,
	Maitreclan,
	MachineDeGuerre,
	MaitresMoulder,
	PropheteGris,
	Skavens,

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
