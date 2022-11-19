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

	public String name(Enum<?> e) {
		return props.getProperty(e.getClass().getSimpleName() + "." + e.name() + ".name");
	}

}
