package armybuilder.model.army;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import armybuilder.model.comparator.DisplayNameComparator;
import armybuilder.model.rule.GeneriqueRule;
import armybuilder.model.rule.IHaveRule;
import armybuilder.model.rule.IRule;
import armybuilder.model.unit.Unit;
import armybuilder.model.unit.keyword.KeyWord;

public class Army implements IHaveRule {
	private int id;
	private String name;
	private Allegiance allegiance;
	private SubAllegiance subAllegiance;
	private List<Unit> units = new ArrayList<Unit>();

	private List<IRule<?>> rules = new ArrayList<IRule<?>>();

	public void decorate() {
		allegiance.decorate(this);
		subAllegiance.decorate(this);
		units.forEach(u -> u.decorate());
		Arrays.stream(GeneriqueRule.values()).forEach(r -> r.decorate(this));
	}

	/**
	 * rules
	 */
	@Override
	public List<IRule<?>> getRules() {
		List<IRule<?>> results = new ArrayList<IRule<?>>(rules);
		units.stream().flatMap(u -> u.getRules().stream()).distinct().forEach(results::add);
		results.sort(new DisplayNameComparator());
		return results;
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
	public int count(KeyWord keyWord) {
		return units(keyWord).size();
	}

	public List<Unit> units(KeyWord keyWord) {
		return units.stream().filter(u -> u.is(keyWord)).collect(Collectors.toList());
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

}
