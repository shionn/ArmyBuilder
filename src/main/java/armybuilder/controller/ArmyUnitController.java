package armybuilder.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;

import armybuilder.model.army.Army;
import armybuilder.model.army.option.MultiOption;
import armybuilder.model.unit.IUnitModel;
import armybuilder.model.unit.Unit;
import armybuilder.model.unit.option.UnitOption;

@Controller
public class ArmyUnitController {

	@Autowired
	private Army army;

	@GetMapping(path = "/unit/add")
	public String addUnit(@RequestHeader("unitChoice") String modelName) {
		IUnitModel model = army.getUnitChoices().stream().filter(u -> modelName.equals(u.name()))
				.findFirst().get();
		army.add(new Unit(army, model));
		return "redirect:/";
	}


	@GetMapping(path = "/unit/{hash}/{option}")
	public String setOption(@PathVariable("hash") int hash,
			@PathVariable("option") UnitOption option,
			@RequestHeader("value") String value) {
		army.getUnits().stream().filter(u -> u.hashCode() == hash).forEach(u -> {
			switch (option.getType()) {
			case bool:
				if (Boolean.valueOf(value)) {
					u.add(u.getOptionValues(option).get(0));
				} else {
					u.remove(option);
				}
				break;
			case select:
				if ("null".equals(value)) {
					u.remove(option);
				} else {
					u.getOptionValues(option).stream().filter(v -> v.name().equals(value))
							.forEach(v -> u.add(option, v));
				}
				break;
			case selectMultiOption:
				if ("0".equals(value)) {
					u.remove(option);
				} else {
					MultiOption o = army.multiOptions(option, Integer.parseInt(value));
					u.add(o);
				}
				break;
			default:
				break;

			}
		});
		return "redirect:/";
	}

	@GetMapping(path = "/unit/remove/{hash}")
	public String remove(@PathVariable("hash") int hash) {
		army.getUnits().stream().filter(u -> u.hashCode() == hash).forEach(u -> army.remove(u));
		return "redirect:/";
	}

	@GetMapping(path = "/optimisation/add")
	public String addOptimisation(@RequestHeader("optimisation") String optimisation) {
		army.getOptimisationChoices().stream().filter(o -> o.name().equals(optimisation))
				.forEach(army::add);
		return "redirect:/";
	}

	@GetMapping(path = "/optimisation/remove/{hash}")
	public String removeOptimisation(@PathVariable("hash") int hash) {
		army.getOptimisations().stream().filter(o -> o.hashCode() == hash).forEach(army::remove);
		return "redirect:/";
	}


}
