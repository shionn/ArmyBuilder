package armybuilder.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import armybuilder.model.army.OldArmy;

@Controller
public class MultiOptionsController {

	@Autowired
	private OldArmy army;

	@GetMapping(path = "/multioptions/rm/{id}")
	public String rmMultiOption(@PathVariable("id") int id) {
		army.removeMultiOptions(id);
		return "redirect:/";
	}

}
