package armybuilder.model.army;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

import armybuilder.model.dok.DokRule;
import armybuilder.model.rule.IRule;
import armybuilder.model.unit.keyword.KeyWord;
import armybuilder.model.unit.role.RoleTactique;
import armybuilder.modelold.deprecated.army.Listing;
import armybuilder.modelold.deprecated.nighthaunt.NighthauntRule;
import armybuilder.serialisation.EnumPropertyLoader;

public enum SubAllegiance {
	DraichiGaneth(
			Arrays.asList(DokRule.TueusesHerisseesDeLames),
			Allegiance.DoK,
			l -> l.units()
					.stream()
					.filter(u -> !u.is(KeyWord.HaggNar) && !u.is(RoleTactique.SortsPersistantsEtInvocation))
					.forEach(u -> u.add(KeyWord.DraichiGaneth))),
	HaggNar(
			Arrays.asList(DokRule.FillesDuPremierTemple),
			Allegiance.DoK,
			l -> l.units()
					.stream()
					.filter(u -> !u.is(KeyWord.HaggNar) && !u.is(RoleTactique.SortsPersistantsEtInvocation))
					.forEach(u -> u.add(KeyWord.HaggNar))),
	KheltNar(
			Arrays.asList(DokRule.FrapperEtSeRetirer),
			Allegiance.DoK,
			l -> l.units()
					.stream()
					.filter(u -> !u.is(KeyWord.HaggNar) && !u.is(RoleTactique.SortsPersistantsEtInvocation))
					.forEach(u -> u.add(KeyWord.KheltNar))),
	Khailebron(
			Arrays.asList(DokRule.MaitressesDesOmbrevoies),
			Allegiance.DoK,
			l -> l.units()
					.stream()
					.filter(u -> !u.is(KeyWord.HaggNar) && !u.is(RoleTactique.SortsPersistantsEtInvocation))
					.forEach(u -> u.add(KeyWord.Khailebron))),
	Kraith(
			Arrays.asList(DokRule.DisciplesDuMassacre),
			Allegiance.DoK,
			l -> l.units()
					.stream()
					.filter(u -> !u.is(KeyWord.HaggNar) && !u.is(RoleTactique.SortsPersistantsEtInvocation))
					.forEach(u -> u.add(KeyWord.Kraith))),
	LOstEmeraude(
			Arrays.asList(NighthauntRule.LaMaledictionEmeraude, NighthauntRule.ChevaliersDuRegret),
			Allegiance.Nighthaunt,
			null),
	ZaintharKai(
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

	private SubAllegiance(List<IRule<?>> rules, Allegiance allegiance,
			Consumer<Listing> modifier) {
		this.displayName = EnumPropertyLoader.instance().name(this);
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
