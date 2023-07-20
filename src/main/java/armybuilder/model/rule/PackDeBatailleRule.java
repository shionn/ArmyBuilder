package armybuilder.model.rule;

import java.util.Arrays;
import java.util.List;

import armybuilder.model.rule.desc.Description;
import armybuilder.model.rule.desc.ShortDescriptionBuilder;
import armybuilder.serialisation.EnumPropertyLoader;

public enum PackDeBatailleRule implements IRule<PackDeBatailleRule> {

	Metamorphose(RuleType.Sort),
	RegardDeGhur(RuleType.Sort),
	RugissementSauvage(RuleType.AptitudesDeCommandement, RuleType.PhaseDeCombat),

	/** V3 saison 2 */
	ActionDeseperee(RuleType.ActionsHeroiques, RuleType.PhaseDesHeros),
	AlimenteParLaRageDeGhur(RuleType.Aptitude),
	AutoriteDuDominant(RuleType.Aptitude),
	CapeDeNictoptere(RuleType.Artefact),
	CharmeDePlumeDeGriffe(RuleType.Artefact),
	CleDeLaVictoire(RuleType.Aptitude, RuleType.PhaseDeTir),
	DentGrincantesDeGallet(RuleType.Sort),
	EnteteCommeUnRhinox(RuleType.Aptitude),
	FrappeDOuverture(RuleType.ActionsHeroiques, RuleType.PhaseDesHeros),
	HeameDIvoire(RuleType.Artefact, RuleType.PhaseDeCharge),
	MaitreDesTunnels(RuleType.PhaseDeMouvement, RuleType.TraisUnitee),
	MenerParLExemple(RuleType.ActionsHeroiques, RuleType.PhaseDesHeros),
	PasDeRepliPasDeReddition(RuleType.AptitudesDeCommandement, RuleType.PhaseDeCombatDebut),
	/** V3 saison 3 */
	OptimalFocus(RuleType.TraisDeBataille, RuleType.PhaseDesHeros),
	Hoarfrost(RuleType.Sort),

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
	public Description getDescription() {
		return new Description("Generique/PackDeBataille/", this);
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
