package armybuilder.v3.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.lang3.tuple.Pair;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import armybuilder.v3.db.dao.ArmyDao;
import armybuilder.v3.model.army.Allegiance;
import armybuilder.v3.model.army.Army;
import armybuilder.v3.model.comparator.DisplayNameComparator;

@Controller
public class HomeV3Contoller {
	@Autowired
	private SqlSession session;
	@Autowired
	private Army army;

	@GetMapping(path = "/v3")
	public ModelAndView home() {
		List<Army> armies = session.getMapper(ArmyDao.class).list();
		List<Pair<Allegiance, List<Army>>> menus = armies.stream()
				.map(army -> army.getAllegiance())
				.distinct()
				.sorted(new DisplayNameComparator())
				.map(allegiance -> Pair.of(allegiance,
						armies.stream().filter(army -> army.is(allegiance)).collect(Collectors.toList())))
				.collect(Collectors.toList());
		return new ModelAndView("v3/main").addObject("menus", menus).addObject("army", army);
	}

}
