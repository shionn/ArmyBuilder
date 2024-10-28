package armybuilder.db.dao.army;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import armybuilder.db.dbo.army.Army;
import armybuilder.db.dbo.army.ArmyModel;
import armybuilder.db.dbo.unit.UnitModel;

public interface ArmyDao {

	@Select("SELECT * FROM Army WHERE id = #{id}")
	@Results({ @Result(column = "model", property = "model", one = @One(select = "readModel")) })
	Army read(int id);

	@Select("SELECT * FROM ArmyModel WHERE id = #{id}")
	@Results({ 
		@Result(column = "id", property = "id"),
		@Result(column = "id", property = "units", many = @Many(select = "readUnitModels")) 
	})
	ArmyModel readModel(int id);

	@Select("SELECT * FROM UnitModel WHERE army_model = #{model} ORDER BY name")
	List<UnitModel> readUnitModels(int model);

	@Insert("INSERT INTO Unit ( army, model ) VALUES ( #{army}, #{model} )")
	void addUnit(@Param("army") int army, @Param("model") int model);
}
