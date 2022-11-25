package armybuilder.model.stormcast;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import armybuilder.model.rule.IRule;
import armybuilder.model.rule.RuleType;
import armybuilder.serialisation.DescriptionReader;
import armybuilder.serialisation.EnumPropertyLoader;

public enum StormcastRule implements IRule<StormcastRule> {
	FlamboiementDeGloire(RuleType.TraisDeBataille),
	DescendantsDeLOrage(RuleType.TraisDeBataille),

	PretreMortis(RuleType.Aptitude, RuleType.TraisUnitee),

	OrageGuerisseur(RuleType.Priere),
	OrageFoudroyant(RuleType.Priere),

//	AAA(RuleType.Aptitude),
//	AAA(RuleType.Aptitude),
//	AAA(RuleType.Aptitude),
//	AAA(RuleType.Aptitude),
//	AAA(RuleType.Aptitude),
//	AAA(RuleType.Aptitude),
//	AAA(RuleType.Aptitude),
//	AAA(RuleType.Aptitude),
//	AAA(RuleType.Aptitude),
//	AAA(RuleType.Aptitude),
//	AAA(RuleType.Aptitude),
//	AAA(RuleType.Aptitude),
//	AAA(RuleType.Aptitude),
//	AAA(RuleType.Aptitude),
//	AAA(RuleType.Aptitude),
//	AAA(RuleType.Aptitude),
//	AAA(RuleType.Aptitude),
//	AAA(RuleType.Aptitude),
//	AAA(RuleType.Aptitude),
//	AAA(RuleType.Aptitude),
//	AAA(RuleType.Aptitude),
//	AAA(RuleType.Aptitude),
//	AAA(RuleType.Aptitude),
//	AAA(RuleType.Aptitude),
//	AAA(RuleType.Aptitude),
//	AAA(RuleType.Aptitude),
//	AAA(RuleType.Aptitude),
//	AAA(RuleType.Aptitude),
//	AAA(RuleType.Aptitude),
//	AAA(RuleType.Aptitude),
//	AAA(RuleType.Aptitude),
	;

	private List<RuleType> types;
	private String displayName;

	private StormcastRule(RuleType... types) {
		this.displayName = EnumPropertyLoader.instance().name(this);
		this.types = Arrays.asList(types);
	}

	@Override
	public String getDisplayName() {
		return displayName;
	}

	@Override
	public List<RuleType> getTypes() {
		return types;
	}

	@Override
	public String getDescription() throws IOException {
		return new DescriptionReader().read("Stormcast/", name());
	}

}
