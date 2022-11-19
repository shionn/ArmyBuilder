package armybuilder.db.dao;

import java.util.List;

import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import armybuilder.model.army.Army;
import armybuilder.model.unit.Unit;

public interface ArmyDao {

	@Select("SELECT id, name, allegiance FROM Army WHERE active IS TRUE ORDER BY allegiance, name")
	public List<Army> list();
	
	@Select("SELECT id, name, allegiance, subAllegiance " //
			+ "FROM Army " //
			+ "WHERE id = #{id}")
	@Results({ @Result(property = "id", column = "id"),
			@Result(property = "units", column = "id", many = @Many(select = "readUnits")) })
	public Army read(int id);

	@Select("SELECT id, model FROM Unit WHERE army = #{id}")
	public List<Unit> readUnits(int id);

}
