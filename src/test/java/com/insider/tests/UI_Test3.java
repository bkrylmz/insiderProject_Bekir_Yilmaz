package com.insider.tests;

import com.insider.pages.UseInsiderPage;
import com.insider.utilities.BrowserUtils;
import com.insider.utilities.Driver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertTrue;

public class UI_Test3 extends UseInsiderPage {
    @BeforeMethod
    public void setupMethod() {
        Driver.getDriver().get("https://useinsider.com/careers/quality-assurance/");
    }

    @Test
    //Test Automation
    //3. Go to https://useinsider.com/careers/quality-assurance/, click “See all QA jobs”, filter jobs by Location:
    // “Istanbul, Turkey”, and Department: “Quality Assurance”, check the presence of the job list

    public void test3() {

        onlyNecessaryCookies.click();
        seeAllQaJobs.click();
        BrowserUtils.waitForClickablility(filterByLocationDropDown, 5);

        Select select1 = new Select(filterByLocationDropDown);
        select1.selectByVisibleText("Istanbul, Turkey");

        Select select2 = new Select(filterByDepartmentDropDown);
        select2.selectByVisibleText("Quality Assurance");

        BrowserUtils.scroolToElement(seniorSoftwareQualityAssuranceEngineer_RemotePosition);
        BrowserUtils.waitForVisibility(seniorSoftwareQualityAssuranceEngineer_RemotePosition, 5);

        assertTrue(seniorSoftwareQualityAssuranceEngineer_RemotePosition.isDisplayed());
        assertTrue(softwareQaTesterInsiderTestiniumTechHub_RemotePosition.isDisplayed());
        assertTrue(softwareQualityAssuranceEngineer_RemotePosition.isDisplayed());
    }

}
