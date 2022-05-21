package armybuilder.model.army;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import armybuilder.model.army.option.Allegiance;

@Component
@SessionScope
public class AllArmy {

	private Allegiance allegiance = Allegiance.DoK;
	private List<Army> armies = Arrays.stream(Allegiance.values()).map(a -> new Army(a))
			.collect(Collectors.toList());

	public Army current() {
		return armies.stream().filter(a -> a.is(allegiance)).findFirst().orElse(null);
	}

	public void select(Allegiance allegiance) {
		this.allegiance = allegiance;
	}
}
