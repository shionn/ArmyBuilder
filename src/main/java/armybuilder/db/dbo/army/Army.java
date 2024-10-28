package armybuilder.db.dbo.army;

import java.util.List;

import armybuilder.db.dbo.unit.Unit;
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
	private List<Unit> units;

	public int getCost() {
		return units.stream().map(u -> u.getCost()).reduce(0, (a, b) -> a + b);
	}
}
