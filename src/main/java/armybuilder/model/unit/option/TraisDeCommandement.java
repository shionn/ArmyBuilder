package armybuilder.model.unit.option;

import java.util.function.Consumer;
import java.util.function.Function;

import armybuilder.model.army.Allegiance;
import armybuilder.model.army.Army;
import armybuilder.model.dok.DokRule;
import armybuilder.model.unit.Unit;
import armybuilder.model.unit.keyword.KeyWord;
import armybuilder.model.unit.model.UnitModel;

public enum TraisDeCommandement implements IUnitOption {

	BainDeSang(u -> u.is(UnitOptionCategory.General) && !u.is(KeyWord.Unique), u -> u.add(DokRule.BainDeSang)),
	MaitriseDesArcanes(
			u -> u.is(UnitOptionCategory.General) && !u.is(KeyWord.Unique) && u.is(KeyWord.Sorcier),
			u -> {
				u.add(DokRule.MaitriseDesArcanes);
				u.add(DokRule.Affaiblissement);
				u.add(DokRule.DanseSymetrique);
				u.add(DokRule.DestrierDOmbres);
				u.add(DokRule.PuitsDeTenebres);
				u.add(DokRule.RasoirMental);
				u.add(DokRule.SuaireDeDesespoir);
			}),
	MaitreDesPoisons(
			u -> u.is(UnitOptionCategory.General) && !u.is(KeyWord.Unique),
			null),
	OrateurZele(u -> u.is(UnitOptionCategory.General) && !u.is(KeyWord.Unique), null),
	PousseParLaVengeance(
			u -> u.is(UnitOptionCategory.General) && u.is(UnitModel.MelusaiIronscale),
			null),
	SacrificateurSanglant(
			u -> u.is(UnitOptionCategory.General) && !u.is(KeyWord.Unique),
			null),
	VraiCroyant(u -> u.is(UnitOptionCategory.General) && !u.is(KeyWord.Unique), null);

	TraisDeCommandement(Function<Unit, Boolean> available, Consumer<Unit> modifier) {

	}

	public void decorate(Unit unit) {

	}

	public boolean available(Army army) {
		return army.is(Allegiance.DoK);
	}

	@Override
	public String getDisplayName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UnitOptionCategory getCategory() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean availableFor(Unit unit) {
		// TODO Auto-generated method stub
		return false;
	}

}
