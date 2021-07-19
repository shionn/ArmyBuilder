package armybuilder.model;

import java.util.Comparator;
import java.util.function.Function;

import armybuilder.model.dok.DokRule;
import armybuilder.model.i.IArmyModifier;
import armybuilder.model.i.IArmyOption;
import armybuilder.model.test.Tests;

public enum SubAllegiance implements IArmyOption<SubAllegiance>, Comparator<SubAllegiance> {
	HaggNar(
			"Temple : Hagg Nar",
			Modifiers.rules(DokRule.FillesDuPremierTemple),
			Tests.isAllegiance(Allegiance.DoK)),
	DraichiGaneth(
			"Temple : Draichi Ganeth",
			Modifiers.rules(DokRule.TueusesHerisseesDeLames),
			Tests.isAllegiance(Allegiance.DoK)),
	Kraith(
			"Temple : Kraith",
			Modifiers.rules(DokRule.DisciplesDuMassacre),
			Tests.isAllegiance(Allegiance.DoK)),
	Khailebron(
			"Temple : Khailebron",
			Modifiers.rules(DokRule.DissimulationEtDiscretion),
			Tests.isAllegiance(Allegiance.DoK)),
	KheltNar(
			"Temple : Khelt Nar",
			Modifiers.rules(DokRule.FrapperEtSeRetirer),
			Tests.isAllegiance(Allegiance.DoK)),
	ZaintharKai(
			"Temple : Zainthar Kai",
			Modifiers.rules(DokRule.LessenceDeKhaine, DokRule.CrypteDesAinee),
			Tests.isAllegiance(Allegiance.DoK));

	private String displayName;
	private IArmyModifier<SubAllegiance> modifier;
	private Function<Army, Boolean> isDisplay;

	private SubAllegiance(String displayName, IArmyModifier<SubAllegiance> modifier,
			Function<Army, Boolean> isDisplay) {
		this.displayName = displayName;
		this.modifier = modifier;
		this.isDisplay = isDisplay;
	}

	@Override
	public String getDisplayName() {
		return displayName;
	}

	@Override
	public ArmyOptionType getType() {
		return ArmyOptionType.SubAllegiance;
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
		if (modifier != null) {
			modifier.accept(this, army);
		}
	}

}
