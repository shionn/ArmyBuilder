package armybuilder.v3.model.unit.model;

import java.util.List;

import armybuilder.v3.model.IHaveDisplayName;
import armybuilder.v3.model.army.Army;
import armybuilder.v3.model.rule.IRule;
import armybuilder.v3.model.unit.ProfileDegressif;
import armybuilder.v3.model.unit.UnitProfile;
import armybuilder.v3.model.unit.keyword.IHaveKeyWord;
import armybuilder.v3.model.unit.option.UnitOptionCategory;
import armybuilder.v3.model.unit.role.IHaveRoleTactique;
import armybuilder.v3.model.unit.weapon.IHaveWeapons;

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
