package armybuilder.model.check;

import armybuilder.model.Army;

public interface ICheck<T extends Enum<T> & ICheck<T>> {

	public void verify(Army army);

}
