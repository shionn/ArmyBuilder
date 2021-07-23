package armybuilder.model.rule;

import java.io.IOException;
import java.util.List;

public interface IArmyRule<T extends Enum<T> & IArmyRule<T>> {

	List<ArmyRuleType> getTypes();

	String name();

	String description() throws IOException;
}
