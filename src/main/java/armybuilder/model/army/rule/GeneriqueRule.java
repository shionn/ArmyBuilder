package armybuilder.model.army.rule;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

import armybuilder.model.army.OldArmy;
import armybuilder.model.unit.KeyWord;
import armybuilder.serialisation.DescriptionReader;

public enum GeneriqueRule implements IArmyRule<GeneriqueRule> {

	CommandementHeroique("Commandement Héroïque", null, ArmyRuleType.ActionsHeroiques),
	GuerisonHeroique("Guérison Héroïque", null, ArmyRuleType.ActionsHeroiques),
	HeureDeGloire("Heure de Gloire", null, ArmyRuleType.ActionsHeroiques),
	VolonteHeroique("Volonté Héroïque", null, ArmyRuleType.ActionsHeroiques),

	Ralliement(ArmyRuleType.AptitudesDeCommandement, ArmyRuleType.PhaseDesHeros),
	Redeploiement(
			"Redéploiement",
			null,
			ArmyRuleType.AptitudesDeCommandement,
			ArmyRuleType.PhaseDeMouvement),

	EnAvantVersLaVictoire(
			"En Avant, Vers la Victoire",
			null,
			ArmyRuleType.AptitudesDeCommandement,
			ArmyRuleType.PhaseDeCharge),
	DechainerLesEnfers(
			"Déchaîner les Enfers",
			null,
			ArmyRuleType.AptitudesDeCommandement,
			ArmyRuleType.PhaseDeCharge),

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

	PresenceExaltante(
			"Présence Exaltante",
			null,
			ArmyRuleType.AptitudesDeCommandement,
			ArmyRuleType.PhaseDeDeroute),

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
			a -> a.units(KeyWord.Pretre).stream()
					.forEach(u -> u.add(GeneriqueRule.valueOf("Benediction"))),
			ArmyRuleType.Priere,
			ArmyRuleType.TraisUnitee),
	Chatiment(
			"Châtiment",
			a -> a.units(KeyWord.Pretre).stream()
					.forEach(u -> u.add(GeneriqueRule.valueOf("Chatiment"))),
			ArmyRuleType.Priere,
			ArmyRuleType.TraisUnitee),

	Rugissement("Rugissement", null, ArmyRuleType.FureursMonstrueuses),
	Pietinement("Piétinement", null, ArmyRuleType.FureursMonstrueuses),
	DuelTitanesque("Duel Titanesque", null, ArmyRuleType.FureursMonstrueuses),
	Ecroulement("Écroulement", null, ArmyRuleType.FureursMonstrueuses),

	DissiperLesSorts("Dissiper les Sorts", null, ArmyRuleType.Aptitude, ArmyRuleType.PhaseDesHeros),
	Fiascos("Fiascos", null, ArmyRuleType.Aptitude, ArmyRuleType.PhaseDesHeros),
	TestsDeDeroute("Tests de Déroute", null, ArmyRuleType.Aptitude, ArmyRuleType.PhaseDeDeroute),


	;

	private List<ArmyRuleType> types;
	private String displayName;
	private Consumer<OldArmy> consumer;

	GeneriqueRule(ArmyRuleType... types) {
		this.types = Arrays.asList(types);
	}

	GeneriqueRule(String displayName, Consumer<OldArmy> consumer, ArmyRuleType... types) {
		this.displayName = displayName;
		this.consumer = consumer;
		this.types = Arrays.asList(types);
	}

	public boolean isUsable(OldArmy army) {
		boolean usable = true;
		for (ArmyRuleType type : types) {
			usable &= type.isUsable(army);
		}
		return usable;
	}

	@Override
	public List<ArmyRuleType> getTypes() {
		return types;
	}

	@Override
	public String getDescription() throws IOException {
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

	@Override
	public void rebuild(OldArmy army) {
		if (consumer != null) {
			consumer.accept(army);
		}
	}

}
