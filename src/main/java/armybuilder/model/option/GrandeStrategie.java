package armybuilder.model.option;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import armybuilder.model.Army;
import armybuilder.model.rule.ArmyRuleType;
import armybuilder.model.rule.DescriptionReader;
import armybuilder.model.rule.IArmyRule;

public enum GrandeStrategie
		implements
		IArmyOptionValue<GrandeStrategie>,
		IArmyRule<GrandeStrategie> {
	CoupezLaTete(
			"Coupez la Tête",
			Arrays.asList(PackDeBataille.LutteDeGeneraux, PackDeBataille.BataillesRangees2021)),
	Vendetta(
			"Vendetta",
			Arrays.asList(PackDeBataille.LutteDeGeneraux, PackDeBataille.BataillesRangees2021)),
	TenezLaLigne(
			"Tenez la Ligne",
			Arrays.asList(PackDeBataille.LutteDeGeneraux, PackDeBataille.BataillesRangees2021)),
	PresenceDominante("Présence Dominante", Arrays.asList(PackDeBataille.BataillesRangees2021)),
	MaitreDesBetes("Maitre des Bêtes", Arrays.asList(PackDeBataille.BataillesRangees2021)),
	PrecieuseSorcellerie(
			"Précieuse Sorcellerie",
			Arrays.asList(PackDeBataille.BataillesRangees2021)),
	PiliersDeLaCoryance(
			"Piliers de la Croyance",
			Arrays.asList(PackDeBataille.BataillesRangees2021)),
	DomaineDuPredateur("Domaine du Prédateur", Arrays.asList(PackDeBataille.BataillesRangees2021)),

	;

	private String displayName;
	private List<PackDeBataille> packDeBatailles;

	private GrandeStrategie(String displayName, List<PackDeBataille> packDeBatailles) {
		this.displayName = displayName;
		this.packDeBatailles = packDeBatailles;
	}

	@Override
	public String getDisplayName() {
		return displayName;
	}

	@Override
	public ArmyOption getOption() {
		return ArmyOption.PackDeBataille;
	}

	@Override
	public boolean isOptionDisplayed(Army army) {
		return packDeBatailles.contains(army.getOption(ArmyOption.PackDeBataille));
	}

	@Override
	public void rebuild(Army army) {
	}

	@Override
	public void verify(Army army) {

	}

	@Override
	@SuppressWarnings("unchecked")
	public List<ArmyRuleType> getTypes() {
		return Collections.EMPTY_LIST;
	}

	@Override
	public String getDescription() throws IOException {
		return new DescriptionReader().read("GrandeStrategie/", name());
	}

}
