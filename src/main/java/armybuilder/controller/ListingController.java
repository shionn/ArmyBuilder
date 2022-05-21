package armybuilder.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;

import armybuilder.model.army.AllArmy;
import armybuilder.model.army.Listing;
import armybuilder.model.army.option.SubAllegiance;
import armybuilder.model.unit.IUnitModel;
import armybuilder.model.unit.Unit;

@Controller
public class ListingController {

	@Autowired
	private AllArmy armies;

	@GetMapping(path = "/listing/add")
	public String addListing() {
		int id = armies.current().listings().stream().map(l -> l.getId()).reduce(0, Integer::max) + 1;
		SubAllegiance subAllegiance = armies.current().getAvailableSubAllegiance().get(0);
		armies.current().add(new Listing(id, subAllegiance));
		return "redirect:/";
	}

	@GetMapping(path = "/listing/{id}/SubAllegiance")
	public String selectSubAllegiance(@PathVariable("id") int id,
			@RequestHeader("SubAllegiance") SubAllegiance sub) {
		armies.current().listing(id).set(sub);
		return "redirect:/";
	}

	@GetMapping(path = "/listing/{id}/unit/add")
	public String addUnitToListing(@PathVariable("id") int id, @RequestHeader("unitChoice") String name) {
		Listing listing = armies.current().listing(id);
		IUnitModel model = listing.getAvailableUnitChoice().stream().filter(u -> u.name().equalsIgnoreCase(name))
				.findFirst().get();
		listing.add(new Unit(model, listing));
		return "redirect:/";
	}

}
