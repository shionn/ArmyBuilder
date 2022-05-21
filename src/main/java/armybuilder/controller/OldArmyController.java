package armybuilder.controller;

import java.io.IOException;
import java.io.StringWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.aop.framework.Advised;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.ObjectMapper;

import armybuilder.model.army.OldArmy;
import armybuilder.model.army.option.Allegiance;
import armybuilder.model.army.option.DisplayUnit;
import armybuilder.model.army.option.GrandeStrategie;
import armybuilder.model.army.option.IListingOptionValue;
import armybuilder.model.army.option.ListingOption;
import armybuilder.model.army.option.MultiOption;
import armybuilder.model.army.option.PackDeBataille;
import armybuilder.model.army.option.Triomphes;
import armybuilder.model.army.option.bataillon.Bataillon;
import armybuilder.model.unit.Unit;

@Controller
@Deprecated
public class OldArmyController {

	@Autowired
	private OldArmy army;

	@GetMapping(path = "/reset")
	public String reset() {
		army.reset();
		return "redirect:/";
	}

	@GetMapping(path = "/save")
	@ResponseBody
	public HttpEntity<String> save() throws Exception {
		StringWriter w = new StringWriter();
		new ObjectMapper().writeValue(w, getNotProxifiedArmy());
		HttpHeaders header = new HttpHeaders();
		header.set(HttpHeaders.CONTENT_DISPOSITION,
				"attachment; filename=" + fileName()
						+ "-" + new SimpleDateFormat("yyyy-MM-dd").format(new Date())
						+ ".json");
		return new HttpEntity<String>(w.toString(), header);
	}

	private String fileName() {
		IListingOptionValue<?> option = army.option(ListingOption.Allegiance);
		if (option == null) {
			return "NoAllegiance";
		}
		return option.getDisplayName();
	}


	@PostMapping(path = "/load")
	public String load(@RequestParam("file") MultipartFile file) throws IOException, Exception {
		army.reset();
		new ObjectMapper().readerForUpdating(getNotProxifiedArmy())
				.readValue(file.getInputStream());
		for (Unit u : army.getUnits()) {
			u.setArmy(army);
		}
		return "redirect:/";
		
	}

	@GetMapping(path = "/Allegiance")
	public String setAllegiance(@RequestHeader("Allegiance") Allegiance allegiance) {
		army.setOption(allegiance);
		return "redirect:/";
	}

	@GetMapping(path = "/PackDeBataille")
	public String setPackDeBataille(@RequestHeader("PackDeBataille") PackDeBataille pack) {
		army.setOption(pack);
		return "redirect:/";
	}

	@GetMapping(path = "/GrandeStrategie")
	public String setPackDeBataille(@RequestHeader("GrandeStrategie") GrandeStrategie gdStrat) {
		army.setOption(gdStrat);
		return "redirect:/";
	}

	@GetMapping(path = "/Triomphes")
	public String setPackDeBataille(@RequestHeader("Triomphes") Triomphes triomphes) {
		army.setOption(triomphes);
		return "redirect:/";
	}

	@GetMapping(path = "/Bataillon")
	public String addBataillon(@RequestHeader("Bataillon") Bataillon bat) {
		int id = army.multiOptions().stream().map(o -> o.getId()).reduce(0, Integer::max) + 1;
		army.addMultiOption(new MultiOption(id, ListingOption.Bataillon, bat));
		return "redirect:/";
	}

	@GetMapping(path = "/DisplayUnit")
	public String setPackDeBataille(@RequestHeader("DisplayUnit") DisplayUnit display) {
		army.setOption(display);
		return "redirect:/";
	}

	private OldArmy getNotProxifiedArmy() throws Exception {
		return (OldArmy) ((Advised) army).getTargetSource().getTarget();
	}

}
