package armybuilder.serialisation;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

import org.apache.commons.lang3.StringUtils;

import armybuilder.model.unit.UnitProfile;
import armybuilder.model.unit.keyword.KeyWord;
import armybuilder.model.unit.option.UnitOptionCategory;
import armybuilder.model.unit.role.RoleTactique;

public class EnumPropertyLoader {

	private static class LazyHolder {
		private static EnumPropertyLoader instance = new EnumPropertyLoader();
	}

	private Properties props = new Properties();

	private EnumPropertyLoader() {
		for (String file : Arrays.asList("enums", "Dok", "Nighthaunt", "Skaven", "Stormcast"))
		load(file);
	}

	private void load(String file) {
		try (InputStream is = Thread.currentThread()
				.getContextClassLoader()
				.getResourceAsStream(file + ".properties")) {
			props.load(is);
		} catch (IOException e) {
			throw new IllegalStateException(e);
		}
	}


	public static EnumPropertyLoader instance() {
		return LazyHolder.instance;
	}

	private String props(Enum<?> e, String ext) {
		return props.getProperty(e.getClass().getSimpleName() + "." + e.name() + "." + ext);
	}

	public String name(Enum<?> e) {
		String value = props(e, "name");
		if (value == null) {
			throw new IllegalArgumentException("can't read name for " + e.getClass().getSimpleName() + "." + e.name());
		}
		return value;
	}

	public int pts(Enum<?> e) {
		try {
			return Integer.parseInt(props(e, "pts"));
		} catch (NumberFormatException ex) {
			throw new IllegalArgumentException("can't read pts for " + e.name(), ex);
		}
	}

	public List<RoleTactique> roles(Enum<?> e) {
		return Arrays.stream(props(e, "roles").split(",")).map(RoleTactique::valueOf).toList();
	}

	public UnitProfile profile(Enum<?> e) {
		return UnitProfile.valueOf(props(e, "profile"));
	}

	public List<KeyWord> keywords(Enum<?> e) {
		return Arrays.stream(props(e, "keywords").split(",")).map(KeyWord::valueOf).toList();
	}

	public List<UnitOptionCategory> options(Enum<?> e) {
		return Arrays.stream(props(e, "options").split(","))
				.filter(v -> StringUtils.isNotEmpty(v))
				.map(UnitOptionCategory::valueOf)
				.toList();
	}

}
