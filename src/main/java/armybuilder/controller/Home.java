package armybuilder.controller;

import java.io.IOException;
import java.io.StringWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.databind.ObjectMapper;

import armybuilder.db.dao.ArmyDao;
import armybuilder.model.Turn;
import armybuilder.model.army.AllArmy;
import armybuilder.model.army.Army;
import armybuilder.model.army.option.Allegiance;

@Controller
public class Home {
	@Autowired
	private AllArmy armies;
	@Autowired
	private SqlSession session;

	@GetMapping(path = "/")
	public ModelAndView home() {
		armies.rebuild();
		List<armybuilder.db.dbo.Army> armies = session.getMapper(ArmyDao.class).list();
		return new ModelAndView("army")
				.addObject("armies",
						armies.stream()
								.map(a -> a.getAllegiance())
								.distinct()
								.collect(Collectors.toMap(a -> a,
										allegiance -> armies.stream()
												.filter(army -> army.is(allegiance))
												.collect(Collectors.toList()))))
				.addObject("army", this.armies.current())
				.addObject("turn", new Turn());
	}

	@GetMapping(path = "/select/{allegiance}")
	public String change(@PathVariable("allegiance") Allegiance allegiance) {
		armies.select(allegiance);
		return "redirect:/";
	}

	@GetMapping(path = "/save")
	@ResponseBody
	public HttpEntity<String> save() throws Exception {
		StringWriter w = new StringWriter();
		new ObjectMapper().writeValue(w, armies.current());
		HttpHeaders header = new HttpHeaders();
		header.set(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + armies.current().allegiance() + "-"
				+ new SimpleDateFormat("yyyy-MM-dd").format(new Date()) + ".json");
		return new HttpEntity<String>(w.toString(), header);
	}

	@PostMapping(path = "/load")
	public String load(@RequestParam("file") MultipartFile file) throws IOException, Exception {
		Army army = new ObjectMapper().readerFor(Army.class).readValue(file.getInputStream());
		army.listings().forEach(l -> l.units().forEach(u -> u.listing(l)));
		armies.update(army);
		return "redirect:/";

	}

}
