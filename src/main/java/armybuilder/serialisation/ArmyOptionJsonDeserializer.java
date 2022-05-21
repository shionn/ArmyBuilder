package armybuilder.serialisation;

import java.util.Arrays;

import com.fasterxml.jackson.databind.util.StdConverter;

import armybuilder.model.army.option.Allegiance;
import armybuilder.model.army.option.DisplayUnit;
import armybuilder.model.army.option.GrandeStrategie;
import armybuilder.model.army.option.IListingOptionValue;
import armybuilder.model.army.option.PackDeBataille;
import armybuilder.model.army.option.SubAllegiance;
import armybuilder.model.army.option.Triomphes;
import armybuilder.model.army.option.bataillon.Bataillon;

public class ArmyOptionJsonDeserializer extends StdConverter<String, IListingOptionValue<?>> {

	@Override
	public IListingOptionValue<?> convert(String value) {
		for (Class<? extends Enum<?>> type : Arrays.asList(Allegiance.class, GrandeStrategie.class,
				PackDeBataille.class, SubAllegiance.class, Triomphes.class, Bataillon.class,
				DisplayUnit.class)) {
			for (Enum<?> instance : type.getEnumConstants()) {
				if (value.equals(instance.name())) {
					return (IListingOptionValue<?>) instance;
				}
			}
		}
		throw new IllegalArgumentException("Unknown value : " + value);
	}

}
