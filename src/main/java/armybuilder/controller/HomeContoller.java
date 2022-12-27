package armybuilder.controller;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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
		List<armybuilder.model.army.Army> armies = session.getMapper(ArmyDao.class).list();
		// TODO utiliser une List de Pair pour resoudre le probleme de tri
		Map<Allegiance, List<Army>> menus = armies.stream()
				.map(a -> a.getAllegiance())
				.distinct()
				.sorted(new DisplayNameComparator())
				.collect(Collectors.toMap(a -> a,
						allegiance -> armies.stream()
								.filter(army -> army.getAllegiance() == allegiance)
								.collect(Collectors.toList())));
		return new ModelAndView("main").addObject("menus", menus).addObject("army", army);
	}

}
