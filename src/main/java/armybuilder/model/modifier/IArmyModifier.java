package armybuilder.model.modifier;

import java.util.function.Consumer;

import armybuilder.model.Army;
import armybuilder.model.option.IArmyOptionValue;

public interface IArmyModifier<T extends Enum<T> & IArmyOptionValue<T>> extends Consumer<Army> {

}
