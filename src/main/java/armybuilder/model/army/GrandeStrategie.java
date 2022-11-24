package armybuilder.model.army;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

import armybuilder.model.IHaveDisplayName;
import armybuilder.model.rule.IRule;
import armybuilder.model.rule.RuleType;
import armybuilder.serialisation.DescriptionReader;

public enum GrandeStrategie implements IHaveDisplayName, IDecoreArmy, IRule<GrandeStrategie> {
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
	private Function<Army, Boolean> available;

	private GrandeStrategie(String displayName, Function<Army, Boolean> available) {
		this.displayName = displayName;
		this.available = available;
	}

	@Override
	public String getDisplayName() {
		return displayName;
	}

	public boolean availableFor(Army army) {
		return available.apply(army);
	}

	@Override
	public String getDescription() throws IOException {
		return new DescriptionReader().read("GrandeStrategie/", name());
	}


	@Override
	public void decorate(Army army) {
		army.add(this);
	}

	@Override
	public List<RuleType> getTypes() {
		return Arrays.asList(RuleType.GrandeStrategie);
	}

}