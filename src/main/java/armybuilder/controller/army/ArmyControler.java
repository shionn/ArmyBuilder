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

	@GetMapping("/army/{id}")
	public ModelAndView open(@PathVariable("id")int id) {
		ArmyDao dao = session.getMapper(ArmyDao.class);
		return new ModelAndView("army").addObject("army", dao.read(id));
	}

	@PostMapping("/army/{id}/add-unit")
	public String asddUnit(@PathVariable("id") int id, @RequestHeader("model") int model) {
		ArmyDao dao = session.getMapper(ArmyDao.class);
		dao.addUnit(id, model);
		session.commit();
		return "redirect:/army/" + id;
	}

}
