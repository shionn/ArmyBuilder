package armybuilder.db.dao;

import java.util.List;

import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import armybuilder.model.army.Army;
import armybuilder.model.army.bataillon.Bataillon;
import armybuilder.model.unit.Unit;

public interface ArmyDao {

	@Select("SELECT id, name, allegiance FROM Army WHERE active IS TRUE ORDER BY allegiance, name")
	public List<Army> list();

	@Select("SELECT * FROM Army WHERE id = #{id}")
	@Results({ @Result(property = "id", column = "id"),
			@Result(property = "units", column = "id", many = @Many(select = "readUnits")),
			@Result(property = "bataillons", column = "id", many = @Many(select = "readBataillons")) })
	public Army read(int id);

	@Select("SELECT * FROM Unit WHERE army = #{id}")
	public List<Unit> readUnits(int id);

	@Select("SELECT * FROM Bataillon WHERE army = #{id}")
	public List<Bataillon> readBataillons(int id);

}
