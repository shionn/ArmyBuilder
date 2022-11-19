package armybuilder.controller;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import armybuilder.db.dao.ArmyDao;
import armybuilder.db.dbo.Army;
import armybuilder.db.dbo.SubAllegiance;

@Controller
public class ArmyEditController {

	@Autowired
	private SqlSession session;
	@Autowired
	private CurrentArmyId current;


	@PostMapping("/army/edit")
	public String edit(@RequestParam("suballegiance") SubAllegiance sub) {
		ArmyDao dao = session.getMapper(ArmyDao.class);
		Army army = dao.read(current.id());
		army.setSubAllegiance(sub);
		dao.edit(army);
		session.commit();
		return "redirect:/";
	}

}
