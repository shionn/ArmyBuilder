package armybuilder.v3.model.army.bataillon;

import java.util.List;

import armybuilder.v3.model.IHaveDisplayName;
import armybuilder.v3.model.army.Army;
import armybuilder.v3.model.army.IDecoreArmy;
import armybuilder.v3.model.rule.IRule;
import armybuilder.v3.model.unit.IDecorateUnit;
import armybuilder.v3.model.unit.Unit;

public class Bataillon implements IHaveDisplayName, IDecoreArmy, IDecorateUnit {

	private int id;
	private BataillonType type;
	private List<Unit> units;

	@Override
	public String getDisplayName() {
		return type.getDisplayName();
	}

	public List<IRule<?>> getRules() {
		return type.getRules();
	}

	public List<BataillonComposition> getCompositions() {
		return type.getCompositions();
	}

	public boolean availableFor(Unit unit) {
		return type.availableFor(unit);
	}

	@Override
	public void decorate(Unit unit) {
		type.decorate(unit);
	}

	@Override
	public void decorate(Army army) {
		type.decorate(army);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public BataillonType getType() {
		return type;
	}

	public void setType(BataillonType type) {
		this.type = type;
	}


	public List<Unit> getUnits() {
		return units;
	}

	public void setUnits(List<Unit> units) {
		this.units = units;
	}
}
