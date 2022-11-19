package armybuilder.modelold.deprecated;

import java.util.Arrays;
import java.util.List;

import armybuilder.modelold.deprecated.army.rule.ArmyRuleType;

public class Turn {

	public enum Phase {
		Héros(
				"1 Phase des Héros",
				Arrays.asList(Arrays.asList(ArmyRuleType.Aptitude, ArmyRuleType.PhaseDesHeros),
						Arrays.asList(ArmyRuleType.ActionsHeroiques),
						Arrays.asList(ArmyRuleType.AptitudesDeCommandement, ArmyRuleType.PhaseDesHeros),
						Arrays.asList(ArmyRuleType.Sort), Arrays.asList(ArmyRuleType.Priere))),
		Mouvement(
				"2 Phase de Mouvement",
				Arrays.asList(Arrays.asList(ArmyRuleType.TraitsDeCommandement, ArmyRuleType.PhaseDeMouvement),
						Arrays.asList(ArmyRuleType.AptitudesDeCommandement, ArmyRuleType.PhaseDeMouvement))),
		Tir(
				"3 Phase de Tir",
				Arrays.asList(Arrays.asList(ArmyRuleType.Triomphes, ArmyRuleType.PhaseDeTir),
						Arrays.asList(ArmyRuleType.AptitudesDeCommandement, ArmyRuleType.PhaseDeTir),
						Arrays.asList(ArmyRuleType.PhaseDeTir))),
		Charge(
				"4 Phase de Charge",
				Arrays.asList(Arrays.asList(ArmyRuleType.Triomphes, ArmyRuleType.PhaseDeCharge),
						Arrays.asList(ArmyRuleType.AptitudesDeCommandement, ArmyRuleType.PhaseDeCharge),
						Arrays.asList(ArmyRuleType.PhaseDeCharge), Arrays.asList(ArmyRuleType.FureursMonstrueuses))),
		Combat(
				"5 Phase de Combat",
				Arrays.asList(Arrays.asList(ArmyRuleType.Triomphes, ArmyRuleType.PhaseDeCombat),
						Arrays.asList(ArmyRuleType.AptitudesDeCommandement, ArmyRuleType.PhaseDeCombat),
						Arrays.asList(ArmyRuleType.PhaseDeCombat))),
		Deroute(
				"6 Phase de Déroute",
				Arrays.asList(Arrays.asList(ArmyRuleType.Triomphes, ArmyRuleType.PhaseDeCharge),
						Arrays.asList(ArmyRuleType.AptitudesDeCommandement, ArmyRuleType.PhaseDeDeroute),
						Arrays.asList(ArmyRuleType.Aptitude, ArmyRuleType.PhaseDeDeroute)));

		private String name;
		private List<List<ArmyRuleType>> steps;

		Phase(String name, List<List<ArmyRuleType>> steps) {
			this.name = name;
			this.steps = steps;
		}

		public String getName() {
			return name;
		}

		public List<List<ArmyRuleType>> getSteps() {
			return steps;
		}
	}

	public Phase[] getPhases() {
		return Phase.values();
	}

}