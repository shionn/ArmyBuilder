package armybuilder.model.army.rule;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

import armybuilder.model.army.Listing;
import armybuilder.model.army.option.Allegiance;
import armybuilder.model.unit.KeyWord;
import armybuilder.serialisation.DescriptionReader;

public enum GeneriqueRule implements IArmyRule<GeneriqueRule> {

	CommandementHeroique("Commandement Héroïque", null, ArmyRuleType.ActionsHeroiques),
	GuerisonHeroique("Guérison Héroïque", null, ArmyRuleType.ActionsHeroiques),
	HeureDeGloire("Heure de Gloire", null, ArmyRuleType.ActionsHeroiques),
	VolonteHeroique("Volonté Héroïque", null, ArmyRuleType.ActionsHeroiques),

	// Tactique de bataille

	// AptitudesDeCommandement
	Ralliement(ArmyRuleType.AptitudesDeCommandement, ArmyRuleType.PhaseDesHeros),
	Redeploiement("Redéploiement", null, ArmyRuleType.AptitudesDeCommandement, ArmyRuleType.PhaseDeMouvement),
	EnAvantVersLaVictoire(
			"En Avant, Vers la Victoire",
			null,
			ArmyRuleType.AptitudesDeCommandement,
			ArmyRuleType.PhaseDeCharge),
	DechainerLesEnfers("Déchaîner les Enfers", null, ArmyRuleType.AptitudesDeCommandement, ArmyRuleType.PhaseDeCharge),
	AttaqueEnRegle(
			"Attaque en Règle",
			null,
			ArmyRuleType.AptitudesDeCommandement,
			ArmyRuleType.PhaseDeTir,
			ArmyRuleType.PhaseDeCombat),
	DefenseEnRegle(
			"Défense en Règle",
			null,
			ArmyRuleType.AptitudesDeCommandement,
			ArmyRuleType.PhaseDeTir,
			ArmyRuleType.PhaseDeCombat),
	PresenceExaltante("Présence Exaltante", null, ArmyRuleType.AptitudesDeCommandement, ArmyRuleType.PhaseDeDeroute),

	// Sort
	TraitMagique(
			"Trait Magique",
			a -> a.units(KeyWord.Sorcier).stream()
					.forEach(u -> u.add(GeneriqueRule.valueOf("TraitMagique"))),
			ArmyRuleType.Sort,
			ArmyRuleType.TraisUnitee),
	BouclierMystique(
			"Bouclier Mystique",
			a -> a.units(KeyWord.Sorcier).stream()
					.forEach(u -> u.add(GeneriqueRule.valueOf("BouclierMystique"))),
			ArmyRuleType.Sort,
			ArmyRuleType.TraisUnitee),

	Benediction(
			"Bénédiction",
			a -> a.units(KeyWord.Pretre)
					.stream()
					.filter(u -> !a.is(Allegiance.DoK))
					.forEach(u -> u.add(GeneriqueRule.valueOf("Benediction"))),
			ArmyRuleType.Priere,
			ArmyRuleType.TraisUnitee),
	Chatiment(
			"Châtiment",
			a -> a.units(KeyWord.Pretre).stream()
					.forEach(u -> u.add(GeneriqueRule.valueOf("Chatiment"))),
			ArmyRuleType.Priere,
			ArmyRuleType.TraisUnitee),

	// fureur monstrueuse
	Rugissement("Rugissement", null, ArmyRuleType.FureursMonstrueuses),
	Pietinement("Piétinement", null, ArmyRuleType.FureursMonstrueuses),
	DuelTitanesque("Duel Titanesque", null, ArmyRuleType.FureursMonstrueuses),
	Ecroulement("Écroulement", null, ArmyRuleType.FureursMonstrueuses),

	// regle
	DissiperLesSorts("Dissiper les Sorts", null, ArmyRuleType.Aptitude, ArmyRuleType.PhaseDesHeros),
	Fiascos("Fiascos", null, ArmyRuleType.Aptitude, ArmyRuleType.PhaseDesHeros),
	TestsDeDeroute("Tests de Déroute", null, ArmyRuleType.Aptitude, ArmyRuleType.PhaseDeDeroute),


	;

	private List<ArmyRuleType> types;
	private String displayName;
	private Consumer<Listing> consumer;

	GeneriqueRule(ArmyRuleType... types) {
		this.types = Arrays.asList(types);
	}

	GeneriqueRule(String displayName, Consumer<Listing> consumer, ArmyRuleType... types) {
		this.displayName = displayName;
		this.consumer = consumer;
		this.types = Arrays.asList(types);
	}

	@Override
	public List<ArmyRuleType> getTypes() {
		return types;
	}

	@Override
	public String getDescription() throws IOException {
		if (is(ArmyRuleType.AptitudesDeCommandement)) {
			return new DescriptionReader().read("Generique/AptitudesDeCommandement/", name());
		}
		if (is(ArmyRuleType.ActionsHeroiques)) {
			return new DescriptionReader().read("Generique/ActionsHeroiques/", name());
		}
		return new DescriptionReader().read("Generique/", name());
	}

	@Override
	public String displayName() {
		if (displayName == null) {
			return name();
		}
		return displayName;
	}

	@Override
	public String toString() {
		return name() + getTypes();
	}

	public void rebuild(Listing listing) {
		if (consumer != null) {
			consumer.accept(listing);
		} else {
			listing.add(this);
		}
	}

}
