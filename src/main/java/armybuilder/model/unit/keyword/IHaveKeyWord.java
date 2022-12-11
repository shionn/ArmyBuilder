package armybuilder.model.unit.keyword;

import java.util.Arrays;
import java.util.List;

public interface IHaveKeyWord {
	List<KeyWord> getKeyWords();

	default boolean is(KeyWord... keyWords) {
		return getKeyWords().containsAll(Arrays.asList(keyWords));
	}

	default boolean isOne(KeyWord... keyWords) {
		return Arrays.asList(keyWords).stream().filter(this::is).findAny().isPresent();
	}

}
