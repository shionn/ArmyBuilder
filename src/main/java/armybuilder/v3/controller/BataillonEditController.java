package armybuilder.v3.controller;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import armybuilder.v3.db.dao.BataillonEditDao;
import armybuilder.v3.model.army.bataillon.BataillonType;

@Controller
public class BataillonEditController {

	@Autowired
	private SqlSession session;
	@Autowired
	private CurrentArmyId current;

	@PostMapping("/v3/bataillon/add")
	public String create(@RequestParam("type") BataillonType type) {
		session.getMapper(BataillonEditDao.class).create(current.id(), type);
		session.commit();
		return "redirect:/v3";
	}

	@GetMapping("/v3/bataillon/rm/{id}")
	public String rm(@PathVariable("id") int bataillon) {
		session.getMapper(BataillonEditDao.class).remove(bataillon);
		session.commit();
		return "redirect:/v3";
	}

}
