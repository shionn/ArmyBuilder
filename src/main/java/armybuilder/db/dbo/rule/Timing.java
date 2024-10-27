package armybuilder.db.dbo.rule;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum Timing {

//	AnyCharge("N’importe Quelle Phase de Charge", "orange"),
	AnyBattle("N’importe Quelle Phase de Mêlée", "red", "battle"),
	AnyBattle_Movement("N’importe Quelle Phase de Mêlée", "red", "movement"),
	AnyBattle_Shield("N’importe Quelle Phase de Mêlée", "red", "shield"),
	AnyEndTurn_Shield("Fin de N’importe Quel Tour", "purple", "shield"),
//	AnyMovement("N’importe Quelle Phase de Mouvement", "gray"),

	Deploy("Phase de Déploiement", "black", "wind-rose"),

	Passif_Shield("Passif", "drak-green", "shield"),
	Passif_WindRose("Passif", "yellow", "wind-rose"),
//	PassifBattle("Passif", "red"),
//	PassifDeploy("Passif", "black"),
	PassifMovement_Shield("N’importe Quelle Phase de Mouvement", "gray", "shield"),
	PassifMovement_Movement("N’importe Quelle Phase de Mouvement", "gray", "movement"),
//	PassifShot("Passif", "blue"),
	PassifWeapon("Passif", "black", "skull"),

//	ReactionBattle("Réaction", "red"),
	ReactionMovement("Réaction", "grey", "movement"),
	ReactionShot("Réaction", "blue", "bow"),
	
	OnceRoundStartRound("Une Fois par Round de Bataille (Armée), Début du Round de Bataille", "black", "wind-rose"),

	OnceTurnAnyBattle("Une Fois Par Tour (Armée), N’importe Quelle Phase de Mêlée", "red", "battle"),
	OnceTurnAnyBattle_Movement("Une Fois Par Tour (Armée), N’importe Quelle Phase de Mêlée", "red", "movement"),
	OnceTurnAnyEndTurn_Battle("Une Fois Par Tour (Armée), Fin de N’importe Quel Tour", "purple", "battle"),

	OnceTurnOpponentHero_Movement("Une Fois Par Tour (Armée), Phase des Héros Adverse", "orange", "movement"),

	OnceTurnYourBattle("Une Fois Par Tour (Armée), Votre Phase de Mêlée", "red", "battle"),
	OnceTurnYourHero("Une Fois Par Tour (Armée), Votre Phase des Héros", "yellow", "wind-rose"),
	OnceTurnYourShot("Une Fois Par Tour (Armée), Votre Phase de Tir", "blue", "bow"),


//	YourCharge("Votre Phase de Charge", "orange"),
	YourHero("Votre Phase des Héros", "yellow", "wind-rose"),
	YourHero_Battle("Votre Phase des Héros", "yellow", "battle"),
	YourHero_Movement("Votre Phase des Héros", "yellow", "movement"),
	YourHero_Shield("Votre Phase des Héros", "yellow", "shield"),
	YourMovement("Votre Phase de Mouvement", "gray", "movement"),
//	YourShot("Votre Phase de Tir", "blue"),
	
	//
	;

	private final String displayName;
	private final String color;
	private final String icon;

}
