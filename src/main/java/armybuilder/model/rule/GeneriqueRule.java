package armybuilder.model.rule;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

import armybuilder.model.army.Allegiance;
import armybuilder.model.army.Army;
import armybuilder.model.unit.keyword.KeyWord;
import armybuilder.serialisation.DescriptionReader;
import armybuilder.serialisation.EnumPropertyLoader;

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
	DefenseEnRegle(null, RuleType.AptitudesDeCommandement, RuleType.PhaseDeTir, RuleType.PhaseDeCombat),
	PresenceExaltante(null, RuleType.AptitudesDeCommandement, RuleType.PhaseDeDeroute),

	// Sort
	TraitMagique(
			a -> a.units(KeyWord.Sorcier).stream().forEach(u -> u.add(GeneriqueRule.valueOf("TraitMagique"))),
			RuleType.Sort,
			RuleType.TraisUnitee),
	BouclierMystique(
			a -> a.units(KeyWord.Sorcier).stream().forEach(u -> u.add(GeneriqueRule.valueOf("BouclierMystique"))),
			RuleType.Sort,
			RuleType.TraisUnitee),

	Benediction(
			a -> a.units(KeyWord.Pretre)
					.stream()
					.filter(u -> !a.is(Allegiance.DoK)) // TODO pourquoi j'ai filtrer les DOK ?
					.forEach(u -> u.add(GeneriqueRule.valueOf("Benediction"))),
			RuleType.Priere,
			RuleType.TraisUnitee),
	Chatiment(
			a -> a.units(KeyWord.Pretre).stream().forEach(u -> u.add(GeneriqueRule.valueOf("Chatiment"))),
			RuleType.Priere,
			RuleType.TraisUnitee),

	// fureur monstrueuse
	Rugissement(null, RuleType.FureursMonstrueuses),
	Pietinement(null, RuleType.FureursMonstrueuses),
	DuelTitanesque(null, RuleType.FureursMonstrueuses),
	Ecroulement(null, RuleType.FureursMonstrueuses),

	// regle
	DissiperLesSorts(null, RuleType.Aptitude, RuleType.PhaseDesHeros),
	Fiascos(null, RuleType.Aptitude, RuleType.PhaseDesHeros),
	TestsDeDeroute(null, RuleType.Aptitude, RuleType.PhaseDeDeroute),

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
	public String getDescription() throws IOException {
		if (is(RuleType.AptitudesDeCommandement)) {
			return new DescriptionReader().read("Generique/AptitudesDeCommandement/", name());
		}
		if (is(RuleType.ActionsHeroiques)) {
			return new DescriptionReader().read("Generique/ActionsHeroiques/", name());
		}
		return new DescriptionReader().read("Generique/", name());
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
