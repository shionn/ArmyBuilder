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
import armybuilder.db.dbo.army.Army;
import armybuilder.db.dbo.army.ArmyModel;
import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class ArmyEditController {

	private SqlSession session;

	@GetMapping("/admin/army/edit")
	public ModelAndView open() {
		ArmyEditDao dao = session.getMapper(ArmyEditDao.class);
		return new ModelAndView("admin/army-edit").addObject("armies", dao.listArmies())
				.addObject("models", dao.listArmyModels());
	}

	@GetMapping("/admin/army/edit/{id}")
	public ModelAndView openEditArmy(@PathVariable("id") int id) {
		ArmyEditDao dao = session.getMapper(ArmyEditDao.class);
		return new ModelAndView("admin/army-edit").addObject("armies", dao.listArmies())
				.addObject("models", dao.listArmyModels())
				.addObject(dao.readArmy(id));
	}

	@PostMapping("/admin/army/edit/{id}")
	public String editArmy(@PathVariable("id") int id, @ModelAttribute EditRequest request) {
		ArmyEditDao dao = session.getMapper(ArmyEditDao.class);
		Army army = Army.builder().id(id).name(request.getName()).model(ArmyModel.builder().id(request.getArmy().getId()).build()).build();
		dao.update(army);
		session.commit();
		return "redirect:/admin/army/edit/" + id + "#form";
	}

	@PostMapping("/admin/army/create")
	public String createArmy(@ModelAttribute EditRequest request) {
		Army army = Army.builder().name(request.getName()).build();
		ArmyEditDao dao = session.getMapper(ArmyEditDao.class);
		dao.createArmy(army);
		session.commit();
		return "redirect:/admin/army/edit/" + army.getId() + "#form";
	}

	@GetMapping("/admin/army/model/edit/{id}")
	public ModelAndView openArmyModel(@PathVariable("id") int id) {
		ArmyEditDao dao = session.getMapper(ArmyEditDao.class);
		return new ModelAndView("admin/army-edit").addObject("models", dao.listArmyModels())
				.addObject("model", dao.readArmyModel(id));
	}

	@PostMapping("/admin/army/model/edit/{id}")
	public String editArmyModel(@PathVariable("id") int id, @ModelAttribute EditRequest request) {

		return "redirect:/admin/army/edit/" + id;
	}

}
