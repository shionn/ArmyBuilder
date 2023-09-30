package armybuilder.model.army;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

import org.apache.commons.lang3.tuple.Pair;

import armybuilder.model.unit.Unit;
import armybuilder.model.unit.role.RoleTactique;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum UnitGroupDisplay {
	AllInOne("Tout en Un", false, Arrays.asList(Pair.of("non", a -> a.getUnits()))),
	LeadersTroupsArtilleriesOthers(
			"Leardes Troupes Artilleries Reste",
			true,
			Arrays.asList(Pair.of("Leaders", a -> a.units(RoleTactique.Leader)),
					Pair.of("Troupes", a -> a.units(u -> !u.isOne(RoleTactique.Leader, RoleTactique.Artillerie,
							RoleTactique.SortsPersistantsEtInvocation, RoleTactique.TerrainDeFaction))),
					Pair.of("Artilleries", a -> a.units(RoleTactique.Artillerie)),
					Pair.of("Autres", a -> a.units(
							u -> u.isOne(RoleTactique.SortsPersistantsEtInvocation, RoleTactique.TerrainDeFaction)))));

	@Getter
	private final String displayName;

	@Getter
	private final boolean displayTitles;

	private final List<Pair<String, Function<Army, List<Unit>>>> builders;

	public List<Pair<String, List<Unit>>> groups(Army army) {
		List<Pair<String, List<Unit>>> groups = new ArrayList<>();
		for (Pair<String, Function<Army, List<Unit>>> builder : builders) {
			groups.add(Pair.of(builder.getKey(), builder.getValue().apply(army)));
		}
		return groups;
	}

}
