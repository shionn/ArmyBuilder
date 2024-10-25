package armybuilder.db.dbo.rule;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum Timing {
	Deploy("Phase de Déploiement"),
	YourShot("Votre Phase de Tir");

	private final String displayName;

}
