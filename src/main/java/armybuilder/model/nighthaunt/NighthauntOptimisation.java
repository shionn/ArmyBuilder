package armybuilder.model.nighthaunt;

import java.util.function.BiFunction;
import java.util.function.Consumer;

import armybuilder.model.Army;
import armybuilder.model.unit.KeyWord;
import armybuilder.model.unit.Unit;
import armybuilder.model.unit.option.IUnitOptionValue;
import armybuilder.model.unit.option.UnitOption;

public enum NighthauntOptimisation implements IUnitOptionValue<NighthauntOptimisation> {
	// TraisDeCommandement
	DrapeDOmbre(
			UnitOption.TraisDeCommandement,
			(a, u) -> u.is(UnitOption.General) && !u.is(KeyWord.Unique)),
	EntiteTerrifiante(
			UnitOption.TraisDeCommandement,
			(a, u) -> u.is(UnitOption.General) && !u.is(KeyWord.Unique)),
	EspritAmer(
			UnitOption.TraisDeCommandement,
			(a, u) -> u.is(UnitOption.General) && !u.is(KeyWord.Unique)),
	EspritPersistant(
			UnitOption.TraisDeCommandement,
			(a, u) -> u.is(UnitOption.General) && !u.is(KeyWord.Unique)),
	HaineDesVivants(
			UnitOption.TraisDeCommandement,
			(a, u) -> u.is(UnitOption.General) && !u.is(KeyWord.Unique)),
	MaitreDesOstsDEsprits(
			UnitOption.TraisDeCommandement,
			(a, u) -> u.is(UnitOption.General) && !u.is(KeyWord.Unique)),

	BrumeSepulcrale(UnitOption.Sort, (a, u) -> u.is(KeyWord.Heros) && u.is(KeyWord.Sorcier)),
	CageAAmes(UnitOption.Sort, (a, u) -> u.is(KeyWord.Heros) && u.is(KeyWord.Sorcier)),
	CanuleSpectrale(UnitOption.Sort, (a, u) -> u.is(KeyWord.Heros) && u.is(KeyWord.Sorcier)),
	DrainDEsprit(UnitOption.Sort, (a, u) -> u.is(KeyWord.Heros) && u.is(KeyWord.Sorcier)),
	FauxGlaneuse(UnitOption.Sort, (a, u) -> u.is(KeyWord.Heros) && u.is(KeyWord.Sorcier)),
	VoleurDeVie(UnitOption.Sort, (a, u) -> u.is(KeyWord.Heros) && u.is(KeyWord.Sorcier)),

	FaucheLesPeines(UnitOption.Artefact, (a, u) -> u.is(KeyWord.Heros) && !u.is(KeyWord.Unique)),
	FilDeLOmbre(UnitOption.Artefact, (a, u) -> u.is(KeyWord.Heros) && !u.is(KeyWord.Unique)),
	Inciseur(UnitOption.Artefact, (a, u) -> u.is(KeyWord.Heros) && !u.is(KeyWord.Unique)),
	JugementDuBourreau(UnitOption.Artefact, (a, u) -> u.is(KeyWord.Heros) && !u.is(KeyWord.Unique)),
	LameDeFeuMaudit(UnitOption.Artefact, (a, u) -> u.is(KeyWord.Heros) && !u.is(KeyWord.Unique)),
	LameStridente(UnitOption.Artefact, (a, u) -> u.is(KeyWord.Heros) && !u.is(KeyWord.Unique)),

	// Composition
	Dreadwarden(UnitOption.Chef, (a, u) -> u.is(NighthauntUnitModel.ChainraspHorde)),
	TambourDArythmie(UnitOption.Chef, (a, u) -> u.is(NighthauntUnitModel.GlaivewraithStalkers)),
	VarclavLeCruel(UnitOption.Chef, (a, u) -> u.is(NighthauntUnitModel.ThornsOfTheBriarQueen)),

	;

	private String displayName;
	private UnitOption option;
	private BiFunction<Army, Unit, Boolean> available;
	private Consumer<Unit> modifier;

	private NighthauntOptimisation(String displayName, UnitOption option,
			BiFunction<Army, Unit, Boolean> available, Consumer<Unit> modifier) {
		this.displayName = displayName;
		this.option = option;
		this.available = available;
		this.modifier = modifier;
	}

	private NighthauntOptimisation(UnitOption option, BiFunction<Army, Unit, Boolean> available) {
		this.displayName = NighthauntRule.valueOf(name()).getDisplayName();
		this.option = option;
		this.available = available;
	}

	@Override
	public String getDisplayName() {
		return "Nighthaunt : " + displayName;
	}

	@Override
	public UnitOption getOption() {
		return option;
	}

	@Override
	public boolean isAvailable(Army army, Unit unit) {
		return available.apply(army, unit);
	}

	@Override
	public void rebuild(Unit unit) {
		if (modifier == null) {
			unit.add(NighthauntRule.valueOf(name()));
		} else {
			modifier.accept(unit);
		}
	}
}