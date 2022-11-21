package armybuilder.modelold.deprecated;

import java.util.Arrays;
import java.util.List;

import armybuilder.model.rule.RuleType;

public class Turn {

	public enum Phase {
		Héros(
				"1 Phase des Héros",
				Arrays.asList(Arrays.asList(RuleType.Aptitude, RuleType.PhaseDesHeros),
						Arrays.asList(RuleType.ActionsHeroiques),
						Arrays.asList(RuleType.AptitudesDeCommandement, RuleType.PhaseDesHeros),
						Arrays.asList(RuleType.Sort), Arrays.asList(RuleType.Priere))),
		Mouvement(
				"2 Phase de Mouvement",
				Arrays.asList(Arrays.asList(RuleType.TraitsDeCommandement, RuleType.PhaseDeMouvement),
						Arrays.asList(RuleType.AptitudesDeCommandement, RuleType.PhaseDeMouvement))),
		Tir(
				"3 Phase de Tir",
				Arrays.asList(Arrays.asList(RuleType.Triomphes, RuleType.PhaseDeTir),
						Arrays.asList(RuleType.AptitudesDeCommandement, RuleType.PhaseDeTir),
						Arrays.asList(RuleType.PhaseDeTir))),
		Charge(
				"4 Phase de Charge",
				Arrays.asList(Arrays.asList(RuleType.Triomphes, RuleType.PhaseDeCharge),
						Arrays.asList(RuleType.AptitudesDeCommandement, RuleType.PhaseDeCharge),
						Arrays.asList(RuleType.PhaseDeCharge), Arrays.asList(RuleType.FureursMonstrueuses))),
		Combat(
				"5 Phase de Combat",
				Arrays.asList(Arrays.asList(RuleType.Triomphes, RuleType.PhaseDeCombat),
						Arrays.asList(RuleType.AptitudesDeCommandement, RuleType.PhaseDeCombat),
						Arrays.asList(RuleType.PhaseDeCombat))),
		Deroute(
				"6 Phase de Déroute",
				Arrays.asList(Arrays.asList(RuleType.Triomphes, RuleType.PhaseDeCharge),
						Arrays.asList(RuleType.AptitudesDeCommandement, RuleType.PhaseDeDeroute),
						Arrays.asList(RuleType.Aptitude, RuleType.PhaseDeDeroute)));

		private String name;
		private List<List<RuleType>> steps;

		Phase(String name, List<List<RuleType>> steps) {
			this.name = name;
			this.steps = steps;
		}

		public String getName() {
			return name;
		}

		public List<List<RuleType>> getSteps() {
			return steps;
		}
	}

	public Phase[] getPhases() {
		return Phase.values();
	}

}