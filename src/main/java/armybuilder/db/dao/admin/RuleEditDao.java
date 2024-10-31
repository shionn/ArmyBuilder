package armybuilder.db.dao.admin;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import armybuilder.db.dao.admin.frag.ListArmiesEditFragDao;
import armybuilder.db.dbo.Keyword;
import armybuilder.db.dbo.rule.Rule;

public interface RuleEditDao extends ListArmiesEditFragDao {

	@Insert("INSERT INTO Rule (name) VALUES (#{name})")
	@Options(useGeneratedKeys = true, keyColumn = "id", keyProperty = "id")
	int createRule(Rule rule);

	@Insert("REPLACE INTO RuleKeyword (rule,keyword) " //
			+ "VALUES (#{rule.id}, #{keyword})")
	int addKeyword(@Param("rule") Rule rule, @Param("keyword") Keyword keyword);

	@Select("SELECT * FROM Rule ORDER BY name")
	@Results({ //
			@Result(property = "id", column = "id"), //
			@Result(property = "keywords", column = "id", many = @Many(select = "listRuleKeywords")) //
	})
	List<Rule> list();

	@Select("SELECT keyword FROM RuleKeyword WHERE rule = #{rule}")
	List<Keyword> listRuleKeywords(int rule);

	@Select("SELECT * FROM Rule WHERE id = #{id}")
	@Results({ //
			@Result(column = "option_army", property = "optionArmy.id"),
			@Result(column = "id", property = "id"),
			@Result(column = "id", property = "keywords", many = @Many(select = "listRuleKeywords"))
	})
	Rule read(int id);

	@Update("UPDATE Rule " //
			+ "SET announce = #{announce}, `condition` = #{condition}, description = #{description}, "
			+ "effect = #{effect}, name = #{name}, timing = #{timing}, cost = #{cost}, option_army = #{optionArmy.id}, "
			+ "option_unit_type = #{optionUnitType}, option_army_type = #{optionArmyType}, script = #{script}, "
			+ "useby = #{useby} " //
			+ "WHERE id = #{id}")
	int updateRule(Rule rule);

}
