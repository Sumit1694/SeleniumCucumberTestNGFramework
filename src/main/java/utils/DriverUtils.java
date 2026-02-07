package utils;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import base.DriverFactory;

public final class DriverUtils {

    private DriverUtils() {}

    /* ---------- Internal Driver Access ---------- */

    private static WebDriver driver() {
        return DriverFactory.getDriver();
    }

    /* ---------- Browser Info ---------- */

    public static String getTitle() {
        return driver().getTitle();
    }

    public static String getCurrentUrl() {
        return driver().getCurrentUrl();
    }

    /* ---------- Navigation ---------- */

    public static void navigateTo(String url) {
        driver().navigate().to(url);
    }

    public static void refreshPage() {
        driver().navigate().refresh();
    }

    public static void goBack() {
        driver().navigate().back();
    }

    public static void goForward() {
        driver().navigate().forward();
    }

    /* ---------- Frame Handling ---------- */

    public static void switchToFrame(String frameNameOrId) {
        driver().switchTo().frame(frameNameOrId);
    }

    public static void switchToFrame(WebElement frameElement) {
        driver().switchTo().frame(frameElement);
    }

    public static void switchToDefaultContent() {
        driver().switchTo().defaultContent();
    }

    /* ---------- Alert Handling ---------- */

    public static Alert switchToAlert() {
        return driver().switchTo().alert();
    }

    public static void acceptAlert() {
        driver().switchTo().alert().accept();
    }

    public static void dismissAlert() {
        driver().switchTo().alert().dismiss();
    }

    public static String getAlertText() {
        return driver().switchTo().alert().getText();
    }

    /* ---------- Window Handling ---------- */

    public static void switchToWindow(String windowHandle) {
        driver().switchTo().window(windowHandle);
    }

    public static String getCurrentWindowHandle() {
        return driver().getWindowHandle();
    }

    /* ---------- Cleanup ---------- */

    public static void quitDriver() {
        if (driver() != null) {
            driver().quit();
            DriverFactory.removeDriver();
        }
    }
}
