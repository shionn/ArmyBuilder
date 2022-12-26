package armybuilder.model.nighthaunt;

import java.util.function.Consumer;
import java.util.function.Function;

import armybuilder.model.unit.Unit;
import armybuilder.model.unit.keyword.KeyWord;
import armybuilder.model.unit.option.IUnitOption;
import armybuilder.model.unit.option.UnitOptionCategory;

public enum NighthauntOptimisation implements IUnitOption {
	DrapeDOmbre(UnitOptionCategory.TraisDeCommandement, u -> u.is(UnitOptionCategory.General) && !u.is(KeyWord.Unique)),
	EntiteTerrifiante(UnitOptionCategory.TraisDeCommandement,
			u -> u.is(UnitOptionCategory.General) && !u.is(KeyWord.Unique)),
	EspritAmer(UnitOptionCategory.TraisDeCommandement, u -> u.is(UnitOptionCategory.General) && !u.is(KeyWord.Unique)),
	EspritPersistant(UnitOptionCategory.TraisDeCommandement,
			u -> u.is(UnitOptionCategory.General) && !u.is(KeyWord.Unique)),
	HaineDesVivants(UnitOptionCategory.TraisDeCommandement,
			u -> u.is(UnitOptionCategory.General) && !u.is(KeyWord.Unique)),
	MaitreDesOstsSpectraux(UnitOptionCategory.TraisDeCommandement,
			u -> u.is(UnitOptionCategory.General) && !u.is(KeyWord.Unique)),

	AnneauDuFeuDeLame(UnitOptionCategory.Artefact, u -> u.is(KeyWord.Heros) && !u.is(KeyWord.Unique)),
	CapeDeLaLuneCroissante(UnitOptionCategory.Artefact, u -> u.is(KeyWord.Heros) && !u.is(KeyWord.Unique)),
	EclatDeLuneDesMoissons(UnitOptionCategory.Artefact, u -> u.is(KeyWord.Heros) && !u.is(KeyWord.Unique)),
	FamilierAvide(UnitOptionCategory.Artefact, u -> u.is(KeyWord.Heros) && !u.is(KeyWord.Unique)),
	FanalDeNagashizzar(UnitOptionCategory.Artefact, u -> u.is(KeyWord.Heros) && !u.is(KeyWord.Unique)),
	FaucheLesPeines(UnitOptionCategory.Artefact, u -> u.is(KeyWord.Heros) && !u.is(KeyWord.Unique)),
	FilDeLOmbre(UnitOptionCategory.Artefact, u -> u.is(KeyWord.Heros) && !u.is(KeyWord.Unique)),
	GrimoireDeMinuit(UnitOptionCategory.Artefact,
			u -> u.is(KeyWord.Heros) && u.is(KeyWord.Sorcier) && !u.is(KeyWord.Unique)),
	Inciseur(UnitOptionCategory.Artefact, u -> u.is(KeyWord.Heros) && !u.is(KeyWord.Unique)),
	LanterneDeSorcellumiere(UnitOptionCategory.Artefact,
			u -> u.is(KeyWord.Heros) && u.is(KeyWord.Sorcier) && !u.is(KeyWord.Unique)),
	PendentifDuVentMaussade(UnitOptionCategory.Artefact, u -> u.is(KeyWord.Heros) && !u.is(KeyWord.Unique)),

	BrumeSepulcrale(UnitOptionCategory.Sort, u -> u.is(KeyWord.Heros) && u.is(KeyWord.Sorcier)),
	CageAAmes(UnitOptionCategory.Sort, u -> u.is(KeyWord.Heros) && u.is(KeyWord.Sorcier)),
	CanuleSpectrale(UnitOptionCategory.Sort, u -> u.is(KeyWord.Heros) && u.is(KeyWord.Sorcier)),
	DrainDEsprit(UnitOptionCategory.Sort, u -> u.is(KeyWord.Heros) && u.is(KeyWord.Sorcier)),
	VoleurDeVie(UnitOptionCategory.Sort, u -> u.is(KeyWord.Heros) && u.is(KeyWord.Sorcier)),
	SceauDeShyish(UnitOptionCategory.Sort, u -> u.is(KeyWord.Heros) && u.is(KeyWord.Sorcier)),

	QuesteurDeShyish(UnitOptionCategory.Chef, u -> u.is(KeyWord.FaucheursMornemanes)),

	// Composition
//	Dreadwarden(UnitOptionCategory.Chef, u -> u.is(NighthauntUnitModel.ChainraspHorde)),
//	VarclavLeCruel(UnitOptionCategory.Chef, u -> u.is(NighthauntUnitModel.ThornsOfTheBriarQueen)),
//	TambourDArythmie(UnitOptionCategory.Musicien, u -> u.is(NighthauntUnitModel.GlaivewraithStalkers)),

	;

	private UnitOptionCategory option;
	private Function<Unit, Boolean> available;
	private Consumer<Unit> modifier;

	private NighthauntOptimisation(UnitOptionCategory option, Function<Unit, Boolean> available,
			Consumer<Unit> modifier) {
		this.option = option;
		this.available = available;
		this.modifier = modifier;
	}

	private NighthauntOptimisation(UnitOptionCategory option, Function<Unit, Boolean> available) {
		this.option = option;
		this.available = available;
	}

	@Override
	public UnitOptionCategory getCategory() {
		return option;
	}

	@Override
	public boolean availableFor(Unit unit) {
		return available.apply(unit);
	}

	@Override
	public void decorate(Unit unit) {
		if (modifier == null) {
			unit.add(NighthauntRule.valueOf(name()));
		} else {
			modifier.accept(unit);
		}
	}

	@Override
	public String getDisplayName() {
		return NighthauntRule.valueOf(name()).getDisplayName();
	}
}
