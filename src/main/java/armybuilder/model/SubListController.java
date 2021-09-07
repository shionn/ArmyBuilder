package armybuilder.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;

import armybuilder.model.unit.Unit;

@Controller
public class SubListController {

	@Autowired
	private Army army;

	@GetMapping(path = "/sublist/add")
	public String add() {
		int id = ((int) army.getSubLists().stream().reduce(0, (a, b) -> Integer.max(a, b))) + 1;
		army.addSubList(id);
		return "redirect:/";
	}

	@GetMapping(path = "/sublist/remove/{id}")
	public String remove(@PathVariable("id") int id) {
		army.getUnits().forEach(u -> u.removeSubList(id));
		army.removeSubList(id);
		return "redirect:/";
	}

	@GetMapping(path = "/sublist/add/{id}")
	public String add(@PathVariable("id") int id, @RequestHeader("unitHash") int unitHash) {
		Unit unit = army.getUnits().stream().filter(u -> u.hashCode() == unitHash).findFirst().get();
		unit.addSubList(id);
		return "redirect:/";
	}

	@GetMapping(path = "/sublist/remove/{id}/{unitHash}")
	public String remove(@PathVariable("id") int id, @PathVariable("unitHash") int unitHash) {
		Unit unit = army.getUnits().stream().filter(u -> u.hashCode() == unitHash).findFirst().get();
		unit.removeSubList(id);
		return "redirect:/";
	}

}
