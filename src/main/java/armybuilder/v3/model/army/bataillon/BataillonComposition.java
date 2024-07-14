package armybuilder.v3.model.army.bataillon;

import armybuilder.v3.model.unit.Unit;

public interface BataillonComposition {

	boolean isAvailable(Unit unit);

	String getImg();

	boolean isOpt();

	int getCount();

}
