package armybuilder.db.dbo.option;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ArmyOptionType {
	BattleAspect("Traits de Bataille", false),
	Formation("Formation", true),
	Spell("Domaine de Sort", true),
	Prayer("Domaine de Prière", true),
	Expression("Domaine de Manifestation", true);

	private final String name;
	private final boolean editable;

	public static ArmyOptionType from(String value) {
		try {
			return valueOf(value);
		} catch (IllegalArgumentException e) {
			return null;
		}
	}

}
