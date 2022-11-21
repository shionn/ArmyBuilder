package armybuilder.model.unit.keyword;

import java.util.List;

public interface IHaveKeyWord {
	List<KeyWord> getKeyWords();

	default boolean is(KeyWord keyWord) {
		return getKeyWords().contains(keyWord);
	}

}
