package armybuilder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;

import armybuilder.model.Army;
import armybuilder.model.unit.Unit;
import armybuilder.model.unit.dok.DokUnitModel;
import armybuilder.model.unit.option.UnitOption;
import armybuilder.model.unit.option.UnitOptionType;

@Controller
public class ArmyUnitController {

	@Autowired
	private Army army;

	@GetMapping(path = "/unit/add")
	public String addUnit(@RequestHeader("unitChoice") String modelName) {
		// Todo a rendre generique
		army.addUnit(new Unit(army, DokUnitModel.valueOf(modelName)));
		return "redirect:/";
	}

	@GetMapping(path = "/unit/{hash}/{option}")
	public String setOption(@PathVariable("hash") int hash,
			@PathVariable("option") UnitOption option,
			@RequestHeader("value") String value) {
		army.getUnits().stream().filter(u -> u.hashCode() == hash).forEach(u -> {
			if (option.getType() == UnitOptionType.bool) {
				if (Boolean.valueOf(value)) {
					u.addOption(option, option);
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

}
