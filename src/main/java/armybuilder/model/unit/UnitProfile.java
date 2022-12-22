package armybuilder.model.unit;

public enum UnitProfile {
	_3_9_7_4("3", "9", "7", "4+"),
	_4_3_7_2("4", "3", "7", "2+"),
	_4_3_7_3("4", "3", "7", "3+"),
	_4_3_8_3("4", "3", "8", "3+"),
	_5_2_7_3("5", "2", "7", "3+"),
	_5_2_7_4("5", "2", "7", "4+"),
	_5_3_8_4("5", "3", "8", "4+"),
	_5_6_9_3("5", "6", "9", "3+"),
	_6_1_6_5("6", "1", "6", "5+"),
	_6_1_7_5("6", "1", "7", "5+"),
	_6_1_7_6("6", "1", "7", "6+"),
	_6_1_10_4("6", "1", "10", "4+"),
	_6_4_10_4("6", "4", "10", "4+"),
	_6_5_6_5("6", "5", "6", "5+"),
	_6_5_8_5("6", "5", "8", "5+"),
	_6_5_10_4("6", "5", "10", "4+"),
	_6_6_8_4("6", "6", "8", "4+"),
	_8_1_10_4("8", "1", "10", "4+"),
	_8_2_8_5("8", "2", "8", "5+"),
	_8_6_8_5("8", "6", "8", "5+"),
	_8_6_9_5("8", "6", "9", "5+"),
	_9_2_6_Dash("9", "2", "6", "-"),
	_9_9_10_4("9", "9", "10", "4+"),
	_12_2_7_4("12", "2", "7", "4+"),
	_12_5_8_4("12", "5", "8", "4+"),
	_12_5_10_4("12", "5", "10", "4+"),
	_12_8_6_3("12", "8", "6", "3+"),
	_12_8_9_3("12", "8", "9", "3+"),
	_12_8_10_3("12", "8", "10", "3+"),
	_14_1_7_5("14", "1", "7", "5+"),
	_14_1_7_6("14", "1", "7", "6+"),
	_S_12_10_4("*", "12", "10", "4+"),
	_S_13_8_5("*", "13", "8", "5+"),
	_S_15_6_4("*", "15", "6", "4"),
	None("", "", "", ""),
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

	public int getIntLife() {
		return Integer.parseInt(args[1]);
	}

	public String getCmd() {
		return args[2];
	}

	public String getSvg() {
		return args[3];
	}

}
