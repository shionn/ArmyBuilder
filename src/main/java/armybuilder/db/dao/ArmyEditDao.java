package armybuilder.db.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import armybuilder.model.army.Army;

public interface ArmyEditDao {

	@Select("SELECT id, name, allegiance, subAllegiance FROM Army WHERE id = #{id}")
	public Army read(int id);

	@Insert("INSERT INTO Army (name, allegiance) VALUES (#{name}, #{allegiance})")
	public int create(Army army);

	@Update("UPDATE Army SET subAllegiance = #{subAllegiance} WHERE id = #{id}")
	public int edit(Army army);

}
