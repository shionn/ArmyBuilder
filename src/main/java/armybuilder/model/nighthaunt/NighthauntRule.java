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

	// Todo Optimisation
	DrapeDOmbre(RuleType.TraitsDeCommandement),
	EntiteTerrifiante(RuleType.TraitsDeCommandement),
	EspritPersistant(RuleType.TraitsDeCommandement),
	HaineDesVivants(RuleType.TraitsDeCommandement),
	MaitreDesOstsSpectraux(RuleType.TraitsDeCommandement),
	EspritAmer(RuleType.TraitsDeCommandement),

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
	LaMaledictionEmeraude("La Malédiction Émeraude", RuleType.TraisDeBataille),
	NourrisDeTerreur("Nourris de Terreur", RuleType.TraisDeBataille),
	RestituerLesFigurinesTuees("Restituer Les Figurines Tuées", RuleType.TraisDeBataille),

	MaitreDesOstsDEsprits("Maître des Osts d'Esprits", RuleType.TraitsDeCommandement),
	SeigneurDeLOst("Seigneur de l'Ost", RuleType.TraitsDeCommandement),

	BrumeSepulcrale("Brume Sépulcrale", RuleType.Sort, RuleType.TraisUnitee),
	CageAAmes("Cage à Âmes", RuleType.Sort, RuleType.TraisUnitee),
	CanuleSpectrale("Canule Spectrale", RuleType.Sort, RuleType.TraisUnitee),
	DrainDEsprit("Drain d'Esprit", RuleType.Sort, RuleType.TraisUnitee),
	FauxGlaneuse("Faux Glaneuse", RuleType.Sort, RuleType.TraisUnitee),
	VoleurDeVie("Voleur de Vie", RuleType.Sort, RuleType.TraisUnitee),
	VortexHurlant("Vortex Hurlant", RuleType.Sort, RuleType.TraisUnitee),

	FaucheLesPeines("Fauche-les-Peines", RuleType.Artefact),
	FilDeLOmbre("Fil de l'Ombre", RuleType.Artefact),
	Inciseur("Inciseur", RuleType.Artefact),
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
	Dematerialisation(
			"Dématérialisation",
			RuleType.Aptitude,
			RuleType.PhaseDeMouvement,
			RuleType.TraisUnitee),
	HordeEffroyable("Horde Effroyable", RuleType.Aptitude),
	LaPointeDeLaMort("La Pointe de la Mort", RuleType.Aptitude),
	MaledictionDeLoyaute("Malédiction de Loyauté", RuleType.Aptitude),
	MangeSorts(
			"Mange-sorts",
			RuleType.Aptitude,
			RuleType.PhaseDesHeros,
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
