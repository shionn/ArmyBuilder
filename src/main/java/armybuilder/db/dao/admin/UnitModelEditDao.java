package armybuilder.db.dao.admin;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import armybuilder.db.dbo.Keyword;
import armybuilder.db.dbo.unit.UnitModel;
import armybuilder.db.dbo.unit.UnitModelWeapon;

public interface UnitModelEditDao {

	@Select("SELECT id, name FROM UnitModel ORDER BY name")
	List<UnitModel> list();

	@Select("SELECT * FROM UnitModel WHERE id = #{id}")
	@Results({
			@Result(column = "id", property = "id"),
			@Result(column = "id", property = "keywords", many = @Many(select = "listKeywords")),
			@Result(column = "id", property = "weapons", many = @Many(select = "listWeapons"))
	})
	UnitModel read(int id);


	@Insert("INSERT INTO UnitModel (name) VALUES (#{name})")
	@Options(useGeneratedKeys = true, keyColumn = "id", keyProperty = "id")
	int create(UnitModel model);

	@Update("UPDATE UnitModel " //
			+ "SET name = #{name}, mvt = #{mvt}, life = #{life}, control = #{control}, save = #{save} " //
			+ "WHERE id = #{id}")
	int update(UnitModel unit);

	@Select("SELECT * FROM UnitModelWeapon WHERE unit_model = #{id}")
	List<UnitModelWeapon> listWeapons(int id);

	@Insert("INSERT INTO UnitModelWeapon (unit_model) VALUES (#{unit})")
	int addWeapons(int unit);

	@Delete("DELETE FROM UnitModelWeapon WHERE unit_model = #{unit} AND id = #{weapon}")
	int rmWeapons(@Param("unit") int unit, @Param("weapon") int weapon);

	@Update("UPDATE UnitModelWeapon " //
			+ "SET type = #{type}, name = #{name}, atk = #{atk}, hit=#{hit}, str = #{str}, perf = #{perf}, deg = #{deg} "
			+ "WHERE id = #{id}")
	int updateWeapon(UnitModelWeapon weapon);

	@Select("SELECT keyword FROM UnitModelKeyword WHERE unit_model = #{id}")
	List<Keyword> listKeywords(int id);

	@Delete("DELETE FROM UnitModelKeyword WHERE unit_model = #{id}")
	int deleteKeywords(int id);

	@Delete("INSERT INTO UnitModelKeyword (unit_model, keyword) " //
			+ "VALUES (#{id}, #{keyword})")
	int addKeywords(@Param("id") int id, @Param("keyword") Keyword keyword);

}
