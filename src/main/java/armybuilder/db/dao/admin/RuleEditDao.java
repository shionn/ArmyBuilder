package armybuilder.db.dao.admin;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import armybuilder.db.dbo.Keyword;
import armybuilder.db.dbo.rule.Rule;

public interface RuleEditDao {

	@Insert("INSERT INTO Rule (timing, name,description,announce,effect) "
			+ "VALUES (#{timing}, #{name}, #{description}, #{announce}, #{effect} )")
	@Options(useGeneratedKeys = true, keyColumn = "id", keyProperty = "id")
	int createRule(Rule rule);

	@Insert("INSERT INTO RuleKeyword (rule,keyword) " //
			+ "VALUES (#{rule.id}, #{keyword})")
	int addKeyword(@Param("rule") Rule rule, @Param("keyword") Keyword keyword);

	@Select("SELECT * FROM Rule ORDER BY name")
	@Results({ @Result(property = "id", column = "id"),
			@Result(property = "keywords", column = "id", many = @Many(select = "listRuleKeywords")) })
	List<Rule> list();

	@Select("SELECT keyword FROM RuleKeyword WHERE rule = #{rule}")
	List<Keyword> listRuleKeywords(int rule);

}
