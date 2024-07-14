package armybuilder.v3.model.rule;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

import armybuilder.v3.model.rule.desc.Description;
import armybuilder.v3.model.unit.Unit;
import armybuilder.v3.serialisation.EnumPropertyLoader;

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
	Rupture(RuleType.Sort),
	MercilessBlizzard(RuleType.Sort),
	ShamanOfTheChilledLands(u -> u.add(Hoarfrost, Rupture, MercilessBlizzard), RuleType.TraitsDeCommandement),
	EyeOfTheBlizzard(RuleType.TraitsDeCommandement, RuleType.PhaseDesHerosPlayer),
	ChilledToTheBone(RuleType.TraitsDeCommandement, RuleType.Sort),
	EaterOfMagic(RuleType.TraitsDeCommandement, RuleType.Sort),

;

	private List<RuleType> types;
	private String displayName;
	private String shortDescription;
	private Consumer<Unit> modifier;

	PackDeBatailleRule(RuleType... types) {
		this.displayName = EnumPropertyLoader.instance().name(this);
		this.types = Arrays.asList(types);
	}

	PackDeBatailleRule(Consumer<Unit> modifier, RuleType... types) {
		this(types);
		this.modifier = modifier;
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

	@Override
	public void decorate(Unit unit) {
		if (modifier != null) {
			modifier.accept(unit);
		}
	}

}
