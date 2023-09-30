package armybuilder.model.army.turn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

import armybuilder.model.army.Army;
import armybuilder.model.rule.IRule;
import armybuilder.model.rule.RuleType;

public class TurnStepBuilder {

	private static final String DÉBUT = "Début";
	private static final String EN_COURS = "En cours";
	private static final String FIN = "Fin";

	public List<TurnStep> build(Army army) {
		List<TurnStep> steps = new ArrayList<TurnStep>();
		steps.add(buildHero(army));
		steps.add(buildMovement(army));
		steps.add(buildShot(army));
		steps.add(buildCharge(army));
		steps.add(buildBattle(army));
		steps.add(buildDeroute(army));
		return steps;
	}

	private TurnStep buildHero(Army army) {
		return TurnStep.builder()
				.name("Héro")
				.subs(Arrays.asList(buildHeroStart(army), buildHeroDuring(army), buildHeroEnd()))
				.build();
	}

	private TurnStep buildHeroStart(Army army) {
		List<TurnStep> subs = new ArrayList<TurnStep>();
		subs.add(TurnStep.builder().name("Actions héroĩques").build());
		subs.add(TurnStep.builder().name("Conjuration / Bannissement").build());
		subs.add(TurnStep.builder().name("Ralliement").build());
		subs.addAll(buildFromRule(army, r -> r.is(RuleType.PhaseDesHerosPlayerDebut)));
		return TurnStep.builder().name(DÉBUT).subs(subs).build();
	}

	private TurnStep buildHeroDuring(Army army) {
		List<TurnStep> subs = new ArrayList<TurnStep>();
		subs.addAll(buildFromRule(army, r -> r.isOne(RuleType.PhaseDesHeros, RuleType.PhaseDesHerosPlayer)));
		List<TurnStep> subSpells = new ArrayList<TurnStep>();
		subSpells.add(TurnStep.builder().name("Sort Persistant").build());
		subSpells.addAll(buildFromRule(army, r -> r.is(RuleType.Sort)));
		subs.add(TurnStep.builder()
				.name("Sort / Dissipation <em>(30\")</em>")
				.subs(subSpells)
				.build());
		subs.add(TurnStep.builder().name("Prière").subs(buildFromRule(army, r -> r.is(RuleType.Priere))).build());
		return TurnStep.builder()
				.name(EN_COURS)
				.subs(subs)
				.build();
	}

	private TurnStep buildHeroEnd() {
		return TurnStep.builder()
				.name(FIN)
				.subs(Arrays.asList(TurnStep.builder().name("Sort prédateur").build()))
				.build();
	}

	private TurnStep buildMovement(Army army) {
		return TurnStep.builder()
				.name("Mouvement")
				.subs(Arrays.asList(buildMovementStart(army), buildMovementDuring(army), buildMovementEnd(army)))
				.build();
	}

	private TurnStep buildMovementStart(Army army) {
		return TurnStep.builder()
				.name(DÉBUT)
				.subs(buildFromRule(army, r -> r.isOne(RuleType.PhaseDeMouvementPlayerDebut)))
				.build();
	}

	private TurnStep buildMovementDuring(Army army) {
		List<TurnStep> subs = new ArrayList<TurnStep>();
		subs.addAll(buildFromRule(army, r -> r.isOne(RuleType.PhaseDeMouvement, RuleType.PhaseDeMouvementPlayer)));
		subs.add(TurnStep.builder().name("Au Pas de Course").build());
		subs.add(TurnStep.builder().name("Redéploiement").build());
		return TurnStep.builder()
				.name(EN_COURS)
				.subs(subs)
				.build();
	}

	private TurnStep buildMovementEnd(Army army) {
		return TurnStep.builder()
				.name(FIN)
				.subs(buildFromRule(army, r -> r.isOne(RuleType.PhaseDeMouvementPlayerFin)))
				.build();
	}

	private TurnStep buildShot(Army army) {
		return TurnStep.builder()
				.name("Tir")
				.subs(Arrays.asList(buildShotStart(army), buildShotDuring(army)))
				.build();
	}

	private TurnStep buildShotStart(Army army) {
		return TurnStep.builder()
				.name(DÉBUT)
				.subs(buildFromRule(army, r -> r.isOne(RuleType.PhaseDeTirPlayerDebut)))
				.build();
	}

	private TurnStep buildShotDuring(Army army) {
		List<TurnStep> subs = new ArrayList<TurnStep>();
		subs.add(TurnStep.builder().name("Attaque / Défense en Règle").build());
		return TurnStep.builder().name(EN_COURS).subs(subs).build();
	}

	private TurnStep buildCharge(Army army) {
		return TurnStep.builder()
				.name("Charge")
				.subs(Arrays.asList(
//						buildChargeStart(army),
						buildChargeDuring(army), buildChargeEnd(army)))
				.build();
	}

//	private TurnStep buildChargeStart(Army army) {
//		return TurnStep.builder().name("Début").build();
//	}

	private TurnStep buildChargeDuring(Army army) {
		List<TurnStep> subs = new ArrayList<TurnStep>();
		subs.add(TurnStep.builder().name("En Avant, Vers la Victoire").build());
		subs.add(TurnStep.builder().name("Déchaîner les Enfers").build());
		return TurnStep.builder().name(EN_COURS).subs(subs).build();
	}

	private TurnStep buildChargeEnd(Army army) {
		List<TurnStep> subs = new ArrayList<TurnStep>();
		subs.add(TurnStep.builder().name("Fureur monstrueuse").build());
		return TurnStep.builder().name(FIN).subs(subs).build();
	}

	private TurnStep buildBattle(Army army) {
		return TurnStep.builder()
				.name("Combat")
				.subs(Arrays.asList(buildBattleStart(army), buildBattleDuring(army)))
				.build();
	}

	private TurnStep buildBattleStart(Army army) {
		List<TurnStep> subs = new ArrayList<TurnStep>();
		subs.addAll(buildFromRule(army, r -> r.isOne(RuleType.PhaseDeCombatDebut)));
		return TurnStep.builder().name(DÉBUT).subs(subs).build();
	}

	private TurnStep buildBattleDuring(Army army) {
		List<TurnStep> subs = new ArrayList<TurnStep>();
		subs.add(TurnStep.builder().name("Attaque / Défense en Règle").build());
		subs.addAll(buildFromRule(army, r -> r.isOne(RuleType.PhaseDeCombat)));
		return TurnStep.builder().name(EN_COURS).subs(subs).build();
	}

	private List<TurnStep> buildFromRule(Army army, Predicate<IRule<?>> predicate) {
		return army.getUnits()
				.stream()
				.flatMap(u -> u.rules(predicate)
						.stream()
						.filter(r -> r.is(RuleType.MemoDisplay)))
				.distinct()
				.sorted()
				.map(rule -> TurnStep.builder().name(rule.getDisplayName()).rule(rule).build())
				.toList();
	}

	private TurnStep buildDeroute(Army army) {
		return TurnStep.builder()
				.name("Déroute")
				.subs(Arrays.asList(buildDerouteStart(army)))
				.build();
	}

	private TurnStep buildDerouteStart(Army army) {
		List<TurnStep> subs = new ArrayList<TurnStep>();
		subs.add(TurnStep.builder().name("Présence Exaltante").build());
		return TurnStep.builder().name(DÉBUT).subs(subs).build();
	}

//	private String overline(String string) {
//		return "<span style=\"text-decoration:overline\">" + string + "</span>";
//	}
}
