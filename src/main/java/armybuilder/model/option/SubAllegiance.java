package armybuilder.model.option;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

import armybuilder.model.Army;
import armybuilder.model.check.Checkers;
import armybuilder.model.modifier.IArmyModifier;
import armybuilder.model.modifier.Modifiers;
import armybuilder.model.rule.DokRule;
import armybuilder.model.test.Tests;
import armybuilder.model.unit.dok.DokOptimisations;
import armybuilder.model.unit.option.UnitOption;

public enum SubAllegiance implements IArmyOptionValue<SubAllegiance>, Comparator<SubAllegiance> {
	HaggNar(
			"Temple : Hagg Nar",
			Modifiers.rules(DokRule.FillesDuPremierTemple, DokRule.AvancezLesChaudrons),
			Tests.isAllegiance(Allegiance.DoK),
			Arrays.asList(
					Checkers.unitWithOption(UnitOption.TraisDeCommandement,
							DokOptimisations.DisciplesDevots),
					Checkers.unitWithOption(UnitOption.Artefact, DokOptimisations.LUlfuri))),
	DraichiGaneth(
			"Temple : Draichi Ganeth",
			Modifiers.rules(DokRule.TueusesHerisseesDeLames),
			Tests.isAllegiance(Allegiance.DoK),
			Arrays.asList()),
	Kraith(
			"Temple : Kraith",
			Modifiers.rules(DokRule.DisciplesDuMassacre),
			Tests.isAllegiance(Allegiance.DoK),
			Arrays.asList()),
	Khailebron(
			"Temple : Khailebron",
			Modifiers.rules(DokRule.DissimulationEtDiscretion),
			Tests.isAllegiance(Allegiance.DoK),
			Arrays.asList()),
	KheltNar(
			"Temple : Khelt Nar",
			Modifiers.rules(DokRule.FrapperEtSeRetirer),
			Tests.isAllegiance(Allegiance.DoK),
			Arrays.asList()),
	ZaintharKai(
			"Temple : Zainthar Kai",
			Modifiers.rules(DokRule.LessenceDeKhaine, DokRule.CrypteDesAinee),
			Tests.isAllegiance(Allegiance.DoK),
			Arrays.asList());

	private String displayName;
	private IArmyModifier modifier;
	private Function<Army, Boolean> isDisplay;
	private List<Consumer<Army>> checkers;

	private SubAllegiance(String displayName, IArmyModifier modifier,
			Function<Army, Boolean> isDisplay, List<Consumer<Army>> checkers) {
		this.displayName = displayName;
		this.modifier = modifier;
		this.isDisplay = isDisplay;
		this.checkers = checkers;
	}

	@Override
	public String getDisplayName() {
		return displayName;
	}

	@Override
	public ArmyOption getOption() {
		return ArmyOption.SubAllegiance;
	}

	@Override
	public boolean isOptionDisplayed(Army army) {
		return isDisplay.apply(army);
	}

	@Override
	public int compare(SubAllegiance o1, SubAllegiance o2) {
		return o1.getDisplayName().compareTo(o2.getDisplayName());
	}

	@Override
	public void rebuild(Army army) {
		modifier.accept(army);
	}

	@Override
	public void verify(Army army) {
		checkers.stream().forEach(c -> c.accept(army));
	}

}
