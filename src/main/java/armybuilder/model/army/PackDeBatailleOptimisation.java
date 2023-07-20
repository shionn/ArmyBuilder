package armybuilder.model.army;

import armybuilder.model.unit.Unit;
import armybuilder.model.unit.option.IUnitOption;
import armybuilder.model.unit.option.UnitOptionCategory;

public enum PackDeBatailleOptimisation implements IUnitOption {

	HandCarvedNullstoneIcon();

	@Override
	public String getDisplayName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UnitOptionCategory getCategory() {
		// TODO Auto-generated method stub
		return UnitOptionCategory.AspectDuChampion;
	}

	@Override
	public boolean availableFor(Unit unit) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void decorate(Unit unit) {
		// TODO Auto-generated method stub

	}

}
