package armybuilder.model.army;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import armybuilder.model.army.bataillon.Bataillon;
import armybuilder.model.army.bataillon.BataillonType;
import armybuilder.model.army.turn.TurnStep;
import armybuilder.model.army.turn.TurnStepBuilder;
import armybuilder.model.comparator.DisplayNameComparator;
import armybuilder.model.comparator.SubEnumOrdinalComparator;
import armybuilder.model.rule.GeneriqueRule;
import armybuilder.model.rule.IHaveRule;
import armybuilder.model.rule.IRule;
import armybuilder.model.rule.desc.DescriptionMode;
import armybuilder.model.unit.Unit;
import armybuilder.model.unit.keyword.KeyWord;
import armybuilder.model.unit.role.RoleTactique;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Army implements IHaveRule {
	private int id;
	private String name;
	private Allegiance allegiance;
	private SubAllegiance subAllegiance;
	private PackDeBataille packDeBataille;
	private GrandeStrategie grandeStrategie;
	private Triomphes triomphes;
	private AptitudeDeCommandement aptitudeDeCommandement;
	private DescriptionMode descriptionMode;
	private List<Unit> units = new ArrayList<Unit>();
	private List<Bataillon> bataillons = new ArrayList<Bataillon>();
	private List<IRule<?>> rules = new ArrayList<IRule<?>>();

	public void decorate() {
		units.forEach(Unit::decorate);
		Arrays.asList(allegiance, subAllegiance, packDeBataille, grandeStrategie, triomphes, aptitudeDeCommandement)
				.stream()
				.filter(Objects::nonNull)
				.forEach(opt -> opt.decorate(this));
		bataillons.forEach(bat -> bat.decorate(this));
		Arrays.stream(GeneriqueRule.values()).forEach(r -> r.decorate(this));
	}

	public List<CheckRule> getChecks() {
		return Arrays.stream(CheckRule.values()).filter(c -> c.verify(this)).toList();
	}

	public List<TurnStep> getSteps() {
		return new TurnStepBuilder().build(this);

	}

	/**
	 * rules
	 */
	@Override
	public List<IRule<?>> getRules() {
		return rules.stream().distinct().sorted(new DisplayNameComparator()).toList();
	}

	public List<IRule<?>> getAllRules() {
		List<IRule<?>> results = new ArrayList<IRule<?>>(rules);
		units.stream().flatMap(u -> u.getRules().stream()).forEach(results::add);
		return results.stream().distinct().sorted(new DisplayNameComparator()).toList();
	}

	public void add(IRule<?>... rules) {
		this.rules.addAll(Arrays.asList(rules));
	}

	public void addIf(boolean condition, IRule<?>... rules) {
		if (condition) {
			add(rules);
		}
	}

	/**
	 * units
	 */
	public int count(KeyWord... keyWords) {
		return units(keyWords).size();
	}

	public List<Unit> units(KeyWord... keyWords) {
		return units.stream().filter(u -> u.is(keyWords)).collect(Collectors.toList());
	}

	public List<Unit> units(RoleTactique role) {
		return units.stream().filter(u -> u.is(role)).collect(Collectors.toList());
	}

	public List<Unit> units(Predicate<Unit> filter) {
		return units.stream().filter(filter).collect(Collectors.toList());
	}

	/**
	 * bataillons
	 */
	public List<Bataillon> bataillons(Unit unit) {
		return bataillons.stream().filter(bat -> bat.availableFor(unit)).toList();
	}

	/**
	 * getter/setters/is
	 */
	public int getPoints() {
		return units.stream().map(u -> u.getPoints()).reduce(Integer.valueOf(0), (a, b) -> a + b);
	}

	public boolean is(Allegiance allegiance) {
		return this.allegiance == allegiance;
	}

	public boolean is(SubAllegiance sub) {
		return this.subAllegiance == sub;
	}

	public List<Unit> getUnits() {
		units.sort(new SubEnumOrdinalComparator<Unit>(Unit::getModel));
		return units;
	}

	public boolean is(PackDeBataille packDeBataille) {
		return this.packDeBataille == packDeBataille;
	}

	public boolean is(GrandeStrategie grandeStrategie) {
		return this.grandeStrategie == grandeStrategie;
	}

	public boolean is(Triomphes triomphes) {
		return this.triomphes == triomphes;
	}

	public long count(BataillonType type) {
		return bataillons.stream().filter(b -> b.getType() == type).count();
	}

	public boolean is(AptitudeDeCommandement aptitudeDeCommandement) {
		return this.aptitudeDeCommandement == aptitudeDeCommandement;
	}

}
