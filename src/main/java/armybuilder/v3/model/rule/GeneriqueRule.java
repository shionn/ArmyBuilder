package armybuilder.v3.model.rule;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

import armybuilder.v3.model.army.Allegiance;
import armybuilder.v3.model.army.Army;
import armybuilder.v3.model.rule.desc.Description;
import armybuilder.v3.model.unit.keyword.KeyWord;
import armybuilder.v3.serialisation.EnumPropertyLoader;

public enum GeneriqueRule implements IRule<GeneriqueRule> {

	CommandementHeroique(null, RuleType.ActionsHeroiques),
	GuerisonHeroique(null, RuleType.ActionsHeroiques),
	HeureDeGloire(null, RuleType.ActionsHeroiques),
	VolonteHeroique(null, RuleType.ActionsHeroiques),

	// Tactique de bataille

	// AptitudesDeCommandement
	Ralliement(null, RuleType.AptitudesDeCommandement, RuleType.PhaseDesHeros),
	Redeploiement(null, RuleType.AptitudesDeCommandement, RuleType.PhaseDeMouvement),
	EnAvantVersLaVictoire(null, RuleType.AptitudesDeCommandement, RuleType.PhaseDeCharge),
	DechainerLesEnfers(null, RuleType.AptitudesDeCommandement, RuleType.PhaseDeCharge),
	AttaqueEnRegle(null, RuleType.AptitudesDeCommandement, RuleType.PhaseDeTir, RuleType.PhaseDeCombat),
	DefenseEnRegle(a -> a.addIf(!a.is(Allegiance.Nighthaunt), GeneriqueRule.valueOf("DefenseEnRegle")),
			RuleType.AptitudesDeCommandement, RuleType.PhaseDeTir, RuleType.PhaseDeCombat),
	PresenceExaltante(null, RuleType.AptitudesDeCommandement, RuleType.PhaseDeDeroute),

	// Sort
	TraitMagique(a -> a.units(KeyWord.Sorcier).stream().forEach(u -> u.add(GeneriqueRule.valueOf("TraitMagique"))),
			RuleType.Sort),
	BouclierMystique(a -> a.units(KeyWord.Sorcier)
			.stream()
			.filter(u -> !u.is(KeyWord.Hantenuits))
			.forEach(u -> u.add(GeneriqueRule.valueOf("BouclierMystique"))), RuleType.Sort),

	Benediction(
			// donne une protection a 6+ donc inutil pour les DoK
			a -> a.units(KeyWord.Pretre)
					.stream()
					.filter(u -> !a.is(Allegiance.DoK))
					.forEach(u -> u.add(GeneriqueRule.valueOf("Benediction"))),
			RuleType.Priere),
	Chatiment(a -> a.units(KeyWord.Pretre).stream().forEach(u -> u.add(GeneriqueRule.valueOf("Chatiment"))),
			RuleType.Priere),

	// fureur monstrueuse
	Rugissement(a -> a.addIf(a.count(KeyWord.Monstre) > 0, GeneriqueRule.valueOf("Rugissement")),
			RuleType.FureursMonstrueuses,
			RuleType.MemoDisplay),
	Pietinement(a -> a.addIf(a.count(KeyWord.Monstre) > 0, GeneriqueRule.valueOf("Pietinement")),
			RuleType.FureursMonstrueuses,
			RuleType.MemoDisplay),
	DuelTitanesque(a -> a.addIf(a.count(KeyWord.Monstre) > 0, GeneriqueRule.valueOf("DuelTitanesque")),
			RuleType.FureursMonstrueuses,
			RuleType.MemoDisplay),
	Ecroulement(a -> a.addIf(a.count(KeyWord.Monstre) > 0, GeneriqueRule.valueOf("Ecroulement")),
			RuleType.FureursMonstrueuses,
			RuleType.MemoDisplay),

	// regle
	//DissiperLesSorts(a -> a.addIf(a.count(KeyWord.Sorcier) > 0, GeneriqueRule.valueOf("DissiperLesSorts")), RuleType.Rule),

	DescriptionTour(a -> a.add(GeneriqueRule.valueOf("DescriptionTour")), RuleType.Memo),

	;

	private List<RuleType> types;
	private String displayName;
	private Consumer<Army> consumer;

	GeneriqueRule(Consumer<Army> consumer, RuleType... types) {
		this.displayName = EnumPropertyLoader.instance().name(this);
		this.consumer = consumer;
		this.types = Arrays.asList(types);
	}

	@Override
	public List<RuleType> getTypes() {
		return types;
	}

	@Override
	public Description getDescription() {
		if (is(RuleType.AptitudesDeCommandement)) {
			return new Description("Generique/AptitudesDeCommandement/", this);
		}
		if (is(RuleType.ActionsHeroiques)) {
			return new Description("Generique/ActionsHeroiques/", this);
		}
		return new Description(this);
	}

	@Override
	public String getDisplayName() {
		if (displayName == null) {
			return name();
		}
		return displayName;
	}

	@Override
	public String toString() {
		return name() + getTypes();
	}

	public void decorate(Army army) {
		if (consumer != null) {
			consumer.accept(army);
		} else {
			army.add(this);
		}
	}

}
