package armybuilder.model.unit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.stream.Collectors;

import armybuilder.model.army.bataillon.Bataillon;
import armybuilder.model.comparator.DisplayNameComparator;
import armybuilder.model.comparator.DisplayRuleComparator;
import armybuilder.model.comparator.EnumOrdinalComparator;
import armybuilder.model.rule.IHaveRule;
import armybuilder.model.rule.IRule;
import armybuilder.model.unit.keyword.IHaveKeyWord;
import armybuilder.model.unit.keyword.KeyWord;
import armybuilder.model.unit.model.UnitModel;
import armybuilder.model.unit.option.UnitOption;
import armybuilder.model.unit.option.UnitOptionCategory;
import armybuilder.model.unit.role.IHaveRoleTactique;
import armybuilder.model.unit.role.RoleTactique;
import armybuilder.model.unit.weapon.AlteredWeapon;
import armybuilder.model.unit.weapon.IHaveWeapons;
import armybuilder.model.unit.weapon.IUnitWeapon;
import lombok.Getter;
import lombok.Setter;

public class Unit implements IHaveWeapons, IHaveRoleTactique, IHaveKeyWord, IHaveRule {

	@Getter
	@Setter
	private int id;
	@Getter
	@Setter
	private UnitModel model;
	@Getter
	@Setter
	private UnitOption general;
	@Getter
	@Setter
	private UnitOption traisDeCommandement;
	@Getter
	@Setter
	private UnitOption traisDeMonstre;
	@Getter
	@Setter
	private UnitOption traisDeMonture;
	@Getter
	@Setter
	private UnitOption artefact;
	@Getter
	@Setter
	private UnitOption sort;
	@Getter
	@Setter
	private UnitOption priere;
	@Getter
	@Setter
	private UnitOption chef;
	@Getter
	@Setter
	private UnitOption musicien;
	@Getter
	@Setter
	private UnitOption banniere;
	@Getter
	@Setter
	private UnitOption arme;
	@Getter
	@Setter
	private UnitOption renforcee;
	@Getter
	@Setter
	private UnitOption invoquee;
	@Getter
	@Setter
	private UnitOption aspectChampion;
	@Getter
	@Setter
	private UnitOption aptitudeDeVeteran;
	@Getter
	@Setter
	private Bataillon bataillon;

	@Getter
	@Setter
	private int points;
	@Getter
	private List<IRule<?>> rules = new ArrayList<IRule<?>>();
	private List<KeyWord> keyWords = new ArrayList<KeyWord>();
	@Getter
	private List<IUnitWeapon> weapons = new ArrayList<IUnitWeapon>();
	private List<RoleTactique> roles = new ArrayList<RoleTactique>();
	@Getter
	@Setter
	private UnitProfile profile;

	public void decorate() {
		this.points = model.getPoints();
		this.profile = model.getProfile();
		this.rules.addAll(model.getRules());
		this.keyWords.addAll(model.getKeyWords());
		this.weapons.addAll(model.getWeapons());
		this.roles.addAll(model.getRoleTactiques());
		Arrays.asList(general, traisDeCommandement, traisDeMonstre, traisDeMonture, artefact, sort, priere, chef,
				musicien, banniere, arme, renforcee, aspectChampion, invoquee)
				.stream()
				.filter(Objects::nonNull)
				.forEach(o -> o.decorate(this));
		if (bataillon != null) {
			bataillon.decorate(this);
		}
		this.rules.forEach(r -> r.decorate(this));
	}

	/**
	 * weapons
	 */
	public void add(IUnitWeapon... weapons) {
		this.weapons.addAll(Arrays.asList(weapons));
	}

	public void alter(IUnitWeapon weapon, Consumer<AlteredWeapon> modifier) {
		this.weapons.replaceAll(w -> {
			if (w.is(weapon)) {
				AlteredWeapon altered = new AlteredWeapon(w);
				modifier.accept(altered);
				return altered;
			}
			return w;
		});
	}

	public void alterAllWeapons(Consumer<AlteredWeapon> modifier) {
		this.weapons.replaceAll(w -> {
			AlteredWeapon altered = new AlteredWeapon(w);
			modifier.accept(altered);
			return altered;
		});
	}

	/**
	 *
	 */
	@Override
	public List<RoleTactique> getRoleTactiques() {
		return roles;
	}

	public void changeRole(RoleTactique oldRole, RoleTactique newRole) {
		if (roles.remove(oldRole)) {
			roles.add(newRole);
		}
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

	public void addIf(boolean condition, KeyWord keyWord) {
		if (condition) {
			this.keyWords.add(keyWord);
		}
	}

	/**
	 * rules
	 */
	public List<IRule<?>> getDisplayRules() {
		return rules.stream().sorted(new DisplayRuleComparator()).toList();
	}

	public void add(IRule<?>... rules) {
		Arrays.stream(rules).filter(rule -> !this.rules.contains(rule)).forEach(this.rules::add);
	}

	/**
	 * Options
	 */
	public List<UnitOptionCategory> getOptionsCategories() {
		List<UnitOptionCategory> options = new ArrayList<UnitOptionCategory>(model.getOptionsCategories());
		if (is(KeyWord.ChampionDeGallet)) {
			options.add(UnitOptionCategory.AspectDuChampion);
		}
		options.sort(new EnumOrdinalComparator());
		return options;
	}

	public boolean is(UnitOption option) {
		return option.getCategory().get(this) == option;
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

	public ProfileDegressif getProfileDegressif() {
		return model.getProfileDegressif();
	}

	public boolean is(UnitModel model) {
		return this.model == model;
	}

	@Override
	public String toString() {
		return this.model.name();
	}

}
