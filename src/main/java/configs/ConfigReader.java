package configs;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import Constants.FrameworkConstants;
import enums.BrowserType;

public final class ConfigReader {

	private static final Properties properties = new Properties();

	private ConfigReader() {}

	static {
		try {
			InputStream input = ConfigReader.class.getClassLoader().getResourceAsStream(FrameworkConstants.CONFIG_FILE_NAME);

			if(input==null)
			{
				throw new RuntimeException("Config file not found: " + FrameworkConstants.CONFIG_FILE_NAME);
			}
			properties.load(input);

		}catch(IOException e) {
			throw new RuntimeException("Failed to load global.properties", e);
		}
	}

	public static BrowserType getBrowserType() {
	    // 1️ From ThreadLocal (XML execution)
	    String browser = BrowserContext.getBrowser();
	    if (browser != null && !browser.trim().isEmpty()) {
	        return BrowserType.valueOf(browser.toUpperCase());
	    }

	    // Fallback to properties
	    String propBrowser = properties.getProperty(FrameworkConstants.BROWSER_KEY, FrameworkConstants.DEFAULT_BROWSER);
	    return BrowserType.valueOf(propBrowser.toUpperCase());
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
