package armybuilder.db.dao.admin;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import armybuilder.db.dbo.Keyword;
import armybuilder.db.dbo.army.ArmyModel;
import armybuilder.db.dbo.rule.Rule;
import armybuilder.db.dbo.unit.UnitModel;
import armybuilder.db.dbo.unit.UnitModelWeapon;

public interface UnitModelEditDao {

	@Select("SELECT unit.id, unit.name, army.name AS army_name " //
			+ "FROM UnitModel unit " //
			+ "LEFT JOIN ArmyModel army ON unit.army_model = army.id " //
			+ "ORDER BY name")
	@Results({
		@Result(column = "army_name", property = "army.name"),
	})
	List<UnitModel> list();

	@Select("SELECT * FROM UnitModel WHERE id = #{id}")
	@Results({
			@Result(column = "id", property = "id"),
			@Result(column = "id", property = "keywords", many = @Many(select = "listKeywords")),
			@Result(column = "id", property = "weapons", many = @Many(select = "listWeapons")),
			@Result(column = "id", property = "rules", many = @Many(select = "listUnitRules")),
			@Result(column = "army_model", property = "army", one = @One(select = "readArmy")),
	})
	UnitModel read(int id);

	@Insert("INSERT INTO UnitModel (name) VALUES (#{name})")
	@Options(useGeneratedKeys = true, keyColumn = "id", keyProperty = "id")
	int create(UnitModel model);

	@Update("UPDATE UnitModel " //
			+ "SET name = #{name}, mvt = #{mvt}, life = #{life}, control = #{control}, save = #{save}, army_model = #{army.id} " //
			+ "WHERE id = #{id}")
	int update(UnitModel unit);

	@Select("SELECT * FROM UnitModelWeapon WHERE unit_model = #{id}")
	List<UnitModelWeapon> listWeapons(int id);

	@Insert("INSERT INTO UnitModelWeapon (unit_model) VALUES (#{unit})")
	int addWeapon(int unit);

	@Delete("DELETE FROM UnitModelWeapon WHERE unit_model = #{unit} AND id = #{weapon}")
	int rmWeapon(@Param("unit") int unit, @Param("weapon") int weapon);

	@Update("UPDATE UnitModelWeapon " //
			+ "SET type = #{type}, name = #{name}, `range` = #{range}, " //
			+ "atk = #{atk}, hit=#{hit}, str = #{str}, perf = #{perf}, deg = #{deg}, " //
			+ "aptitude = #{aptitude} " //
			+ "WHERE id = #{id}")
	int updateWeapon(UnitModelWeapon weapon);

	@Select("SELECT keyword FROM UnitModelKeyword WHERE unit_model = #{id}")
	List<Keyword> listKeywords(int id);

	@Delete("DELETE FROM UnitModelKeyword WHERE unit_model = #{id}")
	int deleteKeywords(int id);

	@Delete("INSERT INTO UnitModelKeyword (unit_model, keyword) " //
			+ "VALUES (#{id}, #{keyword})")
	int addKeywords(@Param("id") int id, @Param("keyword") Keyword keyword);

	@Select("SELECT * FROM ArmyModel WHERE id = #{army}")
	ArmyModel readArmy(int army);

	@Select("SELECT * FROM ArmyModel ORDER BY name")
	List<ArmyModel> listArmies();

	@Select("SELECT model.id, rule.id AS rule_id, rule.name AS rule_name " //
			+ "FROM UnitModelRule model " //
			+ "LEFT JOIN Rule rule ON model.rule = rule.id " //
			+ "WHERE unit_model = #{unit}")
	@Results({
		@Result(column = "rule_id", property = "rule.id"),
		@Result(column = "rule_name", property = "rule.name")
	})
	List<UnitModelRule> listUnitRules(int army);

	@Select("SELECT * FROM Rule ORDER BY name")
	List<Rule> listRules();

	@Insert("INSERT INTO UnitModelRule (unit_model) VALUES (#{unit})")
	int addRule(int unit);

	@Delete("DELETE FROM UnitModelRule WHERE id = #{id}")
	int rmRule(int id);

	@Update("UPDATE UnitModelRule SET rule = #{rule.id} WHERE id = #{id}")
	int updateRule(UnitModelRule model);

}
