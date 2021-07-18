package armybuilder;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import armybuilder.model.Faction;

@Controller
public class Home {

	@GetMapping(path = "/")
	public ModelAndView home() {
		return new ModelAndView("army").addObject("factions", Faction.values());
	}

}
