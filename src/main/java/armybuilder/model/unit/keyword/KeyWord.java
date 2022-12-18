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
	Castigators,
	Corpuscant,
	Chevalier,
	ChevaliersSanctifies,
	Dracoline,
	Draconithe,
	Evocators,
	Fulgurant,
	GryphDogues,
	Judicators,
	JudicatorsArc,
	Justicar,
	Liberators,
	MarteauxDeSigmar,
	Paladin,
	Praetors,
	Prosecutors,
	ProsecutorsMarteaux,
	Redempteur,
	Retributors,
	SacroSaint,
	Seigneur,
	SeigneurRelictor,
	Sequitors,
	StormCast,
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
