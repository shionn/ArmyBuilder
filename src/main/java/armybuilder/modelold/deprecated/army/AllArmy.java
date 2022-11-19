package armybuilder.modelold.deprecated.army;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import armybuilder.model.army.Allegiance;

@Component
@SessionScope
public class AllArmy {

	private Allegiance allegiance = Allegiance.DoK;
	private List<OldArmy> armies = Arrays.stream(Allegiance.values()).map(a -> new OldArmy(a))
			.collect(Collectors.toList());

	public void rebuild() {
		current().rebuild();
	}

	public OldArmy current() {
		return armies.stream().filter(a -> a.is(allegiance)).findFirst().orElse(null);
	}

	public void select(Allegiance allegiance) {
		this.allegiance = allegiance;
	}

	public void update(OldArmy army) {
		armies.stream().filter(a -> a.allegiance() == army.allegiance()).findAny().ifPresent(a -> armies.remove(a));
		armies.add(army);
		select(army.allegiance());
	}

}
