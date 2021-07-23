package armybuilder.model.unit;

public enum UnitProfile {
	_6_1_7_6("6", "1", "7", "6+"),
	_6_5_8_5("6", "5", "8", "5+"),
	_6_6_8_4("6", "6", "8", "4+"),
	_8_6_9_5("8", "6", "9", "5"),
	_S_12_10_4("*", "12", "10", "4+"),
	_S_13_8_5("*", "13", "8", "5+"),
	;

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
