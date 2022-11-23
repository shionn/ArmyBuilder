package armybuilder.model.unit.option;

import java.util.function.BiConsumer;
import java.util.function.Function;

import armybuilder.model.IHaveDisplayName;
import armybuilder.model.unit.Unit;
import armybuilder.serialisation.EnumPropertyLoader;

public enum UnitOptionCategory implements IHaveDisplayName {
	General(UnitOptionType.bool, (u, o) -> u.setGeneral(o), Unit::getGeneral),
	TraisDeCommandement(UnitOptionType.select, (u, o) -> u.setTraisDeCommandement(o), Unit::getTraisDeCommandement),
	TraisDeMonstre(UnitOptionType.select, (u, o) -> u.setTraisDeMonstre(o), Unit::getTraisDeMonstre),
	Artefact(UnitOptionType.select, (u, o) -> u.setArtefact(o), Unit::getArtefact),
	Sort(UnitOptionType.select, (u, o) -> u.setSort(o), Unit::getSort),
	Priere(UnitOptionType.select, (u, o) -> u.setPriere(o), Unit::getPriere),

	Chef(UnitOptionType.bool, (u, o) -> u.setChef(o), Unit::getChef),
	Banniere(UnitOptionType.bool, (u, o) -> u.setBanniere(o), Unit::getBanniere),
	Musicien(UnitOptionType.bool, (u, o) -> u.setMusicien(o), Unit::getMusicien),
	Armes(UnitOptionType.select, (u, o) -> u.setArme(o), Unit::getArme),
	Invoquee(UnitOptionType.bool, (u, o) -> u.setInvoquee(o), Unit::getInvoquee),
	Renforcees(UnitOptionType.select, (u, o) -> u.setRenforcee(o), Unit::getRenforcee),
	Bataillon(UnitOptionType.select, null, null),

	;

	private String displayName;
	private BiConsumer<Unit, UnitOption> setter;
	private Function<Unit, UnitOption> getter;
	private UnitOptionType type;

	private UnitOptionCategory(UnitOptionType type, BiConsumer<Unit, UnitOption> setter,
			Function<Unit, UnitOption> getter) {
		this.displayName = EnumPropertyLoader.instance().name(this);
		this.type = type;
		this.setter = setter;
		this.getter = getter;
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
		return get(unit) != null;
	}

	public UnitOption get(Unit unit) {
		if (getter == null)
			return null;
		return getter.apply(unit);
	}

	public void set(Unit unit, UnitOption value) {
		setter.accept(unit, value);
	}

}
