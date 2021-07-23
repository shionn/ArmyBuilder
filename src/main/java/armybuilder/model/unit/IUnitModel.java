package armybuilder.model.unit;

import java.util.List;

import armybuilder.model.rule.IArmyRule;

public interface IUnitModel {

	public String getDisplayName();

	UnitProfile getProfile();

	List<IUnitWeapon> getWeapons();

	ProfileDegressif getProfileDegressif();

	List<KeyWord> getKeyWords();

	List<IArmyRule<?>> getRules();

	List<RoleTatcique> getRoleTactiques();

	int getValue();

}
