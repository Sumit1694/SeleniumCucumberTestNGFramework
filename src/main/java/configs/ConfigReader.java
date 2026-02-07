package configs;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public final class ConfigReader {

	private static final Properties properties = new Properties();

	private ConfigReader() {}

	static {
		try {
			InputStream input = ConfigReader.class.getClassLoader().getResourceAsStream("global.properties");

			if(input==null)
			{
				throw new RuntimeException("global.properties not found in src/test/resources");
			}
			properties.load(input);

		}catch(IOException e) {
			throw new RuntimeException("Failed to load global.properties", e);
		}
	}

	public static String getBrowser() {

	    // 1️⃣ From ThreadLocal (XML execution)
	    String browser = BrowserContext.getBrowser();
	    if (browser != null && !browser.trim().isEmpty()) {
	        return browser;
	    }

	    // 2️⃣ Fallback to properties
	    return properties.getProperty("browser");
	}


	public static String getEnv()
	{
		return properties.getProperty("env");
	}

	public static String getUrl()
	{
		String env = getEnv();
		return properties.getProperty(env + "Url");
	}

	public static int getTimeout()
	{
		return Integer.parseInt(properties.getProperty("timeout"));
	}

	public static String getProperty(String key,String defaultValue)
	{
		return properties.getProperty(key, defaultValue);
	}

}
