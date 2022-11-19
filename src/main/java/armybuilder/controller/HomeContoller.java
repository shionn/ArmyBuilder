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
import armybuilder.db.dbo.Allegiance;
import armybuilder.db.dbo.Army;
import armybuilder.model.Turn;
import armybuilder.model.army.DecoratedArmy;

@Controller
public class HomeContoller {
	@Autowired
	private SqlSession session;
	@Autowired
	private DecoratedArmy army;

	@GetMapping(path = "/")
	public ModelAndView home() {
		List<armybuilder.db.dbo.Army> armies = session.getMapper(ArmyDao.class).list();
		Map<Allegiance, List<Army>> menus = armies.stream()
				.map(a -> a.getAllegiance())
				.distinct()
				.collect(Collectors.toMap(a -> a,
						allegiance -> armies.stream()
								.filter(army -> army.getAllegiance() == allegiance)
								.collect(Collectors.toList())));
		return new ModelAndView("main").addObject("menus", menus)
				.addObject("army", army)
				.addObject("turn", new Turn());
	}

//	@GetMapping(path = "/select/{allegiance}")
//	public String change(@PathVariable("allegiance") Allegiance allegiance) {
//		armies.select(allegiance);
//		return "redirect:/";
//	}

//	@GetMapping(path = "/save")
//	@ResponseBody
//	public HttpEntity<String> save() throws Exception {
//		StringWriter w = new StringWriter();
//		new ObjectMapper().writeValue(w, armies.current());
//		HttpHeaders header = new HttpHeaders();
//		header.set(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + armies.current().allegiance() + "-"
//				+ new SimpleDateFormat("yyyy-MM-dd").format(new Date()) + ".json");
//		return new HttpEntity<String>(w.toString(), header);
//	}
//
//	@PostMapping(path = "/load")
//	public String load(@RequestParam("file") MultipartFile file) throws IOException, Exception {
//		Army army = new ObjectMapper().readerFor(Army.class).readValue(file.getInputStream());
//		army.listings().forEach(l -> l.units().forEach(u -> u.listing(l)));
//		armies.update(army);
//		return "redirect:/";
//
//	}

}
