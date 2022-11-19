package armybuilder.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class SelectArmyController {

	@Autowired
	private CurrentArmyId current;

	@GetMapping("/select/{id}")
	public String select(@PathVariable("id") int id) {
		current.id(id);
		return "redirect:/";
	}

}
