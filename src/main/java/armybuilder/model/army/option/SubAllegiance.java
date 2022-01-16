package armybuilder.model.army.option;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

import armybuilder.model.army.Army;
import armybuilder.model.army.check.Checkers;
import armybuilder.model.army.modifier.IArmyModifier;
import armybuilder.model.army.modifier.Modifiers;
import armybuilder.model.dok.DokOptimisations;
import armybuilder.model.dok.DokRule;
import armybuilder.model.nighthaunt.NighthauntOptimisation;
import armybuilder.model.nighthaunt.NighthauntRule;
import armybuilder.model.unit.KeyWord;
import armybuilder.model.unit.Unit;
import armybuilder.model.unit.option.UnitOption;

public enum SubAllegiance implements IArmyOptionValue<SubAllegiance>, Comparator<SubAllegiance> {
	DraichiGaneth(
			"Temple : Draichi Ganeth",
			Arrays.asList(
					Modifiers.rules(DokRule.TueusesHerisseesDeLames, DokRule.UnMillierDeStyles)),
			a -> a.is(Allegiance.DoK),
			Arrays.asList(
					Checkers.unitWithOption(UnitOption.TraisDeCommandement,
							DokOptimisations.VainqueurDuYaithRil),
					Checkers.unitWithOption(UnitOption.Artefact, DokOptimisations.BaiserDeLaMort))),
	HaggNar(
			"Temple : Hagg Nar",
			Arrays.asList(
					Modifiers.rules(DokRule.FillesDuPremierTemple, DokRule.AvancezLesChaudrons)),
			a -> a.is(Allegiance.DoK),
			Arrays.asList(
					Checkers.unitWithOption(UnitOption.TraisDeCommandement,
							DokOptimisations.DisciplesDevots),
					Checkers.unitWithOption(UnitOption.Artefact, DokOptimisations.LUlfuri))),
	KheltNar(
			"Temple : Khelt Nar",
			Arrays.asList(Modifiers.rules(DokRule.FrapperEtSeRetirer, DokRule.SaignerLEsprit)),
			a -> a.is(Allegiance.DoK),
			Arrays.asList(
					Checkers.unitWithOption(UnitOption.TraisDeCommandement,
							DokOptimisations.VolEnCercle),
					Checkers.unitWithOption(UnitOption.Artefact, DokOptimisations.LaFaixDeGalisa),
					Checkers.oneUniteLike(KeyWord.KhineraiHarpies, UnitOption.Gratuit))),
	Khailebron(
			"Temple : Khailebron",
			Arrays.asList(Modifiers.rules(DokRule.DissimulationEtDiscretion,
					DokRule.MaitressesDesOmbrevoies)),
			a -> a.is(Allegiance.DoK),
			Arrays.asList(
					Checkers.unitWithOption(UnitOption.TraisDeCommandement,
							DokOptimisations.MaitresseDeLIllusion),
					Checkers.unitWithOption(UnitOption.Artefact, DokOptimisations.Mormurmure))),
	Kraith(
			"Temple : Kraith",
			Arrays.asList(
					Modifiers.rules(DokRule.DisciplesDuMassacre, DokRule.ExalteesParLeCarnage)),
			a -> a.is(Allegiance.DoK),
			Arrays.asList(
					Checkers.unitWithOption(UnitOption.TraisDeCommandement,
							DokOptimisations.SeBaignerDansLeurSang),
					Checkers.unitWithOption(UnitOption.Artefact,
							DokOptimisations.VeninDeNagendra))),

	LOstEmeraude(
			"Processions : l'OST Emeraude",
			Arrays.asList(Modifiers.rules(NighthauntRule.LaMaledictionEmeraude,
					NighthauntRule.ChevaliersDuRegret)),
			a -> a.is(Allegiance.Nighthaunt),
			Arrays.asList(
					Checkers.unitWithOption(UnitOption.TraisDeCommandement,
							NighthauntOptimisation.SeigneurDeLOst),
					Checkers.unitWithOption(UnitOption.Artefact,
							NighthauntOptimisation.LaLameDuChevalierFelon))),
	ZaintharKai(
			"Temple : Zainthar Kai",
			Arrays.asList(Modifiers.rules(DokRule.LessenceDeKhaine, DokRule.CrypteDesAinee,
					DokRule.LePouvoirDuSang)),
			a -> a.is(Allegiance.DoK),
			Arrays.asList(
					Checkers.unitWithOption(UnitOption.TraisDeCommandement,
							DokOptimisations.MaledictionDeLaMainSanglante),
					Checkers.unitWithOption(UnitOption.Artefact,
							DokOptimisations.TalismanEcarlate))),

	TousLesTemples(
			"Tous les Temples",
			Arrays.asList(
			// Modifiers.optimisations(SubAllegiance.HaggNar, DokRule.FillesDuPremierTemple,
			// DokRule.AvancezLesChaudrons, DokRule.DisciplesDevots, DokRule.LUlfuri)
					Modifiers.rules(DokRule.HaggNarDesc, DokRule.KheltNarDesc,
							DokRule.ZaintharKaiDesc)
			// Modifiers.rules(HaggNar, KheltNar, ZaintharKai)
			),
			a -> a.is(Allegiance.DoK),
			Arrays.asList()),

	;

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

	@Override
	public boolean isAvailable(Army army, Unit unit) {
		return false;
	}

}
