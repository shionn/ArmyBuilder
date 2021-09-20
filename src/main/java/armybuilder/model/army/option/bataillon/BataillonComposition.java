package armybuilder.model.army.option.bataillon;

import armybuilder.model.army.Army;
import armybuilder.model.unit.Unit;

public interface BataillonComposition {

	boolean isAvailable(Unit unit);

	boolean verify(Army army);

	String getImg();

	boolean isOpt();

	int getCount();

}
