package armybuilder.v3.model.unit.option;

import armybuilder.v3.model.IHaveDisplayName;
import armybuilder.v3.model.unit.Unit;

public interface IUnitOption extends IHaveDisplayName {
	UnitOptionCategory getCategory();

	boolean availableFor(Unit unit);

	void decorate(Unit unit);
}
