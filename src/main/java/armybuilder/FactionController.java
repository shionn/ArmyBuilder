package armybuilder;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FactionController {

	@GetMapping(path = "/faction")
	public String update() {
		return "redirect:/";
	}

}
