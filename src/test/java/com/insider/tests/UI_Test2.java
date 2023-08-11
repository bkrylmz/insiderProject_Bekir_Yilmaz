package com.insider.tests;

import com.insider.pages.UseInsiderPage;
import com.insider.utilities.BrowserUtils;
import com.insider.utilities.ConfigurationReader;
import com.insider.utilities.Driver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertTrue;

public class UI_Test2 extends UseInsiderPage {

    @BeforeMethod
    public void setupMethod() {
        Driver.getDriver().get(ConfigurationReader.getProperty("homepage"));
    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        BrowserUtils.takeScreenshot(Driver.getDriver(), result);
    }

    // Test Automation
    // 2. Select the “Company” menu in the navigation bar, select “Careers” and check Career page,
    // its Locations, Teams, and Life at Insider blocks are open or not

    // Test failed. Because There is a bug. Teams are not open all.
    // For ex. to open QA team, user should click "see all team" button after open the career page
    // At the bottom of the console, you can find the location where the screenshot is saved. "Screenshot saved to: ..."
    @Test
    public void test2() {

        mainPageCompanyButton.click();
        BrowserUtils.waitForClickablility(mainPageCareersButton, 5);
        mainPageCareersButton.click();
        BrowserUtils.waitForClickablility(onlyNecessaryCookies, 5);
        onlyNecessaryCookies.click();

        assertTrue(ourLocations.isDisplayed());
        assertTrue(seeAllTeams.isDisplayed());
        assertTrue(qualityAssuranceTeam.isDisplayed()); // there is a bug
        assertTrue(lifeAtInsider.isDisplayed());
    }

}
