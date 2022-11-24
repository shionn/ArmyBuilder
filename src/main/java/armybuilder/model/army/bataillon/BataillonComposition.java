package armybuilder.model.army.bataillon;

import armybuilder.model.unit.Unit;

public interface BataillonComposition {

	boolean isAvailable(Unit unit);

	String getImg();

	boolean isOpt();

	int getCount();

}
