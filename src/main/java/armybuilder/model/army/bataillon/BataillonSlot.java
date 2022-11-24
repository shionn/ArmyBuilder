package armybuilder.model.army.bataillon;

import java.util.function.Function;

import armybuilder.model.unit.Unit;
import armybuilder.model.unit.keyword.KeyWord;
import armybuilder.model.unit.model.UnitModel;
import armybuilder.model.unit.role.RoleTactique;

public enum BataillonSlot {

	Artillerie(u -> u.is(RoleTactique.Artillerie)),
	Commandant(u -> u.is(RoleTactique.Leader)),
	Monstre(u -> u.is(RoleTactique.Behemoth) && !u.is(RoleTactique.Leader)),
	SousCommandant(u -> u.is(RoleTactique.Leader) && u.getModel().getProfile().getIntLife() < 10),
	Troupe(u -> u.is(RoleTactique.Ligne) || u.is(RoleTactique.Elite)),
	// Dok
	ConjurateursDuFauMaudit(u -> u.is(UnitModel.ConjurateursDuFeuMaudit)),
	GuerriereKhinerai(u -> u.is(UnitModel.EtripeusesKhinerai) || u.is(UnitModel.EgorgeusesKhinerai)),
	GuerriereMelusai(u -> u.is(UnitModel.BloodSisters) || u.is(UnitModel.BloodStalkers)),
	KhainiteLeader(u -> u.is(KeyWord.MeduseIncarnate) || u.is(KeyWord.FerecailleMelusai)),
	Morathi(u -> u.is(UnitModel.MorathiKhaine) || u.is(UnitModel.LaReineDeLOmbre)),
	// Pack de Bataille
	VeteranDeGallet(u -> u.is(KeyWord.VeteransDeGallet)),

	;
	private Function<Unit, Boolean> is;

	private BataillonSlot(Function<Unit, Boolean> is) {
		this.is = is;
	}

	boolean is(Unit unit) {
		return is.apply(unit);
	}

}
