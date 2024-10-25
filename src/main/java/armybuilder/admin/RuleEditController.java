package armybuilder.admin;

import java.util.Arrays;
import java.util.stream.Collectors;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import armybuilder.admin.request.EditRequest;
import armybuilder.db.dao.admin.RuleEditDao;
import armybuilder.db.dbo.Keyword;
import armybuilder.db.dbo.rule.Rule;
import armybuilder.db.dbo.rule.Timing;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class RuleEditController {

	private final SqlSession session;

	@GetMapping("/admin/rule/edit")
	public ModelAndView list() {
		RuleEditDao dao = session.getMapper(RuleEditDao.class);
		return new ModelAndView("admin/rule-edit").addObject("rules", dao.list());
	}

	@PostMapping("/admin/rule/create")
	public String createRule(@ModelAttribute EditRequest request) {
		Rule rule = Rule.builder()
				.name(request.getName())
				.timing(Timing.valueOf(request.getTiming()))
				.description(request.getDescription())
				.announce(request.getAnnounce())
				.effect(request.getEffect())
				.keywords(Arrays.stream(request.getKeywords().split(","))
						.map(Keyword::valueOf)
						.collect(Collectors.toList()))
				.build();
		RuleEditDao dao = session.getMapper(RuleEditDao.class);
		dao.createRule(rule);
		rule.getKeywords().forEach(k -> dao.addKeyword(rule, k));
		session.commit();
		return "redirect:/admin/rule/edit";
	}

}
