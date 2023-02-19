package armybuilder.db.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import armybuilder.model.army.Army;

public interface ArmyEditDao {

	@Select("SELECT * FROM Army WHERE id = #{id}")
	public Army read(int id);

	@Insert("INSERT INTO Army (name, allegiance) VALUES (#{name}, #{allegiance})")
	public int create(Army army);

	@Update("UPDATE Army " //
			+ "SET subAllegiance          = #{subAllegiance}, " //
			+ "    pack_de_bataille       = #{packDeBataille}, " //
			+ "    grande_strategie       = #{grandeStrategie}, " //
			+ "    triomphes              = #{triomphes}, " //
			+ "    aptitudeDeCommandement = #{aptitudeDeCommandement}, " //
			+ "    description_mode       = #{descriptionMode} " //
			+ "WHERE id = #{id}")
	public int edit(Army army);

}
