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

	// Manuel du general
	VeteransDeGallet,

	// fait au dessus
	BloodStalkers,
	BloodSister,
	ChainraspHorde,
	DreadbladeHarrow,
	EpinesDeLaReineDesRonces,
	GlaivewraithStalkers,
	Invocable,
	KnightOfShrouds,
	LaBladeCoven,
	LaReineDesRonces,
	LOstEmeraude,
	Malignant,
	MelusaiIronscale,
	MirrorghastBanshee,
	MorgwaethTheBloodied,
	MyrmournBanshees,
	Nighthaunt,
	TombBanshee,

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
