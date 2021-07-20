package armybuilder.model.unit;

import java.util.List;

import armybuilder.model.rule.IArmyRule;

public interface IUnit {

	public String getDisplayName();

	UnitProfile getProfile();

	List<IUnitWeapon> getWeapons();

	ProfileDegressif getProfileDegressif();

	List<KeyWord> getKeyWords();

	List<IArmyRule> getRules();

}
