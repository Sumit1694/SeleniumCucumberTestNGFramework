package Constants;

public class FrameworkConstants {

	private FrameworkConstants() {}

	private static final String PROJECT_PATH = System.getProperty("user.dir");

	public static final String CONFIG_FILE_NAME = "global.properties";

	public static final String EXTENT_REPORT_FOLDER = PROJECT_PATH + "/test-output/Extent-Report";

	public static final String SCREENSHOT_PATH = PROJECT_PATH + "/test-output/SparkReport/screenshots/";

	public static final int DEFAULT_TIMEOUT = 10;
	public static final String DEFAULT_BROWSER = "CHROME";

	public static final String BROWSER_KEY = "browser";

	public static final int PAGE_LOAD_TIMEOUT = 30;
}