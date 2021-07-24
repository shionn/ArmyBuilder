package armybuilder.model.option;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

import armybuilder.model.Army;
import armybuilder.model.rule.ArmyRuleType;
import armybuilder.model.rule.DescriptionReader;
import armybuilder.model.rule.IArmyRule;

public enum GrandeStrategie
		implements
		IArmyOptionValue<GrandeStrategie>,
		IArmyRule<GrandeStrategie> {
	CoupezLaTete("Coupez la Tête"), Vendetta("Vendetta"), TenezLaLigne("Tenez la Ligne");

	private String displayName;

	private GrandeStrategie(String displayName) {
		this.displayName = displayName;
	}

	@Override
	public String getDisplayName() {
		return displayName;
	}

	@Override
	public ArmyOption getOption() {
		return ArmyOption.PackDeBataille;
	}

	@Override
	public boolean isOptionDisplayed(Army army) {
		return army.getOption(ArmyOption.PackDeBataille) == PackDeBataille.LutteDeGeneraux;
	}

	@Override
	public void rebuild(Army army) {
	}

	@Override
	public void verify(Army army) {

	}

	@Override
	@SuppressWarnings("unchecked")
	public List<ArmyRuleType> getTypes() {
		return Collections.EMPTY_LIST;
	}

	@Override
	public String getDescription() throws IOException {
		return new DescriptionReader().read("GrandeStrategie/", name());
	}

}
