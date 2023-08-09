package com.insider.tests;

import com.insider.pages.UseInsiderPage;
import com.insider.utilities.BrowserUtils;
import com.insider.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertTrue;

public class UI_Test5 extends UseInsiderPage {
    @BeforeMethod
    public void setupMethod() {
        Driver.getDriver().get("https://useinsider.com/careers/quality-assurance/");
    }

    @Test  //Test failed. There is a bug. When user click the view role, it does not redirect App Form
    //Test Automation
    //5. Click the “View Role” button and check that this action redirects us to the Lever Application form page

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

        WebElement applicationForm = Driver.getDriver().findElement(By.xpath("//input[@name='resume']")); // Test failed. There is a bug
        Assert.assertTrue(applicationForm.isDisplayed());
    }

}






