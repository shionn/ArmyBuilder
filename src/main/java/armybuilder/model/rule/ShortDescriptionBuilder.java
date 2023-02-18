package armybuilder.model.rule;

import java.util.Arrays;

import armybuilder.model.unit.keyword.KeyWord;
import armybuilder.model.unit.role.RoleTactique;

public class ShortDescriptionBuilder {
	private StringBuilder content = new StringBuilder();

	public static ShortDescriptionBuilder sh() {
		return new ShortDescriptionBuilder();
	}

	public String build() {
		if (last() != '.') {
			dot();
		}
		return content.toString();
	}

	private char last() {
		return content.charAt(content.length() - 1);
	}

	private ShortDescriptionBuilder space() {
		if (content.isEmpty())
			return this;
		if (Arrays.asList('!', ' ').contains(last()))
			return this;
		return character(' ');
	}

	private ShortDescriptionBuilder character(char c) {
		content.append(c);
		return this;
	}

	private ShortDescriptionBuilder number(int x) {
		content.append(x);
		return this;
	}

	private ShortDescriptionBuilder word(String word) {
		content.append(word);
		return this;
	}

	public ShortDescriptionBuilder pourTous() {
		return space().character('∀');
	}

	public ShortDescriptionBuilder pourChaque() {
		return space().character('∀');
	}

	public ShortDescriptionBuilder unitée() {
		return space().character('μ');
	}

	public ShortDescriptionBuilder non() {
		return space().character('!');
	}

	public ShortDescriptionBuilder different() {
		return space().character('≠');
	}

	public ShortDescriptionBuilder ou() {
		return space().word("||");
	}

	public ShortDescriptionBuilder desPlus(int x) {
		return space().number(5).character('+');
	}

	public ShortDescriptionBuilder D6() {
		return space().word("D6");
	}

	public ShortDescriptionBuilder sur(int x) {
		return space().word("sur").space().number(4).character('+');
	}

	public ShortDescriptionBuilder plus(int x) {
		return space().character('+').number(x);
	}

	public ShortDescriptionBuilder fois(int x) {
		return space().number(1).character('x');
	}

	public ShortDescriptionBuilder ami() {
		return word("<sub>a</sub>");
	}

	public ShortDescriptionBuilder ennemi() {
		return word("<sup>e</sup>");
	}

	public ShortDescriptionBuilder keyword(KeyWord keyWord) {
		return space().word("__").word(keyWord.getDisplayName()).word("__");
	}

	public ShortDescriptionBuilder role(RoleTactique ligne) {
		return space().character('*').word(ligne.getDisplayName()).character('*');
	}

	public ShortDescriptionBuilder ruleType(RuleType type) {
		return space().word("__").word(type.getDisplayName()).word("__");
	}

	public ShortDescriptionBuilder rule(IRule<?> rule) {
		return space().word("__").word(rule.getDisplayName()).word("__");
	}

	public ShortDescriptionBuilder a(int x) {
		return space().word("à ").number(x).character('"');
	}

	public ShortDescriptionBuilder aPlus(int x) {
		return space().word("à +").number(x).character('"');
	}

	public ShortDescriptionBuilder aUnDemiPouce() {
		return space().word("à ").character('½').character('"');
	}

	public ShortDescriptionBuilder entierment(int x) {
		return space().word("∈ ").number(x).character('"');
	}

	public ShortDescriptionBuilder text(String string) {
		return space().word(string);
	}

	public ShortDescriptionBuilder un() {
		return space().number(1);
	}

	public ShortDescriptionBuilder deux() {
		return space().number(2);
	}

	public ShortDescriptionBuilder dix() {
		return space().number(10);
	}

	public ShortDescriptionBuilder dot() {
		return character('.');
	}

	public ShortDescriptionBuilder comma() {
		return character(',');
	}

	public ShortDescriptionBuilder deuxPoint() {
		return character(':');
	}

	public ShortDescriptionBuilder debut() {
		return space().character('*').word("début").character('*');
	}

	public ShortDescriptionBuilder uneFoisParBataille() {
		return space().character('*').word("une seule fois").character('*');
	}

	public ShortDescriptionBuilder uneFoisParRound() {
		return space().character('*').word("une seule par round").character('*');
	}

	public ShortDescriptionBuilder finDeTour() {
		return space().character('*').word("fin de tour").character('*');
	}


	public ShortDescriptionBuilder si() {
		return space().word("si");
	}

	public ShortDescriptionBuilder cible() {
		return space().word("cible");
	}

	public ShortDescriptionBuilder projectil() {
		return space().word("projectil");
	}

	public ShortDescriptionBuilder choissisez() {
		return space().word("choissisez");
	}

	public ShortDescriptionBuilder gagne() {
		return space().word("gagne");
	}

	public ShortDescriptionBuilder frappeEnDerner() {
		return space().word("frappe en dernier");
	}

	public ShortDescriptionBuilder jusquà() {
		return space().word("=>");
	}


	public ShortDescriptionBuilder avec() {
		return space().word("avec");
	}

	public ShortDescriptionBuilder apres() {
		return space().word("apres");
	}

	public ShortDescriptionBuilder et() {
		return space().word("et");
	}

	public ShortDescriptionBuilder objectif() {
		return space().word("objectif");
	}

	public ShortDescriptionBuilder visible() {
		return space().word("visible");
	}

	public ShortDescriptionBuilder subit() {
		return space().word("subit");
	}

	public ShortDescriptionBuilder BM() {
		return space().word("BM");
	}

	public ShortDescriptionBuilder attaque() {
		return space().word("attaque");
	}

	public ShortDescriptionBuilder melee() {
		return space().word("mêlée");
	}

	public ShortDescriptionBuilder mouvementEngagement() {
		return space().word("mouvement d'engagement");
	}

	public ShortDescriptionBuilder monture() {
		return space().word("monture");
	}

	public ShortDescriptionBuilder elligible() {
		return space().word("élligible");
	}

	public ShortDescriptionBuilder toutes() {
		return space().word("toutes");
	}

	public ShortDescriptionBuilder figurine() {
		return space().word("ƒ");
	}

	public ShortDescriptionBuilder teleport() {
		return space().word("téléport");
	}

	public ShortDescriptionBuilder contest() {
		return space().word("contest");
	}

	public ShortDescriptionBuilder contesté() {
		return space().word("contesté");
	}

	public ShortDescriptionBuilder pour() {
		return space().word("pour");
	}

	public ShortDescriptionBuilder sur() {
		return space().word("sur");
	}

	public ShortDescriptionBuilder donne() {
		return space().word("donne");
	}

	public ShortDescriptionBuilder ordre() {
		return space().word("ordre");
	}

	public ShortDescriptionBuilder sansDepenserDePts() {
		return space().text("sans dépenser de pts");
	}

}
