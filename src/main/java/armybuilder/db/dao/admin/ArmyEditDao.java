package armybuilder.db.dao.admin;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import armybuilder.db.dao.admin.frag.ListArmyModelsEditFragDao;
import armybuilder.db.dbo.army.Army;

public interface ArmyEditDao extends ListArmyModelsEditFragDao {

	@Select("SELECT * FROM Army ORDER BY name")
	@Results({ @Result(column = "model", property = "model", one = @One(select = "readArmyModel")) })
	List<Army> listArmies();

	@Insert("INSERT INTO Army (name) VALUES (#{name})")
	@Options(useGeneratedKeys = true, keyColumn = "id", keyProperty = "id")
	int createArmy(Army army);

	@Select("SELECT * FROM Army WHERE id = #{id}")
	@Results({ @Result(column = "model", property = "model", one = @One(select = "readArmyModel")) })
	Army readArmy(int id);

	@Update("UPDATE Army SET name = #{name}, model = #{model.id} WHERE id = #{id}")
	int update(Army army);

}
