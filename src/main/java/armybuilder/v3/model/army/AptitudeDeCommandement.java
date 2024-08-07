package armybuilder.v3.model.army;

import java.util.Arrays;
import java.util.List;

import armybuilder.v3.model.IHaveDisplayName;
import armybuilder.v3.model.rule.IRule;
import armybuilder.v3.model.rule.RuleType;
import armybuilder.v3.model.rule.desc.Description;
import armybuilder.v3.serialisation.EnumPropertyLoader;

public enum AptitudeDeCommandement implements IHaveDisplayName, IDecoreArmy, IRule<GrandeStrategie> {

	AppelALAide(Allegiance.StormCast),
	CoupDeTonerreFinal(Allegiance.StormCast),
	DechainezVotreAine(Allegiance.StormCast),
	MarcheImpertubable(Allegiance.StormCast),
	VoleeDEclairs(Allegiance.StormCast),

	;

	private Allegiance allegiance;
	private String displayName;

	private AptitudeDeCommandement(Allegiance allegiance) {
		this.displayName = EnumPropertyLoader.instance().name(this);
		this.allegiance = allegiance;
	}

	public boolean availableFor(Army army) {
		return allegiance == null || army.is(allegiance);
	}

	@Override
	public void decorate(Army army) {
		army.add(this);
	}

	@Override
	public String getDisplayName() {
		return displayName;
	}

	@Override
	public List<RuleType> getTypes() {
		return Arrays.asList(RuleType.AptitudesDeCommandement);
	}

	@Override
	public Description getDescription() {
		return new Description(this);
	}

}
