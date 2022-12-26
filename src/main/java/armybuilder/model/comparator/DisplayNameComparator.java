package armybuilder.model.comparator;

import java.util.Comparator;

import org.apache.commons.lang3.StringUtils;

import armybuilder.model.IHaveDisplayName;

public class DisplayNameComparator implements Comparator<IHaveDisplayName> {

	@Override
	public int compare(IHaveDisplayName o1, IHaveDisplayName o2) {
		return StringUtils.stripAccents(o1.getDisplayName()).compareTo(StringUtils.stripAccents(o2.getDisplayName()));
	}

}
