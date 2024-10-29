package armybuilder.db.dbo.option;

import armybuilder.db.dbo.army.ArmyModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ArmyOptionModel {

	private int id;
	private ArmyModel army;
	private ArmyOptionType type;
	private String name;
	private String script;
}
