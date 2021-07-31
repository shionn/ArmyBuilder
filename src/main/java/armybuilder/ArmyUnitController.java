package armybuilder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;

import armybuilder.model.Army;
import armybuilder.model.unit.IUnitModel;
import armybuilder.model.unit.Unit;
import armybuilder.model.unit.option.UnitOption;
import armybuilder.model.unit.option.UnitOptionType;

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
			if (option.getType() == UnitOptionType.bool) {
				if (Boolean.valueOf(value)) {
					u.addOption(option, u.getOptionValues(option).get(0));
				} else {
					u.removeOption(option);
				}
			} else {
				if ("null".equals(value)) {
					u.removeOption(option);
				} else {
					u.getOptionValues(option).stream().filter(v -> v.name().equals(value))
							.forEach(v -> u.addOption(option, v));
				}
			}
		});
		return "redirect:/";
	}

	@GetMapping(path = "/unit/remove/{hash}")
	public String remove(@PathVariable("hash") int hash) {
		army.getUnits().stream().filter(u -> u.hashCode() == hash).forEach(u -> {
			army.remove(u);
		});
		return "redirect:/";
	}

}
