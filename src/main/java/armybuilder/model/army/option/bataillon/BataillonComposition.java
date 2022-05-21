package armybuilder.model.army.option.bataillon;

import armybuilder.model.army.OldArmy;
import armybuilder.model.unit.Unit;

@Deprecated
public interface BataillonComposition {

	boolean isAvailable(Unit unit);

	boolean verify(OldArmy army);

	String getImg();

	boolean isOpt();

	int getCount();

}
