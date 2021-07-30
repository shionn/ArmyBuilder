package armybuilder.model.nighthaunt;

import java.io.IOException;
import java.util.List;

import armybuilder.model.rule.ArmyRuleType;
import armybuilder.model.rule.IArmyRule;

public enum NighthauntRule implements IArmyRule<NighthauntRule> {
	AuraDEffroi("Aura d'Effroi", ArmyRuleType.TraisDeBataille),
	ConvocationSpectrale(
			"Convocation Spectrale",
			ArmyRuleType.TraisDeBataille,
			ArmyRuleType.AptitudesDeCommandement),
	EspritsImpérissables("Esprits Impérissables", ArmyRuleType.TraisDeBataille),
	IlsViennentDesSousMondes(
			"Ils Viennent des Sous-Mondes",
			ArmyRuleType.TraisDeBataille,
			ArmyRuleType.PhaseDeMouvement),
	NourrisDeTerreur("Nourris de Terreur", ArmyRuleType.TraisDeBataille),
	RestituerLesFigurinesTuees("RestituerLesFigurinesTuées", ArmyRuleType.TraisDeBataille),
	VagueDeTerreur("Vague de Terreur", ArmyRuleType.TraisDeBataille, ArmyRuleType.PhaseDeCharge),

	DrapeDOmbre("Drapé d'Ombre", ArmyRuleType.TraitsDeCommandement),
	EntiteTerrifiante("Entité Terrifiante", ArmyRuleType.TraitsDeCommandement),
	EspritAmer("Esprit Amer", ArmyRuleType.TraitsDeCommandement),
	EspritPersistant("Esprit Persistant", ArmyRuleType.TraitsDeCommandement),
	HaineDesVivants("Haine des Vivants", ArmyRuleType.TraitsDeCommandement),
	MaitreDesOstsDEsprits("Maître des Osts d'Esprits", ArmyRuleType.TraitsDeCommandement),

	BrumeSepulcrale("Brume Sépulcrale", ArmyRuleType.Sort),
	CageAAmes("Cage à Âmes", ArmyRuleType.Sort),
	CanuleSpectrale("Canule Spectrale", ArmyRuleType.Sort),
	DrainDEsprit("Drain d'Esprit", ArmyRuleType.Sort),
	FauxGlaneuse("Faux Glaneuse", ArmyRuleType.Sort),
	VoleurDeVie("Voleur de Vie", ArmyRuleType.Sort),

	;

	private String displayName;

	private NighthauntRule(String displayName, ArmyRuleType... types) {
		this.displayName = displayName;

	}

	@Override
	public List<ArmyRuleType> getTypes() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getDisplayName() {
		return displayName;
	}

	@Override
	public String getDescription() throws IOException {
		// TODO Auto-generated method stub
		return null;
	}
}
