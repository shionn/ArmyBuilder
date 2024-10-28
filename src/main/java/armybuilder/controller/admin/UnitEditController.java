package armybuilder.controller.admin;

import java.util.Arrays;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import armybuilder.controller.admin.request.EditRequest;
import armybuilder.db.dao.admin.UnitModelEditDao;
import armybuilder.db.dbo.army.ArmyModel;
import armybuilder.db.dbo.rule.Rule;
import armybuilder.db.dbo.unit.UnitModel;
import armybuilder.db.dbo.unit.UnitModelRule;
import armybuilder.db.dbo.unit.UnitModelWeapon;
import armybuilder.db.dbo.unit.WeaponType;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class UnitEditController {
	private final SqlSession session;

	@GetMapping("/admin/unit/edit")
	public ModelAndView list() {
		UnitModelEditDao dao = session.getMapper(UnitModelEditDao.class);
		return new ModelAndView("admin/unit-edit").addObject("units", dao.list());
	}

	@GetMapping("/admin/unit/edit/{id}")
	public ModelAndView read(@PathVariable("id") int id) {
		UnitModelEditDao dao = session.getMapper(UnitModelEditDao.class);
		return new ModelAndView("admin/unit-edit").addObject("units", dao.list())
				.addObject("unit", dao.read(id))
				.addObject("armies", dao.listArmies())
				.addObject("rules", dao.listRules());
	}

	@PostMapping("/admin/unit/edit/{id}")
	public String edit(@PathVariable("id") int id, @ModelAttribute EditRequest request) {
		UnitModel unit = UnitModel.builder()
				.id(id)
				.control(request.getControl())
				.life(request.getLife())
				.mvt(request.getMvt())
				.name(request.getName())
				.save(request.getSave())
				.keywords(request.keywords())
				.cost(Integer.parseInt(request.getCost()))
				.size(Integer.parseInt(request.getSize()))
				.army(ArmyModel.builder().id(request.getArmy().getId()).build())
				.weapons(Arrays.stream(request.getWeapons())
						.map(r -> UnitModelWeapon.builder()
								.id(r.getId())
								.name(r.getName())
								.type(WeaponType.valueOf(r.getType()))
								.unitId(id)
								.range(r.getRange())
								.atk(r.getAtk())
								.hit(r.getHit())
								.str(r.getStr())
								.perf(r.getPerf())
								.deg(r.getDeg())
								.aptitude(r.getAptitude())
								.build())
						.toList())
				.rules(Arrays.stream(request.getRules())
						.map(m -> UnitModelRule.builder()
								.id(m.getId())
								.rule(Rule.builder().id(m.getRule().getId()).build())
								.build())
						.toList())
				.build();
		UnitModelEditDao dao = session.getMapper(UnitModelEditDao.class);
		dao.update(unit);
		dao.deleteKeywords(unit.getId());
		unit.getKeywords().forEach(k -> dao.addKeywords(id, k));
		unit.getWeapons().forEach(dao::updateWeapon);
		unit.getRules().forEach(dao::updateRule);
		session.commit();
		return "redirect:/admin/unit/edit/" + id;
	}

	@PostMapping("/admin/unit/create")
	public String createUnitModel(@ModelAttribute EditRequest request) {
		UnitModel model = UnitModel.builder().name(request.getName()).build();
		UnitModelEditDao dao = session.getMapper(UnitModelEditDao.class);
		dao.create(model);
		session.commit();
		return "redirect:/admin/unit/edit/" + model.getId();
	}

	@PostMapping("/admin/unit/edit/{unit}/add-weapon")
	public String addWeapon(@PathVariable("unit") int unit) {
		UnitModelEditDao dao = session.getMapper(UnitModelEditDao.class);
		dao.addWeapon(unit);
		session.commit();
		return "redirect:/admin/unit/edit/" + unit;
	}

	@PostMapping("/admin/unit/edit/{unit}/rm-weapon/{weapon}")
	public String rmWeapon(@PathVariable("unit") int unit, @PathVariable("weapon") int weapon) {
		UnitModelEditDao dao = session.getMapper(UnitModelEditDao.class);
		dao.rmWeapon(unit, weapon);
		session.commit();
		return "redirect:/admin/unit/edit/" + unit;
	}

	@PostMapping("/admin/unit/edit/{unit}/add-rule")
	public String addRule(@PathVariable("unit") int unit) {
		UnitModelEditDao dao = session.getMapper(UnitModelEditDao.class);
		dao.addRule(unit);
		session.commit();
		return "redirect:/admin/unit/edit/" + unit;
	}

	@PostMapping("/admin/unit/edit/{unit}/rm-rule/{model}")
	public String rmRule(@PathVariable("unit") int unit, @PathVariable("model") int rule) {
		UnitModelEditDao dao = session.getMapper(UnitModelEditDao.class);
		dao.rmRule(rule);
		session.commit();
		return "redirect:/admin/unit/edit/" + unit;
	}

}
