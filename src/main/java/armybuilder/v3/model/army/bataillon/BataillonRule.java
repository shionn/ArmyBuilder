package armybuilder.v3.model.army.bataillon;

import static armybuilder.v3.model.rule.desc.ShortDescriptionBuilder.sh;

import java.util.Arrays;
import java.util.List;

import armybuilder.v3.model.rule.IRule;
import armybuilder.v3.model.rule.PackDeBatailleRule;
import armybuilder.v3.model.rule.RuleType;
import armybuilder.v3.model.rule.desc.Description;
import armybuilder.v3.model.rule.desc.ShortDescriptionBuilder;
import armybuilder.v3.model.unit.keyword.KeyWord;

public enum BataillonRule implements IRule<BataillonRule> {
	Unifies("Unifiés", RuleType.Aptitude),
	Experts("Experts", RuleType.AptitudesDeCommandement, RuleType.PhaseDeTir, RuleType.PhaseDeCombat),
	Magnifiques("Magnifiques", RuleType.Composition),
	Tueurs("Tueurs", RuleType.AptitudesDeCommandement, RuleType.PhaseDeTir, RuleType.PhaseDeCombat,
			RuleType.PhaseDeCharge),
	Strateges("Stratèges", RuleType.Aptitude, RuleType.PhaseDesHeros),
	Rapides("Rapides", RuleType.AptitudesDeCommandement, RuleType.PhaseDeMouvement),
	PisterALOdeur("Pister à l'Odeur", RuleType.Aptitude, RuleType.PhaseBeforeStart),
	OutsidersExperts("Outsiders Experts", RuleType.Aptitude),
	ForceDominatrice("Force Dominatrice", RuleType.Aptitude),
	ChasseursDeTetes("Chasseur de Têtes", RuleType.Aptitude),
	UnButCommun(
			"Un But Commun",
			sh().unitée()
					.gagne()
					.keyword(KeyWord.GardeAssermentee)
					.et()
					.elligible()
					.rule(PackDeBatailleRule.MenerParLExemple),
			RuleType.Aptitude,
			RuleType.PhaseDeCombat),
	FraterniteDuCombat(
			"Fraternité du Combat",
			sh().toutes()
					.figurine()
					.ami()
					.aUnDemiPouce()
					.figurine()
					.ami()
					.aUnDemiPouce()
					.figurine()
					.ennemi()
					.text("est à porté"),
			RuleType.Aptitude,
			RuleType.PhaseDeCombat),
	// manuel du general 2023-24
	CoordinatedAugmentation("Coordinated Augmentation", RuleType.PhaseDesHerosPlayer),
	MagicHunters("Magic Hunters", RuleType.PhaseDeCombat),
	;
	private String displayName;
	private List<RuleType> types;
	private String shortDescription;

	private BataillonRule(String displayName, RuleType... types) {
		this.displayName = displayName;
		this.types = Arrays.asList(types);
	}

	private BataillonRule(String displayName, ShortDescriptionBuilder sh, RuleType... types) {
		this.displayName = displayName;
		this.types = Arrays.asList(types);
		this.shortDescription = sh.build();
	}

	@Override
	public List<RuleType> getTypes() {
		return types;
	}

	@Override
	public String getDisplayName() {
		return displayName;
	}

	@Override
	public Description getDescription() {
		return new Description("Generique/Bataillon/", this);
	}

	@Override
	public String getShortDescription() {
		return shortDescription;
	}

}
