package armybuilder.model.army.option;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import armybuilder.model.army.Army;

public enum ArmyOption {
	Allegiance("Allegiance", false, armybuilder.model.army.option.Allegiance.values()),
	SubAllegiance("Sous Allegiance", false, armybuilder.model.army.option.SubAllegiance.values()),
	PackDeBataille(
			"Pack de Bataille",
			false,
			armybuilder.model.army.option.PackDeBataille.values()),
	GrandeStrategie(
			"Grande Strategie",
			false,
			armybuilder.model.army.option.GrandeStrategie.values()),
	Triomphes("Triomphe", false, armybuilder.model.army.option.Triomphes.values()),
	Bataillon("Bataillon", true, armybuilder.model.army.option.bataillon.Bataillon.values());

	private String displayName;
	private List<IArmyOptionValue<?>> values;
	private boolean multi;

	private ArmyOption(String displayName, boolean multi, IArmyOptionValue<?>... values) {
		this.displayName = displayName;
		this.multi = multi;
		this.values = Arrays.asList(values);
	}

	public List<IArmyOptionValue<?>> getValues(Army army) {
		return values.stream().filter(o -> o.isOptionDisplayed(army)).collect(Collectors.toList());
	}

	public String getDisplayName() {
		return displayName;
	}

	public boolean isSelect() {
		return true;
	}

	public boolean isMulti() {
		return multi;
	}

}
