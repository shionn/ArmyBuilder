package armybuilder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

import armybuilder.model.Allegiance;
import armybuilder.model.Army;
import armybuilder.model.ArmyOptionType;
import armybuilder.model.SubAllegiance;

@Controller
public class ArmyOptionController {

	@Autowired
	private Army army;

	@GetMapping(path = "/allegiance")
	public String setAllegiance(@RequestHeader("allegiance") Allegiance allegiance) {
		army.setOption(ArmyOptionType.Allegiance, allegiance);
		army.setOption(ArmyOptionType.SubAllegiance, null);
		return "redirect:/";
	}

	@GetMapping(path = "/suballegiance")
	public String setSubAllegiance(@RequestHeader("suballegiance") SubAllegiance subAllegiance) {
		army.setOption(ArmyOptionType.SubAllegiance, subAllegiance);
		return "redirect:/";
	}

}
