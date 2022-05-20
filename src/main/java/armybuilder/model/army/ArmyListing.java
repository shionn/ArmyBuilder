package armybuilder.model.army;

import java.util.List;
import java.util.stream.Collectors;

import armybuilder.model.army.option.SubAllegiance;
import armybuilder.model.unit.IUnitModel;

public class ArmyListing {

	private int id;

	private SubAllegiance subAllegiance;

	public ArmyListing(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public boolean is(int id) {
		return this.id == id;
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
		return subAllegiance.allegiance().units().stream().filter(u -> u.availableFor(this))
				.collect(Collectors.toList());
	}

	public String getDisplayName() {
		return subAllegiance == null ? "Select suballegiance" : subAllegiance.getDisplayName();
	}

	public int getPoints() {
		return -1;
	}



}
