package armybuilder.db.dbo.army;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Army {

	private int id;
	private String name;
	private ArmyModel model;
}
