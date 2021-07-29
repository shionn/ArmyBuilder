package armybuilder;

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

import armybuilder.model.Army;
import armybuilder.model.option.Allegiance;
import armybuilder.model.option.ArmyOption;
import armybuilder.model.option.GrandeStrategie;
import armybuilder.model.option.PackDeBataille;
import armybuilder.model.option.SubAllegiance;
import armybuilder.model.option.Triomphes;
import armybuilder.model.unit.Unit;

@Controller
public class ArmyController {

	@Autowired
	private Army army;

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
				"attachment; filename=" + army.getOption(ArmyOption.Allegiance).getDisplayName()
						+ "-" + new SimpleDateFormat("yyyy-MM-dd").format(new Date())
						+ ".json");
		return new HttpEntity<String>(w.toString(), header);
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
		army.setOption(ArmyOption.Allegiance, allegiance);
		return "redirect:/";
	}

	@GetMapping(path = "/SubAllegiance")
	public String setSubAllegiance(@RequestHeader("SubAllegiance") SubAllegiance subAllegiance) {
		army.setOption(ArmyOption.SubAllegiance, subAllegiance);
		return "redirect:/";
	}

	@GetMapping(path = "/PackDeBataille")
	public String setPackDeBataille(@RequestHeader("PackDeBataille") PackDeBataille pack) {
		army.setOption(ArmyOption.PackDeBataille, pack);
		return "redirect:/";
	}

	@GetMapping(path = "/GrandeStrategie")
	public String setPackDeBataille(@RequestHeader("GrandeStrategie") GrandeStrategie pack) {
		army.setOption(ArmyOption.GrandeStrategie, pack);
		return "redirect:/";
	}

	@GetMapping(path = "/Triomphes")
	public String setPackDeBataille(@RequestHeader("Triomphes") Triomphes triomphes) {
		army.setOption(ArmyOption.Triomphes, triomphes);
		return "redirect:/";
	}

	private Army getNotProxifiedArmy() throws Exception {
		return (Army) ((Advised) army).getTargetSource().getTarget();
	}

}
