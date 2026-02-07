package utils;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.DriverFactory;

public class WaitUtils {

	private final WebDriverWait wait;

	public WaitUtils() {
		WebDriver driver = DriverFactory.getDriver();
		this.wait = new WebDriverWait(driver,Duration.ofSeconds(ConfigReader.getTimeout()));
	}

	public WebElement waitForElement(By locator, WaitStrategy strategy) {

		switch (strategy) {

		case CLICKABLE:return wait.until(ExpectedConditions.elementToBeClickable(locator));

		case VISIBLE: return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

		case PRESENT: return wait.until(ExpectedConditions.presenceOfElementLocated(locator));

		case NONE: return wait.until(ExpectedConditions.presenceOfElementLocated(locator));

		default: throw new IllegalArgumentException("Unsupported wait strategy: " + strategy);
		}
	}

	public String waitForText(By locator, String expectedText) {

		wait.until(ExpectedConditions.textToBePresentInElementLocated(locator, expectedText));
		return DriverFactory.getDriver().findElement(locator).getText().trim();
	}

	public List<WebElement> waitForElements(By locator, WaitStrategy strategy) {

	    switch (strategy) {

	        case VISIBLE:
	            return wait.until(
	                ExpectedConditions.visibilityOfAllElementsLocatedBy(locator)
	            );

	        case CLICKABLE:
	            return wait.until(
	                ExpectedConditions.presenceOfAllElementsLocatedBy(locator)
	            );

	        default:
	            throw new IllegalArgumentException("Invalid wait strategy");
	    }
	}
}