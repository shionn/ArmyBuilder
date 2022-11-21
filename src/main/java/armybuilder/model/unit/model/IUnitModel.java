package armybuilder.model.unit.model;

import java.util.List;

import armybuilder.model.army.Army;
import armybuilder.model.rule.IRule;
import armybuilder.model.unit.ProfileDegressif;
import armybuilder.model.unit.UnitProfile;
import armybuilder.model.unit.keyword.IHaveKeyWord;
import armybuilder.model.unit.role.IHaveRoleTactique;
import armybuilder.model.unit.weapon.IHaveWeapons;
import armybuilder.model.unit.weapon.IUnitWeapon;
import armybuilder.modelold.deprecated.army.Listing;
import armybuilder.modelold.deprecated.unit.Unit;
import armybuilder.modelold.deprecated.unit.option.IUnitOptionValue;
import armybuilder.modelold.deprecated.unit.option.UnitOptionCategory;

public interface IUnitModel<T extends Enum<T> & IUnitModel<T>> extends IHaveWeapons, IHaveRoleTactique, IHaveKeyWord
{

	public String getDisplayName();

	String name();

	public boolean available(Army army);


	List<IRule<?>> getRules();

	@Deprecated
	int points();

	@Deprecated
	List<UnitOptionCategory> options();

	@Deprecated
	List<IUnitOptionValue<?>> optionValues();

	@Deprecated
	void rebuild(Unit unit);

	@Deprecated
	public boolean availableFor(Listing listing);

	UnitProfile getProfile();

	ProfileDegressif getProfileDegressif();

	@Deprecated
	default boolean is(IUnitWeapon weapon) {
		return false;
//		return weapons().contains(weapon);
	}

	@Deprecated
	default boolean is(IRule<?> rule) {
		return getRules().contains(rule);
	}



}
