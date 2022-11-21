package armybuilder.modelold.deprecated.army.option.bataillon;

import java.util.function.Function;

import armybuilder.model.dok.DokUnitModel;
import armybuilder.model.unit.keyword.KeyWord;
import armybuilder.model.unit.role.RoleTactique;
import armybuilder.modelold.deprecated.unit.Unit;

public enum BataillonSlot {

	Artillerie(u -> u.is(RoleTactique.Artillerie)),
	Commandant(u -> u.is(RoleTactique.Leader)),
	Monstre(u -> u.is(RoleTactique.Behemoth) && !u.is(RoleTactique.Leader)),
	SousCommandant(u -> u.is(RoleTactique.Leader) && u.model().getProfile().getIntLife() < 10),
	Troupe(u -> u.is(RoleTactique.Ligne) || u.is(RoleTactique.Elite)),
	// Dok
	ConjurateursDuFauMaudit(u -> u.is(DokUnitModel.ConjurateursDuFeuMaudit)),
	GuerriereKhinerai(u -> u.is(DokUnitModel.EtripeusesKhinerai) || u.is(DokUnitModel.EgorgeusesKhinerai)),
	GuerriereMelusai(u -> u.is(DokUnitModel.BloodSisters) || u.is(DokUnitModel.BloodStalkers)),
	KhainiteLeader(u -> u.is(KeyWord.MeduseIncarnate) || u.is(KeyWord.FerecailleMelusai)),
	Morathi(u -> u.is(DokUnitModel.MorathiKhaine) || u.is(DokUnitModel.LaReineDeLOmbre)),
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
