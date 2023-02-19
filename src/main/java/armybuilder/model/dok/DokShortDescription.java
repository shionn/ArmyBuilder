package armybuilder.model.dok;

import static armybuilder.model.rule.desc.ShortDescriptionBuilder.sh;

import armybuilder.model.rule.desc.ShortDescriptionBuilder;
import armybuilder.model.unit.keyword.KeyWord;

public enum DokShortDescription {

	// @formatter:off
	FoiFanatique(sh().pourTous().keyword(KeyWord.FilleDeKhaine).ami().gagne().protection(6)),
	FillesDuPremierTemple(sh().pourTous().keyword(KeyWord.HaggNar).ami().gagne().plus(1).round().pour().rule(DokRule.RitesDeSang)),





	;// @formatter:on

	private String value;

	private DokShortDescription(ShortDescriptionBuilder sh) {
		this.value = sh.build();
	}

	public String toString() {
		return value;
	}
}
