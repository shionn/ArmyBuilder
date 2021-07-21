package armybuilder.model.unit;

public interface IUnitOption<T extends Enum<T> & IUnitOption<T>> {

	String getDisplayName();

	UnitOptionType getType();

}
