package armybuilder.model.army.option;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;

import armybuilder.model.army.Army;
import armybuilder.model.army.Listing;
import armybuilder.model.army.OldArmy;
import armybuilder.model.army.rule.IArmyRule;
import armybuilder.model.dok.DokRule;
import armybuilder.model.nighthaunt.NighthauntRule;
import armybuilder.model.unit.Unit;

public enum SubAllegiance implements IListingOptionValue<SubAllegiance>, Comparator<SubAllegiance> {
	DraichiGaneth(
			"Temple : Draichi Ganeth",
			Arrays.asList(DokRule.TueusesHerisseesDeLames, DokRule.UnMillierDeStyles),
			a -> a.is(Allegiance.DoK),
			Allegiance.DoK),
	HaggNar(
			"Temple : Hagg Nar",
			Arrays.asList(DokRule.FillesDuPremierTemple, DokRule.AvancezLesChaudrons),
			a -> a.is(Allegiance.DoK),
			Allegiance.DoK),
	KheltNar(
			"Temple : Khelt Nar",
			Arrays.asList(DokRule.FrapperEtSeRetirer, DokRule.SaignerLEsprit),
			a -> a.is(Allegiance.DoK),
			Allegiance.DoK),
	Khailebron(
			"Temple : Khailebron",
			Arrays.asList(DokRule.DissimulationEtDiscretion, DokRule.MaitressesDesOmbrevoies),
			a -> a.is(Allegiance.DoK),
			Allegiance.DoK),
	Kraith(
			"Temple : Kraith",
			Arrays.asList(DokRule.DisciplesDuMassacre, DokRule.ExalteesParLeCarnage),
			a -> a.is(Allegiance.DoK),
			Allegiance.DoK),
	LOstEmeraude(
			"Processions : l'OST Emeraude",
			Arrays.asList(NighthauntRule.LaMaledictionEmeraude, NighthauntRule.ChevaliersDuRegret),
			a -> a.is(Allegiance.Nighthaunt),
			Allegiance.Nighthaunt),
	ZaintharKai(
			"Temple : Zainthar Kai",
			Arrays.asList(DokRule.LessenceDeKhaine, DokRule.CrypteDesAinee, DokRule.LePouvoirDuSang),
			a -> a.is(Allegiance.DoK),
			Allegiance.DoK),

	;

	private String displayName;
	private List<IArmyRule<?>> rules;
	private Function<Army, Boolean> isAvailable;
	private Allegiance allegiance;

	private SubAllegiance(String displayName, List<IArmyRule<?>> rules,
			Function<Army, Boolean> isDisplay, Allegiance allegiance) {
		this.displayName = displayName;
		this.rules = rules;
		this.isAvailable = isDisplay;
		this.allegiance = allegiance;
	}

	@Override
	public String displayName() {
		return displayName;
	}

	@Deprecated
	@Override
	public ListingOption option() {
		return ListingOption.SubAllegiance;
	}

	@Deprecated
	@Override
	public boolean isOptionDisplayed(OldArmy army) {
		return false;
	}

	@Deprecated
	@Override
	public int compare(SubAllegiance o1, SubAllegiance o2) {
		return o1.displayName().compareTo(o2.displayName());
	}

	@Override
	public void rebuild(Listing listing) {
		allegiance().rebuild(listing);
		if (rules != null) {
			listing.add(rules.toArray(new IArmyRule[0]));
		}
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

	@Override
	public void rebuild(OldArmy army) {

	}

	public List<IArmyRule<?>> rules() {
		return rules;
	}

}
