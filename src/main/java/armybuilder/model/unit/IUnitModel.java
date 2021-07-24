package armybuilder.model.unit;

import java.util.List;

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

	List<RoleTatcique> getRoleTactiques();

	int getValue();

	List<UnitOption> getOptions();

	List<IUnitOptionValue<?>> getOptionValues();

}
