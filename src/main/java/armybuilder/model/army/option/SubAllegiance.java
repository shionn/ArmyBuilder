package armybuilder.model.army.option;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

import armybuilder.model.army.Army;
import armybuilder.model.army.OldArmy;
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
					Checkers.unitWithOption(UnitOption.Artefact, DokOptimisations.BaiserDeLaMort)),
			Allegiance.DoK),
	HaggNar(
			"Temple : Hagg Nar",
			Arrays.asList(
					Modifiers.rules(DokRule.FillesDuPremierTemple, DokRule.AvancezLesChaudrons)),
			a -> a.is(Allegiance.DoK),
			Arrays.asList(
					Checkers.unitWithOption(UnitOption.TraisDeCommandement,
							DokOptimisations.DisciplesDevots),
					Checkers.unitWithOption(UnitOption.Artefact, DokOptimisations.LUlfuri)),
			Allegiance.DoK),
	KheltNar(
			"Temple : Khelt Nar",
			Arrays.asList(Modifiers.rules(DokRule.FrapperEtSeRetirer, DokRule.SaignerLEsprit)),
			a -> a.is(Allegiance.DoK),
			Arrays.asList(
					Checkers.unitWithOption(UnitOption.TraisDeCommandement,
							DokOptimisations.VolEnCercle),
					Checkers.unitWithOption(UnitOption.Artefact, DokOptimisations.LaFaixDeGalisa),
					Checkers.oneUniteLike(KeyWord.KhineraiHarpies, UnitOption.Gratuit)),
			Allegiance.DoK),
	Khailebron(
			"Temple : Khailebron",
			Arrays.asList(Modifiers.rules(DokRule.DissimulationEtDiscretion,
					DokRule.MaitressesDesOmbrevoies)),
			a -> a.is(Allegiance.DoK),
			Arrays.asList(
					Checkers.unitWithOption(UnitOption.TraisDeCommandement,
							DokOptimisations.MaitresseDeLIllusion),
					Checkers.unitWithOption(UnitOption.Artefact, DokOptimisations.Mormurmure)),
			Allegiance.DoK),
	Kraith(
			"Temple : Kraith",
			Arrays.asList(
					Modifiers.rules(DokRule.DisciplesDuMassacre, DokRule.ExalteesParLeCarnage)),
			a -> a.is(Allegiance.DoK),
			Arrays.asList(
					Checkers.unitWithOption(UnitOption.TraisDeCommandement,
							DokOptimisations.SeBaignerDansLeurSang),
					Checkers.unitWithOption(UnitOption.Artefact,
							DokOptimisations.VeninDeNagendra)),
			Allegiance.DoK),
	LOstEmeraude(
			"Processions : l'OST Emeraude",
			Arrays.asList(Modifiers.rules(NighthauntRule.LaMaledictionEmeraude,
					NighthauntRule.ChevaliersDuRegret)),
			a -> a.is(Allegiance.Nighthaunt),
			Arrays.asList(
					Checkers.unitWithOption(UnitOption.TraisDeCommandement,
							NighthauntOptimisation.SeigneurDeLOst),
					Checkers.unitWithOption(UnitOption.Artefact,
							NighthauntOptimisation.LaLameDuChevalierFelon)),
			Allegiance.Nighthaunt),
	ZaintharKai(
			"Temple : Zainthar Kai",
			Arrays.asList(Modifiers.rules(DokRule.LessenceDeKhaine, DokRule.CrypteDesAinee,
					DokRule.LePouvoirDuSang)),
			a -> a.is(Allegiance.DoK),
			Arrays.asList(
					Checkers.unitWithOption(UnitOption.TraisDeCommandement,
							DokOptimisations.MaledictionDeLaMainSanglante),
					Checkers.unitWithOption(UnitOption.Artefact,
							DokOptimisations.TalismanEcarlate)),
			Allegiance.DoK),

	;

	private String displayName;
	private List<IArmyModifier> modifiers;
	private Function<Army, Boolean> isAvailable;
	private List<Consumer<OldArmy>> checkers;
	private Allegiance allegiance;

	private SubAllegiance(String displayName, List<IArmyModifier> modifiers,
			Function<Army, Boolean> isDisplay, List<Consumer<OldArmy>> checkers, Allegiance allegiance) {
		this.displayName = displayName;
		this.modifiers = modifiers;
		this.isAvailable = isDisplay;
		this.checkers = checkers;
		this.allegiance = allegiance;
	}

	@Override
	public String getDisplayName() {
		return displayName;
	}

	@Deprecated
	@Override
	public ArmyOption getOption() {
		return ArmyOption.SubAllegiance;
	}

	@Deprecated
	@Override
	public boolean isOptionDisplayed(OldArmy army) {
		return false;
	}

	@Deprecated
	@Override
	public int compare(SubAllegiance o1, SubAllegiance o2) {
		return o1.getDisplayName().compareTo(o2.getDisplayName());
	}

	@Deprecated
	@Override
	public void rebuild(OldArmy army) {
		modifiers.stream().forEach(m -> m.accept(army));
	}

	@Deprecated
	@Override
	public void verify(OldArmy army) {
		checkers.stream().forEach(c -> c.accept(army));
	}

	@Deprecated
	@Override
	public boolean isAvailable(OldArmy army, Unit unit) {
		return false;
	}

	public boolean availableFor(Army army) {
		return isAvailable.apply(army);
	}

	public Allegiance allegiance() {
		return allegiance;
	}

}
