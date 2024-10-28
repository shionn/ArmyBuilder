package armybuilder.db.dbo.rule;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum Timing {

//	AnyCharge("N’importe Quelle Phase de Charge", "charge"),
	AnyBattle("N’importe Quelle Phase de Mêlée", "battle", "battle"),
	AnyBattle_Movement("N’importe Quelle Phase de Mêlée", "battle", "movement"),
	AnyBattle_Shield("N’importe Quelle Phase de Mêlée", "battle", "shield"),
	AnyEndTurn_Shield("Fin de N’importe Quel Tour", "end", "shield"),
//	AnyMovement("N’importe Quelle Phase de Mouvement", "movement"),
	AnyHero("N’importe Quelle Phase des Héros", "hero", "wind-rose"),
	AnyHero_Battle("N’importe Quelle Phase des Héros", "hero", "battle"),

	Deploy("Phase de Déploiement", "passif", "wind-rose"),

	Passif_Shield("Passif", "drak-green", "shield"),
	Passif_WindRose("Passif", "hero", "wind-rose"),
	PassifBattle("Passif", "battle", "shield"),
	PassifMovement("Passif", "passif", "movement"),
	PassifWeapon("Passif", "passif", "skull"),

//	ReactionBattle("Réaction", "battle"),
	ReactionMovement("Réaction", "grey", "movement"),
	ReactionShot("Réaction", "shot", "bow"),
	
	OnceRoundStartRound("Une Fois par Round de Bataille (Armée), Début du Round de Bataille", "passif", "wind-rose"),

	OnceTurnAnyBattle("Une Fois Par Tour (Armée), N’importe Quelle Phase de Mêlée", "battle", "battle"),
	OnceTurnAnyBattle_Movement("Une Fois Par Tour (Armée), N’importe Quelle Phase de Mêlée", "battle", "movement"),
	OnceTurnAnyEndTurn_Battle("Une Fois Par Tour (Armée), Fin de N’importe Quel Tour", "end", "battle"),

	OnceTurnOpponentHero_Movement("Une Fois Par Tour (Armée), Phase des Héros Adverse", "charge", "movement"),

	OnceTurnYourBattle("Une Fois Par Tour (Armée), Votre Phase de Mêlée", "battle", "battle"),
	OnceTurnYourHero("Une Fois Par Tour (Armée), Votre Phase des Héros", "hero", "wind-rose"),
	OnceTurnYourShot("Une Fois Par Tour (Armée), Votre Phase de Tir", "shot", "bow"),
	OnceTurnYourEndTurn("Une Fois Par Tour (Armée), Fin de Votre Tour", "end", "flag"),


	YourCharge("Votre Phase de Charge", "charge", "movement"),
	YourHero("Votre Phase des Héros", "hero", "wind-rose"),
	YourHero_Battle("Votre Phase des Héros", "hero", "battle"),
	YourHero_Movement("Votre Phase des Héros", "hero", "movement"),
	YourHero_Shield("Votre Phase des Héros", "hero", "shield"),
	YourMovement("Votre Phase de Mouvement", "movement", "movement"),
//	YourShot("Votre Phase de Tir", "shot"),
	
	//
	;

	private final String displayName;
	private final String color;
	private final String icon;

}
