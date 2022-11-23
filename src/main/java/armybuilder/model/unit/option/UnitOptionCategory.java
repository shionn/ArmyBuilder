package armybuilder.model.unit.option;

import java.util.function.BiConsumer;
import java.util.function.Function;

import armybuilder.model.IHaveDisplayName;
import armybuilder.model.unit.Unit;
import armybuilder.model.unit.keyword.KeyWord;
import armybuilder.serialisation.EnumPropertyLoader;

public enum UnitOptionCategory implements IHaveDisplayName {
	General(UnitOptionType.bool, (u) -> u.is(KeyWord.Heros), u -> u.getGeneral() != null, (u, o) -> u.setGeneral(o)),
	TraisDeCommandement(UnitOptionType.select, (u) -> !u.is(KeyWord.Unique), u -> false, null),
	TraisDeMonstre(UnitOptionType.select, (u) -> !u.is(KeyWord.Unique), u -> false, null),
	Artefact(UnitOptionType.select, (u) -> !u.is(KeyWord.Unique), u -> false, null),
	Sort(UnitOptionType.select, (u) -> u.is(KeyWord.Sorcier), u -> false, null),
	Priere(UnitOptionType.select, (u) -> u.is(KeyWord.Pretre), u -> false, null),

	Chef(UnitOptionType.bool, (u) -> true, u -> u.getChef() != null, (u, o) -> u.setChef(o)),
	Banniere(UnitOptionType.bool, (u) -> true, u -> u.getBanniere() != null, (u, o) -> u.setBanniere(o)),
	Musicien(UnitOptionType.bool, (u) -> true, u -> u.getMusicien() != null, (u, o) -> u.setMusicien(o)),
	Armes(UnitOptionType.select, (u) -> true, u -> false, null),
	Invoquee(UnitOptionType.bool, (u) -> true, u -> u.getInvoquee() != null, (u, o) -> u.setInvoquee(o)),
	Renforcees(UnitOptionType.select, (u) -> !u.is(UnitOptionCategory.Invoquee), u -> false, null),
	Bataillon(UnitOptionType.select, (u) -> true, u -> false, null),

	;

	private String displayName;
	private Function<Unit, Boolean> available;
	private Function<Unit, Boolean> readBoolean;
	private BiConsumer<Unit, UnitOption> setter;
	private UnitOptionType type;

	private UnitOptionCategory(UnitOptionType type, Function<Unit, Boolean> available,
			Function<Unit, Boolean> readBoolean, BiConsumer<Unit, UnitOption> setter) {
		this.displayName = EnumPropertyLoader.instance().name(this);
		this.type = type;
		this.available = available;
		this.readBoolean = readBoolean;
		this.setter = setter;
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

	public boolean isBoolean() {
		return type == UnitOptionType.bool;
	}

	public boolean is(Unit unit) {
		return readBoolean.apply(unit);
	}

	public void set(Unit unit, UnitOption value) {
		setter.accept(unit, value);
	}
}
