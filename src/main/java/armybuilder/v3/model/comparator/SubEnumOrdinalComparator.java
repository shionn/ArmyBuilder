package armybuilder.v3.model.comparator;

import java.util.Comparator;
import java.util.function.Function;

public class SubEnumOrdinalComparator<T> implements Comparator<T> {

	private Function<T, Enum<?>> mapper;
	private EnumOrdinalComparator delegate = new EnumOrdinalComparator();

	public SubEnumOrdinalComparator(Function<T, Enum<?>> mapper) {
		this.mapper = mapper;
	}

	@Override
	public int compare(T o1, T o2) {
		return delegate.compare(mapper.apply(o1), mapper.apply(o2));
	}

}
