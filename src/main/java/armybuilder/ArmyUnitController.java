package armybuilder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

import armybuilder.model.Army;
import armybuilder.model.unit.DokUnit;
import armybuilder.model.unit.Unit;

@Controller
public class ArmyUnitController {

	@Autowired
	private Army army;

	@GetMapping(path = "/add-unit")
	public String setAllegiance(@RequestHeader("unitChoice") String modelName) {
		// Todo a rendre generique
		army.addUnit(new Unit(DokUnit.valueOf(modelName)));
		return "redirect:/";
	}

}
