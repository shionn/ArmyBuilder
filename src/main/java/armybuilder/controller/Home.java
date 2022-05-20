package armybuilder.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import armybuilder.model.Turn;
import armybuilder.model.army.AllArmy;
import armybuilder.model.army.option.Allegiance;

@Controller
public class Home {
	@Autowired
	private AllArmy armies;

	@GetMapping(path = "/")
	public ModelAndView home() {
//		army.rebuild();
		return new ModelAndView("army")
//				.addObject("armyOptions", ArmyOption.values())
//				.addObject("allegiances", Allegiance.values()).addObject("subAllegiances", Arrays
//						.stream(SubAllegiance.values()).filter(s -> s.isOptionDisplayed(army))
//						.sorted()
//						.collect(Collectors.toList()))
				.addObject("army", armies.current()).addObject("turn", new Turn());
	}

	@GetMapping(path = "/select/{allegiance}")
	public String change(@PathVariable("allegiance") Allegiance allegiance) {
		armies.select(allegiance);
		return "redirect:/";
	}

}
