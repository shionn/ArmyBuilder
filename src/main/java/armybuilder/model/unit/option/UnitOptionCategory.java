package armybuilder.model.unit.option;

import java.util.function.Function;

import armybuilder.model.IHaveDisplayName;
import armybuilder.model.unit.Unit;
import armybuilder.model.unit.keyword.KeyWord;
import armybuilder.modelold.deprecated.unit.option.UnitOptionType;
import armybuilder.serialisation.EnumPropertyLoader;

public enum UnitOptionCategory implements IHaveDisplayName {
	General(UnitOptionType.bool, (u) -> u.is(KeyWord.Heros), Unit::isGeneral),
	TraisDeCommandement(UnitOptionType.select, (u) -> !u.is(KeyWord.Unique), u -> false),
	TraisDeMonstre(UnitOptionType.select, (u) -> !u.is(KeyWord.Unique), u -> false),
	Artefact(UnitOptionType.select, (u) -> !u.is(KeyWord.Unique), u -> false),
	Sort(UnitOptionType.select, (u) -> u.is(KeyWord.Sorcier), u -> false),
	Priere(UnitOptionType.select, (u) -> u.is(KeyWord.Pretre), u -> false),

	Chef(UnitOptionType.bool, (u) -> true, Unit::isChef),
	Banniere(UnitOptionType.bool, (u) -> true, Unit::isBanniere),
	Musicien(UnitOptionType.bool, (u) -> true, Unit::isMusicien),
	Armes(UnitOptionType.select, (u) -> true, u -> false),
	Invoquee(UnitOptionType.bool, (u) -> true, Unit::isInvoquee),
	Renforcees(UnitOptionType.select, (u) -> !u.is(UnitOptionCategory.Invoquee), u -> false),
	Bataillon(UnitOptionType.select, (u) -> true, u -> false),

	;

	private String displayName;
	private Function<Unit, Boolean> available;
	private Function<Unit, Boolean> readBoolean;
	private UnitOptionType type;

	private UnitOptionCategory(UnitOptionType type, Function<Unit, Boolean> available,
			Function<Unit, Boolean> readBoolean) {
		this.displayName = EnumPropertyLoader.instance().name(this);
		this.type = type;
		this.available = available;
		this.readBoolean = readBoolean;
	}

	@Deprecated
	public boolean availableFor(Unit unit) {
		return available.apply(unit);
	}

	@Override
	public String getDisplayName() {
		return displayName;
	}

	public UnitOptionType getType() {
		return type;
	}

	public boolean is(Unit unit) {
		return readBoolean.apply(unit);
	}

}
