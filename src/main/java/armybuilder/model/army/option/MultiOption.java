package armybuilder.model.army.option;

import java.util.List;

import armybuilder.model.army.Army;
import armybuilder.model.army.option.bataillon.Bataillon;
import armybuilder.model.unit.Unit;

public class MultiOption {
	private int id;
	private ArmyOption option;
	private IArmyOptionValue<?> value;

	public MultiOption(int id, ArmyOption option, IArmyOptionValue<?> value) {
		this.id = id;
		this.option = option;
		this.value = value;
	}

	public int getId() {
		return id;
	}

	public ArmyOption getOption() {
		return option;
	}

	public IArmyOptionValue<?> getValue() {
		return value;
	}

	public String getDisplayName() {
		return value.getDisplayName();
	}

	public boolean is(ArmyOption option) {
		return this.option == option;
	}

	public boolean isAvailable(Army army, Unit unit) {
		return value.isAvailable(army, unit);
	}

	public List<?> getCompositions() {
		return ((Bataillon) value).getCompositions();
	}

}
