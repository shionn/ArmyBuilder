package armybuilder.v4.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RootControllerAosV4 {

	@GetMapping("/v4")
	public ModelAndView root() {
		return new ModelAndView("v4/index");
	}

}
