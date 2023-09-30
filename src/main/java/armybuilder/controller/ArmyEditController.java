package armybuilder.controller;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import armybuilder.db.dao.ArmyEditDao;
import armybuilder.model.army.AptitudeDeCommandement;
import armybuilder.model.army.Army;
import armybuilder.model.army.GrandeStrategie;
import armybuilder.model.army.PackDeBataille;
import armybuilder.model.army.SubAllegiance;
import armybuilder.model.army.Triomphes;
import armybuilder.model.army.UnitGroupDisplay;
import armybuilder.model.rule.desc.DescriptionMode;

@Controller
public class ArmyEditController {

	@Autowired
	private SqlSession session;
	@Autowired
	private CurrentArmyId current;

	@PostMapping("/army/edit")
	public String edit(@RequestParam(name = "suballegiance", defaultValue = "NULL") String sub,
			@RequestParam(name = "packdebataille", defaultValue = "NULL") String packDeBataille,
			@RequestParam(name = "grandestrategie", defaultValue = "NULL") String grandeStrategie,
			@RequestParam(name = "triomphes", defaultValue = "NULL") String triomphes,
			@RequestParam(name = "aptitudeDeCommandement", defaultValue = "NULL") String aptitudeDeCommandement,
			@RequestParam(name = "descriptionMode") DescriptionMode descriptionMode,
			@RequestParam(name = "unitGroupMode", defaultValue = "AllInOne") UnitGroupDisplay unitGroupMode) {
		ArmyEditDao dao = session.getMapper(ArmyEditDao.class);
		Army army = dao.read(current.id());
		army.setDescriptionMode(descriptionMode);
		army.setSubAllegiance(toSubAllegiance(sub));
		army.setPackDeBataille(toPackDeBataille(packDeBataille));
		army.setGrandeStrategie(toGS(grandeStrategie));
		army.setTriomphes(toTriomphes(triomphes));
		army.setAptitudeDeCommandement(toAptitudeDeCommandement(aptitudeDeCommandement));
		army.setUnitGroupDisplay(unitGroupMode);
		dao.edit(army);
		session.commit();
		return "redirect:/";
	}

	private SubAllegiance toSubAllegiance(String subAllegiance) {
		if ("NULL".equals(subAllegiance)) {
			return null;
		}
		return SubAllegiance.valueOf(subAllegiance);
	}

	private PackDeBataille toPackDeBataille(String packDeBataille) {
		if ("NULL".equals(packDeBataille)) {
			return null;
		}
		return PackDeBataille.valueOf(packDeBataille);
	}

	private AptitudeDeCommandement toAptitudeDeCommandement(String aptitudeDeCommandement) {
		if ("NULL".equals(aptitudeDeCommandement)) {
			return null;
		}
		return AptitudeDeCommandement.valueOf(aptitudeDeCommandement);
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
