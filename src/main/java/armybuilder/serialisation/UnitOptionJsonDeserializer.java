package armybuilder.serialisation;

import java.util.Arrays;
import java.util.List;

import com.fasterxml.jackson.databind.util.StdConverter;

import armybuilder.model.army.option.bataillon.Bataillon;
import armybuilder.model.dok.DokOptimisations;
import armybuilder.model.nighthaunt.NighthauntOptimisation;
import armybuilder.model.unit.option.IUnitOptionValue;
import armybuilder.model.unit.option.OptimisationsUniverselles;

public class UnitOptionJsonDeserializer extends StdConverter<String, IUnitOptionValue<?>> {

	private static final List<Class<? extends Enum<?>>> ALL = Arrays.asList( //
			DokOptimisations.class, //
			OptimisationsUniverselles.class, //
			NighthauntOptimisation.class, //
			Bataillon.class);

	@Override
	public IUnitOptionValue<?> convert(String value) {
		for (Class<? extends Enum<?>> type : ALL) {
			for (Enum<?> instance : type.getEnumConstants()) {
				if (value.equals(instance.name())) {
					return (IUnitOptionValue<?>) instance;
				}
			}
		}
		throw new IllegalArgumentException("Unknown value : " + value);
	}

}
