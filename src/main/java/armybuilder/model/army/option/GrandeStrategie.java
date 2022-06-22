package armybuilder.model.army.option;

import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;

import armybuilder.model.army.Listing;
import armybuilder.model.army.rule.ArmyRuleType;
import armybuilder.model.army.rule.IArmyRule;
import armybuilder.serialisation.DescriptionReader;

public enum GrandeStrategie implements IListingOptionValue<GrandeStrategie>, IArmyRule<GrandeStrategie> {
	BainDeSang("Bain de Sang", l -> l.is(Allegiance.DoK)),
	ConquisAuNomDeKhaine("Conquis au nom de Khaine", l -> l.is(Allegiance.DoK)),
	CoupezLaTete(
			"Coupez la Tête",
			l -> l.is(PackDeBataille.LutteDeGeneraux) || l.is(PackDeBataille.BataillesRangees2021)),
	DefendreCeQuiNousAppartient("Défendre ce qui nous appartient", l -> l.is(PackDeBataille.BataillesRangees2022)),
	DemonstrationDeForce("Démonstration de Force", l -> l.is(PackDeBataille.BataillesRangees2022)),
	DomaineDuPredateur("Domaine du Prédateur", l -> l.is(PackDeBataille.BataillesRangees2021)),
	DomptezLaTerre("Domptez la Terre", l -> l.is(PackDeBataille.BataillesRangees2022)),
	MaitreDesBetes("Maitre des Bêtes", l -> l.is(PackDeBataille.BataillesRangees2021)),
	PasDePlacePourLesFaibles("Pas de Place pour les Faibles", l -> l.is(PackDeBataille.BataillesRangees2022)),
	PiliersDeLaCoryance("Piliers de la Croyance", l -> l.is(PackDeBataille.BataillesRangees2021)),
	PrecieuseSorcellerie("Précieuse Sorcellerie", l -> l.is(PackDeBataille.BataillesRangees2021)),
	PrendreCeQuIlsOnt("Prendre ce qu'ils ont", l -> l.is(PackDeBataille.BataillesRangees2022)),
	PresenceDominante("Présence Dominante", l -> l.is(PackDeBataille.BataillesRangees2021)),
	PreuveDeDominance("Preuve de Dominance", l -> l.is(PackDeBataille.BataillesRangees2022)),
	RienQueLaDestruction("Rien que la Destruction", l -> l.is(Allegiance.DoK)),
	TenezLaLigne(
			"Tenez la Ligne",
			l -> l.is(PackDeBataille.LutteDeGeneraux) || l.is(PackDeBataille.BataillesRangees2021)),
	Vendetta("Vendetta", l -> l.is(PackDeBataille.LutteDeGeneraux) || l.is(PackDeBataille.BataillesRangees2021)),
	ZelotesSanguinaires("Zélotes Sanguinaires", l -> l.is(Allegiance.DoK)),

	;

	private String displayName;
	private Function<Listing, Boolean> available;

	private GrandeStrategie(String displayName, Function<Listing, Boolean> available) {
		this.displayName = displayName;
		this.available = available;
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
		return available.apply(listing);
	}

	@Override
	public void rebuild(Listing listing) {
		// TODO Auto-generated method stub

	}

}
