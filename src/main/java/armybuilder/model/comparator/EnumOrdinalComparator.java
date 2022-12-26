package armybuilder.model.comparator;

import java.util.Comparator;

public class EnumOrdinalComparator implements Comparator<Enum<?>> {

	@Override
	public int compare(Enum<?> o1, Enum<?> o2) {
		return Integer.compare(o1.ordinal(), o2.ordinal());
	}

}
