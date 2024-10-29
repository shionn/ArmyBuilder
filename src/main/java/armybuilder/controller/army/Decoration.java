package armybuilder.controller.army;

import java.util.Arrays;

import org.apache.ibatis.session.SqlSession;
import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;
import org.mozilla.javascript.ScriptableObject;
import org.springframework.stereotype.Component;

import armybuilder.db.dao.decoration.DecorationDao;
import armybuilder.db.dbo.army.Army;
import armybuilder.db.dbo.option.ArmyOptionType;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class Decoration {


	private final SqlSession session;

	public void decorate(Army army) {
		army.addRule(army.getModel().getOptionRules().stream().filter(r -> r.is(ArmyOptionType.BattleAspect)).toList());
		Context cx = Context.enter();
		try {
			DecorationDao dao = session.getMapper(DecorationDao.class);
			Scriptable scope = cx.initStandardObjects();

			ScriptableObject.putProperty(scope, "army", Context.javaToJS(new ArmyDecorated(dao, army), scope));
			army.getOptions()
					.stream()
					.map(o -> o.getScript())
					.forEach(script -> cx.evaluateString(scope, script, "truc", 0, null));
		} finally {
			Context.exit();
		}
	}

	@RequiredArgsConstructor
	public class ArmyDecorated {
		private final DecorationDao dao;
		private final Army army;

		public void addRule(int id) {
			army.addRule(Arrays.asList(dao.readRule(id)));
		}
	}

}
