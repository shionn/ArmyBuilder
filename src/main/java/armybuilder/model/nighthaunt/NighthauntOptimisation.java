package armybuilder.model.nighthaunt;

import java.util.function.Consumer;
import java.util.function.Function;

import armybuilder.model.unit.KeyWord;
import armybuilder.model.unit.Unit;
import armybuilder.model.unit.option.IUnitOptionValue;
import armybuilder.model.unit.option.UnitOption;

public enum NighthauntOptimisation implements IUnitOptionValue<NighthauntOptimisation> {
	// TraisDeCommandement
	DrapeDOmbre(
			UnitOption.TraisDeCommandement,
			u -> u.is(UnitOption.General) && !u.is(KeyWord.Unique)),
	EntiteTerrifiante(
			UnitOption.TraisDeCommandement,
			u -> u.is(UnitOption.General) && !u.is(KeyWord.Unique)),
	EspritAmer(
			UnitOption.TraisDeCommandement,
			u -> u.is(UnitOption.General) && !u.is(KeyWord.Unique)),
	EspritPersistant(
			UnitOption.TraisDeCommandement,
			u -> u.is(UnitOption.General) && !u.is(KeyWord.Unique)),
	HaineDesVivants(
			UnitOption.TraisDeCommandement,
			u -> u.is(UnitOption.General) && !u.is(KeyWord.Unique)),
	MaitreDesOstsDEsprits(
			UnitOption.TraisDeCommandement,
			u -> u.is(UnitOption.General) && !u.is(KeyWord.Unique)),
	SeigneurDeLOst(
			UnitOption.TraisDeCommandement,
			u -> u.is(UnitOption.General) && !u.is(KeyWord.Unique)
					&& u.is(KeyWord.LOstEmeraude)),

	BrumeSepulcrale(UnitOption.Sort, u -> u.is(KeyWord.Heros) && u.is(KeyWord.Sorcier)),
	CageAAmes(UnitOption.Sort, u -> u.is(KeyWord.Heros) && u.is(KeyWord.Sorcier)),
	CanuleSpectrale(UnitOption.Sort, u -> u.is(KeyWord.Heros) && u.is(KeyWord.Sorcier)),
	DrainDEsprit(UnitOption.Sort, u -> u.is(KeyWord.Heros) && u.is(KeyWord.Sorcier)),
	FauxGlaneuse(UnitOption.Sort, u -> u.is(KeyWord.Heros) && u.is(KeyWord.Sorcier)),
	VoleurDeVie(UnitOption.Sort, u -> u.is(KeyWord.Heros) && u.is(KeyWord.Sorcier)),

	FaucheLesPeines(UnitOption.Artefact, u -> u.is(KeyWord.Heros) && !u.is(KeyWord.Unique)),
	FilDeLOmbre(UnitOption.Artefact, u -> u.is(KeyWord.Heros) && !u.is(KeyWord.Unique)),
	Inciseur(UnitOption.Artefact, u -> u.is(KeyWord.Heros) && !u.is(KeyWord.Unique)),
	JugementDuBourreau(UnitOption.Artefact, u -> u.is(KeyWord.Heros) && !u.is(KeyWord.Unique)),
	LameDeFeuMaudit(UnitOption.Artefact, u -> u.is(KeyWord.Heros) && !u.is(KeyWord.Unique)),
	LameStridente(UnitOption.Artefact, u -> u.is(KeyWord.Heros) && !u.is(KeyWord.Unique)),
	LaLameDuChevalierFelon(
			UnitOption.Artefact,
			u -> u.is(KeyWord.Heros) && !u.is(KeyWord.Unique) && u.is(KeyWord.KnightOfShrouds)
					&& u.is(KeyWord.LOstEmeraude)),

	// Composition
	Dreadwarden(UnitOption.Chef, u -> u.is(NighthauntUnitModel.ChainraspHorde)),
	VarclavLeCruel(UnitOption.Chef, u -> u.is(NighthauntUnitModel.ThornsOfTheBriarQueen)),
	TambourDArythmie(UnitOption.Musicien, u -> u.is(NighthauntUnitModel.GlaivewraithStalkers)),

	;

	private String displayName;
	private UnitOption option;
	private Function<Unit, Boolean> available;
	private Consumer<Unit> modifier;

	private NighthauntOptimisation(String displayName, UnitOption option,
			Function<Unit, Boolean> available, Consumer<Unit> modifier) {
		this.displayName = displayName;
		this.option = option;
		this.available = available;
		this.modifier = modifier;
	}

	private NighthauntOptimisation(UnitOption option, Function<Unit, Boolean> available) {
		this.displayName = NighthauntRule.valueOf(name()).displayName();
		this.option = option;
		this.available = available;
	}

	@Override
	public String displayName() {
		return "Nighthaunt : " + displayName;
	}

	@Override
	public UnitOption option() {
		return option;
	}

	@Override
	public boolean isAvailable(Unit unit) {
		return available.apply(unit);
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
