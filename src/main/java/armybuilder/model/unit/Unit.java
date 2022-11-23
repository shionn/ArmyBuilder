package armybuilder.model.unit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import armybuilder.model.comparator.DisplayNameComparator;
import armybuilder.model.rule.IRule;
import armybuilder.model.unit.keyword.IHaveKeyWord;
import armybuilder.model.unit.keyword.KeyWord;
import armybuilder.model.unit.model.UnitModel;
import armybuilder.model.unit.option.UnitOptionCategory;
import armybuilder.model.unit.role.IHaveRoleTactique;
import armybuilder.model.unit.role.RoleTactique;
import armybuilder.model.unit.weapon.IHaveWeapons;
import armybuilder.model.unit.weapon.IUnitWeapon;
import armybuilder.modelold.deprecated.unit.option.UnitOptionType;

public class Unit implements IHaveWeapons, IHaveRoleTactique, IHaveKeyWord {

	private int id;
	private UnitModel model;
	private boolean general;
	private boolean chef;
	private boolean musicien;
	private boolean banniere;
	private boolean invoquee;
	// private List<UnitOption> options;

	private List<IRule<?>> rules = new ArrayList<IRule<?>>();
	private List<KeyWord> keyWords = new ArrayList<KeyWord>();


	public void decorate() {
		rules.addAll(model.getRules());
		keyWords.addAll(model.getKeyWords());
		Arrays.stream(UnitOptionCategory.values())
				.filter(cat -> cat.getType() == UnitOptionType.bool)
				.filter(cat -> cat.is(this));
		//model.decorate(this);
	}

	@Override
	public List<IUnitWeapon> getWeapons() {
		return model.getWeapons();
	}

	@Override
	public List<RoleTactique> getRoleTactiques() {
		return model.getRoleTactiques();
	}

	/**
	 * keyword
	 */
	@Override
	public List<KeyWord> getKeyWords() {
		keyWords.sort(new DisplayNameComparator());
		return keyWords;
	}

	public void add(KeyWord keyWord) {
		this.keyWords.add(keyWord);
	}

	/**
	 * rules
	 */
	public List<IRule<?>> getRules() {
		return rules;
	}

	public void add(IRule<?>... rules) {
		Arrays.stream(rules).forEach(this.rules::add);
	}

	/**
	 * Options
	 */
	public List<UnitOptionCategory> getOptionsCategories() {
		return model.getOptionsCategories();
	}

	public boolean is(UnitOptionCategory category) {
		return category.is(this);
	}

	/**
	 * basic
	 */
	public String getDisplayName() {
		return model.getDisplayName();
	}

	public UnitProfile getProfile() {
		return model.getProfile();
	}

	public ProfileDegressif getProfileDegressif() {
		return model.getProfileDegressif();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public UnitModel getModel() {
		return model;
	}

	public void setModel(UnitModel model) {
		this.model = model;
	}


	public void setGeneral(boolean general) {
		this.general = general;
	}

	public boolean isGeneral() {
		return general;
	}

	public void setChef(boolean chef) {
		this.chef = chef;
	}

	public boolean isChef() {
		return chef;
	}

	public void setMusicien(boolean musicien) {
		this.musicien = musicien;
	}

	public boolean isMusicien() {
		return musicien;
	}

	public void setBanniere(boolean banniere) {
		this.banniere = banniere;
	}

	public boolean isBanniere() {
		return banniere;
	}

	public void setInvoquee(boolean invoquee) {
		this.invoquee = invoquee;
	}

	public boolean isInvoquee() {
		return invoquee;
	}

}
