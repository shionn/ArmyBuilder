package armybuilder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

import armybuilder.model.Army;
import armybuilder.model.option.Allegiance;
import armybuilder.model.option.ArmyOptionType;
import armybuilder.model.option.GrandeStrategie;
import armybuilder.model.option.PackDeBataille;
import armybuilder.model.option.SubAllegiance;

@Controller
public class ArmyOptionController {

	@Autowired
	private Army army;

	@GetMapping(path = "/Allegiance")
	public String setAllegiance(@RequestHeader("Allegiance") Allegiance allegiance) {
		army.setOption(ArmyOptionType.Allegiance, allegiance);
		return "redirect:/";
	}

	@GetMapping(path = "/SubAllegiance")
	public String setSubAllegiance(@RequestHeader("SubAllegiance") SubAllegiance subAllegiance) {
		army.setOption(ArmyOptionType.SubAllegiance, subAllegiance);
		return "redirect:/";
	}

	@GetMapping(path = "/PackDeBataille")
	public String setPackDeBataille(@RequestHeader("PackDeBataille") PackDeBataille pack) {
		army.setOption(ArmyOptionType.PackDeBataille, pack);
		return "redirect:/";
	}

	@GetMapping(path = "/GrandeStrategie")
	public String setPackDeBataille(@RequestHeader("GrandeStrategie") GrandeStrategie pack) {
		army.setOption(ArmyOptionType.GrandeStrategie, pack);
		return "redirect:/";
	}

}
