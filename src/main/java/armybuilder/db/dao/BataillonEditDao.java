package armybuilder.db.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;

import armybuilder.model.army.bataillon.BataillonType;

public interface BataillonEditDao {

	@Insert("INSERT INTO Bataillon(army,type) VALUES (#{army}, #{type})")
	void create(@Param("army") int army, @Param("type") BataillonType type);

}
