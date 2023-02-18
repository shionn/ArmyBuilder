package armybuilder.db.dao;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import armybuilder.model.unit.Unit;
import armybuilder.model.unit.model.UnitModel;

public interface UnitEditDao {

	@Select("SELECT * FROM Unit WHERE id = #{id}")
	Unit read(int id);

	@Insert("INSERT INTO Unit (army, model) VALUE (#{army}, #{model})")
	void add(@Param("army") int army, @Param("model") UnitModel model);

	@Update("UPDATE Unit SET general = #{general}, " //
			+ "trais_de_commandement = #{traisDeCommandement}, trais_de_monstre = #{traisDeMonstre}, " //
			+ "artefact = #{artefact}, sort = #{sort}, priere = #{priere}, " //
			+ "chef = #{chef}, musicien = #{musicien}, banniere = #{banniere}, " //
			+ "arme = #{arme}, renforcee = #{renforcee}, invoquee = #{invoquee}, "
			+ "trais_de_monture = #{traisDeMonture}, aspect_champion = #{aspectChampion} " //
			+ "WHERE id = #{id}")
	int update(Unit unit);

	@Delete("DELETE FROM Unit WHERE id = #{id}")
	void rm(int id);

	@Update("UPDATE Unit SET bataillon = #{bataillon} WHERE id = #{unit}")
	void editBataillon(@Param("unit") int unit, @Param("bataillon") int bataillon);

}
