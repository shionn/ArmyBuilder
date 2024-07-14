package armybuilder.v3.model.unit.role;

import java.util.Arrays;
import java.util.List;

public interface IHaveRoleTactique {

	List<RoleTactique> getRoleTactiques();

	default boolean is(RoleTactique role) {
		return getRoleTactiques().contains(role);
	}

	default boolean isOne(RoleTactique... roles) {
		return Arrays.stream(roles).filter(this::is).findFirst().isPresent();
	}

}
