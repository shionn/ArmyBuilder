package armybuilder.model.option;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import armybuilder.model.Army;

public enum ArmyOption {
	Allegiance("Allegiance", true, armybuilder.model.option.Allegiance.values()),
	SubAllegiance("Sous Allegiance", true, armybuilder.model.option.SubAllegiance.values()),
	PackDeBataille("Pack de Bataille", true, armybuilder.model.option.PackDeBataille.values()),
	GrandeStrategie("Grande Strategie", true, armybuilder.model.option.GrandeStrategie.values()),
	// MortalRealm,
	;

	private boolean select;
	private String displayName;
	private List<IArmyOptionValue<?>> values;

	private ArmyOption(String displayName, boolean select, IArmyOptionValue<?>... values) {
		this.displayName = displayName;
		this.select = select;
		this.values = Arrays.asList(values);
	}

	public List<IArmyOptionValue<?>> getValues(Army army) {
		return values.stream().filter(o -> o.isOptionDisplayed(army)).collect(Collectors.toList());
	}

	public String getDisplayName() {
		return displayName;
	}

	public boolean isSelect() {
		return select;
	}

}
