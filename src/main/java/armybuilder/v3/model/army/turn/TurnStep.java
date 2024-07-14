package armybuilder.v3.model.army.turn;

import java.util.List;

import armybuilder.v3.model.rule.IRule;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TurnStep {
	private String name;
	private List<TurnStep> subs;
	private IRule<?> rule;

	public boolean isHaveRule() {
		return rule != null;
	}

}
