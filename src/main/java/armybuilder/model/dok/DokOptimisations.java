package armybuilder.model.dok;

import java.util.function.Consumer;
import java.util.function.Function;

import armybuilder.model.unit.KeyWord;
import armybuilder.model.unit.Unit;
import armybuilder.model.unit.option.IUnitOptionValue;
import armybuilder.model.unit.option.UnitOption;

public enum DokOptimisations implements IUnitOptionValue<DokOptimisations> {

	// TraisDeCommandement
	BainDeSang(UnitOption.TraisDeCommandement, u -> u.is(UnitOption.General) && !u.is(KeyWord.Unique)),
	MaitriseDesArcanes(
			UnitOption.TraisDeCommandement,
			u -> u.is(UnitOption.General) && !u.is(KeyWord.Unique) && u.is(KeyWord.Sorcier),
			u -> {
				u.add(DokRule.MaitriseDesArcanes);
				u.add(DokRule.Affaiblissement);
				u.add(DokRule.DanseSymetrique);
				u.add(DokRule.DestrierDOmbres);
				u.add(DokRule.PuitsDeTenebres);
				u.add(DokRule.RasoirMental);
				u.add(DokRule.SuaireDeDesespoir);
			}),
	MaitreDesPoisons(UnitOption.TraisDeCommandement, u -> u.is(UnitOption.General) && !u.is(KeyWord.Unique)),
	OrateurZele(UnitOption.TraisDeCommandement, u -> u.is(UnitOption.General) && !u.is(KeyWord.Unique)),
	PousseParLaVengeance(
			UnitOption.TraisDeCommandement,
			u -> u.is(UnitOption.General) && u.is(DokUnitModel.MelusaiIronscale)),
	SacrificateurSanglant(UnitOption.TraisDeCommandement, u -> u.is(UnitOption.General) && !u.is(KeyWord.Unique)),
	VraiCroyant(UnitOption.TraisDeCommandement, u -> u.is(UnitOption.General) && !u.is(KeyWord.Unique)),

	// Artefact
	CoeurDeCristal(UnitOption.Artefact, u -> u.is(KeyWord.Heros) && !u.is(KeyWord.Unique) && u.is(KeyWord.Sorcier)),
	CouronneDeDouleur(UnitOption.Artefact, u -> u.is(KeyWord.Heros) && !u.is(KeyWord.Unique)),
	LameSorciere(UnitOption.Artefact, u -> u.is(KeyWord.Heros) && !u.is(KeyWord.Unique)),
	OmbreSeptFoisDrapee(
			UnitOption.Artefact,
			u -> u.is(KeyWord.Heros) && !u.is(KeyWord.Unique) && u.is(KeyWord.Sorcier)),
	PendentifKhainite(UnitOption.Artefact, u -> u.is(KeyWord.Heros) && !u.is(KeyWord.Unique) && u.is(KeyWord.Pretre)),
	PierreDOmbre(UnitOption.Artefact, u -> u.is(KeyWord.Heros) && !u.is(KeyWord.Unique) && u.is(KeyWord.Sorcier)),
	RuneDeKhaine(UnitOption.Artefact, u -> u.is(KeyWord.Heros) && !u.is(KeyWord.Unique)),
	SymboleSanglant(UnitOption.Artefact, u -> u.is(KeyWord.Heros) && !u.is(KeyWord.Unique) && u.is(KeyWord.Pretre)),
	VeninFleauDuSang(UnitOption.Artefact, u -> u.is(KeyWord.Heros) && !u.is(KeyWord.Unique)),

	// sort
	Affaiblissement(UnitOption.Sort, u -> u.is(KeyWord.Heros) && u.is(KeyWord.Sorcier)),
	DanseSymetrique(UnitOption.Sort, u -> u.is(KeyWord.Heros) && u.is(KeyWord.Sorcier)),
	DestrierDOmbres(UnitOption.Sort, u -> u.is(KeyWord.Heros) && u.is(KeyWord.Sorcier)),
	PuitsDeTenebres(UnitOption.Sort, u -> u.is(KeyWord.Heros) && u.is(KeyWord.Sorcier)),
	RasoirMental(UnitOption.Sort, u -> u.is(KeyWord.Heros) && u.is(KeyWord.Sorcier)),
	SuaireDeDesespoir(UnitOption.Sort, u -> u.is(KeyWord.Heros) && u.is(KeyWord.Sorcier)),

	// priere
	BenedictionDeKhaine(UnitOption.Priere, u -> u.is(KeyWord.Heros) && u.is(KeyWord.Pretre)),
	CatechismeDuMeurtre(UnitOption.Priere, u -> u.is(KeyWord.Heros) && u.is(KeyWord.Pretre)),
	CouventDuCoeurDeFer(UnitOption.Priere, u -> u.is(KeyWord.Heros) && u.is(KeyWord.Pretre)),
	SacreDeSang(UnitOption.Priere, u -> u.is(KeyWord.Heros) && u.is(KeyWord.Pretre)),
	SacrificeDuMartyr(UnitOption.Priere, u -> u.is(KeyWord.Heros) && u.is(KeyWord.Pretre)),
	ResurrectionPourpre(UnitOption.Priere, u -> u.is(KeyWord.Heros) && u.is(KeyWord.Pretre)),

	// Compositioon
	Ecorcheuse("Champion", UnitOption.Chef, u -> u.is(KeyWord.EtripeusesKhinerai), null),
	Matriache("Champion", UnitOption.Chef, u -> u.is(KeyWord.Erinyes), null),
	PorteuseDePennonDeMort("Porte-Étendards", UnitOption.Banniere,
			u -> u.is(KeyWord.Erinyes) || u.is(KeyWord.SoeurDuMassacre), null),
	Servante("Champion", UnitOption.Chef, u -> u.is(KeyWord.SoeurDuMassacre), null),
	SonneuseDeCor("Musiciennes", UnitOption.Musicien,
			u -> u.is(KeyWord.Erinyes) || u.is(KeyWord.SoeurDuMassacre), null),

	// Armes
	SciansaAppairees("Sciansá Appairées", UnitOption.Armes, u -> u.is(KeyWord.Erinyes),
			u -> u.add(DokUnitWeapon.SciansaAppairees)),
	SciansaEtRondacheTranchante("Sciansá et Rondache Tranchante", UnitOption.Armes, u -> u.is(KeyWord.Erinyes),
			u -> {
				u.add(DokUnitWeapon.Sciansa);
				u.add(DokRule.RondacheTranchante);
			}),
	FouetBarbeleEtRondacheTranchante("Fouet Barbelé et Rondache Tranchante", UnitOption.Armes,
			u -> u.is(KeyWord.SoeurDuMassacre), u -> u.add(DokRule.RondacheTranchante)),
	FouetBarbeleEtCouteauSacrificiel("Fouet Barbelé et Couteau Sacrificiel", UnitOption.Armes,
			u -> u.is(KeyWord.SoeurDuMassacre), u -> u.add(DokUnitWeapon.CouteauxSacrificiel)),

	// ---- fait au dessus

	// Compositioon
	Krone("Krone", UnitOption.Chef, u -> u.is(DokUnitModel.BloodStalkers), u -> {
		u.add(DokRule.Krone);
		u.add(DokUnitWeapon.GuivreDeSang);
	}),
	Gorgai("Gorgaï", UnitOption.Chef, u -> u.is(DokUnitModel.BloodSisters), null),
	ShroudQueen("Shroud Queen", UnitOption.Chef, u -> u.is(KeyWord.RodeursDeLOmbre), u -> {
		u.add(DokUnitWeapon.LameObscures);
		u.add(DokRule.ShroudQueen);
	}),


	;

	private String displayName;
	private UnitOption option;
	private Function<Unit, Boolean> available;
	private Consumer<Unit> modifier;

	DokOptimisations(String displayName, UnitOption type, Function<Unit, Boolean> available, Consumer<Unit> modifier) {
		this.displayName = displayName;
		this.option = type;
		this.available = available;
		this.modifier = modifier;
	}

	DokOptimisations(UnitOption type, Function<Unit, Boolean> available, Consumer<Unit> modifier) {
		this(type, available);
		this.modifier = modifier;
	}

	DokOptimisations(UnitOption type, Function<Unit, Boolean> available) {
		this.displayName = DokRule.valueOf(name()).displayName();
		this.option = type;
		this.available = available;
	}

	@Override
	public String displayName() {
		return displayName;
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
			unit.add(DokRule.valueOf(name()));
		} else {
			modifier.accept(unit);
		}
	}

}
