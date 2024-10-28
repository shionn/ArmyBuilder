package armybuilder.db.dbo.option;

import java.util.function.Predicate;

import armybuilder.db.dbo.Keyword;
import armybuilder.db.dbo.unit.Unit;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Option {
	Reinforced("Réenforcée", u -> u.getModel().is(Keyword.Infanterie) && u.getModel().getSize() > 1,
			OptionType.checkbox);

	private final String displayName;
	private final Predicate<Unit> available;
	private final OptionType type;

	public boolean isAvailable(Unit unit) {
		return available.test(unit);
	}

}
