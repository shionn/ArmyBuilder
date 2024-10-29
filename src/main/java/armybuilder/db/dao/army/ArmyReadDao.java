package armybuilder.db.dao.army;

import java.util.List;

import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import armybuilder.db.dao.frag.ReadRuleFragDao;
import armybuilder.db.dbo.Keyword;
import armybuilder.db.dbo.army.Army;
import armybuilder.db.dbo.army.ArmyModel;
import armybuilder.db.dbo.option.ArmyOptionModel;
import armybuilder.db.dbo.rule.Rule;
import armybuilder.db.dbo.unit.Unit;
import armybuilder.db.dbo.unit.UnitModel;
import armybuilder.db.dbo.unit.UnitModelRule;
import armybuilder.db.dbo.unit.UnitModelWeapon;
import armybuilder.db.dbo.unit.option.UnitOptionValue;

public interface ArmyReadDao extends ReadRuleFragDao {

	@Select("SELECT * FROM Army WHERE id = #{id}")
	@Results({ //
			@Result(column = "id", property = "id"),
			@Result(column = "id", property = "units", many = @Many(select = "readUnits")),
			@Result(column = "id", property = "options", one = @One(select = "readArmyOptions")),
			@Result(column = "model", property = "model", one = @One(select = "readModel")),
	})
	Army read(int id);

	@Select("SELECT * FROM Unit WHERE army = #{army}")
	@Results({ //
			@Result(column = "model", property = "model", one = @One(select = "readUnitModel")),
			@Result(column = "id", property = "id"),
			@Result(column = "id", property = "rules", many = @Many(select = "readUnitRules")),
			@Result(column = "id", property = "options", many = @Many(select = "readUnitOptionValues"))
	})
	List<Unit> readUnits(int army);

	@Select("SELECT * FROM Rule WHERE id IN (SELECT value FROM UnitOptionValue WHERE unit = #{unit})")
	List<Rule> readUnitRules(int unit);

	@Select("SELECT * FROM ArmyModel WHERE id = #{id}")
	@Results({ 
			@Result(column = "id", property = "id"),
			@Result(column = "id", property = "units", many = @Many(select = "readUnitModels")),
			@Result(column = "id", property = "options", many = @Many(select = "readArmyOptionModels")), 
			@Result(column = "id", property = "unitOptionRules", one = @One(select = "readUnitOptionRules")),
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

	@Select("SELECT keyword FROM UnitModelKeyword WHERE unit_model = #{model}")
	List<Keyword> readUnitModelKeywords(int model);
	
	@Select("SELECT * FROM UnitModel WHERE army_model = #{model} ORDER BY name")
	List<UnitModel> readUnitModels(int model);

	@Select("SELECT * FROM UnitOptionValue WHERE unit = #{unit}")
	List<UnitOptionValue> readUnitOptionValues(int unit);

	@Select("SELECT * FROM ArmyOptionModel WHERE army = #{model}")
	List<ArmyOptionModel> readArmyOptionModels(int model);

	@Select("SELECT * FROM ArmyOptionModel WHERE id IN (SELECT model FROM ArmyOption WHERE army = #{army})")
	List<ArmyOptionModel> readArmyOptions(int army);

	@Select("select * FROM Rule WHERE option_army = #{army} ORDER BY name")
	List<Rule> readUnitOptionRules(int army);
}
