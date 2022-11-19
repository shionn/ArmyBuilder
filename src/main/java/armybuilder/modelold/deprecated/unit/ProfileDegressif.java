package armybuilder.modelold.deprecated.unit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ProfileDegressif {

	private List<String> titles = new ArrayList<>();
	private List<String[]> lines = new ArrayList<>();

	public ProfileDegressif(String... cols) {
		this.titles.add("Blessures Subies");
		this.titles.addAll(Arrays.asList(cols));
	}

	public ProfileDegressif add(String... values) {
		this.lines.add(values);
		return this;
	}

	public List<String> getTitles() {
		return titles;
	}

	public List<String[]> getLines() {
		return lines;
	}
}
