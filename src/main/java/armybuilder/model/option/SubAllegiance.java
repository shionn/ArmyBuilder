package armybuilder.model.option;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

import armybuilder.model.Army;
import armybuilder.model.check.Checkers;
import armybuilder.model.dok.DokOptimisations;
import armybuilder.model.dok.DokRule;
import armybuilder.model.modifier.IArmyModifier;
import armybuilder.model.modifier.Modifiers;
import armybuilder.model.test.Tests;
import armybuilder.model.unit.KeyWord;
import armybuilder.model.unit.option.UnitOption;

public enum SubAllegiance implements IArmyOptionValue<SubAllegiance>, Comparator<SubAllegiance> {
	DraichiGaneth(
			"Temple : Draichi Ganeth",
			Arrays.asList(
					Modifiers.rules(DokRule.TueusesHerisseesDeLames, DokRule.UnMillierDeStyles)),
			Tests.isAllegiance(Allegiance.DoK),
			Arrays.asList(
					Checkers.unitWithOption(UnitOption.TraisDeCommandement,
							DokOptimisations.VainqueurDuYaithRil),
					Checkers.unitWithOption(UnitOption.Artefact, DokOptimisations.BaiserDeLaMort))),
	HaggNar(
			"Temple : Hagg Nar",
			Arrays.asList(
					Modifiers.rules(DokRule.FillesDuPremierTemple, DokRule.AvancezLesChaudrons)),
			Tests.isAllegiance(Allegiance.DoK),
			Arrays.asList(
					Checkers.unitWithOption(UnitOption.TraisDeCommandement,
							DokOptimisations.DisciplesDevots),
					Checkers.unitWithOption(UnitOption.Artefact, DokOptimisations.LUlfuri))),
	KheltNar(
			"Temple : Khelt Nar",
			Arrays.asList(Modifiers.rules(DokRule.FrapperEtSeRetirer, DokRule.SaignerLEsprit)),
			Tests.isAllegiance(Allegiance.DoK),
			Arrays.asList(
					Checkers.unitWithOption(UnitOption.TraisDeCommandement,
							DokOptimisations.VolEnCercle),
					Checkers.unitWithOption(UnitOption.Artefact, DokOptimisations.LaFaixDeGalisa),
					Checkers.oneUniteLike(KeyWord.KhineraiHarpies, UnitOption.Gratuit))),
	Khailebron(
			"Temple : Khailebron",
			Arrays.asList(Modifiers.rules(DokRule.DissimulationEtDiscretion,
					DokRule.MaitressesDesOmbrevoies)),
			Tests.isAllegiance(Allegiance.DoK),
			Arrays.asList(
					Checkers.unitWithOption(UnitOption.TraisDeCommandement,
							DokOptimisations.MaitresseDeLIllusion),
					Checkers.unitWithOption(UnitOption.Artefact, DokOptimisations.Mormurmure))),
	Kraith(
			"Temple : Kraith",
			Arrays.asList(
					Modifiers.rules(DokRule.DisciplesDuMassacre, DokRule.ExalteesParLeCarnage)),
			Tests.isAllegiance(Allegiance.DoK),
			Arrays.asList(
					Checkers.unitWithOption(UnitOption.TraisDeCommandement,
							DokOptimisations.SeBaignerDansLeurSang),
					Checkers.unitWithOption(UnitOption.Artefact,
							DokOptimisations.VeninDeNagendra))),
	ZaintharKai(
			"Temple : Zainthar Kai",
			Arrays.asList(Modifiers.rules(DokRule.LessenceDeKhaine, DokRule.CrypteDesAinee,
					DokRule.LePouvoirDuSang)),
			Tests.isAllegiance(Allegiance.DoK),
			Arrays.asList(
					Checkers.unitWithOption(UnitOption.TraisDeCommandement,
							DokOptimisations.MaledictionDeLaMainSanglante),
					Checkers.unitWithOption(UnitOption.Artefact,
							DokOptimisations.TalismanEcarlate)));

	private String displayName;
	private List<IArmyModifier> modifiers;
	private Function<Army, Boolean> isDisplay;
	private List<Consumer<Army>> checkers;

	private SubAllegiance(String displayName, List<IArmyModifier> modifiers,
			Function<Army, Boolean> isDisplay, List<Consumer<Army>> checkers) {
		this.displayName = displayName;
		this.modifiers = modifiers;
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
		modifiers.stream().forEach(m -> m.accept(army));
		army.getUnits().stream().filter(u -> !u.is(KeyWord.HaggNar))
				.forEach(u -> u.add(KeyWord.valueOf(name())));
	}

	@Override
	public void verify(Army army) {
		checkers.stream().forEach(c -> c.accept(army));
	}

}
