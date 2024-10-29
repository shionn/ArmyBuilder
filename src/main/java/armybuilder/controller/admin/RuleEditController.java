package armybuilder.controller.admin;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import armybuilder.controller.admin.request.EditRequest;
import armybuilder.db.dao.admin.RuleEditDao;
import armybuilder.db.dbo.army.ArmyModel;
import armybuilder.db.dbo.option.ArmyOptionType;
import armybuilder.db.dbo.option.UnitOptionType;
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

	@GetMapping("/admin/rule/edit/{id}")
	public ModelAndView open(@PathVariable("id") int id) {
		RuleEditDao dao = session.getMapper(RuleEditDao.class);
		return new ModelAndView("admin/rule-edit").addObject("rules", dao.list())
				.addObject("rule", dao.read(id))
				.addObject("armies", dao.listArmies());
	}

	@PostMapping("/admin/rule/edit/{id}")
	public String updateRule(@ModelAttribute EditRequest request) {
		Rule rule = Rule.builder()
				.id(request.getId())
				.name(request.getName())
				.timing(Timing.valueOf(request.getTiming()))
				.cost(request.getCost())
				.condition(request.getCondition())
				.description(request.getDescription())
				.announce(request.getAnnounce())
				.effect(request.getEffect())
				.keywords(request.keywords())
				.optionArmy(ArmyModel.builder().id(request.getOption().getArmy().getId()).build())
				.optionUnitType(UnitOptionType.from(request.getOption().getUnit().getType()))
				.optionArmyType(ArmyOptionType.from(request.getOption().getArmy().getType()))
				.build();
		RuleEditDao dao = session.getMapper(RuleEditDao.class);
		dao.updateRule(rule);
		rule.getKeywords().forEach(k -> dao.addKeyword(rule, k));
		session.commit();
		return "redirect:/admin/rule/edit/" + rule.getId();
	}

	@PostMapping("/admin/rule/create")
	public String createRule(@ModelAttribute EditRequest request) {
		Rule rule = Rule.builder().name(request.getName()).build();
		RuleEditDao dao = session.getMapper(RuleEditDao.class);
		dao.createRule(rule);
		session.commit();
		return "redirect:/admin/rule/edit/" + rule.getId();
	}

}
