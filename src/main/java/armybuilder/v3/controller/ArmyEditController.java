package armybuilder.v3.controller;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import armybuilder.v3.db.dao.ArmyEditDao;
import armybuilder.v3.model.army.AptitudeDeCommandement;
import armybuilder.v3.model.army.Army;
import armybuilder.v3.model.army.GrandeStrategie;
import armybuilder.v3.model.army.PackDeBataille;
import armybuilder.v3.model.army.SubAllegiance;
import armybuilder.v3.model.army.Triomphes;
import armybuilder.v3.model.army.UnitGroupDisplay;
import armybuilder.v3.model.rule.desc.DescriptionMode;

@Controller
public class ArmyEditController {

	@Autowired
	private SqlSession session;
	@Autowired
	private CurrentArmyId current;

	@PostMapping("/v3/army/edit")
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
		return "redirect:/v3";
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
