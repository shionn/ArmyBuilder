package armybuilder.model.unit;

import java.util.List;

import armybuilder.model.army.Army;
import armybuilder.model.rule.IRule;
import armybuilder.model.unit.weapon.IHaveWeapons;
import armybuilder.model.unit.weapon.IUnitWeapon;
import armybuilder.modelold.deprecated.army.Listing;
import armybuilder.modelold.deprecated.unit.KeyWord;
import armybuilder.modelold.deprecated.unit.ProfileDegressif;
import armybuilder.modelold.deprecated.unit.Unit;
import armybuilder.modelold.deprecated.unit.option.IUnitOptionValue;
import armybuilder.modelold.deprecated.unit.option.UnitOption;

public interface IUnitModel<T extends Enum<T> & IUnitModel<T>> extends IHaveWeapons
{

	public String getDisplayName();

	String name();

	public boolean available(Army army);

	@Deprecated
	List<KeyWord> keyWords();

	@Deprecated
	List<IRule<?>> rules();

	List<RoleTactique> getRoleTactiques();

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
	ProfileDegressif profileDegressif();

	@Deprecated
	default boolean is(IUnitWeapon weapon) {
		return false;
//		return weapons().contains(weapon);
	}

	@Deprecated
	default boolean is(IRule<?> rule) {
		return rules().contains(rule);
	}

	default boolean is(RoleTactique role) {
		return getRoleTactiques().contains(role);
	}

	@Deprecated
	default boolean is(KeyWord keyWord) {
		return keyWords().contains(keyWord);
	}

}
