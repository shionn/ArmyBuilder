package armybuilder.model.serialisation;

import java.util.Arrays;

import com.fasterxml.jackson.databind.util.StdConverter;

import armybuilder.model.option.Allegiance;
import armybuilder.model.option.GrandeStrategie;
import armybuilder.model.option.IArmyOptionValue;
import armybuilder.model.option.PackDeBataille;
import armybuilder.model.option.SubAllegiance;
import armybuilder.model.option.Triomphes;

public class ArmyOptionJsonDeserializer extends StdConverter<String, IArmyOptionValue<?>> {

	@Override
	public IArmyOptionValue<?> convert(String value) {
		for (Class<? extends Enum<?>> type : Arrays.asList(Allegiance.class, GrandeStrategie.class,
				PackDeBataille.class, SubAllegiance.class, Triomphes.class)) {
			for (Enum<?> instance : type.getEnumConstants()) {
				if (value.equals(instance.name())) {
					return (IArmyOptionValue<?>) instance;
				}
			}
		}
		throw new IllegalArgumentException("Unknown value : " + value);
	}

}
