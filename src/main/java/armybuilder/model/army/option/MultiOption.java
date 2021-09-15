package armybuilder.model.army.option;

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

}
