package armybuilder.model.nighthaunt;

import java.util.function.BiFunction;
import java.util.function.Consumer;

import armybuilder.model.army.OldArmy;
import armybuilder.model.army.option.SubAllegiance;
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
	SeigneurDeLOst(
			UnitOption.TraisDeCommandement,
			(a, u) -> u.is(UnitOption.General) && !u.is(KeyWord.Unique)
					&& a.is(SubAllegiance.LOstEmeraude)),

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
	LaLameDuChevalierFelon(
			UnitOption.Artefact,
			(a, u) -> u.is(KeyWord.Heros) && !u.is(KeyWord.Unique) && u.is(KeyWord.KnightOfShrouds)
					&& a.is(SubAllegiance.LOstEmeraude)),

	// Composition
	Dreadwarden(UnitOption.Chef, (a, u) -> u.is(NighthauntUnitModel.ChainraspHorde)),
	VarclavLeCruel(UnitOption.Chef, (a, u) -> u.is(NighthauntUnitModel.ThornsOfTheBriarQueen)),
	TambourDArythmie(UnitOption.Musicien, (a, u) -> u.is(NighthauntUnitModel.GlaivewraithStalkers)),

	;

	private String displayName;
	private UnitOption option;
	private BiFunction<OldArmy, Unit, Boolean> available;
	private Consumer<Unit> modifier;

	private NighthauntOptimisation(String displayName, UnitOption option,
			BiFunction<OldArmy, Unit, Boolean> available, Consumer<Unit> modifier) {
		this.displayName = displayName;
		this.option = option;
		this.available = available;
		this.modifier = modifier;
	}

	private NighthauntOptimisation(UnitOption option, BiFunction<OldArmy, Unit, Boolean> available) {
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
	public boolean isAvailable(OldArmy army, Unit unit) {
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
