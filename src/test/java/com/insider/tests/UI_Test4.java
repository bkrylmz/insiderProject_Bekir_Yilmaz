package com.insider.tests;

import com.insider.pages.UseInsiderPage;
import com.insider.utilities.BrowserUtils;
import com.insider.utilities.ConfigurationReader;
import com.insider.utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertTrue;


public class UI_Test4 extends UseInsiderPage {
    private WebDriver driver;

    @BeforeMethod
    public void setupMethod() {
        Driver.getDriver().get(ConfigurationReader.getProperty("qapage"));

    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        BrowserUtils.takeScreenshot(Driver.getDriver(), result);
    }

    // Test Automation
    // 4. Check that all jobs’ Position contains “Quality Assurance”, Department contains “Quality Assurance”,
    // and Location contains “Istanbul, Turkey”

    // Test failed. Because There is a bug. Software QA Tester Insider Testinium TechHub_RemotePosition
    // is not contain "Quality Assurance", it just contains "QA"
    // At the bottom of the console, you can find the location where the screenshot is saved. "Screenshot saved to: ..."
    @Test
    public void test4() {

        onlyNecessaryCookies.click();
        seeAllQaJobs.click();
        BrowserUtils.waitForClickablility(filterByLocationDropDown, 5);

        Select select1 = new Select(filterByLocationDropDown);
        select1.selectByVisibleText("Istanbul, Turkey");

        Select select2 = new Select(filterByDepartmentDropDown);
        select2.selectByVisibleText("Quality Assurance");

        BrowserUtils.scroolToElement(seniorSoftwareQualityAssuranceEngineer_RemotePosition);
        BrowserUtils.waitForVisibility(seniorSoftwareQualityAssuranceEngineer_RemotePosition, 5);

        assertTrue(seniorSoftwareQualityAssuranceEngineer_RemotePosition.toString().contains("Quality Assurance"));
        assertTrue(softwareQaTesterInsiderTestiniumTechHub_RemotePosition.toString().contains("Quality Assurance"));//there is a bug it is not "Quality Assurance" it just contains "QA"
        assertTrue(softwareQualityAssuranceEngineer_RemotePosition.toString().contains("Quality Assurance"));

        assertTrue(seniorSoftware_QaDepartments.toString().contains("Quality Assurance"));
        assertTrue(insiderSoftware_QaDepartments.toString().contains("Quality Assurance"));
        assertTrue(software_QaDepartments.toString().contains("Quality Assurance"));

        assertTrue(seniorSoftware_QaLocation.toString().contains("Istanbul, Turkey"));
        assertTrue(insiderSoftware_QaLocation.toString().contains("Istanbul, Turkey"));
        assertTrue(software_QaLocation.toString().contains("Istanbul, Turkey"));
    }

}





