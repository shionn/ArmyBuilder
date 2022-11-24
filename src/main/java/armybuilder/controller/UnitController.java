package armybuilder.controller;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
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

	@GetMapping("/unit/rm/{id}")
	public String rmUnit(@PathVariable("id") int id) {
		session.getMapper(UnitEditDao.class).rm(id);
		session.commit();
		return "redirect:/";
	}

	@PostMapping("/unit/edit/{id}/{option}")
	public String editBooleanUnitOption(@PathVariable("id") int id, @PathVariable("option") UnitOption option) {
		return edit(id, option);
	}

	@PostMapping("/unit/edit/{id}")
	public String editSelectUnitOption(@PathVariable("id") int id, @RequestHeader("option") UnitOption option) {
		return edit(id, option);
	}

	@PostMapping("/unit/bataillon/{id}")
	public String editBataillon(@PathVariable("id") int unit, @RequestHeader("bataillon") int bataillon) {
		session.getMapper(UnitEditDao.class).editBataillon(unit, bataillon);
		session.commit();
		return "redirect:/";
	}

	private String edit(int id, UnitOption option) {
		UnitEditDao dao = session.getMapper(UnitEditDao.class);
		Unit unit = dao.read(id);
		if (option.getCategory().isBoolean()) {
			if (unit.is(option.getCategory())) {
				option.getCategory().set(unit, null);
			} else {
				option.getCategory().set(unit, option);
			}
		} else {
			option.getCategory().set(unit, option);
		}
		dao.update(unit);
		session.commit();
		return "redirect:/";
	}


}
