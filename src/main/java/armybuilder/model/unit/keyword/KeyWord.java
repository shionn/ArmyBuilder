package armybuilder.model.unit.keyword;

import armybuilder.model.IHaveDisplayName;
import armybuilder.serialisation.EnumPropertyLoader;

public enum KeyWord implements IHaveDisplayName {
	// Generique
	Aelf,
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

	// StormCast
	Chevalier,
	Draconithe,
	Fulgurant,
	Judicators,
	JudicatorsArc,
	Justicar,
	Liberators,
	Redempteur,
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
