package armybuilder.v3.model.unit.option;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

import armybuilder.v3.model.rule.IRule;
import armybuilder.v3.model.rule.PackDeBatailleRule;
import armybuilder.v3.model.unit.Unit;
import armybuilder.v3.model.unit.keyword.KeyWord;
import armybuilder.v3.model.unit.role.RoleTactique;

public class BaseUnitOption implements IUnitOption {

	public static class Builder {
		private BaseUnitOption option = new BaseUnitOption();

		public Builder aspectsDuChampion(PackDeBatailleRule rule) {
			return name(rule).category(UnitOptionCategory.AspectDuChampion)
					.availableFor(KeyWord.ChampionDeGallet)
					.decorate(rule);
		}

		public Builder artefact(PackDeBatailleRule rule) {
			return name(rule).category(UnitOptionCategory.Artefact)
					.decorate(rule)
					.availableFor(u -> !u.is(KeyWord.Unique) && u.is(RoleTactique.Leader));
		}

		public Builder sort(PackDeBatailleRule rule) {
			return name(rule).category(UnitOptionCategory.Sort)
					.decorate(rule)
					.availableFor(u -> !u.is(KeyWord.Unique) && u.is(RoleTactique.Leader) && u.is(KeyWord.Sorcier));
		}

		public Builder traitDeCo(PackDeBatailleRule rule) {
			return name(rule).category(UnitOptionCategory.TraisDeCommandement)
					.decorate(rule)
					.availableFor(u -> !u.is(KeyWord.Unique) && u.is(UnitOptionCategory.General));
		}

		public Builder name(IRule<?> rule) {
			option.displayName = rule.getDisplayName();
			return this;
		}

		private Builder category(UnitOptionCategory category) {
			option.category = category;
			return this;
		}

		public Builder availableFor(KeyWord keyWord) {
			return availableFor(u -> u.is(keyWord));
		}

		public Builder availableFor(RoleTactique role) {
			return availableFor(u -> u.is(role));
		}

		public Builder availableFor(Function<Unit, Boolean> available) {
			option.available.add(available);
			return this;
		}

		public Builder decorate(IRule<?> rule) {
			return decorate(u -> u.add(rule));
		}

		public Builder decorate(Consumer<Unit> decorate) {
			option.decorate = decorate;
			return this;
		}

		public IUnitOption build() {
			return option;
		}

		public Builder scenario() {
			option.displayName = "Scenario : " + option.displayName;
			return this;
		}

	}

	public static Builder builder() {
		return new Builder();
	}

	private String displayName;
	private UnitOptionCategory category;
	private List<Function<Unit, Boolean>> available = new ArrayList<>();
	private Consumer<Unit> decorate;

	private BaseUnitOption() {

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
		return available.stream().map(a -> a.apply(unit)).reduce(Boolean.TRUE, Boolean::logicalAnd);
	}

	@Override
	public void decorate(Unit unit) {
		if (decorate != null) {
			decorate.accept(unit);
		}
	}

}
