package armybuilder.model.rule;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import armybuilder.serialisation.DescriptionReader;
import armybuilder.serialisation.EnumPropertyLoader;

public enum GeneriqueUnitRule implements IRule<GeneriqueUnitRule> {

	Predateur_9(RuleType.Aptitude),
	Predateur_12(RuleType.Aptitude),

	Sorcier_1_1(RuleType.Aptitude),
	Sorcier_2_1(RuleType.Aptitude),
	Sorcier_1_2(RuleType.Aptitude),
	Sorcier_2_2(RuleType.Aptitude),
	Sorcier_3_2_1(RuleType.Aptitude),

	Vol(RuleType.Aptitude),

	ArmeEnflammee(RuleType.Sort, RuleType.TraisUnitee),
	BrumeFantome(RuleType.Sort, RuleType.TraisUnitee),
	Levitation(RuleType.Sort, RuleType.TraisUnitee),

	Guerison(RuleType.Priere, RuleType.TraisUnitee),
	Malediction(RuleType.Priere, RuleType.TraisUnitee),
	Supervision(RuleType.Priere, RuleType.TraisUnitee),

	AmuletteDeLaDestinee(RuleType.Artefact),
	VolumeObscur(RuleType.Artefact),
	FioleDeVeninDeManticore(RuleType.Artefact),
	GraineDeRenaissance(RuleType.Artefact),

	GrandPretre(RuleType.TraitsDeCommandement),
	LeaderCompetent(RuleType.TraitsDeCommandement),
	MaitreDeLaMagie(RuleType.TraitsDeCommandement),
	SoifDeBataille(RuleType.TraitsDeCommandement),
	StatureHeroique(RuleType.TraitsDeCommandement),

	;

	private String displayName;
	private List<RuleType> types;

	GeneriqueUnitRule(RuleType... types) {
		this.displayName = EnumPropertyLoader.instance().name(this);
		this.types = Arrays.asList(types);
	}

	@Override
	public List<RuleType> getTypes() {
		return types;
	}

	@Override
	public String getDescription() throws IOException {
		return new DescriptionReader().read("GeneriqueUnit/", name());
	}

	@Override
	public String getDisplayName() {
		return displayName;
	}

}