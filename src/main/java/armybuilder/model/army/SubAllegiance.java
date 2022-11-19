package armybuilder.model.army;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

import armybuilder.model.dok.DokRule;
import armybuilder.model.rule.IRule;
import armybuilder.model.unit.RoleTactique;
import armybuilder.modelold.deprecated.army.Listing;
import armybuilder.modelold.deprecated.nighthaunt.NighthauntRule;
import armybuilder.modelold.deprecated.unit.KeyWord;

public enum SubAllegiance {
	DraichiGaneth(
			"Temple : Draichi Ganeth",
			Arrays.asList(DokRule.TueusesHerisseesDeLames),
			Allegiance.DoK,
			l -> l.units()
					.stream()
					.filter(u -> !u.is(KeyWord.HaggNar) && !u.is(RoleTactique.SortsPersistantsEtInvocation))
					.forEach(u -> u.add(KeyWord.DraichiGaneth))),
	HaggNar(
			"Temple : Hagg Nar",
			Arrays.asList(DokRule.FillesDuPremierTemple),
			Allegiance.DoK,
			l -> l.units()
					.stream()
					.filter(u -> !u.is(KeyWord.HaggNar) && !u.is(RoleTactique.SortsPersistantsEtInvocation))
					.forEach(u -> u.add(KeyWord.HaggNar))),
	KheltNar(
			"Temple : Khelt Nar",
			Arrays.asList(DokRule.FrapperEtSeRetirer),
			Allegiance.DoK,
			l -> l.units()
					.stream()
					.filter(u -> !u.is(KeyWord.HaggNar) && !u.is(RoleTactique.SortsPersistantsEtInvocation))
					.forEach(u -> u.add(KeyWord.KheltNar))),
	Khailebron(
			"Temple : Khailebron",
			Arrays.asList(DokRule.MaitressesDesOmbrevoies),
			Allegiance.DoK,
			l -> l.units()
					.stream()
					.filter(u -> !u.is(KeyWord.HaggNar) && !u.is(RoleTactique.SortsPersistantsEtInvocation))
					.forEach(u -> u.add(KeyWord.Khailebron))),
	Kraith(
			"Temple : Kraith",
			Arrays.asList(DokRule.DisciplesDuMassacre),
			Allegiance.DoK,
			l -> l.units()
					.stream()
					.filter(u -> !u.is(KeyWord.HaggNar) && !u.is(RoleTactique.SortsPersistantsEtInvocation))
					.forEach(u -> u.add(KeyWord.Kraith))),
	LOstEmeraude(
			"Processions : l'OST Emeraude",
			Arrays.asList(NighthauntRule.LaMaledictionEmeraude, NighthauntRule.ChevaliersDuRegret),
			Allegiance.Nighthaunt,
			null),
	ZaintharKai(
			"Temple : Zainthar Kai",
			Arrays.asList(DokRule.LessenceDeKhaine),
			Allegiance.DoK,
			l -> l.units()
					.stream()
					.filter(u -> !u.is(KeyWord.HaggNar) && !u.is(RoleTactique.SortsPersistantsEtInvocation))
					.forEach(u -> u.add(KeyWord.ZaintharKai))),

	;

	private String displayName;
	private List<IRule<?>> rules;
	private Allegiance allegiance;
	private Consumer<Listing> modifier;

	private SubAllegiance(String displayName, List<IRule<?>> rules,
			Allegiance allegiance, Consumer<Listing> modifier) {
		this.displayName = displayName;
		this.rules = rules;
		this.allegiance = allegiance;
		this.modifier = modifier;
	}

	public boolean available(Army army) {
		return army.is(allegiance);
	}

	public String getDisplayName() {
		return displayName;
	}

}