package armybuilder.db.dao.menu;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import armybuilder.db.dbo.army.Army;
import armybuilder.db.dbo.army.ArmyModel;

public interface MenuDao {

	@Select("SELECT id, name FROM ArmyModel WHERE game = 'AOSv4' AND visible = true ORDER BY name")
	List<ArmyModel> listRoot();

	@Select("SELECT id, name FROM Army WHERE model = #{model} ORDER BY name")
	List<Army> listArmy(int model);
}
