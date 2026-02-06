package base;

import org.openqa.selenium.WebDriver;

public final class DriverFactory {

	private DriverFactory() {}

	private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

	public static WebDriver getDriver()
	{
		return driver.get();
	}

	public static void setDriver(WebDriver driverInstance)
	{
		driver.set(driverInstance);
	}

	public static void removeDriver()
	{
		driver.remove();
	}

}
