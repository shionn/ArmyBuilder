package armybuilder.model.army;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

import armybuilder.model.IHaveDisplayName;
import armybuilder.model.dok.DokRule;
import armybuilder.model.rule.IRule;
import armybuilder.model.unit.keyword.KeyWord;
import armybuilder.model.unit.role.RoleTactique;
import armybuilder.serialisation.EnumPropertyLoader;

public enum SubAllegiance implements IHaveDisplayName, IDecoreArmy {
	DraichiGaneth(
			Arrays.asList(DokRule.TueusesHerisseesDeLames),
			Allegiance.DoK,
			a -> a.getUnits()
					.stream()
					.filter(u -> !u.is(KeyWord.HaggNar) && !u.is(RoleTactique.SortsPersistantsEtInvocation))
					.forEach(u -> u.add(KeyWord.DraichiGaneth))),
	HaggNar(
			Arrays.asList(DokRule.FillesDuPremierTemple),
			Allegiance.DoK,
			a -> a.getUnits()
					.stream()
					.filter(u -> !u.is(KeyWord.HaggNar) && !u.is(RoleTactique.SortsPersistantsEtInvocation))
					.forEach(u -> u.add(KeyWord.HaggNar))),
	KheltNar(
			Arrays.asList(DokRule.FrapperEtSeRetirer),
			Allegiance.DoK,
			a -> a.getUnits()
					.stream()
					.filter(u -> !u.is(KeyWord.HaggNar) && !u.is(RoleTactique.SortsPersistantsEtInvocation))
					.forEach(u -> u.add(KeyWord.KheltNar))),
	Khailebron(
			Arrays.asList(DokRule.MaitressesDesOmbrevoies),
			Allegiance.DoK,
			a -> a.getUnits()
					.stream()
					.filter(u -> !u.is(KeyWord.HaggNar) && !u.is(RoleTactique.SortsPersistantsEtInvocation))
					.forEach(u -> u.add(KeyWord.Khailebron))),
	Kraith(
			Arrays.asList(DokRule.DisciplesDuMassacre),
			Allegiance.DoK,
			a -> a.getUnits()
					.stream()
					.filter(u -> !u.is(KeyWord.HaggNar) && !u.is(RoleTactique.SortsPersistantsEtInvocation))
					.forEach(u -> u.add(KeyWord.Kraith))),
//	LOstEmeraude(
//			Arrays.asList(NighthauntRule.LaMaledictionEmeraude, NighthauntRule.ChevaliersDuRegret),
//			Allegiance.Nighthaunt,
//			null),
	ZaintharKai(
			Arrays.asList(DokRule.LessenceDeKhaine),
			Allegiance.DoK,
			a -> a.getUnits()
					.stream()
					.filter(u -> !u.is(KeyWord.HaggNar) && !u.is(RoleTactique.SortsPersistantsEtInvocation))
					.forEach(u -> u.add(KeyWord.ZaintharKai))),

	;

	private String displayName;
	private List<IRule<?>> rules;
	private Allegiance allegiance;
	private Consumer<Army> modifier;

	private SubAllegiance(List<IRule<?>> rules, Allegiance allegiance,
			Consumer<Army> modifier) {
		this.displayName = EnumPropertyLoader.instance().name(this);
		this.rules = rules;
		this.allegiance = allegiance;
		this.modifier = modifier;
	}

	public boolean availableFor(Army army) {
		return army.is(allegiance);
	}

	@Override
	public String getDisplayName() {
		return displayName;
	}

	@Override
	public void decorate(Army army) {
		rules.forEach(army::add);
		modifier.accept(army);
	}

}
