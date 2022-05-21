package armybuilder.model.army;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import armybuilder.model.army.compare.UnitComparator;
import armybuilder.model.army.compare.UnitModelComparator;
import armybuilder.model.army.option.SubAllegiance;
import armybuilder.model.unit.IUnitModel;
import armybuilder.model.unit.Unit;
import armybuilder.model.unit.option.UnitOption;

public class Listing {

	private int id;

	private SubAllegiance subAllegiance;
	private List<Unit> units = new ArrayList<Unit>();

	public Listing(int id, SubAllegiance subAllegiance) {
		this.id = id;
		this.subAllegiance = subAllegiance;
	}

	public void rebuild() {
		units.stream().forEach(u -> u.reset());
		units.stream().forEach(u -> u.rebuild());
	}

	/** suballegiance **/
	public boolean is(SubAllegiance sub) {
		return this.subAllegiance == sub;
	}

	public void select(SubAllegiance sub) {
		this.subAllegiance = sub;
	}

	public SubAllegiance getSubAllegiance() {
		return subAllegiance;
	}

	/** units **/
	public List<IUnitModel> getAvailableUnitChoice() {
		return subAllegiance.allegiance()
				.units()
				.stream()
				.filter(u -> u.availableFor(this))
				.sorted(new UnitModelComparator())
				.collect(Collectors.toList());
	}

	public boolean have(IUnitModel unit) {
		return units.stream().filter(u -> u.is(unit)).findFirst().isPresent();
	}

	public void add(Unit unit) {
		this.units.add(unit);
	}

	public List<Unit> units() {
		return units.stream().sorted(new UnitComparator()).collect(Collectors.toList());
	}

	public List<Unit> units(IUnitModel model) {
		return units.stream().filter(u -> u.is(model)).sorted(new UnitComparator()).collect(Collectors.toList());
	}

	public void remove(Unit u) {
		this.units.remove(u);
	}

	public Unit unit(UnitOption option) {
		return this.units.stream().filter(u -> u.is(option)).findFirst().orElse(null);
	}

	/** getters */
	public String getDisplayName() {
		return subAllegiance == null ? "Select suballegiance" : subAllegiance.getDisplayName();
	}

	public int points() {
		return units.stream().collect(Collectors.summingInt(u -> u.points()));
	}

	public int getId() {
		return id;
	}

	public boolean is(int id) {
		return this.id == id;
	}


}
