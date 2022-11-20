package armybuilder.model.unit.role;

import java.util.List;

public interface IHaveRoleTactique {

	List<RoleTactique> getRoleTactiques();

	default boolean is(RoleTactique role) {
		return getRoleTactiques().contains(role);
	}

}
