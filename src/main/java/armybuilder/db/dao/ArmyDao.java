package armybuilder.db.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import armybuilder.db.dbo.Army;

public interface ArmyDao {

	@Select("SELECT id, name, allegiance FROM Army WHERE active IS TRUE ORDER BY allegiance, name")
	public List<Army> list();
	
	@Insert("INSERT INTO Army (name, allegiance) VALUES (#{name} #{allegiance})")
	public void create(Army army);

}
