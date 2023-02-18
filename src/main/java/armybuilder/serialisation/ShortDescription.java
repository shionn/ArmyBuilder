package armybuilder.serialisation;

import static armybuilder.model.rule.ShortDescriptionBuilder.sh;

import armybuilder.model.rule.GeneriqueRule;
import armybuilder.model.rule.IRule;
import armybuilder.model.rule.PackDeBatailleRule;
import armybuilder.model.rule.RuleType;
import armybuilder.model.rule.ShortDescriptionBuilder;
import armybuilder.model.unit.keyword.KeyWord;
import armybuilder.model.unit.role.RoleTactique;

public enum ShortDescription {

	// @formatter:off
	PackDeBatailleRule_ActionDeseperee(sh().text("second joueur du round").comma().un().keyword(KeyWord.ChampionDeGallet).ami().text("peu effecter").deux().different().ruleType(RuleType.ActionsHeroiques)),
	PackDeBatailleRule_AutoriteDuDominant(sh().uneFoisParBataille().donne().fois(3).ordre().rule(GeneriqueRule.Ralliement).comma().rule(GeneriqueRule.AttaqueEnRegle).comma().rule(GeneriqueRule.DefenseEnRegle).comma().rule(GeneriqueRule.Redeploiement)),
	PackDeBatailleRule_CleDeLaVictoire(sh().non().cible().projectil().comma().si().a(1).unitée().ami().role(RoleTactique.Ligne)),
	PackDeBatailleRule_CharmeDePlumeDeGriffe(sh().protection(5)),
	PackDeBatailleRule_DentGrincantesDeGallet(sh().desPlus(6).a(12).choissisez().un().objectif().visible().dot().pourChaque().unitée().a(6).objectif().sur(4).deuxPoint().subit().D6().BM()),
	PackDeBatailleRule_EnteteCommeUnRhinox(sh().contest().pour().dix().figurine().sur().objectif().non().contesté().keyword(KeyWord.ChampionDeGallet).ennemi()),
	PackDeBatailleRule_FrappeDOuverture(sh().un().keyword(KeyWord.ChampionDeGallet).ami().non().a(3).unitée().ennemi().text("peu combattre").dot().gagne().frappeEnDerner().jusquà().finDeTour()),
	PackDeBatailleRule_MaitreDesTunnels(sh().uneFoisParBataille().text("à la place du mouvement").comma().teleport().aPlus(9).figurine().ennemi()),
	PackDeBatailleRule_MenerParLExemple(sh().un().keyword(KeyWord.ChampionDeGallet).ami().apres().rule(PackDeBatailleRule.MenerParLExemple).avec().unitée().keyword(KeyWord.GardeAssermentee).entierment(6).et().a(3).unitée().ennemi().dot().unitée().ami().keyword(KeyWord.GardeAssermentee).text("peu combattre").et().gagne().frappeEnDerner().jusquà().finDeTour()),
	PackDeBatailleRule_PasDeRepliPasDeReddition(sh().debut().comma().un().unitée().ami().non().keyword(KeyWord.Heros).non().keyword(KeyWord.Monstre).text("n'ayant pas chargé").et().a(3).unitée().ennemi().dot().gagne().non().mouvementEngagement().et().plus(1).attaque().melee().non().monture()),



	;// @formatter:on

	private String value;

	private ShortDescription(ShortDescriptionBuilder sh) {
		this.value = sh.build();
	}

	public String getValue() {
		return value;
	}

	static public ShortDescription valueOf(IRule<?> rule) {
		return valueOf(rule.getClass().getSimpleName() + '_' + rule.name());
	}

}
