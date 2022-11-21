package armybuilder.model.unit.keyword;

public enum KeyWord {
	// Generique
	Aelf("Aelf"),
	Heros("Héros"),
	Unique("Unique"),
	Monstre("Monstre"),
	Mort("Mort"),
	Ordre("Ordre"),
	Pretre("Prêtre"),
	Sorcier("Sorcier"),
	Totem("Totem"),

	// DoK
	AvatarDeKhaine("Avatar de Khaine"),
	ChaudronDeSang("Chaudron de Sang"),
	DraichiGaneth("Draichi Ganeth"),
	Erinyes("Witch Aelves"),
	EtripeusesKhinerai("Étripeuses Khineraĩ"),
	FerecailleMelusai("Ferécaille Melusaï"),
	FilleDeKhaine("Filles de Khaine"),
	GrandeGladiatrice("Grande Gladiatrice"),
	HaggNar("Hagg Nar"),
	Khailebron("Khailebron"),
	KheltNar("Khelt Nar"),
	Khinerai("Khineraĩ"),
	Kraith("Kraith"),
	LaReineDeLOmbre("La Reine de l'Ombre"),
	Melusai("Melusaĩ"),
	Meduse("Méduse"),
	MeduseIncarnate("Méduse Incarnate"),
	Moirenees("Moirenées"),
	MorathiKhaine("Morathi-Khaine"),
	ReineDuMassacre("Reine du Massacre"),
	ReineMatriarche("Hag Matriarche"),
	RodeursDeLOmbre("Rodeurs de l'Ombre"),
	SanctuaireIncarnat("Sanctuaire Incarnat"),
	SoeurDuMassacre("Sœurs du Massacre"),
	ZaintharKai("Zainthar Kai"),

	// Manuel du general
	VeteransDeGallet("Veterans de Gallet"),

	// fait au dessus
	BloodStalkers("Blood Stalkers"),
	BloodSister("Blood Sister"),
	ChainraspHorde("ChainraspHorde"),
	DreadbladeHarrow("Dreadblade Harrow"),
	EpinesDeLaReineDesRonces("Epines de la Reine des Ronces"),
	GlaivewraithStalkers("Glaivewraith Stalkers"),
	Invocable("Invocable"),
	KnightOfShrouds("Knight Of Shrouds"),
	LaBladeCoven("La Blade-Coven"),
	LaReineDesRonces("La Reine des Ronces"),
	LOstEmeraude("Ost Émeraude"),
	Malignant("Malignant"),
	MelusaiIronscale("Melusai Ironscale"),
	MirrorghastBanshee("Mirrorghast Banshee"),
	MorgwaethTheBloodied("Morgwaeth the Bloodied"),
	MyrmournBanshees("Myrmourn Banshees"),
	Nighthaunt("Nighthaunt"),
	TombBanshee("Tomb Banshee"),
	TousLesTemples("Tous les Temples"),


	;

	private String displayName;

	private KeyWord(String displayName) {
		this.displayName = displayName;
	}

	public String getDisplayName() {
		return displayName;
	}
}
