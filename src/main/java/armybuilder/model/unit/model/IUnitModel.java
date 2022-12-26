package armybuilder.model.unit.model;

import java.util.List;

import armybuilder.model.IHaveDisplayName;
import armybuilder.model.army.Army;
import armybuilder.model.rule.IRule;
import armybuilder.model.unit.ProfileDegressif;
import armybuilder.model.unit.UnitProfile;
import armybuilder.model.unit.keyword.IHaveKeyWord;
import armybuilder.model.unit.option.UnitOptionCategory;
import armybuilder.model.unit.role.IHaveRoleTactique;
import armybuilder.model.unit.weapon.IHaveWeapons;

public interface IUnitModel<T extends Enum<T> & IUnitModel<T>>
		extends IHaveWeapons, IHaveRoleTactique, IHaveKeyWord, IHaveDisplayName {

	String name();

	public boolean availableFor(Army army);

	List<IRule<?>> getRules();

	int getPoints();

	List<UnitOptionCategory> getOptionsCategories();

	UnitProfile getProfile();

	ProfileDegressif getProfileDegressif();

}
