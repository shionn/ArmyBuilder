package armybuilder.db.dao.admin;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import armybuilder.db.dao.admin.frag.ListArmiesEditFragDao;
import armybuilder.db.dbo.option.ArmyOptionModel;

public interface ArmyEditDao extends ListArmiesEditFragDao {

	@Insert("INSERT INTO ArmyOptionModel ( name ) VALUE ( #{name} )")
	@Options(useGeneratedKeys = true, keyColumn = "id", keyProperty = "id")
	int createOption(ArmyOptionModel option);

	@Select("SELECT * FROM ArmyOptionModel WHERE id = #{id}")
	@Results({ //
			@Result(column = "army", property = "army.id") //
	})
	ArmyOptionModel readOption(int id);

	@Update("UPDATE ArmyOptionModel " //
			+ "SET army = #{army.id}, type = #{type}, name = #{name}, script = #{script} " //
			+ "WHERE id = #{id}")
	int updateOption(ArmyOptionModel option);

	@Select("SELECT m.id, m.name, a.name AS army_name " //
			+ "FROM ArmyOptionModel m " //
			+ "LEFT JOIN ArmyModel a ON a.id = m.army " //
			+ "ORDER BY army_name, name")
	@Results({ //
			@Result(column = "army_name", property = "army.name") //
	})
	List<ArmyOptionModel> listOption();

}
