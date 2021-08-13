package armybuilder.model.unit;

import java.util.List;

import armybuilder.model.Army;
import armybuilder.model.rule.IArmyRule;
import armybuilder.model.unit.option.IUnitOptionValue;
import armybuilder.model.unit.option.UnitOption;
import armybuilder.model.unit.weapon.IUnitWeapon;

public interface IUnitModel {

	public String getDisplayName();

	UnitProfile getProfile();

	List<IUnitWeapon> getWeapons();

	ProfileDegressif getProfileDegressif();

	List<KeyWord> getKeyWords();

	List<IArmyRule<?>> getRules();

	List<RoleTactique> getRoleTactiques();

	int getValue();

	List<UnitOption> getOptions();

	List<IUnitOptionValue<?>> getOptionValues();

	void rebuild(Army army, Unit unit);

	default boolean isOneOf(RoleTactique... roles) {
		for (RoleTactique role : roles) {
			if (getRoleTactiques().contains(role)) {
				return true;
			}
		}
		return false;
	}

	default boolean is(RoleTactique role) {
		return getRoleTactiques().contains(role);
	}

	void check(Army army, Unit unit);

	String name();


}
