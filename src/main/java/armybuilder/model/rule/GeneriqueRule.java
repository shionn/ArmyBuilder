package armybuilder.model.rule;

import java.util.Arrays;
import java.util.List;

import armybuilder.model.ArmyRuleType;

public enum GeneriqueRule implements IArmyRule {

	CommandementHeroique(ArmyRuleType.ActionsHeroiques),
	GuerisonHeroique(ArmyRuleType.ActionsHeroiques),
	HeureDeGloire(ArmyRuleType.ActionsHeroiques),
	VolonteHeroique(ArmyRuleType.ActionsHeroiques),

	Ralliement(ArmyRuleType.AptitudesDeCommandement, ArmyRuleType.PhaseDesHeros),
	Redeploiement(ArmyRuleType.AptitudesDeCommandement, ArmyRuleType.PhaseDeMouvement),

	EnAvantVersLaVictoire(ArmyRuleType.AptitudesDeCommandement, ArmyRuleType.PhaseDeCharge),
	DechainerLesEnfers(ArmyRuleType.AptitudesDeCommandement, ArmyRuleType.PhaseDeCharge),

	AttaqueEnRegle(
			ArmyRuleType.AptitudesDeCommandement,
			ArmyRuleType.PhaseDeTir,
			ArmyRuleType.PhaseDeCombat),
	DefenseEnRegle(
			ArmyRuleType.AptitudesDeCommandement,
			ArmyRuleType.PhaseDeTir,
			ArmyRuleType.PhaseDeCombat),

	PresenceExaltante(ArmyRuleType.AptitudesDeCommandement, ArmyRuleType.PhaseDeDeroute),

	TraitMagique(ArmyRuleType.Sort),
	BouclierMystique(ArmyRuleType.Sort),
	Benediction(ArmyRuleType.Priere),
	Chatiment(ArmyRuleType.Priere),
	
	Rugissement(ArmyRuleType.FureursMonstrueuses),
	Pietinement(ArmyRuleType.FureursMonstrueuses),
	DuelTitanesque(ArmyRuleType.FureursMonstrueuses),
	Ecroulement(ArmyRuleType.FureursMonstrueuses),

	;

	private List<ArmyRuleType> types;

	GeneriqueRule(ArmyRuleType... types) {
		this.types = Arrays.asList(types);
	}

	@Override
	public List<ArmyRuleType> getTypes() {
		return types;
	}

}
