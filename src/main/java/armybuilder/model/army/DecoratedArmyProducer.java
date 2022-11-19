package armybuilder.model.army;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

import armybuilder.controller.CurrentArmyId;
import armybuilder.db.dao.ArmyDao;
import armybuilder.db.dbo.Army;

@Component
public class DecoratedArmyProducer {

	@Autowired
	private CurrentArmyId current;

	@Autowired
	private SqlSession session;

	@Bean
	@RequestScope
	public DecoratedArmy decoratedArmy() {
		Army army = session.getMapper(ArmyDao.class).read(current.id());
		if (army == null) {
			return new DecoratedArmy(new Army());
		}
		return decorate(army);
	}

	private DecoratedArmy decorate(Army army) {
		DecoratedArmy decorated = new DecoratedArmy(army);
		army.getAllegiance().decorate(decorated);

		return decorated;
	}

}
