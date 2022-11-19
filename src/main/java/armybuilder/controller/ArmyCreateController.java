package armybuilder.controller;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import armybuilder.db.dao.ArmyEditDao;
import armybuilder.model.army.Allegiance;
import armybuilder.model.army.Army;

@Controller
public class ArmyCreateController {

	@Autowired
	private SqlSession session;

	@GetMapping("/army/create")
	public ModelAndView openForm() {
		return new ModelAndView("create");
	}

	@PostMapping("/army/create")
	public String submitForm(@RequestParam(name = "name", required = true) String name,
			@RequestParam(name = "allegiance", required = true) Allegiance allegiance) {
		Army army = new Army();
		army.setName(name);
		army.setAllegiance(allegiance);
		session.getMapper(ArmyEditDao.class).create(army);
		session.commit();
		return "redirect:/";
	}

}
