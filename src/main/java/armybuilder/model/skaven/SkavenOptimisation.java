package armybuilder.model.skaven;

import java.util.function.Consumer;
import java.util.function.Function;

import armybuilder.model.unit.Unit;
import armybuilder.model.unit.keyword.KeyWord;
import armybuilder.model.unit.option.IUnitOption;
import armybuilder.model.unit.option.UnitOptionCategory;

public enum SkavenOptimisation implements IUnitOption {

	// trais de co
	AdversaireSournois(UnitOptionCategory.TraisDeCommandement, u -> u.is(UnitOptionCategory.General)),
	ManipulateurSupreme(
			UnitOptionCategory.TraisDeCommandement,
			u -> u.is(UnitOptionCategory.General) && u.is(KeyWord.Maitreclan)),
	MaitreDeLaMagie(
			UnitOptionCategory.TraisDeCommandement,
			u -> u.is(UnitOptionCategory.General) && u.is(KeyWord.Maitreclan)),
	IntrigantDiabolique(
			UnitOptionCategory.TraisDeCommandement,
			u -> u.is(UnitOptionCategory.General) && u.is(KeyWord.Maitreclan)),
	MutateurAstucieux(
			UnitOptionCategory.TraisDeCommandement,
			u -> u.is(UnitOptionCategory.General) && u.is(KeyWord.ClansMoulder)),
	ModeleurSupreme(
			UnitOptionCategory.TraisDeCommandement,
			u -> u.is(UnitOptionCategory.General) && u.is(KeyWord.ClansMoulder)),
	MaitreDeHorde(
			UnitOptionCategory.TraisDeCommandement,
			u -> u.is(UnitOptionCategory.General) && u.is(KeyWord.ClansMoulder)),
	TueurSansEgal(
			UnitOptionCategory.TraisDeCommandement,
			u -> u.is(UnitOptionCategory.General) && u.is(KeyWord.ClansEshin)),
	MaitreDesOmbres(
			UnitOptionCategory.TraisDeCommandement,
			u -> u.is(UnitOptionCategory.General) && u.is(KeyWord.ClansEshin)),
	AgiliteIncroyable(
			UnitOptionCategory.TraisDeCommandement,
			u -> u.is(UnitOptionCategory.General) && u.is(KeyWord.ClansEshin)),
	VaillanceVermineuse(
			UnitOptionCategory.TraisDeCommandement,
			u -> u.is(UnitOptionCategory.General) && u.is(KeyWord.ClansVerminus)),
	SeigneurSauvage(
			UnitOptionCategory.TraisDeCommandement,
			u -> u.is(UnitOptionCategory.General) && u.is(KeyWord.ClansVerminus)),
	PuissantAlpha(
			UnitOptionCategory.TraisDeCommandement,
			u -> u.is(UnitOptionCategory.General) && u.is(KeyWord.ClansVerminus)),
	SuperviseurDeDestruction(
			UnitOptionCategory.TraisDeCommandement,
			u -> u.is(UnitOptionCategory.General) && u.is(KeyWord.ClansSkryre)),
	CollectionneurEmerite(
			UnitOptionCategory.TraisDeCommandement,
			u -> u.is(UnitOptionCategory.General) && u.is(KeyWord.ClansSkryre)),
	InventeurDerange(
			UnitOptionCategory.TraisDeCommandement,
			u -> u.is(UnitOptionCategory.General) && u.is(KeyWord.ClansSkryre)),
	MaitreDeLaPourritureEtDeLaRuine(
			UnitOptionCategory.TraisDeCommandement,
			u -> u.is(UnitOptionCategory.General) && u.is(KeyWord.ClansPestilens)),
	ArchitecteDeLaMort(
			UnitOptionCategory.TraisDeCommandement,
			u -> u.is(UnitOptionCategory.General) && u.is(KeyWord.ClansPestilens)),
	Scrofuleux(
			UnitOptionCategory.TraisDeCommandement,
			u -> u.is(UnitOptionCategory.General) && u.is(KeyWord.ClansPestilens)),

	// artos
	LeRongeclat(UnitOptionCategory.Artefact, u -> u.is(KeyWord.Maitreclan)),
	Skavenectar(UnitOptionCategory.Artefact, u -> u.is(KeyWord.Maitreclan)),
	SceptreDeSuprematieLegitime(UnitOptionCategory.Artefact, u -> u.is(KeyWord.Maitreclan)),
	FouetDeCrocs(UnitOptionCategory.Artefact, u -> u.is(KeyWord.ClansMoulder)),
	CouronneEnragee(UnitOptionCategory.Artefact, u -> u.is(KeyWord.ClansMoulder)),
	Salecuir(UnitOptionCategory.Artefact, u -> u.is(KeyWord.ClansMoulder)),
	BabioleTenebromagnetique(UnitOptionCategory.Artefact, u -> u.is(KeyWord.ClansEshin)),
	CapeDetaleuse(UnitOptionCategory.Artefact, u -> u.is(KeyWord.ClansEshin)),
	Rongebombe(UnitOptionCategory.Artefact, u -> u.is(KeyWord.ClansEshin)),
	BouclierDeDistraction(UnitOptionCategory.Artefact, u -> u.is(KeyWord.ClansVerminus)),
	ArmureDeMalerouille(UnitOptionCategory.Artefact, u -> u.is(KeyWord.ClansVerminus)),
	CharmeDeMalepierre(UnitOptionCategory.Artefact, u -> u.is(KeyWord.ClansVerminus)),
	ResonateurEsoteriqueAMalepierre(UnitOptionCategory.Artefact, u -> u.is(KeyWord.ClansSkryre)),
	FioleDuFulminateur(UnitOptionCategory.Artefact, u -> u.is(KeyWord.ClansSkryre)),
	LOrbeDAirain(UnitOptionCategory.Artefact, u -> u.is(KeyWord.ClansSkryre)),
	LeFumigatus(UnitOptionCategory.Artefact, u -> u.is(KeyWord.ClansPestilens)),
	CloquepusLeKysteVivant(UnitOptionCategory.Artefact, u -> u.is(KeyWord.ClansPestilens)),
	LameDeCorruption(UnitOptionCategory.Artefact, u -> u.is(KeyWord.ClansPestilens)),

	// sort et priere
	Brulure(UnitOptionCategory.Sort, u -> u.is(KeyWord.PropheteGris)),
	Evasion(UnitOptionCategory.Sort, u -> u.is(KeyWord.PropheteGris)),
	FrenesieMortelle(UnitOptionCategory.Sort, u -> u.is(KeyWord.PropheteGris)),
	PlusPlusPlusDeVilPouvoir(UnitOptionCategory.Sort, u -> u.is(KeyWord.ClansSkryre)),
	ChaineDeMalefoudre(UnitOptionCategory.Sort, u -> u.is(KeyWord.ClansSkryre)),
	BouclierDeMalefoudre(UnitOptionCategory.Sort, u -> u.is(KeyWord.ClansSkryre)),
	PestePeste(UnitOptionCategory.Priere, u -> u.is(KeyWord.ClansPestilens)),
	CrasseCrasse(UnitOptionCategory.Priere, u -> u.is(KeyWord.ClansPestilens)),
	RageRage(UnitOptionCategory.Priere, u -> u.is(KeyWord.ClansPestilens)),

	// armes
	LanceRouillee(
			SkavenWeapons.LanceRouillee.getDisplayName(),
			UnitOptionCategory.Armes,
			u -> u.is(KeyWord.RatsDesClans),
			u -> u.add(SkavenWeapons.LanceRouillee)),
	LameRouillee(
			SkavenWeapons.LameRouillee.getDisplayName(),
			UnitOptionCategory.Armes,
			u -> u.is(KeyWord.RatsDesClans),
			u -> u.add(SkavenWeapons.LameRouillee)),
	FouetDeMalepierre(
			SkavenWeapons.FouetDeMalepierre.getDisplayName(),
			UnitOptionCategory.Armes,
			u -> u.is(KeyWord.MaitreMoulder),
			u -> u.add(SkavenWeapons.FouetDeMalepierre)),
	AttrapeChoses(
			SkavenWeapons.AttrapeChoses.getDisplayName(),
			UnitOptionCategory.Armes,
			u -> u.is(KeyWord.MaitreMoulder),
			u -> u.add(SkavenWeapons.AttrapeChoses)),
	PaireDeLamesFetides(
			SkavenWeapons.PaireDeLamesFetides.getDisplayName(),
			UnitOptionCategory.Armes,
			u -> u.is(KeyWord.MoinesDeLaPeste),
			u -> u.add(SkavenWeapons.PaireDeLamesFetides)),
	LameFetideEtBatonDesPlaies(
			SkavenWeapons.LameFetideEtBatonDesPlaies.getDisplayName(),
			UnitOptionCategory.Armes,
			u -> u.is(KeyWord.MoinesDeLaPeste),
			u -> u.add(SkavenWeapons.LameFetideEtBatonDesPlaies)),

	ColosseProjectil(
			"Projectils",
			UnitOptionCategory.Armes,
			u -> u.is(KeyWord.ColossesDeChoc),
			u -> {
				u.add(SkavenWeapons.BombardesAGlobesToxiques, SkavenWeapons.CanonsRatlings, SkavenWeapons.CoupsDeMassue,
						SkavenWeapons.GanteletsEcorcheurs);
				u.add(SkavenRule.GanteletsEcorcheurs, SkavenRule.ArmureSertieDeMalepierre,
						SkavenRule.BombardesAGlobesToxiques);
			}),
	ColosseMelee("Melees", UnitOptionCategory.Armes, u -> u.is(KeyWord.ColossesDeChoc), u -> {
		u.add(SkavenWeapons.ProjecteursAMaleflamme, SkavenWeapons.CoupsDeMassue, SkavenWeapons.PoingsConcasseurs,
				SkavenWeapons.GanteletsChoc);
		u.add(SkavenRule.TunneliersAPoingsConcasseurs, SkavenRule.GanteletsChoc, SkavenRule.ProjecteursAMaleflamme);
	}),

	// composition
	Maitrecroc(UnitOptionCategory.Chef, u -> u.is(KeyWord.VerminesDeChoc)),
	PorteEtendardDeChoc(UnitOptionCategory.Banniere, u -> u.is(KeyWord.VerminesDeChoc)),
	TambourDeChoc(UnitOptionCategory.Musicien, u -> u.is(KeyWord.VerminesDeChoc)),

	Maitregriffe(UnitOptionCategory.Chef, u -> u.is(KeyWord.RatsDesClans)),
	PorteEtendardDesClans(UnitOptionCategory.Banniere, u -> u.is(KeyWord.RatsDesClans)),
	SonneurDeClocheDesClans(UnitOptionCategory.Musicien, u -> u.is(KeyWord.RatsDesClans)),

	LegatDeLaPeste(UnitOptionCategory.Chef, u -> u.is(KeyWord.MoinesDeLaPeste)),
	IconeDeLentropie(UnitOptionCategory.Banniere, u -> u.is(KeyWord.MoinesDeLaPeste)),
	HerautDeLaPeste(UnitOptionCategory.Musicien, u -> u.is(KeyWord.MoinesDeLaPeste)),

	;

	private String displayName;
	private UnitOptionCategory category;
	private Function<Unit, Boolean> available;
	private Consumer<Unit> decorate;

	private SkavenOptimisation(String displayName, UnitOptionCategory category, Function<Unit, Boolean> available,
			Consumer<Unit> decorate) {
		this.displayName = displayName;
		this.category = category;
		this.available = available;
		this.decorate = decorate;
	}

	private SkavenOptimisation(UnitOptionCategory category, Function<Unit, Boolean> available) {
		this.displayName = SkavenRule.valueOf(name()).getDisplayName();
		this.category = category;
		this.available = available;
	}

	@Override
	public String getDisplayName() {
		return displayName;
	}

	@Override
	public UnitOptionCategory getCategory() {
		return category;
	}

	@Override
	public boolean availableFor(Unit unit) {
		return unit.is(KeyWord.Skavens) && available.apply(unit);
	}

	@Override
	public void decorate(Unit unit) {
		if (decorate == null) {
			unit.add(SkavenRule.valueOf(name()));
		} else {
			decorate.accept(unit);
		}
	}

}
