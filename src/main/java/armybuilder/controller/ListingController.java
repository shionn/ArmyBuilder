package armybuilder.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;

import armybuilder.model.army.AllArmy;
import armybuilder.model.army.ArmyListing;
import armybuilder.model.army.option.SubAllegiance;

@Controller
public class ListingController {

	@Autowired
	private AllArmy armies;

	@GetMapping(path = "/listing/add")
	public String addListing() {
		int id = armies.current().getListings().stream().map(l -> l.getId()).reduce(0, Integer::max) + 1;
		armies.current().add(new ArmyListing(id));
		return "redirect:/";
	}

	@GetMapping(path = "/listing/{id}/SubAllegiance")
	public String selectSubAllegiance(@PathVariable("id") int id,
			@RequestHeader("SubAllegiance") SubAllegiance sub) {
		armies.current().listing(id).select(sub);
		return "redirect:/";
	}

}
