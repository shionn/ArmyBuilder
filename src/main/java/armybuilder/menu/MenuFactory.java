package armybuilder.menu;

import org.apache.ibatis.session.SqlSession;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.annotation.RequestScope;

import armybuilder.db.dao.menu.MenuDao;
import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
public class MenuFactory {

	private final SqlSession session;

	@Bean("menu")
	@RequestScope
	public MenuItem buildMenu() {
		MenuDao dao = session.getMapper(MenuDao.class);
		return MenuItem.builder()
				.children(dao.listRoot()
						.stream()
						.map(model -> MenuItem.builder()
								.name(model.getName())
								.children(dao.listArmy(model.getId())
										.stream()
										.map(army -> MenuItem.builder().name(army.getName()).id(army.getId()).build())
										.toList())
								.build())
						.toList())
				.build();
	}
}
