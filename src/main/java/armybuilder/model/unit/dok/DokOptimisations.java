package armybuilder.model.unit.dok;

import java.util.function.BiFunction;

import armybuilder.model.Army;
import armybuilder.model.unit.KeyWord;
import armybuilder.model.unit.Unit;
import armybuilder.model.unit.option.IUnitOptionValue;
import armybuilder.model.unit.option.UnitOption;

public enum DokOptimisations implements IUnitOptionValue<DokOptimisations> {

	BainDeSang(
			"Bain de Sang",
			UnitOption.TraisDeCommandement,
			(a, u) -> u.is(UnitOption.General) && !u.is(KeyWord.Unique)
					&& u.is(KeyWord.DaughtersOfKhaine) && u.is(KeyWord.Aelf)),
	OrateurZele(
			"Orateur Zélé",
			UnitOption.TraisDeCommandement,
			(a, u) -> u.is(UnitOption.General) && !u.is(KeyWord.Unique)
					&& u.is(KeyWord.DaughtersOfKhaine) && u.is(KeyWord.Aelf)),
	SacrificateurSanglant(
			"Sacrificateur Sanglant",
			UnitOption.TraisDeCommandement,
			(a, u) -> u.is(UnitOption.General) && !u.is(KeyWord.Unique)
					&& u.is(KeyWord.DaughtersOfKhaine) && u.is(KeyWord.Aelf)),
	BeauteTerrifiante(
			"Beauté Terrifiante",
			UnitOption.TraisDeCommandement,
			(a, u) -> u.is(UnitOption.General) && !u.is(KeyWord.Unique)
					&& u.is(KeyWord.DaughtersOfKhaine) && u.is(KeyWord.Aelf)),
	MaitreDesPoisons(
			"Maître des Poisons",
			UnitOption.TraisDeCommandement,
			(a, u) -> u.is(UnitOption.General) && !u.is(KeyWord.Unique)
					&& u.is(KeyWord.DaughtersOfKhaine) && u.is(KeyWord.Aelf)),
	VraiCroyant(
			"Vrai Croyant",
			UnitOption.TraisDeCommandement,
			(a, u) -> u.is(UnitOption.General) && !u.is(KeyWord.Unique)
					&& u.is(KeyWord.DaughtersOfKhaine) && u.is(KeyWord.Aelf)),

	MaitriseDesArcanes(
			"Maîtrise des Arcanes",
			UnitOption.TraisDeCommandement,
			(a, u) -> u.is(UnitOption.General) && !u.is(KeyWord.Unique)
					&& u.is(KeyWord.BloodwrackMedusa)),
	AnneauxOndulants(
			"Anneaux Ondulants",
			UnitOption.TraisDeCommandement,
			(a, u) -> u.is(UnitOption.General) && !u.is(KeyWord.Unique)
					&& u.is(KeyWord.BloodwrackMedusa)),
	PresenceEffrayante(
			"Présence Effrayante",
			UnitOption.TraisDeCommandement,
			(a, u) -> u.is(UnitOption.General) && !u.is(KeyWord.Unique)
					&& u.is(KeyWord.BloodwrackMedusa)),

	VeteranDeLaCathtrarDhule(
			"Vétéran de la Cathtrar Dhule",
			UnitOption.TraisDeCommandement,
			(a, u) -> u.is(UnitOption.General) && !u.is(KeyWord.Unique)
					&& u.is(KeyWord.MelusaiIronscale)),
	EcaillesImpenetrables(
			"Écailles Impénétrables",
			UnitOption.TraisDeCommandement,
			(a, u) -> u.is(UnitOption.General) && !u.is(KeyWord.Unique)
					&& u.is(KeyWord.MelusaiIronscale)),
	AnimeParLaVengeance(
			"Animé par la Vengeance",
			UnitOption.TraisDeCommandement,
			(a, u) -> u.is(UnitOption.General) && !u.is(KeyWord.Unique)
					&& u.is(KeyWord.MelusaiIronscale)),


	;

	private String displayName;
	private UnitOption option;
	private BiFunction<Army, Unit, Boolean> available;

	DokOptimisations(String displayName, UnitOption type,
			BiFunction<Army, Unit, Boolean> available) {
		this.displayName = displayName;
		this.option = type;
		this.available = available;
	}

	@Override
	public String getDisplayName() {
		return "DoK : " + displayName;
	}

	@Override
	public UnitOption getOption() {
		return option;
	}

	@Override
	public boolean isAvailable(Army army, Unit unit) {
		return available.apply(army, unit);
	}

}
