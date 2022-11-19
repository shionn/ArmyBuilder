package armybuilder.controller;

import java.io.Serializable;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@Component
@SessionScope
public class CurrentArmyId implements Serializable {
	private static final long serialVersionUID = -3699530406667577954L;

	private int id = -1;

	public int id() {
		return id;
	}

	public void id(int id) {
		this.id = id;
	}

}
