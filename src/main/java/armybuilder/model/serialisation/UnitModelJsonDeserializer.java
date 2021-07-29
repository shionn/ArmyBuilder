package armybuilder.model.serialisation;

import java.util.Arrays;

import com.fasterxml.jackson.databind.util.StdConverter;

import armybuilder.model.dok.DokUnitModel;
import armybuilder.model.unit.IUnitModel;

public class UnitModelJsonDeserializer extends StdConverter<String, IUnitModel> {

	@Override
	public IUnitModel convert(String value) {
		for (Class<? extends Enum<?>> type : Arrays.asList(DokUnitModel.class)) {
			for (Enum<?> instance : type.getEnumConstants()) {
				if (value.equals(instance.name())) {
					return (IUnitModel) instance;
				}
			}
		}
		throw new IllegalArgumentException("Unknown value : " + value);
	}

}
