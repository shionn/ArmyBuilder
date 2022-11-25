package armybuilder.serialisation;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class EnumPropertyLoader {

	private static class LazyHolder {
		private static EnumPropertyLoader instance = new EnumPropertyLoader();
	}

	private Properties props = new Properties();

	private EnumPropertyLoader() {
		try (InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream("enums.properties")) {
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

}
