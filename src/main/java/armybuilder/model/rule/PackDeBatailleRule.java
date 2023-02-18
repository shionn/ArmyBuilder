package armybuilder.model.rule;

import static armybuilder.model.rule.ShortDescriptionBuilder.sh;

import java.util.Arrays;
import java.util.List;

import armybuilder.model.unit.keyword.KeyWord;
import armybuilder.model.unit.role.RoleTactique;
import armybuilder.serialisation.DescriptionReader;
import armybuilder.serialisation.EnumPropertyLoader;

public enum PackDeBatailleRule implements IRule<PackDeBatailleRule> {
	ActionDeseperee(
			sh().text("second joueur du round")
					.comma()
					.un()
					.keyword(KeyWord.ChampionDeGallet)
					.ami()
					.text("peu effecter")
					.deux()
					.different()
					.ruleType(RuleType.ActionsHeroiques),
			RuleType.ActionsHeroiques,
			RuleType.PhaseDesHeros),
	CleDeLaVictoire(
			sh().non().cible().projectil().comma().si().a(1).unitée().ami().role(RoleTactique.Ligne),
			RuleType.Aptitude,
			RuleType.TraisUnitee,
			RuleType.PhaseDeTir),
	DentGrincantesDeGallet(
			sh().desPlus(6)
					.a(12)
					.choissisez()
					.un()
					.objectif()
					.visible()
					.dot()
					.pourChaque()
					.unitée()
					.a(6)
					.objectif()
					.sur(4)
					.deuxPoint()
					.subit()
					.D6()
					.BM(),
			RuleType.Sort,
			RuleType.TraisUnitee),
	FrappeDOuverture(
			sh().un()
					.keyword(KeyWord.ChampionDeGallet)
					.ami()
					.non()
					.a(3)
					.unitée()
					.ennemi()
					.text("peu combattre")
					.dot()
					.gagne()
					.frappeEnDerner()
					.jusquà()
					.finDeTour(),
			RuleType.ActionsHeroiques,
			RuleType.PhaseDesHeros),
	MenerParLExemple(
			sh().un()
					.keyword(KeyWord.ChampionDeGallet)
					.ami()
					.apres()
					.rule(FrappeDOuverture)
					.avec()
					.unitée()
					.keyword(KeyWord.GardeAssermentee)
					.entierment(6)
					.et()
					.a(3)
					.unitée()
					.ennemi()
					.dot()
					.unitée()
					.ami()
					.keyword(KeyWord.GardeAssermentee)
					.text("peu combattre")
					.et()
					.gagne()
					.frappeEnDerner()
					.jusquà()
					.finDeTour(),
			RuleType.ActionsHeroiques,
			RuleType.PhaseDesHeros),
	Metamorphose(RuleType.Sort, RuleType.TraisUnitee),
	PasDeRepliPasDeReddition(
			sh().debut()
					.comma()
					.un()
					.unitée()
					.ami()
					.non()
					.keyword(KeyWord.Heros)
					.non()
					.keyword(KeyWord.Monstre)
					.text("n'ayant pas chargé")
					.et()
					.a(3)
					.unitée()
					.ennemi()
					.dot()
					.gagne()
					.non()
					.mouvementEngagement()
					.et()
					.plus(1)
					.attaque()
					.melee()
					.non()
					.monture(),
			RuleType.AptitudesDeCommandement,
			RuleType.PhaseDeCombatDebut),
	RegardDeGhur(RuleType.Sort, RuleType.TraisUnitee),
	RugissementSauvage(RuleType.AptitudesDeCommandement, RuleType.PhaseDeCombat),

	;

	private List<RuleType> types;
	private String displayName;
	private String shortDescription;

	PackDeBatailleRule(RuleType... types) {
		this.displayName = EnumPropertyLoader.instance().name(this);
		this.types = Arrays.asList(types);
	}

	PackDeBatailleRule(ShortDescriptionBuilder sh, RuleType... types) {
		this.shortDescription = sh.build();
		this.displayName = EnumPropertyLoader.instance().name(this);
		this.types = Arrays.asList(types);
	}

	@Override
	public List<RuleType> getTypes() {
		return types;
	}

	@Override
	public String getDescription() {
		return new DescriptionReader().read("Generique/PackDeBataille/", this);
	}

	@Override
	public String getDisplayName() {
		return displayName;
	}

	@Override
	public String getShortDescription() {
		return shortDescription;
	}

}
