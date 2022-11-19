package armybuilder.model.army;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import armybuilder.db.dbo.Allegiance;
import armybuilder.db.dbo.Army;
import armybuilder.db.dbo.SubAllegiance;
import armybuilder.model.army.rule.IRule;
import armybuilder.model.unit.KeyWord;

public class DecoratedArmy {

	private Army army;
	private List<IRule<?>> rules = new ArrayList<IRule<?>>();

	public DecoratedArmy(@Autowired Army army) {
		this.army = army;
	}

	public boolean is(SubAllegiance sub) {
		return army.getSubAllegiance() == sub;
	}

	public int id() {
		return army.getId();
	}

	public String name() {
		return army.getName();
	}

	public Allegiance allegiance() {
		return army.getAllegiance();
	}

	/**
	 * rules
	 */
	public List<IRule<?>> rules() {
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


}
