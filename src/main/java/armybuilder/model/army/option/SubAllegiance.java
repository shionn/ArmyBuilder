package armybuilder.model.army.option;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

import armybuilder.model.army.Listing;
import armybuilder.model.army.rule.IArmyRule;
import armybuilder.model.dok.DokRule;
import armybuilder.model.nighthaunt.NighthauntRule;
import armybuilder.model.unit.KeyWord;
import armybuilder.model.unit.RoleTactique;

public enum SubAllegiance implements IListingOptionValue<SubAllegiance> {
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
	private List<IArmyRule<?>> rules;
	private Allegiance allegiance;
	private Consumer<Listing> modifier;

	private SubAllegiance(String displayName, List<IArmyRule<?>> rules,
			Allegiance allegiance, Consumer<Listing> modifier) {
		this.displayName = displayName;
		this.rules = rules;
		this.allegiance = allegiance;
		this.modifier = modifier;
	}

	@Override
	public String displayName() {
		return displayName;
	}

	@Override
	public ListingOption option() {
		return ListingOption.SubAllegiance;
	}

	@Override
	public void rebuild(Listing listing) {
		allegiance().rebuild(listing);
		if (rules != null) {
			listing.add(rules.toArray(new IArmyRule[0]));
		}
		if (modifier != null) {
			modifier.accept(listing);
		}
	}

	@Override
	public boolean availableFor(Listing listing) {
		return listing.subAllegiance().allegiance == allegiance;
	}

	public Allegiance allegiance() {
		return allegiance;
	}

	public List<IArmyRule<?>> rules() {
		return rules;
	}

}
