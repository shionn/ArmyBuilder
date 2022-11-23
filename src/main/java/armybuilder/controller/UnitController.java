package armybuilder.controller;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import armybuilder.db.dao.UnitEditDao;
import armybuilder.model.unit.Unit;
import armybuilder.model.unit.model.UnitModel;
import armybuilder.model.unit.option.UnitOption;

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

	@PostMapping("/unit/edit/{id}/{option}")
	public String editUnitOption(@PathVariable("id") int id, @PathVariable("option") UnitOption option) {
		UnitEditDao dao = session.getMapper(UnitEditDao.class);
		Unit unit = dao.read(id);
		if (option.getCategory().isBoolean()) {
			if (unit.is(option.getCategory())) {
				option.getCategory().set(unit, null);
			} else {
				option.getCategory().set(unit, option);
			}
		}
		dao.update(unit);
		session.commit();
		return "redirect:/";
	}

}
