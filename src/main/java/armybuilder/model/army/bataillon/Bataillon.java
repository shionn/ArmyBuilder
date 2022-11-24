package armybuilder.model.army.bataillon;

import java.util.List;

import armybuilder.model.IHaveDisplayName;
import armybuilder.model.rule.IRule;

public class Bataillon implements IHaveDisplayName {

	private int id;
	private BataillonType type;

	@Override
	public String getDisplayName() {
		return type.getDisplayName();
	}

	public List<IRule<?>> getRules() {
		return type.getRules();
	}

	public List<BataillonComposition> getCompositions() {
		return type.getCompositions();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public BataillonType getType() {
		return type;
	}

	public void setType(BataillonType type) {
		this.type = type;
	}

}
