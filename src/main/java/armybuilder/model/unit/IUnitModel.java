package armybuilder.model.unit;

import java.util.List;

import armybuilder.model.army.Listing;
import armybuilder.model.army.rule.IArmyRule;
import armybuilder.model.unit.option.IUnitOptionValue;
import armybuilder.model.unit.option.UnitOption;
import armybuilder.model.unit.weapon.IUnitWeapon;

public interface IUnitModel {

	public String displayName();


	List<IUnitWeapon> weapons();

	default boolean is(IUnitWeapon weapon) {
		return weapons().contains(weapon);
	}

	List<KeyWord> keyWords();

	List<IArmyRule<?>> rules();

	default boolean is(IArmyRule<?> rule) {
		return rules().contains(rule);
	}

	List<RoleTactique> roleTactiques();

	default boolean is(RoleTactique role) {
		return roleTactiques().contains(role);
	}

	int points();

	List<UnitOption> options();

	List<IUnitOptionValue<?>> optionValues();

	void rebuild(Unit unit);

	@Deprecated
	default boolean isOneOf(RoleTactique... roles) {
		for (RoleTactique role : roles) {
			if (roleTactiques().contains(role)) {
				return true;
			}
		}
		return false;
	}


	String name();

	public boolean availableFor(Listing listing);

	UnitProfile profile();

	ProfileDegressif profileDegressif();

}
