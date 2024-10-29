package armybuilder.db.dao.admin.frag;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import armybuilder.db.dbo.army.ArmyModel;

public interface ListArmiesEditFragDao {

	@Select("SELECT * FROM ArmyModel ORDER BY name")
	List<ArmyModel> listArmies();

	@Select("SELECT * FROM ArmyModel WHERE id = #{id}")
	ArmyModel readArmy(int id);

}
