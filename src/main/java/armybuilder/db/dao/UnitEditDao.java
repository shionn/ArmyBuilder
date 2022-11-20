package armybuilder.db.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;

import armybuilder.model.unit.model.UnitModel;

public interface UnitEditDao {

	@Insert("INSERT INTO Unit (army, model) VALUE (#{army}, #{model})")
	void add(@Param("army") int army, @Param("model") UnitModel model);

}
