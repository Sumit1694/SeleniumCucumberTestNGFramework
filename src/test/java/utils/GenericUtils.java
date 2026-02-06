package utils;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;

public class GenericUtils {

	public WebDriver driver;

	public GenericUtils(WebDriver driver)
	{
		this.driver=driver;
	}

	public void SwitchToChildWindow()
	{
		Set<String> s1 = driver.getWindowHandles();
        Iterator<String> i1 = s1.iterator();
        @SuppressWarnings("unused")
		String parentWindow = i1.next();
        String childWindow = i1.next();
        driver.switchTo().window(childWindow);
	}

}
