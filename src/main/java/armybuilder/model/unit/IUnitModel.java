package armybuilder.model.unit;

import java.util.List;

import armybuilder.model.army.Listing;
import armybuilder.model.army.rule.IRule;
import armybuilder.model.unit.option.IUnitOptionValue;
import armybuilder.model.unit.option.UnitOption;
import armybuilder.model.unit.weapon.IUnitWeapon;

public interface IUnitModel {

	public String displayName();


	List<IUnitWeapon> weapons();

	List<KeyWord> keyWords();

	List<IRule<?>> rules();

	List<RoleTactique> roleTactiques();

	int points();

	List<UnitOption> options();

	List<IUnitOptionValue<?>> optionValues();

	void rebuild(Unit unit);

	String name();

	public boolean availableFor(Listing listing);

	UnitProfile profile();

	ProfileDegressif profileDegressif();

	default boolean is(IUnitWeapon weapon) {
		return weapons().contains(weapon);
	}

	default boolean is(IRule<?> rule) {
		return rules().contains(rule);
	}

	default boolean is(RoleTactique role) {
		return roleTactiques().contains(role);
	}

	default boolean is(KeyWord keyWord) {
		return keyWords().contains(keyWord);
	}

}
