package armybuilder;

import armybuilder.v3.model.IHaveDisplayName;
import armybuilder.v3.model.dok.DokRule;

public class EnumGen {
	public static void main(String[] args) {
		for (IHaveDisplayName o : DokRule.values()) {
			System.out.println("DokRule." + o + ".name=" + o.getDisplayName());
		}
	}
}
