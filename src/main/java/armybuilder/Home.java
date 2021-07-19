package armybuilder;

import java.util.Arrays;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import armybuilder.model.Allegiance;
import armybuilder.model.Army;
import armybuilder.model.SubAllegiance;

@Controller
public class Home {
	@Autowired
	private Army army;

	@GetMapping(path = "/")
	public ModelAndView home() {
		army.rebuild();
		return new ModelAndView("army")
				.addObject("allegiances", Allegiance.values()).addObject("subAllegiances", Arrays
						.stream(SubAllegiance.values()).filter(s -> s.isOptionDisplayed(army))
						.sorted()
						.collect(Collectors.toList()))
				.addObject("army", army);
	}

}
