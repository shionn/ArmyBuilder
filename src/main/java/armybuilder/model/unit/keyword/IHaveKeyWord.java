package armybuilder.model.unit.keyword;

import java.util.Arrays;
import java.util.List;

public interface IHaveKeyWord {
	List<KeyWord> getKeyWords();

	default boolean is(KeyWord keyWord) {
		return getKeyWords().contains(keyWord);
	}

	default boolean isOne(KeyWord... keyWords) {
		return Arrays.asList(keyWords).stream().filter(this::is).findAny().isPresent();
	}

}
