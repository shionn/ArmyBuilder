package armybuilder.model.unit.weapon;

public class AlteredWeapon implements IUnitWeapon {

	private IUnitWeapon source;
	private String altAttaque;
	private String attaque;
	private String blesser;
	private String toucher;

	public AlteredWeapon(IUnitWeapon source) {
		this.source = source;
		this.blesser = source.getBlesser();
		this.toucher = source.getToucher();
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
		return attaque;
	}

	public void setAltAttaque(String altAttaque) {
		this.altAttaque = altAttaque;
	}

	@Override
	public String getAltAttaques() {
		return altAttaque;
	}

	@Override
	public String getToucher() {
		return toucher;
	}

	public void toucherAddParrenthesisPlusOne() {
		toucher += "(+1)";
	}

	@Override
	public String getBlesser() {
		return blesser;
	}

	public void blesserAddParrenthesisPlusOne() {
		blesser += "(+1)";
	}

	@Override
	public String getPerf() {
		return source.getPerf();
	}

	@Override
	public String getDegats() {
		return source.getDegats();
	}

	@Override
	public boolean is(IUnitWeapon weapon) {
		return source.is(weapon);
	}

}
