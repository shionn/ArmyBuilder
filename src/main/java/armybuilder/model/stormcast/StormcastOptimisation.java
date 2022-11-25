package armybuilder.model.stormcast;

import java.util.function.Consumer;
import java.util.function.Function;

import armybuilder.model.unit.Unit;
import armybuilder.model.unit.keyword.KeyWord;
import armybuilder.model.unit.option.IUnitOption;
import armybuilder.model.unit.option.UnitOptionCategory;

public enum StormcastOptimisation implements IUnitOption {
	AppelALAide(UnitOptionCategory.TraisDeCommandement, u -> true),
	MarcheImpertubable(UnitOptionCategory.TraisDeCommandement, u -> true),
	VoleeDEclairs(UnitOptionCategory.TraisDeCommandement, u -> true),
	DechainezVotreAine(UnitOptionCategory.TraisDeCommandement, u -> true),
	CoupDeTonerreFinal(UnitOptionCategory.TraisDeCommandement, u -> true),

	VindictorPrimus(UnitOptionCategory.Chef, u -> u.is(KeyWord.Vindictor)),
	SignifereAzyrite(UnitOptionCategory.Banniere, u -> u.is(KeyWord.Vindictor)),

	;

	private String displayName;
	private UnitOptionCategory category;
	private Function<Unit, Boolean> available;
	private Consumer<Unit> decorate;

	StormcastOptimisation(UnitOptionCategory category, Function<Unit, Boolean> available) {
		this(category, available, null);
	}

	StormcastOptimisation(UnitOptionCategory category, Function<Unit, Boolean> available, Consumer<Unit> decorate) {
		this.displayName = StormcastRule.valueOf(name()).getDisplayName();
		this.category = category;
		this.available = available;
		this.decorate = decorate;
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
		return unit.is(KeyWord.StormCast) && available.apply(unit);
	}

	@Override
	public void decorate(Unit unit) {
		if (decorate == null) {
			unit.add(StormcastRule.valueOf(name()));
		} else {
			decorate.accept(unit);
		}
	}

}
