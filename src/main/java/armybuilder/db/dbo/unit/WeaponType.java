package armybuilder.db.dbo.unit;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum WeaponType {
	Melee("Armes de Melée"),
	Distant("Armes de Tir");

	private String displayName;
}
