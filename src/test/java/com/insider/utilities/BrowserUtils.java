package com.insider.utilities;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;

import java.io.File;


public class BrowserUtils {

    public static void scroolToElement(WebElement element) {

        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);

    }

    public static WebElement waitForVisibility(WebElement element, int timeToWaitInSec) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), timeToWaitInSec);
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    /**
     * Waits for element matching the locator to be visible on the page
     *
     * @param locator
     * @param timeout
     * @return
     */
    public static WebElement waitForVisibility(By locator, int timeout) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), timeout);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    /**
     * Waits for provided element to be clickable
     *
     * @param element
     * @param timeout
     * @return
     */
    public static WebElement waitForClickablility(WebElement element, int timeout) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), timeout);
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    /**
     * Waits for element matching the locator to be clickable
     *
     * @param locator
     * @param timeout
     * @return
     */
    public static WebElement waitForClickablility(By locator, int timeout) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), timeout);
        return wait.until(ExpectedConditions.elementToBeClickable(locator));

    }

    public static void takeScreenshot(WebDriver driver, ITestResult result) {
        if (ITestResult.FAILURE == result.getStatus()) {
            try {
                // Take a screenshot
                TakesScreenshot screenshot = (TakesScreenshot) driver;
                File source = screenshot.getScreenshotAs(OutputType.FILE);

                // save the screenshot
                String fileName = result.getName() + "_" + System.currentTimeMillis() + ".png";
                File target = new File("screenshots/" + fileName);
                FileUtils.copyFile(source, target);
                System.out.println("Screenshot saved to: " + target.getAbsolutePath());
            } catch (Exception e) {
                System.out.println("Failed to take screenshot: " + e.getMessage());
            }
        }
    }


}