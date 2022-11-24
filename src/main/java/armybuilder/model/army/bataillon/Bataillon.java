package armybuilder.model.army.bataillon;

import java.util.List;

import armybuilder.model.IHaveDisplayName;
import armybuilder.model.army.Army;
import armybuilder.model.army.IDecoreArmy;
import armybuilder.model.rule.IRule;
import armybuilder.model.unit.IDecorateUnit;
import armybuilder.model.unit.Unit;

public class Bataillon implements IHaveDisplayName, IDecoreArmy, IDecorateUnit {

	private int id;
	private BataillonType type;

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


}
