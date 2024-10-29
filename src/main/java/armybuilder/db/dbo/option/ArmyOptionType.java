package armybuilder.db.dbo.option;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ArmyOptionType {
	Formation("Formation"),
	Spell("Somaine de Sort"),
	Prayer("Domaine de Prière"),
	Expression("Domaine de Manifestation");

	private final String name;
}
