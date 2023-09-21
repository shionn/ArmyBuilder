package armybuilder.model.rule;

import java.util.Arrays;
import java.util.List;

import armybuilder.model.rule.desc.Description;
import armybuilder.serialisation.EnumPropertyLoader;

public enum GeneriqueUnitRule implements IRule<GeneriqueUnitRule> {

	Predateur_9(RuleType.Aptitude),
	Predateur_12(RuleType.Aptitude),

	Sorcier_1_1(RuleType.Aptitude),
	Sorcier_2_1(RuleType.Aptitude),
	Sorcier_1_2(RuleType.Aptitude),
	Sorcier_2_2(RuleType.Aptitude),
	Sorcier_3_2_1(RuleType.Aptitude),

	Elite(RuleType.Aptitude),
	Infranchissable(RuleType.Aptitude, RuleType.PhaseDeMouvement),
	MaitreDeGuerre(RuleType.Aptitude),
	Vol(RuleType.Aptitude),

	ArmeEnflammee(RuleType.Sort),
	BrumeFantome(RuleType.Sort),
	Levitation(RuleType.Sort),

	Guerison(RuleType.Priere),
	Malediction(RuleType.Priere),
	Supervision(RuleType.Priere),

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
	public Description getDescription() {
		return new Description(this);
	}

	@Override
	public String getDisplayName() {
		return displayName;
	}

	@Override
	public String toString() {
		return name() + getTypes();
	}

}
