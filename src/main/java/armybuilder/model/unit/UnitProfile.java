package armybuilder.model.unit;

public enum UnitProfile {
	_6_6_8_4("6", "6", "8", "4+"), _S_12_10_4("*", "12", "10", "4+");

	private String[] args;

	private UnitProfile(String... args) {
		this.args = args;
	}

	public String getMvt() {
		return args[0];
	}

	public String getLife() {
		return args[1];
	}

	public String getCmd() {
		return args[2];
	}

	public String getSvg() {
		return args[3];
	}

}
