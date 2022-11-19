package armybuilder.db.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;

import armybuilder.model.unit.IUnitModel;

public interface UnitEditDao {

	@Insert("INSERT INTO Unit (army, model) VALUE (#{amry}, #{model})")
	void add(@Param("army") int army, @Param("model") IUnitModel model);

}
