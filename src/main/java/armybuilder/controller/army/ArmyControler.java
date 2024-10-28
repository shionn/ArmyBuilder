package armybuilder.controller.army;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.servlet.ModelAndView;

import armybuilder.db.dao.army.ArmyDao;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class ArmyControler {

	private final SqlSession session;

	@GetMapping("/army/{army}")
	public ModelAndView open(@PathVariable("army") int army) {
		ArmyDao dao = session.getMapper(ArmyDao.class);
		return new ModelAndView("army").addObject("army", dao.read(army));
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

}
