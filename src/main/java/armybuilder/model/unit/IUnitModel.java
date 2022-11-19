package armybuilder.model.unit;

import java.util.List;

import armybuilder.model.army.Listing;
import armybuilder.model.army.rule.IRule;
import armybuilder.model.unit.option.IUnitOptionValue;
import armybuilder.model.unit.option.UnitOption;
import armybuilder.model.unit.weapon.IUnitWeapon;

public interface IUnitModel {

	public String displayName();

	@Deprecated
	List<IUnitWeapon> weapons();

	@Deprecated
	List<KeyWord> keyWords();

	@Deprecated
	List<IRule<?>> rules();

	@Deprecated
	List<RoleTactique> roleTactiques();

	@Deprecated
	int points();

	@Deprecated
	List<UnitOption> options();

	@Deprecated
	List<IUnitOptionValue<?>> optionValues();

	@Deprecated
	void rebuild(Unit unit);

	@Deprecated
	String name();

	@Deprecated
	public boolean availableFor(Listing listing);

	@Deprecated
	UnitProfile profile();

	@Deprecated
	ProfileDegressif profileDegressif();

	@Deprecated
	default boolean is(IUnitWeapon weapon) {
		return weapons().contains(weapon);
	}

	@Deprecated
	default boolean is(IRule<?> rule) {
		return rules().contains(rule);
	}

	@Deprecated
	default boolean is(RoleTactique role) {
		return roleTactiques().contains(role);
	}

	@Deprecated
	default boolean is(KeyWord keyWord) {
		return keyWords().contains(keyWord);
	}

}
