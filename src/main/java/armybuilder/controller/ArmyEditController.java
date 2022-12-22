package armybuilder.controller;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import armybuilder.db.dao.ArmyEditDao;
import armybuilder.model.army.Army;
import armybuilder.model.army.GrandeStrategie;
import armybuilder.model.army.PackDeBataille;
import armybuilder.model.army.SubAllegiance;
import armybuilder.model.army.Triomphes;

@Controller
public class ArmyEditController {

	@Autowired
	private SqlSession session;
	@Autowired
	private CurrentArmyId current;

	@PostMapping("/army/edit")
	public String edit(@RequestParam("suballegiance") SubAllegiance sub,
			@RequestParam("packdebataille") PackDeBataille packDeBataille,
			@RequestParam(name = "grandestrategie") String grandeStrategie,
			@RequestParam(name = "triomphes") String triomphes) {
		ArmyEditDao dao = session.getMapper(ArmyEditDao.class);
		Army army = dao.read(current.id());
		army.setSubAllegiance(sub);
		army.setPackDeBataille(packDeBataille);
		army.setGrandeStrategie(toGS(grandeStrategie));
		army.setTriomphes(toTriomphes(triomphes));
		dao.edit(army);
		session.commit();
		return "redirect:/";
	}

	private Triomphes toTriomphes(String triomphes) {
		if ("NULL".equals(triomphes)) {
			return null;
		}
		return Triomphes.valueOf(triomphes);
	}

	private GrandeStrategie toGS(String grandeStrategie) {
		if ("NULL".equals(grandeStrategie)) {
			return null;
		}
		return GrandeStrategie.valueOf(grandeStrategie);
	}

}
