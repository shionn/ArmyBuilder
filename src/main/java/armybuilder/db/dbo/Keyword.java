package armybuilder.db.dbo;

import java.util.Arrays;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Keyword {

	Attaque,
	Base,
	Bannissement,
	Cavalerie,
	Champion,
	Charge,
	Convocation,
	CorpACorp("Corp à Corp"),
	Course,
	Deploiement,
	DeploiementDeTerrain,
	Dissipation,
	Heros("Héros"),
	Illimite("Illimité"),
	Infanterie,
	MachineDeGuerre("Machine de Guerre"),
	Manifestation,
	Musicien_1_10("Musicien(1/10)"),
	Musicien_1_20("Musicien(1/20)"),
	Monstre,
	Mouvement,
	MorteEtendard_1_10("Porte-Etendard(1/10)"),
	MorteEtendard_1_20("Porte-Etendard(1/20)"),
	Protection_5("Protection(5+)"),
	Protection_6("Protection(6+)"),
	Pretre_1("Prêtre(1)"),
	Pretre_2("Prêtre(2)"),
	Repli,
	Saccage,
	Sorcier_1("Sorcier(1)"),
	Sorcier_2("Sorcier(2)"),
	Sorcier_3("Sorcier(3)"),
	Sorcier_4("Sorcier(4)"),
	Sort,
	SortPersistant("Sort Persistant"),
	TerrainDeFaction("Terrain de Faction"),
	Tir,
	Unique,
	Vol,

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

	public static List<Keyword> sorted() {
		return Arrays.stream(values()).sorted((a, b) -> a.getDisplayName().compareTo(b.getDisplayName())).toList();
	}
}
