package armybuilder.model.army.bataillon;

import java.util.Arrays;
import java.util.List;

import armybuilder.model.rule.IRule;
import armybuilder.model.rule.RuleType;
import armybuilder.serialisation.DescriptionReader;

public enum BataillonRule implements IRule<BataillonRule> {
	Unifies("Unifiés", RuleType.Aptitude),
	Experts("Experts", RuleType.AptitudesDeCommandement, RuleType.PhaseDeTir, RuleType.PhaseDeCombat),
	Magnifiques("Magnifiques", RuleType.Composition),
	Tueurs("Tueurs", RuleType.AptitudesDeCommandement, RuleType.PhaseDeTir, RuleType.PhaseDeCombat,
			RuleType.PhaseDeCharge),
	Strateges("Stratèges", RuleType.Aptitude, RuleType.PhaseDesHeros),
	Rapides("Rapides", RuleType.AptitudesDeCommandement, RuleType.PhaseDeMouvement),
	PisterALOdeur("Pister à l'Odeur", RuleType.Aptitude, RuleType.PhaseBeforeStart),
	OutsidersExperts("Outsiders Experts", RuleType.Aptitude),
	ForceDominatrice("Force Dominatrice", RuleType.Aptitude),
	ChasseursDeTetes("Chasseur de Têtes", RuleType.Aptitude);

	private String displayName;
	private List<RuleType> types;

	private BataillonRule(String displayName, RuleType... types) {
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
	public String getDescription() {
		return new DescriptionReader().read("Generique/Bataillon/", this);
	}


}
