package armybuilder.model.i;

import java.util.function.BiConsumer;

import armybuilder.model.Army;

public interface IArmyModifier<T extends Enum<T> & IArmyOption<T>> extends BiConsumer<T, Army> {

}
