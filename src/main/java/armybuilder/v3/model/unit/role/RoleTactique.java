package armybuilder.v3.model.unit.role;

public enum RoleTactique {
	Leader, Ligne, Elite, Behemoth, Artillerie, SortsPersistantsEtInvocation, TerrainDeFaction,;

	public String getDisplayName() {
		// TODO displayname depuis enum
		return name();
	}
}
