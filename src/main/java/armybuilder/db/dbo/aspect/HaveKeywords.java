package armybuilder.db.dbo.aspect;

import java.util.List;
import java.util.function.BinaryOperator;

import armybuilder.db.dbo.Keyword;

public interface HaveKeywords {
	List<Keyword> getKeywords();

	public default String keywordsAsString() {
		if (getKeywords() == null) {
			return "";
		}
		return getKeywords().stream().map(Keyword::name).reduce(new BinaryOperator<String>() {
			@Override
			public String apply(String t, String u) {
				return t + ',' + u;
			}
		}).orElse("");
	}

	public default boolean is(Keyword keyword) {
		return getKeywords() != null && getKeywords().contains(keyword);
	}

}
