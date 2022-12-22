package armybuilder.model.army;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import armybuilder.model.army.bataillon.Bataillon;
import armybuilder.model.army.bataillon.BataillonType;
import armybuilder.model.comparator.DisplayNameComparator;
import armybuilder.model.rule.GeneriqueRule;
import armybuilder.model.rule.IHaveRule;
import armybuilder.model.rule.IRule;
import armybuilder.model.unit.Unit;
import armybuilder.model.unit.keyword.KeyWord;
import armybuilder.model.unit.role.RoleTactique;

public class Army implements IHaveRule {
	private int id;
	private String name;
	private Allegiance allegiance;
	private SubAllegiance subAllegiance;
	private PackDeBataille packDeBataille;
	private GrandeStrategie grandeStrategie;
	private Triomphes triomphes;
	private AptitudeDeCommandement aptitudeDeCommandement;
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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean is(Allegiance allegiance) {
		return this.allegiance == allegiance;
	}

	public Allegiance getAllegiance() {
		return allegiance;
	}

	public void setAllegiance(Allegiance allegiance) {
		this.allegiance = allegiance;
	}

	public boolean is(SubAllegiance sub) {
		return this.subAllegiance == sub;
	}

	public SubAllegiance getSubAllegiance() {
		return subAllegiance;
	}

	public void setSubAllegiance(SubAllegiance subAllegiance) {
		this.subAllegiance = subAllegiance;
	}

	public List<Unit> getUnits() {
		units.sort(new Comparator<Unit>() {
			@Override
			public int compare(Unit o1, Unit o2) {
				return Integer.compare(o1.getModel().ordinal(), o2.getModel().ordinal());
			}
		});
		return units;
	}

	public void setUnits(List<Unit> units) {
		this.units = units;
	}

	public PackDeBataille getPackDeBataille() {
		return packDeBataille;
	}

	public void setPackDeBataille(PackDeBataille packDeBataille) {
		this.packDeBataille = packDeBataille;
	}

	public boolean is(PackDeBataille packDeBataille) {
		return this.packDeBataille == packDeBataille;
	}

	public void setGrandeStrategie(GrandeStrategie grandeStrategie) {
		this.grandeStrategie = grandeStrategie;
	}

	public GrandeStrategie getGrandeStrategie() {
		return grandeStrategie;
	}

	public boolean is(GrandeStrategie grandeStrategie) {
		return this.grandeStrategie == grandeStrategie;
	}

	public void setTriomphes(Triomphes triomphes) {
		this.triomphes = triomphes;
	}

	public Triomphes getTriomphes() {
		return triomphes;
	}

	public boolean is(Triomphes triomphes) {
		return this.triomphes == triomphes;
	}

	public List<Bataillon> getBataillons() {
		return bataillons;
	}

	public void setBataillons(List<Bataillon> bataillons) {
		this.bataillons = bataillons;
	}

	public long count(BataillonType type) {
		return bataillons.stream().filter(b -> b.getType() == type).count();
	}

	public AptitudeDeCommandement getAptitudeDeCommandement() {
		return aptitudeDeCommandement;
	}

	public void setAptitudeDeCommandement(AptitudeDeCommandement aptitudeDeCommandement) {
		this.aptitudeDeCommandement = aptitudeDeCommandement;
	}

	public boolean is(AptitudeDeCommandement aptitudeDeCommandement) {
		return this.aptitudeDeCommandement == aptitudeDeCommandement;
	}
}
