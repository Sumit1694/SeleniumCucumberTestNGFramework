package utils;

import org.openqa.selenium.WebDriver;

public class GenericUtils {

	public WebDriver driver;
	private String ParentWindow;

	public GenericUtils(WebDriver driver)
	{
		this.driver=driver;
	}

	public void SwitchToChildWindow()
	{
		ParentWindow = driver.getWindowHandle();
		for(String window:driver.getWindowHandles())
		{
			if(!window.equals(ParentWindow)) {
				driver.switchTo().window(window);
				break;
			}
		}
	}

	public void switchToParentWindow()
	{
		driver.switchTo().window(ParentWindow);
	}

}
