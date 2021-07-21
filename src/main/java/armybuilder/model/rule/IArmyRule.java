package armybuilder.model.rule;

import java.util.List;

public interface IArmyRule<T extends Enum<T> & IArmyRule<T>> {

	List<ArmyRuleType> getTypes();

	String name();
}
