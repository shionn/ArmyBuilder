package armybuilder.controller.admin;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import armybuilder.controller.admin.request.EditRequest;
import armybuilder.db.dao.admin.ArmyEditDao;
import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class ArmyEditController {

	private SqlSession session;

	@GetMapping("/admin/army/edit")
	public ModelAndView open() {
		ArmyEditDao dao = session.getMapper(ArmyEditDao.class);
		return new ModelAndView("admin/army-edit")
				.addObject("armies", dao.listArmies());
	}

	@GetMapping("/admin/army/edit/{id}")
	public ModelAndView openArmy(@PathVariable("id") int id) {
		ArmyEditDao dao = session.getMapper(ArmyEditDao.class);
		return new ModelAndView("admin/army-edit")
				.addObject("armies", dao.listArmies())
				.addObject("army", dao.readArmy(id));
	}

	@PostMapping("/admin/army/edit/{id}")
	public String editArmy(@PathVariable("id") int id, @ModelAttribute EditRequest request) {

		return "redirect:/admin/army/edit/" + id;
	}



}
