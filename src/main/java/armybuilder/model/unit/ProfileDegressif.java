package armybuilder.model.unit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import armybuilder.model.IHaveDisplayName;

public class ProfileDegressif {

	private List<String> titles = new ArrayList<>();
	private List<String[]> lines = new ArrayList<>();

	public ProfileDegressif(String... cols) {
		this.titles.add("Blessures Subies");
		this.titles.addAll(Arrays.asList(cols));
	}

	public ProfileDegressif(IHaveDisplayName... names) {
		this.titles.add("Blessures Subies");
		Arrays.stream(names).forEach(name -> this.titles.add(name.getDisplayName()));
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
