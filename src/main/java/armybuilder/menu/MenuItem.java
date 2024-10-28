package armybuilder.menu;

import java.util.List;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class MenuItem {

	private final String name;
	private final int id;
	private final List<MenuItem> children;

}
