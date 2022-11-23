package armybuilder.model.unit.option;

import armybuilder.model.IHaveDisplayName;
import armybuilder.model.unit.Unit;

public interface IUnitOption extends IHaveDisplayName {
	UnitOptionCategory getCategory();

	boolean availableFor(Unit unit);

	void decorate(Unit unit);
}
