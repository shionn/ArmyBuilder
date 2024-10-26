package armybuilder.db.dbo.unit;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UnitModelWeapon {

	private int id;
	private int unitId;
	private String name;
	private WeaponType type;
	private String atk, hit, str, perf, deg;

}
