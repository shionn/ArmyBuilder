package armybuilder.serialisation;

import java.util.Arrays;

import com.fasterxml.jackson.databind.util.StdConverter;

import armybuilder.db.dbo.SubAllegiance;
import armybuilder.model.army.option.GrandeStrategie;
import armybuilder.model.army.option.IListingOptionValue;
import armybuilder.model.army.option.PackDeBataille;
import armybuilder.model.army.option.Triomphes;

public class ListingOptionValueJsonDeserializer extends StdConverter<String, IListingOptionValue<?>> {

	@Override
	public IListingOptionValue<?> convert(String value) {
		for (Class<? extends Enum<?>> type : Arrays.asList(GrandeStrategie.class, PackDeBataille.class,
				SubAllegiance.class, Triomphes.class)) {
			for (Enum<?> instance : type.getEnumConstants()) {
				if (value.equals(instance.name())) {
					return (IListingOptionValue<?>) instance;
				}
			}
		}
		throw new IllegalArgumentException("Unknown value : " + value);
	}

}
