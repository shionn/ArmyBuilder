package armybuilder.controller;

import java.util.Comparator;

import armybuilder.db.dbo.Keyword;
import armybuilder.db.dbo.rule.Rule;
import armybuilder.db.dbo.unit.Unit;

public class Comparators {

	public static final Comparator<Unit> unit = new Comparator<Unit>() {
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
				compare = o2.getModel().getName().compareTo(o1.getModel().getName());
			}
			if (compare == 0) {
				compare = Integer.compare(o1.getId(), o2.getId());
			}
			return compare;
		}
	};
	public static final Comparator<Rule> rule = new Comparator<Rule>() {

		@Override
		public int compare(Rule o1, Rule o2) {

			int compare = Boolean.compare(o1.getTiming() != null, o2.getTiming() != null);
			if (compare == 0 && o1.getTiming() != null && o2.getTiming() != null) {
				compare = Integer.compare(o1.getTiming().getStep().ordinal(), o2.getTiming().getStep().ordinal());
			}
			if (compare == 0) {
				compare = Boolean.compare(o1.is(Keyword.Sort), o2.is(Keyword.Sort));
			}
			if (compare == 0) {
				compare = Boolean.compare(o1.is(Keyword.Convocation), o2.is(Keyword.Convocation));
			}
			if (compare == 0 && o1.getCost() != null && o2.getCost() != null) {
				compare = o1.getCost().compareTo(o2.getCost());
			}
			if (compare == 0) {
				compare = o1.getName().compareTo(o2.getName());
			}
			return compare;
		}

	};

}
