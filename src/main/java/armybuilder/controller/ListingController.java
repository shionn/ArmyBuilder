package armybuilder.controller;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;

import armybuilder.db.dbo.SubAllegiance;
import armybuilder.model.army.AllArmy;
import armybuilder.model.army.Listing;
import armybuilder.model.army.option.GrandeStrategie;
import armybuilder.model.army.option.PackDeBataille;
import armybuilder.model.army.option.Triomphes;
import armybuilder.model.army.option.bataillon.Bataillon;
import armybuilder.model.unit.IUnitModel;
import armybuilder.model.unit.Unit;

@Controller
public class ListingController {

	@Autowired
	private AllArmy armies;

	@GetMapping(path = "/listing/add")
	public String addListing() {
		int id = armies.current().listings().stream().map(l -> l.getId()).reduce(0, Integer::max) + 1;
		SubAllegiance subAllegiance = Arrays.stream(SubAllegiance.values())
				.filter(s -> armies.current().is(s.allegiance()))
				.findFirst()
				.get();
		armies.current().add(new Listing(id, subAllegiance));
		return "redirect:/";
	}

	@GetMapping(path = "/listing/rm/{id}")
	public String rmListing(@PathVariable("id") int id) {
		armies.current().rm(armies.current().listing(id));
		return "redirect:/";
	}

	@GetMapping(path = "/listing/{id}/SubAllegiance")
	public String selectSubAllegiance(@PathVariable("id") int id, @RequestHeader("SubAllegiance") SubAllegiance sub) {
		armies.current().listing(id).set(sub);
		return "redirect:/";
	}

	@GetMapping(path = "/listing/{id}/PackDeBataille")
	public String selectPackDeBataille(@PathVariable("id") int id,
			@RequestHeader("PackDeBataille") PackDeBataille pack) {
		armies.current().listing(id).set(pack);
		return "redirect:/";
	}

	@GetMapping(path = "/listing/{id}/GrandeStrategie")
	public String selectGrandeStrategie(@PathVariable("id") int id,
			@RequestHeader("GrandeStrategie") GrandeStrategie strategie) {
		armies.current().listing(id).set(strategie);
		return "redirect:/";
	}

	@GetMapping(path = "/listing/{id}/Triomphes")
	public String selectGrandeStrategie(@PathVariable("id") int id,
			@RequestHeader("Triomphes") Triomphes trionmphe) {
		armies.current().listing(id).set(trionmphe);
		return "redirect:/";
	}

	@GetMapping(path = "/listing/{id}/Bataillon/add")
	public String addBataillonToListing(@PathVariable("id") int id, @RequestHeader("bataillon") Bataillon bataillon) {
		armies.current().listing(id).add(bataillon);
		return "redirect:/";
	}

	@GetMapping(path = "/listing/{id}/Bataillon/rm/{bataillon}")
	public String rmBataillonToListing(@PathVariable("id") int id, @PathVariable("bataillon") Bataillon bataillon) {
		armies.current().listing(id).rm(bataillon);
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
