package armybuilder.controller;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import armybuilder.db.dao.UnitEditDao;
import armybuilder.model.unit.model.UnitModel;

@Controller
public class UnitController {

	@Autowired
	private SqlSession session;
	@Autowired
	private CurrentArmyId current;

	@PostMapping("/unit/add")
	public String addUnit(@RequestParam("model") UnitModel model) {
		session.getMapper(UnitEditDao.class).add(current.id(), model);
		session.commit();
		return "redirect:/";
	}
}
