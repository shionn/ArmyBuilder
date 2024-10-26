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

	Cavalerie,
	Champion,
	Heros("Héros"),
	Infanterie,
	MachineDeGuerre("Machine de Guerre"),
	Manifestation,
	Musicien_1_10("Musicien(1/10)"),
	Musicien_1_20("Musicien(1/20)"),
	Monstre,
	MorteEtendard_1_10("Porte-Etendard(1/10)"),
	MorteEtendard_1_20("Porte-Etendard(1/20)"),
	Protection_5("Protection(5+)"),
	Protection_6("Protection(6+)"),
	Pretre_1("Prêtre(1)"),
	Pretre_2("Prêtre(2)"),
	Sorcier_1("Sorcier(1)"),
	Sorcier_2("Sorcier(2)"),
	Sorcier_3("Sorcier(3)"),
	Sorcier_4("Sorcier(4)"),
	SortPersistant("Sort Persistant"),
	TerrainDeFaction("Terrain de Faction"),
	Unique,

	// Grande Allegiance
	Chaos,

	// Allegiance
	Skavens,

	// Skaven
	EquipeDArme("Equipe d'Arme"),
	Eshin,
	Maitreclan("Maîtreclan"),
	Moulder,
	Skryre,
	Verminus,

	;

	private String displayName;

	private Keyword() {
		this(null);
		displayName = name();
	}

}
