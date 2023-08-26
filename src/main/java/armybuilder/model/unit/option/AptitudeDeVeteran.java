package armybuilder.model.unit.option;

import java.util.Arrays;
import java.util.List;

import armybuilder.model.rule.IRule;
import armybuilder.model.rule.RuleType;
import armybuilder.model.rule.desc.Description;
import armybuilder.model.unit.Unit;
import armybuilder.serialisation.EnumPropertyLoader;
import lombok.Getter;

public enum AptitudeDeVeteran implements IUnitOption, IRule<AptitudeDeVeteran> {
	ParangonDeVaillance
	;


	@Getter
	private final String displayName;
	@Getter
	private final List<RuleType> types;

	private AptitudeDeVeteran(RuleType... types) {
		this.displayName = EnumPropertyLoader.instance().name(this);
		this.types = Arrays.asList(types);
	}

	@Override
	public UnitOptionCategory getCategory() {
		return UnitOptionCategory.AptitudeDeVeteran;
	}

	@Override
	public boolean availableFor(Unit unit) {
		return true;
	}

	@Override
	public void decorate(Unit unit) {
		unit.add(this);
	}

	@Override
	public Description getDescription() {
		return new Description("Generique/AptitudeDeVeteran", this);
	}

}
