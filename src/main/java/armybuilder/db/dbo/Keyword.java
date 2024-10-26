package armybuilder.db.dbo;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Keyword {
	Attaque,
	Base,
	Deploiement,
	DeploiementDeTerrain,
	Tir,

	Heros("Héros"),
	Infanterie,
	Sorcier,

	Chaos,

	Skavens,
	Maitreclan("Maîtreclan"),

	;

	private String displayName;

	private Keyword() {
		this(null);
		displayName = name();
	}

}
