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

	public ShortDescriptionBuilder unitée() {
		return space().character('μ');
	}

	public ShortDescriptionBuilder ami() {
		return word("<sub>a</sub>");
	}

	public ShortDescriptionBuilder keyword(KeyWord keyWord) {
		return space().word("__").word(keyWord.getDisplayName()).word("__");
	}

	public ShortDescriptionBuilder a(int x) {
		return space().word("à ").number(x).character('"');
	}

	public ShortDescriptionBuilder role(RoleTactique ligne) {
		return space().character('*').word(ligne.getDisplayName()).character('*');
	}

	public ShortDescriptionBuilder text(String string) {
		return space().word(string);
	}

	public ShortDescriptionBuilder dot() {
		return character('.');
	}

	public ShortDescriptionBuilder si() {
		return space().word("si");
	}

	public ShortDescriptionBuilder non() {
		return space().character('!');
	}

}
