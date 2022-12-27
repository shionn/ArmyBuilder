package armybuilder.model.unit.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import armybuilder.model.unit.keyword.KeyWord;
import armybuilder.model.unit.option.UnitOptionCategory;
import armybuilder.model.unit.role.RoleTactique;

public class UnitModelTest {

	@ParameterizedTest
	@MethodSource("leaders")
	public void testLeaders(UnitModel model) {
		assertThat(model.getOptionsCategories()).contains(UnitOptionCategory.General)
				.doesNotContain(UnitOptionCategory.Renforcees);
		if (!model.is(KeyWord.Unique)) {
			assertThat(model.getOptionsCategories()).contains(UnitOptionCategory.General,
					UnitOptionCategory.TraisDeCommandement, UnitOptionCategory.Artefact);
		}
	}

	@ParameterizedTest
	@MethodSource("sorciers")
	public void testSorciers(UnitModel model) {
		assertThat(model.getOptionsCategories()).contains(UnitOptionCategory.Sort);
	}

	@ParameterizedTest
	@MethodSource("units")
	public void testUnits(UnitModel model) {
		assertThat(model.getOptionsCategories()).contains(UnitOptionCategory.Renforcees);
	}

	static Stream<UnitModel> leaders() {
		return Arrays.stream(UnitModel.values())
				.filter(u -> u.is(RoleTactique.Leader))
				.filter(u -> !u.is(KeyWord.LaReineDeLOmbre));
	}

	static Stream<UnitModel> sorciers() {
		return Arrays.stream(UnitModel.values())
				.filter(u -> u.is(KeyWord.Sorcier))
				.filter(u -> !u.is(KeyWord.MorathiKhaine));
	}

	static Stream<UnitModel> units() {
		return Arrays.stream(UnitModel.values())
				.filter(u -> u.is(RoleTactique.Ligne) || u.is(RoleTactique.Elite))
				.filter(u -> !u.is(KeyWord.Unique));
	}

}
