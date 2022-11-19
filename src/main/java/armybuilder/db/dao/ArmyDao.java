package armybuilder.db.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import armybuilder.db.dbo.Army;

public interface ArmyDao {

	@Select("SELECT id, name, allegiance FROM Army WHERE active IS TRUE ORDER BY allegiance, name")
	public List<Army> list();
	
	@Insert("INSERT INTO Army (name, allegiance) VALUES (#{name}, #{allegiance})")
	public int create(Army army);

	@Select("SELECT id, name, allegiance, subAllegiance FROM Army WHERE id = #{id}")
	public Army read(int id);

	@Update("UPDATE Army SET subAllegiance = #{subAllegiance} WHERE id = #{id}")
	public int edit(Army army);

}
