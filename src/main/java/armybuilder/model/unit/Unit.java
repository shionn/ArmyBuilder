package armybuilder.model.unit;

import java.util.List;
import java.util.stream.Collectors;

import armybuilder.model.Army;
import armybuilder.model.rule.IArmyRule;

public class Unit {

	private IUnit model;

	public Unit(IUnit model) {
		this.model = model;
	}

	public void rebuild(Army army) {
	}

	public List<IUnitWeapon> getWeapons(WeaponType type) {
		return model.getWeapons().stream().filter(w -> w.getType() == type)
				.collect(Collectors.toList());
	}

	public ProfileDegressif getProfileDegressif() {
		return model.getProfileDegressif();
	}

	public List<IArmyRule> getRules() {
		return model.getRules();
	}

	public List<IUnitOption<?>> getOptions() {
		return model.getOptions();
	}
	
	
	public List<KeyWord> getKeyWords() {
		return model.getKeyWords();
	}

	public String getDisplayName() {
		return model.getDisplayName();
	}

	public String getMouvement() {
		return model.getProfile().getMvt();
	}

	public String getBlessures() {
		return model.getProfile().getLife();
	}

	public String getBravoure() {
		return model.getProfile().getCmd();
	}

	public String getSauvegarde() {
		return model.getProfile().getSvg();
	}


}
