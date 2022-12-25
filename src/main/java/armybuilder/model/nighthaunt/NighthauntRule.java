package armybuilder.model.nighthaunt;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import armybuilder.model.rule.IRule;
import armybuilder.model.rule.RuleType;
import armybuilder.serialisation.DescriptionReader;
import armybuilder.serialisation.EnumPropertyLoader;

public enum NighthauntRule implements IRule<NighthauntRule> {
	ApparitionsInstables(RuleType.TraisDeBataille),
	AuraDEffroi(RuleType.TraisDeBataille),
	Etheres(RuleType.TraisDeBataille),
	Incorporels(RuleType.TraisDeBataille, RuleType.AptitudesDeCommandement),
	VagueDeTerreur(RuleType.TraisDeBataille),
	ToucherEffroyable(RuleType.TraisDeBataille),

	ArtisansDUneMortEffroyable(RuleType.TraisDeBataille),
	EntrainesDansLaTombe(RuleType.TraisDeBataille),
	LaMaledictionEmeraude(RuleType.TraisDeBataille),
	VortexDeViolenceFrenetique(RuleType.TraisDeBataille),

	DrapeDOmbre(RuleType.TraitsDeCommandement),
	EntiteTerrifiante(RuleType.TraitsDeCommandement),
	EspritAmer(RuleType.TraitsDeCommandement),
	EspritPersistant(RuleType.TraitsDeCommandement),
	HaineDesVivants(RuleType.TraitsDeCommandement),
	MaitreDesOstsSpectraux(RuleType.TraitsDeCommandement),

	AnneauDuFeuDeLame(RuleType.Artefact),
	CapeDeLaLuneCroissante(RuleType.Artefact),
	EclatDeLuneDesMoissons(RuleType.Artefact),
	FamilierAvide(RuleType.Artefact),
	FanalDeNagashizzar(RuleType.Artefact),
	FaucheLesPeines(RuleType.Artefact),
	FilDeLOmbre(RuleType.Artefact),
	GrimoireDeMinuit(RuleType.Artefact),
	Inciseur(RuleType.Artefact),
	LanterneDeSorcellumiere(RuleType.Artefact),
	PendentifDuVentMaussade(RuleType.Artefact),

	BrumeSepulcrale(RuleType.Sort),
	CageAAmes(RuleType.Sort),
	CanuleSpectrale(RuleType.Sort),
	DrainDEsprit(RuleType.Sort),
	LeurreSpectral(RuleType.Sort),
	VoleurDeVie(RuleType.Sort),
	TempeteSpectrale(RuleType.Sort),
	SceauDeShyish(RuleType.Sort),

	AttireesParLaGuerre(RuleType.Aptitude),
	BougiesDeCadavre(RuleType.Aptitude),
	BougiesSorcieres(RuleType.Aptitude),
	ChasseursSpectraux(RuleType.Aptitude),
	CondamnationALEternelTourment(RuleType.Aptitude),
	ContremaitreSpectral(RuleType.Aptitude),
	CranesDesincarnes(RuleType.Aptitude),
	Dematerialisation(RuleType.Aptitude),
	EnergieDAmesCaptives(RuleType.Aptitude),
	FauchesCommeLesBles(RuleType.Aptitude),
	FaireFaceALaMort(RuleType.Aptitude),
	HeuresVolees(RuleType.Aptitude),
	HordeEffroyable(RuleType.Aptitude),
	HurlementFunebre(RuleType.Aptitude),
	HurlementPerturbant(RuleType.Aptitude),
	JusticeFuneste(RuleType.Aptitude),
	LanterneDeCauchemar(RuleType.Aptitude),
	LaPointeDeLaMort(RuleType.Aptitude),
	MaledictionDeLoyaute(RuleType.Aptitude),
	MangeSorts(RuleType.Aptitude),
	MortTourbillonnante(RuleType.Aptitude),
	PourvoyeursDeMortEffrenes(RuleType.Aptitude),
	ProgressionFantomatique(RuleType.Aptitude),
	SeigneurDesSpectres(RuleType.Aptitude),
	SiJeNePeuxRegnerNulNeLePourra(RuleType.Aptitude),
	SoifDeSangMeurtriere(RuleType.Aptitude),
	UnMaillonDeLaChaine(RuleType.Aptitude),

	// OLD
	ChevaliersDuRegret("Chevaliers du Regret", RuleType.TraisDeBataille),
	ConvocationSpectrale(
			"Convocation Spectrale",
			RuleType.TraisDeBataille,
			RuleType.AptitudesDeCommandement,
			RuleType.PhaseDeMouvement),
	EspritsImperissables("Esprits Impérissables", RuleType.TraisDeBataille),
	IlsViennentDesSousMondes(
			"Ils Viennent des Sous-Mondes",
			RuleType.TraisDeBataille,
			RuleType.PhaseDeMouvement),
	NourrisDeTerreur("Nourris de Terreur", RuleType.TraisDeBataille),
	RestituerLesFigurinesTuees("Restituer Les Figurines Tuées", RuleType.TraisDeBataille),

	MaitreDesOstsDEsprits("Maître des Osts d'Esprits", RuleType.TraitsDeCommandement),
	SeigneurDeLOst("Seigneur de l'Ost", RuleType.TraitsDeCommandement),

	FauxGlaneuse("Faux Glaneuse", RuleType.Sort, RuleType.TraisUnitee),
	VortexHurlant("Vortex Hurlant", RuleType.Sort, RuleType.TraisUnitee),

	JugementDuBourreau("Jugement du Bourreau", RuleType.Artefact),
	LaLameDuChevalierFelon("La Lame du Chevalier Félon", RuleType.Artefact),
	LameDeFeuMaudit("Lame de Feu Maudit", RuleType.Artefact),
	LameStridente("Lame Stridente", RuleType.Artefact),

	Affrelame("Affrelame", RuleType.Aptitude),
	ChainesEtrangleuses("Chaînes Étrangleuses", RuleType.Aptitude),
	CriFunebre(
			"Cri Funèbre",
			RuleType.Aptitude,
			RuleType.PhaseDeTir,
			RuleType.TraisUnitee),
	ToucherFuneste("Toucher Funeste", RuleType.Aptitude),

	// Composition
	Dreadwarden("Dreadwarden", RuleType.Composition),
	TambourDArythmie("Tambour d'Arythmie", RuleType.Composition),
	VarclavLeCruel("Varclav le Cruel", RuleType.Composition),

	;

	private String displayName;
	private List<RuleType> types;

	private NighthauntRule(RuleType... types) {
		this.displayName = EnumPropertyLoader.instance().name(this);
		this.types = Arrays.asList(types);
	}

	private NighthauntRule(String displayName, RuleType... types) {
		this.displayName = displayName;
		this.types = Arrays.asList(types);
	}

	@Override
	public List<RuleType> getTypes() {
		return types;
	}

	@Override
	public String getDisplayName() {
		return displayName;
	}

	@Override
	public String getDescription() throws IOException {
		return new DescriptionReader().read(this);
	}


}
