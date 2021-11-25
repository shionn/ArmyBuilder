package armybuilder.model.unit.option;

import java.util.Set;

import armybuilder.model.army.Army;
import armybuilder.model.army.rule.IArmyRule;
import armybuilder.model.unit.Unit;

public interface IUnitOptionValue<T extends Enum<T> & IUnitOptionValue<T>> {

	boolean isAvailable(Army army, Unit unit);

	UnitOption getOption();

	String getDisplayName();

	default String getFullDisplayName() {
		return getOption().getDisplayName() + " : " + getDisplayName();
	}

	String name();

	void rebuild(Unit unit);

	default Set<IArmyRule<?>> getDisplayedRules() {
		Unit fake = new Unit();
		this.rebuild(fake);
		return fake.getRules();
	}
}
