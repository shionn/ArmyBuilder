package armybuilder.v3.model.army;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

import armybuilder.v3.controller.CurrentArmyId;
import armybuilder.v3.db.dao.ArmyDao;

@Component
public class ArmyProducer {

	@Autowired
	private CurrentArmyId current;

	@Autowired
	private SqlSession session;

	@Bean
	@RequestScope
	public Army currentArmy() {
		Army army = session.getMapper(ArmyDao.class).read(current.id());
		if (army == null) {
			army = new Army();
		} else {
			army.decorate();
		}
		return army;
	}


}
