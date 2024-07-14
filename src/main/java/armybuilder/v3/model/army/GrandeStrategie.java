package armybuilder.v3.model.army;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

import armybuilder.v3.model.IHaveDisplayName;
import armybuilder.v3.model.rule.IRule;
import armybuilder.v3.model.rule.RuleType;
import armybuilder.v3.model.rule.desc.Description;
import armybuilder.v3.model.unit.keyword.KeyWord;

public enum GrandeStrategie implements IHaveDisplayName, IDecoreArmy, IRule<GrandeStrategie> {
	CoupezLaTete(
			"Coupez la Tête",
			l -> l.is(PackDeBataille.LutteDeGeneraux) || l.is(PackDeBataille.BataillesRangees2021)),
	CeJourEstLeNotre(
			"Ce jour est le nôtre",
			l -> l.is(PackDeBataille.BataillesRangees2023)),
	DefendreCeQuiNousAppartient(
			"Défendre ce qui nous appartient",
			l -> l.is(PackDeBataille.BataillesRangees2022) || l.is(PackDeBataille.BataillesRangees2023)),
	DemonstrationDeForce("Démonstration de Force", l -> l.is(PackDeBataille.BataillesRangees2022)),
	DomaineDuPredateur("Domaine du Prédateur", l -> l.is(PackDeBataille.BataillesRangees2021)),
	DomptezLaTerre("Domptez la Terre", l -> l.is(PackDeBataille.BataillesRangees2022) || l.is(PackDeBataille.BataillesRangees2023)),
	InstinctDuSurvivant("Instinct du Survivant", l -> l.is(PackDeBataille.BataillesRangees2023)),
	MaitreDesBetes("Maitre des Bêtes", l -> l.is(PackDeBataille.BataillesRangees2021)),
	PasDePlacePourLesFaibles("Pas de Place pour les Faibles", l -> l.is(PackDeBataille.BataillesRangees2022)),
	PiliersDeLaCoryance("Piliers de la Croyance", l -> l.is(PackDeBataille.BataillesRangees2021)),
	PrecieuseSorcellerie("Précieuse Sorcellerie", l -> l.is(PackDeBataille.BataillesRangees2021)),
	PrendreCeQuIlsOnt(
			"Prendre ce qu'ils ont",
			l -> l.is(PackDeBataille.BataillesRangees2022) || l.is(PackDeBataille.BataillesRangees2023)),
	PresenceDominante("Présence Dominante", l -> l.is(PackDeBataille.BataillesRangees2021)),
	PreuveDeDominance("Preuve de Dominance", l -> l.is(PackDeBataille.BataillesRangees2022)),
	Revendication(
			"Revendication",
			l -> l.is(PackDeBataille.BataillesRangees2023) && l.count(KeyWord.ChampionDeGallet) >= 3),
	TenezLaLigne(
			"Tenez la Ligne",
			l -> l.is(PackDeBataille.LutteDeGeneraux) || l.is(PackDeBataille.BataillesRangees2021)),
	Vendetta("Vendetta", l -> l.is(PackDeBataille.LutteDeGeneraux) || l.is(PackDeBataille.BataillesRangees2021)),


	BainDeSang("Bain de Sang", l -> l.is(Allegiance.DoK)),
	ConquisAuNomDeKhaine("Conquis au nom de Khaine", l -> l.is(Allegiance.DoK)),
	RienQueLaDestruction("Rien que la Destruction", l -> l.is(Allegiance.DoK)),
	ZelotesSanguinaires("Zélotes Sanguinaires", l -> l.is(Allegiance.DoK)),

	DemembrezLeBrave("Démembrez le Brave", l -> l.is(Allegiance.Nighthaunt)),
	FuirOuLaisserFuir("Fuir ou Laisser Fuir", l -> l.is(Allegiance.Nighthaunt)),
	NourrisDeTerreur("Nourris de Terreur", l -> l.is(Allegiance.Nighthaunt)),
	UneAmeAPrendre("Une Ame à Prendre", l -> l.is(Allegiance.Nighthaunt)),
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
	public Description getDescription() {
		return new Description(this);
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
