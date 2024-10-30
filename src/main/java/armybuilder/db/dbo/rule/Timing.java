package armybuilder.db.dbo.rule;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Timing {

//	AnyCharge("N’importe Quelle Phase de Charge", "charge"),
	AnyBattle("N’importe Quelle Phase de Mêlée", TimingStep.Battle),
	AnyBattle_Movement("N’importe Quelle Phase de Mêlée", TimingStep.Battle, "movement"),
	AnyBattle_Shield("N’importe Quelle Phase de Mêlée", TimingStep.Battle, "shield"),
	AnyEndTurn_Shield("Fin de N’importe Quel Tour", TimingStep.End, "shield"),
//	AnyMovement("N’importe Quelle Phase de Mouvement", "movement"),
	AnyHero("N’importe Quelle Phase des Héros", TimingStep.Hero),
	AnyHero_Battle("N’importe Quelle Phase des Héros", TimingStep.Hero, "battle"),

	Deploy("Phase de Déploiement", TimingStep.Deploy),

	PassifGreen_Shield("Passif", TimingStep.PassifGreen, "shield"),
	PassifHero("Passif", TimingStep.Hero, "wind-rose"),
	PassifBattle_Shield("Passif", TimingStep.Battle, "shield"),
	PassifMovement("Passif", TimingStep.Movement),
	PassifMovement_Shield("Passif", TimingStep.Movement, "shield"),
	PassifShot("Passif", TimingStep.Passif, "shot"),
	PassifWeapon("Passif", TimingStep.Passif, "skull"),

//	ReactionBattle("Réaction", "battle"),
	ReactionMovement("Réaction", TimingStep.Movement),
	ReactionShot("Réaction", TimingStep.Shot),

	OnceBattleAnyBattle("Une Fois Par Bataille, N’importe Quelle Phase de Mêlée", TimingStep.Battle),

	OnceRoundStartRound("Une Fois par Round de Bataille (Armée), Début du Round de Bataille", TimingStep.StartRound),

	OnceTurnAnyBattle("Une Fois Par Tour (Armée), N’importe Quelle Phase de Mêlée", TimingStep.Battle),
	OnceTurnAnyBattle_Movement("Une Fois Par Tour (Armée), N’importe Quelle Phase de Mêlée", TimingStep.Battle,
			"movement"),
	OnceTurnAnyEndTurn_Battle("Une Fois Par Tour (Armée), Fin de N’importe Quel Tour", TimingStep.End, "battle"),

	OnceTurnOpponentHero_Movement("Une Fois Par Tour (Armée), Phase des Héros Adverse", TimingStep.Hero, "movement"),

	OnceTurnYourBattle("Une Fois Par Tour (Armée), Votre Phase de Mêlée", TimingStep.Battle),
	OnceTurnYourHero("Une Fois Par Tour (Armée), Votre Phase des Héros", TimingStep.Hero),
	OnceTurnYourShot("Une Fois Par Tour (Armée), Votre Phase de Tir", TimingStep.Shot),
	OnceTurnYourEndTurn("Une Fois Par Tour (Armée), Fin de Votre Tour", TimingStep.End),

	YourCharge("Votre Phase de Charge", TimingStep.Charge),
	YourHero("Votre Phase des Héros", TimingStep.Hero),
	YourHero_Battle("Votre Phase des Héros", TimingStep.Hero, "battle"),
	YourHero_Movement("Votre Phase des Héros", TimingStep.Hero, "movement"),
	YourHero_Shield("Votre Phase des Héros", TimingStep.Hero, "shield"),
	YourMovement("Votre Phase de Mouvement", TimingStep.Movement),
//	YourShot("Votre Phase de Tir", "shot"),

	//
	;

	private final String displayName;
	private final TimingStep step;
//	private final String color;
	private final String icon;

	Timing(String name, TimingStep step) {
		this(name, step, step.getIcon());
	}

	public static Timing from(String value) {
		try {
			return valueOf(value);
		} catch (IllegalArgumentException e) {
			return null;
		}
	}

	public String getColor() {
		return this.step.getColor();
	}

}
