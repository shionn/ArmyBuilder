package armybuilder.modelold.deprecated.nighthaunt;

import java.util.function.Consumer;
import java.util.function.Function;

import armybuilder.model.unit.keyword.KeyWord;
import armybuilder.modelold.deprecated.unit.Unit;
import armybuilder.modelold.deprecated.unit.option.IUnitOptionValue;
import armybuilder.modelold.deprecated.unit.option.UnitOptionCategory;

public enum NighthauntOptimisation implements IUnitOptionValue<NighthauntOptimisation> {
	// TraisDeCommandement
	DrapeDOmbre(
			UnitOptionCategory.TraisDeCommandement,
			u -> u.is(UnitOptionCategory.General) && !u.is(KeyWord.Unique)),
	EntiteTerrifiante(
			UnitOptionCategory.TraisDeCommandement,
			u -> u.is(UnitOptionCategory.General) && !u.is(KeyWord.Unique)),
	EspritAmer(
			UnitOptionCategory.TraisDeCommandement,
			u -> u.is(UnitOptionCategory.General) && !u.is(KeyWord.Unique)),
	EspritPersistant(
			UnitOptionCategory.TraisDeCommandement,
			u -> u.is(UnitOptionCategory.General) && !u.is(KeyWord.Unique)),
	HaineDesVivants(
			UnitOptionCategory.TraisDeCommandement,
			u -> u.is(UnitOptionCategory.General) && !u.is(KeyWord.Unique)),
	MaitreDesOstsDEsprits(
			UnitOptionCategory.TraisDeCommandement,
			u -> u.is(UnitOptionCategory.General) && !u.is(KeyWord.Unique)),
	SeigneurDeLOst(
			UnitOptionCategory.TraisDeCommandement,
			u -> u.is(UnitOptionCategory.General) && !u.is(KeyWord.Unique)
					&& u.is(KeyWord.LOstEmeraude)),

	BrumeSepulcrale(UnitOptionCategory.Sort, u -> u.is(KeyWord.Heros) && u.is(KeyWord.Sorcier)),
	CageAAmes(UnitOptionCategory.Sort, u -> u.is(KeyWord.Heros) && u.is(KeyWord.Sorcier)),
	CanuleSpectrale(UnitOptionCategory.Sort, u -> u.is(KeyWord.Heros) && u.is(KeyWord.Sorcier)),
	DrainDEsprit(UnitOptionCategory.Sort, u -> u.is(KeyWord.Heros) && u.is(KeyWord.Sorcier)),
	FauxGlaneuse(UnitOptionCategory.Sort, u -> u.is(KeyWord.Heros) && u.is(KeyWord.Sorcier)),
	VoleurDeVie(UnitOptionCategory.Sort, u -> u.is(KeyWord.Heros) && u.is(KeyWord.Sorcier)),

	FaucheLesPeines(UnitOptionCategory.Artefact, u -> u.is(KeyWord.Heros) && !u.is(KeyWord.Unique)),
	FilDeLOmbre(UnitOptionCategory.Artefact, u -> u.is(KeyWord.Heros) && !u.is(KeyWord.Unique)),
	Inciseur(UnitOptionCategory.Artefact, u -> u.is(KeyWord.Heros) && !u.is(KeyWord.Unique)),
	JugementDuBourreau(UnitOptionCategory.Artefact, u -> u.is(KeyWord.Heros) && !u.is(KeyWord.Unique)),
	LameDeFeuMaudit(UnitOptionCategory.Artefact, u -> u.is(KeyWord.Heros) && !u.is(KeyWord.Unique)),
	LameStridente(UnitOptionCategory.Artefact, u -> u.is(KeyWord.Heros) && !u.is(KeyWord.Unique)),
	LaLameDuChevalierFelon(
			UnitOptionCategory.Artefact,
			u -> u.is(KeyWord.Heros) && !u.is(KeyWord.Unique) && u.is(KeyWord.KnightOfShrouds)
					&& u.is(KeyWord.LOstEmeraude)),

	// Composition
	Dreadwarden(UnitOptionCategory.Chef, u -> u.is(NighthauntUnitModel.ChainraspHorde)),
	VarclavLeCruel(UnitOptionCategory.Chef, u -> u.is(NighthauntUnitModel.ThornsOfTheBriarQueen)),
	TambourDArythmie(UnitOptionCategory.Musicien, u -> u.is(NighthauntUnitModel.GlaivewraithStalkers)),

	;

	private String displayName;
	private UnitOptionCategory option;
	private Function<Unit, Boolean> available;
	private Consumer<Unit> modifier;

	private NighthauntOptimisation(String displayName, UnitOptionCategory option,
			Function<Unit, Boolean> available, Consumer<Unit> modifier) {
		this.displayName = displayName;
		this.option = option;
		this.available = available;
		this.modifier = modifier;
	}

	private NighthauntOptimisation(UnitOptionCategory option, Function<Unit, Boolean> available) {
		this.displayName = NighthauntRule.valueOf(getName()).getDisplayName();
		this.option = option;
		this.available = available;
	}

	@Override
	public String getDisplayName() {
		return "Nighthaunt : " + displayName;
	}

	@Override
	public UnitOptionCategory option() {
		return option;
	}

	@Override
	public boolean isAvailable(Unit unit) {
		return available.apply(unit);
	}

	@Override
	public void rebuild(Unit unit) {
		if (modifier == null) {
			unit.add(NighthauntRule.valueOf(getName()));
		} else {
			modifier.accept(unit);
		}
	}
}
