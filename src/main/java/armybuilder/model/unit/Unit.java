package armybuilder.model.unit;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import armybuilder.model.Army;
import armybuilder.model.rule.IArmyRule;
import armybuilder.model.unit.option.OptimisationsUniverselles;
import armybuilder.model.unit.option.UnitOption;

public class Unit {

	private Army army;
	private IUnitModel model;
	private Map<UnitOption, Object> options = new HashMap<UnitOption, Object>();

	public Unit(Army army, IUnitModel model) {
		this.army = army;
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

	public List<UnitOption> getOptions() {
		return Arrays.stream(UnitOption.values()).filter(u -> u.isAvailable(this))
				.collect(Collectors.toList());
	}

	public void addOption(UnitOption option, Object value) {
		options.put(option, value);
	}

	public void removeOption(UnitOption option) {
		options.remove(option);
	}

	public Object getOption(UnitOption option) {
		return options.get(option);
	}

	public List<?> getOptionValues(UnitOption option) {
		return Arrays.stream(OptimisationsUniverselles.values())
				.filter(o -> o.getOption() == option)
				.filter(o -> o.isAvailable(army, this)).collect(Collectors.toList());
	}

	public List<IArmyRule> getRules() {
		return model.getRules();
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

	public boolean is(KeyWord keyWord) {
		return getKeyWords().contains(keyWord);
	}

	public boolean is(UnitOption opt) {
		return getOption(opt) != null;
	}

}
