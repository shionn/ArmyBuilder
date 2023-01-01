package armybuilder.model.army;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

import armybuilder.model.IHaveDisplayName;
import armybuilder.model.dok.DokRule;
import armybuilder.model.nighthaunt.NighthauntRule;
import armybuilder.model.rule.IRule;
import armybuilder.model.stormcast.StormcastRule;
import armybuilder.model.unit.keyword.KeyWord;
import armybuilder.model.unit.role.RoleTactique;
import armybuilder.serialisation.EnumPropertyLoader;

public enum SubAllegiance implements IHaveDisplayName, IDecoreArmy {
	None(Arrays.asList(), null),

	// Dok
	DraichiGaneth(Arrays.asList(DokRule.TueusesHerisseesDeLames), Allegiance.DoK),
	HaggNar(Arrays.asList(DokRule.FillesDuPremierTemple), Allegiance.DoK),
	KheltNar(Arrays.asList(DokRule.FrapperEtSeRetirer), Allegiance.DoK),
	Khailebron(Arrays.asList(DokRule.MaitressesDesOmbrevoies), Allegiance.DoK),
	Kraith(Arrays.asList(DokRule.DisciplesDuMassacre), Allegiance.DoK),
	ZaintharKai(Arrays.asList(DokRule.LessenceDeKhaine), Allegiance.DoK),

	// Nighthaunt
	LegionEploree(Arrays.asList(NighthauntRule.EntrainesDansLaTombe), Allegiance.Nighthaunt),
	FleauEcarlate(Arrays.asList(NighthauntRule.VortexDeViolenceFrenetique), Allegiance.Nighthaunt, a -> {
		a.add(NighthauntRule.VortexDeViolenceFrenetique);
		a.units(KeyWord.RevenantsLamemanes).forEach(u -> u.changeRole(RoleTactique.Elite, RoleTactique.Ligne));
	}),
	MortsDeVifArgent(Arrays.asList(NighthauntRule.ArtisansDUneMortEffroyable), Allegiance.Nighthaunt, a -> {
		a.add(NighthauntRule.ArtisansDUneMortEffroyable);
		a.units(KeyWord.CarognesFaucheuses).forEach(u -> u.changeRole(RoleTactique.Elite, RoleTactique.Ligne));
	}),
	OstEmeraude(Arrays.asList(NighthauntRule.LaMaledictionEmeraude), Allegiance.Nighthaunt),

	// StormCast
	BellicistesCelestes(Arrays.asList(StormcastRule.ClairvoyanceIntrepide), Allegiance.StormCast),
	ChevaliersExcelsiors(
			Arrays.asList(StormcastRule.TempeteDAnnihilation),
			Allegiance.StormCast,
			a -> a.getUnits()
					.stream()
					.filter(u -> u.is(KeyWord.ChevaliersExcelsiors, KeyWord.Paladin))
					.forEach(u -> u.add(StormcastRule.TempeteDAnnihilation))),
	ChevaliersSanctifies(
			Arrays.asList(StormcastRule.SeulementLesFideles),
			Allegiance.StormCast,
			a -> a.getUnits()
					.stream()
					.filter(u -> u.is(KeyWord.ChevaliersSanctifies, KeyWord.Redempteur))
					.forEach(u -> u.add(StormcastRule.SeulementLesFideles))),
	EnclumesDeLHeldenhammer(
			Arrays.asList(StormcastRule.AuraMorbide),
			Allegiance.StormCast,
			a -> a.getUnits()
					.stream()
					.filter(u -> u.is(KeyWord.EnclumesDeLHeldenhammer))
					.forEach(u -> u.add(StormcastRule.AuraMorbide))),
	MarteauxDeSigmar(Arrays.asList(StormcastRule.EchecInterdit), Allegiance.StormCast),
	SeigneursDeLaTempete(Arrays.asList(StormcastRule.LOstAltier), Allegiance.StormCast),
	TempliersSiellaires(Arrays.asList(StormcastRule.Rabatteurs), Allegiance.StormCast),
	VengeursCelestes(Arrays.asList(StormcastRule.MusParLaVengeance), Allegiance.StormCast),




	;

	private String displayName;
	private List<IRule<?>> rules;
	private Allegiance allegiance;
	private Consumer<Army> modifier;

	private SubAllegiance(List<IRule<?>> rules, Allegiance allegiance, Consumer<Army> modifier) {
		this.displayName = EnumPropertyLoader.instance().name(this);
		this.rules = rules;
		this.allegiance = allegiance;
		this.modifier = modifier;
	}

	private SubAllegiance(List<IRule<?>> rules, Allegiance allegiance) {
		this(rules, allegiance, null);
	}

	public boolean availableFor(Army army) {
		return allegiance == null || army.is(allegiance);
	}

	public List<IRule<?>> getRules() {
		return rules;
	}

	@Override
	public String getDisplayName() {
		return displayName;
	}

	@Override
	public void decorate(Army army) {
		rules.forEach(army::add);
		if (this != None) {
			army.getUnits()
					.stream()
					.filter(u -> !u.isSubAllegied() && !u.is(RoleTactique.SortsPersistantsEtInvocation))
					.forEach(u -> u.add(KeyWord.valueOf(name())));
		}
		if (modifier != null) {
			modifier.accept(army);
		}
	}

}
