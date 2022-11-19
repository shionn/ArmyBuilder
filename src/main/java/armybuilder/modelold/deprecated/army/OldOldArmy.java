package armybuilder.modelold.deprecated.army;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import armybuilder.model.rule.IRule;
import armybuilder.model.unit.IUnitModel;
import armybuilder.model.unit.RoleTactique;
import armybuilder.modelold.deprecated.army.option.IListingOptionValue;
import armybuilder.modelold.deprecated.army.option.ListingOption;
import armybuilder.modelold.deprecated.army.rule.ArmyRuleType;
import armybuilder.modelold.deprecated.unit.KeyWord;
import armybuilder.modelold.deprecated.unit.Unit;
import armybuilder.modelold.deprecated.unit.option.IUnitOptionValue;
import armybuilder.modelold.deprecated.unit.option.OptimisationsUniverselles;
import armybuilder.modelold.deprecated.unit.option.UnitOption;
import armybuilder.serialisation.ListingOptionValueJsonDeserializer;
import armybuilder.serialisation.UnitOptionJsonDeserializer;

@Component
@SessionScope
@JsonAutoDetect(fieldVisibility = Visibility.ANY, getterVisibility = Visibility.NONE)
@JsonIgnoreProperties(ignoreUnknown = true)
@Deprecated
public class OldOldArmy {

	@JsonDeserialize(contentConverter = ListingOptionValueJsonDeserializer.class)
	private Map<ListingOption, IListingOptionValue<?>> options = new HashMap<>();
	private List<Unit> units = new ArrayList<>();
	@JsonDeserialize(contentConverter = UnitOptionJsonDeserializer.class)
	private List<IUnitOptionValue<?>> optimisations = new ArrayList<>();

	@JsonIgnore
	private Set<IRule<?>> rules = new LinkedHashSet<>();
	@JsonIgnore
	private Set<IUnitModel> unitChoices = new TreeSet<>((a, b) -> {
		return a.getDisplayName().compareTo(b.getDisplayName());
	});

	public void reset() {
		this.options.clear();
		this.units.clear();
		this.optimisations.clear();
	}

	public void rebuild() {
		rules.clear();
		units.stream().filter(Objects::nonNull).forEach(Unit::reset);


	}

	/*
	 * Options
	 */
	public void setOption(IListingOptionValue<?> value) {
		this.options.put(value.option(), value);
	}

	public boolean is(IListingOptionValue<?> opt) {
		return options.containsValue(opt);
	}

	public IListingOptionValue<?> option(ListingOption option) {
		return options.get(option);
	}

	public <T extends IListingOptionValue<?>> T option(T defolt) {
		@SuppressWarnings("unchecked")
		T value = (T) option(defolt.option());
		return value == null ? defolt : value;
	}

	/*
	 * rules
	 */
	public List<IRule<?>> getRules(ArmyRuleType... types) {
		return rules.stream().filter(r -> r.getTypes().containsAll(Arrays.asList(types)))
				.sorted((a, b) -> a.name().compareTo(b.name())).collect(Collectors.toList());
	}

	public List<IRule<?>> getRules(Collection<ArmyRuleType> types) {
		return rules.stream().filter(r -> r.getTypes().containsAll(types))
				// .filter(r -> isUsable(r))
				.sorted((a, b) -> a.name().compareTo(b.name())).collect(Collectors.toList());
	}

	public void addRule(IRule<?> rule) {
		this.rules.add(rule);
	}


	public void addRules(Collection<IRule<?>> rules) {
		this.rules.addAll(rules);
	}

	public void addRules(IRule<?>... rules) {
	}

	/*
	 * unit
	 */
	public void addUnitChoice(IUnitModel unit) {
		this.unitChoices.add(unit);
	}

	@JsonIgnore
	public Set<IUnitModel> getUnitChoices() {
		return unitChoices;
	}

	public List<IUnitModel> unitChoices(RoleTactique role, RoleTactique exclude) {
		return unitChoices.stream().filter(u -> u.is(role) && !u.is(exclude))
				.collect(Collectors.toList());
	}

	public List<IUnitModel> unitChoices(RoleTactique role) {
		return unitChoices.stream().filter(u -> u.is(role)).collect(Collectors.toList());
	}

	public void add(Unit unit) {
		this.units.add(unit);
	}

	public void remove(Unit unit) {
		this.units.remove(unit);
	}

	public List<Unit> getUnits() {
		return units.stream().sorted().collect(Collectors.toList());
	}

	public List<Unit> units(UnitOption opt) {
		return units.stream().filter(u -> u.is(opt)).collect(Collectors.toList());
	}

	public Unit unit(UnitOption opt) {
		return units.stream().filter(u -> u.is(opt)).findFirst().orElse(null);
	}

	public List<Unit> units(IRule<?> rule) {
		return units.stream().filter(u -> u.is(rule)).collect(Collectors.toList());
	}

	public List<Unit> units(UnitOption opt, IUnitOptionValue<?> value) {
		return units.stream().filter(u -> u.get(opt) == value).collect(Collectors.toList());
	}

	public List<Unit> units(RoleTactique role) {
		return units.stream().filter(u -> u.is(role)).collect(Collectors.toList());
	}

	public List<Unit> units(KeyWord keyWord) {
		return units.stream().filter(u -> u.is(keyWord)).collect(Collectors.toList());
	}

	public List<Unit> units(IUnitModel model) {
		return units.stream().filter(u -> u.is(model)).collect(Collectors.toList());
	}

	/**
	 * Optimisations
	 */
	public List<IUnitOptionValue<?>> getOptimisationChoices() {
		Set<IUnitOptionValue<?>> options = new HashSet<>();
		unitChoices.stream().map(u -> u.optionValues()).forEach(o -> options.addAll(o));
		options.addAll(Arrays.asList(OptimisationsUniverselles.values()));

		return options.stream()
				.filter(o -> Arrays.asList(UnitOption.TraisDeCommandement, UnitOption.Artefact,
						UnitOption.Sort, UnitOption.Priere)
						.contains(o.option()))
				.sorted((a, b) -> a.getFullDisplayName().compareTo(b.getFullDisplayName()))
				.collect(Collectors.toList());
	}

	public void add(IUnitOptionValue<?> optimisation) {
		this.optimisations.add(optimisation);
	}

	public void remove(IUnitOptionValue<?> optimisation) {
		this.optimisations.remove(optimisation);
	}

	public List<IUnitOptionValue<?>> getOptimisations() {
		return optimisations.stream()
				.sorted((a, b) -> a.getFullDisplayName().compareTo(b.getFullDisplayName()))
				.collect(Collectors.toList());
	}

}