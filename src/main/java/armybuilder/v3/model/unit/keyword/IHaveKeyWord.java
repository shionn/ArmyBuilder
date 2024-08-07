package armybuilder.v3.model.unit.keyword;

import java.util.Arrays;
import java.util.List;

import armybuilder.v3.model.army.SubAllegiance;

public interface IHaveKeyWord {
	List<KeyWord> getKeyWords();

	default boolean is(KeyWord... keyWords) {
		return getKeyWords().containsAll(Arrays.asList(keyWords));
	}

	default boolean isOne(KeyWord... keyWords) {
		return Arrays.asList(keyWords).stream().filter(this::is).findAny().isPresent();
	}

	default boolean isOneOf(KeyWord... keyWords) {
		return Arrays.stream(keyWords).filter(k -> getKeyWords().contains(k)).count() > 0;
	}

	default boolean isSubAllegied() {
		return isOneOf(
				Arrays.stream(SubAllegiance.values())
						.filter(sub -> sub != SubAllegiance.None)
						.map(s -> KeyWord.valueOf(s.name()))
						.toArray(s -> new KeyWord[s]));
	}

}
