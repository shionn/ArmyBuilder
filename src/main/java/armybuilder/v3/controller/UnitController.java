package armybuilder.v3.controller;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

import armybuilder.v3.db.dao.UnitEditDao;
import armybuilder.v3.model.unit.Unit;
import armybuilder.v3.model.unit.model.UnitModel;
import armybuilder.v3.model.unit.option.UnitOption;
import armybuilder.v3.model.unit.option.UnitOptionCategory;

@Controller
public class UnitController {

	@Autowired
	private SqlSession session;
	@Autowired
	private CurrentArmyId current;

	@PostMapping("/v3/unit/add")
	public String addUnit(@RequestParam("model") UnitModel model) {
		session.getMapper(UnitEditDao.class).add(current.id(), model);
		session.commit();
		return "redirect:/v3";
	}

	@GetMapping("/v3/unit/rm/{id}")
	public String rmUnit(@PathVariable("id") int id) {
		session.getMapper(UnitEditDao.class).rm(id);
		session.commit();
		return "redirect:/v3";
	}

	@GetMapping("/v3/unit/{id}/rmopt/{option}")
	public String rmUnitOption(@PathVariable("id") int id, @PathVariable("option") UnitOptionCategory option) {
		UnitEditDao dao = session.getMapper(UnitEditDao.class);
		Unit unit = dao.read(id);
		option.set(unit, null);
		session.getMapper(UnitEditDao.class).update(unit);
		session.commit();
		return "redirect:/v3";
	}

	@PostMapping("/v3/unit/edit/{id}/{option}")
	public String editBooleanUnitOption(@PathVariable("id") int id, @PathVariable("option") UnitOption option) {
		return edit(id, option);
	}

	@PostMapping("/v3/unit/edit/{id}")
	public String editSelectUnitOption(@PathVariable("id") int id, @RequestHeader("option") UnitOption option) {
		return edit(id, option);
	}

	@PostMapping("/v3/unit/bataillon/{id}")
	public String editBataillon(@PathVariable("id") int unit, @RequestHeader("bataillon") int bataillon) {
		session.getMapper(UnitEditDao.class).editBataillon(unit, bataillon);
		session.commit();
		return "redirect:/v3";
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
		return "redirect:/v3";
	}


}
