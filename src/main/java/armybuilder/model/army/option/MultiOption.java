package armybuilder.model.army.option;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import armybuilder.model.army.Army;
import armybuilder.model.army.option.bataillon.Bataillon;
import armybuilder.model.unit.Unit;
import armybuilder.serialisation.ArmyOptionJsonDeserializer;

@JsonAutoDetect(fieldVisibility = Visibility.ANY, getterVisibility = Visibility.NONE)
@JsonIgnoreProperties(ignoreUnknown = true)
public class MultiOption {
	private int id;
	private ArmyOption option;
	@JsonDeserialize(converter = ArmyOptionJsonDeserializer.class)
	private IArmyOptionValue<?> value;

	public MultiOption() {

	}

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
