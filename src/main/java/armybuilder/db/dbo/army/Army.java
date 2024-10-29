package armybuilder.db.dbo.army;

import java.util.Comparator;
import java.util.List;

import armybuilder.db.dbo.Keyword;
import armybuilder.db.dbo.option.ArmyOptionModel;
import armybuilder.db.dbo.option.ArmyOptionType;
import armybuilder.db.dbo.rule.Rule;
import armybuilder.db.dbo.unit.Unit;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Army {

	private int id;
	private String name;
	private ArmyModel model;
	private List<Unit> units;
	private List<Rule> rules;
	private List<ArmyOptionModel> options;

	public int getCost() {
		return units.stream().map(u -> u.getCost()).reduce(0, (a, b) -> a + b);
	}

	public ArmyOptionModel get(ArmyOptionType type) {
		return options.stream().filter(o -> o.getType() == type).findAny().orElse(null);
	}
	
	public List<Unit> getSortedUnits() {
		return units.stream().sorted(new Comparator<Unit>() {
			@Override
			public int compare(Unit o2, Unit o1) {
				int compare = Boolean.compare(o1.is(Keyword.Heros), o2.is(Keyword.Heros));
				if (compare == 0) {
					compare = Boolean.compare(o1.is(Keyword.Infanterie), o2.is(Keyword.Infanterie));
				}
				if (compare == 0) {
					compare = Boolean.compare(o1.is(Keyword.Monstre), o2.is(Keyword.Monstre));
				}
				if (compare == 0) {
					compare = Boolean.compare(o1.is(Keyword.TerrainDeFaction), o2.is(Keyword.TerrainDeFaction));
				}
				if (compare == 0) {
					compare = o1.getModel().getName().compareTo(o2.getModel().getName());
				}
				if (compare == 0) {
					compare = Integer.compare(o1.getId(), o2.getId());
				}
				return compare ;
			}
		}).toList();
	}

}
