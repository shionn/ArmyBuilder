package armybuilder.controller;

import java.util.function.Consumer;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

import armybuilder.db.dao.UnitEditDao;
import armybuilder.model.unit.Unit;
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

	@PostMapping("/unit/edit/{id}/General")
	public String editUnitGeneral(@PathVariable("id") int id,
			@RequestHeader(name = "General", defaultValue = "false") boolean general) {
		return edit(id, u -> u.setGeneral(general));
	}

	@PostMapping("/unit/edit/{id}/Chef")
	public String editUnitChef(@PathVariable("id") int id,
			@RequestHeader(name = "Chef", defaultValue = "false") boolean chef) {
		return edit(id, u -> u.setChef(chef));
	}

	@PostMapping("/unit/edit/{id}/Banniere")
	public String editUnitBanniere(@PathVariable("id") int id,
			@RequestHeader(name = "Banniere", defaultValue = "false") boolean banniere) {
		return edit(id, u -> u.setBanniere(banniere));
	}

	@PostMapping("/unit/edit/{id}/Musicien")
	public String editUnitMusicien(@PathVariable("id") int id,
			@RequestHeader(name = "Musicien", defaultValue = "false") boolean musicien) {
		return edit(id, u -> u.setMusicien(musicien));
	}

	@PostMapping("/unit/edit/{id}/Invoquee")
	public String editUnitInvoquee(@PathVariable("id") int id,
			@RequestHeader(name = "Invoquee", defaultValue = "false") boolean invoquee) {
		return edit(id, u -> u.setInvoquee(invoquee));
	}

	private String edit(int id, Consumer<Unit> modifier) {
		UnitEditDao dao = session.getMapper(UnitEditDao.class);
		Unit unit = dao.read(id);
		modifier.accept(unit);
		dao.update(unit);
		session.commit();
		return "redirect:/";
	}
}
