package armybuilder.serialisation;

import com.fasterxml.jackson.databind.util.StdConverter;

import armybuilder.model.army.option.IListingOptionValue;

public class ArmyOptionJsonDeserializer extends StdConverter<String, IListingOptionValue<?>> {

	@Override
	public IListingOptionValue<?> convert(String value) {
//		for (Class<? extends Enum<?>> type : Arrays.asList(Allegiance.class, GrandeStrategie.class,
//				PackDeBataille.class, SubAllegiance.class, Triomphes.class, Bataillon.class,
//				DisplayUnit.class)) {
//			for (Enum<?> instance : type.getEnumConstants()) {
//				if (value.equals(instance.name())) {
//					return (IListingOptionValue<?>) instance;
//				}
//			}
//		}
		throw new IllegalArgumentException("Unknown value : " + value);
	}

}
