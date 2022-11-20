package armybuilder.model.unit.model;

import java.util.List;

import armybuilder.model.army.Army;
import armybuilder.model.rule.IRule;
import armybuilder.model.unit.ProfileDegressif;
import armybuilder.model.unit.UnitProfile;
import armybuilder.model.unit.role.IHaveRoleTactique;
import armybuilder.model.unit.weapon.IHaveWeapons;
import armybuilder.model.unit.weapon.IUnitWeapon;
import armybuilder.modelold.deprecated.army.Listing;
import armybuilder.modelold.deprecated.unit.KeyWord;
import armybuilder.modelold.deprecated.unit.Unit;
import armybuilder.modelold.deprecated.unit.option.IUnitOptionValue;
import armybuilder.modelold.deprecated.unit.option.UnitOption;

public interface IUnitModel<T extends Enum<T> & IUnitModel<T>> extends IHaveWeapons, IHaveRoleTactique
{

	public String getDisplayName();

	String name();

	public boolean available(Army army);

	@Deprecated
	List<KeyWord> keyWords();

	@Deprecated
	List<IRule<?>> rules();

	@Deprecated
	int points();

	@Deprecated
	List<UnitOption> options();

	@Deprecated
	List<IUnitOptionValue<?>> optionValues();

	@Deprecated
	void rebuild(Unit unit);


	@Deprecated
	public boolean availableFor(Listing listing);

	UnitProfile getProfile();

	@Deprecated
	ProfileDegressif getProfileDegressif();

	@Deprecated
	default boolean is(IUnitWeapon weapon) {
		return false;
//		return weapons().contains(weapon);
	}

	@Deprecated
	default boolean is(IRule<?> rule) {
		return rules().contains(rule);
	}


	@Deprecated
	default boolean is(KeyWord keyWord) {
		return keyWords().contains(keyWord);
	}

}
