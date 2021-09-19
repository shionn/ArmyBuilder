package armybuilder.model.army.option.bataillon;

import java.util.function.Function;

import armybuilder.model.unit.RoleTactique;
import armybuilder.model.unit.Unit;

public enum BataillonSlot {

	Commandant(u -> u.is(RoleTactique.Leader)),
	SousCommandant(u -> u.is(RoleTactique.Leader)),
	Troupe(u -> u.is(RoleTactique.Ligne) || u.is(RoleTactique.Elite)),
	Artillerie(u -> u.is(RoleTactique.Artillerie)),
	Monstre(u -> u.is(RoleTactique.Behemoth) && !u.is(RoleTactique.Leader));
	
	private Function<Unit, Boolean> is;

	private BataillonSlot(Function<Unit, Boolean> is) {
		this.is = is;
	}

	boolean is(Unit unit) {
		return is.apply(unit);
	}
	
}
