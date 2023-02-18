package armybuilder.model.rule;

import static armybuilder.model.rule.ShortDescriptionBuilder.sh;

import java.util.Arrays;
import java.util.List;

import armybuilder.model.unit.role.RoleTactique;
import armybuilder.serialisation.DescriptionReader;
import armybuilder.serialisation.EnumPropertyLoader;

public enum PackDeBatailleRule implements IRule<PackDeBatailleRule> {
	ActionDeseperee(RuleType.ActionsHeroiques, RuleType.PhaseDesHeros),
	CleDeLaVictoire(
			sh().si()
					.a(1)
					.unitée()
					.ami()
					.role(RoleTactique.Ligne)
					.non()
					.text("cible de projectil"),
			RuleType.Aptitude,
			RuleType.TraisUnitee, RuleType.PhaseDeTir),
	FrappeDOuverture(RuleType.ActionsHeroiques, RuleType.PhaseDesHeros),
	RegardDeGhur(RuleType.Sort, RuleType.TraisUnitee),
	RugissementSauvage(RuleType.AptitudesDeCommandement, RuleType.PhaseDeCombat),
	MenerParLExemple(RuleType.ActionsHeroiques, RuleType.PhaseDesHeros),
	Metamorphose(RuleType.Sort, RuleType.TraisUnitee),

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
