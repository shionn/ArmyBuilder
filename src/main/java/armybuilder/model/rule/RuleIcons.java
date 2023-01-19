package armybuilder.model.rule;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public enum RuleIcons {

	Heros(r -> r.isOne(RuleType.PhaseDesHeros)),
	Mouvement(r -> r.isOne(RuleType.PhaseDeMouvement)),
	Tir(r -> r.isOne(RuleType.PhaseDeTir)),
	Charge(r -> r.isOne(RuleType.PhaseDeCharge)),
	Combat(r -> r.isOne(RuleType.PhaseDeCombatDebut, RuleType.PhaseDeCombat, RuleType.PhaseDeCombatFin)),
	Deroute(r -> r.is(RuleType.PhaseDeDeroute)),

	Sort(r -> r.is(RuleType.Sort)),
	Aura(r -> r.is(RuleType.Aura)),
	;


	private Function<IRule<?>, Boolean> visible;
	private String img;
	private String style;

	private RuleIcons(Function<IRule<?>, Boolean> visible) {
		this.visible = visible;
		this.img = name();
		this.style = "filter: brightness(0%)";
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
