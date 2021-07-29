package armybuilder.model.serialisation;

import java.util.Arrays;

import com.fasterxml.jackson.databind.util.StdConverter;

import armybuilder.model.dok.DokOptimisations;
import armybuilder.model.unit.option.IUnitOptionValue;
import armybuilder.model.unit.option.OptimisationsUniverselles;

public class UnitOptionJsonDeserializer extends StdConverter<String, IUnitOptionValue<?>> {

	@Override
	public IUnitOptionValue<?> convert(String value) {
		for (Class<? extends Enum<?>> type : Arrays.asList(DokOptimisations.class,
				OptimisationsUniverselles.class)) {
			for (Enum<?> instance : type.getEnumConstants()) {
				if (value.equals(instance.name())) {
					return (IUnitOptionValue<?>) instance;
				}
			}
		}
		throw new IllegalArgumentException("Unknown value : " + value);
	}

}
