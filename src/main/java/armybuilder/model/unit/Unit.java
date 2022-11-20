package armybuilder.model.unit;

import java.util.List;

import armybuilder.model.unit.model.UnitModel;
import armybuilder.model.unit.role.IHaveRoleTactique;
import armybuilder.model.unit.role.RoleTactique;
import armybuilder.model.unit.weapon.IHaveWeapons;
import armybuilder.model.unit.weapon.IUnitWeapon;

public class Unit implements IHaveWeapons, IHaveRoleTactique {

	private int id;
	private UnitModel model;

	@Override
	public List<IUnitWeapon> getWeapons() {
		return model.getWeapons();
	}

	@Override
	public List<RoleTactique> getRoleTactiques() {
		return model.getRoleTactiques();
	}

	public String getDisplayName() {
		return model.getDisplayName();
	}

	public UnitProfile getProfile() {
		return model.getProfile();
	}

	public ProfileDegressif getProfileDegressif() {
		return model.getProfileDegressif();
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
