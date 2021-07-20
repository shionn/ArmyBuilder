package armybuilder.model.modifier;

import java.util.function.BiConsumer;

import armybuilder.model.Army;
import armybuilder.model.option.IArmyOption;

public interface IArmyModifier<T extends Enum<T> & IArmyOption<T>> extends BiConsumer<T, Army> {

}
