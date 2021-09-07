package armybuilder.model.army.option;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import armybuilder.model.army.Army;

public enum ArmyOption {
	Allegiance("Allegiance", true, armybuilder.model.army.option.Allegiance.values()),
	SubAllegiance("Sous Allegiance", true, armybuilder.model.army.option.SubAllegiance.values()),
	PackDeBataille("Pack de Bataille", true, armybuilder.model.army.option.PackDeBataille.values()),
	GrandeStrategie("Grande Strategie", true, armybuilder.model.army.option.GrandeStrategie.values()),
	Triomphes("Triomphe", true, armybuilder.model.army.option.Triomphes.values())
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
