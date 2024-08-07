package armybuilder.v3.model.army.bataillon;

import java.util.function.Function;

import armybuilder.v3.model.unit.Unit;
import armybuilder.v3.model.unit.keyword.KeyWord;
import armybuilder.v3.model.unit.model.UnitModel;
import armybuilder.v3.model.unit.role.RoleTactique;

public enum BataillonSlot {

	Artillerie(u -> u.is(RoleTactique.Artillerie)),
	Commandant(u -> u.is(RoleTactique.Leader)),
	Monstre(u -> u.is(RoleTactique.Behemoth) && !u.is(RoleTactique.Leader)),
	SousCommandant(u -> u.is(RoleTactique.Leader) && u.getModel().getProfile().getIntLife() < 10),
	Troupe(u -> u.is(RoleTactique.Ligne) || u.is(RoleTactique.Elite)),
	// TODO Dok
//	ConjurateursDuFauMaudit(u -> u.is(UnitModel.ConjurateursDuFeuMaudit)),
//	GuerriereKhinerai(u -> u.is(UnitModel.EtripeusesKhinerai) || u.is(UnitModel.EgorgeusesKhinerai)),
//	GuerriereMelusai(u -> u.is(UnitModel.BloodSisters) || u.is(UnitModel.BloodStalkers)),
	KhainiteLeader(u -> u.is(KeyWord.MeduseIncarnate) || u.is(KeyWord.FerecailleMelusai)),
	Morathi(u -> u.is(UnitModel.MorathiKhaine) || u.is(UnitModel.LaReineDeLOmbre)),
	// Pack de Bataille
	ChampionDeGallet(u -> u.is(KeyWord.ChampionDeGallet)),
	VeteranDeGallet(u -> u.is(KeyWord.VeteransDeGallet)),
	Infanterie(
			u -> !u.isOne(RoleTactique.Leader, RoleTactique.Artillerie, RoleTactique.Behemoth) && !u.is(KeyWord.Monture)
					&& u.getProfile().getIntLife() <= 4),

	;
	private Function<Unit, Boolean> is;

	private BataillonSlot(Function<Unit, Boolean> is) {
		this.is = is;
	}

	boolean is(Unit unit) {
		return is.apply(unit);
	}

}
