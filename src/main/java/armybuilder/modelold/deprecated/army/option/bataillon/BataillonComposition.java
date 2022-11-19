package armybuilder.modelold.deprecated.army.option.bataillon;

import armybuilder.modelold.deprecated.unit.Unit;

public interface BataillonComposition {

	boolean isAvailable(Unit unit);

	String getImg();

	boolean isOpt();

	int getCount();

}
