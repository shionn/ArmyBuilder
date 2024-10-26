package armybuilder.db.dbo.unit;

import java.util.List;
import java.util.function.BinaryOperator;

import armybuilder.db.dbo.Keyword;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UnitModel implements BinaryOperator<String> {
	private int id;
	private String name;
	private String mvt, life, control, save;
	private List<UnitModelWeapon> weapons;
	private List<Keyword> keywords;

	public String getKeywordsAsString() {
		return keywords.stream().map(Keyword::name).reduce(this).orElse("");
	}

	@Override
	public String apply(String t, String u) {
		return t + ',' + u;
	}

}
