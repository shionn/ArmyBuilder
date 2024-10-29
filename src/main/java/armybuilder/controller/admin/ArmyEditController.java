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
import armybuilder.db.dbo.army.ArmyModel;
import armybuilder.db.dbo.option.ArmyOptionModel;
import armybuilder.db.dbo.option.ArmyOptionType;
import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class ArmyEditController {

	private SqlSession session;

	@GetMapping("/admin/army/edit")
	public ModelAndView open() {
		ArmyEditDao dao = session.getMapper(ArmyEditDao.class);
		return new ModelAndView("admin/army-edit").addObject("options", dao.listOption());
	}

	@GetMapping("/admin/army/option/edit/{id}")
	public ModelAndView openArmyOption(@PathVariable("id") int id) {
		ArmyEditDao dao = session.getMapper(ArmyEditDao.class);
		return new ModelAndView("admin/army-edit").addObject("option", dao.readOption(id))
				.addObject("armies", dao.listArmies())
				.addObject("options", dao.listOption());
	}

	@PostMapping("/admin/army/option/edit/{id}")
	public String updateArmyOption(@PathVariable("id") int id, @ModelAttribute EditRequest request) {
		ArmyOptionModel option = ArmyOptionModel.builder()
				.id(id)
				.army(ArmyModel.builder().id(request.getArmy().getId()).build())
				.name(request.getName())
				.type(ArmyOptionType.valueOf(request.getType()))
				.script(request.getScript())
				.build();
		session.getMapper(ArmyEditDao.class).updateOption(option);
		session.commit();
		return "redirect:/admin/army/option/edit/" + option.getId();
	}

	@PostMapping("/admin/army/option/create")
	public String createArmyOption(@ModelAttribute EditRequest request) {
		ArmyOptionModel option = ArmyOptionModel.builder().name(request.getName()).build();
		session.getMapper(ArmyEditDao.class).createOption(option);
		session.commit();
		return "redirect:/admin/army/option/edit/" + option.getId();
	}

}
