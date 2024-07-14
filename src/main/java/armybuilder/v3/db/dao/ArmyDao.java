package armybuilder.v3.db.dao;

import java.util.List;

import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import armybuilder.v3.model.army.Army;
import armybuilder.v3.model.army.bataillon.Bataillon;
import armybuilder.v3.model.unit.Unit;

public interface ArmyDao {

	@Select("SELECT id, name, allegiance FROM Army WHERE active IS TRUE ORDER BY allegiance, name")
	public List<Army> list();

	@Select("SELECT * FROM Army WHERE id = #{id}")
	@Results({ @Result(property = "id", column = "id"),
			@Result(property = "units", column = "id", many = @Many(select = "readUnits")),
			@Result(property = "bataillons", column = "id", many = @Many(select = "readBataillons")) })
	public Army read(int id);

	@Select("SELECT * FROM Unit WHERE army = #{id}")
	@Results({ @Result(property = "bataillon", column = "bataillon", one = @One(select = "readBataillonForUnit")) })
	public List<Unit> readUnits(int id);

	@Select("SELECT * FROM Bataillon WHERE id = #{bataillon}")
	public Bataillon readBataillonForUnit(int bataillon);

	@Select("SELECT * FROM Bataillon WHERE army = #{army}")
	@Results({ @Result(property = "id", column = "id"),
			@Result(property = "units", column = "id", many = @Many(select = "readUnitsForBataillon")) })
	public List<Bataillon> readBataillons(@Param("army") int army);

	@Select("SELECT * FROM Unit WHERE bataillon = #{bataillon}")
	public List<Unit> readUnitsForBataillon(@Param("bataillon") int bataillon);
}
