package armybuilder.model.rule;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public enum GeneriqueRule implements IArmyRule<GeneriqueRule> {

	CommandementHeroique("Commandement Héroïque", ArmyRuleType.ActionsHeroiques),
	GuerisonHeroique("Guérison Héroïque", ArmyRuleType.ActionsHeroiques),
	HeureDeGloire("Heure de Gloire", ArmyRuleType.ActionsHeroiques),
	VolonteHeroique("Volonté Héroïque", ArmyRuleType.ActionsHeroiques),

	Ralliement(ArmyRuleType.AptitudesDeCommandement, ArmyRuleType.PhaseDesHeros),
	Redeploiement(
			"Redéploiement",
			ArmyRuleType.AptitudesDeCommandement,
			ArmyRuleType.PhaseDeMouvement),

	EnAvantVersLaVictoire(
			"En Avant, Vers la Victoire",
			ArmyRuleType.AptitudesDeCommandement,
			ArmyRuleType.PhaseDeCharge),
	DechainerLesEnfers(
			"Déchaîner les Enfers",
			ArmyRuleType.AptitudesDeCommandement,
			ArmyRuleType.PhaseDeCharge),

	AttaqueEnRegle(
			"Attaque en Règle",
			ArmyRuleType.AptitudesDeCommandement,
			ArmyRuleType.PhaseDeTir,
			ArmyRuleType.PhaseDeCombat),
	DefenseEnRegle(
			"Défense en Règle",
			ArmyRuleType.AptitudesDeCommandement,
			ArmyRuleType.PhaseDeTir,
			ArmyRuleType.PhaseDeCombat),

	PresenceExaltante(
			"Présence Exaltante",
			ArmyRuleType.AptitudesDeCommandement,
			ArmyRuleType.PhaseDeDeroute),

	TraitMagique("Trait Magique", ArmyRuleType.Sort, ArmyRuleType.TraisUnitee),
	BouclierMystique("Bouclier Mystique", ArmyRuleType.Sort, ArmyRuleType.TraisUnitee),
	Benediction("Bénédiction", ArmyRuleType.Priere, ArmyRuleType.TraisUnitee),
	Chatiment("Châtiment", ArmyRuleType.Priere, ArmyRuleType.TraisUnitee),
	
	Rugissement("Rugissement", ArmyRuleType.FureursMonstrueuses),
	Pietinement("Piétinement", ArmyRuleType.FureursMonstrueuses),
	DuelTitanesque("Duel Titanesque", ArmyRuleType.FureursMonstrueuses),
	Ecroulement("Écroulement", ArmyRuleType.FureursMonstrueuses),

	;

	private List<ArmyRuleType> types;
	private String displayName;

	GeneriqueRule(ArmyRuleType... types) {
		this.types = Arrays.asList(types);
	}

	GeneriqueRule(String displayName, ArmyRuleType... types) {
		this.displayName = displayName;
		this.types = Arrays.asList(types);
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
	public String getDisplayName() {
		if (displayName == null) {
			return name();
		}
		return displayName;
	}

}
