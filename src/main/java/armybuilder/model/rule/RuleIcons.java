package armybuilder.model.rule;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public enum RuleIcons {

	Heros("ra ra-player", r -> r.isOne(RuleType.PhaseDesHeros)),
	HerosPlyerTurn(
			"ra ra-player underline",
			r -> r.isOne(RuleType.PhaseDesHerosPlayer, RuleType.PhaseDesHerosPlayerDebut)),
	Mouvement("ra ra-footprint", r -> r.isOne(RuleType.PhaseDeMouvement)),
	MouvementPlayer(
			"ra ra-footprint underline",
			r -> r.isOne(RuleType.PhaseDeMouvementPlayer, RuleType.PhaseDeMouvementPlayerDebut,
					RuleType.PhaseDeMouvementPlayerFin)),
	Tir("ra ra-crossbow", r -> r.isOne(RuleType.PhaseDeTir)),
	TirPlayer("ra ra-crossbow underline", r -> r.isOne(RuleType.PhaseDeTirPlayer, RuleType.PhaseDeTirPlayerDebut)),
	Charge("fa fa-forward", r -> r.isOne(RuleType.PhaseDeCharge)),
	Combat("ra ra-crossed-swords",
			r -> r.isOne(RuleType.PhaseDeCombatDebut, RuleType.PhaseDeCombat, RuleType.PhaseDeCombatFin)),
	Deroute("fa fa-flag", r -> r.is(RuleType.PhaseDeDeroute)),

	Sort("ra ra-lightning-storm", r -> r.is(RuleType.Sort)),
	Priere("ra ra-candle", r -> r.is(RuleType.Priere)),
	Aura("ra ra-rss", r -> r.is(RuleType.Aura)),
	;


	private Function<IRule<?>, Boolean> visible;
	private String img;
	private String style;

	private RuleIcons(String style, Function<IRule<?>, Boolean> visible) {
		this.visible = visible;
		this.img = name();
		this.style = style;
	}

	public String getImg() {
		return img;
	}

	public String getStyle() {
		return style;
	}

	public static List<RuleIcons> get(IRule<?> rule) {
		return Arrays.stream(values()).filter(icon -> icon.visible.apply(rule)).collect(Collectors.toList());
	}
}
