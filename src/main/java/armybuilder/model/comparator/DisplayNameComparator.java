package armybuilder.model.comparator;

import java.util.Comparator;

import armybuilder.model.IHaveDisplayName;

public class DisplayNameComparator implements Comparator<IHaveDisplayName> {

	@Override
	public int compare(IHaveDisplayName o1, IHaveDisplayName o2) {
		return o1.getDisplayName().compareTo(o2.getDisplayName());
	}

}
