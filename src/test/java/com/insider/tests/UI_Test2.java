package com.insider.tests;

import com.insider.pages.UseInsiderPage;
import com.insider.utilities.BrowserUtils;
import com.insider.utilities.ConfigurationReader;
import com.insider.utilities.Driver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertTrue;

public class UI_Test2 extends UseInsiderPage {
    @BeforeMethod
    public void setupMethod() {
        Driver.getDriver().get(ConfigurationReader.getProperty("homepage"));
    }

    @Test // Test failed. There is a bug. Teams are not open all. For ex. to open QA team, user should click see all team button
    //Test Automation
    //2. Select the “Company” menu in the navigation bar, select “Careers” and check Career page,
    //   its Locations, Teams, and Life at Insider blocks are open or not

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