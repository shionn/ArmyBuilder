package armybuilder.db.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import armybuilder.model.unit.Unit;
import armybuilder.model.unit.model.UnitModel;

public interface UnitEditDao {

	@Insert("INSERT INTO Unit (army, model) VALUE (#{army}, #{model})")
	void add(@Param("army") int army, @Param("model") UnitModel model);

	@Select("SELECT * FROM Unit WHERE id = #{id}")
	Unit read(int id);

	@Update("UPDATE Unit SET general = #{general}, " //
			+ "chef = #{chef}, musicien = #{musicien}, banniere = #{banniere}, " //
			+ "invoquee = #{invoquee} " //
			+ "WHERE id = #{id}")
	int update(Unit unit);

}
