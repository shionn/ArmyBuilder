package armybuilder.v3.model.unit.option;

import java.util.function.BiConsumer;
import java.util.function.Function;

import armybuilder.v3.model.IHaveDisplayName;
import armybuilder.v3.model.unit.Unit;
import armybuilder.v3.serialisation.EnumPropertyLoader;

public enum UnitOptionCategory implements IHaveDisplayName {
	General(UnitOptionType.bool, (u, o) -> u.setGeneral(o), Unit::getGeneral),
	TraisDeCommandement(UnitOptionType.select, (u, o) -> u.setTraisDeCommandement(o), Unit::getTraisDeCommandement),
	TraisDeMonstre(UnitOptionType.select, (u, o) -> u.setTraisDeMonstre(o), Unit::getTraisDeMonstre),
	TraisDeMonture(UnitOptionType.select, (u, o) -> u.setTraisDeMonture(o), Unit::getTraisDeMonture),
	Artefact(UnitOptionType.select, (u, o) -> u.setArtefact(o), Unit::getArtefact),
	@Deprecated
	// todo rename en SaisonalOption
	AspectDuChampion(UnitOptionType.select, (u, o) -> u.setAspectChampion(o), Unit::getAspectChampion),
	Sort(UnitOptionType.select, (u, o) -> u.setSort(o), Unit::getSort),
	Priere(UnitOptionType.select, (u, o) -> u.setPriere(o), Unit::getPriere),

	Chef(UnitOptionType.bool, (u, o) -> u.setChef(o), Unit::getChef),
	Banniere(UnitOptionType.bool, (u, o) -> u.setBanniere(o), Unit::getBanniere),
	Musicien(UnitOptionType.bool, (u, o) -> u.setMusicien(o), Unit::getMusicien),
	Armes(UnitOptionType.select, (u, o) -> u.setArme(o), Unit::getArme),
	Invoquee(UnitOptionType.bool, (u, o) -> u.setInvoquee(o), Unit::getInvoquee),
	Renforcees(UnitOptionType.select, (u, o) -> u.setRenforcee(o), Unit::getRenforcee),
	AptitudeDeVeteran(UnitOptionType.select, (u, o) -> u.setAptitudeDeVeteran(o), Unit::getAptitudeDeVeteran),

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
