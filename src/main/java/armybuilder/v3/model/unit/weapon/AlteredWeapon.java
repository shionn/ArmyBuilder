package armybuilder.v3.model.unit.weapon;

public class AlteredWeapon implements IUnitWeapon {

	private IUnitWeapon source;
	private String altAttaques;
	private String altBlesser;
	private String altToucher;
	private String altDegats;

	public AlteredWeapon(IUnitWeapon source) {
		this.source = source;
	}

	@Override
	public String getDisplayName() {
		return source.getDisplayName();
	}

	@Override
	public WeaponType getType() {
		return source.getType();
	}

	@Override
	public String getPortee() {
		return source.getPortee();
	}

	@Override
	public String getAttaques() {
		String attaques = source.getAttaques();
		if (altAttaques != null) {
			attaques += "<small> (" + altAttaques + ")</small>";
		}
		return attaques;
	}

	public void setAltAttaques(String altAttaque) {
		this.altAttaques = altAttaque;
	}

	@Override
	public String getToucher() {
		String toucher = source.getToucher();
		if (altToucher != null) {
			toucher += "<small> (" + altToucher + ")</small>";
		}
		return toucher;
	}

	public void setAltToucher(String altToucher) {
		this.altToucher = altToucher;
	}

	@Override
	public String getBlesser() {
		String blesser = source.getBlesser();
		if (altBlesser != null) {
			blesser += "<small> (" + altBlesser + ")</small>";
		}
		return blesser;
	}

	public void setAltBlesser(String altBlesser) {
		this.altBlesser = altBlesser;
	}

	@Override
	public String getPerf() {
		return source.getPerf();
	}

	public void setAltDegats(String altDegats) {
		this.altDegats = altDegats;
	}

	@Override
	public String getDegats() {
		String degat = source.getDegats();
		if (altDegats != null) {
			degat += "<small> (" + altDegats + ")</small>";
		}
		return degat;
	}

	@Override
	public boolean is(IUnitWeapon weapon) {
		return source.is(weapon);
	}

}
