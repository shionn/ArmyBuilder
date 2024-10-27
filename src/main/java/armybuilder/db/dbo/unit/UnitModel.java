package armybuilder.db.dbo.unit;

import java.util.List;

import armybuilder.db.dao.admin.UnitModelRule;
import armybuilder.db.dbo.Keyword;
import armybuilder.db.dbo.army.ArmyModel;
import armybuilder.db.dbo.aspect.HaveKeywords;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UnitModel implements HaveKeywords {
	private int id;
	private String name;
	private String mvt, life, control, save;
	private ArmyModel army;
	private List<UnitModelWeapon> weapons;
	private List<Keyword> keywords;
	private List<UnitModelRule> rules;

}
