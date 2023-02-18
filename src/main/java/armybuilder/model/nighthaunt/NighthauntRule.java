package armybuilder.model.nighthaunt;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

import armybuilder.model.rule.IRule;
import armybuilder.model.rule.RuleType;
import armybuilder.model.unit.Unit;
import armybuilder.serialisation.DescriptionReader;
import armybuilder.serialisation.EnumPropertyLoader;

public enum NighthauntRule implements IRule<NighthauntRule> {
	ApparitionsInstables(RuleType.TraisDeBataille),
	AuraDEffroi(RuleType.TraisDeBataille, RuleType.Aura, RuleType.PhaseDeDeroute),
	Etheres(RuleType.TraisDeBataille),
	VagueDeTerreur(RuleType.TraisDeBataille, RuleType.PhaseDeCharge),
	ToucherEffroyable(RuleType.TraisDeBataille, RuleType.PhaseDeCombat),

	ArtisansDUneMortEffroyable(RuleType.TraisDeBataille),
	EntrainesDansLaTombe(RuleType.TraisDeBataille),
	LaMaledictionEmeraude(RuleType.TraisDeBataille),
	VortexDeViolenceFrenetique(RuleType.TraisDeBataille),

	DrapeDOmbre(RuleType.TraitsDeCommandement),
	EntiteTerrifiante(RuleType.TraitsDeCommandement, RuleType.Aura),
	EspritAmer(RuleType.TraitsDeCommandement),
	EspritPersistant(RuleType.TraitsDeCommandement),
	HaineDesVivants(RuleType.TraitsDeCommandement),
	MaitreDesOstsSpectraux(RuleType.TraitsDeCommandement),

	SubmergesParLEffroi(RuleType.TactiquesDeBataille),
	MareesDeTerreur(RuleType.TactiquesDeBataille),
	PaniqueDeMasse(RuleType.TactiquesDeBataille),
	LaMortParUnMillierDeCoupures(RuleType.TactiquesDeBataille),
	UnAllerSimple(RuleType.TactiquesDeBataille),
	CauchemarsIncessants(RuleType.TactiquesDeBataille),

	Incorporels(RuleType.AptitudesDeCommandement, RuleType.PhaseDeTir, RuleType.PhaseDeCombat),

	AnneauDuFeuDeLame(RuleType.Artefact, RuleType.PhaseDeCombatFin),
	CapeDeLaLuneCroissante(RuleType.Artefact),
	EclatDeLuneDesMoissons(RuleType.Artefact),
	FamilierAvide(RuleType.Artefact),
	FanalDeNagashizzar(RuleType.Artefact, RuleType.PhaseDesHeros),
	FaucheLesPeines(RuleType.Artefact),
	FilDeLOmbre(RuleType.Artefact),
	GrimoireDeMinuit(RuleType.Artefact),
	Inciseur(RuleType.Artefact),
	LanterneDeSorcellumiere(RuleType.Artefact),
	PendentifDuVentMaussade(RuleType.Artefact),

	BrumeSepulcrale(RuleType.Sort),
	CageAAmes(RuleType.Sort),
	CanuleSpectrale(RuleType.Sort),
	DrainDEsprit(RuleType.Sort),
	LeurreSpectral(RuleType.Sort),
	VoleurDeVie(RuleType.Sort),
	TempeteSpectrale(RuleType.Sort),
	SceauDeShyish(RuleType.Sort),
	SuaireDeDesespoir(RuleType.Sort),

	AttireesParLaGuerre(RuleType.Aptitude),
	BougiesDeCadavre(RuleType.Aptitude),
	BougiesSorcieres(RuleType.Aptitude),
	ChasseursSpectraux(RuleType.Aptitude),
	CondamnationALEternelTourment(RuleType.Aptitude),
	ContremaitreSpectral(RuleType.Aptitude),
	CranesDesincarnes(RuleType.Aptitude),
	Dematerialisation(RuleType.Aptitude),
	EnergieDAmesCaptives(RuleType.Aptitude),
	FauchesCommeLesBles(RuleType.Aptitude),
	FaireFaceALaMort(RuleType.Aptitude, RuleType.PhaseDeCombatDebut),
	HeuresVolees(
			u -> u.alter(NighthauntUnitWeapon.EpeeDesHeuresVolees, w -> w.setAltBlesser("+1")),
			RuleType.Aptitude,
			RuleType.PhaseDeCombatFin),
	HordeEffroyable(
			u -> u.alter(NighthauntUnitWeapon.ArmeDeMalfaisant, w -> w.setAltBlesser("+1")),
			RuleType.Aptitude,
			RuleType.PhaseDeCombat),
	HurlementFunebre(RuleType.Aptitude),
	HurlementPerturbant(RuleType.Aptitude, RuleType.PhaseDeCombat),
	JusticeFuneste(RuleType.Aptitude),
	LanterneDeCauchemar(RuleType.Aptitude, RuleType.Aura),
	LaPointeDeLaMort(RuleType.Aptitude),
	MaledictionDeLoyaute(RuleType.Aptitude),
	MangeSorts(RuleType.Aptitude),
	MortarqueDuDeuil(RuleType.Aptitude),
	MortTourbillonnante(
			u -> u.alter(NighthauntUnitWeapon.GrandeLameDeLaTombe, w -> w.setAltAttaques("+1")),
			RuleType.Aptitude,
			RuleType.PhaseDeCombat),
	PasDeRepitPourLesDamnees(RuleType.Aptitude),
	PourvoyeursDeMortEffrenes(RuleType.Aptitude),
	ProgressionFantomatique(RuleType.Aptitude),
	ReleverLeVoile(RuleType.Aptitude),
	SablesDuTemps(RuleType.Aptitude),
	SeigneurDesSpectres_1(RuleType.Aptitude, RuleType.PhaseDeTir, RuleType.PhaseDeCombat),
	SeigneurDesSpectres_2(RuleType.Aptitude, RuleType.PhaseDeCombat),
	SiJeNePeuxRegnerNulNeLePourra(RuleType.Aptitude),
	SoifDeSangMeurtriere(
			u -> u.alter(NighthauntUnitWeapon.MembresFaucheurs, w -> w.setAltToucher("+1")),
			RuleType.Aptitude,
			RuleType.PhaseDeCombat),
	UnMaillonDeLaChaine(RuleType.Aptitude),

	Affregarde(u -> u.alter(NighthauntUnitWeapon.ArmeDeMalfaisant, w -> w.setAltAttaques("+1")), RuleType.Composition),
	QuesteurDeShyish(u -> u.add(NighthauntUnitWeapon.GlasMortel), RuleType.Composition),
	TambourDArythmie(RuleType.Composition),
	Tailladeuse(u -> u.alter(NighthauntUnitWeapon.MembresFaucheurs, w -> w.setAltAttaques("+1")), RuleType.Composition),
	SpectreInfernal(RuleType.Composition),

	;

	private String displayName;
	private List<RuleType> types;
	private Consumer<Unit> modifier;

	private NighthauntRule(RuleType... types) {
		this.displayName = EnumPropertyLoader.instance().name(this);
		this.types = Arrays.asList(types);
	}

	private NighthauntRule(Consumer<Unit> modifier, RuleType... types) {
		this(types);
		this.modifier = modifier;
	}

	private NighthauntRule(String displayName, RuleType... types) {
		this.displayName = displayName;
		this.types = Arrays.asList(types);
	}

	@Override
	public List<RuleType> getTypes() {
		return types;
	}

	@Override
	public String getDisplayName() {
		return displayName;
	}

	@Override
	public String getDescription() {
		return new DescriptionReader().read(this);
	}

	@Override
	public void decorate(Unit unit) {
		if (modifier != null) {
			modifier.accept(unit);
		}
	}

}
