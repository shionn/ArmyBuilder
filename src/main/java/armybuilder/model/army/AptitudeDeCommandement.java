package armybuilder.model.army;

import armybuilder.model.IHaveDisplayName;
import armybuilder.model.rule.IRule;
import armybuilder.model.stormcast.StormcastRule;

public enum AptitudeDeCommandement implements IHaveDisplayName, IDecoreArmy {

	AppelALAide(StormcastRule.AppelALAide, Allegiance.StormCast),
	CoupDeTonerreFinal(StormcastRule.CoupDeTonerreFinal, Allegiance.StormCast),
	DechainezVotreAine(StormcastRule.DechainezVotreAine, Allegiance.StormCast),
	MarcheImpertubable(StormcastRule.MarcheImpertubable, Allegiance.StormCast),
	VoleeDEclairs(StormcastRule.VoleeDEclairs, Allegiance.StormCast),

	;

	private IRule<?> rule;
	private Allegiance allegiance;

	private AptitudeDeCommandement(IRule<?> rule, Allegiance allegiance) {
		this.rule = rule;
		this.allegiance = allegiance;
	}

	public boolean availableFor(Army army) {
		return allegiance == null || army.is(allegiance);
	}

	@Override
	public void decorate(Army army) {
		army.add(rule);
	}

	@Override
	public String getDisplayName() {
		return rule.getDisplayName();
	}

}
