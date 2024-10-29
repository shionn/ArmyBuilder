package armybuilder.db.dbo.rule;

import java.util.List;

import armybuilder.db.dbo.Keyword;
import armybuilder.db.dbo.army.ArmyModel;
import armybuilder.db.dbo.aspect.HaveKeywords;
import armybuilder.db.dbo.option.ArmyOptionType;
import armybuilder.db.dbo.option.UnitOptionType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Rule implements HaveKeywords {
	private int id;
	private Timing timing;
	private String cost;
	private String condition;
	private String name;
	private String description;
	private String announce;
	private String effect;
	private String script;
	private ArmyModel optionArmy;
	private UnitOptionType optionUnitType;
	private ArmyOptionType optionArmyType;
	private List<Keyword> keywords;

	public boolean is(UnitOptionType option) {
		return option == this.optionUnitType;
	}

	public boolean is(ArmyOptionType type) {
		return optionArmyType == type;
	}

}
