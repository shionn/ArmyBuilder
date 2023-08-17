package armybuilder.model.army.turn;

import java.util.List;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TurnStep {
	private String name;
	private List<TurnStep> subs;

}
