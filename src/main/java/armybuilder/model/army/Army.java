package armybuilder.model.army;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import armybuilder.model.rule.IRule;
import armybuilder.model.unit.Unit;
import armybuilder.modelold.deprecated.unit.KeyWord;

public class Army {
	private int id;
	private String name;
	private Allegiance allegiance;
	private SubAllegiance subAllegiance;
	private List<Unit> units;

	private List<IRule<?>> rules = new ArrayList<IRule<?>>();

	/**
	 * rules
	 */
	public List<IRule<?>> getRules() {
		return rules;
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
	public int count(KeyWord khinerai) {
		// TODO Auto-generated method stub
		return 0;
	}

	/**
	 * getter/setters/is
	 */
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
		return units;
	}

	public void setUnits(List<Unit> units) {
		this.units = units;
	}
}
