package armybuilder.model.unit;

import java.util.List;

import armybuilder.model.army.Listing;
import armybuilder.model.army.rule.IArmyRule;
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

	int getPoints();

	List<UnitOption> getOptions();

	List<IUnitOptionValue<?>> getOptionValues();

	void rebuild(Unit unit);

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

	String name();

	public boolean availableFor(Listing armyListing);

}
