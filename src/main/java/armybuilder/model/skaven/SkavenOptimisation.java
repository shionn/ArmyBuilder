package armybuilder.model.skaven;

import java.util.function.Consumer;
import java.util.function.Function;

import armybuilder.model.unit.Unit;
import armybuilder.model.unit.keyword.KeyWord;
import armybuilder.model.unit.option.IUnitOption;
import armybuilder.model.unit.option.UnitOptionCategory;

public enum SkavenOptimisation implements IUnitOption {

	// trais de co
	AdversaireSournois(UnitOptionCategory.TraisDeCommandement, u -> u.is(UnitOptionCategory.General)),
	ManipulateurSupreme(
			UnitOptionCategory.TraisDeCommandement,
			u -> u.is(UnitOptionCategory.General) && u.is(KeyWord.Maitreclan)),
	MaitreDeLaMagie(
			UnitOptionCategory.TraisDeCommandement,
			u -> u.is(UnitOptionCategory.General) && u.is(KeyWord.Maitreclan)),
	IntrigantDiabolique(
			UnitOptionCategory.TraisDeCommandement,
			u -> u.is(UnitOptionCategory.General) && u.is(KeyWord.Maitreclan)),
	MutateurAstucieux(
			UnitOptionCategory.TraisDeCommandement,
			u -> u.is(UnitOptionCategory.General) && u.is(KeyWord.ClansMoulder)),
	ModeleurSupreme(
			UnitOptionCategory.TraisDeCommandement,
			u -> u.is(UnitOptionCategory.General) && u.is(KeyWord.ClansMoulder)),
	MaitreDeHorde(
			UnitOptionCategory.TraisDeCommandement,
			u -> u.is(UnitOptionCategory.General) && u.is(KeyWord.ClansMoulder)),
	TueurSansEgal(
			UnitOptionCategory.TraisDeCommandement,
			u -> u.is(UnitOptionCategory.General) && u.is(KeyWord.ClansEchin)),
	MaitreDesOmbres(
			UnitOptionCategory.TraisDeCommandement,
			u -> u.is(UnitOptionCategory.General) && u.is(KeyWord.ClansEchin)),
	AgiliteIncroyable(
			UnitOptionCategory.TraisDeCommandement,
			u -> u.is(UnitOptionCategory.General) && u.is(KeyWord.ClansEchin)),

	LanceRouillee(
			SkavenWeapons.LanceRouillee.getDisplayName(),
			UnitOptionCategory.Armes,
			u -> u.is(KeyWord.RatsDesClans),
			u -> u.add(SkavenWeapons.LanceRouillee)),
	LameRouillee(
			SkavenWeapons.LameRouillee.getDisplayName(),
			UnitOptionCategory.Armes,
			u -> u.is(KeyWord.RatsDesClans),
			u -> u.add(SkavenWeapons.LameRouillee)),

	Maitregriffe(UnitOptionCategory.Chef, u -> u.is(KeyWord.RatsDesClans)),
	PorteEtendardDesClans(UnitOptionCategory.Banniere, u -> u.is(KeyWord.RatsDesClans)),
	SonneurDeClocheDesClans(UnitOptionCategory.Musicien, u -> u.is(KeyWord.RatsDesClans)),;

	private String displayName;
	private UnitOptionCategory category;
	private Function<Unit, Boolean> available;
	private Consumer<Unit> decorate;

	private SkavenOptimisation(String displayName, UnitOptionCategory category, Function<Unit, Boolean> available,
			Consumer<Unit> decorate) {
		this.displayName = displayName;
		this.category = category;
		this.available = available;
		this.decorate = decorate;
	}

	private SkavenOptimisation(UnitOptionCategory category, Function<Unit, Boolean> available) {
		this.displayName = SkavenRule.valueOf(name()).getDisplayName();
		this.category = category;
		this.available = available;
	}

	@Override
	public String getDisplayName() {
		return displayName;
	}

	@Override
	public UnitOptionCategory getCategory() {
		return category;
	}

	@Override
	public boolean availableFor(Unit unit) {
		return unit.is(KeyWord.Skavens) && available.apply(unit);
	}

	@Override
	public void decorate(Unit unit) {
		if (decorate == null) {
			unit.add(SkavenRule.valueOf(name()));
		} else {
			decorate.accept(unit);
		}
	}

}
