package armybuilder.model.rule;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import armybuilder.model.Army;

public enum GeneriqueUnitRule implements IArmyRule<GeneriqueUnitRule> {

	Predateur_9("Prédateur", ArmyRuleType.Aptitude),
	Predateur_12("Prédateur", ArmyRuleType.Aptitude),
	
	Sorcier_1_1("Magie", ArmyRuleType.Aptitude),
	Sorcier_2_1("Magie", ArmyRuleType.Aptitude),
	Sorcier_1_2("Magie", ArmyRuleType.Aptitude),
	Sorcier_2_2("Magie", ArmyRuleType.Aptitude),
	Sorcier_3_2_1("Magie", ArmyRuleType.Aptitude),
	
	Vol(ArmyRuleType.Aptitude), 
	
	ArmeEnflammee("Arme en Flamme", ArmyRuleType.Sort, ArmyRuleType.TraisUnitee),
	BrumeFantome("Brume Fantôme", ArmyRuleType.Sort, ArmyRuleType.TraisUnitee),
	Levitation("Lévitation", ArmyRuleType.Sort, ArmyRuleType.TraisUnitee),
	
	Guerison("Guérison", ArmyRuleType.Priere, ArmyRuleType.TraisUnitee),
	Malediction("Malédiction", ArmyRuleType.Priere, ArmyRuleType.TraisUnitee),
	Supervision("Supervision", ArmyRuleType.Priere, ArmyRuleType.TraisUnitee),

	AmuletteDeLaDestinee("Amulette de la Destinée", ArmyRuleType.Artefact),
	VolumeObscur("Volume Obscur", ArmyRuleType.Artefact),
	FioleDeVeninDeManticore("Fiole de Venin de Manticore", ArmyRuleType.Artefact),
	GraineDeRenaissance("Graine de Renaissance", ArmyRuleType.Artefact),

	GrandPretre("Grand Prêtre", ArmyRuleType.TraitsDeCommandement),
	LeaderCompétent("Leader Compétent", ArmyRuleType.TraitsDeCommandement),
	MaitreDeLaMagie("Maître de la Magie", ArmyRuleType.TraitsDeCommandement),
	SoifDeBataille("Soif de Bataille", ArmyRuleType.TraitsDeCommandement),
	StatureHeroïque("Stature Héroïque", ArmyRuleType.TraitsDeCommandement),

	;

	private String displayName;
	private List<ArmyRuleType> types;

	GeneriqueUnitRule(ArmyRuleType... types) {
		this.types = Arrays.asList(types);
	}

	GeneriqueUnitRule(String displayName, ArmyRuleType... types) {
		this.displayName = displayName;
		this.types = Arrays.asList(types);
	}

	@Override
	public List<ArmyRuleType> getTypes() {
		return types;
	}

	@Override
	public String getDescription() throws IOException {
		return new DescriptionReader().read("GeneriqueUnit/", name());
	}

	@Override
	public String getDisplayName() {
		if (displayName == null) {
			return name();
		}
		return displayName;
	}

	@Override
	public void rebuild(Army army) {

	}

}
