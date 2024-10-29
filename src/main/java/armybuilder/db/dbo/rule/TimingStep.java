package armybuilder.db.dbo.rule;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum TimingStep {
	Deploy("wind-rose"),
	Passif(null),
	PassifGreen(null),
	StartRound("wind-rose"),
	Hero("wind-rose"),
	Movement("movement"),
	Shot("bow"),
	Charge("movement"),
	Battle("battle"),
	End("flag");

	private final String icon;

	public String getColor() {
		return name().toLowerCase();
	}

	public String getIcon() {
		return icon;
	}

}
