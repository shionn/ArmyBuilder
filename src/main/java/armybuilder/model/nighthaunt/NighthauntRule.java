package armybuilder.model.nighthaunt;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import armybuilder.model.Army;
import armybuilder.model.rule.ArmyRuleType;
import armybuilder.model.rule.DescriptionReader;
import armybuilder.model.rule.IArmyRule;

public enum NighthauntRule implements IArmyRule<NighthauntRule> {
	AuraDEffroi("Aura d'Effroi", ArmyRuleType.TraisDeBataille),
	ChevaliersDuRegret("Chevaliers du Regret", ArmyRuleType.TraisDeBataille),
	ConvocationSpectrale(
			"Convocation Spectrale",
			ArmyRuleType.TraisDeBataille,
			ArmyRuleType.AptitudesDeCommandement,
			ArmyRuleType.PhaseDeMouvement),
	EspritsImperissables("Esprits Impérissables", ArmyRuleType.TraisDeBataille),
	IlsViennentDesSousMondes(
			"Ils Viennent des Sous-Mondes",
			ArmyRuleType.TraisDeBataille,
			ArmyRuleType.PhaseDeMouvement),
	LaMaledictionEmeraude("La Malédiction Émeraude", ArmyRuleType.TraisDeBataille),
	NourrisDeTerreur("Nourris de Terreur", ArmyRuleType.TraisDeBataille),
	RestituerLesFigurinesTuees("RestituerLesFigurinesTuées", ArmyRuleType.TraisDeBataille),
	VagueDeTerreur("Vague de Terreur", ArmyRuleType.TraisDeBataille, ArmyRuleType.PhaseDeCharge),

	DrapeDOmbre("Drapé d'Ombre", ArmyRuleType.TraitsDeCommandement),
	EntiteTerrifiante("Entité Terrifiante", ArmyRuleType.TraitsDeCommandement),
	EspritAmer("Esprit Amer", ArmyRuleType.TraitsDeCommandement),
	EspritPersistant("Esprit Persistant", ArmyRuleType.TraitsDeCommandement),
	HaineDesVivants("Haine des Vivants", ArmyRuleType.TraitsDeCommandement),
	MaitreDesOstsDEsprits("Maître des Osts d'Esprits", ArmyRuleType.TraitsDeCommandement),
	SeigneurDeLOst("Seigneur de l'Ost", ArmyRuleType.TraitsDeCommandement),

	BrumeSepulcrale("Brume Sépulcrale", ArmyRuleType.Sort, ArmyRuleType.TraisUnitee),
	CageAAmes("Cage à Âmes", ArmyRuleType.Sort, ArmyRuleType.TraisUnitee),
	CanuleSpectrale("Canule Spectrale", ArmyRuleType.Sort, ArmyRuleType.TraisUnitee),
	DrainDEsprit("Drain d'Esprit", ArmyRuleType.Sort, ArmyRuleType.TraisUnitee),
	FauxGlaneuse("Faux Glaneuse", ArmyRuleType.Sort, ArmyRuleType.TraisUnitee),
	VoleurDeVie("Voleur de Vie", ArmyRuleType.Sort, ArmyRuleType.TraisUnitee),
	VortexHurlant("Vortex Hurlant", ArmyRuleType.Sort, ArmyRuleType.TraisUnitee),

	FaucheLesPeines("Fauche-les-Peines", ArmyRuleType.Artefact),
	FilDeLOmbre("Fil de l'Ombre", ArmyRuleType.Artefact),
	Inciseur("Inciseur", ArmyRuleType.Artefact),
	JugementDuBourreau("Jugement du Bourreau", ArmyRuleType.Artefact),
	LaLameDuChevalierFelon("La Lame du Chevalier Félon", ArmyRuleType.Artefact),
	LameDeFeuMaudit("Lame de Feu Maudit", ArmyRuleType.Artefact),
	LameStridente("Lame Stridente", ArmyRuleType.Artefact),

	ChainesEtrangleuses("Chaînes Étrangleuses", ArmyRuleType.Aptitude),
	Etheres("Éthérés", ArmyRuleType.Aptitude),
	HordeEffroyable("Horde Effroyable", ArmyRuleType.Aptitude),
	LaPointeDeLaMort("La Pointe de la Mort", ArmyRuleType.Aptitude),
	MangeSorts(
			"Mange-sorts",
			ArmyRuleType.Aptitude,
			ArmyRuleType.PhaseDesHeros,
			ArmyRuleType.TraisUnitee),

	// Composition
	Dreadwarden("Dreadwarden", ArmyRuleType.Composition),
	TambourDArythmie("Tambour d'Arythmie", ArmyRuleType.Composition),
	VarclavLeCruel("Varclav le Cruel", ArmyRuleType.Composition),

	;

	private String displayName;
	private List<ArmyRuleType> types;

	private NighthauntRule(String displayName, ArmyRuleType... types) {
		this.displayName = displayName;
		this.types = Arrays.asList(types);

	}

	@Override
	public List<ArmyRuleType> getTypes() {
		return types;
	}

	@Override
	public String getDisplayName() {
		return displayName;
	}

	@Override
	public String getDescription() throws IOException {
		return new DescriptionReader().read("Nighthaunt/", name());
	}

	@Override
	public String toString() {
		return name() + getTypes();
	}

	@Override
	public void rebuild(Army army) {

	}

}
