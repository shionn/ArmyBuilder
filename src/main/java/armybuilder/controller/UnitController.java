package armybuilder.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;

import armybuilder.model.army.AllArmy;
import armybuilder.model.army.OldArmy;
import armybuilder.model.unit.option.UnitOption;

@Controller
public class UnitController {

	@Autowired
	private OldArmy army;
	@Autowired
	private AllArmy armies;

	@GetMapping(path = "/unit/{hash}/{option}")
	public String setOption(@PathVariable("hash") int hash, @PathVariable("option") UnitOption option,
			@RequestHeader("value") String value) {
		armies.current()
				.listings()
				.stream()
				.flatMap(l -> l.units().stream())
				.filter(u1 -> u1.hashCode() == hash)
				.forEach(u -> {
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
							u.getOptionValues(option)
									.stream()
									.filter(v -> v.name().equals(value))
									.forEach(v -> u.add(option, v));
						}
					default:
						break;
					}
				});
		return "redirect:/";
	}

	@GetMapping(path = "/unit/remove/{hash}")
	public String remove(@PathVariable("hash") int hash) {
		armies.current()
				.listings()
				.stream()
				.forEach(l -> l.units()
						.stream()
						.filter(u -> u.hashCode() == hash)
						.findFirst()
						.ifPresent(u -> l.remove(u)));
		return "redirect:/";
	}

	@GetMapping(path = "/optimisation/add")
	public String addOptimisation(@RequestHeader("optimisation") String optimisation) {
		army.getOptimisationChoices().stream().filter(o -> o.name().equals(optimisation)).forEach(army::add);
		return "redirect:/";
	}

	@GetMapping(path = "/optimisation/remove/{hash}")
	public String removeOptimisation(@PathVariable("hash") int hash) {
		army.getOptimisations().stream().filter(o -> o.hashCode() == hash).forEach(army::remove);
		return "redirect:/";
	}

}
