package armybuilder.model.unit;

import java.util.List;

import armybuilder.model.unit.weapon.IHaveWeapons;
import armybuilder.model.unit.weapon.IUnitWeapon;

public class Unit implements IHaveWeapons {

	private int id;
	private UnitModel model;


	@Override
	public List<IUnitWeapon> getWeapons() {
		return model.getWeapons();
	}

	public String getDisplayName() {
		return model.getDisplayName();
	}

	public Boolean is(RoleTactique role) {
		return model.is(role);
	}

	public UnitProfile getProfile() {
		return model.getProfile();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public UnitModel getModel() {
		return model;
	}

	public void setModel(UnitModel model) {
		this.model = model;
	}

}
