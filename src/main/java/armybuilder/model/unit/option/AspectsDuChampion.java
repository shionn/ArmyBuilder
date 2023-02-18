package armybuilder.model.unit.option;

import static armybuilder.model.rule.ShortDescriptionBuilder.sh;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import armybuilder.model.rule.IRule;
import armybuilder.model.rule.RuleType;
import armybuilder.model.rule.ShortDescriptionBuilder;
import armybuilder.model.unit.Unit;
import armybuilder.model.unit.keyword.KeyWord;
import armybuilder.serialisation.DescriptionReader;
import armybuilder.serialisation.EnumPropertyLoader;

public enum AspectsDuChampion implements IUnitOption, IRule<AspectsDuChampion> {
	MaitreDesTunnels(
			sh().uneFoisParBataille().text("à la place du mouvement").comma().teleport().aPlus(9).figurine().ennemi(),
			RuleType.PhaseDeMouvement),
	AlimenteParLaRageDeGhur(),
	EnteteCommeUnRhinox(
			sh().contest()
					.pour()
					.dix()
					.figurine()
					.sur()
					.objectif()
					.non()
					.contesté()
					.keyword(KeyWord.ChampionDeGallet)
					.ennemi())
	;

	private String shortDesciprion;
	private ArrayList<RuleType> types;

	private AspectsDuChampion( RuleType... types) {
		this(null, types);
	}
	private AspectsDuChampion(ShortDescriptionBuilder sh, RuleType... types) {
		this.shortDesciprion = sh.build();
		this.types = new ArrayList<RuleType>(Arrays.asList(types));
		this.types.add(RuleType.Aptitude);
		this.types.add(RuleType.TraisUnitee);
	}

	@Override
	public String getDisplayName() {
		return EnumPropertyLoader.instance().name(this);
	}

	@Override
	public UnitOptionCategory getCategory() {
		return UnitOptionCategory.AspectDuChampion;
	}

	@Override
	public boolean availableFor(Unit unit) {
		return unit.is(KeyWord.ChampionDeGallet);
	}

	@Override
	public void decorate(Unit unit) {
		unit.add(this);
	}

	@Override
	public List<RuleType> getTypes() {
		return types;
	}

	@Override
	public String getDescription() {
		return new DescriptionReader().read("Generique/AspectsDuChampion", this);
	}

	@Override
	public String getShortDescription() {
		return shortDesciprion;
	}

}
