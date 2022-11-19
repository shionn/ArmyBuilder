package armybuilder.db.dbo;

public class Army {
	private int id;
	private String name;
	private Allegiance allegiance;
	private SubAllegiance subAllegiance;

	public Allegiance getAllegiance() {
		return allegiance;
	}

	public void setAllegiance(Allegiance allegiance) {
		this.allegiance = allegiance;
	}

	public SubAllegiance getSubAllegiance() {
		return subAllegiance;
	}

	public void setSubAllegiance(SubAllegiance subAllegiance) {
		this.subAllegiance = subAllegiance;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
