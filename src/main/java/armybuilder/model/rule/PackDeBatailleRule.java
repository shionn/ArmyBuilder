package armybuilder.model.rule;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import armybuilder.serialisation.DescriptionReader;
import armybuilder.serialisation.EnumPropertyLoader;

public enum PackDeBatailleRule implements IRule<PackDeBatailleRule> {
	ActionDeseperee(RuleType.ActionsHeroiques, RuleType.PhaseDesHeros),
	CleDeLaVictoire(RuleType.Aptitude, RuleType.TraisUnitee, RuleType.PhaseDeTir),
	FrappeDOuverture(RuleType.ActionsHeroiques, RuleType.PhaseDesHeros),
	RegardDeGhur(RuleType.Sort, RuleType.TraisUnitee),
	RugissementSauvage(RuleType.AptitudesDeCommandement, RuleType.PhaseDeCombat),
	MenerParLExemple(RuleType.ActionsHeroiques, RuleType.PhaseDesHeros),
	Metamorphose(RuleType.Sort, RuleType.TraisUnitee),

	;

	private List<RuleType> types;
	private String displayName;

	PackDeBatailleRule(RuleType... types) {
		this.displayName = EnumPropertyLoader.instance().name(this);
		this.types = Arrays.asList(types);
	}

	@Override
	public List<RuleType> getTypes() {
		return types;
	}

	@Override
	public String getDescription() throws IOException {
		return new DescriptionReader().read("Generique/PackDeBataille/", name());
	}

	@Override
	public String getDisplayName() {
		return displayName;
	}

}
