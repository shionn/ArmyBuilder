package armybuilder.db.dao.army;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;

import armybuilder.db.dbo.option.ArmyOptionType;
import armybuilder.db.dbo.option.UnitOptionType;

public interface ArmyDao {


	@Insert("INSERT INTO Unit ( army, model ) VALUES ( #{army}, #{model} )")
	int addUnit(@Param("army") int army, @Param("model") int model);

	@Delete("DELETE FROM Unit WHERE id = #{id}")
	int rmUnit(int unit);

	@Insert("REPLACE INTO UnitOptionValue (unit, `option`, value) " //
			+ "VALUES (#{unit}, #{option}, #{value}) ")
	int setUnitOptionValue(@Param("unit") int unit, @Param("option") UnitOptionType option, @Param("value") String value);

	@Insert("REPLACE INTO ArmyOption (army, `type`, model) " //
			+ "VALUES (#{army}, #{option}, #{model}) ")
	int setArmyOptionValue(@Param("army") int army, @Param("option") ArmyOptionType option, @Param("model") int value);

}
