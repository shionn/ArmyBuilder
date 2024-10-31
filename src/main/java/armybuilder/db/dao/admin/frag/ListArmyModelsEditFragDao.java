package armybuilder.db.dao.admin.frag;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import armybuilder.db.dbo.army.ArmyModel;

public interface ListArmyModelsEditFragDao {

	@Select("SELECT * FROM ArmyModel ORDER BY name")
	List<ArmyModel> listArmyModels();

	@Select("SELECT * FROM ArmyModel WHERE id = #{id}")
	ArmyModel readArmyModel(int id);

}
