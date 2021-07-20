package armybuilder.model.option;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import armybuilder.model.Army;

public enum ArmyOptionType {
	Allegiance("Allegiance", true, armybuilder.model.option.Allegiance.values()),
	SubAllegiance("Sous Allegiance", true, armybuilder.model.option.SubAllegiance.values()),
	PackDeBataille("Pack de Bataille", true, armybuilder.model.option.PackDeBataille.values()),
	GrandeStrategie("Grande Strategie", true, armybuilder.model.option.GrandeStrategie.values()),
	// MortalRealm,
	// GrandStrategy
	;

	private boolean select;
	private String displayName;
	private List<IArmyOption<?>> values;

	private ArmyOptionType(String displayName, boolean select, IArmyOption<?>... values) {
		this.displayName = displayName;
		this.select = select;
		this.values = Arrays.asList(values);
	}

	public List<IArmyOption<?>> getValues(Army army) {
		return values.stream().filter(o -> o.isOptionDisplayed(army)).collect(Collectors.toList());
	}

	public String getDisplayName() {
		return displayName;
	}

	public boolean isSelect() {
		return select;
	}

}
