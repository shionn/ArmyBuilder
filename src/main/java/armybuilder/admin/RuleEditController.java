package armybuilder.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RuleEditController {

	@GetMapping("/admin/rule/edit")
	public ModelAndView list() {
		return new ModelAndView("admin/rule-edit");
	}

}
