package armybuilder.modelold.deprecated.dok;

import java.util.function.Consumer;
import java.util.function.Function;

import armybuilder.model.dok.DokRule;
import armybuilder.model.dok.DokUnitModel;
import armybuilder.model.dok.DokUnitWeapon;
import armybuilder.model.unit.keyword.KeyWord;
import armybuilder.model.unit.option.UnitOptionCategory;
import armybuilder.modelold.deprecated.unit.Unit;
import armybuilder.modelold.deprecated.unit.option.IUnitOptionValue;

public enum DokOptimisations implements IUnitOptionValue<DokOptimisations> {

	// TraisDeCommandement
	BainDeSang(UnitOptionCategory.TraisDeCommandement, u -> u.is(UnitOptionCategory.General) && !u.is(KeyWord.Unique)),
	MaitriseDesArcanes(
			UnitOptionCategory.TraisDeCommandement,
			u -> u.is(UnitOptionCategory.General) && !u.is(KeyWord.Unique) && u.is(KeyWord.Sorcier),
			u -> {
				u.add(DokRule.MaitriseDesArcanes);
				u.add(DokRule.Affaiblissement);
				u.add(DokRule.DanseSymetrique);
				u.add(DokRule.DestrierDOmbres);
				u.add(DokRule.PuitsDeTenebres);
				u.add(DokRule.RasoirMental);
				u.add(DokRule.SuaireDeDesespoir);
			}),
	MaitreDesPoisons(UnitOptionCategory.TraisDeCommandement, u -> u.is(UnitOptionCategory.General) && !u.is(KeyWord.Unique)),
	OrateurZele(UnitOptionCategory.TraisDeCommandement, u -> u.is(UnitOptionCategory.General) && !u.is(KeyWord.Unique)),
	PousseParLaVengeance(
			UnitOptionCategory.TraisDeCommandement,
			u -> u.is(UnitOptionCategory.General) && u.is(DokUnitModel.MelusaiIronscale)),
	SacrificateurSanglant(UnitOptionCategory.TraisDeCommandement, u -> u.is(UnitOptionCategory.General) && !u.is(KeyWord.Unique)),
	VraiCroyant(UnitOptionCategory.TraisDeCommandement, u -> u.is(UnitOptionCategory.General) && !u.is(KeyWord.Unique)),

	// Artefact
	CoeurDeCristal(UnitOptionCategory.Artefact, u -> u.is(KeyWord.Heros) && !u.is(KeyWord.Unique) && u.is(KeyWord.Sorcier)),
	CouronneDeDouleur(UnitOptionCategory.Artefact, u -> u.is(KeyWord.Heros) && !u.is(KeyWord.Unique)),
	LameSorciere(UnitOptionCategory.Artefact, u -> u.is(KeyWord.Heros) && !u.is(KeyWord.Unique)),
	OmbreSeptFoisDrapee(
			UnitOptionCategory.Artefact,
			u -> u.is(KeyWord.Heros) && !u.is(KeyWord.Unique) && u.is(KeyWord.Sorcier)),
	PendentifKhainite(UnitOptionCategory.Artefact, u -> u.is(KeyWord.Heros) && !u.is(KeyWord.Unique) && u.is(KeyWord.Pretre)),
	PierreDOmbre(UnitOptionCategory.Artefact, u -> u.is(KeyWord.Heros) && !u.is(KeyWord.Unique) && u.is(KeyWord.Sorcier)),
	RuneDeKhaine(UnitOptionCategory.Artefact, u -> u.is(KeyWord.Heros) && !u.is(KeyWord.Unique)),
	SymboleSanglant(UnitOptionCategory.Artefact, u -> u.is(KeyWord.Heros) && !u.is(KeyWord.Unique) && u.is(KeyWord.Pretre)),
	VeninFleauDuSang(UnitOptionCategory.Artefact, u -> u.is(KeyWord.Heros) && !u.is(KeyWord.Unique)),

	// sort
	Affaiblissement(UnitOptionCategory.Sort, u -> u.is(KeyWord.Heros) && u.is(KeyWord.Sorcier)),
	DanseSymetrique(UnitOptionCategory.Sort, u -> u.is(KeyWord.Heros) && u.is(KeyWord.Sorcier)),
	DestrierDOmbres(UnitOptionCategory.Sort, u -> u.is(KeyWord.Heros) && u.is(KeyWord.Sorcier)),
	PuitsDeTenebres(UnitOptionCategory.Sort, u -> u.is(KeyWord.Heros) && u.is(KeyWord.Sorcier)),
	RasoirMental(UnitOptionCategory.Sort, u -> u.is(KeyWord.Heros) && u.is(KeyWord.Sorcier)),
	SuaireDeDesespoir(UnitOptionCategory.Sort, u -> u.is(KeyWord.Heros) && u.is(KeyWord.Sorcier)),

	// priere
	BenedictionDeKhaine(UnitOptionCategory.Priere, u -> u.is(KeyWord.Heros) && u.is(KeyWord.Pretre)),
	CatechismeDuMeurtre(UnitOptionCategory.Priere, u -> u.is(KeyWord.Heros) && u.is(KeyWord.Pretre)),
	CouventDuCoeurDeFer(UnitOptionCategory.Priere, u -> u.is(KeyWord.Heros) && u.is(KeyWord.Pretre)),
	SacreDeSang(UnitOptionCategory.Priere, u -> u.is(KeyWord.Heros) && u.is(KeyWord.Pretre)),
	SacrificeDuMartyr(UnitOptionCategory.Priere, u -> u.is(KeyWord.Heros) && u.is(KeyWord.Pretre)),
	ResurrectionPourpre(UnitOptionCategory.Priere, u -> u.is(KeyWord.Heros) && u.is(KeyWord.Pretre)),

	// Compositioon
	Ecorcheuse("Champion", UnitOptionCategory.Chef, u -> u.is(KeyWord.EtripeusesKhinerai), null),
	Matriache("Champion", UnitOptionCategory.Chef, u -> u.is(KeyWord.Erinyes), null),
	PorteuseDePennonDeMort("Porte-Étendards", UnitOptionCategory.Banniere,
			u -> u.is(KeyWord.Erinyes) || u.is(KeyWord.SoeurDuMassacre), null),
	Servante("Champion", UnitOptionCategory.Chef, u -> u.is(KeyWord.SoeurDuMassacre), null),
	SonneuseDeCor("Musiciennes", UnitOptionCategory.Musicien,
			u -> u.is(KeyWord.Erinyes) || u.is(KeyWord.SoeurDuMassacre), null),

	// Armes
	SciansaAppairees("Sciansá Appairées", UnitOptionCategory.Armes, u -> u.is(KeyWord.Erinyes),
			u -> u.add(DokUnitWeapon.SciansaAppairees)),
	SciansaEtRondacheTranchante("Sciansá et Rondache Tranchante", UnitOptionCategory.Armes, u -> u.is(KeyWord.Erinyes),
			u -> {
				u.add(DokUnitWeapon.Sciansa);
				u.add(DokRule.RondacheTranchante);
			}),
	FouetBarbeleEtRondacheTranchante("Fouet Barbelé et Rondache Tranchante", UnitOptionCategory.Armes,
			u -> u.is(KeyWord.SoeurDuMassacre), u -> u.add(DokRule.RondacheTranchante)),
	FouetBarbeleEtCouteauSacrificiel("Fouet Barbelé et Couteau Sacrificiel", UnitOptionCategory.Armes,
			u -> u.is(KeyWord.SoeurDuMassacre), u -> u.add(DokUnitWeapon.CouteauxSacrificiel)),

	// ---- fait au dessus

	// Compositioon
	Krone("Krone", UnitOptionCategory.Chef, u -> u.is(DokUnitModel.BloodStalkers), u -> {
		u.add(DokRule.Krone);
		u.add(DokUnitWeapon.GuivreDeSang);
	}),
	Gorgai("Gorgaï", UnitOptionCategory.Chef, u -> u.is(DokUnitModel.BloodSisters), null),
	ShroudQueen("Shroud Queen", UnitOptionCategory.Chef, u -> u.is(KeyWord.RodeursDeLOmbre), u -> {
		u.add(DokUnitWeapon.LameObscures);
		u.add(DokRule.ShroudQueen);
	}),


	;

	private String displayName;
	private UnitOptionCategory option;
	private Function<Unit, Boolean> available;
	private Consumer<Unit> modifier;

	DokOptimisations(String displayName, UnitOptionCategory type, Function<Unit, Boolean> available, Consumer<Unit> modifier) {
		this.displayName = displayName;
		this.option = type;
		this.available = available;
		this.modifier = modifier;
	}

	DokOptimisations(UnitOptionCategory type, Function<Unit, Boolean> available, Consumer<Unit> modifier) {
		this(type, available);
		this.modifier = modifier;
	}

	DokOptimisations(UnitOptionCategory type, Function<Unit, Boolean> available) {
		this.displayName = DokRule.valueOf(name()).getDisplayName();
		this.option = type;
		this.available = available;
	}

	@Override
	public String getDisplayName() {
		return displayName;
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
			unit.add(DokRule.valueOf(getName()));
		} else {
			modifier.accept(unit);
		}
	}

}
