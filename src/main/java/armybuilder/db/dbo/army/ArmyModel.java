package armybuilder.db.dbo.army;

import java.util.List;

import armybuilder.db.dbo.unit.UnitModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ArmyModel {

	private int id;
	private String name;
	private List<UnitModel> units;
}
