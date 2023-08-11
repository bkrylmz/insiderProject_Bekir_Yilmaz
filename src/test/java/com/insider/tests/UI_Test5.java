package com.insider.tests;

import com.insider.pages.UseInsiderPage;
import com.insider.utilities.BrowserUtils;
import com.insider.utilities.ConfigurationReader;
import com.insider.utilities.Driver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class UI_Test5 extends UseInsiderPage {
    @BeforeMethod
    public void setupMethod() {
        Driver.getDriver().get(ConfigurationReader.getProperty("qapage"));
    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        BrowserUtils.takeScreenshot(Driver.getDriver(), result);
    }

    // Test Automation
    // 5. Click the “View Role” button and check that this action redirects us to the Lever Application form page

    // Test failed. Because There is a bug. When user click the view role, it does not redirect App Form.
    // at first user clicks “View Role”  and than user needs to click "APPLY FOR THIS JOB" button to redirect App form page
    // At the bottom of the console, you can find the location where the screenshot is saved. "Screenshot saved to: ..."
    @Test
    public void test5() {

        onlyNecessaryCookies.click();
        seeAllQaJobs.click();
        BrowserUtils.waitForClickablility(filterByLocationDropDown, 5);

        Select select1 = new Select(filterByLocationDropDown);
        select1.selectByVisibleText("Istanbul, Turkey");

        Select select2 = new Select(filterByDepartmentDropDown);
        select2.selectByVisibleText("Quality Assurance");

        BrowserUtils.scroolToElement(seniorSoftwareQualityAssuranceEngineer_RemotePosition);
        BrowserUtils.waitForVisibility(seniorSoftwareQualityAssuranceEngineer_RemotePosition, 5);

        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(seniorSoftwareQualityAssuranceEngineer_RemotePosition).pause(2500).perform();
        viewRole1.click();

        Assert.assertTrue(applicationForm.isDisplayed());
    }

}






