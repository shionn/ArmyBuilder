package armybuilder.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.lang3.tuple.Pair;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import armybuilder.db.dao.ArmyDao;
import armybuilder.model.army.Allegiance;
import armybuilder.model.army.Army;
import armybuilder.model.comparator.DisplayNameComparator;

@Controller
public class HomeContoller {
	@Autowired
	private SqlSession session;
	@Autowired
	private Army army;

	@GetMapping(path = "/")
	public ModelAndView home() {
		List<Army> armies = session.getMapper(ArmyDao.class).list();
		List<Pair<Allegiance, List<Army>>> menus = armies.stream()
				.map(army -> army.getAllegiance())
				.distinct()
				.sorted(new DisplayNameComparator())
				.map(allegiance -> Pair.of(allegiance,
						armies.stream().filter(army -> army.is(allegiance)).collect(Collectors.toList())))
				.collect(Collectors.toList());
		return new ModelAndView("main").addObject("menus", menus).addObject("army", army);
	}

}
