package armybuilder.controller;

import java.util.Arrays;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import armybuilder.model.Turn;
import armybuilder.model.army.Army;
import armybuilder.model.army.option.Allegiance;
import armybuilder.model.army.option.ArmyOption;
import armybuilder.model.army.option.SubAllegiance;

@Controller
public class Home {
	@Autowired
	private Army army;

	@GetMapping(path = "/")
	public ModelAndView home() {
		army.rebuild();
		return new ModelAndView("army")
				.addObject("armyOptions", ArmyOption.values())
				.addObject("allegiances", Allegiance.values()).addObject("subAllegiances", Arrays
						.stream(SubAllegiance.values()).filter(s -> s.isOptionDisplayed(army))
						.sorted()
						.collect(Collectors.toList()))
				.addObject("army", army).addObject("turn", new Turn());
	}

}
