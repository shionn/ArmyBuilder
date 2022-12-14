package armybuilder.model.skaven;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import armybuilder.model.rule.IRule;
import armybuilder.model.rule.RuleType;
import armybuilder.serialisation.DescriptionReader;
import armybuilder.serialisation.EnumPropertyLoader;

public enum SkavenRule implements IRule<SkavenRule> {
	DirigerDepuisLArriere(RuleType.TraisDeBataille),
	SauveQuiPeut(RuleType.TraisDeBataille),
	LUnionFaitLaForce(RuleType.TraisDeBataille),

	// aptitude des heoro de sous clan
	CreationsPrisees_1(RuleType.TraisDeBataille),
	CreationsPrisees_3(RuleType.TraisDeBataille),
	ManipulateursHabiles(RuleType.Aptitude, RuleType.TraisUnitee),
	ToujoursTroisCoupsDeGriffesDAvance(RuleType.AptitudesDeCommandement),
	MaitresDuMeurtre_1(RuleType.TraisDeBataille),
	MaitresDuMeurtre_3(RuleType.TraisDeBataille),
	PuissantsChefsDeGuerre_1(RuleType.ActionsHeroiques),
	PuissantsChefsDeGuerre_3(RuleType.ActionsHeroiques),

	// aptitude d'unité
	AppelDesCrevasses(RuleType.Aptitude, RuleType.TraisUnitee),
	AutelDuGrandRatCornu(RuleType.Aptitude, RuleType.TraisUnitee),
	AvalancheDEnergie(RuleType.Aptitude, RuleType.TraisUnitee),
	CarillonFuneste(RuleType.Aptitude, RuleType.TraisUnitee),
	PousseeVersLaBataille(RuleType.Aptitude, RuleType.TraisUnitee),
	RemousParDelaLeVoile(RuleType.Aptitude, RuleType.TraisUnitee),
	FragmentsDeMalepierre(RuleType.Aptitude, RuleType.TraisUnitee),

	Fletrissement(RuleType.Sort),

	;

	private List<RuleType> types;
	private String name;

	SkavenRule(RuleType... types) {
		this.types = Arrays.asList(types);
		this.name = EnumPropertyLoader.instance().name(this);
	}

	@Override
	public String getDisplayName() {
		return name;
	}

	@Override
	public List<RuleType> getTypes() {
		return types;
	}

	@Override
	public String getDescription() throws IOException {
		return new DescriptionReader().read(this);
	}

}
