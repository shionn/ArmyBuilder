package armybuilder.model.unit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import armybuilder.model.comparator.DisplayNameComparator;
import armybuilder.model.dok.DokUnitWeapon;
import armybuilder.model.rule.IRule;
import armybuilder.model.unit.keyword.IHaveKeyWord;
import armybuilder.model.unit.keyword.KeyWord;
import armybuilder.model.unit.model.UnitModel;
import armybuilder.model.unit.option.UnitOption;
import armybuilder.model.unit.option.UnitOptionCategory;
import armybuilder.model.unit.role.IHaveRoleTactique;
import armybuilder.model.unit.role.RoleTactique;
import armybuilder.model.unit.weapon.IHaveWeapons;
import armybuilder.model.unit.weapon.IUnitWeapon;

public class Unit implements IHaveWeapons, IHaveRoleTactique, IHaveKeyWord {

	private int id;
	private UnitModel model;
	private UnitOption general;
	private UnitOption chef;
	private UnitOption musicien;
	private UnitOption banniere;
	private UnitOption invoquee;
	// private List<UnitOption> options;

	private int points;
	private List<IRule<?>> rules = new ArrayList<IRule<?>>();
	private List<KeyWord> keyWords = new ArrayList<KeyWord>();


	public void decorate() {
		this.points = model.getPoints();
		this.rules.addAll(model.getRules());
		this.keyWords.addAll(model.getKeyWords());
		Arrays.asList(general, chef, musicien, banniere, invoquee)
				.stream()
				.filter(Objects::nonNull)
				.forEach(o -> o.decorate(this));
	}

	/**
	 * weapons
	 */
	@Override
	public List<IUnitWeapon> getWeapons() {
		return model.getWeapons();
	}

	public Object add(DokUnitWeapon weapon) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 *
	 */
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

	public UnitOption optionValue(UnitOptionCategory category) {
		if (!category.isBoolean()) {
			throw new IllegalArgumentException(category + " n'est pas boolean");
		}
		List<UnitOption> optionValues = optionValues(category);
		if (optionValues.isEmpty()) {
			throw new IllegalStateException("pas d'otpion pour " + model + " " + category);
		}
		if (optionValues.size() > 1) {
			throw new IllegalStateException("trop d'option pour " + model + " " + category);
		}
		return optionValues.get(0);
	}

	public List<UnitOption> optionValues(UnitOptionCategory category) {
		return Arrays.stream(UnitOption.values())
				.filter(o -> o.getCategory() == category)
				.filter(o -> o.availableFor(this))
				.collect(Collectors.toList());
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

	public boolean is(UnitModel model) {
		return this.model == model;
	}

	public void setGeneral(UnitOption general) {
		this.general = general;
	}

	public UnitOption getGeneral() {
		return general;
	}

	public void setChef(UnitOption chef) {
		this.chef = chef;
	}

	public UnitOption getChef() {
		return chef;
	}

	public void setMusicien(UnitOption musicien) {
		this.musicien = musicien;
	}

	public UnitOption getMusicien() {
		return musicien;
	}

	public void setBanniere(UnitOption banniere) {
		this.banniere = banniere;
	}

	public UnitOption getBanniere() {
		return banniere;
	}

	public void setInvoquee(UnitOption invoquee) {
		this.invoquee = invoquee;
	}

	public UnitOption getInvoquee() {
		return invoquee;
	}

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}


}
