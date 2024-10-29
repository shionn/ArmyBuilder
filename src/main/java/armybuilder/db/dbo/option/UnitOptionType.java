package armybuilder.db.dbo.option;

import java.util.function.Predicate;

import armybuilder.db.dbo.Keyword;
import armybuilder.db.dbo.unit.Unit;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum UnitOptionType {
	Reinforced("Réenforcée", u -> u.getModel().is(Keyword.Infanterie) && u.getModel().getSize() > 1,
			UnitOptionMode.checkbox),
	HeroicAspect("Traits Héroiques", u -> u.getModel().is(Keyword.Heros), UnitOptionMode.select),;


	private final String name;
	private final Predicate<Unit> available;
	private final UnitOptionMode type;

	public boolean isAvailable(Unit unit) {
		return available.test(unit);
	}

	public static UnitOptionType from(String value) {
		try {
			return valueOf(value);
		} catch (IllegalArgumentException e) {
			return null;
		}
	}

}
