package armybuilder.controller.army;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.servlet.ModelAndView;

import armybuilder.db.dao.army.ArmyDao;
import armybuilder.db.dao.army.ArmyReadDao;
import armybuilder.db.dbo.army.Army;
import armybuilder.db.dbo.option.ArmyOptionType;
import armybuilder.db.dbo.option.UnitOptionType;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class ArmyControler {

	private final SqlSession session;
	private final Decoration decorator;

	@GetMapping("/army/{army}")
	public ModelAndView open(@PathVariable("army") int id) {
		ArmyReadDao dao = session.getMapper(ArmyReadDao.class);
		Army army = dao.read(id);
		decorator.decorate(army);
		return new ModelAndView("army").addObject("army", army);
	}

	@PostMapping("/army/{army}/add-unit")
	public String addUnit(@PathVariable("army") int army, @RequestHeader("model") int model) {
		ArmyDao dao = session.getMapper(ArmyDao.class);
		dao.addUnit(army, model);
		session.commit();
		return "redirect:/army/" + army;
	}

	@GetMapping("/army/{army}/rm-unit/{unit}")
	public String rmUnit(@PathVariable("army") int army, @PathVariable("unit") int unit) {
		ArmyDao dao = session.getMapper(ArmyDao.class);
		dao.rmUnit(unit);
		session.commit();
		return "redirect:/army/" + army;
	}

	@PostMapping("/army/{army}/unit/{unit}/option/{option}")
	public String changeUnitOption(@PathVariable("army") int army, @PathVariable("unit") int unit,
			@PathVariable("option") UnitOptionType option, @RequestHeader("value") String value) {
		ArmyDao dao = session.getMapper(ArmyDao.class);
		dao.setUnitOptionValue(unit, option, value);
		session.commit();
		return "redirect:/army/" + army;
	}

	@PostMapping("/army/{army}/option/{option}")
	public String changeArmyOption(@PathVariable("army") int army, @PathVariable("option") ArmyOptionType option,
			@RequestHeader("model") int model) {
		ArmyDao dao = session.getMapper(ArmyDao.class);
		dao.setArmyOptionValue(army, option, model);
		session.commit();
		return "redirect:/army/" + army;
	}


}
