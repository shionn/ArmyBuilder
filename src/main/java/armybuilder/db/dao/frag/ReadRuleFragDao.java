package armybuilder.db.dao.frag;

import java.util.List;

import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import armybuilder.db.dbo.Keyword;
import armybuilder.db.dbo.rule.Rule;

public interface ReadRuleFragDao {

	@Select("SELECT * FROM Rule WHERE id = #{id}")
	@Results({ //
			@Result(column = "id", property = "id"),
			@Result(column = "id", property = "keywords", many = @Many(select = "readRuleKeywords")), //
	})
	Rule readRule(int id);

	@Select("SELECT keyword FROM RuleKeyword WHERE rule = #{id}")
	List<Keyword> readRuleKeywords(int id);

}
