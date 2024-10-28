package armybuilder.db.dao.army;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import armybuilder.db.dbo.Keyword;
import armybuilder.db.dbo.army.Army;
import armybuilder.db.dbo.army.ArmyModel;
import armybuilder.db.dbo.option.Option;
import armybuilder.db.dbo.rule.Rule;
import armybuilder.db.dbo.unit.Unit;
import armybuilder.db.dbo.unit.UnitModel;
import armybuilder.db.dbo.unit.UnitModelRule;
import armybuilder.db.dbo.unit.UnitModelWeapon;
import armybuilder.db.dbo.unit.option.UnitOptionValue;

public interface ArmyDao {

	@Select("SELECT * FROM Army WHERE id = #{id}")
	@Results({ //
			@Result(column = "id", property = "id"),
			@Result(column = "id", property = "units", many = @Many(select = "readUnits")),
			@Result(column = "model", property = "model", one = @One(select = "readModel")),
	})
	Army read(int id);

	@Select("SELECT * FROM Unit WHERE army = #{army}")
	@Results({ //
			@Result(column = "model", property = "model", one = @One(select = "readUnitModel")),
			@Result(column = "id", property = "id"),
			@Result(column = "id", property = "options", many = @Many(select = "readUnitOptionValues"))
	})
	List<Unit> readUnits(int army);

	@Select("SELECT * FROM ArmyModel WHERE id = #{id}")
	@Results({ 
			@Result(column = "id", property = "id"),
			@Result(column = "id", property = "units", many = @Many(select = "readUnitModels")) 
	})
	ArmyModel readModel(int id);

	@Select("SELECT * FROM UnitModel WHERE id = #{model}")
	@Results({ 
			@Result(column = "id", property = "id"),
			@Result(column = "id", property = "weapons", many = @Many(select = "readUnitModelWeapons")), 
			@Result(column = "id", property = "rules", many = @Many(select = "readUnitModelRules")), 
			@Result(column = "id", property = "keywords", many = @Many(select = "readUnitModelKeywords")), 
	})
	UnitModel readUnitModel(int model);

	@Select("SELECT * FROM UnitModelWeapon WHERE unit_model = #{model}")
	List<UnitModelWeapon> readUnitModelWeapons(int model);

	@Select("SELECT * FROM UnitModelRule WHERE unit_model = #{model}")
	@Results({ //
			@Result(column = "rule", property = "rule", one = @One(select = "readRule")), //
	})
	List<UnitModelRule> readUnitModelRules(int model);

	@Select("SELECT * FROM Rule WHERE id = #{id}")
	@Results({ //
			@Result(column = "id", property = "id"),
			@Result(column = "id", property = "keywords", many = @Many(select = "readRuleKeywords")), //
	})
	Rule readRule(int id);

	@Select("SELECT keyword FROM RuleKeyword WHERE rule = #{id}")
	List<Keyword> readRuleKeywords(int id);

	@Select("SELECT keyword FROM UnitModelKeyword WHERE unit_model = #{model}")
	List<Keyword> readUnitModelKeywords(int model);
	
	@Select("SELECT * FROM UnitModel WHERE army_model = #{model} ORDER BY name")
	List<UnitModel> readUnitModels(int model);

	@Insert("INSERT INTO Unit ( army, model ) VALUES ( #{army}, #{model} )")
	int addUnit(@Param("army") int army, @Param("model") int model);

	@Delete("DELETE FROM Unit WHERE id = #{id}")
	int rmUnit(int unit);

	@Insert("REPLACE INTO UnitOptionValue (unit, `option`, value) " //
			+ "VALUES (#{unit}, #{option}, #{value}) ")
	int setOptionValue(@Param("unit") int unit, @Param("option") Option option, @Param("value") String value);

	@Select("SELECT * FROM UnitOptionValue WHERE unit = #{unit}")
	List<UnitOptionValue> readUnitOptionValues(int unit);
}
