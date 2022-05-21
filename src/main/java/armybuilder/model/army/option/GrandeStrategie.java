package armybuilder.model.army.option;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import armybuilder.model.army.Listing;
import armybuilder.model.army.OldArmy;
import armybuilder.model.army.rule.ArmyRuleType;
import armybuilder.model.army.rule.IArmyRule;
import armybuilder.serialisation.DescriptionReader;

@Deprecated
public enum GrandeStrategie
		implements
		IListingOptionValue<GrandeStrategie>,
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
	public String displayName() {
		return displayName;
	}

	@Override
	public ListingOption option() {
		return ListingOption.GrandeStrategie;
	}

	@Override
	public boolean isOptionDisplayed(OldArmy army) {
		return packDeBatailles.contains(army.option(ListingOption.PackDeBataille));
	}

	@Override
	public void rebuild(OldArmy army) {
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

	@Override
	public boolean availableFor(Listing listing) {
		return true;
	}

	@Override
	public void rebuild(Listing listing) {
		// TODO Auto-generated method stub

	}

}
